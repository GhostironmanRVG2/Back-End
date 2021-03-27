package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Fact;

public class FactPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Insert into heroku_062c2f3cf2f9e9d.fact (name,description,photo) VALUE (?,?,?)";
	int i;
		public int insertFact(Fact fact) {
			// TODO Auto-generated method stub
			String n=fact.getName();
			String d=fact.getDescription();
			String p=fact.getPhoto();
			
		   //Connection to database and store value in
			try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,n);
				ps.setString(2,d);
				ps.setString(3, p);
				i=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				i=0;
			}
			return i;
			
		}
}
