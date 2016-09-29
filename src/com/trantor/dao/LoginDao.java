package com.trantor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.trantor.Service.LoginBean;

public class LoginDao {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static Statement stmt = null;

	public static LoginBean login(LoginBean bean) {

		String username = bean.getUsername();
		String password = bean.getPassword();

		String searchQuery = "select * from trantor_login where username='"
				+ username + "' AND password='" + password + "'";

		System.out.println("Your username is " + username);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionProvider.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out
						.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			}

			// if user exists set the isValid variable to true
			else if (more) {
				String username1 = rs.getString("username");
				String password1 = rs.getString("password");
				String client_name=rs.getString("client_name");
				String name=rs.getString("name");
				String team_name=rs.getString("team");
				int userid=rs.getInt("userid");
				
				System.out.println("Welcome " + username1);
				bean.setName(name);
				bean.setTeam_name(team_name);
				bean.setClient_name(client_name);
				bean.setUsername(username1);
				bean.setPassword(password1);
				bean.setUserid(userid);
				bean.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}

		// some exception handling
		finally {
/*
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {

			}
			try {
				if (currentCon != null) {
					currentCon.close();
				}
			} catch (Exception e) {

			}
*/
		}

		return bean;
	}
}