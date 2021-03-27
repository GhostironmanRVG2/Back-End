package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class RegistVerify {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.user where email=?";
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
