import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.SubscriptionDeleteIMP;
import models.Subscription;
public class SubscriptionDelete extends HttpServlet {
String ida;
String idc;
int c;
int a;
int i;
JSONObject obj=new JSONObject();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Subscription s=new Subscription();
	       ida=request.getParameter("id_activity");
	       a=Integer.parseInt(ida);
	       s.setId_activity(a);
	       idc=request.getParameter("id_child");
	       c=Integer.parseInt(idc);
	       s.setId_child(c);
	       
	     

	       
	       SubscriptionDeleteIMP SDI=new SubscriptionDeleteIMP();
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
