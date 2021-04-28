import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.oreilly.servlet.MultipartRequest;  
public class Upload extends HttpServlet {
int s=1;
String name_photo,ext;	
JSONObject j=new JSONObject();
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
		    throws ServletException, IOException {  
		  
		response.setContentType("application/xhtml+xml");  
		PrintWriter out = response.getWriter();  
		try {          
		MultipartRequest m=new MultipartRequest(request,"C:/Users/pedro/Desktop/Projeto/Projeto/Back-end/WebContent/IMAGES/");
		name_photo=m.getFilesystemName("upload");
		int lastIndex=name_photo.lastIndexOf(".");
		ext = name_photo.substring(lastIndex, name_photo.length());
		}catch(Exception e) {
			
		System.out.println(e);	
		s=0;	
			
		}
		
        if(s==1) {
        	if(ext.equals(".jpg") || ext.equals(".JPG") || ext.equals(".png") || ext.equals(".PNG") || ext.equals(".JPEG") || ext.equals(".jpeg")) {	
        	
       	
           try {
			j.put("STATUS", "200");
			j.put("MSG","SUCESS");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
           
           out.print(j);
        	
        	
        	
        	}else{	             
        		
        		
        		
        		File file = new File("C:/Users/pedro/Desktop/Projeto/Projeto/Back-end/WebContent/IMAGES/"+name_photo);
   			 if(file.delete())
   		        {
   		            System.out.println("File deleted successfully");
   		         try {
					j.put("STATUS", "400");
					j.put("MSG","FAIL");
					out.print(j);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
   	           
   		        }
   		        else
   		        {
   		            System.out.println("Failed to delete the file");
   		        }
        		
        		
        		
        		
        		
        		
        		
        		
        		
        	}
        	
        	
        	
        	
        	
        	
        	
        }else {
		
		System.out.println("Something went wrong");
		 try {
			j.put("STATUS", "400");
			j.put("MSG","FAIL");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	           out.print(j);
		
        }
		
		
		
		}  
		}  
	
	
	
	
	

