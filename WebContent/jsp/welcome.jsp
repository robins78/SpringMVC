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
<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}

#banner {
	background-image: url('../images/banner.png');
	width: 100%;
	min-height: 189px;
}

tr.even {
	background: #E0ECF8;
}

tr.odd {
	background: #F2F2F2;
}

#gridHead {
	background: #81BEF7
}

#display {
	border-style: groove;
}

#header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}
</style>
<title>Welcome</title>
</head>
<body>
	<div id="header">
		<img src="./banner.jpg">
	</div>
	<form:form id="addressForm" method="post" action="welcome">
		<!-- modelAttribute="Address" -->
		<input type="submit" value="Fetch" />
	</form:form>

	<table id="display" style="width: 100%">
		<c:forEach items="${addressList}" var="addr" varStatus="count">
			<c:if test="${count.index==0}">
				<tr id="gridHead">
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Lane</th>
					<th>Appt No</th>
					<th>City</th>
					<th>State</th>
					<th>Pin</th>
				</tr>
			</c:if>
			<tr class="${count.index % 2 == 0 ? 'odd' : 'even'}">
				<td><c:out value="${addr.id}" /></td>
				<td><c:out value="${addr.firstName}" /></td>
				<td><c:out value="${addr.lastName}" /></td>
				<td><c:out value="${addr.lane}" /></td>
				<td><c:out value="${addr.appNo}" /></td>
				<td><c:out value="${addr.city}" /></td>
				<td><c:out value="${addr.state}" /></td>
				<td><c:out value="${addr.pin}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>