<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
	<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/css/display.css">
<head>
</head>
<body>
	<div class="navbar navbar-static-top custom"> 
			<div class="container">
				<a href="/index" class="navbar-brand brand">Selenium
					Gallery</a>
				<div class="collapse navbar-collapse ">
					<ul class="nav navbar-nav navbar-center">
						<li><a href="/ShowProjects">Projects</a></li>
<!-- 						<li><a href="/index">Run</a></li> -->
						<li><a href="/AddProject">Add project</a></li>
						<li><a href="/AddUser">Add user</a></li>
					</ul>
				</div>
			</div>
		</div>
</body>
</html>