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
import models.Reward;

public class RewardGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.reward";
    ResultSet rs; 
    List<Reward> lista=new ArrayList<Reward>();
	public List<Reward> RewardsGet() {
			try {
				Class.forName(DRIVER);
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql);
		            rs=ps.executeQuery();
		            
		            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
		            while(rs.next()) {
                        int id_reward=rs.getInt("id_reward");
                        String name=rs.getString("name");
                        String photo=rs.getString("photo");
                        int points=rs.getInt("points");
			           
			            lista.add(new Reward(id_reward,name,photo,points));
			            
			             
			           
			            
			            }
			            
		            
		            
		            
		            
		            
		       
				
				
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			return lista;
			
			
			
			
			
			
		}
		
		
		
	}

