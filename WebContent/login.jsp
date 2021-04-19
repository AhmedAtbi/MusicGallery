<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css" />
</head>
<body>


	<%@ include file="../header.jsp"%>

	<%
		session = request.getSession(false);
	if (session.getAttribute("email") == null) {
	%>

	<div align="center">
		<h1>Login Form</h1>
		<form action="login.php" method="post">
			<table style="with: 100%">
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>

			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>

	<%
		} else {

	response.sendRedirect("index.jsp");

	}
	%>
</body>
</html>