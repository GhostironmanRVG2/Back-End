import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.Request_activityCurrentYearMounthGetIMP;
import connector.SubscriptionCurrentYearMonthGetIMP;
import models.Request_Activity;
import models.Subscription;

public class Request_activityCurrentYearMounthGet extends HttpServlet {
	JSONObject l=new JSONObject();	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
		Request_activityCurrentYearMounthGetIMP R=new Request_activityCurrentYearMounthGetIMP();
		
		List<Request_Activity> o=R.get();
		
	   
			
			
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
