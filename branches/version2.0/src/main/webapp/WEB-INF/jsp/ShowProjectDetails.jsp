<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript">
function showMethodOfClass(id) {
	if(document.getElementById('listM').value=='List Methods'){
	document.getElementById('listM').value = 'Hide Methods';
	document.getElementById(id).style.display = 'none';
	}else{
	document.getElementById('listM').value = 'List Methods';
	document.getElementById(id).style.display = 'inline';
	}
}
</script>
</head>
<body>
	<div class="row" id="projectDetails">
		<display:table name="project" id="project"
			class="col-sm-12 col-md-12 col-lg-12 table-bordered text-center table-hover title" requestURI="ShowProjects"
			defaultsort="1">
			<display:column title="Project Name" property="projectName" paramId="id" paramProperty="id" maxLength="20" />
			<display:column title="Test JAR name" property="jarName" maxLength="20" />
			<display:column title="Description" property="description" maxLength="50" />
			<display:column title="Dependency JAR name" property="dependencyJarName" maxLength="20" />
			<display:column title="Modified on" property="dateModification" format="{0,date,dd.MM.yyyy HH:mm:ss}" />
			<display:column title="Created on" property="dateCreation" format="{0,date,dd.MM.yyyy HH:mm:ss}" />
			<display:column href="/app/EditProject" paramId="id" paramProperty="id">
				<button class="btn btn-primary btn-xs" name="projectForm">Edit</button>
			</display:column>
			<display:column href="/app/GenerateTree" paramId="id" paramProperty="id">
				<button class="btn btn-primary btn-xs">Generate Project Tree</button>
			</display:column>
		</display:table>
	</div>
	<br></br>
	<div class="row" id="classes">
		<display:table name="classInfos" id="dir" class="col-sm-12 col-md-12 col-lg-12 text-center table-bordered table-hover title headtitle-link"
			requestURI="ShowProjectDetails" defaultsort="1">
			<display:column title="Class name" property="name" paramId="id" paramProperty="id" sortable="true">
			</display:column>
			<display:column title="Last Execution Date" property="executionDate" sortable="true">
			</display:column>
			<display:column title="#Successful" sortable="true">
			</display:column>
			<display:column title="#Failed" sortable="true">
			</display:column>
			<display:column title="Status" property="success" paramId="status" paramProperty="success" sortable="true">
			</display:column>
			<display:column title="Qualified name" property="qualifiedName" >
			</display:column>
			<display:column title="Folder Location" property="path" paramId="path" paramProperty="path" sortable="true">
			</display:column>
			<display:column title="Methods" paramId="classId" paramProperty="id" href="/app/ShowClassDetails">
				<button class="btn btn-primary btn-xs" id="listM" value="List Methods" onclick="showMethodOfClass('methods')">List Methods</button>
			</display:column>
			<%-- 			<display:column title="Methods name"> --%>
			<%-- 				<c:forEach var="cl" items="${dir.testInfo}"> --%>
			<%-- 					<c:out value="${cl.name}"></c:out> --%>
			<%-- 				</c:forEach> --%>
			<%-- 			</display:column> --%>

			<display:column href="/app/RunClass" paramId="id" paramProperty="id">
				<button class="btn btn-primary btn-xs" name="projectForm">Execute Test Class</button>
			</display:column>
		</display:table>
	</div>
	<br></br>
</body>
</html>