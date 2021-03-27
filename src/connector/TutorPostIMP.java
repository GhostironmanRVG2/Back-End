package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Collaborator;
import models.Tutor;

public class TutorPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Insert into heroku_062c2f3cf2f9e9d.tutor (id_user,name,birth_date,address,district,county,post_code,phone_number) VALUE (?,?,?,?,?,?,?,?)";
	int i;
		public int insertCollab(Tutor t) {
			// TODO Auto-generated method stub
			
			
		   //Connection to database and store value in
			try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, t.getId_user());
				ps.setString(2,t.getName());
				ps.setString(3, t.getBirth_date());
				ps.setString(4, t.getAddress());
				ps.setString(5, t.getDistrict());
				ps.setString(6, t.getCounty());
				ps.setString(7, t.getPost_code());
				ps.setInt(8, t.getPhone_number());
				i=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				i=0;
			}
			return i;
			
		}
}

