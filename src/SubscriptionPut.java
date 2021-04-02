import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.UserMSG;
import connector.SubscriptionPutIMP;
import connector.UserPutIMP;
import models.Subscription;
import models.User;

public class SubscriptionPut extends HttpServlet {
	JSONObject j=new JSONObject();
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		     String id=req.getParameter("id_child");
		     int id_child= Integer.parseInt(id);
		     String id2=req.getParameter("id_activity");
		     int id_activity=Integer.valueOf(id2);
		     String evalutation= req.getParameter("evaluation");
		     //OBJ
		     Subscription S=new Subscription();
		     
		     S.setEvaluation(evalutation);
		     S.setId_activity(id_activity);
		     S.setId_child(id_child);
		     
		     //FUNCTION
		     
		     
		     
		     SubscriptionPutIMP S2=new SubscriptionPutIMP();
		     int i=S2.put(S);
		     
		     
		     
		     
		     if(i==1) {
		    	 
		    	 try {
					j.put("STATUS", "200");
					 j.put("MSG", "DADOS ALTERADOS COM SUCESSO");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	 
		    	 
		    	 
		    	 
		    	 
		     }else {
		    	 
             try {
				j.put("STATUS", "400");
				j.put("MSG", "ERROR PUTTING THE DATA");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
 		    	 
		    	 
		    	 
		    	 
		     }
		     
		     
		     
		     
		     
		     PrintWriter out = resp.getWriter();
			    resp.setContentType("application/json");
			    resp.setCharacterEncoding("UTF-8");
			    out.print(j);
			    out.flush();   
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		    
		
		      
		       
		   
	
			}
	
	
	
	
	
	
	
	
	
	
	
	

}
