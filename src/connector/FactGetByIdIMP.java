package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Fact;

public class FactGetByIdIMP {

		
		
		String DRIVER="com.mysql.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306";
		String USER="BD";
		String PASSWORD="12341234";
			String sql="Select * from dai.fact where id_fact=?";
			ResultSet rs;
			Fact result=new Fact();
		public Fact get(Fact f) {
			// TODO Auto-generated method stub
			int id_fact=f.getId_fact();
			
			try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,id_fact);
		            rs=ps.executeQuery();
		            rs.next();
		            result.setId_fact(id_fact);
		            result.setDescription(rs.getString("description"));
		            result.setName(rs.getString("name"));
		            result.setPhoto(rs.getString("photo"));
		            
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			return result;
			
	}
		
		
	

}
