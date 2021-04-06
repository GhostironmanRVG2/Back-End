package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.EvaluationRequest;

public class EvaluationRequestPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Insert into heroku_062c2f3cf2f9e9d.evaluation_request (id_request,id_child,points) VALUE (?,?,?)";
	int i;
	public int post(EvaluationRequest e) {
		// TODO Auto-generated method stub
		int id_child=e.getId_child();
		int id_request=e.getId_request();
		float points=e.getPoints();
		
		   //Connection to database and store value in
			try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id_request);
				ps.setInt(2, id_child);
				ps.setFloat(3, points);
				i=ps.executeUpdate();
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				i=0;
			}
			return i;
			
		}
	}

