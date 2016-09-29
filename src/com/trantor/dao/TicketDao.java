package com.trantor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.trantor.Service.TicketBean;

public class TicketDao {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static Statement stmt = null;

	public static TicketBean ticket(TicketBean tickbean) {


		String desc = tickbean.getDescription();
		String date = tickbean.getDate();
		

		String insertQuery = "insert into trantor_mom(description,date) values('"
				+ desc
				+ "','"
				+ date+"')";

		try {
			// connect to DB
			currentCon = ConnectionProvider.getConnection();
			stmt = currentCon.createStatement();
			int nor = stmt.executeUpdate(insertQuery);

			if (nor == 0) {
				System.out
						.println("Sorry, your ticket doesnot insert!!");
				tickbean.setValid(false);
			}

			else if (nor > 0) {

				tickbean.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}

		// some exception handling
		finally {
			
		}

		return tickbean;

	}
}
