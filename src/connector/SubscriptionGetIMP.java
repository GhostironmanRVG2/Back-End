package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Reward;
import models.Subscription;

public class SubscriptionGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.subscription";
    ResultSet rs; 
    List<Subscription> lista=new ArrayList<Subscription>();

	public List<Subscription> GetAll() {
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
                    
	               int id_activity=rs.getInt("id_activity");
	               int id_child=rs.getInt("id_child");
	               String evaluation=rs.getString("evaluation");
	               String photo_1=rs.getString("photo_1");
	               String photo_2=rs.getString("photo_2");
	               String state=rs.getString("state");
		           
		            lista.add(new Subscription(evaluation,photo_1,photo_2,state,id_activity,id_child));
		            
		             
		           
		            
		            }
		            
	            
	            
	            
	            
	            
	       
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
		
		
		
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
