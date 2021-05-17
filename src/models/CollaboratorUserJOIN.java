package models;

public class CollaboratorUserJOIN {

	int id_collaborator, id_user,nif,phone_number;
	String name,type,address,county,district,post_code,status,email;
	
	
	public CollaboratorUserJOIN(int id_collaborator, int id_user, int nif, int phone_number, String name, String type,
			String address, String county, String district, String post_code, String status) {
		super();
		this.id_collaborator = id_collaborator;
		this.id_user = id_user;
		this.nif = nif;
		this.phone_number = phone_number;
		this.name = name;
		this.type = type;
		this.address = address;
		this.county = county;
		this.district = district;
		this.post_code = post_code;
		this.status = status;
	}


	public CollaboratorUserJOIN(int id_collaborator, int id_user, int nif, int phone_number, String name, String type,
			String address, String county, String district, String post_code, String status, String email) {
		super();
		this.id_collaborator = id_collaborator;
		this.id_user = id_user;
		this.nif = nif;
		this.phone_number = phone_number;
		this.name = name;
		this.type = type;
		this.address = address;
		this.county = county;
		this.district = district;
		this.post_code = post_code;
		this.status = status;
		this.email = email;
	}
	
	
	public CollaboratorUserJOIN() {
		// TODO Auto-generated constructor stub
	}


	public int getId_collaborator() {
		return id_collaborator;
	}


	public void setId_collaborator(int id_collaborator) {
		this.id_collaborator = id_collaborator;
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


	public int getNif() {
		return nif;
	}


	public void setNif(int nif) {
		this.nif = nif;
	}


	public int getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCounty() {
		return county;
	}


	public void setCounty(String county) {
		this.county = county;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getPost_code() {
		return post_code;
	}


	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}
