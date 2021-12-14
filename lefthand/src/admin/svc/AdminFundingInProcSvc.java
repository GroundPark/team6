package admin.svc;

import static admin.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminFundingInProcSvc {
	public int adminFundingInsert(FundingInfo fdg) {
		int result = 0;
		Connection conn = getConnection();
		AdminFundingInProcDao adminFundingInProcDao = AdminFundingInProcDao.getInstance();
		adminFundingInProcDao.setConnection(conn);
		result = adminFundingInProcDao.adminFundingInsert(fdg);
		
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		return result;
	}
}
