package models;

import java.util.Date;

public class ChildSubscriptionJoin {
	String evaluation, photo_1, photo_2, state, name, birth_date, photo,description;
	int id_activity, id_child, total_points, id_user, phone_number_tutor, id_institution;
	Date date;
	
	
	public ChildSubscriptionJoin() {}
	
	public ChildSubscriptionJoin(String evaluation, String photo_1, String photo_2, String state, String name,
			String birth_date, String photo, int id_activity, int id_child, int total_points, int id_user,
			int phone_number_tutor, int id_institution) {
		super();
		this.evaluation = evaluation;
		this.photo_1 = photo_1;
		this.photo_2 = photo_2;
		this.state = state;
		this.name = name;
		this.birth_date = birth_date;
		this.photo = photo;
		this.id_activity = id_activity;
		this.id_child = id_child;
		this.total_points = total_points;
		this.id_user = id_user;
		this.phone_number_tutor = phone_number_tutor;
		this.id_institution = id_institution;
	}

	
	public ChildSubscriptionJoin(String evaluation, String photo_1, String photo_2, String state, String name,
			String birth_date, String photo, int id_activity, int id_child, int total_points, int id_user,
			int phone_number_tutor, int id_institution,String description) {
		super();
		this.evaluation = evaluation;
		this.photo_1 = photo_1;
		this.photo_2 = photo_2;
		this.state = state;
		this.name = name;
		this.birth_date = birth_date;
		this.photo = photo;
		this.id_activity = id_activity;
		this.id_child = id_child;
		this.total_points = total_points;
		this.id_user = id_user;
		this.phone_number_tutor = phone_number_tutor;
		this.id_institution = id_institution;
		this.description=description;
	}
	
	
	public ChildSubscriptionJoin(String evaluation, String photo_1, String photo_2, String state, String name,
			String birth_date, String photo, int id_activity, int id_child, int total_points, int id_user,
			int phone_number_tutor, int id_institution,String description,Date date) {
		super();
		this.evaluation = evaluation;
		this.photo_1 = photo_1;
		this.photo_2 = photo_2;
		this.state = state;
		this.name = name;
		this.birth_date = birth_date;
		this.photo = photo;
		this.id_activity = id_activity;
		this.id_child = id_child;
		this.total_points = total_points;
		this.id_user = id_user;
		this.phone_number_tutor = phone_number_tutor;
		this.id_institution = id_institution;
		this.description=description;
		this.date=date;
	}
	
	

	public ChildSubscriptionJoin(String state, String name, String birth_date, String photo, int id_activity,
			int id_child, int total_points, int id_user, int phone_number_tutor) {
		super();
		this.state = state;
		this.name = name;
		this.birth_date = birth_date;
		this.photo = photo;
		this.id_activity = id_activity;
		this.id_child = id_child;
		this.total_points = total_points;
		this.id_user = id_user;
		this.phone_number_tutor = phone_number_tutor;
	}




	
	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEvaluation() {
		return evaluation;
	}


	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}


	public String getPhoto_1() {
		return photo_1;
	}


	public void setPhoto_1(String photo_1) {
		this.photo_1 = photo_1;
	}


	public String getPhoto_2() {
		return photo_2;
	}


	public void setPhoto_2(String photo_2) {
		this.photo_2 = photo_2;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
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


	public int getId_activity() {
		return id_activity;
	}


	public void setId_activity(int id_activity) {
		this.id_activity = id_activity;
	}


	public int getId_child() {
		return id_child;
	}


	public void setId_child(int id_child) {
		this.id_child = id_child;
	}


	public int getTotal_points() {
		return total_points;
	}


	public void setTotal_points(int total_points) {
		this.total_points = total_points;
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

	public int getId_institution() {
		return id_institution;
	}

	public void setId_institution(int id_institution) {
		this.id_institution = id_institution;
	}
	
	
}
