package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Child;

public class ChildPutIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.child set name=?,birth_date=?,photo=?,id_user=?,phone_number_tutor=?,total_points=? where id_child=? ";
int i;
	public int ChildDoPut(Child c) {
		// extract
		String name=c.getName();
		String birth_date=c.getBirth_date();
		String photo=c.getPhoto();
		int id_child=c.getId_child();
		int id_user=c.getId_user();
		int phone_number_tutor=c.getPhone_number_tutor();
		int total_points=c.getTotal_points();
		
		
		
       //DRIVER
       try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, birth_date);
			ps.setString(3, photo);
			ps.setInt(4, id_user);
			ps.setInt(5, phone_number_tutor);
			ps.setInt(6, total_points);
			ps.setInt(7, id_child);
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
       
		return i;
		
		
		
	}

}
