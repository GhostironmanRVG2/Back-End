package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Fact;
import models.User;

public class FactGetByNameIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
		String sql="Select * from dai.fact where name=?";
		ResultSet rs;
		Fact result=new Fact();
	public Fact get(Fact f) {
		// TODO Auto-generated method stub
		String name =f.getName();
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,name);
	            rs=ps.executeQuery();
	            rs.next();
	            result.setId_fact(rs.getInt("id_fact"));
	            
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return result;
		
}
}
