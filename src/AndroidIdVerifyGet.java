import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityGetIMP;
import connector.AndroidIdVerifyGetIMP;
import models.User;

public class AndroidIdVerifyGet extends HttpServlet {
	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
JSONObject j=new JSONObject();        
        //REQ
        String Android_ID=request.getParameter("Android_ID");
        String Email=request.getParameter("email");
        //CRIACAO DO OBJ
        User j2=new User();
        j2.setEmail(Email);
        //IMP
        AndroidIdVerifyGetIMP V=new  AndroidIdVerifyGetIMP();
        User result=V.get(j2);
        
        
		
		
		 PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    //CRIAS O OBJETO JSON
		    if(result.getAndroid_ID()!=null) {
		    
		    
		    if(result.getAndroid_ID().equals(Android_ID)) {
		    try {
				
				j.put("STATUS",200);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    }else {
		    	
		    	try {
					j.put("STATUS",401);
					j.put("MSG", "THIS ACCOUNT IS LINKED TO ANOTHER DEVICE");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }
		    
				
			
		   	
		   	
		    
		    	
		    	
		    	
		    }else {
		    	
		    	
		    	try {
					j.put("STATUS",400);
					j.put("MSG","THIS ACCOUNT DOESNT HAVE PERMISSION TO BIOMETRIC LOGIN");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	
		    	
		    }
		    
		    out.print(j);
		    
		    
		    
		    
		    
		    
		     
        
        
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

