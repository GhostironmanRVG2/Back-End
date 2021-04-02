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
int p;
int i;
JSONObject obj=new JSONObject();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Subscription s=new Subscription();
	       ida=request.getParameter("id_activity");
	       p=Integer.parseInt(ida);
	       s.setId_activity(p);
	       idc=request.getParameter("id_child");
	       p=Integer.parseInt(idc);
	       s.setId_child(p);
	       
	       
	       
	       SubscriptionDeleteIMP SDI=new SubscriptionDeleteIMP();
	       i=SDI.SDelete(s);
	       
	       if(i>0) {
	    	  try {
				obj.put("STATUS","200");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    	   
	    	   
	    	   
	    	   
	    	   
	       }
	       
	       
	       PrintWriter out = response.getWriter();
	       response.setContentType("application/json");
	       response.setCharacterEncoding("UTF-8");
	       out.print(obj);
	       out.flush();   
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}