<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page pageEncoding="UTF-8"%>

<html>
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.js"></script>
<script type="text/javascript">
	function submitForm(method) {
		 $('#deleteSelected').get(0).setAttribute('action', method);
		 $('#deleteSelected').submit();
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

<link type="text/css" rel="stylesheet" href="/css/display.css">
</head>
<body class="box">
	<table>
		<thead>
			<tr align="center" bgcolor="00CC66">
				<th colspan="2">SELENIUM TESTS</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>				
				<form:form action="select" commandName="dirInfos" id="deleteSelected">
					<a href="#" onclick="submitForm('deleteSelected')">Delete selected</a>				
					<div align="right">				
						<display:table name="dirInfos" id="dirInfo" class="title" sort="external" defaultsort="1">
							<display:column property="executionDate"
								title="Test execution time"	format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"
								sortName="executionDate" />
							<display:column value="Go to Gallery" href="/app/PrepareGallery"
								paramProperty="path" paramId="filesRoot" />
							<display:column value="Delete" href="/app/DeleteTestExecutionTime" paramProperty="path"
								paramId="fileRoot" />
							<display:column	title="<input type='checkbox' name='selectall' id='selectall'/>">
															<input type="checkbox" class="case" name="dirInfo[0].delete"/> 
							</display:column>
						</display:table>
					</div>
					</form:form>
				</td>
			</tr>
		</tbody>
	</table>
</body>
<a href="/app/ShowExecutedTests">Back to Tests list</a>
</html>

