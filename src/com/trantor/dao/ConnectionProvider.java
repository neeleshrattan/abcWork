package com.trantor.dao;

import java.sql.*;

import static com.trantor.dao.Provider.*;

public class ConnectionProvider {
	private static Connection con = null;
	static {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_URL, USERNAME,
					PASSWORD);
		} catch (Exception e) {
		}
	}

	public static Connection getConnection() {
		return con;
	}

}