package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import models.Candidate_Institution;
import models.Request_Activity;

public class InstitutionGetNonActivityByIdImp {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.request_activity where id_institution=? and id_request not in(Select id_request from dai.activity);";
	ResultSet rs;
	List<Request_Activity> lista=new ArrayList<Request_Activity>();
	public List get(Request_Activity rA) {
		int id_institution=rA.getId_institution();
		// TODO Auto-generated method stub
				try {
					Class.forName(DRIVER);
					Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, id_institution);
			            rs=ps.executeQuery();
			            
			            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
			            while(rs.next()) {
			            	Time time=rs.getTime("time");
			                Date date=rs.getDate("date");
			                String state=rs.getString("state");
			                String description=rs.getString("description");
			                String type=rs.getString("type");
			                String county=rs.getString("county");
			                String district=rs.getString("district");
			                String address=rs.getString("address");
			                float latitude=rs.getFloat("latitude");
			                float longitude=rs.getFloat("longitude");
			                String post_code=rs.getString("post_code");
			                String photo=rs.getString("photo");
			                int id_request=rs.getInt("id_request");
			                
			  	            
			  	            	
			  	            
			  	            	
			  	        	
			  	            	
			  		           
			  		            lista.add(new Request_Activity(time,date,state,description,type,county,district,address,latitude,longitude,post_code,photo,id_institution,id_request));
				             
				           
				            
				            }
				            
			
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				 return lista;
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

