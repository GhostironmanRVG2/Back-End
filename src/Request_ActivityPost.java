
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


import assets.Request_ActivityMSG;
import connector.Request_ActivityPostIMP;
import models.Request_Activity;

public class Request_ActivityPost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response,int cod,int id_request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject MSG=new JSONObject();
		Request_ActivityMSG M=new Request_ActivityMSG();
		if(cod==200) {
	    try {
			MSG.put("STATUS", M.getStatusS());
			MSG.put("MSG", M.getStatusMsgS());
			MSG.put("id_request", id_request);
			
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
				
			     String id_institution=req.getParameter("id_institution");
			     int id_inst= Integer.parseInt(id_institution);
			     String state=req.getParameter("state");
			     String description=req.getParameter("description");
			     String type=req.getParameter("type");
			     String county=req.getParameter("county");
			     String district=req.getParameter("district");			     
			     String address=req.getParameter("address");
			     String post_code=req.getParameter("post_code");
			     String photo=req.getParameter("photo");   
			     String longitude=req.getParameter("longitude");
			     float longi=Float.valueOf(longitude);
			     String latitude=req.getParameter("latitude");
			     float lat=Float.valueOf(latitude);
			     String time=req.getParameter("time");
			     Time tim=Time.valueOf(time);
			     String date=req.getParameter("date");
			     Date dat=Date.valueOf(date);

	
				//user and password set and get
			     Request_Activity request_activity=new Request_Activity();
			     request_activity.setId_institution(id_inst);
			     request_activity.setState(state);
			     request_activity.setDescription(description);
			     request_activity.setType(type);
			     request_activity.setCounty(county);
			     request_activity.setDistrict(district);
			     request_activity.setAddress(address);
			     request_activity.setPost_code(post_code);
			     request_activity.setPhoto(photo);
			     request_activity.setLatitude(lat);
			     request_activity.setLongitude(longi);
			     request_activity.setTime(tim);
			     request_activity.setDate(dat);

			     

				
				Request_ActivityPostIMP fpimp=new Request_ActivityPostIMP();
				int i=fpimp.insertRequest_Activity(request_activity);
				if(i>0) {
					doGet(req,resp,200,i);
					System.out.println("Sucess");
				}else {doGet(req,resp,400,-1);
				       System.out.println("Something went wrong");
				}
			}
}