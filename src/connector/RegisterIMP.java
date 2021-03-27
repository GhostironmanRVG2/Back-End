package connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.User;

public class RegisterIMP {
String DRIVER="com.mysql.jdbc.Driver";
String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
String USER="b59f6070236844";
String PASSWORD="612a84b4";
String sql="Insert into heroku_062c2f3cf2f9e9d.user (email,password,salt,login_type,status) VALUE (?,?,?,?,?)";
int i;
	public int registerUser(User user) {
		// TODO Auto-generated method stub
		String status=user.getStatus();
		String e=user.getEmail();
		String p=user.getPassword();
		String s=user.getSalt();
		String lt=user.loginT();
		
	   //Connection to database and store value in
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,e);
			ps.setString(2,p);
			ps.setString(3,s);
			ps.setString(4, lt);
			ps.setString(5, status);
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
		return i;
		
	}

}
