import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import connector.PhotoRewardByIdChildGetIMP;
import connector.UserGetIdIMP;
import models.Reward;
import models.User;

public class PhotoRewardByIdChildGet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a object
		UserGetIdIMP UGBII= new UserGetIdIMP();
		
		
		User o=new User();
		String id1=request.getParameter("id_child");
	    int id_child=Integer.valueOf(id1);

        //CRIACAO DO OBJETO
	    Reward R=new Reward();
	    R.setId_child(id_child);
	    
	    
	    
	    //Passar Objeto
	    PhotoRewardByIdChildGetIMP P=new PhotoRewardByIdChildGetIMP();
	    List<Reward> lista=P.get(R);
	    
	    
	    
	    
	    
	    
	    
	    
		
		//JSON OBJECT
		JSONObject MSG=new JSONObject();
		
		try {
			
			MSG.put("MSG", lista);
			
			
			
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
