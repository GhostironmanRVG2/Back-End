
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ChildSubscritpionGetIdInstitutionIMP;
import models.ChildSubscriptionJoin;

public class ChildSubscritpionGetIdInstitution extends HttpServlet {

	String id;
	int id_institution;
    List<ChildSubscriptionJoin> l;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		id=request.getParameter("id_institution");
		id_institution=Integer.valueOf(id);
		ChildSubscriptionJoin cand=new ChildSubscriptionJoin();
		cand.setId_institution(id_institution);
		//PASSAR O OBJETO
		ChildSubscritpionGetIdInstitutionIMP subsc=new ChildSubscritpionGetIdInstitutionIMP();
		l=subsc.GetID(cand);
		
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