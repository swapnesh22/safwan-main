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
<spring:url value="/resources/css/wel.css" var="mainCss" />
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

<div>
	<spring:url value="/login" var="loginURL" />
	<form:form action="${loginURL}" method="post" modelAttribute="user">
		<div>
			<spring:url value="/resources/images" var="images" />
			<img src="${images}/login.jpg" />
		</div>
		<div>
			<label>User Name</label>
			<form:input path="username" />

			<label>Password</label>
			<form:password path="password" />
		</div>
		<div class="container" style="background-color: #f1f1f1">
			<button type="submit" class="button">Submit</button>
			<span class="psw"> <spring:url value="/addUser"
					var="addUserURL" /> <a href="${addUserURL }">New User ?</a> | 
			<spring:url value="/addCategory" var="addCategoryURL" /> <a
				href="${addCategoryURL }">New Category</a> | 
			<spring:url value="/addCategoryMaster" var="addCategoryMasterURL" /> <a
				href="${addCategoryMasterURL }">New Sub Category</a> 
			<spring:url value="/addPost" var="addPostURL" /> <a
				href="${addPostURL }">New Post</a>
			</span>
		</div>


	</form:form>
</div>
</body>

</html>
