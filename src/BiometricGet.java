import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityGetIMP;
import connector.ChildGetByIdIMP;
import connector.UserGetIdIMP;
import models.Child;
import models.User;

public class BiometricGet extends HttpServlet{

	
	
	
	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       JSONObject MSG=new JSONObject();
       String email=request.getParameter("email");
       User j=new User();
       j.setEmail(email);
       //SACAR id_user
       UserGetIdIMP rev=new UserGetIdIMP();
       User k =rev.getByID(j);
       int id_user= k.getID();
       //Buscar dados
       Child child=new Child();
       child.setId_user(id_user);
       ChildGetByIdIMP C=new  ChildGetByIdIMP();
        Child result=C.Get(child);
       
		
		
		 PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    //CRIAS O OBJETO JSON
		    try {
				MSG.put("email",email);
				MSG.put("id_child",result.getId_child() );
				MSG.put("phone_number_tutor",result.getPhone_number_tutor() );
				MSG.put("total_points",result.getTotal_points() );
				MSG.put("birth_date",result.getBirth_date() );
				MSG.put("name",result.getName() );
				MSG.put("photo",result.getPhoto() );
				MSG.put("id_user", id_user);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		    
		    out.print(MSG);
		   	
		   	
		    
		    	
		    	
		    	
		    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
