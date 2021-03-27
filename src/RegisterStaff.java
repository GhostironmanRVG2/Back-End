import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import assets.RegisterMSG;
import connector.CollabPostIMP;
import connector.RegistVerify;
import connector.RegisterIMP;
import connector.UserGetIdIMP;
import models.Collaborator;
import models.User;
import connector.CollabGetByIDUimp;

public class RegisterStaff extends HttpServlet {
	
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
				Collaborator colab=new Collaborator();
				String status="Active";
				String lt="Collaborator";
				String e=req.getParameter("email");
				String p=req.getParameter("password");
				String n=req.getParameter("name");
				String ni=req.getParameter("nif");
				int nif=Integer.valueOf(ni);
				String t=req.getParameter("type");
				String a=req.getParameter("address");
				String c=req.getParameter("county");
				String d=req.getParameter("district");
				String pc=req.getParameter("post_code");
				String pn=req.getParameter("phone_number");
				int pnn=Integer.valueOf(pn);
				
				
				
			      
			      // Generate Salt. The generated value can be stored in DB. 
			      String salt = PasswordUtils.getSalt(30);
			      
			      // Protect user's password. The generated value can be stored in DB.
			      String mySecurePassword = PasswordUtils.generateSecurePassword(p, salt);
			      
			      // Print out protected password 
			      System.out.println("My secure password = " + mySecurePassword);
			      System.out.println("Salt value = " + salt);
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
					int id=l.getID();
					
					//Realizar o post , coisa linda zé carlos
					colab.setAddress(a);
					colab.setCounty(c);
					colab.setDistrict(d);
					colab.setId_user(id);
					colab.setName(n);
					colab.setNif(nif);
					colab.setPhone_number(pnn);
					colab.setPost_code(pc);
					colab.setType(t);
					CollabPostIMP CPI=new CollabPostIMP();
					CPI.insertCollab(colab);
	                CollabGetByIDUimp id_col=new CollabGetByIDUimp();
	                Collaborator ñ=id_col.Get(l);
	                
					HttpSession session=req.getSession();
					session.setAttribute("header","Collaborator");
			        session.setAttribute("address",a);
			        session.setAttribute("county", c);
			        session.setAttribute("district", d);
			        session.setAttribute("id_user", id);
			        session.setAttribute("name", n);
			        session.setAttribute("nif", nif);
			        session.setAttribute("phone_number", pnn);
			        session.setAttribute("post_code",pc);
			        session.setAttribute("type", t);
			        session.setAttribute("id_collaborator", ñ.getId_collaborator());
			        
					doGet(req,resp,200);
					
					System.out.println("Sucess");
					
					
					
					
					
					
				}else {doGet(req,resp,400);
				       System.out.println("Something went wrong");

				
				}
			}else {
				
				doGet(req,resp,401);
				System.out.println("This email already exists");
				
				
				
				
				
			}


			}




			}
