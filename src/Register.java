import javax.servlet.http.HttpServlet;
import assets.RegisterMSG;
import models.Child;
import models.User;
import connector.RegistVerify;
import connector.RegisterIMP;
import connector.UserGetIdIMP;
import connector.TutorGetByIdUserIMP;
import connector.TutorPostIMP;
import connector.ChildGetByIdIMP;
import connector.ChildPostIMP;
import connector.CollabGetByIDUimp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import connector.TutorGetByIdUserIMP;

import javax.servlet.*;
public class Register extends HttpServlet {
	
	
	
	
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
	Child chi=new Child();
	String status="Active";
	String lt="Child";
	String e=req.getParameter("email");
	String p=req.getParameter("password");
	String name=req.getParameter("name");
	String birth_date=req.getParameter("birth_date");
	String pnt=req.getParameter("phone_number_tutor");
	int phone_number_tutor=Integer.valueOf(pnt);
	String photo=req.getParameter("photo");
	
      
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
		int id=l.getID();
		
		//Realizar o post , coisa linda zé carlos
		chi.setId_user(id);
		chi.setBirth_date(birth_date);
		chi.setName(name);
		chi.setPhone_number_tutor(phone_number_tutor);
		chi.setPhoto(photo);
		
		ChildPostIMP CP=new ChildPostIMP();
		CP.Post(chi);
		
		
		//GRAB id_child and other parameters
		ChildGetByIdIMP data=new ChildGetByIdIMP();
		Child dataF=data.Get(chi);
		
		HttpSession session=req.getSession();
		session.setAttribute("header","Child");
		session.setAttribute("birth_date",dataF.getBirth_date());
		session.setAttribute("id_child", dataF.getId_child());
		session.setAttribute("id_user",dataF.getId_user());
		session.setAttribute("name", dataF.getName());
		session.setAttribute("phone_number_tutor", dataF.getPhone_number_tutor());
		session.setAttribute("photo", dataF.getPhoto());
		session.setAttribute("total_points", dataF.getTotal_points());
		
		
		doGet(req,resp,200);
		
		
		
		
		
		
		
		
	}else {doGet(req,resp,400);
	       
	
	}
}else {
	
	doGet(req,resp,401);
	
	
	
	
	
	
}


}




}