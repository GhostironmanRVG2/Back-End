package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Subscription;

public class SubscriptionDeleteIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="delete from dai.subscription where id_activity = ? and id_child = ?";
	int i;
	int idc;
	int ida;
	public int SDelete(Subscription s) {
		ida=s.getId_activity();
		System.out.println(ida);
		idc=s.getId_child();
		System.out.println(idc);
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, ida);
			ps.setInt(2,  idc);
			i=ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
		return i;
		
	}
		
		
		
		
		
		

}