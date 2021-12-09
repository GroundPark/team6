package vo;

import java.util.*;

public class OrderInfo {
// 상품 하나의 주문에 대한 정보들을 저장할 클래스
	private String poi_id, mi_id, poi_name, poi_phone, poi_zip, poi_addr1, poi_addr2, poi_memo; 
	private String poi_payment, poi_status, poi_invoice, poi_date, poi_modify; 
	private int poi_pay, poi_point, poi_discount, poi_delipay, ai_idx;
	private ArrayList<OrderDetail> detailList;	// 구매한 상품 정보는 한 주문에 여러 개가 있을 수 있으므로  ArrayList를 이용하여 여러 개를 담을 수 있게 함
	public String getPoi_id() {
		return poi_id;
	}
	public void setPoi_id(String poi_id) {
		this.poi_id = poi_id;
	}
	public String getMi_id() {
		return mi_id;
	}
	public void setMi_id(String mi_id) {
		this.mi_id = mi_id;
	}
	public String getPoi_name() {
		return poi_name;
	}
	public void setPoi_name(String poi_name) {
		this.poi_name = poi_name;
	}
	public String getPoi_phone() {
		return poi_phone;
	}
	public void setPoi_phone(String poi_phone) {
		this.poi_phone = poi_phone;
	}
	public String getPoi_zip() {
		return poi_zip;
	}
	public void setPoi_zip(String poi_zip) {
		this.poi_zip = poi_zip;
	}
	public String getPoi_addr1() {
		return poi_addr1;
	}
	public void setPoi_addr1(String poi_addr1) {
		this.poi_addr1 = poi_addr1;
	}
	public String getPoi_addr2() {
		return poi_addr2;
	}
	public void setPoi_addr2(String poi_addr2) {
		this.poi_addr2 = poi_addr2;
	}
	public String getPoi_memo() {
		return poi_memo;
	}
	public void setPoi_memo(String poi_memo) {
		this.poi_memo = poi_memo;
	}
	public String getPoi_payment() {
		return poi_payment;
	}
	public void setPoi_payment(String poi_payment) {
		this.poi_payment = poi_payment;
	}
	public String getPoi_status() {
		return poi_status;
	}
	public void setPoi_status(String poi_status) {
		this.poi_status = poi_status;
	}
	public String getPoi_invoice() {
		return poi_invoice;
	}
	public void setPoi_invoice(String poi_invoice) {
		this.poi_invoice = poi_invoice;
	}
	public String getPoi_date() {
		return poi_date;
	}
	public void setPoi_date(String poi_date) {
		this.poi_date = poi_date;
	}
	public String getPoi_modify() {
		return poi_modify;
	}
	public void setPoi_modify(String poi_modify) {
		this.poi_modify = poi_modify;
	}
	public int getPoi_pay() {
		return poi_pay;
	}
	public void setPoi_pay(int poi_pay) {
		this.poi_pay = poi_pay;
	}
	public int getPoi_point() {
		return poi_point;
	}
	public void setPoi_point(int poi_point) {
		this.poi_point = poi_point;
	}
	public int getPoi_discount() {
		return poi_discount;
	}
	public void setPoi_discount(int poi_discount) {
		this.poi_discount = poi_discount;
	}
	public int getPoi_delipay() {
		return poi_delipay;
	}
	public void setPoi_delipay(int poi_delipay) {
		this.poi_delipay = poi_delipay;
	}
	public int getAi_idx() {
		return ai_idx;
	}
	public void setAi_idx(int ai_idx) {
		this.ai_idx = ai_idx;
	}
	public ArrayList<OrderDetail> getDetailList() {
		return detailList;
	}
	public void setDetailList(ArrayList<OrderDetail> detailList) {
		this.detailList = detailList;
	}

}
