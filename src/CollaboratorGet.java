import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityRequestGetIMP;
import connector.CollaboratorGETimp;
import models.Collaborator;
import models.Request_Activity;

public class CollaboratorGet extends HttpServlet {

	
	
	
	JSONObject l=new JSONObject();	
	List<Collaborator> o;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        CollaboratorGETimp CGI=new CollaboratorGETimp();
	        o=CGI.GetAll();
	        
	        
	        try {
				l.put("MSG",o);
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
