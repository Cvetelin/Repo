<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.0.0.min.js"></script>
	<script type="text/javascript">	
		function validateAddProject() {
			var hasErrors = false;
			
			if ($("input[name='firstName']").val() == "") {
				$("input[name='firstName']").parent().find('div').fadeIn();
				hasErrors = true;
			} else 
				$("input[name='firstName']").parent().find('div').fadeOut();
			
			if ($("input[name='lastName']").val() == "") {
				$("input[name='lastName']").parent().find('div').fadeIn();
				hasErrors = true;
			} else
				$("input[name='lastName']").parent().find('div').fadeOut();
			
			if ($("input[name='userName']").val() == "") {
				$("input[name='userName']").parent().find('div').fadeIn();
				hasErrors = true;
			} else
				$("input[name='userName']").parent().find('div').fadeOut();
			
			if ($("input[name='password']").val() == "") {
				$("input[name='password']").parent().find('div').fadeIn();
				hasErrors = true;
			} else
				$("input[name='password']").parent().find('div').fadeOut();
			
			if (hasErrors)
				return false;
			return true;
		}
		
	</script>
</head>
 
<body>	
	
	<div>
		<div class="col-md-10 text-center">
			<p class="lead">Add User</p>			
		</div>	
		<form:form commandName="userForm" method="POST"  action="CreateUser"  cssClass="form-horizontal" id="submitForm" >
			<div class="form-group">
				<label for="firstName" class="col-sm-3 control-label">First name</label>
				<div class="col-sm-4">
					<form:input path="firstName" id="firstName" cssClass="form-control" maxlength="30"/>					
					<div style="display:none; color:red;">The value is required</div>
<%-- 					<form:hidden path="projectId"/> --%>
				</div>
			</div>		
			<div class="form-group">
				<label for="lastName" class="col-sm-3 control-label">Last name</label>
				<div class="col-sm-4">
					<form:input path="lastName" id="lastName" cssClass="form-control" maxlength="30"/>					
					<div style="display:none; color:red;">The value is required</div>
				</div>
			</div>				
			<div class="form-group">
				<label for="userName" class="col-sm-3 control-label">Username</label>
				<div class="col-sm-4">
					<form:input path="userName" id="userName" cssClass="form-control" maxlength="30"/>					
					<div style="display:none; color:red;">The value is required</div>
				</div>
			</div>
		 	<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Password</label>
				<div class="col-sm-4">
					<form:input path="password" id="password" cssClass="form-control" maxlength="30"/>					
					<div style="display:none; color:red;">The value is required</div>
				</div>
			</div>
			 <div class="form-group">
				<div class="col-sm-offset-1 col-sm-6 pull-right">
<!-- 					<input type="button" id="cancelBtn" class="btn btn-default"  value=Back onClick="history.go(-1)" /> -->
					<a href="/ShowProjects" >
						<input type="button" id="cancelBtn" class="btn btn-default"  value="Cancel"></input>
					</a>
					<input type="submit" id="submit" class="btn btn-default" onclick="return validateAddProject();" value="Save" />
		  		</div>
		  	 </div>			  	
		</form:form>
	</div>	
		<!-- 			
		http://viralpatel.net/blogs/spring-mvc-multi-row-submit-java-list/
		http://howtodoinjava.com/2013/08/30/hibernate-example-of-insertselect-blob-from-database/
		-->
</body>
</html>