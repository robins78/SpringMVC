<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<spring:url value="js/jquery.1.12.js" var="jqueryJs" />
	<title>Login</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" ></script>

	<script>
		$(document).ready(function(){
		    //alert("Hi");
		});
	</script>

	<style type="text/css">
		body {
			background-image: url('http://crunchify.com/bg.png');
		}
	</style>
</head>
<body>
	<form:form id="loginForm" method="post" action="login"	modelAttribute="loginBean">
	 <table>
		<tr>
			<td><form:label path="username">Enter your user-name</form:label></td>
			<td><form:input id="username" name="username" path="username" /></td>
		</tr>
		<tr>
			<td><form:label path="username">Please enter your password</form:label></td>
			<td><form:password id="password" name="password" path="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	 </table>
	</form:form>
</body>
</body>
</html>