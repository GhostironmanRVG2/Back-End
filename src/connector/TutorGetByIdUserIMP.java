package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Tutor;
import models.User;

public class TutorGetByIdUserIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.tutor where id_user=?";
	ResultSet rs;
	Tutor o=new Tutor(4,"lol","lol","lol","lol","lol","lol",4,4);
	public Tutor Get(User user) {
		
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
				        o.setAddress(rs.getString("address"));
				        o.setBirth_date(rs.getString("birth_date"));
				        o.setCounty(rs.getString("county"));
				        o.setDistrict(rs.getString("district"));
				        o.setId_tutor(rs.getInt("id_tutor"));
				        o.setId_user(id_user);
				        o.setName(rs.getString("name"));
				        o.setPhone_number(rs.getInt("phone_number"));
				        o.setPost_code(rs.getString("post_code"));
				            
						
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					return o;
					
				}
	
}
