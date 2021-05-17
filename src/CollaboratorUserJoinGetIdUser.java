

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


import connector.CollaboratorUserJoinGetIdUserIMP;
import models.CollaboratorUserJOIN;

public class CollaboratorUserJoinGetIdUser extends HttpServlet {
	String user;
	int id_user;
    List<CollaboratorUserJOIN> l;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		user=request.getParameter("id_user");
		id_user=Integer.valueOf(user);
		CollaboratorUserJOIN subs=new CollaboratorUserJOIN();
		subs.setId_user(id_user);
		//PASSAR O OBJETO
		CollaboratorUserJoinGetIdUserIMP subsc=new CollaboratorUserJoinGetIdUserIMP();
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