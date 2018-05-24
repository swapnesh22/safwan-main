<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Sample Form</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>
	<h2>Post Input From</h2>
	<hr />
	
	<div>
		Click to Add: 
		<input id="toggleElement" type="checkbox" />
	</div>

	<div id="addPost" class="div1">
		<spring:url value="/savePost" var="savePostURL" />
		<form:form action="${savePostURL}" method="post"
			modelAttribute="post">
			<form:hidden path="id" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<table width="50%" border=1>
				<tr>
					<td>Post</td>
					<td><form:input path="title" /> <form:errors
							path="title" cssClass="error" /></td>
					<td><button type="submit" class="button">Save</button></td>
				</tr>
			</table>
		</form:form>
	</div>
	
	<div class="div2">
		<spring:url value="/savePostComment" var="savePostCommentURL" />
		<form:form action="${savePostCommentURL}" method="post"
			modelAttribute="postComment">
		<table width="50%" border=1 id="myTable">

			<tr>
				<th>Id</th>
				<th>Review</th>
				<th colspan="3">Action</th>
			</tr>

			<c:forEach items="${listPostComment}" var="postComment">
				<tr>
					
					<td class="rowl">${postComment.id}</td>
					<td class="rowt"><form:input path="postComment.id" /></td>
					
					<td class="rowl">${postComment.review}</td>
					<td class="rowt"><form:input path="postComment.review" /></td>
					
					<td><spring:url value="/saveComment/${postComment.id}"
							var="saveURL" /> <a href="${saveURL }" id="save">Save</a></td>
					<td><spring:url value="/updateComment/${postComment.id}"
							var="updateURL" /> <a href="${updateURL }">Update</a></td>
					<td><spring:url value="/deleteComment/${postComment.id}"
							var="deleteURL" /> <a href="${deleteURL }">Delete</a></td>

				</tr>
			</c:forEach>
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