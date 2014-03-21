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
<title>BUGSHOT</title>
</head>
 
<body>		
	<div class="container center-block text-center row ">
		<div class="row col-md-10 table-bordered title text-center ">Add project</div>
		<div class="row col-md-10 table-bordered title text-center">
			
			<form:form method="POST" modelAttribute="project" cssClass="container form-inline center-block text-left col-md-8">
				<div class="form-group ">
		  	    	<label for="exampleInputFile">File input</label>
		   	 		<input type="file" id="exampleInputFile">
		   			<p class="help-block">Select jar file to load</p>
		 		 </div>
		 		 <div class="btn-group btn-group-sm">
		  			 <button type="submit" class="btn btn-default">Submit</button>
		  		 </div>
			</form:form>
	
	</div>	
		<!-- 	<display:table name="dirInfo" id="dir" class="col-md-4  table-bordered title"  requestURI="ShowExecutedTests" defaultsort="1">
			<display:column title="Executest test classes" property="name" href="/app/RunClass" paramId="qualifiedName"
				paramProperty="qualifiedName" class="col-md-4 table-bordered" sortable="true">
			</display:column>
		</display:table> 
		
		http://viralpatel.net/blogs/spring-mvc-multi-row-submit-java-list/
		http://howtodoinjava.com/2013/08/30/hibernate-example-of-insertselect-blob-from-database/
		-->
		
	</div>
		<a href="/app/GetTestClasses">GetTesClasses</a>
	
	
</body>
</html>