import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.SubscriptionMSG;
import assets.RegisterMSG;
import connector.SubscriptionPostIMP;
import models.Subscription;

public class SubscriptionPost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response,int cod) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject MSG=new JSONObject();
		SubscriptionMSG M=new SubscriptionMSG();
		if(cod==200) {
	    try {
			MSG.put("STATUS", M.getStatusS());
			MSG.put("MSG", M.getStatusMsgS());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			try {
				MSG.put("STATUS",M.getStatusF());
				MSG.put("MSG", M.getStatusMsgM());
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
	
	
	
	
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
		
				String e=req.getParameter("evaluation");
				String p1=req.getParameter("photo_1");
				String p2=req.getParameter("photo_2");
				String s=req.getParameter("state");
				String a=req.getParameter("id_activity");
				int id_act= Integer.parseInt(a);
				String child=req.getParameter("id_child");
				int id_child= Integer.parseInt(child);
				
				
				//user and password set and get
				Subscription subscription=new Subscription();
				subscription.setEvaluation(e);
				subscription.setPhoto_1(p1);
				subscription.setPhoto_2(p2);
				subscription.setState(s);
				subscription.setId_activity(id_act);
				subscription.setId_child(id_child);
				
				SubscriptionPostIMP fpimp=new SubscriptionPostIMP();
				int i=fpimp.insertSubscription(subscription);
				if(i>0) {
					doGet(req,resp,200);
					
				}else {doGet(req,resp,400);
				       
				}
			}
}