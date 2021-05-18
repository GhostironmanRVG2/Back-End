
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Collaborator;

public class CollaboratorPutByCollaboratorIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://188.82.156.135:3306";
	String USER="monkey";
	String PASSWORD="monkey";
String sql="Update dai.collaborator c, dai.user u set c.name=?,c.address=?,c.county=?,c.district=?,c.post_code=?,c.nif=?,c.phone_number=?, u.email=?,c.id_user=? where c.id_user = u.id_user and c.id_collaborator=? ";
int i;
	public int Put(Collaborator c) {
		// extract
	   String name = c.getName();
	   String email = c.getEmail();
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
			ps.setString(2 , address);
			ps.setString(3 , county);
			ps.setString(4 , district);
			ps.setString(5 , post_code);
			ps.setInt(6 , nif);
			ps.setInt(7 , phone_number);
			ps.setString(8 , email);
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
