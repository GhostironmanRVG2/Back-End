package models;

public class Child {
	String name,birth_date,photo;
	int id_child,id_user,phone_number_tutor,total_points;

	
	
	
	
	public Child() {
		super();
	}





	public Child(String name, String birth_date, String photo, int id_child, int id_user, int phone_number_tutor,int total_points) {
		super();
		this.total_points=total_points;
		this.name = name;
		this.birth_date = birth_date;
		this.photo = photo;
		this.id_child = id_child;
		this.id_user = id_user;
		this.phone_number_tutor = phone_number_tutor;
	}





	public int getTotal_points() {
		return total_points;
	}





	public void setTotal_points(int total_points) {
		this.total_points = total_points;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getBirth_date() {
		return birth_date;
	}





	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}





	public String getPhoto() {
		return photo;
	}





	public void setPhoto(String photo) {
		this.photo = photo;
	}





	public int getId_child() {
		return id_child;
	}





	public void setId_child(int id_child) {
		this.id_child = id_child;
	}





	public int getId_user() {
		return id_user;
	}





	public void setId_user(int id_user) {
		this.id_user = id_user;
	}





	public int getPhone_number_tutor() {
		return phone_number_tutor;
	}





	public void setPhone_number_tutor(int phone_number_tutor) {
		this.phone_number_tutor = phone_number_tutor;
	}



	
	
	













	
	
}
