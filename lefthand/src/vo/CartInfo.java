package vo;

public class CartInfo {
// 장바구니에 담긴 하나의 상품 정보를 저장할 클래스로 화면에서 보여줄 데이터들과 변경할 데이터들도 저장할 수 있게 해줌
	private int poc_idx, poc_cnt;
	private String mi_id, pi_id, poc_date, poc_idxs;	// poc_idxs : 장바구니 내의 상품 삭제 시 여러 개의 인덱스를 저장할 변수로 테이블의 컬럼은 아님
	private String pi_name, pi_img1;	// 장바구니 추가적으로 보여줄 상품 정보들
	private int pi_price, pi_stock;
	private double pi_discount;			// 장바구니에서 할인 후 가격 보여주기 위함
	public int getPoc_idx() {
		return poc_idx;
	}
	public void setPoc_idx(int poc_idx) {
		this.poc_idx = poc_idx;
	}
	public int getPoc_cnt() {
		return poc_cnt;
	}
	public void setPoc_cnt(int poc_cnt) {
		this.poc_cnt = poc_cnt;
	}
	public String getMi_id() {
		return mi_id;
	}
	public void setMi_id(String mi_id) {
		this.mi_id = mi_id;
	}
	public String getPi_id() {
		return pi_id;
	}
	public void setPi_id(String pi_id) {
		this.pi_id = pi_id;
	}
	public String getPoc_date() {
		return poc_date;
	}
	public void setPoc_date(String poc_date) {
		this.poc_date = poc_date;
	}
	public String getPi_name() {
		return pi_name;
	}
	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}
	public String getPi_img1() {
		return pi_img1;
	}
	public void setPi_img1(String pi_img1) {
		this.pi_img1 = pi_img1;
	}
	public int getPi_price() {
		return pi_price;
	}
	public void setPi_price(int pi_price) {
		this.pi_price = pi_price;
	}
	public int getPi_stock() {
		return pi_stock;
	}
	public void setPi_stock(int pi_stock) {
		this.pi_stock = pi_stock;
	}
	public double getPi_discount() {
		return pi_discount;
	}
	public void setPi_discount(double pi_discount) {
		this.pi_discount = pi_discount;
	}
	public String getPoc_idxs() {
		return poc_idxs;
	}
	public void setPoc_idxs(String poc_idxs) {
		this.poc_idxs = poc_idxs;
	}
	
}
