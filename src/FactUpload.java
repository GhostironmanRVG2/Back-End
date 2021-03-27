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

import assets.UploadMSG;
import connector.FactUploadIMP;
import models.UploadFact;

public class FactUpload extends HttpServlet {
	String name_photo;
    int s=1;
    String ext;
	UploadMSG u=new UploadMSG();
	public void doPut(HttpServletRequest request, HttpServletResponse response)  
		    throws ServletException, IOException {
		String id_fact=request.getParameter("id_fact");
		int id=Integer.parseInt(id_fact);
		
		//Upload em si  
		response.setContentType("application/xhtml+xml");  
		PrintWriter out = response.getWriter();
		
		
		//FILE UPLOAD
		try {
				MultipartRequest m=new MultipartRequest(request,"C:/Users/pedro/Desktop/Projeto/Projeto/Back-end/WebContent/IMAGES/",100000*512);
				name_photo=m.getFilesystemName("upload");
				int lastIndex = name_photo.lastIndexOf('.');
				 ext = name_photo.substring(lastIndex, name_photo.length());
				}catch(Exception e) {
					s=0;
				}
		
		
		if(s==1) {
		//VERIFICAR EXTENSOES CASO O CASO DE CIMA DE CERTO
		if(ext.equals(".jpg") || ext.equals(".JPG") || ext.equals(".png") || ext.equals(".PNG") || ext.equals(".JPEG") || ext.equals(".jpeg")) {		
		UploadFact f=new UploadFact(1,"lol");
		f.setId_fact(id);
		f.setPhoto(name_photo);		
		FactUploadIMP fu=new FactUploadIMP();
		int i=fu.Upload(f);
		if(i>0) {
		System.out.println("UPDATED WITH SUCESS");
		JSONObject l=new JSONObject();
		try {
			l.put("STATUS",u.getStatusS());
			l.put("MSG", u.getUploadS());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(l);
		out.flush();
		}else {
			try {
				JSONObject l=new JSONObject();
				l.put("STATUS",u.getStatusFbd());
				l.put("MSG", u.getUploadFbd());
				File file = new File("C:/Users/pedro/Desktop/Projeto/Projeto/Back-end/WebContent/IMAGES/"+name_photo);
				out.print(l);
				out.flush();
				 if(file.delete())
			        {
			            System.out.println("File deleted successfully");
			        }
			        else
			        {
			            System.out.println("Failed to delete the file");
			        }
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
			
		}
		
		
				
			
			
			
		
		}else{
			//DELETE FILE SE ESTE NAO FOR DA EXT PRETENDIDA E MANDAR MSG DE ERRO
			File file = new File("C:/Users/pedro/Desktop/Projeto/Projeto/Back-end/WebContent/IMAGES/"+name_photo);
			 if(file.delete())
		        {
		            System.out.println("File deleted successfully");
		        }
		        else
		        {
		            System.out.println("Failed to delete the file");
		        }
			 
			 JSONObject j=new JSONObject();
			 try {
				 j.put("STATUS",u.getStatusFext());
					j.put("MSG", u.getUploadFext());	
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 out.print(j);
			 out.flush();
							
			
			
			
			
		}
		}else {
		

			JSONObject l=new JSONObject();
			try {
				l.put("STATUS",u.getStatusFsize());
				l.put("MSG", u.getUploadFsize());
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			out.print(l);	
		
}
		
		
		
		
	}
	
	
	
	
	
	
}
	
