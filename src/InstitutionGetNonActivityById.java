import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityRequestByIdRequestGetIMP;
import connector.InstitutionGetNonActivityByIdImp;
import models.Request_Activity;

public class InstitutionGetNonActivityById extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           JSONObject j=new JSONObject();
		   String id=request.getParameter("id_institution");
		   int id_institution=Integer.parseInt(id);
		   Request_Activity RA=new Request_Activity();
		   RA.setId_institution(id_institution);
		   
		   //Fazer a funcao
		   InstitutionGetNonActivityByIdImp I=new InstitutionGetNonActivityByIdImp();
		   List result=I.get(RA);
		   
	        
	        
	        
	        try {
	        	
	        	j.put("MSG", result);
				
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			 PrintWriter out = response.getWriter();
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    try {
					out.print(j.get("MSG"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    out.flush();   
	        
	        
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
