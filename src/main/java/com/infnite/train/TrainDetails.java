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
public class TrainDetails {

	@RequestMapping(value="/traindetails", method=RequestMethod.POST)
	public String traindetails(HttpServletRequest request, HttpServletResponse response,Model m) throws IOException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int trainno = Integer.parseInt(request.getParameter("trainno"));
		//String destination = request.getParameter("destination");
		try{
			System.out.print("t1");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			DataSource datasource=connection.getDataSource();
			con=datasource.getConnection();
			ps=con.prepareStatement("select * from traindetails where trainno=?");
			ps.setInt(1,trainno);
			rs = ps.executeQuery();

			System.out.print("t2");
			/*out.println("<html><body>");
			out.println("<h3>Train Details<h3>");
			out.println("<table border=1>"
					+ "<tr>"+ "<td><b>"+"Train no"+"</b></td>"+ "<td><b>"+"Train name"+"</b></td>"+ "<td><b>"+"Source"+"</b></td>"+"<td><b>"+"Destination"+"</b></td>"+"<td><b>"+"Start Time"+"</b></td>"+"<td><b>"+"End Time"+"</b></td>"+"</tr>");
			*/
			if(rs.next())
			{

				System.out.print("t3");
				String msg = "<tr>"
								+"<td>" + rs.getString(1) + "</td>"
								+"<td>" + rs.getString(2) + "</td>"
								+"<td>" + rs.getString(3) + "</td>"
								+"<td>" + rs.getString(4) + "</td>"
								+"<td>" + rs.getString(5) + "</td>"
								+"<td>" + rs.getString(6) + "</td>"
								+"<td>" + rs.getString(7) + "</td>" 
								+"<td>" + rs.getString(8) + "</td>"
								+"<td>" + rs.getString(9) + "</td>"
							+"</tr>";
				m.addAttribute("message", msg);
				return "trainno";
			}
			//ps.setInt(1,Integer.parseInt(request.getParameter("trainno")));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}