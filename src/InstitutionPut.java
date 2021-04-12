import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.ActivityMSG;
import connector.InstitutionPutIMP;
import models.Institution;

public class InstitutionPut extends HttpServlet {

	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		      String id=req.getParameter("id_institution");
		      int id_institution=Integer.valueOf(id);
		      String id2=req.getParameter("id_user");
		      int id_user=Integer.valueOf(id2);
		      String id3=req.getParameter("id_candidate");
		      int id_candidate=Integer.valueOf(id3);
		      //Por no objeto
		      Institution I=new Institution();
		      I.setId_candidate(id_candidate);
		      I.setId_institution(id_institution);
		      I.setId_user(id_user);
		      
		       
				
				InstitutionPutIMP IPI=new InstitutionPutIMP();
				int i= IPI.ActivityDoPut(I);
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
