package admin.svc;

import static admin.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminChallengeUpProcSvc {
	public int AdminChallengeUpdate(AdminChallengeList adminChallenge) {
		int result = 0;
		Connection conn = getConnection();
		
		AdminChallengeUpProcDao adminChallengeUpProcDao = AdminChallengeUpProcDao.getInstance();
		adminChallengeUpProcDao.setConnection(conn);
		result = adminChallengeUpProcDao.adminChallengeUpdate(adminChallenge);
		
		if(result >= 1) 	commit(conn);		
		else				rollback(conn);
		
		close(conn);
		return result;
	}
}
