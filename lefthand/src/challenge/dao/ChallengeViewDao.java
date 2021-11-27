package challenge.dao;

import static challenge.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import challenge.dao.*;
import challenge.vo.*;

public class ChallengeViewDao {
	private static ChallengeViewDao challengeViewDao;
	private Connection conn;
	
	private ChallengeViewDao() {}
	// 외부에서 함부로 인스턴스 생성하지 못하게 private로 생성자를 선언함
	
	public static ChallengeViewDao getInstance() {
	// 싱글톤 방식
		if (challengeViewDao == null)	challengeViewDao = new ChallengeViewDao();
		return challengeViewDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public ChallengeList getChallengeInfo(int idx) {
	// 지정한 글번호(idx)에 해당하는 게시글 정보를 ChallengeList형 인스턴스에 담아 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		ChallengeList challenge = null;		// 데이터가 없을 경우 null을 리턴하게 함
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from t_challenge_info where ci_idx = " + idx;
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				challenge = new ChallengeList();		// rs에 담긴 데이터들을 저장할 인스턴스 생성
				challenge.setCi_idx(idx);
				challenge.setMi_id(rs.getString("mi_id"));
				challenge.setCi_title(rs.getString("ci_title"));
				challenge.setCi_content(rs.getString("ci_content"));
				challenge.setCi_img(rs.getString("ci_img"));
				challenge.setCi_thum_img(rs.getString("ci_thum_img"));
				challenge.setCi_good(rs.getInt("ci_good"));
				challenge.setCi_sdate(rs.getString("ci_sdate"));
				challenge.setCi_edate(rs.getString("ci_edate"));
				challenge.setCi_step(rs.getInt("ci_step"));
				challenge.setCi_status(rs.getString("ci_status"));
				challenge.setCi_isview(rs.getString("ci_isview"));
			}	// rs가 비었으면 else 없이 그냥 challenge에 null이 들어있는 상태로 리턴함
		}catch(Exception e) {
			System.out.println("ChallengeViewDao : getChallengeInfo() 메소드 오류");
			e.printStackTrace();
		}
		
		return challenge;
	}
	
	public ChallengeInfo getChallengeDetail(int idx) {
		// 지정한 글번호(idx)에 해당하는 게시글 정보를 ChallengeList형 인스턴스에 담아 리턴하는 메소드
			Statement stmt = null;
			ResultSet rs = null;
			ChallengeInfo challengeDetail = null;		// 데이터가 없을 경우 null을 리턴하게 함
			
			try {
				stmt = conn.createStatement();
				String sql = "select * from t_challenge_info where ci_idx = " + idx;
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					challengeDetail = new ChallengeInfo();		// rs에 담긴 데이터들을 저장할 인스턴스 생성
					challengeDetail.setCi_idx(idx);
					challengeDetail.setMi_id(rs.getString("mi_id"));
					challengeDetail.setCr_idx(rs.getInt("cr_idx"));
					challengeDetail.setCi_status(rs.getString("ci_status"));
					challengeDetail.setCi_isview(rs.getString("ci_isview"));
					challengeDetail.setCr_content(rs.getString("cr_content"));
					challengeDetail.setCrr_idx(rs.getInt("crr_idx"));
					challengeDetail.setCr_date(rs.getString("cr_date"));
					challengeDetail.setCr_isview(rs.getString("cr_isview"));
					challengeDetail.setCr_content(rs.getString("cr_content"));
					challengeDetail.setCrr_status(rs.getString("crr_status"));
					challengeDetail.setCrr_opdate(rs.getString("crr_opdate"));		
				}	
			}catch(Exception e) {
				System.out.println("ChallengeViewDao : getChallengeDetail() 메소드 오류");
				e.printStackTrace();
			}
			
			return challengeDetail;
		}
}