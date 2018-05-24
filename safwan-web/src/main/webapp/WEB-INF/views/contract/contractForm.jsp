<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contract Form</title>
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
	$("#contractEntry").datepicker({ dateFormat: "dd-mm-yy" }).val();
	});
	
	$(function() {
		$("#contractStart").datepicker({ dateFormat: "dd-mm-yy" }).val();
		});
	$(function() {
		$("#contractEnd").datepicker({ dateFormat: "dd-mm-yy" }).val();
		});
	});

</script>

<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h2>Contract Details</h2>
	<hr />
	<spring:url value="/saveContract" var="saveContractURL" />
	<form:form action="${saveContractURL}" method="post"
		modelAttribute="contract">
		<form:hidden path="contractid" />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<table>
			<tr>
				<td>Logged In User</td>
				<td><c:out value="${sessionScope.user.employee.firstname}"/></td>
			</tr>
			<tr>
				<td>Contract Code</td>
				<td><form:input path="contractcode" /> <form:errors
						path="contractcode" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Contract Entry Date</td>
				<td><form:input path="contractEntryDate" id="contractEntry"  /> <form:errors
						path="contractEntryDate" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Contract Start Date</td>
				<td><form:input path="contractStartDate" id="contractStart"/> <form:errors
						path="contractStartDate" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Contract End Date</td>
				<td><form:input path="contractEndDate" id="contractEnd"/> <form:errors
						path="contractEndDate" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>Frequency</td>
				<td><form:input path="frequency"/> <form:errors
						path="frequency" cssClass="error" /> (in months)</td>
			</tr>
			
			<tr>
				<td>Party</td>
				<td>
					<form:select path="party" items="${parties}" itemValue="partyId" itemLabel="name"/>
				</td>
				<td>
					<form:errors path="party" cssClass="error" />
				</td>
			</tr>
			
			<tr>
				<td>Creator</td>
				<td>
					<form:select path="creator" items="${employees}" itemValue="employeeId" itemLabel="firstname"/>
				</td>
				<td>
					<form:errors path="creator" cssClass="error" />
				</td>
			</tr>
			
			<tr>
				<td>Active Status</td>
				<td>
                  <form:radiobutton path = "activeStatus" value = "Yes" label = "Yes" />
                  <form:radiobutton path = "activeStatus" value = "No" label = "No" />
               
				</td>
			</tr>

			<tr>
				<td><button type="submit" class="button">Submit</button></td>
				<td><spring:url value="/listContract" var="goToListURL" /> <a
					href="${goToListURL}">Contract List</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>