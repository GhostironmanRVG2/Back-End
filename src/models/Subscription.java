package models;

public class Subscription {
	String evaluation,photo_1,photo_2,state;
	int id_activity,id_child,janeiro,fevereiro,março,abril,maio,junho,julho,agosto,setembro,outubro,novembro,dezembro,atual;
	
	
	
	
	
	public Subscription() {
		super();
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public String getPhoto_1() {
		return photo_1;
	}
	public void setPhoto_1(String photo_1) {
		this.photo_1 = photo_1;
	}
	public String getPhoto_2() {
		return photo_2;
	}
	public void setPhoto_2(String photo_2) {
		this.photo_2 = photo_2;
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
	public int getId_child() {
		return id_child;
	}
	public void setId_child(int id_child) {
		this.id_child = id_child;
	}
	public Subscription(String evaluation, String photo_1, String photo_2, String state, int id_activity,
			int id_child) {
		super();
		this.evaluation = evaluation;
		this.photo_1 = photo_1;
		this.photo_2 = photo_2;
		this.state = state;
		this.id_activity = id_activity;
		this.id_child = id_child;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Subscription(int janeiro, int fevereiro, int março, int abril, int maio, int junho, int julho, int agosto,
			int setembro, int outubro, int novembro, int dezembro,int atual) {
		
		
		
		//SUBS COUNT BY MOUNTH
		super();
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
		this.atual=atual;
	}
	
	public int getAtual() {
		return atual;
	}
	public void setAtual(int atual) {
		this.atual = atual;
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
	
	
	
	
	
	
	
	
	
}
