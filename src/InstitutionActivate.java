import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityPutIMP;
import connector.InstitutionActivateIMP;
import models.Activity;

public class InstitutionActivate extends HttpServlet {
	
	JSONObject MSG=new JSONObject();
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		    String email=req.getParameter("email");
		    
		    InstitutionActivateIMP IA=new InstitutionActivateIMP();
		    
		    int i=IA.get(email);
			
		    if(i>0) {
		    	try {
					MSG.put("STATUS", "200");
					MSG.put("MSG", "Conta ativada");
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		    	
		    	
		    }else {
		    	
		    	
		    	
		    	try {
					MSG.put("STATUS", "400");
					MSG.put("MSG", "Erro");
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    }
		    
		    
		    
		    
		    PrintWriter out = resp.getWriter();
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    out.print(MSG);
		    out.flush();   
		    
		    
		    
		    
		    
		    
		    
		    
				


			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
