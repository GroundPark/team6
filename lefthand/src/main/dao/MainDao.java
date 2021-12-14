package main.dao;

import static main.db.JdbcUtil.*;	
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class MainDao {
	private static MainDao mainDao;
	private Connection conn;
	
	private MainDao() {}
	// 외부에서는 함부로 인스턴스를 생성하지 못하게 private으로 생성자를 선언함
		
	public static MainDao getInstance() {
	// 싱글톤 방식으로 인스턴스 낭비를 줄임 
		if (mainDao == null)	mainDao = new MainDao();
		// 기존의 인스턴스가 살아있으면 새롭게 만들지 않고, 없을 경우에만 새로 생성하게 함 
		return mainDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

// productList만드는 과정
	public ArrayList<ProductInfo> getProductList() {
		// 검색된 상품 목록을 ArrayList<ProductInfo>에 담아 리턴하는 메소드
			Statement stmt = null;	
			ResultSet rs = null;
			ArrayList<ProductInfo> productList = new ArrayList<ProductInfo>();	
			// 상품 목록을 저장할 ArrayList로 오직 ProductInfo형 인스턴스만 저장할 수 있음
			ProductInfo pdt = null;	
			// pdtList에 저장할 ProductInfo형 인스턴스
			
			try {
				stmt = conn.createStatement();	
				String sql = "select * from t_product_info order by pi_salecnt desc limit 4";
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {	
					pdt = new ProductInfo();	// pdtList에 저장할 하나의 상품 정보를 담을 인스턴스 생성
					
					pdt.setPi_idx(rs.getInt("pi_idx"));					pdt.setPi_id(rs.getString("pi_id"));
					pdt.setPc_id(rs.getString("pc_id"));				pdt.setPi_name(rs.getString("pi_name"));
					pdt.setPi_price(rs.getInt("pi_price"));				pdt.setPi_discount(rs.getFloat("pi_discount"));
					pdt.setPi_img1(rs.getString("pi_img1"));			pdt.setPi_img2(rs.getString("pi_img2"));
					pdt.setPi_img3(rs.getString("pi_img3"));			pdt.setPi_desc(rs.getString("pi_desc"));
					pdt.setPi_stock(rs.getInt("pi_stock"));				pdt.setPi_good(rs.getInt("pi_good"));
					pdt.setPi_salecnt(rs.getInt("pi_salecnt"));			pdt.setPi_review(rs.getInt("pi_review"));
					pdt.setPi_score(rs.getFloat("pi_score"));			pdt.setPi_soldout(rs.getString("pi_soldout"));
					pdt.setPi_isview(rs.getString("pi_isview"));		pdt.setPi_date(rs.getString("pi_date"));
					pdt.setAi_idx(rs.getInt("ai_idx"));				
					// 받아온 컬럼들의 값을 pdt 인스턴스에 저장
					productList.add(pdt);	// 하나의 상품 정보를 담은 인스턴스 pdt를 pdtList에 저장
					
				} 
				
			} catch (Exception e) {
				System.out.println("MainDao 클래스의 getProductList() 메소드 오류");
				e.printStackTrace();
			} finally {
				close(rs);	close(stmt);	
			}		
			return productList;
		}
		
	// challengeList만드는 과정
		public ArrayList<ChallengeInfo> getChallengeList() {
		// 검색된 상품 목록을 ArrayList<ChallengeInfo>에 담아 리턴하는 메소드
			Statement stmt = null;	
			ResultSet rs = null;
			ArrayList<ChallengeInfo> challengeList = new ArrayList<ChallengeInfo>();	
			// 상품 목록을 저장할 ArrayList로 오직 ProductInfo형 인스턴스만 저장할 수 있음
			ChallengeInfo chall = null;	
			// challengeList에 저장할 ChallengeInfo형 인스턴스
			
			try {
				stmt = conn.createStatement();	
				String sql = "select * from t_challenge_info where ci_step = 2 and ci_status = 'a' order by ci_good desc limit 2";
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {	
					chall = new ChallengeInfo();	// challengeList에 저장할 하나의 상품 정보를 담을 인스턴스 생성
					
					chall.setCi_idx(rs.getInt("ci_idx"));
					chall.setMi_id(rs.getString("mi_id"));
					chall.setCi_title(rs.getString("ci_title"));
					chall.setCi_content(rs.getString("ci_content"));
					chall.setCi_img(rs.getString("ci_img"));
					chall.setCi_thum_img(rs.getString("ci_thum_img"));
					chall.setCi_good(rs.getInt("ci_good"));
					chall.setCi_sdate(rs.getString("ci_sdate"));
					chall.setCi_edate(rs.getString("ci_edate"));
					chall.setCi_step(rs.getInt("ci_step"));
					chall.setCi_status(rs.getString("ci_status"));
					chall.setCi_isview(rs.getString("ci_isview"));
					// 받아온 컬럼들의 값을 chall 인스턴스에 저장
					
					challengeList.add(chall);	// 하나의 상품 정보를 담은 인스턴스 chall를 challengeList에 저장
				} 
				
			} catch (Exception e) {
				System.out.println("MainDao 클래스의 getChallengeList() 메소드 오류");
				e.printStackTrace();
			} finally {
				close(rs);	close(stmt);	
			}
			return challengeList;
		}

	// fundingList만드는 과정
		public ArrayList<FundingInfo> getFundingList() {
		// 검색된 상품 목록을 ArrayList<FundingInfo>에 담아 리턴하는 메소드
			Statement stmt = null;	
			ResultSet rs = null;
			ArrayList<FundingInfo> fundingList = new ArrayList<FundingInfo>();	
			// 상품 목록을 저장할 ArrayList로 오직 FundingInfo형 인스턴스만 저장할 수 있음
			FundingInfo fund = null;	
			// fundingList에 저장할 FundingInfo형 인스턴스
			
			try {
				stmt = conn.createStatement();	
				String sql = "select * from t_funding_info order by fi_ordercnt desc limit 2";
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {	
					fund = new FundingInfo();	// fundingList에 저장할 하나의 상품 정보를 담을 인스턴스 생성
					
					fund.setFi_idx(rs.getInt("fi_idx"));
					fund.setFi_id(rs.getString("fi_id"));
					fund.setFi_name(rs.getString("fi_name"));
					fund.setFi_img1(rs.getString("fi_img1"));
					fund.setFi_img2(rs.getString("fi_img2"));
					fund.setFi_img3(rs.getString("fi_img3"));
					fund.setFi_desc(rs.getString("fi_desc"));
					fund.setFi_price(rs.getInt("fi_price"));
					fund.setFi_ordercnt(rs.getInt("fi_ordercnt"));
					fund.setFi_goal(rs.getInt("fi_goal"));
					fund.setFi_rate(rs.getFloat("fi_rate"));
					fund.setFi_support(rs.getInt("fi_support"));
					fund.setFi_total(rs.getInt("fi_total"));
					fund.setFi_good(rs.getInt("fi_good"));
					fund.setFi_sdate(rs.getString("fi_sdate"));
					fund.setFi_edate(rs.getString("fi_edate"));
					fund.setFi_status(rs.getString("fi_status"));
					fund.setFi_isview(rs.getString("fi_isview"));
					fund.setFi_date(rs.getString("fi_date"));
					fund.setAi_idx(rs.getInt("ai_idx"));
					// 받아온 컬럼들의 값을 fund 인스턴스에 저장
					
					fundingList.add(fund);	// 하나의 상품 정보를 담은 인스턴스 fund를 fundingList에 저장
				} 
				
			} catch (Exception e) {
				System.out.println("MainDao 클래스의 getFundingList() 메소드 오류");
				e.printStackTrace();
			} finally {
				close(rs);	close(stmt);	
			}
			return fundingList;
		}

	// reviewList만드는 과정
		public ArrayList<ReviewInfo> getReviewList() {
		// 검색된 상품 목록을 ArrayList<FundingInfo>에 담아 리턴하는 메소드
			Statement stmt = null;	
			ResultSet rs = null;
			ArrayList<ReviewInfo> reviewList = new ArrayList<ReviewInfo>();	
			// 상품 목록을 저장할 ArrayList로 오직 FundingInfo형 인스턴스만 저장할 수 있음
			ReviewInfo review = null;	
			// reviewList에 저장할 ReviewInfo형 인스턴스
			
			try {
				stmt = conn.createStatement();	
				String sql = "select * from v_review_info order by rl_good desc limit 4";
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {	
					review = new ReviewInfo();	// reviewList에 저장할 하나의 리뷰 정보를 담을 인스턴스 생성
					
					review.setMi_id(rs.getString("mi_id"));
					review.setPi_name(rs.getString("pi_name"));
					review.setRl_content(rs.getString("rl_content"));
					review.setRl_date(rs.getString("rl_date").substring(0,10));
					review.setRl_good(rs.getInt("rl_good"));
					review.setRl_score(rs.getInt("rl_score"));
					// 받아온 컬럼들의 값을 review 인스턴스에 저장
					
					reviewList.add(review);	// 하나의 상품 정보를 담은 인스턴스 review를 reviewList에 저장
				} 
				
			} catch (Exception e) {
				System.out.println("MainDao 클래스의 getReviewList() 메소드 오류");
				e.printStackTrace();
			} finally {
				close(rs);	close(stmt);	
			}
			return reviewList;
		}
	}
