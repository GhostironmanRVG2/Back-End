
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


import assets.EvaluationActivityMSG;
import connector.EvaluationActivityPostIMP;
import models.EvaluationActivity;

public class EvaluationActivityPost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response,int cod) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject MSG=new JSONObject();
		EvaluationActivityMSG M=new EvaluationActivityMSG();
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
				
			     String id_child=req.getParameter("id_child");
			     int id_req= Integer.parseInt(id_child);
			     String id_activity=req.getParameter("id_activity");
			     int id_rew= Integer.parseInt(id_activity);
			     String points=req.getParameter("points");
			     float p=Float.valueOf(points);
			     
			     
				//user and password set and get
			     EvaluationActivity evaluation=new EvaluationActivity();
			     evaluation.setId_child(id_req);
			     evaluation.setId_activity(id_rew);
			     evaluation.setPoints(p);
				
			     EvaluationActivityPostIMP fpimp=new EvaluationActivityPostIMP();
				int i=fpimp.insertEvaluation(evaluation);
				if(i>0) {
					doGet(req,resp,200);
					System.out.println("Sucess");
				}else {doGet(req,resp,400);
				       System.out.println("Something went wrong");
				}
			}
}