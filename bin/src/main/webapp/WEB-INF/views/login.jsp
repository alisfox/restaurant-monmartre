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
}

body {
	color: darkslategray;
	background: mistyrose;
}

header {
	font-size: 200%;
}

footer {
	color: purple;
}
</style>

<style type="text/css" media="all">
.form_table {
	text-align: center;
}

.full_width .segment_header {
	text-align: center !important;
}

.q {
	float: none;
	display: inline-block;
}

table.matrix, table.rating_ranking {
	margin-left: auto !important;
	margin-right: auto !important;
}
</style>

<title>Dashboard</title>
</head>
<body>
	<header>
		<div class="center">
			<h1>Restaurant Monmartre</h1>
		</div>
		<div class="center">
			<h>Sign in</h><br>
			<small>${error}</small>
		</div>
	</header>
	<br></br>
	<form action="action" method="post">

		<table align="center">
			<tr>

				<td>Username</td>

				<td><input type="text" name="employee_login"></td>
			</tr>

			<tr>
				<td>Password</td>

				<td><input type="password" name="employee_password"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Sign in</button></td>
			</tr>
		</table>

	</form>

</body>
</html>