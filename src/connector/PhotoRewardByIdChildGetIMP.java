package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Reward;
import models.User;

public class PhotoRewardByIdChildGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select reward.photo from heroku_062c2f3cf2f9e9d.reward JOIN heroku_062c2f3cf2f9e9d.activity ON activity.id_reward=reward.id_reward JOIN heroku_062c2f3cf2f9e9d.subscription ON subscription.id_activity=activity.id_activity where id_child=? and subscription.state='closed'";
    ResultSet rs; 
    List<Reward> lista=new ArrayList<Reward>();
	public List<Reward> get(Reward r) {
	int id_child=r.getId_child();
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			    ps.setInt(1, id_child);
	            rs=ps.executeQuery();
	     
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
                   String photo=rs.getString("photo");
		           
		            lista.add(new Reward(photo));
		            
		             
		           
		            
		            }
		            
	            
	            
	            
	            
	            
	       
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
