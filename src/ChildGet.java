import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityGetIMP;
import connector.ChildGetIMP;
import models.Child;

public class ChildGet extends HttpServlet {
	String id;
	List<Child> o;
	JSONObject l=new JSONObject();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
	        
	        
	        ChildGetIMP AGI=new ChildGetIMP();
	        o=AGI.ChildrenGet();
	        
	        
	        try {
				l.put("MSG", o);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			 PrintWriter out = response.getWriter();
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    try {
					out.print(l.get("MSG"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    out.flush();   
	        
	   	
			}
}
