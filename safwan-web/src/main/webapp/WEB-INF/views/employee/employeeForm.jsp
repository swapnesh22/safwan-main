<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style type="text/css">
.error {
	color: red;
}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<script>
$(document).ready(function() {
	$(function() {
	$("#dateOfBirth").datepicker({ dateFormat: "dd-mm-yy" }).val();
	});
	
	$(function() {
		$("#dateOfJoining").datepicker({ dateFormat: "dd-mm-yy" }).val();
	});
});

</script>

</head>
<body>
	<h2>Employee Details</h2>
	<hr />
	<spring:url value="/saveEmployee" var="saveEmployeeURL" />
	<form:form action="${saveEmployeeURL}" method="post"
		modelAttribute="employee">
		<form:hidden path="employeeId" />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstname" /> <form:errors
						path="firstname" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastname" /> <form:errors
						path="lastname" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address" /> <form:errors
						path="address" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><form:input path="dob" id="dateOfBirth"  /> <form:errors
						path="dob" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Date of Joining</td>
				<td><form:input path="doj" id="dateOfJoining"/> <form:errors
						path="doj" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><form:input path="contactphone" /> <form:errors path="contactphone"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><form:input path="cellphone" /> <form:errors path="cellphone"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /> <form:errors path="email"
						cssClass="error" /></td>
			</tr>

			<tr>
				<td><button type="submit" class="button">Submit</button></td>
				<td><spring:url value="/listEmployee" var="goToListURL" /> <a
					href="${goToListURL}">Employee List</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>