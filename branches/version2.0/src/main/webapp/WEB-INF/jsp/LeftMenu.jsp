<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras"%>
<html>
<link type="text/css" rel="stylesheet" href="/css/display.css">
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<head>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.0.0.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="left">
		<ul class="nav nav-pills nav-stacked">
			<li><display:table name="projects" id="projects"
					class="table-bordered text-center table-hover title headtitle-link" requestURI="ShowProjectDetails" defaultsort="1">
					<display:column title="Projects" property="projectName" href="/app/ShowProjectDetails" paramId="id"
						paramProperty="id" sortable="true" maxLength="35" />
				</display:table></li>
			<li><a href="#"> <c:forEach var="name" items="${projects.projectName}">
						<c:out value="${name}"></c:out>
					</c:forEach>
			</a></li>
			<li><a href="#">Messages</a></li>
		</ul>
	</div>
</body>
</html>