package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Collaborator;
import models.Fact;

public class CollabPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Insert into heroku_062c2f3cf2f9e9d.collaborator (id_user,name,nif,type,address,county,district,post_code,phone_number) VALUE (?,?,?,?,?,?,?,?,?)";
	int i;
		public int insertCollab(Collaborator c) {
			// TODO Auto-generated method stub
			
			
		   //Connection to database and store value in
			try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, c.getId_user());
				ps.setString(2,c.getName());
				ps.setInt(3, c.getNif());
				ps.setString(4, c.getType());
				ps.setString(5, c.getAddress());
				ps.setString(6, c.getCounty());
				ps.setString(7, c.getDistrict());
				ps.setString(8, c.getPost_code());
				ps.setInt(9,c.getPhone_number());
				i=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				i=0;
			}
			return i;
			
		}
}
