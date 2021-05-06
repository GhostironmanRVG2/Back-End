
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ChildSubscriptionJoinStateGetIMP;
import models.ChildSubscriptionJoin;

public class ChildSubscriptionJoinStateGet extends HttpServlet {

	String id_act;
	String id_chil;
	int id_child;
	int id_activity;
    List<ChildSubscriptionJoin> l;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		id_act=request.getParameter("id_activity");
		id_activity=Integer.valueOf(id_act);
		id_chil=request.getParameter("id_child");
		id_child=Integer.valueOf(id_chil);
		ChildSubscriptionJoin cand=new ChildSubscriptionJoin();
		cand.setId_activity(id_activity);
		cand.setId_child(id_child);

		//PASSAR O OBJETO
		ChildSubscriptionJoinStateGetIMP subsc=new ChildSubscriptionJoinStateGetIMP();
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