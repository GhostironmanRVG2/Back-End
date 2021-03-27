package models;

public class Fact {
	String name,description,photo;
	private int id_fact;

	public Fact(int id_fact,String name, String description, String photo) {
		super();
		this.id_fact=id_fact;
		this.name = name;
		this.description = description;
		this.photo = photo;
	}
	
	
	
	
	
	

	public Fact() {
		super();
	}







	public int getId_fact() {
		return id_fact;
	}







	public void setId_fact(int id_fact) {
		this.id_fact = id_fact;
	}







	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
