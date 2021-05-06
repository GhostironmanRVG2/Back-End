import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.FactGetByIdIMP;
import connector.FactGetByNameIMP;
import models.Fact;

public class FactGetById extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //PASSAR O NOME;
		Fact f=new Fact();
		String id=request.getParameter("id_fact");
		int id_fact=Integer.valueOf(id);
		f.setId_fact(id_fact);
		
		//Executar query
		
		FactGetByIdIMP fn=new FactGetByIdIMP();
		Fact result=fn.get(f);
		
		
		
		
		
		
		
		
		
		//JSON OBJECT
		JSONObject MSG=new JSONObject();
		
		try {
			MSG.put("id_fact", result.getId_fact());
			MSG.put("name", result.getName());
			MSG.put("description",result.getDescription() );
			MSG.put("photo",result.getPhoto() );
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
