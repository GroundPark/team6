package vo;

public class FdgOrderDetail {
// 한 주문에서 주문한 펀딩 하나의 정보를 저장할 클래스
	private int fod_idx, fod_cnt, fod_pprice;
	private String foi_id, fi_id, fod_pname, fod_pimg;
	public int getFod_idx() {
		return fod_idx;
	}
	public void setFod_idx(int fod_idx) {
		this.fod_idx = fod_idx;
	}
	public int getFod_cnt() {
		return fod_cnt;
	}
	public void setFod_cnt(int fod_cnt) {
		this.fod_cnt = fod_cnt;
	}
	public int getFod_pprice() {
		return fod_pprice;
	}
	public void setFod_pprice(int fod_pprice) {
		this.fod_pprice = fod_pprice;
	}
	public String getFoi_id() {
		return foi_id;
	}
	public void setFoi_id(String foi_id) {
		this.foi_id = foi_id;
	}
	public String getFi_id() {
		return fi_id;
	}
	public void setFi_id(String fi_id) {
		this.fi_id = fi_id;
	}
	public String getFod_pname() {
		return fod_pname;
	}
	public void setFod_pname(String fod_pname) {
		this.fod_pname = fod_pname;
	}
	public String getFod_pimg() {
		return fod_pimg;
	}
	public void setFod_pimg(String fod_pimg) {
		this.fod_pimg = fod_pimg;
	}
		
}
