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
import models.Request_Activity;

public class ActivityRequestNonActivityGetIMP {
	
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.request_activity where id_request not in (Select id_request from dai.Activity) ";
    ResultSet rs;
    List<Request_Activity> lista=new ArrayList<Request_Activity>();
	public List<Request_Activity> get() {
		
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
			            	
			            	
			            	
			           
				            
				            lista.add(new Request_Activity(time,date,state,description,type,county,district,address,latitude,longitude,post_code,photo,id_institution,id_request));
				            
			            }
				            
			            
			            
			            
			            
			            
			       
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				return lista;
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
