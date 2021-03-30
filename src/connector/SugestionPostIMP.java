package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Sugestion;

public class SugestionPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Insert into heroku_062c2f3cf2f9e9d.sugestion (id_child,title,designation) VALUE (?,?,?)";
	String sqlnull="Insert into heroku_062c2f3cf2f9e9d.sugestion (id_child,designation) VALUE (?,?)";
	int i;
		public int insertSugestion(Sugestion sugestion) {
			// TODO Auto-generated method stub
			int c = sugestion.getId_child();
			String t = sugestion.getTitle();
			String d = sugestion.getDesignation();
			if(t!=null) {
			
		   //Connection to database and store value in
			try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,c);
				ps.setString(2,t);
				ps.setString(3, d);
				i=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				i=0;
				
				
				
				
			}
			
			}else {
				
				//Connection to database and store value in
				try {
					Class.forName(DRIVER);
					Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
					PreparedStatement ps=con.prepareStatement(sqlnull);
					ps.setInt(1,c);
					ps.setString(2, d);
					i=ps.executeUpdate();
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					i=0;
					
					
					
					
				}
				
				
				
				
				
			}
			return i;
			
		}
}
