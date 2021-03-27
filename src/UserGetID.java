import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connector.UserGetIdIMP;

import org.json.JSONException;
import org.json.JSONObject;

import assets.LoginMSG;
import models.User;

public class UserGetID extends HttpServlet {
	String e;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		UserGetIdIMP UGBII= new UserGetIdIMP();
		
		
		User o=new User();
		e=request.getParameter("email");
		o.setEmail(e);
		o=UGBII.getByID(o);
		
		//JSON OBJECT
		JSONObject MSG=new JSONObject();
		
		try {
			MSG.put("id_user", o.getID());
			MSG.put("login_type", o.loginT());
		    MSG.put("email", o.getEmail());
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
