package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Collaborator;
import models.Tutor;
import models.User;

public class CollabGetByIDUimp {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.collaborator where id_user=?";
	ResultSet rs;
	Collaborator c=new Collaborator(1,1,"lol",1,"lol","lol","lol","lol","lol",2);
	public Collaborator Get(User user) {
		
		// TODO Auto-generated method stub
		
			int id_user=user.getID();
			//Connection to database and store value in
					try {
						Class.forName(DRIVER);
						Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1,id_user);
				            rs=ps.executeQuery();
				            rs.next();
				        c.setAddress(rs.getString("address"));
				        c.setCounty(rs.getString("county"));
				        c.setDistrict(rs.getString("district"));
				        c.setId_collaborator(rs.getInt("id_collaborator"));
				        c.setId_user(rs.getInt("id_user"));
				        c.setName(rs.getString("name"));
				        c.setNif(rs.getInt("nif"));
				        c.setPhone_number(rs.getInt("phone_number"));
				        c.setPost_code(rs.getString("post_code"));
				        c.setType(rs.getString("type"));
				        
				            
						
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					return c;
					
				}
	
}
