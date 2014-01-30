<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>SELENIUM TEST</title>
</head>

<body class="box">
	<table border="1">
		<thead>
			<tr align="center" bgcolor="00CC66">
				<th colspan="2">SELENIUM TESTS</th>
			</tr>
		</thead>
		<tbody class="title">
			<display:table name="dirInfo" id="dir">
				<display:column title="Test name" property="name" href="/app/ShowTestExecutionTime" paramId="path" paramProperty="path">
				</display:column>
				<display:column title="Last execution Time" property="executionDate" format="{0,date,dd.MM.yyyy HH:mm:ss}"></display:column>
			</display:table>
		</tbody>
</body>
</html>

<%-- <c:forEach items="${dirInfo}" var="dir"> --%>
<!-- 						<tr> -->
<%-- 							<td>${dir.name}</td> --%>
<%-- 				            <td>${dir.executionTime}</td> --%>
<%-- 				            <td>${dir.path}</td> --%>
<!-- 						</tr> -->
<%-- 						</c:forEach> --%>