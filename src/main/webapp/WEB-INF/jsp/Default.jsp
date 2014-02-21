<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<head>
</head>
<body>
	<div class="main">
		<tiles:insertAttribute name="menu" />
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<tiles:insertAttribute name="left" />
			</div>
			<div class="span10">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
</body>
</body>
</html>