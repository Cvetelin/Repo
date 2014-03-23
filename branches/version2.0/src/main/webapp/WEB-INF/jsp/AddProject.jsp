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
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.js"></script>
	<script type="text/javascript">	
		function validateAddProject() {
			var hasErrors = false;
			
			if ($("input[name='name']").val() == "") {
				$("input[name='name']").parent().find('div').fadeIn();
				hasErrors = true;
			} else
				$("input[name='name']").parent().find('div').fadeOut();
			
			if ($("input[name='testJar']").val() == "") {
				$("input[name='testJar']").parent().find('div').fadeIn();
				hasErrors = true;
			} else
				$("input[name='testJar']").parent().find('div').fadeOut();
			
			if (hasErrors)
				return false;
			return true;
		}
	</script>
</head>
 
<body>	
	<div  class="table-bordered">
		<div class="col-md-10 text-center">
			<p class="lead">Add project</p>			
		</div>	
		<form:form commandName="projectForm" method="POST"  action="CreateProject"  cssClass="form-horizontal" enctype="multipart/form-data">
			<div class="form-group">
				<label for="projectName" class="col-sm-3 control-label">Project name</label>
				<div class="col-sm-4">
					<form:input path="name" id="projectName" cssClass="form-control" />
					<div style="display:none; color:red;">The value is required</div>
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-3 control-label">Description</label>
				<div class="col-sm-4">
					<form:input path="description" id="description" class="form-control" />
				</div>
			</div>			
			<div class="form-group">
		  	    	<label for="testJar" class="col-sm-3 control-label">Jar file</label>
		  	    	<div class="col-sm-4">
		   	 			<input type="file" id="testJar" class="form-control"  name="testJar" onchange="GetDiretory()"/>
		   	 			<div style="display:none; color:red;">The value is required</div>
		   	 			<p class="help-block text-center">The JAR containing the test classes</p>
		   	 		</div>			   					   			
		 	 </div>	
		 	 <div class="form-group">
		  	    	<label for="depJar" class="col-sm-3 control-label">Dependency jar</label>
		  	    	<div class="col-sm-4">
		   	 			<input type="file" id="depJar" name="depJar" class="form-control" />
		   	 			<p class="help-block text-center">The JAR containing classes not in test src folder</p>
		   	 		</div>	   				
		 	 </div>			 	 
		 	 <div class="form-group">
				<div class="col-sm-offset-1 col-sm-5 pull-right">		 		
		  			 <input type="submit" class="btn btn-default" onclick="return validateAddProject();" value="Save"></input>
		  		</div>
		  	 </div>			  	
		</form:form>
	</div>	
		<!-- 			
		http://viralpatel.net/blogs/spring-mvc-multi-row-submit-java-list/
		http://howtodoinjava.com/2013/08/30/hibernate-example-of-insertselect-blob-from-database/
		-->
		
		<a href="/app/GetTestClasses">GetTesClasses</a>
	
	
</body>
</html>