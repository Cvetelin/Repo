<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Selenium Galery</title>
</head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<body>

	<div class="main">
		<tiles:insertAttribute name="menu" />
		</div>
		<div class="rightPane">
			<tiles:insertAttribute name="body" />		
	</div>

</body>
</body>
</html>