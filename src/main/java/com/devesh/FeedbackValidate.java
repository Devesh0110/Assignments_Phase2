package com.devesh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeedbackValidate
 */
public class FeedbackValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		
		request.getRequestDispatcher("index.jsp").include(request,response);
		request.getRequestDispatcher("FeedbackForm.html").include(request,response);
		//request.getRequestDispatcher("productdetails.html").include(request,response);
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}
