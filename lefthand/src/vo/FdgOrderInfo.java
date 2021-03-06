package vo;

import java.util.*;

public class FdgOrderInfo {
// 하나의 펀딩 주문정보를 저장하는 클래스
	private String foi_id, mi_id, foi_name, foi_phone, foi_zip,	foi_addr1, foi_addr2, foi_memo;
	private String foi_status, foi_invoice, foi_date, foi_modify;
	private int foi_pay, foi_point,	foi_delipay, ai_idx;
	private ArrayList<FdgOrderDetail> fdgDetailList;
	
	public String getFoi_id() {
		return foi_id;
	}
	public void setFoi_id(String foi_id) {
		this.foi_id = foi_id;
	}
	public String getMi_id() {
		return mi_id;
	}
	public void setMi_id(String mi_id) {
		this.mi_id = mi_id;
	}
	public String getFoi_name() {
		return foi_name;
	}
	public void setFoi_name(String foi_name) {
		this.foi_name = foi_name;
	}
	public String getFoi_phone() {
		return foi_phone;
	}
	public void setFoi_phone(String foi_phone) {
		this.foi_phone = foi_phone;
	}
	public String getFoi_zip() {
		return foi_zip;
	}
	public void setFoi_zip(String foi_zip) {
		this.foi_zip = foi_zip;
	}
	public String getFoi_addr1() {
		return foi_addr1;
	}
	public void setFoi_addr1(String foi_addr1) {
		this.foi_addr1 = foi_addr1;
	}
	public String getFoi_addr2() {
		return foi_addr2;
	}
	public void setFoi_addr2(String foi_addr2) {
		this.foi_addr2 = foi_addr2;
	}
	public String getFoi_memo() {
		return foi_memo;
	}
	public void setFoi_memo(String foi_memo) {
		this.foi_memo = foi_memo;
	}
	public String getFoi_status() {
		return foi_status;
	}
	public void setFoi_status(String foi_status) {
		this.foi_status = foi_status;
	}
	public String getFoi_invoice() {
		return foi_invoice;
	}
	public void setFoi_invoice(String foi_invoice) {
		this.foi_invoice = foi_invoice;
	}
	public String getFoi_date() {
		return foi_date;
	}
	public void setFoi_date(String foi_date) {
		this.foi_date = foi_date;
	}
	public String getFoi_modify() {
		return foi_modify;
	}
	public void setFoi_modify(String foi_modify) {
		this.foi_modify = foi_modify;
	}
	public int getFoi_pay() {
		return foi_pay;
	}
	public void setFoi_pay(int foi_pay) {
		this.foi_pay = foi_pay;
	}
	public int getFoi_point() {
		return foi_point;
	}
	public void setFoi_point(int foi_point) {
		this.foi_point = foi_point;
	}
	public int getFoi_delipay() {
		return foi_delipay;
	}
	public void setFoi_delipay(int foi_delipay) {
		this.foi_delipay = foi_delipay;
	}
	public int getAi_idx() {
		return ai_idx;
	}
	public void setAi_idx(int ai_idx) {
		this.ai_idx = ai_idx;
	}
	public ArrayList<FdgOrderDetail> getFdgDetailList() {
		return fdgDetailList;
	}
	public void setFdgDetailList(ArrayList<FdgOrderDetail> fdgDetailList) {
		this.fdgDetailList = fdgDetailList;
	}
	
}
