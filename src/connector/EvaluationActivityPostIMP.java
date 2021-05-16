
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.EvaluationActivity;

public class EvaluationActivityPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Insert into dai.evaluation_activity (id_child,id_activity,points) VALUE (?,?,?)";
	int i;
		public int insertEvaluation(EvaluationActivity evaluation) {
			// TODO Auto-generated method stub
			int req=evaluation.getId_child();
			int rew=evaluation.getId_activity();
			float p=evaluation.getPoints();
			
		   //Connection to database and store value in
			try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,req);
				ps.setInt(2,rew);
				ps.setFloat(3,p);
				i=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				i=0;
			}
			return i;
			
		}
}
