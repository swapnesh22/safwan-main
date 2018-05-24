<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

.cart {
	background-color: #CCC;
}

#sidebar {
	display: none;
}

.cart:hover #sidebar {
	display: block;
}
</style>

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
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
	<spring:url value="/addParty" var="addPartyURL" />
	<a href="${addPartyURL }">Add New Party</a>
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
				<th>Customer Id</th>
				<th>Name</th>
				<th>Address</th>
				<th colspan="2">Action</th>
			</tr>

			<c:forEach items="${listParty}" var="party">
				<tr>
					<td>${party.partyId}</td>
					<td>${party.name}</td>
					<td>${party.address}</td>

					<td><spring:url value="/updateParty/${party.partyId}"
							var="updateURL" /> <a href="${updateURL }">Update</a></td>
					<td><spring:url value="/deleteParty/${party.partyId}"
							var="deleteURL" /> <a href="${deleteURL }">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>
