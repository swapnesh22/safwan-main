<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Form</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>
	<h2>Category Input From</h2>
	<hr />

	<div>
		<table width="50%" border=1 id="myTable">

			<tr>
				<th>Category Id</th>
				<th>Category Name</th>
				<th colspan="2">Action</th>
			</tr>

			<c:forEach items="${listCategory}" var="category">
				<tr>
					<td>${category.categoryid}</td>
					<td>${category.categoryname}</td>
					<td><spring:url value="/updateCategory/${category.categoryid}"
							var="updateURL" /> <a href="${updateURL }">Update</a></td>
					<td><spring:url value="/deleteCategory/${category.categoryid}"
							var="deleteURL" /> <a href="${deleteURL }">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		Click to Add: 
		<input id="toggleElement" type="checkbox" />
	</div>

	<div id="addCat" class="div1">
		<spring:url value="/saveCategory" var="saveCategoryURL" />
		<form:form action="${saveCategoryURL}" method="post"
			modelAttribute="category">
			<form:hidden path="categoryid" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<table width="50%" border=1>
				<tr>
					<td>Category Name</td>
					<td><form:input path="categoryname" /> <form:errors
							path="categoryname" cssClass="error" /></td>
					<td><button type="submit" class="button">Save</button></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>

	$(document).ready(
		    function(){
		    	$(".div1").hide();
		    	$('#toggleElement').click(function () {
		            if ($(this).prop('checked')) {
		                $(".div1").show();
		            } else {
		                $(".div1").hide();
		            }
		        })

		    });
</script>
</html>