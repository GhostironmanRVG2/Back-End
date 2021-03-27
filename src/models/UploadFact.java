package models;

public class UploadFact {
	int id_fact;
	String photo;
	
	
	
	
	
	public UploadFact() {
		super();
	}
	public int getId_fact() {
		return id_fact;
	}
	public void setId_fact(int id_fact) {
		this.id_fact = id_fact;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public UploadFact(int id_fact, String photo) {
		super();
		this.id_fact = id_fact;
		this.photo = photo;
	}
	
	
	
	
	
	

}
