<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Form</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h2>User Input From</h2>
	<hr />
	<spring:url value="/saveUser" var="saveUserURL" />
	<form:form action="${saveUserURL}" method="post"
		modelAttribute="user">
		<form:hidden path="userid" />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<table>
			<tr>
				<td>User Name</td>
				<td><form:input path="username" /> <form:errors
						path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" /> <form:errors
						path="password" cssClass="error" /></td>
			</tr>
			

			<tr>
				<td>Type</td>
				<td>
					<form:select path="type">
							<form:options items="${userTypeList}"/>
						</form:select>
				</td>
				<td>
					<form:errors path="type" cssClass="error" />
				</td>
			</tr>
			
			<tr>
				<td>Employee</td>
				<td>
					<form:select path="employee" items="${employees}" itemValue="employeeId" itemLabel="firstname"/>
				</td>
				<td>
					<form:errors path="employee" cssClass="error" />
				</td>
			</tr>


			<tr>
				<td><button type="submit" class="button">Register</button></td>
				<td>
					<spring:url value="/" var="cancelRequest" />
						<a href="${cancelRequest}">Cancel</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>