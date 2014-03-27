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
<script type="text/javascript">
	function submitForm() {
		$('form[name="project"]').submit();
	}
</script>
</head>
<body>
	<div class="container text-center row ">
		<display:table name="projects" id="projects" class="col-md-12 table-bordered title text-center table-striped table-hover"  
		requestURI="ShowProjects" defaultsort="1" >
			<display:column title="Project Name" property="projectName" href="/app/ShowTestClasses" paramId="id"
				paramProperty="id" sortable="true" maxLength="30"/>
			<display:column  title="Test JAR name" property ="jarName" sortable="true" maxLength="30"/>			
			<display:column  title="Dependency JAR name" property ="dependencyJarName" sortable="true" maxLength="30"/>
			<display:column  title="Description" property ="description" sortable="true" maxLength="30"/>
			<display:column  title="Modified on" property ="dateModification"  format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"/>
			<display:column  title="Created on" property ="dateCreation"  format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"/>
			<display:column href="/app/EditProject" paramId="id" paramProperty="id">
					<button  class="btn btn-primary btn-xs" name="projectForm">Edit</button>		
			</display:column>
		</display:table> 
		
	</div>
</body>
</html>