package challenge.vo;

public class ChallengeList {
// 도전펀딩에서 하나의 게시글을 저장할 클래스
	private String mi_id, ci_title, ci_content, ci_img, ci_thum_img, ci_sdate, ci_edate, ci_status, ci_isview;
	private int ci_idx, ci_step, ci_good;
	//마감일 js hidden 처리
	
	public String getMi_id() {
		return mi_id;
	}
	public void setMi_id(String mi_id) {
		this.mi_id = mi_id;
	}
	public String getCi_title() {
		return ci_title;
	}
	public void setCi_title(String ci_title) {
		this.ci_title = ci_title;
	}
	public String getCi_content() {
		return ci_content;
	}
	public void setCi_content(String ci_content) {
		this.ci_content = ci_content;
	}
	public String getCi_img() {
		return ci_img;
	}
	public void setCi_img(String ci_img) {
		this.ci_img = ci_img;
	}
	public String getCi_thum_img() {
		return ci_thum_img;
	}
	public void setCi_thum_img(String ci_thum_img) {
		this.ci_thum_img = ci_thum_img;
	}
	public String getCi_sdate() {
		return ci_sdate;
	}
	public void setCi_sdate(String ci_sdate) {
		this.ci_sdate = ci_sdate;
	}
	public String getCi_edate() {
		return ci_edate;
	}
	public void setCi_edate(String ci_edate) {
		this.ci_edate = ci_edate;
	}
	public String getCi_status() {
		return ci_status;
	}
	public void setCi_status(String ci_status) {
		this.ci_status = ci_status;
	}
	public String getCi_isview() {
		return ci_isview;
	}
	public void setCi_isview(String ci_isview) {
		this.ci_isview = ci_isview;
	}
	public int getCi_idx() {
		return ci_idx;
	}
	public void setCi_idx(int ci_idx) {
		this.ci_idx = ci_idx;
	}
	public int getCi_step() {
		return ci_step;
	}
	public void setCi_step(int ci_step) {
		this.ci_step = ci_step;
	}
	public int getCi_good() {
		return ci_good;
	}
	public void setCi_good(int ci_good) {
		this.ci_good = ci_good;
	}
	
	
}