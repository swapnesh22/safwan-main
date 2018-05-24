<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>
	<h2>Home Page</h2> 
	<div>
	(User : ${user.username} | Employee : ${user.employee.firstname})
	</div>
	<div align="right"><spring:url value="/logout" var="logoutURL" /> <a
				href="${logoutURL }">logout</a></div>
	<hr />

	<!-- form:form action="" method="post" modelAttribute="user"-->

	<table>
	<tr>
		<th>
			All Users
		</th>
		<th>
			All Users
		</th>
		<th>
			For User : ${user.username}
		</th>
	</tr>
		<tr>
			<td></td>
			<td><spring:url value="/listUser" var="listUserURL" /> <a
				href="${listUserURL }">List All Users</a></td>
			<td/>
		</tr>

		<tr>
			<td><spring:url value="/addEmployee" var="addEmployeeURL" /> <a
				href="${addEmployeeURL }">Add Employee</a></td>
			<td><spring:url value="/listEmployee" var="listEmployeeURL" />
				<a href="${listEmployeeURL }">List Employee</a></td>
				<td/>
		</tr>

		<tr>
			<td><spring:url value="/addParty" var="addPartyURL" /> <a
				href="${addPartyURL }">Add Party</a></td>

			<td><spring:url value="/listParty" var="listPartyURL" /> <a
				href="${listPartyURL }">List Party</a></td>
				<td/>
		</tr>

		<tr>
			<td><spring:url value="/addContract" var="addContractURL" /> <a
				href="${addContractURL }">Add Contract</a></td>
			<td><spring:url value="/listContract" var="listContractURL" />
				<a href="${listContractURL }">List Contract</a></td>
				<td/>
		</tr>
		<tr>
			<td><spring:url value="/addCall" var="addCallURL" /> <a
				href="${addCallURL }">Add Call</a></td>
			<td><spring:url value="/listCall" var="listCallURL" /> <a
				href="${listCallURL }">List Call</a></td>

			<td><spring:url value="/listAssignedCall"
					var="listAssignedCallURL" /> <a href="${listAssignedCallURL }">Assigned
					Call to ${user.username}</a></td>
		</tr>

	</table>
	<!-- /form:form-->
</body>
</html>