<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/css/display.css">
<head>

</head>
<body>
	<div id="menu">
		<tiles:insertAttribute name="menu" />
	</div>
	<div id="leftMenu" style="padding: 0px 50px 50px 20px" class="col-sm-2 col-md-2 sidebar-offcanvas ">
		<tiles:insertAttribute name="left" />
		</div>
		<div id="body" style="padding: 0px 50px 50px 0px" class="col-sm-10 col-md-10">
		<tiles:insertAttribute name="upper-body" />
		<tiles:insertAttribute name="body" />
	</div>
</body>

</html>
