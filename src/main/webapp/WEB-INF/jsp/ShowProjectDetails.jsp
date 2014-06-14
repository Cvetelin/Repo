<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="/js/jquery.blockUI.js"></script>
<script type="text/javascript">

$(document).ready(function() { 
    $('[value~=RunTests]').click(function() { 
        $.blockUI({ css: { 
            border: 'none', 
            padding: '15px', 
            backgroundColor: '#000', 
            '-webkit-border-radius': '10px', 
            '-moz-border-radius': '10px', 
            opacity: .5, 
            color: '#fff' 
        } }); 
    }); 
}); 


</script>
</head>
<body>
	<div class="row tabs" id="tab">
		<ul class="nav nav-tabs ">
			<li class="active"><a href="/ShowProjectDetails?id=${project.id}">View</a></li>
			<li><a href="/ManageProject?id=${project.id}">Edit</a></li>
		</ul>
	</div>
	<div class="row" id="projectDetails">
		<display:table name="project" id="project"
			class="col-sm-12 col-md-12 col-lg-12 table-bordered text-center table-hover title" requestURI="ShowProjects"
			defaultsort="1">
			<display:column title="Project Name" property="projectName" paramId="id" paramProperty="id" maxLength="20" />
			<display:column title="Test JAR name" property="jarName" maxLength="20" />
			<display:column title="Test JAR location" property="jarPath" maxLength="20" href="/download" />
			<display:column title="Description" property="description" maxLength="50" />
			<display:column title="Dependency JAR name" property="dependencyJarName" maxLength="20" />
			<display:column title="Dependency JAR location" property="dependencyJarPath" maxLength="20" />
			<display:column title="Modified on" property="dateModification" format="{0,date,dd.MM.yyyy HH:mm:ss}" />
			<display:column title="Created on" property="dateCreation" format="{0,date,dd.MM.yyyy HH:mm:ss}" />
		</display:table>
	</div>
	<br></br>
	<div class="row" id="classes">
		<display:table name="classInfos" id="class"
			class="col-sm-12 col-md-12 col-lg-12 text-center table-bordered table-hover title headtitle-link"
			requestURI="ShowProjectDetails" defaultsort="1">
			<display:column title="Class name" property="name" paramId="id" paramProperty="id" sortable="true">
			</display:column>
			<display:column title="Last run on" property="executionDate" format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true">
			</display:column>
			<display:column title="#Tests" sortable="true" property="numberOfTests">
			</display:column>
			<display:column title="#Failed" sortable="true" property="numberOfFailedTests">
			</display:column>
			<display:column title="Status" sortable="true">
				<tags:yesno value="${class.success}" />
			</display:column>
			<display:column title="Qualified name" property="qualifiedName">
			</display:column>
			<display:column title="Folder Location" property="path" paramId="path" paramProperty="path" sortable="true">
			</display:column>
			<display:column paramId="classId" paramProperty="id" href="/ShowClassDetails">
				<c:if test="${not empty class.testInfo}">
					<button class="btn btn-info btn-xs active" id="listM" value="List Methods">List Methods</button>
				</c:if>
			</display:column>
			<display:column>
				<c:choose>
					<c:when test="${not empty class.testInfo}">
						<a href="/runMethods?classId=${class.id}">
							<button class="btn btn-primary btn-xs active" id="runTests" name="projectForm" value="RunTests">Run Tests</button>
						</a>
					</c:when>
					<c:otherwise>
						<font color="red"> <c:out value="No methods found" />
						</font>
					</c:otherwise>
				</c:choose>
			</display:column>
		</display:table>
	</div>
	<br></br>
</body>
</html>