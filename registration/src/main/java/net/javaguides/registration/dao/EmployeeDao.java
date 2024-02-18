package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import net.javaguides.registration.model.Employee;

public class EmployeeDao {
public String create(Employee e)throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
			PreparedStatement ps=con.prepareStatement("insert into dataOfPeople values(?,?,?,?,?,?)");
			ps.setString(1,e.getUserName());
			ps.setString(2,e.getFirstname());
			ps.setString(3,e.getLastname());
			ps.setString(4,e.getPhoneNumber());
			ps.setString(5,e.getEmail());
			ps.setString(6,e.getPassword());
			int n=ps.executeUpdate();
			if(n>0) {
				return "Success";
			}
		}
		catch(Exception c) {
			c.printStackTrace();
		}
		return "Failure";
}

}
