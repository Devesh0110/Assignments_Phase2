package com.devesh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FeedbackFilter
 */
@WebFilter("/validate")
public class FeedbackFilter implements Filter {
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	request.getRequestDispatcher("index.jsp").include(request,response);
	request.getRequestDispatcher("FeedbackForm.html").include(request,response);
	String username=request.getParameter("useremail");
	String desc=request.getParameter("productdesc");
	String rating=request.getParameter("rating");
	String productname=request.getParameter("productname");
	//validating email
	final Pattern x = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		    Matcher matcher = x.matcher(username);
		        
	if(username.equals("")||desc.equals("")||productname.equals("")) {
		out.write("<h2 style='color:red'>Blank Input not allowed</h2>");
	}
	else if(Integer.parseInt(rating)<0||Integer.parseInt(rating)>10) {
		out.write("<h2 style='color:red'>Please enter correct value of rating</h2>");
	}
	else if(!matcher.find()) {
		out.write("<h2>Wrong email format</h2>");
	}
	else {
		out.write("<h2 style='color:green'>FeedBack Received</h2>");
		chain.doFilter(request,response);
	}
	
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
