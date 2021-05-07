package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Child;

public class ChildGetByIdIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select c.birth_date,c.id_child,c.name,c.phone_number_tutor,c.photo,c.total_points,u.status as state,c.id_user from dai.Child c join dai.user u on c.id_user=u.id_user  where c.id_user=?";
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
			            newo.setState(rs.getString("state"));
			            
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				return newo;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	}

