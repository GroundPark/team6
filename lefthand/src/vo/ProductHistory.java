package vo;

public class ProductHistory {
	private String pi_id, ph_date;
	private int ph_idx, ph_oldprice, ph_newprice, ai_idx;
	
	public String getPi_id() {
		return pi_id;
	}
	public void setPi_id(String pi_id) {
		this.pi_id = pi_id;
	}
	public String getPh_date() {
		return ph_date;
	}
	public void setPh_date(String ph_date) {
		this.ph_date = ph_date;
	}	
	public int getPh_idx() {
		return ph_idx;
	}
	public void setPh_idx(int ph_idx) {
		this.ph_idx = ph_idx;
	}
	public int getPh_oldprice() {
		return ph_oldprice;
	}
	public void setPh_oldprice(int ph_oldprice) {
		this.ph_oldprice = ph_oldprice;
	}
	public int getPh_newprice() {
		return ph_newprice;
	}
	public void setPh_newprice(int ph_newprice) {
		this.ph_newprice = ph_newprice;
	}
	public int getAi_idx() {
		return ai_idx;
	}
	public void setAi_idx(int ai_idx) {
		this.ai_idx = ai_idx;
	}
}
