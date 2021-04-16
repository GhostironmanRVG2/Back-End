
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.InstitutionCandidateJoinGetIMP;
import connector.RewardGetIMP;
import models.InstitutionCandidateJoin;
import models.Reward;

public class InstitutionCandidateJoinGet extends HttpServlet {

	
	JSONObject l=new JSONObject();	
	List<InstitutionCandidateJoin> o;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
		InstitutionCandidateJoinGetIMP RGAI=new InstitutionCandidateJoinGetIMP();
	        o=RGAI.ActivityCandidateJoinGETAll();
	        
	        
	        try {
				l.put("", o);
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
