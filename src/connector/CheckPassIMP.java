package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class CheckPassIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.user where email=?";
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


