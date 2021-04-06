package models;

public class Reward {
	String name,photo;
	int points;
	int id_reward;
	int id_child;
	
	public Reward() {
		super();
	}

	public Reward(int id_reward,String name, String photo, int points) {
		super();
		this.id_reward=id_reward;
		this.name = name;
		this.photo = photo;
		this.points = points;
	}
	
	public Reward(String photo) {
		super();
		this.photo=photo;
		
		
		
		
	}
	

	public int getId_child() {
		return id_child;
	}

	public void setId_child(int id_child) {
		this.id_child = id_child;
	}

	public int getId_reward() {
		return id_reward;
	}

	public void setId_reward(int id_reward) {
		this.id_reward = id_reward;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
