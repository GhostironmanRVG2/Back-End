import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityRequestNonActivityGetIMP;
import models.Request_ActivityCandidateJOIN;


public class ActivityRequestNonActivityGet extends HttpServlet {

List<Request_ActivityCandidateJOIN> lista=new ArrayList<Request_ActivityCandidateJOIN>();	
JSONObject l=new JSONObject();
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
       ActivityRequestNonActivityGetIMP A=new ActivityRequestNonActivityGetIMP();
       lista=A.get();
       
        
        
        try {
			l.put("MSG", lista);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		 PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    try {
				out.print(l.get("MSG"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    out.flush();   
        
        
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
