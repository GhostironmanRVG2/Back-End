package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Candidate_Institution;
import models.Child;

public class CandidateGetByNif {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.candidate_institution where nif=?";
	Candidate_Institution b=new Candidate_Institution();
	ResultSet rs;
	public Candidate_Institution get(Candidate_Institution c) {
		int nif=c.getNif();
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,nif);
	            rs=ps.executeQuery();
	            rs.next();
	            b.setAddress(rs.getString("address"));
	            b.setCounty(rs.getString("county"));
	            b.setDistrict(rs.getString("district"));
	            b.setId_candidate(rs.getInt("id_candidate"));
	            b.setName(rs.getString("name"));
	            b.setPhone_number(rs.getInt("phone_number"));
	            b.setNif(rs.getInt("nif"));
	            b.setPost_code(rs.getString("post_code"));
	            
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return b;
		
	}

}
