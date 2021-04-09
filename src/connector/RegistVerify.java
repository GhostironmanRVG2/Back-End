package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class RegistVerify {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.user where email=?";
	int i;
	
	
	
	
	public int Verify(User user) {
		String email=user.getEmail();
	
			try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			    PreparedStatement ps=con.prepareStatement(sql);
			    ps.setString(1,email);
			
			    ResultSet rs = ps.executeQuery();
				if(rs.next()==false) {
					
				i=0;
		
					
				}else {
					
					
					i=1;
				}
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
			
	            
	          
		
		
		
		
		
		
		
		
		
		
		return i;
	}

}
