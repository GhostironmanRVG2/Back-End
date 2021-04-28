
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

import models.Request_Activity;


public class Request_ActivityPorIdNotActivitiesGETIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select r.id_request,r.state,r.description,r.type,r.county,r.district,r.address,r.post_code,r.photo,r.date,r.time,r.latitude,r.longitude,a.id_activity,a.id_reward,a.state as activity_state from dai.request_activity r LEFT JOIN dai.activity a on r.id_request=a.id_request where id_institution=? order by a.id_activity; ";
	ResultSet rs;
	List<Request_Activity> lista=new ArrayList<Request_Activity>();
	Request_Activity o=new Request_Activity();
	public List<Request_Activity> Get(Request_Activity req) {
		// TODO Auto-generated method stub
		  int id_institution=req.getId_institution();
			
			//Connection to database and store value in
					try {
						Class.forName(DRIVER);
						Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1,id_institution);
				            rs=ps.executeQuery();
				          while(rs.next()) {
			            	int id_request =rs.getInt("id_request");
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
			            	String activity_state=rs.getString("activity_state");
			            	int id_activity=rs.getInt("id_activity");
			            	int id_reward=rs.getInt("id_reward");
			            	
				          
				            lista.add(new Request_Activity(time,date,state,description,type,county,district,address,latitude,longitude,post_code,photo,id_institution,id_request,activity_state,id_activity,id_reward));
				          }
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					return lista;
					
				}

}