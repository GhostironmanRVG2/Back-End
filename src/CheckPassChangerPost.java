import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.CheckPassIMP;
import connector.ChildGetIMP;
import models.User;

public class CheckPassChangerPost extends HttpServlet {

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        
        String email=request.getParameter("email");
        String pass_changer=request.getParameter("pass_changer");
        User l=new User();
        l.setEmail(email);
        CheckPassIMP Check=new CheckPassIMP();
        User d=Check.check(l);
        JSONObject p=new JSONObject();  
    
       if(d.getPass_changer().equals(pass_changer)&&!(d.getPass_changer().equals(null))) {
    	   
    	try {
			p.put("STATUS", "200");
			p.put("MSG","THATS THE CODE");
			p.put("PATH", "PasswordChangeActivity");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	   
    	   
    	   
       }else {
    	   
    	   try {
			p.put("STATUS","400");
			p.put("MSG", "THATS NOT THE CODE");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
    	   
    	   
    	   
       }
       
		
		
		 PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    out.print(p);
		    out.flush();   
        
   	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
