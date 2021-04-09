package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Subscription;
import models.Sugestion;

public class SugestionGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select * from dai.sugestion";
    ResultSet rs; 
    List<Sugestion> lista=new ArrayList<Sugestion>();
	public List<Sugestion> GetAll() {
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
                   int id_sugestion=rs.getInt("id_sugestion");
                   int id_child=rs.getInt("id_child");
                   String title=rs.getString("title");
                   String designation=rs.getString("designation");
		           
		            lista.add(new Sugestion(id_sugestion,id_child,title,designation));
		            
		             
		           
		            
		            }
		            
	            
	            
	            
	            
	            
	       
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
		
		
		
		
		
		
	}

}
