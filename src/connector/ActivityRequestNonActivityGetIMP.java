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

import models.Activity;
import models.Request_ActivityCandidateJOIN;

public class ActivityRequestNonActivityGetIMP {
	
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select request_activity.id_request, request_activity.id_institution, request_activity.state, request_activity.description, request_activity.type, request_activity.county, request_activity.district, request_activity.address, request_activity.post_code, request_activity.photo, request_activity.date, request_activity.time, request_activity.latitude, request_activity.longitude, candidate_institution.name  from dai.request_activity, dai.institution, dai.candidate_institution where id_request not in (Select id_request from dai.activity) and request_activity.id_institution = institution.id_institution and institution.id_candidate = candidate_institution.id_candidate and (request_activity.state='Aguardar' or request_activity.state='Arquivada');";
    ResultSet rs;
    List<Request_ActivityCandidateJOIN> lista=new ArrayList<Request_ActivityCandidateJOIN>();
	public List<Request_ActivityCandidateJOIN> get() {
		
		        // Sacar o id
				//LIGACAO Á BASE DE DADOS
				try {
					Class.forName(DRIVER);
					Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
					PreparedStatement ps=con.prepareStatement(sql);
			            rs=ps.executeQuery();
			            
			            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
			            while(rs.next()) {
			            	
			            	int id_request=rs.getInt("id_request");
			            	
			            	int id_institution =rs.getInt("id_institution");
			            	
			            	String state=rs.getString("state");
			            	
			            	String description=rs.getString("description");
			            	
			            	String type=rs.getString("type");
			            	
			            	String county=rs.getString("county");
			            	
			            	String district=rs.getString("district");
			            	
			            	String address=rs.getString("address");
			            	
			            	String post_code=rs.getString("post_code");
			            	
			            	String photo=rs.getString("photo");
			            	
			            	Date date=rs.getDate("date");
			            	
			            	Time time=rs.getTime("time");
			            	
			            	float latitude=rs.getFloat("latitude");
			            	
			            	float longitude=rs.getFloat("longitude");
			            	
			            	String name = rs.getString("name");
			            	
			            	
			            	
			           
				            
				            lista.add(new Request_ActivityCandidateJOIN(time,date,state,description,type,county,district,address,latitude,longitude,post_code,photo,id_institution,id_request,name));
				            
			            }
				            

					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				return lista;
				
		

		
	}
   
	

}
