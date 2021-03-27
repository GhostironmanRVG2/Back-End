package models;

public class Sugestion {
	String title,designation;
	int id_child,id_sugestion;

	
	
	
	
	
	
	public Sugestion() {
		super();
	}




	public Sugestion(int id_sugestion ,int id_child,String title, String designation) {
		super();
		this.id_sugestion=id_sugestion;
		this.title = title;
		this.designation = designation;
		this.id_child = id_child;
	}

	
	
	
	public int getId_sugestion() {
		return id_sugestion;
	}




	public void setId_sugestion(int id_sugestion) {
		this.id_sugestion = id_sugestion;
	}




	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getId_child() {
		return id_child;
	}

	public void setId_child(int id_child) {
		this.id_child = id_child;
	}
	
}
