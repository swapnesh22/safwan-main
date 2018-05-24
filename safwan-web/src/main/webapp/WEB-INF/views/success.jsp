<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<h2>User Created</h2>
	<hr />
	<form:form action="" modelAttribute="user">
	<table>
		<tr>
			<th>User Name</th>
			<td>${user.username}</td>
		</tr>
		<tr>
			<th>Type</th>
			<td>${user.type}</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<spring:url value="/logout" var="logout" /> 
					<a href="${logout}">Login with new User</a>
			</td>
		</tr>
	</table>
	</form:form>
</body>
</html>