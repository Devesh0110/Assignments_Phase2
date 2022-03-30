package com.simplilearn.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.webapp.model.Customer;
import com.simplilearn.webapp.util.HibernateSessionUtil;

@WebServlet("/list-customer")
public class ListCustomer extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.jsp").include(request, response);

		try {
			// 1. build hibernate session factory
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			
			// 2. create session object
			Session session = factory.openSession();
			
			// 3. read products
			List<Customer> obj = session.createQuery("from Customer").list();
			
			//show data as table.
			out.print("<h1> Customer List :- </h1>");
			
			out.print("<style> table,td,th {"
					+ "border:2px solid red;"
					+ "padding: 10px; "
					+ "}</style>");
			out.print("<table >");
			out.print("<tr>");
				out.print("<th> Customer Id</th>");
				out.print("<th> Customer Name</th>");
				out.print("<th> Customer Age</th>");
				out.print("<th> Customer Description</th>");
				out.print("<th> Added At </th>");
				out.print("<th> Modified At </th>");
			out.print("</tr>");
			
			for(Customer p : obj) {
				out.print("<tr>");
				out.print("<td>"+p.getId()+"</td>");
				out.print("<td>"+p.getName()+"</td>");
				out.print("<td>"+p.getAge()+"</td>");
				out.print("<td>"+p.getDesc()+"</td>");
				out.print("<td>"+p.getCreatedAt()+"</td>");
				out.print("<td>"+p.getModifiedAt()+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			// 3. close session
			session.close();
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}