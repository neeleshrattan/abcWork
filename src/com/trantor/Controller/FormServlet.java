package com.trantor.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.trantor.Service.LoginBean;
import com.trantor.dao.ConnectionProvider;

public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String desc[] = request.getParameterValues("desc");

		String item[] = request.getParameterValues("item");

		String bywhen[] = request.getParameterValues("bywhen");
		String bywhom[] = request.getParameterValues("bywhom");

		String dateCal[] = request.getParameterValues("date");

		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		String currDate = sdf.format(date).toString();
		HttpSession session = request.getSession();
	int userid=(Integer)	session.getAttribute("userid");
		
	System.out.println(userid);
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement statement = null;
		System.out.print("\nConnecting to database..." + con);
		try {
			for (int i = 0; i < desc.length; i++) {
				System.out.println(desc[i]);
				statement = con
						.prepareStatement("insert into trantor_ticket (userid,description,date) values (?,?,?)");
				statement.setInt(1, userid);
				statement.setString(2, desc[i]);
				statement.setString(3, currDate);
				statement.executeUpdate();

			}
	
			statement.close();

			for (int i = 0; i < item.length; i++) {
				statement = con
						.prepareStatement("insert into trantor_actionItem (item,bywhen,bywhom) values (?,?,?)");

				statement.setString(1, item[i]);
				statement.setString(2, bywhom[i]);
				statement.setString(3, dateCal[i]);
				statement.executeUpdate();

			}
	

			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("DisplayMOM.jsp");
		rd.forward(request, response);
		
		/*
		 * Date date = new Date(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("MM/dd/yy"); String currDate =
		 * sdf.format(date).toString();
		 * 
		 * try {
		 * 
		 * ActionItemBean actionItemBean=new ActionItemBean();
		 * actionItemBean.setActionItemName(request.getParameter("item"));
		 * actionItemBean.setByWhen(request.getParameter("bywhen"));
		 * actionItemBean.setByWhom(request.getParameter("bywhom"));
		 * 
		 * actionItemBean=ActionDao.setActionItem(actionItemBean);
		 * 
		 * 
		 * if(actionItemBean.isValid()) {
		 * 
		 * RequestDispatcher rd=request.getRequestDispatcher("MomUI.jsp");
		 * rd.forward(request, response);
		 * 
		 * 
		 * } else { response.sendRedirect("Login.jsp"); }
		 * 
		 * 
		 * TicketBean ticketBean = new TicketBean();
		 * ticketBean.setDate(currDate);
		 * ticketBean.setDescription(request.getParameter("desc"));
		 * 
		 * ticketBean = TicketDao.ticket(ticketBean);
		 * 
		 * if (ticketBean.isValid()) {
		 * 
		 * RequestDispatcher rd=request.getRequestDispatcher("DisplayMOM.jsp");
		 * rd.forward(request, response); }
		 * 
		 * else response.sendRedirect("Login.jsp"); }
		 * 
		 * catch (Throwable theException) { System.out.println(theException); }
		 */
		}
}



