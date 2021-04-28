
package connector;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import models.Request_Activity;

public class Request_ActivityPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Insert into dai.request_activity (id_institution, state, description, type, county, district, address, post_code, photo, longitude, latitude, time, date) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String sql2="Select last_insert_id() as id_request";
	int i;
	int id_request;
		public int insertRequest_Activity(Request_Activity request_activity) {
			// TODO Auto-generated method stub
			int inst=request_activity.getId_institution();
			String state="Aguardar";
			String description=request_activity.getDescription();
			String type=request_activity.getType();
			String county=request_activity.getCounty();
			String district=request_activity.getDistrict();
			String address=request_activity.getAddress();
			String post_code=request_activity.getPost_code();
			String photo=request_activity.getPhoto();
			float longitude=request_activity.getLongitude();
			float latitude=request_activity.getLatitude();
			Time time=request_activity.getTime();
			Date date=request_activity.getDate();
			
		   //Connection to database and store value in
			try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,inst);
				ps.setString(2, state);
				ps.setString(3, description);
				ps.setString(4, type);
				ps.setString(5, county);
				ps.setString(6, district);
				ps.setString(7, address);
				ps.setString(8, post_code);
				ps.setString(9, photo);
				ps.setFloat(10, longitude);
				ps.setFloat(11, latitude);
				ps.setTime(12, time);
				ps.setDate(13, date);
				
				i=ps.executeUpdate();
				PreparedStatement ps2=con.prepareStatement(sql2);
				ResultSet rs=ps2.executeQuery(sql2);
				rs.next();
				id_request=rs.getInt("id_request");
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				i=0;
			}
			
			return id_request;
			
		}
}