<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="tilesx"
	uri="http://tiles.apache.org/tags-tiles-extras"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="/js/jquery.blockUI.js"></script>
<script type="text/javascript">
	function showMethodOfClass(id) {
		if (document.getElementById('listM').value == 'List Methods') {
			document.getElementById('listM').value = 'Hide Methods';
			document.getElementById(id).style.display = 'none';
		} else {
			document.getElementById('listM').value = 'List Methods';
			document.getElementById(id).style.display = 'inline';
		}
	}

	
	function warnOnDelete(event) {
		var answer = confirm("All data will be lost! Are you sure?")
		if (answer == true ){
			return true;
		} else 
			event.preventDefault();
			return false;
	}
	
	
	function warnOnGenerate(event) {		
		var answer = confirm("Regenerating the project will erase all previous data! Are you sure?")
		if (answer){
			return true;
		} else {
			event.preventDefault();
			return false;
		}
	}
	
	function warn(event) {
		var answer = confirm("All data for the selected element will be lost! Are you sure?")
		if (answer  == true){
			return true;
		}  else
			event.preventDefault();
			return false;
	}
	

	$(document).ready(function() { 
		$('#generate').click(function(event) {
			if (warnOnGenerate(event)) {
				$.blockUI({ css: { 
		            border: 'none', 
		            padding: '15px', 
		            backgroundColor: '#000', 
		            '-webkit-border-radius': '10px', 
		            '-moz-border-radius': '10px', 
		            opacity: .5, 
		            color: '#fff' 
		        } });
			}
		});	
	}); 
</script>
</head>
<body>
	<div class="row tabs" id="tab">
		<ul class="nav nav-tabs ">
			<li><a href="/app/ShowProjectDetails?id=${project.id}">View</a></li>
			<li class="active"><a href="/app/ManageProject?id=${project.id}">Edit</a></li>
		</ul>
	</div> 
	<div class="row " id="project">
		<display:table name="project" id="project"
			class="col-sm-12 col-md-12 col-lg-12 table-bordered text-center table-hover title"
			requestURI="ShowProjects" defaultsort="1">
			<display:column title="Project Name" property="projectName"	paramId="id" paramProperty="id" maxLength="20" />
			<display:column title="Test JAR name" property="jarName" maxLength="20" />
			<display:column title="Test JAR location" property="jarPath" paramId="projectId" paramProperty="id" maxLength="20" href="/app/download" />
			<display:column title="Description" property="description"	maxLength="50" />
<%-- 			<display:column title="Dependency JAR name"	property="dependencyJarName" maxLength="20" /> --%>
<%-- 			<display:column title="Dependency JAR location"	property="dependencyJarPath" maxLength="20" /> --%>
			<display:column title="Modified on" property="dateModification"	format="{0,date,dd.MM.yyyy HH:mm:ss}" />
			<display:column title="Created on" property="dateCreation"	format="{0,date,dd.MM.yyyy HH:mm:ss}" />
			<display:column href="/app/EditProject" paramId="id" paramProperty="id">
				<button class="btn btn-primary btn-xs active" name="projectForm">Edit</button>
			</display:column>
			<display:column href="/app/Generate" paramId="id" paramProperty="id">				
					<button class="btn btn-primary btn-xs active" id="generate" >Regenerate Project</button>				
			</display:column>
			<display:column >
				<a href="/app/DeleteProject?projectId=${project.id}" onclick="warnOnDelete(event)">
					<button class="btn btn-danger btn-xs active" id="delete"  value="Delete" title="Delete the project">Delete</button>
				</a>
			</display:column>			
			<display:column href="#" paramId="id" paramProperty="id">
				<button class="btn btn-primary btn-xs active" id="deactivate"></button>
			</display:column>
		</display:table>
	</div>
	<br></br>
	<c:forEach var="data" items="${manageProject}">
		<c:if test="${not empty data.testBeans}">
			<div class="row overtable">
				<table class="col-sm-8 col-md-8 col-lg-8 table-bordered">
					<tr>
						<td><b>Class name:</b>
							<a href="/app/ShowClassDetails?classId=${data.classId}"  class="btn btn-link btn-xs active">
								<c:out value="${data.className} " default="" />
							</a>								
							<a href="/app/ClearAllTestsExecutions?classId=${data.classId}" class="btn btn-link btn-xs active" 
							onclick="warn(event)" style="float:right" title="Delete all exectution data for this class">Clear data for this class</a>
						</td>
					</tr>
				</table>
			</div>
			<div class="row ">
				<table
					class="col-sm-8 col-md-8 col-lg-8 table-bordered text-center table-hover title">
					<thead>
						<tr>
							<th class="col-sm-4 col-md-4 col-lg-4">Test name</th>
							<th class="col-sm-1 col-md-1 col-lg-1">Number of runs</th>
							<th class="col-sm-1 col-md-1 col-lg-1">Last run date</th>
							<th class="col-sm-1 col-md-1 col-lg-1">Status</th>							
							<th class="col-sm-1 col-md-1 col-lg-1"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="test" items="${data.testBeans}">
							<tr>
								<td><c:out value="${test.name}" default="" /></td>
								<td><c:out value="${test.numberOfExections}" default="" /></td>								
								<td><fmt:formatDate value="${test.executionDate}" pattern="dd.MM.yyyy HH:mm:ss"/></td>
								<td><tags:yesno value="${test.lastRunStatus}" /></td>								
								<td>
									<a href="/app/ClearTestExecutions?methodId=${test.id}" class="btn btn-default btn-xs active" onclick="warn(event)" 
									title="Deletes all execturion data for this test">Clear data
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<br></br>
		</c:if>
	</c:forEach>
</body>
</html>