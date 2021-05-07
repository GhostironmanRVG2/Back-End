import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.UserMSG;
import connector.DeleteSubsIMP;
import connector.UserPutIMP;
import models.Subscription;
import models.User;

public class DeleteSubs extends HttpServlet {
	
	
	protected void doDelete(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		     String id1=req.getParameter("id_activity");
		     int id_activity=Integer.valueOf(id1);
		     String id2=req.getParameter("id_child");
		     int id_child=Integer.valueOf(id2);
		    
		
		       //Object Subs
		      Subscription s=new Subscription();
              s.setId_activity(id_activity);
              s.setId_child(id_child);
		       
			  
              
              DeleteSubsIMP D=new DeleteSubsIMP();
              
              int i=D.delete(s);
              
              
              
		       
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
		UserMSG M=new UserMSG();
		if(cod==200) {
	    try {
			MSG.put("STATUS", M.getStatusS());
			MSG.put("MSG", "DELETED WITH SUCESS");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			try {
				MSG.put("STATUS",M.getStatusF());
				MSG.put("MSG", "FAIL");
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
