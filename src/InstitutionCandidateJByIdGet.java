import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.InstitutionCandidateJByIdGetIMP;
import connector.InstitutionCandidateJoinGetIMP;
import models.InstitutionCandidateJoin;

public class InstitutionCandidateJByIdGet extends HttpServlet {

	
	JSONObject l=new JSONObject();	
	List<InstitutionCandidateJoin> o;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
		String id=request.getParameter("id_institution");
		int id_institution=Integer.valueOf(id);
		
		InstitutionCandidateJByIdGetIMP I=new InstitutionCandidateJByIdGetIMP();
		
	        o=I.CandidateJoinGETAll(id_institution);
	        
		
		PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
 
	        
		
	        try {
				l.put("MSG", o);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
 		try { 
				out.print(l.get("MSG"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	
			
		}
	
	
}
