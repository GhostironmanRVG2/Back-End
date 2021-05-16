
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import assets.UserMSG;
import connector.CandidatePutIMP;
import models.Candidate_Institution;

public class CandidatePut extends HttpServlet {

	
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
	     String name=req.getParameter("name");
	     String address=req.getParameter("address");
	     String county=req.getParameter("county");
	     String district=req.getParameter("district");
	     String post_code=req.getParameter("post_code");
	     String id=req.getParameter("phone_number");
	     int phone_number=Integer.valueOf(id);
	     String id2=req.getParameter("id_candidate");
	     int id_candidate=Integer.valueOf(id2);
		
		       //Object Facts
	     Candidate_Institution R=new Candidate_Institution();
	      R.setAddress(address);
	      R.setCounty(county);
	      R.setDistrict(district);
	      R.setPost_code(post_code);
	      R.setName(name);
	      R.setId_candidate(id_candidate);
	      R.setPhone_number(phone_number);
		       
		       
				
	      CandidatePutIMP AR=new CandidatePutIMP();  
		   int i=AR.Put(R);
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
		UserMSG M=new UserMSG();
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