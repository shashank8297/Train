<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="traindetails" method="post">
			<h2>Enter Details</h2>
			Train No <input type="number" name="trainno" placeholder="train NO" /><br>
			<br> <input type="submit" value="traindetails" /><br> <br>
			<br> For Tickets Booking:
				<a href='https://www.irctc.co.in/nget/train-search'>CLICK HERE</a>
			</br>
			</br>
		</form>
		<%
			if(request.getAttribute("message") != null){
				out.println("<table border='1'>"
								+"<tr>"
									+"<td><b>Train no</b></td>"
									+"<td><b>Train name</b></td>"
									+"<td><b>Source</b></td>"
									+"<td><b>Via</b></td>"
									+"<td><b>Destination</b></td>"
									+"<td><b>departure</b></td>"
									+"<td><b>via_arrival</b></td>"
									+"<td><b>via_departure</b></td>"
									+"<td><b>arrival</b></td>"
								+"</tr>");
				%>
				<tr><%=request.getAttribute("message")%></tr>
				<%
					out.println("</table>");
				}
				%>
		

			<%-- <tr><%=request.getAttribute("message")%></tr> --%>
		</table>
	</center>
</body>
</html>