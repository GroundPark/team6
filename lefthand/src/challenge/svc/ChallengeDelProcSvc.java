package challenge.svc;

import static challenge.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import challenge.dao.*;
import vo.*;

public class ChallengeDelProcSvc {
	public int challengeDelete(int idx) {
		int result = 0;
		Connection conn = getConnection();
		
		ChallengeDelProcDao challengeDelProcDao = ChallengeDelProcDao.getInstance();
		challengeDelProcDao.setConnection(conn);
		result = challengeDelProcDao.challengeDelete(idx);
		
		if(result >= 1) 	commit(conn);		
		else				rollback(conn);
		
		close(conn);
		return result;
	}
}
