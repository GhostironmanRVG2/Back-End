
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


import connector.ActivityRequestJoinGetByIdActivityIMP;
import models.ActivityRequestJOIN;

public class ActivityRequestJOINGetIdInstitution extends HttpServlet {

	String id;
	int id_institution;
    List<ActivityRequestJOIN> l;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		id=request.getParameter("id_institution");
		id_institution=Integer.valueOf(id);
		ActivityRequestJOIN subs=new ActivityRequestJOIN();
		subs.setId_institution(id_institution);
		//PASSAR O OBJETO
		ActivityRequestJoinGetByIdActivityIMP subsc=new ActivityRequestJoinGetByIdActivityIMP();
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
		    try {
				out.print(MSG.get("MSG"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    out.flush();   
		

		
	}
	
	

}