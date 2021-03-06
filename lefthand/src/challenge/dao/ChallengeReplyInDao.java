package challenge.dao;

import static challenge.db.JdbcUtil.*;		
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class ChallengeReplyInDao {
	private static ChallengeReplyInDao challengeReplyInDao;
	private Connection conn;
	
	private ChallengeReplyInDao() {}
	public static ChallengeReplyInDao getInstance() {
	// singleton
		if(challengeReplyInDao == null)		challengeReplyInDao = new ChallengeReplyInDao();
		return challengeReplyInDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int challengeReplyInsert(ChallengeReplyList challengeReply) {
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		int crIdx = 1;		// 도전펀딩 댓글 idx

		
		// int myCridx = ( challengeReplyList.size() == 0 ) ? 
		//			-1 : challengeReplyList.get(challengeReplyList.size() - 1).getCr_idx();
		
		
		try {
			// 마지막 댓글의 idx + 1한 곳에 댓글을 넣는다 
			stmt = conn.createStatement();
			String sql = "select max(cr_idx) + 2 from t_challenge_reply where ci_idx = " + challengeReply.getCi_idx();

			rs = stmt.executeQuery(sql);	
			if(rs.next()) crIdx = rs.getInt(1);	
			
			// sql = "insert into t_challenge_reply (cr_idx, ci_idx, mi_id, cr_content) values ( " 
			//		+ crIdx + ", " 
			// 수정 : cr_idx에 값 주지마셈
			
			sql = "insert into t_challenge_reply (ci_idx, mi_id, cr_content) values ( " 
					+ challengeReply.getCi_idx() + ", '"
					+ challengeReply.getMi_id() + "' ,'"
					+ challengeReply.getCr_content() + "') ";
			
			System.out.println("sql 댓글 테스트" + sql);
			result = stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		
		return result;
	}
}