package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class UserGetNonEmailIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.user where id_user=?";
	ResultSet rs;
	String newo;
	public String getByID(User o) {
		// TODO Auto-generated method stub
		
			int id=o.getID();
			//Connection to database and store value in
					try {
						Class.forName(DRIVER);
						Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1,id);
				            rs=ps.executeQuery();
				           if(rs.next()) {
				        	newo= String.valueOf(rs.getInt("id_user"));
				        	   
				           }else {
				        	   
				           newo=null;	   
				        	   
				        	   
				        	   
				           }
				            
						
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					return newo;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
