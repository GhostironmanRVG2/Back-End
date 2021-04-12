package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Institution;

public class InstitutionPutIMP {

	
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
    String sql="Update dai.institution set id_user=?,id_candidate=? where id_institution=? ";
    int l;
	
	
	
	
	
	
	
	
	
	public int ActivityDoPut(Institution i) {
		
		int id_user=i.getId_user();
		int id_candidate=i.getId_candidate();
		int id_institution=i.getId_institution();
		
		
		
		
		
		
		
		 try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id_user);
				ps.setInt(2, id_candidate);
				ps.setInt(3, id_institution);
				l=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				l=0;
			}
	       
			return l;
			
			
			
		}
	}
