package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Subscription;

public class SubscriptionPutIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
String sql="Update heroku_062c2f3cf2f9e9d.subscription set evaluation=? where id_child=? and id_activity=? ";
int i;
	public int put(Subscription s) {
		  int id_child=s.getId_child();
		  int id_activity=s.getId_activity();
		  String evaluation=s.getEvaluation();
		
	       //DRIVER
	       try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,evaluation);
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

