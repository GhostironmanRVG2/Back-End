package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Candidate_Institution;

public class InstitutionPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Insert into dai.candidate_institution (name,address,county,district,post_code,phone_number,nif,id_user) VALUE (?,?,?,?,?,?,?,?)";
	
	public void Post(Candidate_Institution c) {
						
		
		
		// TODO Auto-generated method stub
		String name= c.getName();
		String address= c.getAddress();
		String county =c.getCounty();
		String district =c.getDistrict();
		String post_code =c.getPost_code();
		int phone_number=c.getPhone_number();
		int nif=c.getNif();
		int id_user=c.getId_user();
		//Connection to database and store value in
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, county);
			ps.setString(4, district);
			ps.setString(5, post_code);
			ps.setInt(6, phone_number);
			ps.setInt(7, nif);
			ps.setInt(8, id_user);
			
			ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
	}
		
		
		
		
		
		
	}

