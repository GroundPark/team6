package challenge.svc;

import static challenge.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import challenge.dao.*;
import vo.*;

public class ChallengeReplySvc {
	public int challengeInsert(ChallengeReplyList challengeReply) {
		int result = 0;
		Connection conn = getConnection();
		
		ChallengeReplyInDao challengeReplyInDao = ChallengeReplyInDao.getInstance();
		challengeReplyInDao.setConnection(conn);
		result = challengeReplyInDao.challengeReplyInsert(challengeReply);
		
		if(result >= 1) 	commit(conn);		
		else				rollback(conn);
		
		close(conn);
		return result;
	}
	/*
	public int challengeDelete(ChallengeReplyList challengeReply) {
		int result = 0;
		Connection conn = getConnection();
		
		ChallengeReplyDelDao challengeReplyDelDao = ChallengeReplyDelDao.getInstance();
		challengeReplyDelDao.setConnection(conn);
		result = challengeReplyDelDao.challengeReplyDelete(challengeReply);
		
		if(result == 1) 	commit(conn);		
		else				rollback(conn);
		
		close(conn);
		return result;
	}
	*/
}
