

package models;

public class Candidate_Institution {

	String name,type,address,county,district,post_code;
	int nif,phone_number,id_candidate;
	
	
	
	
	
	
	
	
	public Candidate_Institution() {
		super();
	}
	public Candidate_Institution(int id_candidate, String name, String type, String address, String county, String district, String post_code, int nif, int phone_number) {
		super();
		this.name = name;
		this.type = type;
		this.address = address;
		this.county = county;
		this.district = district;
		this.post_code = post_code;
		this.nif = nif;
		this.phone_number = phone_number;
		this.id_candidate = id_candidate;
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
	public int getId_candidate() {
		return id_candidate;
	}
	public void setId_candidate(int id_candidate) {
		this.id_candidate = id_candidate;
	}
	
	
	
	
}
