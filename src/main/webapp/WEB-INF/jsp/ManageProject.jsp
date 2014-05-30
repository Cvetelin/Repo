<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
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
</script>
</head>
<body>
	<div class="row tabs" id="tab">
		<ul class="nav nav-tabs ">
			<li><a href="/app/ShowProjectDetails?id=${project.id}">View</a></li>
			<li class="active"><a href="/app/ManageProject?id=${project.id}">Edit</a></li>
		</ul>
	</div>
	<div class="row" id="project">
		<display:table name="project" id="project"
			class="col-sm-12 col-md-12 col-lg-12 table-bordered text-center table-hover title"
			requestURI="ShowProjects" defaultsort="1">
			<display:column title="Project Name" property="projectName"
				paramId="id" paramProperty="id" maxLength="20" />
			<display:column title="Test JAR name" property="jarName"
				maxLength="20" />
			<display:column title="Test JAR location" property="jarPath"
				maxLength="20" href="/app/download" />
			<display:column title="Description" property="description"
				maxLength="50" />
			<display:column title="Dependency JAR name"
				property="dependencyJarName" maxLength="20" />
			<display:column title="Dependency JAR location"
				property="dependencyJarPath" maxLength="20" />
			<display:column title="Modified on" property="dateModification"
				format="{0,date,dd.MM.yyyy HH:mm:ss}" />
			<display:column title="Created on" property="dateCreation"
				format="{0,date,dd.MM.yyyy HH:mm:ss}" />
			<display:column href="/app/EditProject" paramId="id"
				paramProperty="id">
				<button class="btn btn-primary btn-xs" name="projectForm">Edit</button>
			</display:column>
			<display:column href="/app/GenerateTree" paramId="id"
				paramProperty="id">
				<button class="btn btn-primary btn-xs" id="generate">Generate
					Project Tree</button>
			</display:column>
			<display:column href="#" paramId="id" paramProperty="id">
				<button class="btn btn-primary btn-xs" id="delete">Delete</button>
			</display:column>
			<display:column href="#" paramId="id" paramProperty="id">
				<button class="btn btn-primary btn-xs" id="delete"></button>
			</display:column>
		</display:table>
	</div>
	<br></br>
	<div class="row" id="class">
		<display:table name="classInfos" id="class"
			class="col-sm-12 col-md-12 col-lg-12 text-center table-bordered table-hover title headtitle-link"
			requestURI="ShowProjectDetails" defaultsort="1">
			<display:column title="Class name" property="name" paramId="id"
				paramProperty="id" />
			<display:column title="Latest result"
				class="col-sm2 col-md-1 col-lg-1">
				<tags:yesno value="${class.success}" />
			</display:column>
			<display:column title="Last run on" property="executionDate"
				format="{0,date,dd.MM.yyyy HH:mm:ss}" />
			<display:column title="#Tests" property="numberOfTests" />
			<display:column title="Qualified name" property="qualifiedName" />
		</display:table>
	</div>
	<br></br>
	<div class="row" id="info">
		<table
			class="table table-bordered col-sm-12 col-md-12 col-lg-12 table-title table-body">
			<thead>
				<tr>
					<th class="col-sm-1 col-md-1">Class name</th>
					<th>Tests</th>
					<th>Executions</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="class" items="${classInfos}">
					<c:forEach var="test" items="${class.testInfo}">
						<c:forEach var="exec" items="${test.execInfo}">
					<tr>
						<td rowspan="${fn:length(class.testInfo)}"><c:out value="${class.name}"></c:out></td>
						<td>
							<table class="table table-bordered table-body">
							<tbody>
								<c:forEach var="test" items="${class.testInfo}">
									<tr>
										<td><c:out value="${test.name}"></c:out></td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</td>
						<td>
							<table class="table table-bordered table-body">
							<tbody>
								<c:forEach var="test" items="${class.testInfo}">
									<c:forEach var="exec" items="${test.execInfo}">
										<tr>
											<td><c:out value="${exec.executionDate}"></c:out></td>
										</tr>
									</c:forEach>
								</c:forEach>
								</tbody>
							</table>
						</td>
					</tr>
					</c:forEach>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br></br>
	<div class="row" id="executions"></div>


</body>
</html>