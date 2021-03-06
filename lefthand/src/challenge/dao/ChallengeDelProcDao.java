package challenge.dao;

import static challenge.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import challenge.dao.*;
import vo.*;

public class ChallengeDelProcDao {
	private static ChallengeDelProcDao challengeDelProcDao;
	private Connection conn;
	
	private ChallengeDelProcDao() {}
	
	public static ChallengeDelProcDao getInstance() {
		if (challengeDelProcDao == null)	challengeDelProcDao = new ChallengeDelProcDao();
		return challengeDelProcDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int challengeDelete(int idx) {
		Statement stmt = null;
		int result = 0;

		try {
			stmt = conn.createStatement();
			String sql = "update t_challenge_info set ci_isview = 'n' where ci_idx = " + idx;
			// String sql = "delete from t_challenge_info where ci_idx = " + idx;
			result = stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			System.out.println("NoticeDelProcDao 클래스의 challengeDelete() 메소드 오류");
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		
		return result;
	}
	
}