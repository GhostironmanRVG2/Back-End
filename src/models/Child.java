package models;



public class Child {
	String name,birth_date,photo,login_type,status,evaluation,photo_1,photo_2,state;
	int id_child,id_user,phone_number_tutor,total_points,id_activity;
	
	public Child() {
		super();
	}





	public Child(int id_child, String name,int total_points,String birth_date,String photo,int id_user,int phone_number_tutor,int id_activity,String evaluation,String photo_1,String photo_2,String state) {
		super();
		//CHILD WITH SUBS
		this.id_activity=id_activity;
		this.evaluation=evaluation;
		this.photo_1=photo_1;
		this.photo_2=photo_2;
		this.state=state;
		this.total_points=total_points;
		this.name = name;
		this.birth_date = birth_date;
		this.photo = photo;
		this.id_child = id_child;
		this.id_user = id_user;
		this.phone_number_tutor = phone_number_tutor;
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
	
	
	
	
	
	public Child(int id_user,String login_type,String status,int id_child,String name,int total_points,String birth_date,String photo,int phone_number_tutor) {
		super();
		//CHILD WITH USER JOIN
		this.login_type=login_type;
		this.status=status;
		this.total_points=total_points;
		this.name = name;
		this.birth_date = birth_date;
		this.photo = photo;
		this.id_child = id_child;
		this.id_user = id_user;
		this.phone_number_tutor = phone_number_tutor;
	}



	

	public String getLogin_type() {
		return login_type;
	}





	public void setLogin_type(String login_type) {
		this.login_type = login_type;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
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
