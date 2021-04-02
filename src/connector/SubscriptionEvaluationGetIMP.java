package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Subscription;

public class SubscriptionEvaluationGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.subscription where id_child=? and id_activity=?";
	Subscription result=new Subscription();
	public Subscription get(Subscription subs) {
		// TODO Auto-generated method stub
		
		int id_child=subs.getId_child();
		int id_activity=subs.getId_activity();
		
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		    PreparedStatement ps=con.prepareStatement(sql);
		    ps.setInt(1,id_child);
		    ps.setInt(2,id_activity);
		
		    ResultSet rs = ps.executeQuery();
			if(rs.next()==false) {
				
				result.setPhoto_1("ERRO");
	
				
			}else {
				
				result.setEvaluation(rs.getString("evaluation"));
				result.setState("Deu");
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setPhoto_1("ERRO");
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setPhoto_1("ERRO");
			return result;
		}
		
            
          
	
	
	
	
	
	
	
	
	
	
	return result;
	

}
}
