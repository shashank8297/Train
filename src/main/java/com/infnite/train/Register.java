package com.infnite.train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Register {

	@RequestMapping(value="/registerto", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		System.out.print("Resi");
		Connection con = null;
		PreparedStatement ps= null;
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		try {
			DataSource datasource = connection.getDataSource(); 
			con = datasource.getConnection();
			ps = con.prepareStatement("insert into user values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setString(3, email);
			System.out.println("it is here");
			int x = ps.executeUpdate();
			if(x!= 0){
				return "successR";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// on.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
