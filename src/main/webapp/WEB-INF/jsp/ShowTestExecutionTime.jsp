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
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.js"></script>
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
	<form:form action="dirInfoForm" commandName="dirInfoForm"
		id="dirInfoForm" method="POST">
		<div class="container center-block text-center">
			<a href="#" onclick="submitForm('dirInfoForm')">Delete selected</a>
		</div>
		<div class="container center-block text-center">
			<display:table name="dirInfos" id="dirInfo" sort="external"
				defaultsort="1" class="col-md-8  table-bordered title">
				<display:column property="executionDate" title="Test execution time"
					format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"
					sortName="executionDate" class="col-md-4 table-bordered text-center" />
				<display:column value="Go to Gallery" href="/app/PrepareGallery"
					paramProperty="path" paramId="filesRoot"
					class="col-md-2 table-bordered text-center" />
				<display:column value="Delete" href="/app/DeleteTestExecutionTime"
					paramProperty="path" paramId="fileRoot"
					class="col-md-2 table-bordered text-center" />
				<display:column class="col-md-2 text-center"
					title="<input type='checkbox' name='selectall' id='selectall' />">
					<form:checkbox cssClass="case" path="delete"
						value="${dirInfo.path}" />
				</display:column>
			</display:table>
		</div>
	</form:form>
</body>
<a href="/app/ShowExecutedTests">Back to Tests list</a>
</html>

