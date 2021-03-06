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
<html>
<link type="text/css" rel="stylesheet" href="/css/display.css">
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.0.0.min.js"></script>
<script type="text/javascript">
	function submitForm(method) {
		var answer = confirm("Are you sure want to delete the selected tests?")
		if (answer){
			$('#dirInfoForm').get(0).setAttribute('action', method);
			$('#dirInfoForm').submit();
		}
	}
		
	$(function() {
		// add multiple select / deselect functionality
		$("#selectall").click(function() {
			$('.case').attr('checked', this.checked);
		});

		// if all checkbox are selected, check the selectall checkbox
		// and viceversa
		$(".case").click(function() {
			if ($(".case").length == $(".case:checked").length) {
				$("#selectall").attr("checked", "checked");
			} else {
				$("#selectall").removeAttr("checked");
			}
		});
	});	
</script>
<head>
</head>
<body>
	<form:form action="dirInfoForm" commandName="dirInfoForm" id="dirInfoForm" method="POST" name="deleteform">
		<div class="container center-block text-center">
			<div class="col-md-8 table-bordered title col-md-offset-1 bg-primary headtitle-link">
				<b>Runs of test:
					<a href="/ShowExecutedTests?path=${classInfo.path}"> ${exectutionInfo[0].parentName}</a>
				of class ${classInfo.name}
				</b>			
			</div>	
			<display:table name="exectutionInfo" id="exectutionInfo"  requestURI="ShowTestExecutionTime" class="col-md-8  table-bordered title col-md-offset-1">
				<display:column property="executionDate" title="Test run time" format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"
					class="col-md-4 table-bordered text-center" />
				<display:column value="Go to Gallery" href="/PrepareGallery" paramProperty="path" paramId="filesRoot"
					class="col-md-2 table-bordered text-center" />
				<display:column value="Delete" href="/DeleteTestExecutionTime" paramProperty="path" paramId="fileRoot"
					class="col-md-1 table-bordered text-center" />
				<display:column class="col-xs-1 text-center" title="<input type='checkbox' name='selectall' id='selectall' />">
					<form:checkbox cssClass="case" path="delete" value="${exectutionInfo.path}" />
				</display:column>				
			</display:table>
		
		</div>
		
		<div class="container center-block text-right col-md-8">		
				<a href="#" onclick="submitForm('dirInfoForm')" class="text-left">Delete selected</a>
		</div>
	</form:form>
</body>
<a href="/ShowExecutedTests">Back to Tests list</a>
</html>

