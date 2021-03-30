package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Reward;

public class TotalPointsChildGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select SUM(points) AS total_points from heroku_062c2f3cf2f9e9d.reward JOIN heroku_062c2f3cf2f9e9d.activity ON reward.id_reward=activity.id_reward JOIN heroku_062c2f3cf2f9e9d.subscription ON activity.id_activity=subscription.id_activity  where id_child=?";
	Reward result=new Reward();
	ResultSet rs;
	public Reward get(Reward r) {
		int id=r.getId_child();// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id);
	            rs=ps.executeQuery();
	            rs.next();
	           int tp= rs.getInt("total_points");
	            
	           result.setPoints(tp);
	            
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
