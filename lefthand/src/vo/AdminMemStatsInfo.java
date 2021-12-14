package vo;

public class AdminMemStatsInfo {
// 통계에서 사용 할 데이터들이 저장 될 클래스
	private int f_acount, f_lcount, f_rcount, f_bcount;
	// f = 펀딩 : 주문 전체개수, 왼손잡이 주문 개수, 오른손잡이 주문 수, 양손잡이 주문 수
	private int p_acount, p_lcount, p_rcount, p_bcount;
	// p = 상품 : 주문 전체개수, 왼손잡이 주문 개수, 오른손잡이 주문 수, 양손잡이 주문 수
	
	
	public int getF_acount() {
		return f_acount;
	}
	public void setF_acount(int f_acount) {
		this.f_acount = f_acount;
	}
	public int getF_lcount() {
		return f_lcount;
	}
	public void setF_lcount(int f_lcount) {
		this.f_lcount = f_lcount;
	}
	public int getF_rcount() {
		return f_rcount;
	}
	public void setF_rcount(int f_rcount) {
		this.f_rcount = f_rcount;
	}
	public int getF_bcount() {
		return f_bcount;
	}
	public void setF_bcount(int f_bcount) {
		this.f_bcount = f_bcount;
	}
	public int getP_acount() {
		return p_acount;
	}
	public void setP_acount(int p_acount) {
		this.p_acount = p_acount;
	}
	public int getP_lcount() {
		return p_lcount;
	}
	public void setP_lcount(int p_lcount) {
		this.p_lcount = p_lcount;
	}
	public int getP_rcount() {
		return p_rcount;
	}
	public void setP_rcount(int p_rcount) {
		this.p_rcount = p_rcount;
	}
	public int getP_bcount() {
		return p_bcount;
	}
	public void setP_bcount(int p_bcount) {
		this.p_bcount = p_bcount;
	}
	
}
