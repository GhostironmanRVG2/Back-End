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
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.request_activity JOIN heroku_062c2f3cf2f9e9d.activity ON request_activity.id_request=activity.id_request JOIN heroku_062c2f3cf2f9e9d.subscription ON subscription.id_activity=activity.id_activity where subscription.id_child=? and subscription.state=?";
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
						ps.setString(2, "close");
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
			                
				          
				            lista.add(new Request_ActivityP(time,date,state,description,type,county,district,address,latitude,longitude,post_code,photo,id_institution,id_request,points));
				  
				           }
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					return lista;
					
				}
		
		
		
		

}
