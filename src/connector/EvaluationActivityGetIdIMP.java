

package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.EvaluationActivity;

public class EvaluationActivityGetIdIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select points from dai.evaluation_activity where id_child=? and id_activity=? ";
	ResultSet rs;
	List<EvaluationActivity> lista=new ArrayList<EvaluationActivity>();
	public List<EvaluationActivity> Get(EvaluationActivity subs) {
		// TODO Auto-generated method stub
		int child=subs.getId_child();
		int activity=subs.getId_activity();
			//Connection to database and store value in
					try {
						Class.forName(DRIVER);
						Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1,child);
						ps.setInt(2, activity);
				            rs=ps.executeQuery();
				           if( rs.next()) {
			            	float points=rs.getFloat("points");
				          
				            lista.add(new EvaluationActivity(points));
				  
				           }else {
				        	   
				           }
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					return lista;
					
				}
}