package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.registration.model.Employee;

public class SigninDao {
	public String create(Employee s)throws SQLException {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		PreparedStatement ps=con.prepareStatement("select * from dataOfPeople where userName=? and password=?");
		ps.setString(1,s.getUserName());
		ps.setString(2,s.getPassword());
		ResultSet n = ps.executeQuery();
		if (n.next()) {
		    // If there is at least one row in the result set, return "Success"
		    return "Success";
		}

		
	}
	catch(Exception c) {
		c.printStackTrace();
	}
	return "Failure";
}

}
