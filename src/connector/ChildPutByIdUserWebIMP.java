package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Child;

public class ChildPutByIdUserWebIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.child set name=?,birth_date=?,phone_number_tutor=?,total_points=? where id_user=? ";
String sql2="Update dai.user set status=? where id_user=? ";
int i;
	public int ChildDoPut(Child c) {
	
		// extract
				String name=c.getName();
				String birth_date=c.getBirth_date();
				int id_child=c.getId_child();
				int id_user=c.getId_user();
				int phone_number_tutor=c.getPhone_number_tutor();
				int total_points=c.getTotal_points();
				String status=c.getStatus();
				
				
		       //DRIVER
		       try {
					Class.forName(DRIVER);
					Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, name);
					ps.setString(2, birth_date);
					ps.setInt(3, phone_number_tutor);
					ps.setInt(4, total_points);
					ps.setInt(5, id_user);
					i=ps.executeUpdate();
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					i=0;
				}
		       
		       try {
					Class.forName(DRIVER);
					Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
					PreparedStatement ps=con.prepareStatement(sql2);
					ps.setString(1, status);
					ps.setInt(2, id_user);
					i=ps.executeUpdate();
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					i=0;
				}
		       
		       
		       
		       
		       
		       
		       
				return i;
				
				
				
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

