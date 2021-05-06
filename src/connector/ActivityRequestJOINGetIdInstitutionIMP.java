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
import java.util.concurrent.Flow.Subscription;

import models.ActivityRequestJOIN;


public class ActivityRequestJOINGetIdInstitutionIMP{
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select a.id_request, a.id_reward, a.id_activity, r.time, r.date, a.state, r.description, r.type, r.county, r.district, r.address, r.post_code, r.latitude, r.longitude, r.photo, r.id_institution, c.name, r.state as state_request from dai.request_activity r, dai.activity a, dai.institution i, dai.candidate_institution c where i.id_institution=? and r.id_request = a.id_request and r.id_institution = i.id_institution and i.id_candidate=c.id_candidate";
	ResultSet rs;
	
	List<ActivityRequestJOIN> lista=new ArrayList<ActivityRequestJOIN>();
	
	
	public List<ActivityRequestJOIN> Get(ActivityRequestJOIN subs) {
		int id_institution=subs.getId_institution();
		// TODO Auto-generated method stub
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id_institution);
	            rs=ps.executeQuery();
	            
	            
	            while(rs.next()) {
	            int id_request=rs.getInt("id_request");
            	int id_activity =rs.getInt("id_activity");
            	int id_reward=rs.getInt("id_reward");
            	String state=rs.getString("state");
            	String description=rs.getString("description");
            	String name=rs.getString("name");
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
            	String state_request=rs.getString("state_request");
        		
            	
            	lista.add(new ActivityRequestJOIN(id_request, id_reward, id_activity, time, date, state, description, type, county, district, address, post_code, latitude, longitude, photo, id_institution, name, state_request));

	            }
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
	}
		
	
	}