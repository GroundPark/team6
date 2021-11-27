package challenge.svc;

import static challenge.db.JdbcUtil.*;		
import java.util.*;
import challenge.dao.*;
import challenge.vo.*;
import java.sql.*;

public class ChallengeViewSvc {
// 여기다 후기나 관련상품같이 view에서 보여줄거 넣으셈
	public ChallengeList getChallengeInfo(int idx) {
	// 도전펀딩 리스트에서 보여줄거
		Connection conn = getConnection();
		ChallengeViewDao challengeViewDao = ChallengeViewDao.getInstance();
		challengeViewDao.setConnection(conn);
		
		ChallengeList challenge = challengeViewDao.getChallengeInfo(idx);
		
		
		close(conn);
		
		return challenge;
	}
	
	public ChallengeInfo getChallengeDetail(int idx){
	// 위에서 만든거 반밖에 안넣어서 여기에 도전펀딩 상세에 대한거 전부 다넣음 ㅈㅅ 나중에 고침
		ChallengeInfo challengeInfo = new ChallengeInfo();
		Connection conn = getConnection();
		ChallengeDao challengeDao = ChallengeDao.getInstance();
		challengeDao.setConnection(conn);
		challengeInfo = challengeDao.getChallengeInfo(idx);
			
		close(conn);
		
		return challengeInfo;
	}
}

