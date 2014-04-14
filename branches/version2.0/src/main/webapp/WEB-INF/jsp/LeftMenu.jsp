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
<head>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.0.0.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="left" class="sidebar-custom">
		<div class="table-bordered text-center custom lead" style="font-size: 14px; color: #FFFFFF">Projects</div>
		<ul class="nav nav-pills nav-stacked">
<%-- 			<display:table name="projectsList" id="projects" --%>
<%-- 					class="table-bordered text-center table-hover title headtitle-link" requestURI="ShowProjectDetails" defaultsort="1"> --%>
<%-- 					<display:column title="Projects" property="projectName" href="/app/ShowProjectDetails" paramId="id" --%>
<%-- 						paramProperty="id" sortable="true" maxLength="35" class="col-md-2 " /> --%>
<%-- 				</display:table> --%>
			<c:forEach var="name" items="${projectsList}">
				<li><a href="/app/ShowProjectDetails?id=${name.id}" class="table-bordered text-center table-hover">
						<c:out value="${name.projectName}"></c:out>
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>