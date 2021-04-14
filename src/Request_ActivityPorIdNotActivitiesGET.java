
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.Request_ActivityPorIdNotActivitiesGETIMP;
import models.Request_Activity;

public class Request_ActivityPorIdNotActivitiesGET extends HttpServlet {

	String id;
	int id_institution;
    List<Request_Activity> l;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		id=request.getParameter("id_institution");
		id_institution=Integer.valueOf(id);
		Request_Activity cand=new Request_Activity();
		cand.setId_institution(id_institution);
		//PASSAR O OBJETO
		Request_ActivityPorIdNotActivitiesGETIMP subsc=new Request_ActivityPorIdNotActivitiesGETIMP();
		l=subsc.Get(cand);
		 
		
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