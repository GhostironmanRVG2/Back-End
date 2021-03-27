import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityRequestByIdGetIMP;
import connector.UserGetIdIMP;
import models.Request_Activity;
import models.Subscription;
import models.User;

public class ActivityRequestByIdGet extends HttpServlet {

	String id;
	int id_child;
    Request_Activity l;
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
		   MSG.put("address",l.getAddress() );
		   MSG.put("county",l.getCounty());
		   MSG.put("date",l.getDate() );
		   MSG.put("description",l.getDescription() );
		   MSG.put("district",l.getDistrict() );
		   MSG.put("id_institution",l.getId_institution() );
		   MSG.put("id_request",l.getId_request() );
		   MSG.put("latitude",l.getLatitude() );
		   MSG.put("longitude",l.getLongitude() );
		   MSG.put("photo",l.getPhoto() );
		   MSG.put("post_code",l.getPost_code() );
		   MSG.put("time",l.getTime() );
		   MSG.put("state",l.getState() );
		   MSG.put("type",l.getType() );
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		 PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    out.print(MSG);
		    out.flush();   
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
