import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ChildUserGetIMP;
import connector.InstitutionUserCandidateGetIMP;
import models.Child;

public class ChildUserGet extends HttpServlet {

	
	
	
	
	
	List<Child> o;
	JSONObject l=new JSONObject();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
			ChildUserGetIMP CU=new ChildUserGetIMP();
			
			o=CU.get();
	        
			
			
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
