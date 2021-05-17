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
import models.Request_ActivityP;
import models.Subscription;

public class ActivityRequestByIdGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select distinct ra.id_request,ra.id_institution,ra.date,ra.time,ra.type,ra.county,ra.district,ra.address,ra.state,ra.post_code, ra.latitude,ra.longitude,ra.description, ra.photo,r.points, ea.points as points_evaluation from dai.child c left join dai.subscription s on s.id_child = c.id_child left join dai.activity a on s.id_activity = a.id_activity left join dai.request_activity ra on a.id_request = ra.id_request left join dai.reward r on r.id_reward = a.id_reward left join dai.evaluation_activity ea on ea.id_activity = a.id_activity and ea.id_child = s.id_child where s.id_child=? and s.state=? and ra.date<CURDATE() OR (ra.date=CURDATE() and ra.time<=CURTIME()) order by a.id_activity";
	ResultSet rs;
	List<Request_ActivityP> lista=new ArrayList<Request_ActivityP>();
	Request_Activity o=new Request_Activity();
	public List<Request_ActivityP> Get(Subscription subs) {
		// TODO Auto-generated method stub
		  int id_child=subs.getId_child();
			
			//Connection to database and store value in
					try {
						Class.forName(DRIVER);
						Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1,id_child);
						ps.setString(2, "closed");
				            rs=ps.executeQuery();
				           while( rs.next()) {
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
			            	int points=rs.getInt("points");
			            	float points_evaluation=rs.getFloat("points_evaluation");
				          
				            lista.add(new Request_ActivityP(time,date,state,description,type,county,district,address,latitude,longitude,post_code,photo,id_institution,id_request,points,points_evaluation));
				  
				           }
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					return lista;
					
				}
		
		
		
		

}
