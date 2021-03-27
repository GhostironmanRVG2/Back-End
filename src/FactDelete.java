import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.FactDeleteIMP;
import models.Fact;
public class FactDelete extends HttpServlet {
String id;
int p;
int i;
JSONObject obj=new JSONObject();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       Fact f=new Fact();
	       id=request.getParameter("id_fact");
	       p=Integer.parseInt(id);
	       f.setId_fact(p);
	       
	       
	       
	       FactDeleteIMP FDI=new FactDeleteIMP();
	       i=FDI.FDelete(f);
	       
	       if(i>0) {
	    	  try {
				obj.put("STATUS","200");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    	   
	    	   
	    	   
	    	   
	    	   
	       }
	       
	       
	       PrintWriter out = response.getWriter();
	       response.setContentType("application/json");
	       response.setCharacterEncoding("UTF-8");
	       out.print(obj);
	       out.flush();   
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
