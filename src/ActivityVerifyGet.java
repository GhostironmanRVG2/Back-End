import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityRequestByIdGetIMP;
import connector.ActivityVerifyGetIMP;
import models.Subscription;

public class ActivityVerifyGet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		String id=request.getParameter("id_child");
		int id_child=Integer.valueOf(id);
		String id2=request.getParameter("id_activity");
		int id_activity=Integer.valueOf(id2);
	    Subscription subs=new Subscription();
		subs.setId_child(id_child);
		subs.setId_activity(id_activity);
		//PASSAR O OBJETO
		ActivityVerifyGetIMP A=new ActivityVerifyGetIMP();
		int k=A.verify(subs);
		 
		
		//JSON OBJECT
		JSONObject MSG=new JSONObject();
		if(k==1) {
		try {
			MSG.put("STATUS","200" );
			MSG.put("MSG", "THAT SUBSCRIPTION IS LEGIT");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			
			
			try {
				MSG.put("STATUS","400" );
				MSG.put("MSG", "NO SUBSCRIPTION IN THIS ACTIVITY FOR THAT CHILD");
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
