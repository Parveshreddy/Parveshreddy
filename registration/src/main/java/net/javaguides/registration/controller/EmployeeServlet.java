package net.javaguides.registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.dao.EmployeeDao;
import net.javaguides.registration.model.Employee;

import java.io.IOException;


@WebServlet("/jai")

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userName = request.getParameter( "userName");
	    String firstname  = request.getParameter("firstname");
	    String lastname  = request.getParameter("lastname");
	    String phoneNumber  = request.getParameter("phoneNumber");
	    String Email   = request.getParameter("Email");
	    String password   = request.getParameter("password");
	    System.out.println(firstname);
		   Employee st=new Employee();
		   st.setUserName(userName);
		   st.setFirstname(firstname);
		   st.setLastname(lastname);
		   st.setPhoneNumber(phoneNumber);
		   st.setEmail(Email);
		   st.setPassword(password);
		   EmployeeDao sd=new EmployeeDao();
		   try {
		   String status=sd.create(st);
		   if(status.equals("Success")) {
			   RequestDispatcher rd=request.getRequestDispatcher("/login.html");  
		        rd.include(request, response);
			   System.out.println("inserted");
		   }
		   else {
			   RequestDispatcher rd=request.getRequestDispatcher("/Registration.html");  
		        rd.include(request, response);
			   System.out.println("failed to inserted");
		   }
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		  
		   
		}

	}
