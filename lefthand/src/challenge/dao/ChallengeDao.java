package challenge.dao;

import static challenge.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import challenge.dao.*;
import vo.*;

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
	
	
	
}
