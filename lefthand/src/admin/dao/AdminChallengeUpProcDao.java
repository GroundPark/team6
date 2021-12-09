package admin.dao;

import static admin.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminChallengeUpProcDao {
	private static AdminChallengeUpProcDao adminChallengeUpProcDao;
	private Connection conn;
	
	private AdminChallengeUpProcDao() {}
	public static AdminChallengeUpProcDao getInstance() {
		if(adminChallengeUpProcDao == null)		adminChallengeUpProcDao = new AdminChallengeUpProcDao();
		return adminChallengeUpProcDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int adminChallengeUpdate(AdminChallengeList adminChallenge) {
		Statement stmt = null;
		int result = 0;

		try {
			stmt = conn.createStatement();
			String sql = "update t_challenge_info set ci_title = '" + adminChallenge.getCi_title() + "', " 
							+ " ci_content = '" + adminChallenge.getCi_content() + "', " 
						//	+ " ci_img = '" + adminChallenge.getCi_img() + "', " 
						//	+ " ci_sdate = '" + adminChallenge.getCi_sdate() + "', " 
						//	+ " ci_edate = '" + adminChallenge.getCi_edate() + "', " 
							+ " ci_step = " + adminChallenge.getCi_step() + ", " 
							+ " ci_good = " + adminChallenge.getCi_good() + ", "
							+ " ci_status = '" + adminChallenge.getCi_status() + "', "
							+ " ci_isview = '" + adminChallenge.getCi_isview() + "' "
							+ " where ci_idx = " + adminChallenge.getCi_idx();
			result = stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		
		return result;
	}
}