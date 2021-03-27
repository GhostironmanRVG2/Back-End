package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Child;

public class ChildGetByIdIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.Child where id_user=?";
	Child newo=new Child();
	ResultSet rs;
	public Child Get(Child chi) {
		int id=chi.getId_user();
		//Connection to database and store value in
				try {
					Class.forName(DRIVER);
					Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,id);
			            rs=ps.executeQuery();
			            rs.next();
			            newo.setBirth_date(rs.getString("birth_date"));
			            newo.setId_child(rs.getInt("id_child"));
			            newo.setId_user(id);
			            newo.setName(rs.getString("name"));
			            newo.setPhone_number_tutor(rs.getInt("phone_number_tutor"));
			            newo.setPhoto(rs.getString("photo"));
			            newo.setTotal_points(rs.getInt("total_points"));
			            
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				return newo;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	}

