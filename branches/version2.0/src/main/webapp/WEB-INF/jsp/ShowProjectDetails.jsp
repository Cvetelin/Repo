<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/css/display.css">
<head>
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
		<display:table name="classInfo" id="dir" class="col-md-7 text-center table-bordered table-hover title headtitle-link"
			requestURI="ShowProjects" defaultsort="1">
			<display:column title="Class name" property="name" paramId="id" paramProperty="id" sortable="true">
			</display:column>
			<display:column title="Folder Location" property="path" paramId="path" paramProperty="path" sortable="true">
			</display:column>
			<display:column title="Status" property="success" paramId="status" paramProperty="success" sortable="true">
			</display:column>
			<display:column title="Methods" paramId="method" paramProperty="classInfo.id" class="col-md-2">
				<button class="btn btn-primary btn-xs" name="projectForm">List Methods</button>
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
	<div class="row" id="methods">
		<c:forEach items="testInfo">
			<display:table name="testInfo" id="dir" class="col-md-2 table-bordered table-hover title headtitle-link"
				requestURI="ShowExecutedTests" defaultsort="1">
				<display:column title="Class name" property="classInfo.name" paramId="id" paramProperty="id" sortable="true">
				</display:column>
				<display:column title="Test name" property="name" paramId="id" paramProperty="id" sortable="true">
				</display:column>
			</display:table>
		</c:forEach>
	</div>
	</div>

</body>
</html>