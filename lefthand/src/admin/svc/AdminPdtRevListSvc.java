package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;


public class AdminPdtRevListSvc {
	public int getReviewCount(String where) {
		int rcnt = 0;	
		Connection conn = getConnection();
		AdminPdtRevListDao adminPdtRevListDao = AdminPdtRevListDao.getInstance();
		adminPdtRevListDao.setConnection(conn);
		rcnt = adminPdtRevListDao.getReviewCount(where);
		close(conn);
		
		return rcnt;
	}
	
	public ArrayList<ReviewList> getReviewList(String where, String order, int cpage, int psize){
		ArrayList<ReviewList> reviewList = null;
		Connection conn = getConnection();
		AdminPdtRevListDao adminPdtRevListDao = AdminPdtRevListDao.getInstance();
		adminPdtRevListDao.setConnection(conn);
		reviewList = adminPdtRevListDao.getReviewList(where, order, cpage, psize);
		close(conn);
		
		return reviewList;
	}
}
