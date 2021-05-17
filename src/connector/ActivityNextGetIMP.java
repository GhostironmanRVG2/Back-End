package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityNextGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select count(*) as numero from dai.activity a JOIN dai.request_activity r on r.id_request=a.id_request where ((date=CURDATE() and time>=CURRENT_TIME()) OR date>CURDATE())";
    ResultSet rs;
    int numero;
	public int get() {
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	           if(rs.next()) {
	           
	            numero=rs.getInt("numero");
		            
	           }else {
	        	   
	         numero=0;
	           }
	            
	            
	            
	            
	       
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return numero;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	}

