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
<title>SELENIUM TEST</title>
</head>

<body>

	<!-- 		<div class="col-md-8 text-center table-bordered" >SELENIUM TESTS</div> -->
	<!-- 		<div class="container" >  -->
	<div class="container center-block text-center">
	
		<display:table name="testInfo" id="dir" class="col-md-8  table-bordered title col-md-offset-1"  requestURI="ShowExecutedTests" defaultsort="1">	
			<display:column title="Test name" property="name" href="/app/ShowTestExecutionTime" paramId="path"
				paramProperty="path" class="col-md-4 table-bordered" sortable="true">
			</display:column>
			<display:column title="Last execution Time" property="executionDate" format="{0,date,dd.MM.yyyy HH:mm:ss}"
				class="col-md-4 table-bordered text-center" sortable="true" ></display:column>
				</display:table>


	</div>
</body>
</html>