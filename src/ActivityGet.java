import java.io.IOException;
import java.io.PrintWriter;
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
String id;
List<Activity> o;
JSONObject l=new JSONObject();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        ActivityGetIMP AGI=new ActivityGetIMP();
        o=AGI.ActivityGet();
        
        
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
