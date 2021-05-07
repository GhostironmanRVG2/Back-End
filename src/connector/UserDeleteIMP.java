package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.User;

public class UserDeleteIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.user set status='Inactive' where id_user=? ";
int i;
	public int UserDoPut(User f) {
		
		// extract
		   int id_user=f.getID();
	
	       //DRIVER
	       try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id_user);
				i=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				i=0;
			}
	       
			return i;
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
}
