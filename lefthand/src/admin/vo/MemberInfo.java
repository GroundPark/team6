package admin.vo;

public class MemberInfo {
	// 한 명의 관리자 정보를 저장하는 클래스
	private int ai_idx, api_id;
	private String ai_id, ai_pw, ai_name, ai_phone, ai_tel, ai_email, ai_isact, ai_date;
	private int am_idx, ap_pms;		// 메뉴 번호 및 권한

	public int getAi_idx() {
		return ai_idx;
	}
	public void setAi_idx(int ai_idx) {
		this.ai_idx = ai_idx;
	}
	public int getApi_id() {
		return api_id;
	}
	public void setApi_id(int api_id) {
		this.api_id = api_id;
	}
	public String getAi_id() {
		return ai_id;
	}
	public void setAi_id(String ai_id) {
		this.ai_id = ai_id;
	}
	public String getAi_pw() {
		return ai_pw;
	}
	public void setAi_pw(String ai_pw) {
		this.ai_pw = ai_pw;
	}
	public String getAi_name() {
		return ai_name;
	}
	public void setAi_name(String ai_name) {
		this.ai_name = ai_name;
	}
	public String getAi_phone() {
		return ai_phone;
	}
	public void setAi_phone(String ai_phone) {
		this.ai_phone = ai_phone;
	}
	public String getAi_tel() {
		return ai_tel;
	}
	public void setAi_tel(String ai_tel) {
		this.ai_tel = ai_tel;
	}
	public String getAi_email() {
		return ai_email;
	}
	public void setAi_email(String ai_email) {
		this.ai_email = ai_email;
	}
	public String getAi_isact() {
		return ai_isact;
	}
	public void setAi_isact(String ai_isact) {
		this.ai_isact = ai_isact;
	}
	public String getAi_date() {
		return ai_date;
	}
	public void setAi_date(String ai_date) {
		this.ai_date = ai_date;
	}
	public int getAm_idx() {
		return am_idx;
	}
	public void setAm_idx(int am_idx) {
		this.am_idx = am_idx;
	}
	public int getAp_pms() {
		return ap_pms;
	}
	public void setAp_pms(int ap_pms) {
		this.ap_pms = ap_pms;
	}
	
	
}
