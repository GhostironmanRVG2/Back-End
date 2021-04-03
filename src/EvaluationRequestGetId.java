
	import java.io.IOException;
	import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.json.JSONException;
	import org.json.JSONObject;

import connector.ActivityRequestByIdGetIMP;
import connector.EvaluationRequestGetIdIMP;
	import models.EvaluationRequest;

	public class EvaluationRequestGetId extends HttpServlet {
		String child;
		int id_child;
		String request1;
		int id_request;
	    List<EvaluationRequest> l;
	 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Create a object
			child=request.getParameter("id_child");
			id_child=Integer.valueOf(child);
			request1=request.getParameter("id_request");
			id_request=Integer.valueOf(request1);
			EvaluationRequest subs=new EvaluationRequest();
			subs.setId_child(id_child);
			subs.setId_request(id_request);
			//PASSAR O OBJETO
			EvaluationRequestGetIdIMP subsc=new EvaluationRequestGetIdIMP();
			l=subsc.Get(subs);
			 
			
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
			    out.print(MSG);
			    out.flush();   
			
	
			
		}
		
		
	
		
	}