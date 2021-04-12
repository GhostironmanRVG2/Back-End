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

import models.Activity;
import models.User;

public class ActivityGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.activity";
    ResultSet rs;
    int id;
 List<Activity> lista=new ArrayList<Activity>();
	public List<Activity> ActivityGet() {
		// Sacar o id
		//LIGACAO Á BASE DE DADOS
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
	            	
		            int id_request=rs.getInt("id_request");
		            int id_reward=rs.getInt("id_reward");
		            int id_activity=rs.getInt("id_activity");
		            String state=rs.getString("state");
		            
		            lista.add(new Activity(id_activity,id_request,id_reward,state));
		            
	            }
		            
	            
	            
	            
	            
	            
	       
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
		
		
		
		
		
		
	}
}

