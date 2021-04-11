
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.CandidateGetIdIMP;
import models.Candidate_Institution;
import models.User;

public class CandidateGetId extends HttpServlet {

	String id;
	int id_candidate;
    List<Candidate_Institution> l;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		id=request.getParameter("id_candidate");
		id_candidate=Integer.valueOf(id);
		Candidate_Institution cand=new Candidate_Institution();
		cand.setId_candidate(id_candidate);
		//PASSAR O OBJETO
		CandidateGetIdIMP subsc=new CandidateGetIdIMP();
		l=subsc.Get(cand);
		 
		
		//JSON OBJECT
		JSONObject MSG=new JSONObject();
		try {
			MSG.put("MSG", l);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    try {
				out.print(MSG.get("MSG"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    out.flush();   
	
	}
	
}