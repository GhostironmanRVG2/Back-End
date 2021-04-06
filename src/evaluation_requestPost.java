import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.SubscriptionMSG;
import connector.EvaluationRequestPostIMP;
import connector.SubscriptionPostIMP;
import models.EvaluationRequest;
import models.Subscription;

public class evaluation_requestPost extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
		
				String id1=req.getParameter("id_child");
				int id_child=Integer.valueOf(id1);
				String id2=req.getParameter("id_request");
				int id_request=Integer.valueOf(id2);
				String p=req.getParameter("points");
				float points=Float.valueOf(p);
				EvaluationRequest E=new EvaluationRequest();
				E.setId_child(id_child);
				E.setId_request(id_request);
				E.setPoints(points);
				
				//PASSAR OBJ
				EvaluationRequestPostIMP EP=new EvaluationRequestPostIMP();
				int i=EP.post(E);
				if(i>0) {
					doGet(req,resp,200);
					System.out.println("Sucess");
				}else {doGet(req,resp,400);
				       System.out.println("Something went wrong");
				}
			}
	
	
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response,int cod) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject MSG=new JSONObject();
		SubscriptionMSG M=new SubscriptionMSG();
		if(cod==200) {
	    try {
			MSG.put("STATUS", M.getStatusS());
			MSG.put("MSG", "YOU MADE SUCESSFULLY A POST IN EVALUATION_REQUEST");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			try {
				MSG.put("STATUS",M.getStatusF());
				MSG.put("MSG", "SOMETHING WENT WRONG HERE");
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
