package com.trantor.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class Dbconnection 
{
	  static Connection con=null;
	  final static String url="jdbc:mysql://localhost:3306/MOM";
	  final static String user="root";
	  final static String password="root";
	  final static String className="com.mysql.jdbc.Driver";
	  
public static Connection createconnection()
{
 
  try
  {
  try
  {
  	Class.forName(className);
  }
  catch (ClassNotFoundException e)
  {
  e.printStackTrace();
  }
  con = DriverManager.getConnection(url, user, password);
  }
  catch (Exception e)
  {
  e.printStackTrace();
  }

  return con;
  }
}
	