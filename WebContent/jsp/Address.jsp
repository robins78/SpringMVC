<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<spring:url value="js/jquery.1.12.js" var="jqueryJs" />
<title>Address</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>

<script>
	$(document).ready(function() {
	if($("#message").val()=="success"){
	  	alert("Saved Successfully");
		}
	});
</script>

<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}
</style>
</head>
<body>
	<form:form id="addrForm" method="post" action="saveAddr"
		modelAttribute="addressBean">
		<table>
			<tr>
				<td><form:label path="FirstName">First Name</form:label></td>
				<td><form:input id="firstName" name="firstName" path="${firstName}"/></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td> 
				<td><form:input	id="lastName" name="lastName" path="${lastName}" /></td>
			</tr>
			<tr>
				<td><form:label path="lane">Lane</form:label></td>
				<td><form:input id="lane" name="lane" path="${lane}"/></td>
			</tr>
			<tr>
				<td><form:label path="appNo">App No</form:label></td>
				<td><form:input id="appNo" name="appNo" path="${appNo}" /></td>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
				<td><form:input id="city" name="city" path="${city}" /></td>
			</tr>
			<tr>
				<td><form:label path="state">State</form:label></td>
				<td><form:input id="state" name="state" path="${state}" /></td>
			</tr>
			<tr>
				<td><form:label path="pin">Pin</form:label></td>
				<td><form:input id="pin" name="pin" path="${pin}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<form:hidden path="message" id="message" value="${message}"/>
	</form:form>
</body>
</body>
</html>