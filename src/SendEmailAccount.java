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
            message.setText("Candidatura-Kidsland");

            message.setContent(
            		"<div class=''><div class='aHl'></div><div id=':1b0' tabindex='-1'></div><div id=':1bb' class='ii gt'><div id=':1bc' class='a3s aiL '>Cara Instituição, <br><br>Informamos que a sua candidatura foi aceite com sucesso.  <br><br> <p style='font-weight: bold; font-size: 12px;'>Credenciais de Autentição:</p> <p style='font-size: 10px;'>Utilizador: "+email+"</p> <p style='font-size: 10px;'>Password: "+passwordSend+"</p> <br>Por questões de segurança, deverá alterar posteriormente a sua palavra-passe.<br><br>Agradecemos a sua preferência,<br><br><img src='https://i.ibb.co/gM7pTjQ/logo.png' alt='logo' height='102' width='150' class='CToWUd'><br><span class='il'>KidsLand</span> - ProChild"+
            	    "</div><div class='yj6qo'></div></div><div id=':1aw' class='ii gt' style='display:none'><div id=':1av' class='a3s aiL '></div></div><div class='hi'></div></div>"
            		
            		
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
