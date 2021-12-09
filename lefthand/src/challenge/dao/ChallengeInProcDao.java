package challenge.dao;

import static challenge.db.JdbcUtil.*;		
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class ChallengeInProcDao {
	private static ChallengeInProcDao challengeInProcDao;
	private Connection conn;
	
	private ChallengeInProcDao() {}
	public static ChallengeInProcDao getInstance() {
	// singleton
		if(challengeInProcDao == null)		challengeInProcDao = new ChallengeInProcDao();
		return challengeInProcDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int challengeInsert(ChallengeList challenge) {
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		int cIdx = 1;		// 도전펀딩 idx

		try {
			stmt = conn.createStatement();
			String sql = "select max(ci_idx) + 1 from t_challenge_info ";
			rs = stmt.executeQuery(sql);	
			if(rs.next()) cIdx = rs.getInt(1);	// + 1 할지말지
			
			sql = "insert into t_challenge_info (ci_idx, mi_id, ci_title, ci_content, ci_img, ci_thum_img "
					+ " , ci_edate) values ( " 
					+ cIdx + ", '" 
					+ challenge.getMi_id() + "', '" 
					+ challenge.getCi_title() + "', '" 
					+ challenge.getCi_content() + "', '"
					+ challenge.getCi_img() + "', '"
					+ challenge.getCi_thum_img() + "', '"
					+ challenge.getCi_edate() + "' ) ";	
			
			result = stmt.executeUpdate(sql);
			if(result == 1)		result = cIdx;			
			// insert 성공시 result에 글번호를 저장하여 리턴(글보기 화면으로 이동시 글번호가 필요)
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		
		return result;
	}
}