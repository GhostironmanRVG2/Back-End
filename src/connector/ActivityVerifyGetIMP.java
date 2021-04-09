package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Subscription;

public class ActivityVerifyGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.subscription where id_child=? and id_activity=?";
	int i;
	public int verify(Subscription subs) {
		int id_child=subs.getId_child();
		int id_activity=subs.getId_activity();
		
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		    PreparedStatement ps=con.prepareStatement(sql);
		    ps.setInt(1,id_child);
		    ps.setInt(2,id_activity);
		
		    ResultSet rs = ps.executeQuery();
			if(rs.next()==false) {
				
			i=0;
	
				
			}else {
				
				
				i=1;
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
            
          
	
	
	
	
	
	
	
	
	
	
	return i;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
