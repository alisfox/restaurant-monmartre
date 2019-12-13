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
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static-content/css/main.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static-content/js/jquery-ui/jquery-ui.min.css" type="text/css">
<title>Dashboard</title>
</head>
<body>
	<header>
		<div class="center">
			<h1>Restaurant Monmartre</h1>
		</div>
	</header>
	<div class="center">
		<h1>Add employee:</h1>
		<br>
		<spring:form action="save-empl" method="post"
			modelAttribute="employee">
			
                Name:
				<br>
			<spring:input path="employeeName" />


			<br>
				Surname:
				<br>
			<spring:input path="employeeSurname" />
			<br>
			Date of birth:
				<br />
			<spring:input path="employeeDateOfBirth" id="event_date_picker"/>

			<br />
			
				Profession:
				<br />
			<spring:input path="employeeProfession" />

			<br />
			Salary:
				<br />
			<spring:input path="employeeSalary" />

			<br />
				Email:
				<br />
			<spring:input path="employeeEmail" />


			<br />
				Login:
				<br>
			<spring:input path="employeeLogin" />
			<br>
		
             Password:
				<br>
			<spring:password path="employeePassword" />

			<br>
			Role:
				<br />
			<spring:input path="employeeRole" />

			<br />

			<br>
			<input type="submit" name="login_btn" value="Save" />
			<br>
		</spring:form>
	</div>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static-content/js/jquery/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static-content/js/jquery-ui/jquery-ui.min.js"></script>
	
	<script type="text/javascript">
		$( document ).ready(function() {
			$('#event_date_picker').datepicker({
				showOtherMonths: true,
				selectOtherMonths: true,
				dateFormat: "dd-mm-yy",
				showOn: "button",
				buttonImage: "${pageContext.request.contextPath}/static-content/images/calendar-icon-24.png",
				buttonImageOnly: true,
				buttonText: "Select date"
		    });
		});		
	</script>

	<br>
	<div class="center1">
		<a href="<c:url value="/welcome" />">Go back to list Employees</a>
		
	</div>
</body>
</html>