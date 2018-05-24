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
<spring:url value="/resources/css/welcome.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h2>Welcome!</h2>
</body>

<hr />


<spring:url value="/login" var="loginURL" />
<form:form action="${loginURL}" method="post" modelAttribute="user">
	<table>
		<tr>
			<td>
				<table>
					<tr>
						<td><spring:url value="/resources/images" var="images" />
<img src="${images}/login.jpg" /></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>

					<tr>
						<td></td>
						<td>
							
						</td>
					</tr>
					<tr>
						<td>
						<td></td>
					</tr>
				</table>
			</td>
			<td>
				<table>
					<tr>
						<td>User Name</td>
						<td><form:input path="username" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:password path="password" /></td>
					</tr>

					<tr>
						<td><button type="submit" class="button">Submit</button></td>
						<td>
							<!-- Forgot Password ? spring:url value="/forgetPassword" var="forgPassURL" />
						<a href="${forgPassURL }">Forget Password</a-->
						</td>
					</tr>
					<tr>
						<td><spring:url value="/addUser" var="addUserURL" /> <a
							href="${addUserURL }">New User ?</a></td>
						<td></td>
					</tr>
				</table>
			</td>
		</tr>

	</table>

</form:form>
<hr />
<table>
	<tr>
		<td><spring:url value="/addCategory" var="addCategoryURL" /> <a
			href="${addCategoryURL }">New Category</a></td>
	</tr>
	<tr>
		<td><spring:url value="/addCategoryMaster"
				var="addCategoryMasterURL" /> <a href="${addCategoryMasterURL }">New
				Sub Category</a></td>
	</tr>
</table>
</body>

</html>
