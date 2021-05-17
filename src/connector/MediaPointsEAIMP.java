
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import models.EvaluationRequest;

public class MediaPointsEAIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="select avg(points) from dai.evaluation_activity;";
    ResultSet rs;
    float count=0;
	public float NumberFact() {
		// Devolver a média dos points das evaluations_request
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            rs.next();
            count = rs.getFloat(1);
			
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA

	
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return count;
		
		
		
		
		
	}
}
