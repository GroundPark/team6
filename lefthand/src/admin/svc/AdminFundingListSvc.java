package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;


public class AdminFundingListSvc {
	public int getAdminFundingCount(String where) {
		int rcnt = 0;		
		
		Connection conn = getConnection();
		AdminFundingListDao adminFundingDao = AdminFundingListDao.getInstance();
		adminFundingDao.setConnection(conn);
		rcnt = adminFundingDao.getAdminFundingCount(where);
			
		close(conn);
		
		return rcnt;
	}
	
	public ArrayList<AdminFundingList> getAdminFundingList(String where, String order, int cpage, int psize){
		ArrayList<AdminFundingList> adminFundingList = new ArrayList<AdminFundingList>();
		Connection conn = getConnection();
		AdminFundingListDao adminFundingDao = AdminFundingListDao.getInstance();
		adminFundingDao.setConnection(conn);
		adminFundingList = adminFundingDao.getAdminFundingList(where, order, cpage, psize);
			
		close(conn);
		
		return adminFundingList;
	}
	
}