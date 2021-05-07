import java.io.IOException;
import java.io.PrintWriter;

import connector.ChildGetByIdIMP;
import connector.CollabGetByIDUimp;
import connector.InstitutionGetByIdIMP;
import connector.LoginIMP;
import assets.LoginMSG;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import assets.RegisterMSG;
import connector.RegisterIMP;
import connector.TutorGetByIdUserIMP;
import connector.UserGetIdIMP;
import models.Candidate_Institution;
import models.Child;
import models.Collaborator;
import models.Tutor;
import models.User;

public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
		        Child j=new Child();
		        HttpSession session=req.getSession();
				String e=req.getParameter("email");
				String p=req.getParameter("password");
			      
				
		
				
				//user and password set and get
				User user=new User();
				user.setEmail(e);
				user.setPassword(p);
				
				LoginIMP limp=new LoginIMP();
				User o=limp.LoginUser(user);
				//Verify password
				try {
				if(o.getStatus().equals("Active")) {
				
				if(o.getEmail()!="400") {
				 String salt = o.getSalt();
			        
			        boolean passwordMatch = PasswordUtils.verifyUserPassword(user.getPassword(), o.getPassword(), salt);
			        if(passwordMatch) 
			        	
			        {   
			            
			            //SACAR LOGIN TYPE
			            UserGetIdIMP rev=new UserGetIdIMP();
			            User k =rev.getByID(user);
			         
			          if(k.loginT().equals("Child")) {
			               j.setId_user(k.getID());
			        	   ChildGetByIdIMP CGBI=new ChildGetByIdIMP();
			        	   Child l=CGBI.Get(j);
			        	   
			               
			        	   
			            		
			                doGet(req,resp,200,k,l);
			            	
			            	
			            	
			            	
			           }else if(k.loginT().equals("Collaborator")) {
			            	
			        	   //SACAR LOGIN TYPE
				            UserGetIdIMP lol=new UserGetIdIMP();
				            User l =rev.getByID(user);
			            	
			            	//CRIAR COLLAB
			            	
			            	CollabGetByIDUimp id_col=new CollabGetByIDUimp();
			                Collaborator ñ=id_col.Get(k);
							session.setAttribute("header","Collaborator");
					        session.setAttribute("address",ñ.getAddress());
					        session.setAttribute("county", ñ.getCounty());
					        session.setAttribute("district", ñ.getDistrict());
					        session.setAttribute("id_user", ñ.getId_user());
					        session.setAttribute("name", ñ.getName());
					        session.setAttribute("nif", ñ.getNif());
					        session.setAttribute("phone_number", ñ.getPhone_number());
					        session.setAttribute("post_code",ñ.getPost_code());
					        session.setAttribute("type", ñ.getType());
					        session.setAttribute("id_collaborator", ñ.getId_collaborator());
					       
					        doGet(req,resp,200,l,ñ);
			            	
			            	
			            	
			            	
			            	
			            	
			            	
			            	
			            }else{
			            	
			            	//SACAR LOGIN TYPE
				            UserGetIdIMP l2=new UserGetIdIMP();
				            User l=rev.getByID(user);
			            	//CRIAR INSTI
				            InstitutionGetByIdIMP insti=new InstitutionGetByIdIMP();
				            Candidate_Institution ñ=insti.get(k);
				            session.setAttribute("header","Institution");
					        session.setAttribute("address",ñ.getAddress());
					        session.setAttribute("county", ñ.getCounty());
					        session.setAttribute("district", ñ.getDistrict());
					        session.setAttribute("id_user", ñ.getId_user());
					        session.setAttribute("name", ñ.getName());
					        session.setAttribute("nif", ñ.getNif());
					        session.setAttribute("phone_number", ñ.getPhone_number());
					        session.setAttribute("post_code",ñ.getPost_code());
					        session.setAttribute("id_candidate", ñ.getId_candidate());
					        doGet(req,resp,200,l,ñ);
			            	
			            	
			            	
			            	
			            	
			            }
			            
			            
			            
			            
			            
			            
			            
			            
			            
			            
			            
			        } else {
			        	doGet(req,resp,400,null,null);
			            
			            session.invalidate();
			        }
				
				}else {
				doGet(req,resp,400,null,null);
				
				session.invalidate();
					
				}
				
				}else {
					
				doGet(req,resp,400,null,null);
					
					
				}
				
				}catch(Exception lol) {
					
					doGet(req,resp,400,null,null);
					
					
					
				}
			
			}
				
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response,int cod,Object user,Object login) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject MSG=new JSONObject();
		LoginMSG M=new LoginMSG();
		Child i=new Child();
		User h=new User();
		Collaborator c=new Collaborator();
		Candidate_Institution in=new Candidate_Institution();
		if(cod==200) {
	    try {
	    	if(login.getClass().equals(i.getClass())) {
			MSG.put("STATUS", M.getStatusS());
			MSG.put("MSG", M.getStatusMsgS());
			MSG.put("PATH", M.getMobilePathS());
			//Dados User
			h=(User)user;
			MSG.put("id_user",h.getID() );
			MSG.put("email",h.getEmail() );
			MSG.put("status_user",h.getStatus());
			//Dados Child
			i=(Child)login;
			MSG.put("id_child",i.getId_child() );
			MSG.put("phone_number_tutor",i.getPhone_number_tutor() );
			MSG.put("total_points",i.getTotal_points() );
			MSG.put("birth_date",i.getBirth_date() );
			MSG.put("name",i.getName() );
			MSG.put("photo",i.getPhoto() );
			 MSG.put("PathWeb", "backoffice/CM_index.html");
			
			
			
			
	    	}else if(login.getClass().equals(c.getClass())){
	    	MSG.put("STATUS", M.getStatusS());
	    	MSG.put("MSG",M.getStatusMsgS() );
	    	
	    	//dados user
	    	h=(User)user;
	    	MSG.put("id_user",h.getID() );
			MSG.put("email",h.getEmail() );
			MSG.put("status_user",h.getStatus());
	    	//dados collab
	    	c=(Collaborator)login;
	    	MSG.put("id_collaborator",c.getId_collaborator() );
	    	MSG.put("id_user",c.getId_user() );
	    	MSG.put("nif",c.getNif() );
	    	MSG.put("phone_number",c.getPhone_number() );
	    	MSG.put("address",c.getAddress() );
	    	MSG.put("county", c.getCounty());
	    	MSG.put("district",c.getDistrict() );
	    	MSG.put("name",c.getName() );
	    	MSG.put("post_code",c.getPost_code() );
	    	MSG.put("type",c.getType() );
	        MSG.put("PATH", "backoffice/CM_ActionPlan.html");
	    		
	    		
	    		
	    	}else {
	    		MSG.put("STATUS", M.getStatusS());
		    	MSG.put("MSG",M.getStatusMsgS() );
		    	//dados user
		    	h=(User)user;
		    	MSG.put("id_user",h.getID() );
				MSG.put("email",h.getEmail() );
				MSG.put("status_user",h.getStatus());
				//dados 
				 in=(Candidate_Institution)login;
				 MSG.put("PATH", "backoffice/IT_ListActivies.html");
				 MSG.put("id_candidate",in.getId_candidate() );
				 MSG.put("nif",in.getNif() );
				 MSG.put("phone_number",in.getPhone_number() );
				 MSG.put("address",in.getAddress() );
				 MSG.put("county", in.getCounty());
				 MSG.put("district", in.getDistrict());
				 MSG.put("name",in.getName() );
				 MSG.put("post_code",in.getPost_code() );
				 
	    		
	    		
	    		
	    		
	    	}
			
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			try {
				MSG.put("STATUS",M.getStatusF());
				MSG.put("MSG", M.getStatusMsgM());
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
