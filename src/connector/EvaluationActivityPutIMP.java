
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.EvaluationActivity;

public class EvaluationActivityPutIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.evaluation_activity set points=? where id_child=? and id_activity=? ";
int i;
	public int ActivityDoPut(EvaluationActivity a) {
		// extract
	   float points=a.getPoints();
       int id_child=a.getId_child();
	   int id_activity=a.getId_activity();
       //DRIVER
       try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setFloat(1,points);
			ps.setInt(2,id_child);
			ps.setInt(3, id_activity);
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
       
		return i;
		
		
		
	}

}