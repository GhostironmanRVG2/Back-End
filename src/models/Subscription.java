package models;

public class Subscription {
	String evaluation,photo_1,photo_2,state;
	int id_activity,id_child;
	
	
	
	
	
	public Subscription() {
		super();
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
	public Subscription(String evaluation, String photo_1, String photo_2, String state, int id_activity,
			int id_child) {
		super();
		this.evaluation = evaluation;
		this.photo_1 = photo_1;
		this.photo_2 = photo_2;
		this.state = state;
		this.id_activity = id_activity;
		this.id_child = id_child;
	}
	
	
	
	
	
	
	
	
	
}
