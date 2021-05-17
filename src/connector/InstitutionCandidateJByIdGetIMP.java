package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.InstitutionCandidateJoin;

public class InstitutionCandidateJByIdGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://188.82.156.135:3306";
	String USER="monkey";
	String PASSWORD="monkey";
	String sql="Select candidate_institution.id_candidate, institution.id_institution, institution.id_user, candidate_institution.name, candidate_institution.address, candidate_institution.county, candidate_institution.district, candidate_institution.post_code, candidate_institution.nif, candidate_institution.phone_number, candidate_institution.email from dai.candidate_institution JOIN dai.institution ON candidate_institution.id_candidate = institution.id_candidate where id_institution=?";
    ResultSet rs; 
    List<InstitutionCandidateJoin> lista=new ArrayList<InstitutionCandidateJoin>();
	
	
	

	
	public List<InstitutionCandidateJoin> CandidateJoinGETAll(int id_institution) {
		
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id_institution);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
                     
	            	int id_candidate=rs.getInt("id_candidate");
	            	int id_user =rs.getInt("id_user");
	            	String name=rs.getString("name");
	            	String address=rs.getString("address");
	            	String county=rs.getString("county");
	            	String district=rs.getString("district");
	            	String post_code=rs.getString("post_code");
	            	int nif=rs.getInt("nif");
	            	int phone_number=rs.getInt("phone_number");
	            	String email=rs.getString("email");
	            	
	            
	           
		            lista.add(new InstitutionCandidateJoin(id_candidate,id_institution,id_user,name,address,county,district,post_code,nif,phone_number,email));
		            
		             
		           
		            
		            }

			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
	}
		
			
	}
