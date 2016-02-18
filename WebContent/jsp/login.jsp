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
<body>
	<form:form id="loginForm" method="post" action="login"	modelAttribute="loginBean">
		<form:label path="username">Enter your user-name</form:label>
		<form:input id="username" name="username" path="username" />
		<br>
		<form:label path="username">Please enter your password</form:label>
		<form:password id="password" name="password" path="password" />
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</body>
</html>