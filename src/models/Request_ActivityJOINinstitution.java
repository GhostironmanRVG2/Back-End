package models;

import java.sql.Date;
import java.sql.Time;

public class Request_ActivityJOINinstitution {

	String state,description,type,county,district,address,post_code,photo,name;
	int id_institution,id_request;
	float latitude,longitude;
	Time time;
	Date date;
	
	
	
	
	
	
	
	
	
	
	
	
	public Request_ActivityJOINinstitution() {
		super();
	}







	public Request_ActivityJOINinstitution(String state, String description, String type, String county,
			String district, String address, String post_code, String photo, String name, int id_institution,
			int id_request, float latitude, float longitude, Time time, Date date) {
		super();
		this.state = state;
		this.description = description;
		this.type = type;
		this.county = county;
		this.district = district;
		this.address = address;
		this.post_code = post_code;
		this.photo = photo;
		this.name = name;
		this.id_institution = id_institution;
		this.id_request = id_request;
		this.latitude = latitude;
		this.longitude = longitude;
		this.time = time;
		this.date = date;
	}
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getId_institution() {
		return id_institution;
	}
	public void setId_institution(int id_institution) {
		this.id_institution = id_institution;
	}
	public int getId_request() {
		return id_request;
	}
	public void setId_request(int id_request) {
		this.id_request = id_request;
	}

	
	
	
}
