import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.FactGetByNameIMP;
import connector.UserGetIdIMP;
import models.Fact;
import models.User;

public class FactGetByName extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //PASSAR O NOME;
		Fact f=new Fact();
		String name=request.getParameter("name");
		f.setName(name);
		
		//Executar query
		
		FactGetByNameIMP fn=new FactGetByNameIMP();
		Fact result=fn.get(f);
		
		
		
		
		
		
		
		
		
		//JSON OBJECT
		JSONObject MSG=new JSONObject();
		
		try {
			MSG.put("id_fact", result.getId_fact());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		 PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    out.print(MSG);
		    out.flush();   
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
