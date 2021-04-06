package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Child;

public class ChildPutByIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
String sql="Update heroku_062c2f3cf2f9e9d.child set name=?,birth_date=? where id_child=? ";
int i;
public int ChildDoPut(Child c) {
	
	
	// extract
			String name=c.getName();
			String birth_date=c.getBirth_date();
			int id_child=c.getId_child();
		
			
			
			
	       //DRIVER
	       try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, birth_date);
				ps.setInt(3, id_child);
				i=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				i=0;
			}
	       
			return i;
			
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


