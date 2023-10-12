<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Source and Destination</title>
	</head>
	<body>
		<center>
			<form action="detailsd" method="post">
				Source:<select name="source">
					<option value="">-Select-</option>
					<option value="New Delhi">New Delhi</option>
					<option value="Mumbai">Mumbai</option>
					<option value="Kolkata">Kolkata</option>
					<option value="Chennai">Chennai</option>
					<option value="Himalayan Queen">Delhi</option>
					<option value="Agra">Agra</option>
					<option value="Vadodara">Vadodara</option>
					<option value="Dhanbad">Dhanbad</option>
					<option value="Bengaluru">Bengaluru</option>
					<option value="Chandigarh"> Chandigarh</option>
					<option value="Jaipur"> Jaipur</option>
					<option value="Ahmedabad"> Ahmedabad</option>
					<option value="Patna"> Patna</option>
					<option value="Hyderabad"> Hyderabad</option>
					<option value="Shimla"> Shimla</option>
				</select>
				<br> <br> 
				Destination:<select name="destination">
					<option value="">-Select-</option>
					<option value="New Delhi">New Delhi</option>
					<option value="Mumbai">Mumbai</option>
					<option value="Kolkata">Kolkata</option>
					<option value="Chennai">Chennai</option>
					<option value="Himalayan Queen">Delhi</option>
					<option value="Agra">Agra</option>
					<option value="Vadodara">Vadodara</option>
					<option value="Dhanbad">Dhanbad</option>
					<option value="Bengaluru">Bengaluru</option>
					<option value="Chandigarh"> Chandigarh</option>
					<option value="Jaipur"> Jaipur</option>
					<option value="Ahmedabad"> Ahmedabad</option>
					<option value="Patna"> Patna</option>
					<option value="Hyderabad"> Hyderabad</option>
					<option value="Shimla"> Shimla</option>
				</select><br> <br> 
				<input type="submit" value="Get Train Details" />
	</form>
	<%
			if(request.getAttribute("message") != null){
				out.println("<table border=1>" 
						+ "<tr>" 
							+ "<td><b>" + "Train no" + "</b></td>" 
							+ "<td><b>" + "Train name"+ "</b></td>" 
							+ "<td><b>" + "Source" + "</b></td>" 
							+ "<td><b>" + "Destination" + "</b></td>"
							+ "<td><b>" + "Departure" + "</b></td>" 
							+ "<td><b>" + "Arrival" + "</b></td>" 
						+ "</tr>");
		
				%>
				<tr>
					<%=request.getAttribute("message")%>
				</tr>
				<%
					out.println("</table>");
				}
				%>
		
		
	
		</center>
	</body>
</html>