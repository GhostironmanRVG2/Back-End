import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


import assets.ActivityMSG;
import connector.ActivityPostIMP;
import models.Activity;

public class ActivityPost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response,int cod) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject MSG=new JSONObject();
		ActivityMSG M=new ActivityMSG();
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
				
			     String id_request=req.getParameter("id_request");
			     int id_req= Integer.parseInt(id_request);
			     String id_reward=req.getParameter("id_reward");
			     int id_rew= Integer.parseInt(id_reward);
				
				//user and password set and get
				Activity activity=new Activity();
				activity.setId_request(id_req);
				activity.setId_reward(id_rew);
				
				ActivityPostIMP fpimp=new ActivityPostIMP();
				int i=fpimp.insertActivity(activity);
				if(i>0) {
					doGet(req,resp,200);
					System.out.println("Sucess");
				}else {doGet(req,resp,400);
				       System.out.println("Something went wrong");
				}
			}
}