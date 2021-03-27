import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import assets.ActivityMSG;
import assets.FactMSG;
import assets.RegisterMSG;
import connector.ActivityPutIMP;
import connector.RegistVerify;
import connector.RegisterIMP;
import models.Activity;


public class ActivityPut extends HttpServlet {

	
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		     String id_activity=req.getParameter("id_activity");
		     int id1= Integer.parseInt(id_activity);
			 String id_request=req.getParameter("id_request");
		     int id2= Integer.parseInt(id_request);
			 String id_reward=req.getParameter("id_reward");
		     int id3= Integer.parseInt(id_reward);
		
		       //Object Facts
		       Activity a = new Activity();
		       a.setId_activity(id1);
		       a.setId_activity(id2);
			   a.setId_activity(id3);
		       
		       
				
				ActivityPutIMP API=new ActivityPutIMP();
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
