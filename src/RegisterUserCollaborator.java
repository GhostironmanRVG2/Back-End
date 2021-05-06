
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.RegisterMSG;
import connector.RegistVerify;
import connector.RegisterIMP;
import models.Collaborator;
import models.User;

public class RegisterUserCollaborator extends HttpServlet {

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
		Collaborator c=new Collaborator();
		 String p=req.getParameter("password");
		 String e=req.getParameter("email");
		 String status="Active";
		 String lt="Collaborator";
	      
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
						
					
			
			
			
			
			doGet(req,resp,200);
			
			
			
			
			
			
			
	}else {
		
		doGet(req,resp,401);
		
		
		
		
		
		
	}


	}




	}