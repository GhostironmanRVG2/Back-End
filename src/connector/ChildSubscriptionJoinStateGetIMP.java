
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.ChildSubscriptionJoin;

public class ChildSubscriptionJoinStateGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select s.state, c.name, c.birth_date, c.photo, s.id_activity, s.id_child, c.total_points, c.id_user, c.phone_number_tutor from dai.subscription s, dai.child c where i.id_activity = ? and i.id_child = ? and a.id_activity = s.id_activity and s.id_child = c.id_child order by c.id_child;";
	ResultSet rs;
	List<ChildSubscriptionJoin> lista=new ArrayList<ChildSubscriptionJoin>();
	ChildSubscriptionJoin o=new ChildSubscriptionJoin();
	public List<ChildSubscriptionJoin> GetID(ChildSubscriptionJoin cand) {
		// TODO Auto-generated method stub
		  int id_institution=cand.getId_institution();
		  int id_child=cand.getId_child();
			
			//Connection to database and store value in
					try {
						Class.forName(DRIVER);
						Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1,id_institution);
						ps.setInt(2, id_child);
				            rs=ps.executeQuery();
				           rs.next();
			            	String state=rs.getString("state");
			            	String name=rs.getString("name");
			            	String birth_date=rs.getString("birth_date");
			            	String photo=rs.getString("photo");
			            	int id_activity=rs.getInt("id_activity");
			            	int total_points=rs.getInt("total_points");
			            	int id_user=rs.getInt("id_user");
			            	int phone_number_tutor=rs.getInt("phone_number_tutor");
				          
				            lista.add(new ChildSubscriptionJoin(state,name,birth_date,photo,id_activity,id_child,total_points,id_user,phone_number_tutor));
				  
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					return lista;
					
				}
		
		
		
		

}