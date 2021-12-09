package vo;

public class OrderDetail {
// 한 주문에서 주문한 상품 하나의 정보를 저장할 클래스
	private int pod_idx, pod_cnt, pod_pprice; 
	private String poi_id, pi_id, pod_pname, pod_pimg;
	public int getPod_idx() {
		return pod_idx;
	}
	public void setPod_idx(int pod_idx) {
		this.pod_idx = pod_idx;
	}
	public int getPod_cnt() {
		return pod_cnt;
	}
	public void setPod_cnt(int pod_cnt) {
		this.pod_cnt = pod_cnt;
	}
	public int getPod_pprice() {
		return pod_pprice;
	}
	public void setPod_pprice(int pod_pprice) {
		this.pod_pprice = pod_pprice;
	}
	public String getPoi_id() {
		return poi_id;
	}
	public void setPoi_id(String poi_id) {
		this.poi_id = poi_id;
	}
	public String getPi_id() {
		return pi_id;
	}
	public void setPi_id(String pi_id) {
		this.pi_id = pi_id;
	}
	public String getPod_pname() {
		return pod_pname;
	}
	public void setPod_pname(String pod_pname) {
		this.pod_pname = pod_pname;
	}
	public String getPod_pimg() {
		return pod_pimg;
	}
	public void setPod_pimg(String pod_pimg) {
		this.pod_pimg = pod_pimg;
	}
	
}
