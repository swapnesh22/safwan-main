<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<style type="text/css">
.error {
	color: red;
}

.cart { background-color: #CCC; }

#sidebar {
    display: none;
}
.cart:hover #sidebar {
    display:block;
}
</style>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
    $(document).ready(function(){
        $("#boxchecked").click(function (){
            if ($("#boxchecked").prop("checked")){
                $("#hidden").hide();
            }else{
                $("#hidden").show();
            }              
        });
    });
    
    function myFunction() {
    	  var input, filter, table, tr, td, i;
    	  input = document.getElementById("myInput");
    	  filter = input.value.toUpperCase();
    	  table = document.getElementById("myTable");
    	  tr = table.getElementsByTagName("tr");
    	  for (i = 0; i < tr.length; i++) {
    	    td = tr[i].getElementsByTagName("td")[1];
    	    if (td) {
    	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
    	        tr[i].style.display = "";
    	      } else {
    	        tr[i].style.display = "none";
    	      }
    	    }       
    	  }
    	}
</script>

</head>
<body>

	<!-- spring:url value="/addUser" var="addUserURL" />
	<a href="${addUserURL }">Add New User</a-->
	<spring:url value="/goToHome" var="goToHome" /> 
		<a href="${goToHome}">Home</a>
	<form:form>
		<c:if test="${not empty exception}">
			<font class="error"><c:out value="${exception.errCode}" /> <c:out
					value="${exception.errMsg}" /></font>
		</c:if>
		<form:errors />
		<table width="50%" border=1 id="myTable">
		<tr>
			<input type="text" id="myInput" onkeyup="myFunction()"
				placeholder="Search for names.." title="Type in a name">
		</tr>
			<tr>
				<th>User Id</th>
				<th>User Name</th>
				<th>Type</th>
				<th>Employee</th>
				<th colspan="2">Action</th>
			</tr>

			<c:forEach items="${listUser}" var="user">
				<tr>
					<td>${user.userid}</td>
					<td>${user.username}</td>
					<td>${user.type}</td>
					<td>${user.employee.firstname}</td>
					<td><spring:url
							value="/updateUser/${user.userid}"
							var="updateURL" /> <a href="${updateURL }">Update</a></td>
					<td><spring:url
							value="/deleteUser/${user.userid}"
							var="deleteURL" /> <a href="${deleteURL }">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>