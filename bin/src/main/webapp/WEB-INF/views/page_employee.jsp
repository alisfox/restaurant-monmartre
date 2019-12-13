<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.center {
	margin-top: 5%;
	text-align: center;
	margin-bottom: 90px;
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

table {
	align: center;
	font-weight: bold;
}

.button1 {
	position: absolute;
	bottom: 440px;
	right: 150px;
	line-height: 5px;
	color: purple;
}

.button2 {
	position: absolute;
	bottom: 440px;
	left: 150px;
	line-height: 5px;
	color: purple;
}

.button3 {
	position: absolute;
	color: purple;
	bottom: 400px;
}

footer {
	color: purple;
}
</style>
<title>Personal Account</title>
</head>
<body>
	<header>
		<div class="center">
			<h1>Restaurant Monmartre</h1>

			<h>Welcome to your personal account,${name}<h> </h>${surname}.</h>
		</div>
	</header>



	<table align="center">
		<tr>
			<td>Name:</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>Surname:</td>
			<td>${surname}</td>
		</tr>
		<tr>
			<td>Date of birth:</td>
			<td>${date}</td>
		</tr>
		<tr>
			<td>Profession:</td>
			<td>${profession}</td>
		</tr>
		<tr>
			<td>Salary:</td>
			<td>${salary}</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>${email}</td>
		</tr>
		<tr>
			<td>Login:</td>
			<td>${login}</td>
		</tr>
		<tr>
			<td>Password:</td>
			<td>${password}</td>
		</tr>
		<tr>
			<td>Vacation:</td>
			<td>${vacation}</td>
		</tr>

	</table>
	<div class="center">
		<form action="email" method="post">
			<h2>Change email</h2>
			<input type="text" name="email" value="">
			<input type="hidden" name="login" value="${login}">
			<button type="submit">Submit</button>
		</form>

		<form action="message" method="post">
			<h3>You can send a message with wishes on the formation of your
				work schedule</h3>
			<h2>Send the message</h2>
			<input type="text" name="email" value="">
			<input type="hidden" name="login" value="${login}">
			<button type="submit">Submit</button>
		</form>
	</div>

</body>
</html>