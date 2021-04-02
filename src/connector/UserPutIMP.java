package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.User;

public class UserPutIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
String sql="Update heroku_062c2f3cf2f9e9d.user set email=?,login_type=? where id_user=? ";
int i;
	public int UserDoPut(User f) {
		// extract
	   int id_user=f.getID();
       String email=f.getEmail();
       String login_type=f.loginT();
       //DRIVER
       try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2,login_type);
			ps.setInt(3, id_user);
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
       
		return i;
		
		
		
	}

}