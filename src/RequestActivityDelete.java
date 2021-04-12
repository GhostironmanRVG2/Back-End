import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.RequestActivityDeleteIMP;
import models.Request_Activity;

public class RequestActivityDelete extends HttpServlet {
String idr;
int r;
int i;
JSONObject obj=new JSONObject();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Request_Activity s=new Request_Activity();
	       idr=request.getParameter("id_request");
	       r=Integer.parseInt(idr);
	       s.setId_request(r);
	       
	     

	       
	       RequestActivityDeleteIMP SDI=new RequestActivityDeleteIMP();
			JSONObject MSG=new JSONObject();
	       i=SDI.SDelete(s); 
	       if(i==1) {
	    	  try {
	    		  MSG.put("STATUS","200");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}else {
				
				
				try {
					MSG.put("STATUS","400" );
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