<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/bootstrap.css' /> " />
<title>Please Log In</title>
</head>

<style>
	.spacer {
    margin-top: 20px; /* define margin as you see fit */
</style>


<body>
<div class="container">
	<div class="row spacer"></div>
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8">
			<form role="form" id="loginform" action="" method="post" class="form-horizontal">
				<div class="form-group">
					<label for="username" class="col-sm-2">Username: </label>
					<div class=" col-sm-10">
						<input type="text" name="username" class="form-control" id="username">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2">Password: </label>
					<div class=" col-sm-10">
						<input type="password" name="password" class="form-control" id="password">
					</div>
				</div>
				<div class="form-group">
					<label for="rememberMe" class="col-sm-2">Remember me: </label>
					<div class=" col-sm-4">
						<input type="checkbox" name="rememberMe" id="rememberMe">
					</div>
					<div class=" col-sm-6">
						<input type="submit" id="submit" class="btn btn-default pull-right" value="Login" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>