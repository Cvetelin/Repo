<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<link type="text/css" rel="stylesheet" href="/css/display.css">
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">

<head>
</head>
<body>
	<div id="menu">
		<tiles:insertAttribute name="menu" />
	</div>
	<div id="body" style="padding: 0px 50px 50px 50px">
		<tiles:insertAttribute name="left" />
		<tiles:insertAttribute name="body" />
	</div>

</body>
</body>
</html>