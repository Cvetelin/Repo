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
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<html>
<head>
</head>
<c:set var="username">
	<shiro:principal />
</c:set>
<body>
	<div class="navbar navbar-static-top custom"> 
			<div class="container custom-drop">
				<a href="/index" class="navbar-brand brand">Selenium Gallery</a>				
					<ul class="nav navbar-nav">
						<li><a href="/ShowProjects">Projects</a></li>
<!-- 						<li><a href="/index">Run</a></li> -->
					</ul>
					<ul class="nav navbar-nav">
				    	<li class="dropdown">
				       	 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin<b class="caret"></b></a>
				         <ul class="dropdown-menu">
				        	<li><a href="/AddProject">Add project</a></li>
							<li><a href="/AddUser">Add user</a></li>
				         </ul>
		      			</li>
		   		   </ul>
					<ul class="nav navbar-nav navbar-right">
				    	<li class="dropdown">
				       	 <a href="#" class="dropdown-toggle" data-toggle="dropdown">User: ${username}<b class="caret"></b></a>
				         <ul class="dropdown-menu">
				        	<li><a href="/logout">Logout</a></li>
				         </ul>
		      			</li>
		   		   </ul>				
			</div>
		</div>
</body>
</html>