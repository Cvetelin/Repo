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
	<div class="container-fluid text-center center-block">
		<display:table name="project" id="project"
			class="col-sm-12 col-md-12 col-lg-12 table-bordered text-center table-hover title"
			requestURI="ShowProjects" defaultsort="1">
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
	<div class="container text-center center-block">
		<display:table name="dirInfo" id="dir" class="col-md-4  table-bordered table-hover title headtitle-link"
			requestURI="ShowExecutedTests" defaultsort="1">
			<display:column title="Test classes" property="name" href="/app/RunClass" paramId="id" paramProperty="id"
				class="col-md-4 table-bordered" sortable="true">
			</display:column>
		</display:table>
	</div>
</body>
</html>