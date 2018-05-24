<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Party Form</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h2>Party Input From</h2>
	<hr />
	<spring:url value="/saveParty" var="savePartyURL" />
	<form:form action="${savePartyURL}" method="post"
		modelAttribute="party">
		<form:hidden path="partyId" />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<table>
			<tr>
				<td>Party Number</td>
				<td><form:input path="partyId" disabled="true" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /> <form:errors path="name"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Cell phone</td>
				<td><form:input path="cellphone" /> <form:errors
						path="cellphone" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><form:input path="address" /> <form:errors path="address"
						cssClass="error" /></td>
			</tr>

			<tr>
				<td>Contact person</td>
				<td><form:input path="contactperson" /> <form:errors
						path="contactperson" cssClass="error" /></td>

			</tr>

			<tr>
				<td>Email</td>
				<td><form:input path="email" /> <form:errors path="email"
						cssClass="error" /></td>
			</tr>

			<tr>
				<td>Contact phone</td>
				<td><form:input path="contactphone" /> <form:errors
						path="contactphone" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>Party Type</td>
				<td>
					<form:select path="partytype" items="${partytypes}" 
						itemValue="subcategoryid" itemLabel="subcategorydesc"/>
						<form:errors path="partytype" cssClass="error" />
				</td>
			</tr>

			<tr>
				<td><button type="submit" class="button">Submit</button></td>
				<td><spring:url value="/listParty" var="goToListURL" /> <a
					href="${goToListURL}">Customer List</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>