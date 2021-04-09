import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityReqFutureIMP;
import connector.ActivityRequestGetIMP;
import models.ActivityRequestJOIN;

public class ActivityRequestFutureGet extends HttpServlet {

	JSONObject l=new JSONObject();	
	List<ActivityRequestJOIN> o;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        ActivityReqFutureIMP f =new ActivityReqFutureIMP();
	        o=f.ActivityRequestGet();
	        
	        try {
				l.put("MSG", o);
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
