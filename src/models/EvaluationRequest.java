package models;

public class EvaluationRequest {
	int id_child, id_request;
	float points;
	
	public EvaluationRequest() {
		super();
	}

	public EvaluationRequest(int id_child, int id_request, float points) {
		super();
		this.id_child = id_child;
		this.id_request = id_request;
		this.points = points;
	}

	
	
	
	public EvaluationRequest(float points) {
		super();
		this.points = points;
	}
	

	public int getId_child() {
		return id_child;
	}

	public void setId_child(int id_child) {
		this.id_child = id_child;
	}

	public int getId_request() {
		return id_request;
	}

	public void setId_request(int id_request) {
		this.id_request = id_request;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}
	
	
	
	
	
}
