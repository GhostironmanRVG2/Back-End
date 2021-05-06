import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.ChildMSG;
import connector.CandidateInstitutionPutIMP;
import connector.ChildPutIMP;
import connector.InstitutionCandidateJByIdGetIMP;
import models.Candidate_Institution;
import models.Child;
import models.InstitutionCandidateJoin;

public class CandidateInstitutionPut extends HttpServlet {

	
	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		      String id=req.getParameter("id_institution");
		      int id_institution=Integer.valueOf(id);
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
		      InstitutionCandidateJByIdGetIMP G=new InstitutionCandidateJByIdGetIMP();
		      List listaExt=G.CandidateJoinGETAll(id_institution);
		      InstitutionCandidateJoin CI=(InstitutionCandidateJoin)listaExt.get(0);
		      int id_candidate=CI.getId_candidate();
		
		       //Object Child
		      
		      Candidate_Institution k=new Candidate_Institution();
		      k.setAddress(address);
		      k.setCounty(county);
		      k.setDistrict(district);
		      k.setEmail(email);
		      k.setId_candidate(id_candidate);
		      k.setName(name);
		      k.setNif(nif);
		      k.setPhone_number(phone_number);
		      k.setPost_code(post_code);
		      
		      
		      
		      CandidateInstitutionPutIMP CIPI=new CandidateInstitutionPutIMP();
				int i = CIPI.DoPut(k);
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
