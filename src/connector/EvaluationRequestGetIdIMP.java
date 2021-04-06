
		package connector;

		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.util.ArrayList;
		import java.util.List;

		import models.EvaluationRequest;

		public class EvaluationRequestGetIdIMP {
			String DRIVER="com.mysql.jdbc.Driver";
			String URL="jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306";
			String USER="b59f6070236844";
			String PASSWORD="612a84b4";
			String sql="Select points from heroku_062c2f3cf2f9e9d.evaluation_request where id_child=? and id_request=? ";
			ResultSet rs;
			List<EvaluationRequest> lista=new ArrayList<EvaluationRequest>();
			public List<EvaluationRequest> Get(EvaluationRequest subs) {
				// TODO Auto-generated method stub
				int child=subs.getId_child();
				int request=subs.getId_request();
					//Connection to database and store value in
							try {
								Class.forName(DRIVER);
								Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
								PreparedStatement ps=con.prepareStatement(sql);
								ps.setInt(1,child);
								ps.setInt(2, request);
						            rs=ps.executeQuery();
						           if( rs.next()) {
					            	float points=rs.getFloat("points");
						          
						            lista.add(new EvaluationRequest(points));
						  
						           }else {
						        	   
						        	 
						        	   
						           }
								
							} catch (SQLException | ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								
							}
							return lista;
							
						}
		

		}