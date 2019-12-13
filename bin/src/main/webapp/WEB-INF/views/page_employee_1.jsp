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

.h1 {
	margin-top: 5%;
	text-align: center;
	margin-bottom: 120px;
}

.button1 {
	margin-top: 2%;
	margin-left: 150px;
}

footer {
	color: grey;
}
</style>
<title>Employee</title>
</head>
<body>
	<header>


		<div class="center">
			<h1>Restaurant Monmartre</h1>
		</div>
		<div class="center">
			<h>Employee</h>
			${name}
			<h> </h>${surname}
		</div>
	</header>
	<form action="update" method="post">
		<div class="button1">
			<h3>Name</h3>
			<input type="text" name="name" value="${name}"> <br></br>
		</div>

		<div class="button1">
			<h3>Surname</h3>
			<input type="text" name="surname" value="${surname}"> <br></br>
		</div>
		<div class="button1">
			<h3>Date of birth</h3>
			<input type="text" name="date of birth" value="${date}"> <br></br>
		</div>
		<div class="button1">
			<h3>Profession</h3>
			<input type="text" name="profession" value="${profession}"> <br></br>
		</div>
		<div class="button1">
			<h3>Salary</h3>
			<input type="text" name="salary" value="${salary}"> <br></br>
		</div>
		<div class="button1">
			<h3>Email</h3>
			<input type="text" name="email" value="${email}"> <br></br>
		</div>
		<div class="button1">
			<h3>Login</h3>
			<input type="text" name="login" value="${login}"> <br></br>
		</div>
		<div class="button1">
			<h3>Password</h3>
			<input type="password" name="password" value="${password}"> <br></br>
		</div>
		<div class="button1">
			<h3>Role</h3>
			<input type="text" name="role" value="${role}"> <br></br>
		</div>
		<div class="button1">
			<h3>Vacation:</h3>
			<input type="text" name="vacation" value="${vacation}"> <br></br>
		</div>
		<div class="button1">
			<button type="submit">Change data</button>
		</div>
	</form>
	<div class="h1">
		<a href="<c:url value="/welcome" />"><h3>Go back to list Employees</h3></a>
	</div>


</body>
</html>