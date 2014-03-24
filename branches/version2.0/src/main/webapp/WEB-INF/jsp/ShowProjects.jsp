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
</head>
<body>
	<div class="container center-block text-center row ">
		<display:table name="projects" id="projects" class="col-md-8 table-bordered title text-center"  requestURI="ShowProjects" defaultsort="1">
			<display:column title="Project Name" property="projectName" href="/app/RunClass" paramId="name"
				paramProperty="projectName" sortable="true"/>
			<display:column  title="Date creation" property ="dateCreation"  format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"/>
			<display:column  title="Test JAR name" property ="jarName" sortable="true"/>
			<display:column  title="Dependency JAR name" property ="dependencyJarName" sortable="true"/>
		</display:table> 
	</div>
</body>
</html>