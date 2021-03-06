package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminChallengeReplyListUpDao {
	private static AdminChallengeReplyListUpDao adminChallengeReplyListUpDao;
	private Connection conn;
	
	private AdminChallengeReplyListUpDao() {}
	
	public static AdminChallengeReplyListUpDao getInstance() {
		if (adminChallengeReplyListUpDao == null)	adminChallengeReplyListUpDao = new AdminChallengeReplyListUpDao();
		return adminChallengeReplyListUpDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int setReply(int cridx, int ciidx, String miid, String view) {
		Statement stmt = null;
		int vcnt = 0;			
		
		try {
			String sql = "update t_challenge_reply set cr_isview = '" + view + "' " 
					+ " where cr_idx = " + cridx 
					+ " and ci_idx = "  + ciidx 
					+ " and mi_id = '"  + miid + "' ";
			// System.out.println("뭐가잘못된겨" + sql);
			stmt = conn.createStatement();
			vcnt = stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			System.out.println("AdminReplyDao 클래스의 setReply() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(stmt);
		}

		return vcnt;
	}
	


}