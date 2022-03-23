package com.devesh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Feedback extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		
		request.getRequestDispatcher("index.jsp").include(request,response);
		request.getRequestDispatcher("FeedbackForm.html").include(request,response);
		
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("index.jsp").include(request,response);
		request.getRequestDispatcher("FeedbackForm.html").include(request,response);
		String username=request.getParameter("useremail");
		String desc=request.getParameter("productdesc");
		String rating=request.getParameter("rating");
		String productname=request.getParameter("productname");
		
		if(username.equals("")||desc.equals("")||productname.equals("")) {
			out.write("<h2 style='color:red'>Blank Input not allowed</h2>");
		}
		else if(Integer.parseInt(rating)<0||Integer.parseInt(rating)>10) {
			out.write("<h2 style='color:red'>Please enter correct value of rating</h2>");
		}
		else {
			out.write("<h2 style='color:green'>FeedBack Received</h2>");
		}
		
	}
	
}
