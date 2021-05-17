package models;

public class EvaluationActivity {
	int id_child, id_activity;
	float points;
	

	public EvaluationActivity() {
		super();
	}

	public EvaluationActivity(int id_child, int id_activity, float points) {
		super();
		this.id_child = id_child;
		this.id_activity = id_activity;
		this.points = points;
	}



	public EvaluationActivity(float points) {
		super();
		this.points = points;
	}

	public int getId_child() {
		return id_child;
	}



	public void setId_child(int id_child) {
		this.id_child = id_child;
	}



	public int getId_activity() {
		return id_activity;
	}



	public void setId_activity(int id_activity) {
		this.id_activity = id_activity;
	}



	public float getPoints() {
		return points;
	}



	public void setPoints(float points) {
		this.points = points;
	}
	
	
	
}
