import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.ChildMSG;
import connector.ChildPutByIdUserWebIMP;
import connector.ChildPutIMP;
import models.Child;

public class ChildPutByIdUserWeb extends HttpServlet {

	
	
	
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		     String name=req.getParameter("name");
		     String total_points=req.getParameter("total_points");
		     int tp=Integer.valueOf(total_points);
		     String birth_date=req.getParameter("birth_date");
		     String id_user=req.getParameter("id_user");
		     int id=Integer.valueOf(id_user);
		     String phone_number_tutor=req.getParameter("phone_number_tutor");
		     int pnt=Integer.valueOf(phone_number_tutor);
		     String photo=req.getParameter("photo");
		     String status=req.getParameter("status");
		     
		    
		
		       //Object Child
		       Child c = new Child();
		       c.setName(name);
		       c.setTotal_points(tp);
		       c.setBirth_date(birth_date);
		       c.setId_user(id);
		       c.setPhone_number_tutor(pnt);
		       c.setStatus(status);
		       
				
				ChildPutByIdUserWebIMP CPI = new ChildPutByIdUserWebIMP();
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
