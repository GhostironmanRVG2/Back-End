package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Collaborator;
import models.Request_Activity;

public class CollaboratorGETimp {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.collaborator";
    ResultSet rs; 
    List<Collaborator> lista=new ArrayList<Collaborator>();
	public List<Collaborator> GetAll() {
		// TODO Auto-generated method stub
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
                  int id_collaborator= rs.getInt("id_collaborator");
                  int id_user= rs.getInt("id_user");
                  String name= rs.getString("name");
                   int nif=rs.getInt("nif");
                  String type= rs.getString("type");
                  String address= rs.getString("address");
                  String county=rs.getString("county");
                  String district= rs.getString("district");
                   String post_code=rs.getString("post_code");
                  int phone_number= rs.getInt("phone_number");
	            
	            	
	            
	            	
	            	
	            	
		           
		            lista.add(new Collaborator(id_collaborator,id_user,name,nif,type,address,county,district,post_code,phone_number));
		            
		             
		           
		            
		            }
		            
	            
	            
	            
	            
	            
	            
	       
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
	}
	}
