
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.CollaboratorMSG;
import connector.CollaboratorPutByCollaboratorIMP;
import connector.UserPutIMP;
import models.Collaborator;

public class CollaboratorPutByCollaborator extends HttpServlet {

	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		     String name=req.getParameter("name");
		     String address=req.getParameter("address");
		     String county=req.getParameter("county");
		     String district=req.getParameter("district");
		     String post_code=req.getParameter("post_code");
		     String nf=req.getParameter("nif");
		     int nif=Integer.valueOf(nf);
		     String pho=req.getParameter("phone_number");
		     int phone_number=Integer.valueOf(pho);
		     String email=req.getParameter("email");
		     String user=req.getParameter("id_user");
		     int id_user=Integer.valueOf(user);
		     String col=req.getParameter("id_collaborator");
		     int id_collaborator=Integer.valueOf(col);

		
		       //Object request
		      Collaborator R=new Collaborator();
		      R.setName(name);
		      R.setAddress(address);
		      R.setCounty(county);
		      R.setDistrict(district);
		      R.setPost_code(post_code);
		      R.setNif(nif);
		      R.setPhone_number(phone_number);
		      R.setEmail(email);
		      R.setId_user(id_user);
		      R.setId_collaborator(id_collaborator);
		       
		      //Connector 
		      CollaboratorPutByCollaboratorIMP c=new CollaboratorPutByCollaboratorIMP();  
			   int i=c.Put(R);
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
		CollaboratorMSG M=new CollaboratorMSG();
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
