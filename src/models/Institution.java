package models;

public class Institution {

	int id_institution, id_user, id_candidate,phone_number,nif,count;
	String login_type,status,name,address,county,district,post_code;
	
	
	
	
	
	
	
	
	public Institution() {
		super();
	}
	public Institution(int id_institution, int id_user, int id_candidate) {
		super();
		this.id_institution = id_institution;
		this.id_user = id_user;
		this.id_candidate = id_candidate;
	}
	
	public Institution(int id_user, String login_type,String status, int id_institution, int id_candidate,String name,int nif,String address,String county,String district,String post_code,int phone_number) {
		//JOIN CANDIDATE USER
		super();
		this.address=address;
		this.county=county;
		this.district=district;
		this.login_type=login_type;
		this.name=name;
		this.nif=nif;
		this.phone_number=phone_number;
		this.post_code=post_code;
		this.status=status;
		this.id_institution = id_institution;
		this.id_user = id_user;
		this.id_candidate = id_candidate;
	}
	
	
	public Institution(int id_user, String login_type,String status, int id_institution, int id_candidate,String name,int nif,String address,String county,String district,String post_code,int phone_number,int count) {
        //JOIN CANDIDATE USER
        this.address=address;
        this.county=county;
        this.district=district;
        this.login_type=login_type;
        this.name=name;
        this.nif=nif;
        this.phone_number=phone_number;
        this.post_code=post_code;
        this.status=status;
        this.id_institution = id_institution;
        this.id_user = id_user;
        this.id_candidate = id_candidate;
        this.count = count;
    }
	
	
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public int getNif() {
		return nif;
	}
	public void setNif(int nif) {
		this.nif = nif;
	}
	public String getLogin_type() {
		return login_type;
	}
	public void setLogin_type(String login_type) {
		this.login_type = login_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
