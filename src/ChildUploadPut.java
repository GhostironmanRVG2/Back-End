import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.ChildMSG;
import connector.ChildPutIMP;
import connector.ChildUploadPutIMP;
import models.Child;

public class ChildUploadPut extends HttpServlet {
	
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		     String id_child=req.getParameter("id_child");
		     int id1 = Integer.valueOf(id_child);
		     String photo=req.getParameter("photo");
		    
		
		       //Object Child
		       Child c = new Child();
		       c.setId_child(id1);
		       c.setPhoto(photo);
		       
				
				ChildUploadPutIMP CPI = new ChildUploadPutIMP();
				int i = CPI.ChildDoPut(c);
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
		ChildMSG M = new ChildMSG();
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
