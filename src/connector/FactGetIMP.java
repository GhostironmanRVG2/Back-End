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
import models.Child;
import models.Fact;
import models.User;

public class FactGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
	String USER="b59f6070236844";
	String PASSWORD="612a84b4";
	String sql="Select * from heroku_062c2f3cf2f9e9d.fact";
    ResultSet rs;
    int id; 
    JSONObject o=new JSONObject();
    List<Fact> lista=new ArrayList<Fact>();
	public List<Fact> FactGet() {
		// Sacar o id
		//LIGACAO Á BASE DE DADOS
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
	            	
			        int id_fact=rs.getInt("id_fact");            	
		            String name=rs.getString("name");
		            String description=rs.getString("description");
		            String photo=rs.getString("photo");

		           
		            lista.add(new Fact(id_fact,name ,description ,photo));
		            
		            
	            }
		            
	
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
			
	}
}
	
	