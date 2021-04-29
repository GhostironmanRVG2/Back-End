package connector;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import models.CollaboratorUserJOIN;

public class CollaboratorUserJOINGetIMP {
	
String DRIVER="com.mysql.jdbc.Driver";
String URL="jdbc:mysql://188.82.156.135:3306";
String USER="monkey";
String PASSWORD="monkey";
String sql="Select u.id_user, u.status, c.id_collaborator, c.nif, c.name, c.post_code, c.address, c.district, c.county, c.type, c.phone_number from dai.user u, dai.collaborator c where u.id_user = c.id_user";
ResultSet rs; 
List<CollaboratorUserJOIN> lista=new ArrayList<CollaboratorUserJOIN>();

public List<CollaboratorUserJOIN> RewardsGetAllMethod() {
	// TODO Auto-generated method stub

	try {
		Class.forName(DRIVER);
		Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		PreparedStatement ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
            while(rs.next()) {
                 
            	int id_collaborator=rs.getInt("id_collaborator");
            	int id_user =rs.getInt("id_user");
            	int nif = rs.getInt("nif");
            	int phone_number = rs.getInt("phone_number");
            	String status=rs.getString("status");
            	String type=rs.getString("type");
            	String county=rs.getString("county");
            	String district=rs.getString("district");
            	String address=rs.getString("address");
            	String post_code=rs.getString("post_code");
            	String name=rs.getString("name");
            	
            	
            
            	
            	
            	
	           
	            lista.add(new CollaboratorUserJOIN(id_collaborator,id_user,nif,phone_number,name,type,address,county,district,post_code,status));
	            
	             
	           
	            
	            }
	            
            
            
            
            
            
            
       
		
		
	} catch (SQLException | ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	}
	return lista;
}













}
