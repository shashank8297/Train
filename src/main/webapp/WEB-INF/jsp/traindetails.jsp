<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">

		<tr>

			<td><b>Train no</b></td>

			<td><b>Train name</b></td>

			<td><b>Source</b></td>

			<td><b>Destination</b></td>

			<td><b>Start Time</b></td>

			<td><b>End Time</b></td>

		</tr>

		<tr><%=request.getAttribute("message") %></tr>
	</table>
</body>
</html>