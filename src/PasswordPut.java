import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.PasswordPutIMP;
import connector.UserPutIMP;
import models.User;

public class PasswordPut extends HttpServlet {

	
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           	//Get Parameters
		   String e= req.getParameter("email");
		   String p=req.getParameter("password");
		   
		   
		   // Generate Salt. The generated value can be stored in DB. 
		      String salt = PasswordUtils.getSalt(30);
		      
		      // Protect user's password. The generated value can be stored in DB.
		      String mySecurePassword = PasswordUtils.generateSecurePassword(p, salt);
		   
		
		      // Print out protected password 
		      System.out.println("My secure password = " + mySecurePassword);
		      System.out.println("Salt value = " + salt);
			//CRIACAO DO OBJETO
			User user=new User();
			user.setEmail(e);
		    user.setPassword(mySecurePassword);
		    user.setSalt(salt);
			PasswordPutIMP PDI=new PasswordPutIMP();
			int i=PDI.put(user);
			
			 PrintWriter out = resp.getWriter();
			    resp.setContentType("application/json");
			    resp.setCharacterEncoding("UTF-8");
			    JSONObject j=new JSONObject();
			   
			if(i>0) {
				
				try {
					j.put("STATUS", 200);
					j.put("MSG", "PASS IS CHANGED");
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
			}else {
				
				try {
					j.put("STATUS", "400");
					j.put("MSG", "SOMETHING WENT WRONG");
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
			
			
			out.print(j);
			
		   
		   
		   
		   
		   
		
		
		
		
		      
	
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
