package challenge.svc;

import static challenge.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import challenge.dao.*;
import vo.*;

public class ChallengeGoodSvc {
	public int challengeGoodInsert(ChallengeGoodList challengeGood) {
		int result = 0;
		Connection conn = getConnection();
		
		ChallengeGoodDao challengeGoodInDao = ChallengeGoodDao.getInstance();
		challengeGoodInDao.setConnection(conn);
		result = challengeGoodInDao.challengeGoodInsert(challengeGood);
		
		if(result >= 1) 	commit(conn);		
		else				rollback(conn);
		
		close(conn);
		return result;
	}
	
	public ChallengeGoodable getChallengeGoodable(int idx, String miid) {
		int result = 0;
		Connection conn = getConnection();
		
		ChallengeGoodDao challengeGoodableDao = ChallengeGoodDao.getInstance();
		challengeGoodableDao.setConnection(conn);
		ChallengeGoodable myGoodable = challengeGoodableDao.getChallengeGoodable(idx, miid);
		
		close(conn);
		return myGoodable;
	}
	
	
	
	
	
	
	public int challengeGoodCancel(ChallengeGoodList challengeGood) {
		int result = 0;
		Connection conn = getConnection();
		
		ChallengeGoodDao challengeGoodDao = ChallengeGoodDao.getInstance();
		challengeGoodDao.setConnection(conn);
		result = challengeGoodDao.challengeGoodCancel(challengeGood);
		
		if(result >= 1) 	commit(conn);		
		else				rollback(conn);
		
		close(conn);
		return result;
	}
	
}
