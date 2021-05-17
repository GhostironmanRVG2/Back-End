

package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.CollaboratorUserJOIN;

public class CollaboratorUserJoinGetIdUserIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Select c.id_collaborator, c.nif, c.phone_number, u.status, c.type, c.county, c.district, c.address, c.post_code, c.name, u.email from dai.collaborator c, dai.user u where c.id_user = u.id_user and c.id_user= ? ";
	ResultSet rs;
	List<CollaboratorUserJOIN> lista=new ArrayList<CollaboratorUserJOIN>();
	public List<CollaboratorUserJOIN> Get(CollaboratorUserJOIN subs) {
		// TODO Auto-generated method stub
		int id_user=subs.getId_user();
			//Connection to database and store value in
					try {
						Class.forName(DRIVER);
						Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setInt(1,id_user);
				            rs=ps.executeQuery();
				           if( rs.next()) {       	
			            	
				        	
			            	int id_collaborator=rs.getInt("id_collaborator");
			            	int nif = rs.getInt("nif");
			            	int phone_number = rs.getInt("phone_number");
			            	String status=rs.getString("status");
			            	String type=rs.getString("type");
			            	String county=rs.getString("county");
			            	String district=rs.getString("district");
			            	String address=rs.getString("address");
			            	String post_code=rs.getString("post_code");
			            	String name=rs.getString("name");
			            	String email=rs.getString("email");
				            lista.add(new CollaboratorUserJOIN(id_collaborator,id_user,nif,phone_number,name,type,address,county,district,post_code,status,email));

				           }else {
				        	   
				           }
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					return lista;
					
				}
}