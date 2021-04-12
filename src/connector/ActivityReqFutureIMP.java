package connector;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import models.ActivityRequestCandidateJOIN;

public class ActivityReqFutureIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select DISTINCT  r.id_request , r.id_institution,r.date,TIME_FORMAT(r.time,'%H:%i') AS time, r.type, r.county, r.district, r.address, r.state, r.post_code, r.latitude, r.longitude, r.description, r.photo, a.id_activity, a.id_reward, a.state, c.name from ( dai.institution i, dai.candidate_institution c, dai.request_activity r inner join dai.activity a on r.id_request=a.id_request) where a.state='Ativo' and ((date=CURDATE() and time>=CURRENT_TIME()) OR date>CURDATE()) and r.id_institution = i.id_institution and i.id_candidate = c.id_candidate;";
    ResultSet rs;
    int id;
    List<ActivityRequestCandidateJOIN> lista=new ArrayList<ActivityRequestCandidateJOIN>();
	public List<ActivityRequestCandidateJOIN> ActivityRequestCandidateJOIN() {
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
		            int id_reward=rs.getInt("id_reward");
		            int id_activity=rs.getInt("id_activity");
		            int id_institution=rs.getInt("id_institution");
		            String time=rs.getString("time");
		            String date=rs.getString("date");
		            String state=rs.getString("state");
		            String description=rs.getString("description");
		            String type=rs.getString("type");
		            String county=rs.getString("county");
		            String district=rs.getString("district");
		            String address=rs.getString("address");
		            String post_code=rs.getString("post_code");
		            String photo=rs.getString("photo");
		            float longitude=rs.getFloat("longitude");
		            float latitude=rs.getFloat("latitude");
		            String name=rs.getString("name");
          
		           
		            lista.add(new ActivityRequestCandidateJOIN(id_request,id_reward,id_activity,time, date, state, description, type, county, district, address, post_code,latitude,longitude,photo,id_institution,name));
		           
		            
		           
		            
		            }     
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;

	}
}
