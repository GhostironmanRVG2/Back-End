import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityRequestByIdRequestGetIMP;
import connector.TotalPointsChildGetIMP;
import models.Request_Activity;
import models.Request_ActivityJOINinstitution;

public class ActivityRequestByIdRequestGet extends HttpServlet {
Request_Activity R=new Request_Activity();
Request_ActivityJOINinstitution result;
JSONObject l=new JSONObject();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		   String id=request.getParameter("id_request");
		   int id_request=Integer.valueOf(id);
		   R.setId_request(id_request);
		   
		   ActivityRequestByIdRequestGetIMP A=new ActivityRequestByIdRequestGetIMP();
		   result=A.get(R);
		   
		   
	        
	        
	        
	        try {
				l.put("id_request",result.getId_request() );
				l.put("id_institution",result.getId_institution() );
				l.put("address",result.getAddress() );
				l.put("county",result.getCounty() );
				l.put("date",result.getDate() );
				l.put("description",result.getDescription() );
				l.put("district",result.getDistrict() );
				l.put("latitude",result.getLatitude() );
				l.put("longitude",result.getLongitude() );
				l.put("photo",result.getPhoto() );
				l.put("post_code", result.getPost_code() );
				l.put("state", result.getState());
				l.put("time",result.getTime() );
				l.put("type",result.getType() );
				l.put("name", result.getName());
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
