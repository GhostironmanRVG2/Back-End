
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import assets.EvaluationActivityMSG;
import connector.EvaluationActivityPutIMP;
import models.EvaluationActivity;


public class EvaluationActivityPut extends HttpServlet {

	
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		     String points=req.getParameter("points");
		     float id1=Float.valueOf(points);
			 String id_child=req.getParameter("id_child");
		     int id2= Integer.parseInt(id_child);
			 String id_activity=req.getParameter("id_activity");
		     int id3= Integer.parseInt(id_activity);
		
		       //Object Facts
		     EvaluationActivity a = new EvaluationActivity();
		       a.setPoints(id1);
		       a.setId_child(id2);
			   a.setId_activity(id3);
		       
		       
				
			   EvaluationActivityPutIMP API=new EvaluationActivityPutIMP();
				int i= API.ActivityDoPut(a);
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
		EvaluationActivityMSG M=new EvaluationActivityMSG();
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
	 
	    PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    out.print(MSG);
	    out.flush();   
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}