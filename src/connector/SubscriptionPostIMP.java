package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Subscription;

public class SubscriptionPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Insert into dai.Subscription (evaluation,photo_1,photo_2,state,id_activity,id_child) VALUE (?,?,?,?,?,?)";
	int i;
	public int insertSubscription(Subscription subs) {
		// TODO Auto-generated method
                   String e=subs.getEvaluation();
                   String p1=subs.getPhoto_1();
                   String p2=subs.getPhoto_2();
                   String s="Ativo";
                   int id_activity=subs.getId_activity();
                   int id_child=subs.getId_child();
                
                   
					
				   //Connection to database and store value in
					try {
						Class.forName(DRIVER);
						Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, e);
						ps.setString(2, p1);
						ps.setString(3, p2);
						ps.setString(4, s);
						ps.setInt(5, id_activity);
						ps.setInt(6, id_child);
						i=ps.executeUpdate();
						
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						i=0;
					}
					return i;
					
				}	

}
