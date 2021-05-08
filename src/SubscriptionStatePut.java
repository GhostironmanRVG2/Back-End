
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.SubscriptionMSG;
import connector.SubscriptionStatePutIMP;
import models.Subscription;

public class SubscriptionStatePut extends HttpServlet {
	JSONObject j=new JSONObject();
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		     String id=req.getParameter("id_child");
		     int id_child= Integer.parseInt(id);
		     String id2=req.getParameter("id_activity");
		     int id_activity=Integer.valueOf(id2);
		     String state= req.getParameter("state");
		     //OBJ
		     Subscription S=new Subscription();
		     
		     S.setState(state);
		     S.setId_activity(id_activity);
		     S.setId_child(id_child);
		     
		     //FUNCTION
		     
		     
		     
		     SubscriptionStatePutIMP API=new SubscriptionStatePutIMP();
				int i= API.put(S);
				if(i>0) {
					doGet(req,resp,200);
					System.out.println("Sucess");
				}else {doGet(req,resp,400);
				       System.out.println("Something went wrong");

				
				}
	
				
				


			}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp,int cod) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject MSG=new JSONObject();
		SubscriptionMSG M=new SubscriptionMSG();
		if(cod==200) {
	    try {
			MSG.put("STATUS", M.getStatusS());
			MSG.put("MSG", M.getUpdateSucess());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			try {
				MSG.put("STATUS",M.getStatusF());
				MSG.put("MSG", M.getUpdateFailure());
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
