package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.User;

public class PasswordPutIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
    String sql="Update dai.user set password=?,salt=?,pass_changer=? where email=? ";
int i;
	public int put(User user) {
	
		// extract
		  String email=user.getEmail();
		  String password=user.getPassword();
		  String salt=user.getSalt();

	       //DRIVER
	       try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, password);
				ps.setString(2, salt);
				ps.setString(3, null);
				ps.setString(4, email);
				i=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
				i=0;
			}
	       
			return i;
			
			
			
		}
		
		
		
		
		
		
		
		
	}

