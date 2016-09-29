package com.trantor.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trantor.Service.LoginBean;
import com.trantor.dao.LoginDao;

public class LoginServlet extends HttpServlet {
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
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {

			LoginBean loginBean = new LoginBean();
			loginBean.setUsername(request.getParameter("username"));
			loginBean.setPassword(request.getParameter("password"));
			loginBean.setTeam_name(request.getParameter("team"));

			loginBean = LoginDao.login(loginBean);

			if (loginBean.isValid()) {

				HttpSession session = request.getSession(true);
				session.setAttribute("user", loginBean);
				System.out.println(session.getId());
				
				int valueId=loginBean.getUserid();
				
				System.out.println(valueId);
				
				
				session.setAttribute("userid", valueId);
				 
				
				
				RequestDispatcher rd=request.getRequestDispatcher("MomUI.jsp");
				rd.forward(request, response);
			}

			else
			{
				response.sendRedirect("Login.jsp");
			}
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}

	}

}