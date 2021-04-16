package models;

import java.sql.Date;
import java.sql.Time;

public class ActivityRequestJOIN {
	int id_request,id_reward,id_activity;
	String state,description,type,county,district,address,post_code,photo,name, state_request;
	int id_institution;
	float latitude,longitude;
	Time time;
	Date date;
	

	
	public ActivityRequestJOIN() {
		super();
	}
	public ActivityRequestJOIN(int id_request, int id_reward, int id_activity,Time time, Date date, String state,
			String description, String type, String county, String district, String address, String post_code, float latitude,float longitude, 
			String photo, int id_institution,String name, String state_request) {
		
		super();
		this.name=name;
		this.latitude=latitude;
		this.longitude=longitude;
		this.id_request = id_request;
		this.id_reward = id_reward;
		this.id_activity = id_activity;
		this.time = time;
		this.date = date;
		this.state = state;
		this.description = description;
		this.type = type;
		this.county = county;
		this.district = district;
		this.address = address;
		this.post_code = post_code;
		this.photo = photo;
		this.id_institution = id_institution;
		this.state_request = state_request;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getId_activity() {
		return id_activity;
	}
	public void setId_activity(int id_activity) {
		this.id_activity = id_activity;
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
	public String getState_request() {
		return state_request;
	}
	public void setState_request(String state_request) {
		this.state_request = state_request;
	}
	

}
