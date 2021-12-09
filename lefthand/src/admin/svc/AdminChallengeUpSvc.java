package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminChallengeUpSvc {
	public AdminChallengeList getNoticeInfo(int idx) {
		Connection conn = getConnection();
		AdminChallengeUpDao adminChallengeUpDao = AdminChallengeUpDao.getInstance();
		adminChallengeUpDao.setConnection(conn);
		AdminChallengeList adminChallenge = adminChallengeUpDao.getAdminChallengeInfo(idx);
		
		close(conn);
		
		return adminChallenge;
		}
}
