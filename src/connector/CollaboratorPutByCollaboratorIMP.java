
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Collaborator;

public class CollaboratorPutByCollaboratorIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.collaborator set name=?,type=?,address=?,county=?,district=?,post_code=?,nif=?,phone_number=?,id_user=? where id_collaborator=? ";
int i;
	public int Put(Collaborator c) {
		// extract
	   String name = c.getName();
	   String type = c.getType();
	   String address = c.getAddress();
	   String county = c.getCounty();
	   String district = c.getDistrict();
	   String post_code = c.getPost_code();
	   int nif = c.getNif();
	   int phone_number = c.getPhone_number();
	   int id_user = c.getId_user();
	   int id_collaborator = c.getId_collaborator();
	   
       //DRIVER
       try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1 , name);
			ps.setString(2 , type);
			ps.setString(3 , address);
			ps.setString(4 , county);
			ps.setString(5 , district);
			ps.setString(6 , post_code);
			ps.setInt(7 , nif);
			ps.setInt(8 , phone_number);
			ps.setInt(9 , id_user);
			ps.setInt(10 , id_collaborator);
			i=ps.executeUpdate();
			

			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
       
		return i;
		
		
		
	}

}