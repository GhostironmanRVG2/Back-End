
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityRequestJoinGetByIdActivityIMP;
import models.ActivityRequestJOIN;

public class ActivityRequestJoinGetByIdActivity extends HttpServlet {
	ActivityRequestJOIN R=new ActivityRequestJOIN();
	ActivityRequestJOIN result=new ActivityRequestJOIN();
JSONObject l=new JSONObject();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		   String id=request.getParameter("id_activity");
		   int id_activity=Integer.valueOf(id);
		   R.setId_activity(id_activity);
		   
		   ActivityRequestJoinGetByIdActivityIMP A=new ActivityRequestJoinGetByIdActivityIMP();
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
				l.put("name",result.getName() );
				l.put("id_reward",result.getId_reward() );
				l.put("id_activity",result.getId_activity() );

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