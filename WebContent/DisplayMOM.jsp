<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@page import="java.sql.*"%>
	<%@page import="com.trantor.dao.*;"%>

	<%
		Connection con = ConnectionProvider.getConnection();
		Statement ps = con.createStatement();

		String sql = ("select * from trantor_ticket");
		ResultSet rs = ps.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
	%>
	<table border="1" align="center">

		<tr>
			<td><b> <%
 	out.print(rsmd.getColumnName(1).toUpperCase());
 %>
			</b></td>
			<td><b> <%
 	out.print(rsmd.getColumnName(2).toUpperCase());
 %>
			</b></td>
			<td><b> <%
 	out.print(rsmd.getColumnName(3).toUpperCase());
 %>
			</b></td>
			<td><b> <%
 	out.print(rsmd.getColumnName(4).toUpperCase());
 %>
			</b></td>
		</tr>


		<%
			while (rs.next()) {
		%>



		<tr>
			<td>
				<%
					out.print(rs.getInt(1));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(2));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(3));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(4));
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>





</body>
</html>