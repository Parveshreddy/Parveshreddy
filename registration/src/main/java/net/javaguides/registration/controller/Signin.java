package net.javaguides.registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.dao.EmployeeDao;
import net.javaguides.registration.dao.SigninDao;
import net.javaguides.registration.model.Employee;

import java.io.IOException;

@WebServlet("/index")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName  = request.getParameter("userName");
	    String password  = request.getParameter("password");
	    System.out.println(userName);
		   Employee st=new Employee();
		   st.setUserName(userName);
		   st.setPassword(password);
		   SigninDao sd=new SigninDao();
		   try {
			   String status=sd.create(st);
			   if(status.equals("Success")) {
				   RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
			        rd.include(request, response);
				   System.out.println("inserted");
			   }
		   else {
			   System.out.println("failed to inserted");
		   }
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
	}
}
		  
		   
		
	


