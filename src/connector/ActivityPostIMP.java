package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Activity;

public class ActivityPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Insert into heroku_062c2f3cf2f9e9d.activity (id_request,id_reward) VALUE (?,?)";
	int i;
		public int insertActivity(Activity activity) {
			// TODO Auto-generated method stub
			int req=activity.getId_request();
			int rew=activity.getId_reward();
			
		   //Connection to database and store value in
			try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,req);
				ps.setInt(2,rew);
				i=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				i=0;
			}
			return i;
			
		}
}