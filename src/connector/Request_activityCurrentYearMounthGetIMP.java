package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Request_Activity;
import models.Subscription;

public class Request_activityCurrentYearMounthGetIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select count(*) as janeiro,(Select count(*) as fevereiro from dai.request_activity r where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='02') as fevereiro,(Select count(*) from dai.request_activity r where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='03')as março,(Select count(*) from dai.request_activity r where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='04')as abril,(Select count(*) from dai.request_activity r where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='05')as maio,(Select count(*) from dai.request_activity r where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='06')as junho,(Select count(*) from dai.request_activity r  where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='07')as julho,(Select count(*) from dai.request_activity r where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='08')as agosto,(Select count(*) from dai.request_activity r where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='09')as setembro,(Select count(*) from dai.request_activity r where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='10')as outubro,(Select count(*) from dai.request_activity where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='11')as novembro,(Select count(*) from dai.request_activity r where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='12')as dezembro,(Select count(*) as fevereiro from dai.request_activity r where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')=DATE_FORMAT(CURDATE(),'%m')) as atual from dai.request_activity r where DATE_FORMAT(CURDATE(),'%Y')=DATE_FORMAT(r.date,'%Y') and DATE_FORMAT(r.date,'%m')='01';";
    ResultSet rs;
    List<Request_Activity> lista=new ArrayList<Request_Activity>();
	public List<Request_Activity> get() {


		
		
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
		            int atual=rs.getInt("atual");
		            
		            
		            
		            lista.add(new Request_Activity(janeiro,fevereiro,março,abril,maio,junho,julho,agosto,setembro,outubro,novembro,dezembro,atual));
		            
	            }
		            
	            
	            
	            
	            
	            
	       
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return lista;
		
		
		
		
		
	}

}
