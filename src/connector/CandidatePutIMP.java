

package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Candidate_Institution;

public class CandidatePutIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
String sql="Update dai.candidate_institution set name=?,address=?,county=?,district=?,post_code=?,phone_number=? where id_candidate=?";
int i;
public int Put(Candidate_Institution r) {
	String name =r.getName();
	String address = r.getAddress();
	String county=r.getCounty();
	String district=r.getDistrict();
	String post_code=r.getPost_code();
	int phone_number = r.getPhone_number();
	int id_candidate = r.getId_candidate();
       //DRIVER
       try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2,address);
			ps.setString(3,county);
			ps.setString(4,district);
			ps.setString(5,post_code);
			ps.setInt(6, phone_number);
			ps.setInt(7,id_candidate);	
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			i=0;
		}
       
		return i;
		
		
		
	}

}
