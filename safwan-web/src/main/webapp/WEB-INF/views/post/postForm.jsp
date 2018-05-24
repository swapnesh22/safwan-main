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
	
		<spring:url value="/saveComment" var="saveCommentURL" />
		<form:form action="${saveCommentURL}" method="post" modelAttribute="post">
			<form:hidden path="id" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<table width="50%" border=1>
				<tr>
					<td>Post</td>
					<td><form:input path="title" /> <form:errors path="title"
							cssClass="error" /></td>
				</tr>
			</table>

			<table width="50%" border=1 id="myTable">
				<!-- tr>
					<th>Id</th>
					<th>Review</th>
					<th>Action</th>
				</tr-->

				<c:forEach items="${post.comments}" var="comment" varStatus="loop">
					<tr>
						<td class="rowt" id="txtTitle"><form:input
								path="comments[${loop.index}].id" readonly="true" /></td>
						<td class="rowt" id="txtTitl"><form:input
								path="comments[${loop.index}].review" /></td>
					</tr>
				</c:forEach>
				<tr>
				<td>
							<button type="button" >Add Row</button> 
						</td>
						</tr>
			</table>
			<table><tr><td><button type="submit" class="button">Save</button></td></tr></table>
		</form:form>
	</div>

	<!-- http://outbottle.com/spring-3-mvc-adding-objects-to-a-list-element-on-the-fly-at-form-submit-generic-method/-->
</body>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	var i = 1;
    	$("button").click(function() {
    	    $('#myTable tr:first').clone().find("input").each(function() {
    	        $(this).val('').attr('id', function(_, id) { return id + i });
    	    }).end().appendTo('#myTable');
    	    i++;
    	});
    });
</script>
</html>