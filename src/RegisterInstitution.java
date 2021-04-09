import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.RegisterMSG;
import connector.InstitutionPostIMP;
import connector.RegistVerify;
import connector.RegisterIMP;
import connector.UserGetIdIMP;
import models.Candidate_Institution;
import models.User;

public class RegisterInstitution extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response,int cod) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject MSG=new JSONObject();
		RegisterMSG M=new RegisterMSG();
		if(cod==200) {
	    try {
			MSG.put("STATUS", M.getStatusS());
			MSG.put("MSG", M.getStatusMsgS());
			MSG.put("PATH", M.getMobilePathS());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if(cod==400) {
			try {
				MSG.put("STATUS",M.getStatusF());
				MSG.put("MSG", M.getStatusMsgM());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
		
			try {
				MSG.put("STATUS", "401");
				MSG.put("MSG", "Duplicated");
				
				
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
		 Candidate_Institution c=new Candidate_Institution();
		 String p=req.getParameter("password");
		 String e=req.getParameter("email");
		 String name=req.getParameter("name");
		 String n=req.getParameter("nif");
		 int nif=Integer.valueOf(n);
		 String address=req.getParameter("address");
		 String county=req.getParameter("county");
		 String district=req.getParameter("district");
		 String post_code=req.getParameter("post_code");
		 String ph=req.getParameter("phone_number");
		 int phone_number=Integer.valueOf(ph);
		 String status="Inactive";
		 String lt="Institution";
	      
	      // Generate Salt. The generated value can be stored in DB. 
	      String salt = PasswordUtils.getSalt(30);
	      
	      // Protect user's password. The generated value can be stored in DB.
	      String mySecurePassword = PasswordUtils.generateSecurePassword(p, salt);
	      
		//CRIACAO DO OBJETO
		User user=new User();
		user.setEmail(e);
		
	    //Verificar se é duplicado ou nao!
		
		RegistVerify RV=new RegistVerify();
		int valid=RV.Verify(user);
		
		if(valid == 0) {
	            
	      
	      
	      
	      
		//REGIST
	    user.setStatus(status);
		user.setLoginT(lt);
		user.setPassword(mySecurePassword);
		user.setSalt(salt);
		RegisterIMP rimp=new RegisterIMP();
		int i=rimp.registerUser(user);
		if(i>0) {
			//SACAR O ID DO USER ATRAVES DO EMAIL
			User k=new User();
			k.setEmail(e);
			UserGetIdIMP j=new UserGetIdIMP();
			User l=j.getByID(k);
			//ID DO USER
			int id_user=l.getID();
			
		
			
			
			
			
			
			//Realizar o post , coisa linda zé carlos
			c.setNif(nif);
			c.setAddress(address);
			c.setCounty(county);
			c.setDistrict(district);
			c.setName(name);
			c.setPhone_number(phone_number);
			c.setPost_code(post_code);
			c.setId_user(id_user);
			InstitutionPostIMP I=new InstitutionPostIMP();
			I.Post(c);
						
					
			
			
			
			
			doGet(req,resp,200);
			
			
			
			
			
			
			
			
		}else {doGet(req,resp,400);
		       
		
		}
	}else {
		
		doGet(req,resp,401);
		
		
		
		
		
		
	}


	}




	}
	
	
