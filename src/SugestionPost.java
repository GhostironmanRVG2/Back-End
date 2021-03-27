import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.SugestionMSG;
import assets.RegisterMSG;
import connector.SugestionPostIMP;
import models.Sugestion;

public class SugestionPost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response,int cod) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject MSG=new JSONObject();
		SugestionMSG M=new SugestionMSG();
		if(cod==200) {
	    try {
			MSG.put("STATUS", M.getStatusS());
			MSG.put("MSG", M.getStatusMsgS());
			
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
	
	
	
	
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
				
				String id = req.getParameter("id_child");
				int c=Integer.valueOf(id);
				String t = req.getParameter("title");
				String d = req.getParameter("designation");
				
				//user and password set and get
				Sugestion sugestion = new Sugestion(9, 9,"lol","lol");
				sugestion.setId_child(c);
				sugestion.setTitle(t);
				sugestion.setDesignation(d);
				
				SugestionPostIMP spimp =new SugestionPostIMP();
				int i = spimp.insertSugestion(sugestion);
				if(i>0) {
					doGet(req,resp,200);
					System.out.println("Sucess");
				}else {doGet(req,resp,400);
				       System.out.println("Something went wrong");
				}
			}
}
