
package connector;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import models.ActivityRequestJOIN;

public class ActivityRequestJoinGetByIdActivityIMP{
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.request_activity r, dai.activity a where a.id_activity=? and r.id_request = r.id_request";
	ResultSet rs;
	ActivityRequestJOIN result=new ActivityRequestJOIN();
	public ActivityRequestJOIN get(ActivityRequestJOIN r) {
		
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
            	int id_reward=rs.getInt("id_reward");
            	int id_activity=rs.getInt("id_activity");
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
            	result.setName(name);
            	result.setId_reward(id_reward);
            	result.setId_activity(id_activity);

            	
                
	            
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return result;
	}
		
	
	}
