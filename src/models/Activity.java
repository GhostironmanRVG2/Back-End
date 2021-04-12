package models;

public class Activity {
	int id_request,id_reward,id_activity;
	String state;
	
	
	




	public Activity() {
		super();
	}



	public Activity( int id_activity,int id_request, int id_reward,String state) {
		super();
		this.state=state;
		this.id_activity=id_activity;
		this.id_request = id_request;
		this.id_reward = id_reward;
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



	public int getId_request() {
		return id_request;
	}

	public void setId_request(int id_request) {
		this.id_request = id_request;
	}

	public int getId_reward() {
		return id_reward;
	}

	public void setId_reward(int id_reward) {
		this.id_reward = id_reward;
	}

}
