package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Activity;

public class ActivityPutIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
String sql="Update heroku_062c2f3cf2f9e9d.Activity set id_request=?,id_reward=? where id_activity=? ";
int i;
	public int ActivityDoPut(Activity a) {
		// extract
	   int id_activity=a.getId_activity();
       int id_request=a.getId_request();
	   int id_reward=a.getId_reward();
       //DRIVER
       try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id_request);
			ps.setInt(2,id_reward);
			ps.setInt(3, id_activity);
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
       
		return i;
		
		
		
	}

}
