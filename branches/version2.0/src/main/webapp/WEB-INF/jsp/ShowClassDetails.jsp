<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<%@ include file="include/UpperBody.jspf"%>
	<div class="row" id="methods">
		<display:table name="testInfos" id="test" class="col-md-2 table-bordered table-hover title headtitle-link"
			requestURI="ShowClassDetails" defaultsort="1">
			<display:column title="Class name" property="classInfo.name" paramId="id" paramProperty="id" sortable="true">
			</display:column>
			<display:column title="Methods in Class name" property="name" paramId="id" paramProperty="id" sortable="true">
			</display:column>
			<display:column title="Executions">
				<c:forEach var="cl" items="${test.execInfo}">
					<c:out value="${cl.status}"></c:out>
				</c:forEach>
			</display:column>
		</display:table>
	</div>
	<br></br>

</body>
</html>