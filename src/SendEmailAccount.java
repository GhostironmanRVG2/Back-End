import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.PassResetPostIMP;
import connector.UserGetIdIMP;
import models.User;

public class SendEmailAccount extends HttpServlet{

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        String email=request.getParameter("email");
        String passwordSend=request.getParameter("password");
		final String username = "prochildorganization@gmail.com";
        final String password = "DAIProChild";

        //VERIFY IF THE EMAIL IS ON THE DATA BASE 
        User user=new User();
        UserGetIdIMP IMP= new UserGetIdIMP();
        user.setEmail(email);
        User j=IMP.getByID(user);
        
        PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
        JSONObject k=new JSONObject();
        
        
        if(!(j.getEmail()==null)) {
       
      
        
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        
           try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Paizao"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Confirmation");
            message.setText("Confirmation");

            message.setContent(

            		"<div class='w3-container' style='background-color:#46D0D9; border: 20%; width: 50%; height: 40%;text-align: center;'>"+

            		    "<h1 style='color: aliceblue;border: 10%;border: black;border-style: double;'>KIDSLAND</h1>"+

            		    "<div>"+
            		    "<img src='http://188.82.156.135:8080/Back-end/IMAGES/image%201.png'>"+
            		"</div>"+


            		    "<div class='w3-container w3-center w3-animate-top'>"+
            		    
                            "<h1 style='font-family:Arial, Helvetica, sans-serif'>Parabéns, a sua instituição foi aceite para colaborar com a Kidsland...aqui tem as suas credenciais::</h1>"+
            		        
            		        
            		        "<p style='font-family:Arial, Helvetica, sans-serif'>email:</p>"+
            		        "<p style='font-size: medium;'>"+email+"</p>"+
            		        
                            "<p style='font-family:Arial, Helvetica, sans-serif'>password:</p>"+
                            "<p style='font-size: medium;'>"+passwordSend+"</p>"+
            		      
            		      
            		      
            		      
            		      "</div>"+
            		      
            	"</div>"
            		
            	         , "text/html; charset=utf-8");
            
            Transport.send(message);
            k.put("STATUS", 200);
            k.put("MSG", "EMAIL SENDED WITH SUCESS");
            k.put("email", user.getEmail());
            k.put("PATH", "IdentifyCodeActivity");
            out.print(k);
            

    }catch(Exception e){
    	System.out.println(e);
    }
    }else {
    	
    try {
		k.put("STATUS", 400);
		k.put("MSG", "THE EMAIL DOESNT EXIST IN THE BD");
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    	out.print(k);
    	
    	
    }
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
