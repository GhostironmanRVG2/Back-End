package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class CheckPassIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.user where email=?";
	User k=new User();
	public User check(User l) {
		
		String email=l.getEmail();
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		    PreparedStatement ps=con.prepareStatement(sql);
		    ps.setString(1,email);
		    ResultSet rs = ps.executeQuery();

		    if(rs.next()) {
		    k.setPass_changer(rs.getString("pass_changer"));
		    }else {
		    	
		    	k.setPass_changer(null);
		    	
		    }
		    
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	
	
	
	
	
	
	return k;
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


