package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Activity;

public class ActivityPutStateIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.activity set state=? where id_activity=?";
int i;
	public int ActivityDoPut(Activity a) {
		// TODO Auto-generated method stub
	  String state=a.getState();
	  int id_activity=a.getId_activity();
		
		
		
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,state);
			ps.setInt(2,id_activity);
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
       
		return i;
		
	}

}
