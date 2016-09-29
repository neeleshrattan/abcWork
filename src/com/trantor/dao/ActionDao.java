package com.trantor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.trantor.Service.ActionItemBean;

public class ActionDao {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static Statement stmt = null;

	public static ActionItemBean setActionItem(ActionItemBean actionItemBean) {


		String actionName = actionItemBean.getActionItemName();
		String actionByWhen = actionItemBean.getByWhen();
		String actionByWhom = actionItemBean.getByWhom();
		

		String insertQuery = "insert into trantor_actionItem(item,bywhen,bywhom) values('"
				+ actionName
				+ "','"
				+ actionByWhen+"','"+actionByWhom+"')";

		try {
			// connect to DB
			currentCon = ConnectionProvider.getConnection();
			stmt = currentCon.createStatement();
			int nor = stmt.executeUpdate(insertQuery);

			if (nor == 0) {
				System.out
						.println("Sorry, your action has not been performed!!");
				actionItemBean.setValid(false);
			}

			else if (nor > 0) {

				actionItemBean.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}

		// some exception handling
		finally {
			
		}

		return actionItemBean;

	}

}
