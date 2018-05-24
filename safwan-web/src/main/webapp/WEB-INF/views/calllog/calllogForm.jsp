<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Call Log Form</title>
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
	$("#callLogDate").datepicker({ dateFormat: "dd-mm-yy" }).val();
	});
	
	$(function() {
		$("#visitDate").datepicker({ dateFormat: "dd-mm-yy" }).val();
		});
	$(function() {
		$("#callAssignDate").datepicker({ dateFormat: "dd-mm-yy" }).val();
		});
	$(function() {
		$("#visitTime").datepicker({ dateFormat: "dd-mm-yy" }).val();
		});
	});

</script>
</head>
<body>

	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>

	<h2>Call Log Details</h2>
	<hr />
	<spring:url value="/saveCall" var="saveCallURL" />
	<form:form action="${saveCallURL}" method="post"
		modelAttribute="call">
		<form:hidden path="calllogid" />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<table>
			<tr>
				<td>Call Log Number</td>
				<td><form:input path="calllognumber" /> <form:errors
						path="calllognumber" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Call Log Date</td>
				<td><form:input path="callLogDate" id="callLogDate"  /> <form:errors
						path="callLogDate" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Visit Date</td>
				<td><form:input path="visitDate" id="visitDate"/> <form:errors
						path="visitDate" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Visit Time</td>
				<td><form:input path="visitTime" id="visitTime"/> </td>
			</tr>
			<tr>
				<td>Reason For Visit</td>
				<td><form:input path="reasonVisit" /> <form:errors
						path="reasonVisit" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Assignment Date</td>
				<td><form:input path="callAssignDate" id="callAssignDate"/> <form:errors
						path="callAssignDate" cssClass="error" /></td>
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
				<td>Call Type</td>
				<td>
                  <form:radiobutton path = "callType" value = "1" label = "1" />
                  <form:radiobutton path = "callType" value = "2" label = "2" />
               
				</td>
			</tr>

			<tr>
				<td><button type="submit" class="button">Submit</button></td>
				<td><spring:url value="/listCall" var="goToListURL" /> <a
					href="${goToListURL}">Call List</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>