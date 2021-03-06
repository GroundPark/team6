package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminChallengeUpDao {
	private static AdminChallengeUpDao adminChallengeUpDao;
	private Connection conn;
	
	private AdminChallengeUpDao() {}
	// 외부에서 함부로 인스턴스 생성하지 못하게 private로 생성자를 선언함
	
	public static AdminChallengeUpDao getInstance() {
	// 싱글톤 방식
		if (adminChallengeUpDao == null)	adminChallengeUpDao = new AdminChallengeUpDao();
		return adminChallengeUpDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public AdminChallengeList getAdminChallengeInfo(int idx) {
			Statement stmt = null;
			ResultSet rs = null;
			AdminChallengeList adminChallenge = null;		
			
			try {
				stmt = conn.createStatement();
				String sql = "select * from t_challenge_info where ci_idx = " + idx;
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					adminChallenge = new AdminChallengeList();	
					adminChallenge.setCi_idx(rs.getInt("ci_idx"));
					adminChallenge.setMi_id(rs.getString("mi_id"));
					adminChallenge.setCi_title(rs.getString("ci_title"));
					adminChallenge.setCi_img(rs.getString("ci_img"));
					adminChallenge.setCi_thum_img(rs.getString("ci_thum_img"));
					adminChallenge.setCi_good(rs.getInt("ci_good"));
					adminChallenge.setCi_sdate(rs.getString("ci_sdate"));
					adminChallenge.setCi_edate(rs.getString("ci_edate"));
					adminChallenge.setCi_step(rs.getInt("ci_step"));
					adminChallenge.setCi_status(rs.getString("ci_status"));
					adminChallenge.setCi_isview(rs.getString("ci_isview"));
					adminChallenge.setCi_content(rs.getString("ci_content"));
				}	
			}catch(Exception e) {
				System.out.println("AdminChallengeUpDao : getAdminChallengeInfo() 메소드 오류");	
				e.printStackTrace();
			}
			
			return adminChallenge;
	}
}