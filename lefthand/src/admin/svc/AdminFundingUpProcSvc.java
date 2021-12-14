package admin.svc;

import static admin.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminFundingUpProcSvc {
	public int AdminFundingUpdate(AdminFundingList adminFunding) {
		int result = 0;
		Connection conn = getConnection();
		
		AdminFundingUpProcDao adminFundingUpProcDao = AdminFundingUpProcDao.getInstance();
		adminFundingUpProcDao.setConnection(conn);
		result = adminFundingUpProcDao.adminFundingUpdate(adminFunding);
		
		if(result >= 1) 	commit(conn);		
		else				rollback(conn);
		
		close(conn);
		return result;
	}
}
