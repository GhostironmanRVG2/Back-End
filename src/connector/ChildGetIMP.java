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
import models.User;

public class ChildGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.child";
    ResultSet rs;
    int id;
   List<Child> lista=new ArrayList<Child>();
	public List<Child> ChildrenGet() {
		// Sacar o id
		//LIGACAO Á BASE DE DADOS
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
			            	
		           String name=rs.getString("name");
		           String birth_date=rs.getString("birth_date");
		           String photo=rs.getString("photo");
		           int id_child=rs.getInt("id_child");
		           int id_user=rs.getInt("id_user");
		           int phone_number_tutor=rs.getInt("phone_number_tutor");
		           int total_points=rs.getInt("total_points");
		     

		            
		             lista.add(new Child(name,birth_date,photo,id_child,id_user,phone_number_tutor,total_points));
	            }
		             
		            
	
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
			
	

	return lista;
	
	}
}

