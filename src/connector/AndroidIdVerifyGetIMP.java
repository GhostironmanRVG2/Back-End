package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class AndroidIdVerifyGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
		String sql="Select * from dai.user where email=?";
		ResultSet rs;
		User o=new User();
	public User get(User j2) {
		String email=j2.getEmail();
	
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,email);
	            rs=ps.executeQuery();
	            if(rs.next()) {

               o.setAndroid_ID(rs.getString("Android_ID"));
	            }else {
	            	
	            o.setAndroid_ID(null);	
	            	
	            	
	            }
	            
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return o;
		
	}
		
		
		
		
		
		
		
		
		
		
		
	

}
