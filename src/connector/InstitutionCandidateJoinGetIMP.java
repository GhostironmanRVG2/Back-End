
package connector;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import models.InstitutionCandidateJoin;
import models.Reward;

public class InstitutionCandidateJoinGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select candidate_institution.id_candidate, institution.id_institution, institution.id_user, candidate_institution.name, candidate_institution.address, candidate_institution.county, candidate_institution.district, candidate_institution.post_code, candidate_institution.nif, candidate_institution.phone_number  from dai.candidate_institution JOIN dai.institution ON candidate_institution.id_candidate = institution.id_candidate";
    ResultSet rs; 
    List<InstitutionCandidateJoin> lista=new ArrayList<InstitutionCandidateJoin>();

	
	
	
	
	
	public List<InstitutionCandidateJoin> ActivityCandidateJoinGETAll() {
		// TODO Auto-generated method stub
		
		
		
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
                     
	            	int id_candidate=rs.getInt("id_candidate");
	            	int id_institution=rs.getInt("id_institution");
	            	int id_user =rs.getInt("id_user");
	            	String name=rs.getString("name");
	            	String address=rs.getString("address");
	            	String county=rs.getString("county");
	            	String district=rs.getString("district");
	            	String post_code=rs.getString("post_code");
	            	int nif=rs.getInt("nif");
	            	int phone_number=rs.getInt("phone_number");
	            	
	            
	           
		            lista.add(new InstitutionCandidateJoin(id_candidate,id_institution,id_user,name,address,county,district,post_code,nif,phone_number));
		            
		             
		           
		            
		            }

			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
	}


	
}