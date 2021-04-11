import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityGetIMP;
import models.Activity;
import models.User;

public class ActivityGet extends HttpServlet {
	//VAMOS VER SE ISTO DÁ COMIT SEM ERROS.
	//VAIS SACAR UM PULL OH BOI
//CAGUEI APRA TI PARA AS TUAS BADALHOCAS
	//CAGA AS TUAS MAMIGAS ÀS 4 DA MANHA
String id;
List<Activity> o;
JSONObject l=new JSONObject();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        ActivityGetIMP AGI=new ActivityGetIMP();
        o=AGI.ActivityGet();
		
		
		 PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    //CRIAS O OBJETO JSON
		    try {
				l.put("MSG", o);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		    
		   	//
		   	try { 
				out.print(l.get("MSG"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   	
		   	
		    
		    	
		    	
		    	
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		     
        
        
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
