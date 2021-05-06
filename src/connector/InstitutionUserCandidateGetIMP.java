package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Activity;
import models.Institution;

public class InstitutionUserCandidateGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select sum(case when a.state = \"Concluído\" then 1 else 0 end) as count, u.id_user,u.login_type,u.status,i.id_institution,i.id_candidate,c.name,c.nif,c.address,c.county,c.district,c.post_code,c.phone_number from dai.user u join dai.institution i on i.id_user=u.id_user join dai.candidate_institution c on c.id_candidate=i.id_candidate join dai.request_activity r on i.id_institution=r.id_institution join dai.activity a on a.id_request=r.id_request";
    ResultSet rs;
    List<Institution> lista=new ArrayList<Institution>();
	public List<Institution> get() {
		
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
	                int id_user=rs.getInt("id_user");
		            int id_institution=rs.getInt("id_institution");
		            int id_candidate =rs.getInt("id_candidate");
		            int nif=rs.getInt("nif");
		            int phone_number=rs.getInt("phone_number");
		            String login_type =rs.getString("login_type");
		            String status =rs.getString("status");
		            String name=rs.getString("name");
		            String address=rs.getString("address");
		            String county=rs.getString("county");
		            String district=rs.getString("district");
		            String post_code=rs.getString("post_code");
	                
	                
	                
		            lista.add(new Institution(id_user,login_type,status,id_institution,id_candidate,name,nif,address,county,district,post_code,phone_number));
		            
	            }
		            
	            
	            
	            
	            
	            
	       
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
		
		
		
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
