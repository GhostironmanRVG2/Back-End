package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Child;

public class ChildPostIMP {
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306";
	String USER="BD";
	String PASSWORD="12341234";
	String sql="Insert into dai.Child (name,birth_date,photo,id_user,phone_number_tutor) VALUE (?,?,?,?,?)";
	int i;
	public void Post(Child chi) {
		// TODO Auto-generated method
                   String n=chi.getName();
                   String birth_date=chi.getBirth_date();
                   String photo=chi.getPhoto();
                   int id_user=chi.getId_user();
                   int phone_number_tutor=chi.getPhone_number_tutor();
                
                   
					
				   //Connection to database and store value in
					try {
						Class.forName(DRIVER);
						Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, n);
						ps.setString(2, birth_date);
						ps.setString(3, photo);
						ps.setInt(4, id_user);
						ps.setInt(5, phone_number_tutor);
						i=ps.executeUpdate();
						
						
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						i=0;
					}
					
					
				}	

}
