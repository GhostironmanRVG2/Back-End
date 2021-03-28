import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityRequestByIdGetIMP;
import connector.UserGetIdIMP;
import models.Request_Activity;
import models.Request_ActivityP;
import models.Subscription;
import models.User;

public class ActivityRequestByIdGet extends HttpServlet {

	String id;
	int id_child;
    List<Request_ActivityP> l;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		id=request.getParameter("id_child");
		id_child=Integer.valueOf(id);
	    Subscription subs=new Subscription();
		subs.setId_child(id_child);
		//PASSAR O OBJETO
		ActivityRequestByIdGetIMP subsc=new ActivityRequestByIdGetIMP();
		l=subsc.Get(subs);
		 
		
		//JSON OBJECT
		JSONObject MSG=new JSONObject();
		try {
			MSG.put("MSG", l);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    out.print(MSG);
		    out.flush();   
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
