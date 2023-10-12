package com.infnite.train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login {
	@RequestMapping(value = "/loginto", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("1");
		Connection con = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			DataSource datasource = connection.getDataSource();
			con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("2");
				return "home";
			} else {
				return "fail";
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return "fail";
	}
}
