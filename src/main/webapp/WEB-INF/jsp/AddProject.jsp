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
<head>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.0.0.min.js"></script>
	<script type="text/javascript">	
		function validateAddProject() {
			var hasErrors = false;
			
			if ($("input[name='name']").val() == "") {
				$("input[name='name']").parent().find('div').fadeIn();
				hasErrors = true;
			} else
				$("input[name='name']").parent().find('div').fadeOut();
			
			if ($("input[name='testJar']").val() == "") {
				$("input[name='testJar']").parent().find('div').fadeIn();
				hasErrors = true;
			} else
				$("input[name='testJar']").parent().find('div').fadeOut();
			
			if (hasErrors)
				return false;
			return true;
		}
		
		var hash = {
		  '.jar'  : 1,
		  '.JAR' : 1,
		};

		function checkExtension(filename, submitId, inputId) {
			if(filename.value != ""){
		      var re = /\.\w{2}[\.r]$/;	      
		      var ext = filename.match(re);
		      var submitEl = document.getElementById(submitId);
		      if (hash[ext]) {
		        submitEl.disabled = false;
		        return true;
		      } else {
		        alert("Invalid filename, please select jar file");
		        submitEl.disabled = true;
		        clearFileInput(inputId);
		        return false;
		      }
			}
		}
		
		function clearFileInput(inputId) {
			
		    var oldInput = document.getElementById(inputId);
		    var newInput = document.createElement("input");
		    
		    newInput.type = "file";
		    newInput.id = oldInput.id;
		    newInput.name = oldInput.name;
		    newInput.className = oldInput.className;
		    newInput.style.cssText = oldInput.style.cssText;
		    newInput.onchange = oldInput.onchange;
		    // copy any other relevant attributes		    
		    oldInput.parentNode.replaceChild(newInput, oldInput);
		}
		
		$(document).ready(function() {
			$('#projectForm input').on('focus', function() {
				$('#projectForm input').on('keyup', function(e) {
					if (e.keyCode == 27) {
						$('#cancelBtn').click();
						$('#versionForm input').off('keyup');
					}
				});
			});
			$('input[name="name"]').focus();
			
			$('#cancelBtn').on('click', function() {
				window.location.href = "<c:url value='/app/ShowProjects' />";
			})
		});
	</script>
</head>
 
<body>	
	
	<div>
		<div class="col-md-10 text-center">
			<p class="lead">Add/Modify project</p>			
		</div>	
		<form:form commandName="projectForm" method="POST"  action="CreateProject"  cssClass="form-horizontal" enctype="multipart/form-data" id="submitForm" >
			<div class="form-group">
				<label for="projectName" class="col-sm-3 control-label">Project name</label>
				<div class="col-sm-4">
					<form:input path="name" id="projectName" cssClass="form-control" maxlength="30"/>					
					<div style="display:none; color:red;">The value is required</div>
					<form:hidden path="projectId"/>
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
		   	 			<input type="file" id="testJar" class="form-control"  name="testJar" onchange="checkExtension(this.value,'submit','testJar');"/>
		   	 			<div style="display:none; color:red;">The value is required</div>
		   	 			<p class="help-block text-center">The JAR containing the test classes</p>
		   	 		</div>			   					   			
		 	 </div>	
<!-- 		 	 <div class="form-group"> -->
<!-- 		  	    	<label for="depJar" class="col-sm-3 control-label">Dependency jar</label> -->
<!-- 		  	    	<div class="col-sm-4"> -->
<!-- 		   	 			<input type="file" id="depJar" name="depJar" class="form-control  onchange="checkExtension(this.value,'submit','depJar');"/>		   	 		 -->
<!-- 		   	 			<p class="help-block text-center">The JAR containing classes not in test src folder</p> -->
<!-- 		   	 		</div>	   				 -->
<!-- 		 	 </div>	 -->
		 	 <div class="form-group">
				<div class="col-sm-offset-1 col-sm-6 pull-right">
					<input type="button" id="cancelBtn" class="btn btn-default"  value=Back onClick="history.go(-1)" />
					<a href="/app/ShowProjects" >
						<input type="button" id="cancelBtn" class="btn btn-default"  value="Cancel"></input>
					</a>
					<input type="submit" id="submit" class="btn btn-default" onclick="return validateAddProject();" value="Save" />
		  		</div>
		  	 </div>			  	
		</form:form>
	</div>	
		<!-- 			
		http://viralpatel.net/blogs/spring-mvc-multi-row-submit-java-list/
		http://howtodoinjava.com/2013/08/30/hibernate-example-of-insertselect-blob-from-database/
		-->
</body>
</html>