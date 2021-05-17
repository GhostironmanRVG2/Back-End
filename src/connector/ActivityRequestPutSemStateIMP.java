
package connector;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import models.Request_Activity;

public class ActivityRequestPutSemStateIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.request_activity set address=?,county=?,description=?,district=?,latitude=?,longitude=?,post_code=?,type=?,date=?,time=? where id_request=?";
int i;
	public int Put(Request_Activity r) {
		String address =r.getAddress();
		String county=r.getCounty();
		String description=r.getDescription();
		String district=r.getDistrict();
		int id_request =r.getId_request();
		Float latitude =r.getLatitude();
		Float longitude=r.getLongitude();
		String post_code=r.getPost_code();
		String type=r.getType();
		Date date=r.getDate();
		Time time=r.getTime();
		
		
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, address);
			ps.setString(2,county);
			ps.setString(3,description);
			ps.setString(4,district);
			ps.setFloat(5,latitude);
			ps.setFloat(6, longitude);
			ps.setString(7,post_code);
			ps.setString(8, type);
			ps.setDate(9,date);
			ps.setTime(10, time);
			ps.setInt(11, id_request);
			
			
			
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
       
		return i;
		
		
	}

}
