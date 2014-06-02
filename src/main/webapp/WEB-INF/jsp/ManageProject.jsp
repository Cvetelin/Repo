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
	<div class="row " id="project">
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
	<!-- 	<div class="row table-bordered img-rounded" id="details" -->
	<!-- 		style="padding: 20px 0px 20px 20px"> -->
	<!-- 		<div class="row col-sm-2 col-md-2 text-left sidebar-custom" -->
	<!-- 			style="padding: 20px 0px 0px 20px" id="info"> -->
	<!-- 			<ul class="nav nav-pills nav-stacked"> -->
	<!-- 				<li class="active"><a href="#" -->
	<!-- 					class="table-bordered text-center table-hover">Home</a></li> -->
	<!-- 				<li><a href="#" class="table-bordered text-center table-hover">Profile</a></li> -->
	<!-- 				<li><a href="#" class="table-bordered text-center table-hover">Messages</a></li> -->
	<!-- 			</ul> -->
	<!-- 		</div> -->
	<!-- 		<div class=" col-sm-10 col-md-10" style="padding: 0px 0px 0px 20px" -->
	<!-- 			id="info"> -->
	<!-- 			<table -->
	<!-- 				class="table table-bordered col-sm-10 col-md-10 col-lg-10 table-title table-body"> -->
	<!-- 				<thead> -->
	<!-- 					<tr> -->
	<!-- 						<th class="col-sm-1 col-md-1">Class name</th> -->
	<!-- 						<th>Tests</th> -->
	<!-- 						<th>Executions</th> -->
	<!-- 					</tr> -->
	<!-- 				</thead> -->
	<!-- 				<tbody> -->
	<!-- 					<tr> -->
	<!-- 						<td>asdas</td> -->
	<!-- 					</tr> -->

	<!-- 				</tbody> -->
	<!-- 			</table> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
	<br></br>
	<c:forEach var="class" items="${classInfos}">
		<div class="row">
		<table class="col-sm-12 col-md-12 col-lg-12 table-bordered title">
			<thead>
			<tr>
				<th>
					Class name: <c:out value="${class.name}"></c:out>
				</th>
			</tr>
			</thead>
		</table>			
		</div>
		<c:forEach var="test" items="${class.testInfo}" >
			<div class="row ">
			<table class="col-sm-12 col-md-12 col-lg-12 table-bordered text-center table-hover">
				<tr>
					<td class="col-sm-2 col-md-2 col-lg-2">
					  <c:out value="${test.name}"></c:out>
					</td>
					<td class="col-sm-2 col-md-2 col-lg-2">
					<c:forEach var="exec" items="${test.execInfo}">					
						<div class="row">
							<c:out value="${exec.executionDate}" default=""></c:out>
							<input type="checkbox"/>
						</div>					
					</c:forEach>
					<td>
				</tr>
			</table>
				
				
			</div>			
		</c:forEach>
		<br></br>
	</c:forEach>

</body>
</html>