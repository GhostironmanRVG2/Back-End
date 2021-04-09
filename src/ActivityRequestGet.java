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
import connector.RewardGetIMP;
import models.Request_Activity;
import models.Reward;

public class ActivityRequestGet extends HttpServlet {

	
	JSONObject l=new JSONObject();	
	List<Request_Activity> o;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        ActivityRequestGetIMP RGAI=new ActivityRequestGetIMP();
	        o=RGAI.RewardsGetAllMethod();
	        
	        
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
