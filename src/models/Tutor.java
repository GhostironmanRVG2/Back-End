package models;

public class Tutor {
	String name,birth_date,address,district,county,post_code;
	int phone_number,id_user,id_tutor;
	
	
	
	public Tutor() {
		super();
	}

	public int getId_tutor() {
		return id_tutor;
	}

	public void setId_tutor(int id_tutor) {
		this.id_tutor = id_tutor;
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
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getCounty() {
		return county;
	}
	
	public void setCounty(String county) {
		this.county = county;
	}
	
	public String getPost_code() {
		return post_code;
	}
	
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	
	public int getPhone_number() {
		return phone_number;
	}
	
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public Tutor(int id_tutor ,String name, String birth_date, String address, String district, String county, String post_code,
			int phone_number, int id_user) {
		super();
		this.id_tutor=id_tutor;
		this.name = name;
		this.birth_date = birth_date;
		this.address = address;
		this.district = district;
		this.county = county;
		this.post_code = post_code;
		this.phone_number = phone_number;
		this.id_user = id_user;
	}
	
	
	
}
