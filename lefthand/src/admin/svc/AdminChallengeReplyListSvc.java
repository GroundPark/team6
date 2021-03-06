package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;


public class AdminChallengeReplyListSvc {
	public int getAdminChallengeReplyCount(String where) {
		int rcnt = 0;		
		
		Connection conn = getConnection();
		AdminChallengeReplyListDao adminChallengeReplyDao = AdminChallengeReplyListDao.getInstance();
		adminChallengeReplyDao.setConnection(conn);
		rcnt = adminChallengeReplyDao.getAdminChallengeReplyCount(where);
			
		close(conn);
		
		return rcnt;
	}
	
	public ArrayList<AdminChallengeReplyList> getAdminChallengeReplyList(String where, String order, int cpage, int psize){
		ArrayList<AdminChallengeReplyList> adminChallengeReplyList = new ArrayList<AdminChallengeReplyList>();
		Connection conn = getConnection();
		AdminChallengeReplyListDao adminChallengeReplyDao = AdminChallengeReplyListDao.getInstance();
		adminChallengeReplyDao.setConnection(conn);
		adminChallengeReplyList = adminChallengeReplyDao.getAdminChallengeReplyList(where, order, cpage, psize);
			
		close(conn);
		
		return adminChallengeReplyList;
	}
	
}