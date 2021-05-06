package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Candidate_Institution;

public class CandidatePostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Insert into dai.candidate_institution (address,county,district,email,name,post_code,nif,phone_number) VALUE (?,?,?,?,?,?,?,?)";
	int i;
	public int insert(Candidate_Institution CI) {
		
		String address=CI.getAddress();
		String county=CI.getCounty();
		String district=CI.getDistrict();
		String email=CI.getEmail();
		String name=CI.getName();
		String post_code=CI.getPost_code();
		int nif=CI.getNif();
		int phone_number=CI.getPhone_number();
	    
				
		
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,address);
			ps.setString(2,county);
			ps.setString(3, district);
			ps.setString(4, email);
			ps.setString(5, name);
			ps.setString(6,post_code );
			ps.setInt(7, nif);
			ps.setInt(8, phone_number);
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
		return i;
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
