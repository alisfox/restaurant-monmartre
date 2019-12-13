<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.center1 {
	margin-top: 2.5%;
	text-align: center;
	font-size: 150%;
	color: black;
	margin-bottom: 70px;
}

.center {
	margin-top: 5%;
	text-align: center;
}

body {
	color: darkslategray;
	background: mistyrose;
}

header {
	font-size: 200%;
}

h1 {
	font-family: 'Times New Roman', Times, serif;
	font-size: 200%;
}
</style>
<meta charset="utf-8">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static-content/css/main.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static-content/js/jquery-ui/jquery-ui.min.css"
	type="text/css">
<title>Dashboard</title>
</head>
<body>
	<header>
		<div class="center">
			<h1>Restaurant Monmartre</h1>
		</div>
	</header>

	<div class="center">
		<h1>Employees</h1>
	</div>
	<table align="center">
		<tr>
			<th>
				<p>Name</p>
			</th>
			<th>
				<p>Surname</p>
			</th>
			<th>
				<p>Date of birth</p>
			</th>
			<th>
				<p>Profession</p>
			</th>
			<th>
				<p>Salary</p>
			</th>
			<th>
				<p>Email</p>
			</th>
			<th>
				<p>Login</p>
			</th>
			<th>
				<p>Password</p>
			</th>
			<th>
				<p>Role</p>
			</th>



		</tr>

		<c:forEach items="${employeeList}" var="employee">

			<tr>
				<td>${employee.employeeName}</td>
				<td>${employee.employeeSurname}</td>
				<td>${employee.employeeDateOfBirth}</td>
				<td>${employee.employeeProfession}</td>
				<td>${employee.employeeSalary}</td>
				<td>${employee.employeeEmail}</td>
				<td>${employee.employeeLogin}</td>
				<td>${employee.employeePassword}</td>
				<td>${employee.employeeRole}</td>
				<td><a
					href="<c:url value="/page_empl_for_admin/${employee.employeeLogin}" />">change
						data</a></td>
			</tr>
		</c:forEach>
	</table>

	<div class="center">
		<h1>Employee vacation</h1>
	</div>

	<table align="center">
		<tr>

			<th>
				<p>Login</p>
			</th>
			<th>
				<p>Vacation</p>
			</th>
		</tr>

		<c:forEach items="${employeeList1}" var="employeeVacation">


			<tr>

				<td>${employeeVacation.employeeLogin}</td>
				<td>${employeeVacation.vacation}</td>
				<td><a
					href="<c:url value="/page_empl_for_admin/${employeeVacation.employeeLogin}" />">change
						data</a></td>
			</tr>
		</c:forEach>

	</table>

	<br>

	<div class="center">
		<h1>Employee recommendations</h1>
	</div>

	<table align="center">
		<tr>

			<th>
				<p>Login</p>
			</th>
				<th>
				<p>Login</p>
			</th>
			<th>
				<p>Recommendations</p>
			</th>
			<th>
				<p>Recommendations</p>
			</th>
		</tr>

		<c:forEach items="${employeeRecommendationsList}"
			var="employeeRecommendations">


			<tr>
                
				<td>${employeeRecommendations.employeeLogin}</td>
				<td>${employeeRecommendations.recommendations}</td>
				<td><a
					href="<c:url value="/delete/${employeeRecommendations.idEmployeeRecommendations}" />">delete
						data</a></td>
			</tr>
		</c:forEach>

	</table>
	<div class="center1">
		<a href="<c:url value="/add_employee" />">Add new employee</a>

	</div>


</body>
</html>