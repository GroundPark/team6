package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminFundingUpSvc {
	public AdminFundingList getNoticeInfo(int idx) {
		Connection conn = getConnection();
		AdminFundingUpDao adminFundingUpDao = AdminFundingUpDao.getInstance();
		adminFundingUpDao.setConnection(conn);
		AdminFundingList adminFunding = adminFundingUpDao.getAdminFundingInfo(idx);
		
		close(conn);
		
		return adminFunding;
		}
}
