package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;


public class AdminChallengeListSvc {
	public int getAdminChallengeCount(String where) {
		int rcnt = 0;		
		
		Connection conn = getConnection();
		AdminChallengeListDao adminChallengeDao = AdminChallengeListDao.getInstance();
		adminChallengeDao.setConnection(conn);
		rcnt = adminChallengeDao.getAdminChallengeCount(where);
			
		close(conn);
		
		return rcnt;
	}
	
	public ArrayList<AdminChallengeList> getAdminChallengeList(String where, String order, int cpage, int psize){
		ArrayList<AdminChallengeList> adminChallengeList = new ArrayList<AdminChallengeList>();
		Connection conn = getConnection();
		AdminChallengeListDao adminChallengeDao = AdminChallengeListDao.getInstance();
		adminChallengeDao.setConnection(conn);
		adminChallengeList = adminChallengeDao.getAdminChallengeList(where, order, cpage, psize);
			
		close(conn);
		
		return adminChallengeList;
	}
	
}