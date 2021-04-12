package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Child;

public class ChildUploadPutIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.child set photo=? where id_child=? ";
int i;
	public int ChildDoPut(Child c) {
		// extract
				int id_child=c.getId_child();
				String photo=c.getPhoto();
				
				
				
		       //DRIVER
		       try {
					Class.forName(DRIVER);
					Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, photo);
					ps.setInt(2, id_child);
					i=ps.executeUpdate();
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					i=0;
				}
		       
				return i;
				
				
				
			}

}
