package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Fact;

public class FactDeleteIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="delete from heroku_062c2f3cf2f9e9d.fact where id_fact = ?";
	int i;
	int id;
	public int FDelete(Fact f) {
		id=f.getId_fact();
		System.out.println(id);
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			i=ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
		return i;
		
	}
		
		
		
		
		
		

}
