package models;

public class Institution {

	int id_institution, id_user, id_candidate;
	
	
	
	
	
	
	
	
	public Institution() {
		super();
	}
	public Institution(int id_institution, int id_user, int id_candidate) {
		super();
		this.id_institution = id_institution;
		this.id_user = id_user;
		this.id_candidate = id_candidate;
	}
	public int getId_institution() {
		return id_institution;
	}
	public void setId_institution(int id_institution) {
		this.id_institution = id_institution;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_candidate() {
		return id_candidate;
	}
	public void setId_candidate(int id_candidate) {
		this.id_candidate = id_candidate;
	}

	
	
	
	
}
