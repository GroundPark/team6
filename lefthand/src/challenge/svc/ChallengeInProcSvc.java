package challenge.svc;

import static challenge.db.JdbcUtil.*;		// jdbcUtil 클래스의 모든 멤버들을 자유롭게 사용하겠다는 의미
import java.util.*;

import challenge.dao.*;
import vo.*;
import java.sql.*;

public class ChallengeInProcSvc {
	public int challengeInsert(ChallengeList challenge) {
		int result = 0;
		Connection conn = getConnection();
		
		ChallengeInProcDao challengeInProcDao = ChallengeInProcDao.getInstance();
		challengeInProcDao.setConnection(conn);
		result = challengeInProcDao.challengeInsert(challenge);
		
		if(result >= 1) 	commit(conn);		// insert는 1개가 아닐때가 많음
		else				rollback(conn);
		
		close(conn);
		return result;
	}
}
