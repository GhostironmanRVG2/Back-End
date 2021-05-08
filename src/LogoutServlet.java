import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import connector.UserGetIdIMP;
import models.User;  
public class LogoutServlet extends HttpServlet {
	
	
	JSONObject j=new JSONObject();
	
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
        	//email
        	String email=request.getParameter("email");
        	User user=new User();
        	user.setEmail(email);
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	//INVALIDAR A SESSION
        	HttpSession session=request.getSession();  
            session.invalidate();  
        	
        	
        	
        	
        	
        	
        	
        	//response type
            response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");  
            PrintWriter out=response.getWriter();
            
            
 
            
            
            
             
            
            
            
            
          //SACAR LOGIN TYPE
            UserGetIdIMP z=new UserGetIdIMP();
            User l=z.getByID(user);
          
            
            if(l.getLogin_type()==("Collaborator")) {
            	
            try {
				j.put("STATUS", "200");
				j.put("PATH", "frontoffice/LoginCityHall.html");
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
            	
            	
            	
            }else if(l.getLogin_type()==("Admin")) {
            	
            	try {
					j.put("STATUS", "200");
					j.put("PATH", "frontoffice/LoginAdmin.html");
					
					
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
            	
            	
            }else {
            	
            	try {
					j.put("STATUS", "200");
					j.put("PATH", "frontoffice/LoginInstitution.html");
					
					
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
            	
            	
            	
            	
            }
            
            
            
            
            
            
            
           out.print(j);
                
              
            out.close();  
    }  
}  