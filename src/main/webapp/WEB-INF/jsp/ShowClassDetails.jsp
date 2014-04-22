<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
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
</head>
<body>
	<%@ include file="include/UpperBody.jspf"%>
	<div class="row" id="methods">
		<display:table name="testInfos" id="test" class="col-md-6 table-bordered table-hover title text-center headtitle-link"
			requestURI="ShowClassDetails" defaultsort="1">
			<display:column title="Class name" property="classInfo.name" paramId="id" paramProperty="id" sortable="true">
			</display:column>
			<display:column title="Methods in Class" property="name" paramId="id" paramProperty="id" sortable="true">
			</display:column>
			<display:column title="Last run on" property="executionDate" format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"> 
<%-- 				<c:forEach var="cl" items="${test.execInfo}"> --%>
<%-- 					<c:out value="${cl.executionDate}"></c:out> --%>
<%-- 				</c:forEach> --%>
			</display:column>			
		</display:table>
	</div>
	<br></br>
	<div class="row" id="executions">
		<display:table name="execInfos" id="exec" class="col-md-12 table-bordered table-hover title text-center headtitle-link"
			requestURI="ShowClassDetails" defaultsort="1">
			<display:column title="Test method name" property="testInfo.name" paramId="id" paramProperty="id" sortable="true">
			</display:column>
			<display:column title="Status" sortable="true">
				<tags:yesno value="${exec.status}"/>
			</display:column>
			<display:column title="Run Date" property="executionDate" format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true">
			</display:column>	
			<display:column title="Failure reason" property="failureReason" maxLength="150">
			</display:column>		
		</display:table>
	</div>

</body>
</html>