package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Candidate_Institution;
import models.Institution;

public class InstitutionPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://127.0.0.1:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Insert into dai.institution (id_candidate,id_user) VALUE (?,?)";
	int l;
	public int Post(Institution i) {
						
		
		
		// TODO Auto-generated method stub
		int id_candidate=i.getId_candidate();
		int id_user=i.getId_user();
		//Connection to database and store value in
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
		    ps.setInt(1, id_candidate);
		    ps.setInt(2, id_user);
			l=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return 0;
		}
		return l;
	}
		
		
		
		
		
		
	}

