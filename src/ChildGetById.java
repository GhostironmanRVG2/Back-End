import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ChildGetByIdIMP;
import connector.ChildGetIMP;
import models.Child;

public class ChildGetById extends HttpServlet {

	
	String id;
	Child o;
	JSONObject l=new JSONObject();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
	        String id=request.getParameter("id_user");
	        int id_user=Integer.valueOf(id);
	        Child c=new Child();
	        c.setId_user(id_user);
	        ChildGetByIdIMP AGI=new ChildGetByIdIMP();
			
	        o=AGI.Get(c);
	        
	        
	        try {
	        	l.put("state", o.getState());
				l.put("birth_date", o.getBirth_date());
				l.put("id_child", o.getId_child());
				l.put("id_user", id_user);
				l.put("phone_number_tutor", o.getPhone_number_tutor());
				l.put("total_points", o.getTotal_points());
				l.put("login_type", o.getLogin_type());
				l.put("name", o.getName());
				l.put("photo", o.getPhoto());
				l.put("status", o.getStatus());
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			 PrintWriter out = response.getWriter();
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    
					out.print(l);
				
			    out.flush();   
	        
	   	
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
