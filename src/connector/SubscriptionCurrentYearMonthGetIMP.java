package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Activity;
import models.Subscription;

public class SubscriptionCurrentYearMonthGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select count(*) as janeiro,(Select count(*) as fevereiro from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='02') as fevereiro,(Select count(*) from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='03')as março,(Select count(*) from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='04')as abril,(Select count(*) from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='05')as maio,(Select count(*) from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='06')as junho,(Select count(*) from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='07')as julho,(Select count(*) from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='08')as agosto,(Select count(*) from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='09')as setembro,(Select count(*) from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='10')as outubro,(Select count(*) from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='11')as novembro,(Select count(*) from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='12')as dezembro from dai.subscription s JOIN dai.activity a on a.id_activity=s.id_activity JOIN dai.request_activity r on r.id_request=a.id_request where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='01';       ";
    ResultSet rs;
    List<Subscription> lista=new ArrayList<Subscription>();
	public List<Subscription> get() {
		
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            
	            //CRIACAO DA LISTA COM OS OBJETOS DA RESPOSTA
	            while(rs.next()) {
	            	
		            int janeiro=rs.getInt("janeiro");
		            int fevereiro=rs.getInt("fevereiro");
		            int março=rs.getInt("março");
		            int abril=rs.getInt("abril");
		            int maio=rs.getInt("maio");
		            int junho=rs.getInt("junho");
		            int julho=rs.getInt("julho");
		            int setembro=rs.getInt("setembro");
		            int agosto=rs.getInt("agosto");
		            int outubro=rs.getInt("outubro");
		            int novembro=rs.getInt("novembro");
		            int dezembro=rs.getInt("dezembro");
		            
		            
		            lista.add(new Subscription(janeiro,fevereiro,março,abril,maio,junho,julho,agosto,setembro,outubro,novembro,dezembro));
		            
	            }
		            
	            
	            
	            
	            
	            
	       
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
		
		
		
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

