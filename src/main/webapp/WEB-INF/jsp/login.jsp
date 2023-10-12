<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<h2>Login Page</h2>
	<body align="center">
		<center>
			<form method="post" action="loginto">
				User Name:<input type="text" name="username" placeholder="User Name" required><br><br>
				Password:<input type="password" name="password" placeholder="Password" required><br><br>
				<input type="submit" name="submit" value="Login">
			</form>
		</center>
	</body>
</html>