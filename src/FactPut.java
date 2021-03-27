import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.FactMSG;
import assets.RegisterMSG;
import connector.FactPutIMP;
import connector.RegistVerify;
import connector.RegisterIMP;
import models.Fact;

public class FactPut extends HttpServlet {

	
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		     String id_fact=req.getParameter("id_fact");
		     int id= Integer.parseInt(id_fact);
		     String name=req.getParameter("name");
		     String description=req.getParameter("description");
		     String photo=req.getParameter("photo");
		    
		
		       //Object Facts
		       Fact f=new Fact();
		       f.setId_fact(id);
		       f.setName(name);
		       f.setDescription(description);
		       f.setPhoto(photo);
		       
		       
				
				FactPutIMP FPI=new FactPutIMP();
				int i=FPI.FactDoPut(f);
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
		FactMSG M=new FactMSG();
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
