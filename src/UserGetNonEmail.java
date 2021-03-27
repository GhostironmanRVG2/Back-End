import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.UserGetIdIMP;
import connector.UserGetNonEmailIMP;
import models.User;

public class UserGetNonEmail extends HttpServlet {
	String id_user;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		UserGetNonEmailIMP UGNEI= new UserGetNonEmailIMP();
		
		
		User o=new User();
		id_user=request.getParameter("id_user");
		int id=Integer.parseInt(id_user);
		o.setID(id);
		String idSession=UGNEI.getByID(o);
		
		//JSON OBJECT
		JSONObject MSG=new JSONObject();
		if(idSession!=null) {
		try {
			MSG.put("id_user", o.getID());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		 PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    out.print(MSG);
		    out.flush();   
		}else {
		try {
			MSG.put("id_user","null");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
