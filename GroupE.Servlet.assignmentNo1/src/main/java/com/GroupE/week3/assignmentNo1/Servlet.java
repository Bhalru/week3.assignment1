package com.GroupE.week3.assignmentNo1;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	
 * @author login UserName and Password
 *
 */
@WebServlet("Servlet")
	public class Servlet extends HttpServlet{
		private static final long serialVersionUID = 1L;

		/**
		 * HttpServlet#HttpServlet()
		 */
		public Servlet() {
			// TODO Auto-generated constructor stub
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			// response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			// storing the user given values
			String n = request.getParameter("user");
			String p = request.getParameter("pass");

			// validating the UserName and password
			if (n.isEmpty()) {
				out.print("Please Enter UserName");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			} else if (p.isEmpty()) {
				out.print("Please Enter Password");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			} else if (p.equals("class")) {
				RequestDispatcher rd = request.getRequestDispatcher("Studentform");
				rd.forward(request, response);
			} else {
				out.print("Wrong Password");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			}

		}
	}
