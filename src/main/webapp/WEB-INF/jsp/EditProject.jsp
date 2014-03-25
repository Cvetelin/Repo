<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link type="text/css" rel="stylesheet" href="/css/display.css">
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.js"></script>
</head>
<body>
<div  class="table-bordered">
		<div class="col-md-10 text-center">
			<p class="lead">Add project</p>			
		</div>	
		<form:form commandName="projectForm" method="POST"  action="CreateProject"  cssClass="form-horizontal" enctype="multipart/form-data">
			<div class="form-group">
				<label for="projectName" class="col-sm-3 control-label">Project name</label>
				<div class="col-sm-4">
					<form:input path="name" id="projectName" cssClass="form-control" maxlength="50"/>
					<div style="display:none; color:red;">The value is required</div>
				</div>
			</div>		
			 <div class="form-group">
				<label for="description" class="col-sm-3 control-label">Project description</label>
				<div class="col-sm-4">
					<form:input path="description" id="description" class="form-control" maxlength="150"/> 
				</div>
			</div>				
			<div class="form-group">
		  	    	<label for="testJar" class="col-sm-3 control-label">Jar file</label>
		  	    	<div class="col-sm-4">
		   	 			<input type="file" id="testJar" class="form-control"  name="testJar" onchange="GetDiretory()"/>
		   	 			<div style="display:none; color:red;">The value is required</div>
		   	 			<p class="help-block text-center">The JAR containing the test classes</p>
		   	 		</div>			   					   			
		 	 </div>	
		 	 <div class="form-group">
		  	    	<label for="depJar" class="col-sm-3 control-label">Dependency jar</label>
		  	    	<div class="col-sm-4">
		   	 			<input type="file" id="depJar" name="depJar" class="form-control" />
		   	 			<p class="help-block text-center">The JAR containing classes not in test src folder</p>
		   	 		</div>	   				
		 	 </div>			 	 
		 	 <div class="form-group">
				<div class="col-sm-offset-1 col-sm-5 pull-right">		 		
		  			 <input type="submit" class="btn btn-default" onclick="return validateAddProject();" value="Save"></input>
		  		</div>
		  	 </div>			  	
		</form:form>
	</div>	
</body>

<script type="text/javascript">
	$(document).on('ready', function() {

		projectActions();

		// add parameter for current tab
		var tabTasks = '<form:hidden path="groupBy" value="tasks" />';
		var tabEvents = '<form:hidden path="groupBy" value="events" />';
		var tabReports = '<form:hidden path="groupBy" value="reports" />';
		var groupBy = $('.tabmenu').find('.active').text();
		if (groupBy == "Tasks")
			$("#modifyProjectTable").append(tabTasks);
		else if (groupBy == "Events")
			$("#modifyProjectTable").append(tabEvents);
		else
			$("#modifyProjectTable").append(tabReports);
	});
	function projectActions() {
		$('#editProjectBtn').on(
				'click',
				function() {
					$('#modifyProjectTable').css('display', 'none');
					// add default values of the project into their inputs values
					$("#modifyProjectTable input[name='name']").val(
							"${project.name}");
					$("#modifyProjectTable input[name='code']").val(
							"${project.code}");
					$("#modifyProjectTable input[name='issueId']").val(
							"${project.issue.id}");
					$("#modifyProjectTable select[name='manager']").val(
							"${project.manager.userName}");
					$("#modifyProjectTable input[name='analyst']").val(
							"${project.analyst}");
					$("#modifyProjectTable input[name='position']").val(
							"${reporting.position}");
					$('#modifyProjectTable').fadeIn('fast');

					$('#editProjectBtn').fadeOut('fast');
					$('#showProjectTable').css("display", "none");
					$('#modifyProjectTable').fadeIn('fast');

					$('#modifyProjectTable input').on('focus', function() {
						$('#modifyProjectTable input').on('keyup', function(e) {
							if (e.keyCode == 27) {
								$('#cancelModifyProjectBtn').trigger('click');
								$('#modifyProjectTable input').off('keyup');
							}
						});
					});

					$("#modifyProjectTable input[name='name']").focus();
				});

		$('#cancelModifyProjectBtn').on('click', function() {
			$('#modifyProjectTable').css("display", "none");
			$('#editProjectBtn').fadeIn('fast');
			$('#showProjectTable').fadeIn('fast');
		});

		// Check for errors. If has, show dynamic - table for modify project
		if ($('.hasProjectTableErrors').text() != "")
			$('#editProjectBtn').trigger('click');
	}

	function validateModifyProject() {
		var hasErrors = false;

		if ($("#modifyProjectTable input[name='name']").val() == "") {
			$("#modifyProjectTable input[name='name']").parent().find('div')
					.fadeIn();
			hasErrors = true;
		} else
			$("#modifyProjectTable input[name='name']").parent().find('div')
					.fadeOut();

		if ($("#modifyProjectTable input[name='code']").val() == "") {
			$("#modifyProjectTable input[name='code']").parent().find('div')
					.fadeIn();
			hasErrors = true;
		} else
			$("#modifyProjectTable input[name='code']").parent().find('div')
					.fadeOut();

		if ($("#modifyProjectTable input[name='issueId']").val() == "") {
			$("#modifyProjectTable input[name='issueId']").parent().find('div')
					.fadeIn();
			hasErrors = true;
		} else
			$("#modifyProjectTable input[name='issueId']").parent().find('div')
					.fadeOut();

		var issue = $("#modifyProjectTable input[name='issueId']").val();
		if (issue != "") {
			if ((Math.floor(issue) != issue || !$.isNumeric(issue))) {
				$("#modifyProjectTable input[name='issueId']").parent().find(
						'div').fadeIn();
				hasErrors = true;
			} else {
				$("#modifyProjectTable input[name='issueId']").parent().find(
						'div').fadeOut();
			}
		} else {
			$("#modifyProjectTable input[name='issueId']").parent().find('div')
					.fadeOut();
		}

		var position = $("#modifyProjectTable input[name='position']").val();
		if (position != "") {
			if ((Math.floor(position) != position || !$.isNumeric(position))) {
				$("#modifyProjectTable input[name='position']").parent().find(
						'div').fadeIn();
				hasErrors = true;
			} else {
				$("#modifyProjectTable input[name='position']").parent().find(
						'div').fadeOut();
			}
		} else {
			$("#modifyProjectTable input[name='position']").parent()
					.find('div').fadeOut();
		}

		if (hasErrors)
			return false;
		return true;
	}
</script>
</html>