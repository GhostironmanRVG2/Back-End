
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityDeleteIMP;
import models.Activity;
public class ActivityDelete extends HttpServlet {
String ida;
int a;
int i;
JSONObject obj=new JSONObject();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Activity s=new Activity();
	       ida=request.getParameter("id_activity");
	       a=Integer.parseInt(ida);
	       s.setId_activity(a);
	       
	     

	       
	       ActivityDeleteIMP SDI=new ActivityDeleteIMP();
			JSONObject MSG=new JSONObject();
	       i=SDI.SDelete(s); 
	       if(i==1) {
	    	  try {
	    		  MSG.put("STATUS","200");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}else {
				
				
				try {
					MSG.put("STATUS","400" );
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

	    	   
	    	   
	    	   
	       }
	       
	       
	       
	       
	       
	       PrintWriter out = response.getWriter();
	       response.setContentType("application/json");
	       response.setCharacterEncoding("UTF-8");
	       out.print(MSG);
	       out.flush();   
		
		
		
	}
	

	
}