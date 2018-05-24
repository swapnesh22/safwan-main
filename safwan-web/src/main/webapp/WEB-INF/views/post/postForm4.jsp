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


	<div id="addPost" class="div1">
		<form:form action="" method="post" modelAttribute="post">
			<form:hidden path="id" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<table width="50%" border=1>
				<tr>
					<td>Post</td>
					<td><form:input path="title" /> <form:errors path="title"
							cssClass="error" /></td>
					<td><button type="submit" class="button">Save</button></td>
				</tr>
			</table>
		</form:form>
	</div>

	<div class="div2">
		<spring:url value="/saveComment" var="saveCommentURL" />
		<form:form action="${saveCommentURL}" method="post"
			modelAttribute="post">

			<table width="50%" border=1 id="myTable">
				<tr>
					<th>Id</th>
					<th>Review</th>
					<th>Action</th>
				</tr>

				<c:forEach items="${post.comments}" var="comment" varStatus="loop">
					<tr>
						<td class="rowl">${comment.id}</td>
						<td class="rowt"><form:input
								path="comments[${loop.index}].id" disabled="true" /></td>
						<td class="rowl">${comment.review}</td>
						<td class="rowt"><form:input
								path="comments[${loop.index}].review" /></td>

						<td class="rowl"><a href="#" id="edit">Edit</a></td>
						<td class="rowt">
							<button type="submit" class="button">Save</button> <!-- spring:url
								value="/saveComment/${comment.id}" var="saveURL" /> <a
							href="${saveURL }" id="save">Save</a-->
						</td>

					</tr>
				</c:forEach>

			</table>
		</form:form>
	</div>

	<!-- http://outbottle.com/spring-3-mvc-adding-objects-to-a-list-element-on-the-fly-at-form-submit-generic-method/-->
</body>

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
	$(document).ready(function() {
		$(".rowt").hide();
		$('#edit').click(function() {
			if ($(this).prop('checked')) {
				$(".rowl").show();
				$(".rowt").hide();
			} else {
				$(".rowl").hide();
				$(".rowt").show();
			}
		})

	});
</script>
</html>