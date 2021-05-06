import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.ActivityMSG;
import connector.ActivityPostIMP;
import connector.CandidatePostIMP;
import models.Activity;
import models.Candidate_Institution;

public class CandidatePost extends HttpServlet {

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response,int cod) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject MSG=new JSONObject();
		ActivityMSG M=new ActivityMSG();
		if(cod==200) {
	    try {
			MSG.put("STATUS", M.getStatusS());
			MSG.put("MSG", "SUCESS");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			try {
				MSG.put("STATUS",M.getStatusF());
				MSG.put("MSG", "ERROR");
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
	
	
	
	
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
		    
			String name=req.getParameter("name");
			String n=req.getParameter("nif");
			int nif=Integer.valueOf(n);
			String address=req.getParameter("address");
			String county=req.getParameter("county");
			String district=req.getParameter("district");
			String post_code=req.getParameter("post_code");
			String pn=req.getParameter("phone_number");
			int phone_number=Integer.valueOf(pn);
			String email=req.getParameter("email");
		
		//CANDIDATE
		    Candidate_Institution CI=new Candidate_Institution();
		    
		    CI.setAddress(address);
		    CI.setCounty(county);
		    CI.setDistrict(district);
		    CI.setEmail(email);
		    CI.setName(name);
		    CI.setNif(nif);
		    CI.setPhone_number(phone_number);
		    CI.setPost_code(post_code);
		    
		
		
				
				CandidatePostIMP CPI=new CandidatePostIMP();
				int i=CPI.insert(CI);
				if(i>0) {
					doGet(req,resp,200);
					System.out.println("Sucess");
				}else {doGet(req,resp,400);
				       System.out.println("Something went wrong");
				}
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
