package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.ChildSubscriptionJoin;

public class ChildSubscritpionGetIdInstitutionIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select s.evaluation, s.photo_1, s.photo_2, s.state, c.name, c.birth_date, c.photo, s.id_activity, s.id_child, c.total_points, c.id_user, c.phone_number_tutor, i.id_institution,r.description from dai.subscription s, dai.child c, dai.activity a, dai.request_activity r, dai.institution i  where i.id_institution = ? and i.id_institution = r.id_institution and r.id_request = a.id_request and a.id_activity = s.id_activity and s.id_child = c.id_child order by s.id_activity;";
	ResultSet rs;
	List<ChildSubscriptionJoin> lista=new ArrayList<ChildSubscriptionJoin>();
	ChildSubscriptionJoin o=new ChildSubscriptionJoin();
	public List<ChildSubscriptionJoin> GetID(ChildSubscriptionJoin cand) {
		// TODO Auto-generated method stub
		  int id_institution=cand.getId_institution();
			
			//Connection to database and store value in
					try {
						Class.forName(DRIVER);
						Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1,id_institution);
				            rs=ps.executeQuery();
				           while(rs.next()){
				        	   
			            	String evaluation=rs.getString("evaluation");
			            	String photo_1=rs.getString("photo_1");
			            	String photo_2=rs.getString("photo_2");
			            	String state=rs.getString("state");
			            	String name=rs.getString("name");
			            	String birth_date=rs.getString("birth_date");
			            	String photo=rs.getString("photo");
			            	int id_activity=rs.getInt("id_activity");
			            	int id_child=rs.getInt("id_child");
			            	int total_points=rs.getInt("total_points");
			            	int id_user=rs.getInt("id_user");
			            	int phone_number_tutor=rs.getInt("phone_number_tutor");
			                String description=rs.getString("description");
				            
				            lista.add(new ChildSubscriptionJoin(evaluation,photo_1,photo_2,state,name,birth_date,photo,id_activity,id_child,total_points,id_user,phone_number_tutor,id_institution,description));
				            
				           }
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					return lista;
					
				}
		
		
		
		

}