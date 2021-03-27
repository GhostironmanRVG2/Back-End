package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Collaborator;
import models.Institution;

public class InstitutionGETimp {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.institution";
    ResultSet rs; 
    List<Institution> lista=new ArrayList<Institution>();
    
    public List<Institution> GetAll() {
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
                 int id_institution=rs.getInt("id_institution");
                 int id_user=rs.getInt("id_user");
                 String name=rs.getString("name");
                 int nif=rs.getInt("nif");
                 String type=rs.getString("type");
                 String address=rs.getString("address");
                 String county=rs.getString("county");
                 String district=rs.getString("district");
                 String post_code=rs.getString("post_code");
                 int phone_number=rs.getInt("phone_number");
	            
	            	
	            
	            	
	            	
	            	
		           
		            lista.add(new Institution(name,type,address,county,district,post_code,nif,phone_number,id_user,id_institution));
		            
		             
		           
		            
		            }
		            
	            
	            
	            
	            
	            
	            
	       
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		 return lista;
	}
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
