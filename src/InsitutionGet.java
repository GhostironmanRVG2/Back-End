
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.CollaboratorGETimp;
import connector.InstitutionGetIMP;
import models.Collaborator;
import models.Institution;

public class InsitutionGet extends HttpServlet {

	

	JSONObject l=new JSONObject();	
	List<Institution> o;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
		InstitutionGetIMP CGI=new InstitutionGetIMP();
	        o=CGI.GetInstitution();
	        
	        
	        try {
				l.put("MSG", o);
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