package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Fact;

public class FactPutIMP {
String DRIVER="com.mysql.jdbc.Driver";
String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
String USER="b59f6070236844";
String PASSWORD="612a84b4";
String sql="Update heroku_062c2f3cf2f9e9d.fact set name=?,description=?,photo=? where id_fact=? ";
int i;
	public int FactDoPut(Fact f) {
		// extract
	   int id_fact=f.getId_fact();
       String name=f.getName();
       String description=f.getDescription();
       String photo=f.getPhoto();
       //DRIVER
       try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2,description);
			ps.setString(3, photo);
			ps.setInt(4, id_fact);
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
       
		return i;
		
		
		
	}

}
