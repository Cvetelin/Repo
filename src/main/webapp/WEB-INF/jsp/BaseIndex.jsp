<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.js' />"></script>
<link type="text/css" rel="stylesheet" href="/css/display.css">
</head>
<body>
	<div id="menu">
		<tiles:insertAttribute name="menu" />
	</div>
	<div id="body" style="padding: 0px 50px 50px 0px" class="col-sm-12 col-md-12">
		<tiles:insertAttribute name="body" />
	</div>
</body>

</html>