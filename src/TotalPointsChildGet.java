import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.ActivityGetIMP;
import connector.TotalPointsChildGetIMP;
import models.Reward;

public class TotalPointsChildGet extends HttpServlet {
JSONObject l=new JSONObject();
Reward r=new Reward();
Reward result=new Reward();
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
	   String id=request.getParameter("id_child");
	   int id_child=Integer.valueOf(id);
	   
	   r.setId_child(id_child);
	   
	   TotalPointsChildGetIMP t=new TotalPointsChildGetIMP();
	   result=t.get(r);
	   
	   
        
        
        
        try {
			l.put("total_points",result.getPoints() );
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		 PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    out.print(l);
		    out.flush();   
        
        
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
