
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Subscription;

public class SubscriptionStatePutIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.subscription set state=? where id_child=? and id_activity=? ";
int i;
	public int put(Subscription s) {
		  int id_child=s.getId_child();
		  int id_activity=s.getId_activity();
		  String state=s.getState();
		
	       //DRIVER
	       try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,state);
				ps.setInt(2,id_child);
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