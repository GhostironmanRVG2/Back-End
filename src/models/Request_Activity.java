package models;

import java.sql.Date;
import java.sql.Time;

public class Request_Activity {

	String state,description,type,county,district,address,post_code,photo,activity_state;
	int id_institution,id_request,id_activity,id_reward,janeiro,fevereiro,março,abril,maio,junho,julho,agosto,setembro,outubro,novembro,dezembro;
	float latitude,longitude;
	Time time;
	Date date;
	
	
	
	
	
	
	
	public Request_Activity() {
		super();
	}
	public Request_Activity(Time time, Date date, String state, String description, String type, String county,
			String district, String address,float latitude,float longitude ,String post_code, String photo, int id_institution, int id_request) {
		super();
		this.latitude=latitude;
		this.longitude=longitude;
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
		this.id_request = id_request;
	}
	
	
	
	
	
	
	public Request_Activity(Time time, Date date, String state, String description, String type, String county,
			String district, String address,float latitude,float longitude ,String post_code, String photo, int id_institution, int id_request,String activity_state,int id_activity,int id_reward) {
		super();
		this.latitude=latitude;
		this.longitude=longitude;
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
		this.id_request = id_request;
		this.activity_state=activity_state;
		this.id_activity=id_activity;
		this.id_reward=id_reward;
		
	}
	
	
		public Request_Activity(Time time, Date date, String description, String type, String county,
			String district, String address,float latitude,float longitude ,String post_code, String photo, int id_institution, int id_request) {
		super();
		this.latitude=latitude;
		this.longitude=longitude;
		this.time = time;
		this.date = date;
		this.description = description;
		this.type = type;
		this.county = county;
		this.district = district;
		this.address = address;
		this.post_code = post_code;
		this.photo = photo;
		this.id_institution = id_institution;
		this.id_request = id_request;
	}
	
	
	
	public Request_Activity(int janeiro, int fevereiro, int março, int abril, int maio, int junho, int julho,
				int agosto, int setembro, int outubro, int novembro, int dezembro) {
			super();
			//COUNT REQUEST_ACTIVITY
			this.janeiro = janeiro;
			this.fevereiro = fevereiro;
			this.março = março;
			this.abril = abril;
			this.maio = maio;
			this.junho = junho;
			this.julho = julho;
			this.agosto = agosto;
			this.setembro = setembro;
			this.outubro = outubro;
			this.novembro = novembro;
			this.dezembro = dezembro;
		}
	public String getActivity_state() {
			return activity_state;
		}
		public void setActivity_state(String activity_state) {
			this.activity_state = activity_state;
		}
		public int getId_activity() {
			return id_activity;
		}
		public void setId_activity(int id_activity) {
			this.id_activity = id_activity;
		}
		public int getId_reward() {
			return id_reward;
		}
		public void setId_reward(int id_reward) {
			this.id_reward = id_reward;
		}
		public int getJaneiro() {
			return janeiro;
		}
		public void setJaneiro(int janeiro) {
			this.janeiro = janeiro;
		}
		public int getFevereiro() {
			return fevereiro;
		}
		public void setFevereiro(int fevereiro) {
			this.fevereiro = fevereiro;
		}
		public int getMarço() {
			return março;
		}
		public void setMarço(int março) {
			this.março = março;
		}
		public int getAbril() {
			return abril;
		}
		public void setAbril(int abril) {
			this.abril = abril;
		}
		public int getMaio() {
			return maio;
		}
		public void setMaio(int maio) {
			this.maio = maio;
		}
		public int getJunho() {
			return junho;
		}
		public void setJunho(int junho) {
			this.junho = junho;
		}
		public int getJulho() {
			return julho;
		}
		public void setJulho(int julho) {
			this.julho = julho;
		}
		public int getAgosto() {
			return agosto;
		}
		public void setAgosto(int agosto) {
			this.agosto = agosto;
		}
		public int getSetembro() {
			return setembro;
		}
		public void setSetembro(int setembro) {
			this.setembro = setembro;
		}
		public int getOutubro() {
			return outubro;
		}
		public void setOutubro(int outubro) {
			this.outubro = outubro;
		}
		public int getNovembro() {
			return novembro;
		}
		public void setNovembro(int novembro) {
			this.novembro = novembro;
		}
		public int getDezembro() {
			return dezembro;
		}
		public void setDezembro(int dezembro) {
			this.dezembro = dezembro;
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
