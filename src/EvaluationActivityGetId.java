

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


import connector.EvaluationActivityGetIdIMP;
import models.EvaluationActivity;

public class EvaluationActivityGetId extends HttpServlet {
	String child;
	int id_child;
	String activity;
	int id_activity;
    List<EvaluationActivity> l;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		child=request.getParameter("id_child");
		id_child=Integer.valueOf(child);
		activity=request.getParameter("id_activity");
		id_activity=Integer.valueOf(activity);
		EvaluationActivity subs=new EvaluationActivity();
		subs.setId_child(id_child);
		subs.setId_activity(id_activity);
		//PASSAR O OBJETO
		EvaluationActivityGetIdIMP subsc=new EvaluationActivityGetIdIMP();
		l=subsc.Get(subs);
		 
		//JSON OBJECT
		JSONObject MSG=new JSONObject();
		if(!(l.isEmpty())) {
		try {
			MSG.put("MSG", l);
			MSG.put("STATUS", "200");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		}else {
			
			try {
				MSG.put("STATUS", "400");
				MSG.put("MSG", "NO ROWS OH MIGUEL");
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
