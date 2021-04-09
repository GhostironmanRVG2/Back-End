
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.EvaluationRequest;

public class EvaluationRequestPutIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.evaluation_request set points=? where id_child=? and id_request=?";
int i;
	public int EvaluationRequestPut(EvaluationRequest a) {
		// extract
	   int id_child=a.getId_child();
       int id_request=a.getId_request();
       float points=a.getPoints();
       //DRIVER
       try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setFloat(1,points);
			ps.setInt(2,id_child);
			ps.setInt(3, id_request);
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
       
		return i;
		
		
		
	}

}