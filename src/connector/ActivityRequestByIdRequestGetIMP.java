package connector;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import models.Request_Activity;

public class ActivityRequestByIdRequestGetIMP{
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.request_activity where id_request=? ";
	ResultSet rs;
	Request_Activity result=new Request_Activity();
	public Request_Activity get(Request_Activity r) {
		
		int id=r.getId_request();// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id);
	            rs=ps.executeQuery();
	            rs.next();
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
            	
            	result.setAddress(address);
            	result.setCounty(county);
            	result.setDate(date);
            	result.setDescription(description);
            	result.setDistrict(district);
            	result.setId_institution(id_institution);
            	result.setId_request(id_request);
            	result.setLatitude(latitude);
            	result.setLongitude(longitude);
            	result.setPhoto(photo);
            	result.setPost_code(post_code);
            	result.setState(state);
            	result.setTime(time);
            	result.setType(type);
            	
                
	            
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return result;
	}
		
		
		
		
		
		
		
		
		
		
		
		
	}
