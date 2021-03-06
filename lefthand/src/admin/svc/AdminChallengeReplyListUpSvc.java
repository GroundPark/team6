package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminChallengeReplyListUpSvc {
	public int setReply(int cridx, int ciidx, String miid, String view) {
		int vcnt = 0;		
		
		
		Connection conn = getConnection();
		AdminChallengeReplyListUpDao adminChallengeReplyListUpDao = AdminChallengeReplyListUpDao.getInstance();
		adminChallengeReplyListUpDao.setConnection(conn);
		vcnt = adminChallengeReplyListUpDao.setReply(cridx, ciidx, miid, view);
		
		if(vcnt >= 1) 	commit(conn);		
		else			rollback(conn);
		
		close(conn);
		
		return vcnt;
	}
}


