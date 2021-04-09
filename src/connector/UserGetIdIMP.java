package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class UserGetIdIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
		String sql="Select * from dai.user where email=?";
		ResultSet rs;
		User o=new User();
	public User getByID(User user) {
		// TODO Auto-generated method stub
	
		String e=user.getEmail();
		//Connection to database and store value in
				try {
					Class.forName(DRIVER);
					Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1,e);
			            rs=ps.executeQuery();
			            if(rs.next()) {
			            o.setEmail(rs.getString("email"));
			            o.setLoginT(rs.getString("login_type"));
			            o.setID(rs.getInt("id_user"));
			            }else {
			            	
			            o.setEmail(null);	
			            	
			            	
			            }
			            
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				return o;
				
			}
		
		
		
		
		
		
	}

