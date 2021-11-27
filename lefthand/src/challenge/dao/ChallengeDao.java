package challenge.dao;

import static challenge.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import challenge.dao.*;
import challenge.vo.*;

public class ChallengeDao {
	private static ChallengeDao challengeDao;
	private Connection conn;
	
	private ChallengeDao() {}
	// 외부에서 함부로 인스턴스 생성하지 못하게 private로 생성자를 선언함
	
	public static ChallengeDao getInstance() {
	// 싱글톤 방식
		if (challengeDao == null)	challengeDao = new ChallengeDao();
		return challengeDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	/* list로 보낼것
	public int getPdtCount(String where) {
	// 검색된 상품의 전체 개수를 리턴하는 메소드 : 
	
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from t_product_info a, t_pdt_cata_big b, t_pdt_cata_small c, t_pdt_brand d " + where;
			rs = stmt.executeQuery(sql);
			
			rs.next();
			rcnt = rs.getInt(1);
			
		}catch(Exception e) {
			System.out.println("productDao : getPdtCount() 메소드 오류");			
			e.printStackTrace();
		}finally {
			close(rs);	close(stmt);
		}
		
		return rcnt;
	}
	
	
		
	public ArrayList<ProductInfo> getPdtList(String where, String order, int cpage, int psize){
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();	
		ProductInfo pdt = null;
		
		try {
			String sql = "select a.*, b.pcb_id, b.pcb_name, c.pcs_name, d.pb_name " +
				" from t_product_info a, t_pdt_cata_big b, t_pdt_cata_small c, t_pdt_brand d" +
				where + order + " limit " + ((cpage - 1) * psize) + ", " + psize;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {				// AL이므로 while 가능
			pdt = new ProductInfo();	// AL에 저장할 NoticeList형 인스턴스 생성		
			pdt.setPi_idx(rs.getInt("pi_idx"));
            pdt.setPi_id(rs.getString("pi_id"));
            pdt.setPcs_id(rs.getString("pcs_id"));
            pdt.setPb_id(rs.getString("pb_id"));
            pdt.setPi_origin(rs.getString("pi_origin"));
            pdt.setPi_release(rs.getString("pi_release"));
            pdt.setPi_name(rs.getString("pi_name"));
            pdt.setPi_cost(rs.getInt("pi_cost"));
            pdt.setPi_price(rs.getInt("pi_price"));
            pdt.setPi_discount(rs.getDouble("pi_discount"));
            pdt.setPi_option(rs.getString("pi_option"));
            pdt.setPi_img1(rs.getString("pi_img1"));
            pdt.setPi_img2(rs.getString("pi_img2"));
            pdt.setPi_img3(rs.getString("pi_img3"));
            pdt.setPi_desc(rs.getString("pi_desc"));
            pdt.setPi_stock(rs.getInt("pi_stock"));
            pdt.setPi_readcnt(rs.getInt("pi_readcnt"));
            pdt.setPi_salecnt(rs.getInt("pi_salecnt"));
            pdt.setPi_review(rs.getInt("pi_review"));
            pdt.setPi_score(rs.getDouble("pi_score"));
            pdt.setPi_ascall(rs.getString("pi_ascall"));
            pdt.setPi_isview(rs.getString("pi_isview"));
            pdt.setPi_date(rs.getString("pi_date"));
            pdt.setAi_idx(rs.getInt("ai_idx"));
            pdt.setPcb_id(rs.getString("pcb_id"));
            pdt.setPcb_name(rs.getString("pcb_name"));
            pdt.setPcs_name(rs.getString("pcs_name"));
            pdt.setPb_name(rs.getString("pb_name"));
			// 받아온 컬럼들의 값을 pdt 인스턴스에 저장
            
			pdtList.add(pdt);
			}
			// 하나의 상품 정보를 담은 인스턴스 pdt를 pdtList에 저장
			}catch(Exception e) {
				System.out.println("productDao : getPdtList() 메소드 오류");			
				e.printStackTrace();
			}finally {
				close(rs);	close(stmt);
			}
		return pdtList;
	}
		
	*/
	
	
	public ChallengeInfo getChallengeInfo(int idx) {
		Statement stmt = null;
		ResultSet rs = null;
		ChallengeInfo challenge = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from t_challenge_info where ci_isview = 'y' ";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				challenge = new ChallengeInfo();		
				challenge.setCi_idx(rs.getInt("ci_idx"));
				challenge.setMi_id(rs.getString("mi_id"));
				challenge.setCi_title(rs.getString("ci_title"));
				challenge.setCi_img(rs.getString("ci_img"));
				challenge.setCi_thum_img(rs.getString("ci_thum_img"));
				challenge.setCi_good(rs.getInt("ci_good"));
				challenge.setCi_sdate(rs.getString("ci_sdate"));
				challenge.setCi_edate(rs.getString("ci_edate"));
				challenge.setCi_step(rs.getInt("ci_step"));
				challenge.setCi_status(rs.getString("ci_status"));
				challenge.setCi_isview(rs.getString("ci_isview"));
	           
			}
			
		}catch(Exception e) {
			System.out.println("challengeDao : getChallengeInfo() 메소드 오류");			
			e.printStackTrace();
		}finally {
			close(rs);	close(stmt);
		}
		
		return challenge;
	}
	
	
	/*
	public ChallengeInfo getChallengeReply(int idx) {
		Statement stmt = null;
		ResultSet rs = null;
		ChallengeInfo pdt = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from t_challenge_info where ci_isview = y";
			rs = stmt.executeQuery(sql);
			
			
			if(rs.next()) {
				pdt = new ChallengeInfo();		
				
				pdt.setCi_idx(rs.getInt("ci_idx"));
	            pdt.setPi_id(rs.getString("pi_id"));

	           
			}
			
		}catch(Exception e) {
			System.out.println("productDao : getPdtInfo() 메소드 오류");			
			e.printStackTrace();
		}finally {
			close(rs);	close(stmt);
		}
		
		return pdt;
	}
	
	*/
	
}
