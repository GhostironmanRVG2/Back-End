import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import assets.UserMSG;
import connector.ActivityRequestPutIMP;
import connector.UserPutIMP;
import models.Request_Activity;
import models.User;

public class ActivityRequestPut extends HttpServlet {

	protected void doPut(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
	           			
		      //Parametros
		     String description=req.getParameter("description");
		     String type=req.getParameter("type");
		     String address=req.getParameter("address");
		     String district=req.getParameter("district");
		     String county=req.getParameter("county");
		     String post_code=req.getParameter("post_code");
		     String l=req.getParameter("latitude");
		     float latitude=Float.valueOf(l);
		     String lo=req.getParameter("longitude");
		     float longitude=Float.valueOf(lo);
		     String id=req.getParameter("id_request");
		     int id_request=Integer.valueOf(id);
		     String d=req.getParameter("date");
		     Date date=Date.valueOf(d);
		     String t=req.getParameter("time");
		     Time time=Time.valueOf(t);
		     String state=req.getParameter("state");
		    
		
		       //Object request
		      Request_Activity R=new Request_Activity();
		      R.setAddress(address);
		      R.setCounty(county);
		      R.setDescription(description);
		      R.setDistrict(district);
		      R.setId_request(id_request);
		      R.setLatitude(latitude);
		      R.setLongitude(longitude);
		      R.setPost_code(post_code);
		      R.setType(type);
		      R.setDate(date);
		      R.setTime(time);
		      R.setState(state);
		       
		      //Connector 
			  ActivityRequestPutIMP AR=new ActivityRequestPutIMP();  
			   int i=AR.Put(R);
				if(i>0) {
					doGet(req,resp,200);
					System.out.println("Sucess");
				}else {doGet(req,resp,400);
				       System.out.println("Something went wrong");

				
				}
	
			}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response,int cod) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject MSG=new JSONObject();
		UserMSG M=new UserMSG();
		if(cod==200) {
	    try {
			MSG.put("STATUS", M.getStatusS());
			MSG.put("MSG", M.getUpdateSucess());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			try {
				MSG.put("STATUS",M.getStatusF());
				MSG.put("MSG", M.getUpdateFailure());
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
