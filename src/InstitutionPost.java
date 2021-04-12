import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.InstitutionActivateIMP;
import connector.InstitutionPostIMP;
import connector.UserGetIdIMP;
import models.Activity;
import models.Institution;
import models.User;

public class InstitutionPost extends HttpServlet {
	
	JSONObject MSG=new JSONObject();
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	        String id1=req.getParameter("id_candidate");
	        int id_candidate=Integer.valueOf(id1);
		    String id2=req.getParameter("id_user");
		    int id_user=Integer.valueOf(id2);
		    
		    
		    Institution I=new Institution();
		    I.setId_candidate(id_candidate);
		    I.setId_user(id_user);
		    
		    
		    
		    //POST
		    InstitutionPostIMP IMP=new InstitutionPostIMP();
		    int i=IMP.Post(I);
		    
		    
		    
		    
		    if(i>0) {
		    	
		    	try {
					MSG.put("STATUS", "200");
					MSG.put("MSG", "DONE");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	
		    	
		    	
		    	
		    }else {
		    	
		    	
		    	try {
					MSG.put("STATUS", "400");
					MSG.put("MSG", "SOMETHING WENT WRONG");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	
		    	
		    }
		    
		    
		    
		    
		    	
		    	
		    	
		    	
		    	
		    
		    
		    
		    
		    PrintWriter out = resp.getWriter();
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    out.print(MSG);
		    out.flush();   
		    
		    
		    
		    
		    
		    
		    
		    
				


			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
