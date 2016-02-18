<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="js/jquery.1.12.js" var="jqueryJs" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		//  alert("Hi");
	});
</script>
<title>Welcome</title>
</head>
<body>
	<form:form id="addressForm" method="post" action="welcome">
		<!-- modelAttribute="Address" -->
		<input type="submit" value="Fetch" />
	</form:form>

	<table style="width: 100%" border="1">

		<c:forEach items="${addressList}" var="addr" varStatus="count">
			<c:if test="${count.index==0}">
				<tr>
					<td>ID</td>
					<td>First Name</td>
				</tr>
			</c:if>
			<tr>
				<td>ID: <c:out value="${addr.id}" /></td>
				<td>First Name: <c:out value="${addr.firstName}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>