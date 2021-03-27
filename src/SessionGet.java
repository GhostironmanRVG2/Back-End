import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import models.Collaborator;
import models.Tutor;


public class SessionGet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		
response.setContentType("text/html");  
PrintWriter out=response.getWriter();   
JSONObject msg=new JSONObject();



HttpSession session=request.getSession(false);  
if(session!=null){
	if(session.getAttribute("header").equals("Child")) {
	Object id_child=session.getAttribute("id_child");
	Object birth_date =session.getAttribute("birth_date");
	Object id_user =session.getAttribute("id_user");
	Object name =session.getAttribute("name");
	Object phone_number_tutor=session.getAttribute("phone_number_tutor");
	Object photo =session.getAttribute("photo");
	Object total_points=session.getAttribute("total_points");

try {
	msg.put("id_child", id_child);
	msg.put("birth_date",birth_date );
	msg.put("id_user",id_user);
	msg.put("name", name);
	msg.put("phone_number_tutor",phone_number_tutor);
	msg.put("photo",photo );
	msg.put("total_points",total_points );
	
	
	
} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}else {
		
		Object id_collaborator=session.getAttribute("id_collaborator");
		Object id_user=session.getAttribute("id_user");
		Object address=session.getAttribute("address");
		Object birth_date=session.getAttribute("birth_date");
		Object county=session.getAttribute("county");
		Object district=session.getAttribute("district" );
		Object name=session.getAttribute("name" );
		Object phone_number=session.getAttribute("phone_number");
		Object post_code=session.getAttribute("post_code");	
		Object nif=session.getAttribute("nif");
		Object type=session.getAttribute("type");
		
		
		try {
			msg.put("id_collaborator", id_collaborator);
			msg.put("id_user", id_user);
	    msg.put("address", address);
	    msg.put("birth_date", birth_date);
	    msg.put("county",county);
	    msg.put("district", district);
	    msg.put("name", name);
	    msg.put("phone_number", phone_number);
	    msg.put("post_code", post_code);
	    msg.put("nif", nif);
	    msg.put("type", type);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

out.print(msg);





  
} 
else{
  try {
	  
	msg.put("STATUS", "400");
	msg.put("MSG","No sessions available");
	
} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
  
  out.print(msg);   
}  
out.close();  
}  
	
	
	
	
	
	
	
	
}
