package com.infnite.train;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TrainSoureD {

	@RequestMapping(value = "/detailsd", method = RequestMethod.POST)
	public String trainsd(HttpServletRequest request, HttpServletResponse response, Model m) throws IOException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");

		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			DataSource datasource = connection.getDataSource();
			con = datasource.getConnection();
			ps = con.prepareStatement("select * from traindetails");
			/*ps.setString(1, source);
			ps.setString(2, destination);*/
			rs = ps.executeQuery();
			out.println("<html><body>");
			out.println("<h3>Train Details<h3>");
			out.println("<table border=1>" 
							+ "<tr>" 
								+ "<td><b>" + "Train no" + "</b></td>" 
								+ "<td><b>" + "Train name"+ "</b></td>" 
								+ "<td><b>" + "Source" + "</b></td>" 
								+ "<td><b>" + "Destination" + "</b></td>"
								+ "<td><b>" + "Departure" + "</b></td>" 
								+ "<td><b>" + "Arrival" + "</b></td>" 
							+ "</tr>");
			
			while (rs.next()) {
				System.out.println(rs.getString(5));
				if (rs.getString(5).equalsIgnoreCase(destination)) 
				{
					
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(5));
					System.out.println(rs.getString(3));
					if (rs.getString(3).equalsIgnoreCase(source)) 
					{
						System.out.println(rs.getString(1));
						PreparedStatement ps2 = con.prepareStatement("select * from traindetails where source=? and destination=?");
						ps2.setString(1, source);
						ps2.setString(2, destination);
						ResultSet rs2 = ps2.executeQuery();
						if (rs2.next()) {

							String msg = "<tr>" 
											+ "<td>" + rs.getString(1) + "</td>" 
											+ "<td>" + rs.getString(2)+ "</td>"
											+ "<td>" + rs.getString(3) + "</td>"
											+ "<td>" + rs.getString(5)+"</td>" 
											+ "<td>" + rs.getString(6) + "</td>" 
											+ "<td>" + rs.getString(9)
									+ "</td>" + "</tr>";
							m.addAttribute("message", msg);
							return "trainsd";
						}

					} else if (rs.getString(4).equalsIgnoreCase(source)) {
						PreparedStatement ps3 = con
								.prepareStatement("select * from traindetails where via=? and destination=?");
						ps3.setString(1, source);
						ps3.setString(2, destination);
						ResultSet rs3 = ps3.executeQuery();
						if (rs3.next()) {

							String msg = "<tr>" 
											+ "<td>" + rs.getString(1) + "</td>" 
											+ "<td>" + rs.getString(2)+ "</td>" 
											+ "<td>" + rs.getString(4) + "</td>" 
											+ "<td>" + rs.getString(5)+ "</td>" 
											+ "<td>" + rs.getString(8) + "</td>" 
											+ "<td>" + rs.getString(9)+ "</td>" 
										+ "</tr>";
							m.addAttribute("message", msg);
							return "trainsd";
						}

					}
				}
				if (rs.getString(3).equalsIgnoreCase(source)) {
					if (rs.getString(4).equalsIgnoreCase(destination)){
							PreparedStatement ps4 = con.prepareStatement("select * from traindetails where source=? and via=? ");
							ps4.setString(1, source);
							ps4.setString(2,destination );
							ResultSet rs4 = ps4.executeQuery();
							if(rs4.next()){
							String msg = "<tr>"
											+"<td>" + rs.getString(1) + "</td>"
											+"<td>" + rs.getString(2) + "</td>"
											+"<td>" + rs.getString(3) + "</td>"
											+"<td>" + rs.getString(4) + "</td>"
											+"<td>" + rs.getString(6) + "</td>"
											+"<td>" + rs.getString(7) + "</td>"
										+"</tr>";
							m.addAttribute("message",msg);
							return "trainsd";
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
