
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import assets.EvaluationRequestMSG;
import assets.FactMSG;
import assets.RegisterMSG;
import connector.EvaluationRequestPutIMP;
import connector.RegistVerify;
import connector.RegisterIMP;
import models.EvaluationRequest;


public class EvaluationRequestPut extends HttpServlet {

	
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		     String points=req.getParameter("points");
		     int eq1= Integer.parseInt(points);
			 String id_child=req.getParameter("id_child");
		     int eq2= Integer.parseInt(id_child);
			 String id_request=req.getParameter("id_request");
		     int eq3= Integer.parseInt(id_request);
		
		       //Object Facts
		     EvaluationRequest a = new EvaluationRequest();
		       a.setPoints(eq1);
		       a.setId_child(eq2);
			   a.setId_request(eq3);
		       
		       
				
			   EvaluationRequestPutIMP API=new EvaluationRequestPutIMP();
				int i= API.EvaluationRequestPut(a);
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
		EvaluationRequestMSG M=new EvaluationRequestMSG();
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