import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.ActivityMSG;
import connector.ActivityPutStateIMP;
import connector.ActivityRequestPutStateIMP;
import models.Activity;
import models.Request_Activity;

public class ActivityRequestStatePut extends HttpServlet {

	
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		      String state=req.getParameter("state");
		      String id1=req.getParameter("id_request");
		      int id_request=Integer.valueOf(id1);
		       //Object Facts
		       Request_Activity RA=new Request_Activity();
		       RA.setState(state);
		       RA.setId_request(id_request);
		       
				
				ActivityRequestPutStateIMP API=new ActivityRequestPutStateIMP();
				int i= API.ActivityDoPut(RA);
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
		ActivityMSG M=new ActivityMSG();
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
