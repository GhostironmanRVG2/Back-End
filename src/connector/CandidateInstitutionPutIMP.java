package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Candidate_Institution;

public class CandidateInstitutionPutIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.candidate_institution set address=?,county=?,district=?,email=?,name=?,nif=?,post_code=?,phone_number=?  where id_candidate=? ";
int i;
	public int DoPut(Candidate_Institution k) {
		 String  address=k.getAddress();
		 String  county=k.getCounty();
		 String  district=k.getDistrict();
		 String  email=k.getEmail();
		 String  name=k.getName();
		 int  nif=k.getNif();
		 String  post_code=k.getPost_code();
		 int phone_number=k.getPhone_number();
		 int id_candidate=k.getId_candidate();
		 
		 
		 
		 try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, address);
				ps.setString(2,county);
				ps.setString(3,district);
				ps.setString(4,email);
				ps.setString(5,name);
				ps.setInt(6,nif);
				ps.setString(7,post_code);
				ps.setInt(8,phone_number);
				ps.setInt(9,id_candidate );
				i=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				i=0;
			}
	       
			return i;
			
			
			
		}
		 
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

