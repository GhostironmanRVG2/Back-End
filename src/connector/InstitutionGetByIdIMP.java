package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Candidate_Institution;
import models.Collaborator;
import models.User;

public class InstitutionGetByIdIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.candidate_institution where id_user=?";
	ResultSet rs;
	Candidate_Institution insti=new Candidate_Institution();
	public Candidate_Institution get(User k) {
		
		
		// TODO Auto-generated method stub
		
					int id_user=k.getID();
					//Connection to database and store value in
							try {
								Class.forName(DRIVER);
								Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
								PreparedStatement ps=con.prepareStatement(sql);
								ps.setInt(1,id_user);
						            rs=ps.executeQuery();
						            rs.next();
						        insti.setAddress(rs.getString("address"));
						        insti.setCounty(rs.getString("county"));
						        insti.setDistrict(rs.getString("district"));
						        insti.setEmail(rs.getString("email"));
						        insti.setId_candidate(rs.getInt("id_candidate"));
						        insti.setId_user(rs.getInt("id_user"));
						        insti.setName(rs.getString("name"));
						        insti.setNif(rs.getInt("nif"));
						        insti.setPhone_number(rs.getInt("phone_number"));
						        insti.setPost_code(rs.getString("post_code"));
						        
						        
						            
								
								
							} catch (SQLException | ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								
							}
							return insti;
							
			
		
	
	}

}
