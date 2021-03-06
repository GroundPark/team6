package challenge.svc;

import static challenge.db.JdbcUtil.*;		
import java.util.*;
import challenge.dao.*;
import vo.*;
import java.sql.*;

public class ChallengeViewSvc {
// 여기다 후기나 관련상품같이 view에서 보여줄거 넣으셈
	/*
	public ChallengeList getChallengeInfo(int idx) {
	// 도전펀딩 리스트에서 보여줄거
		Connection conn = getConnection();
		ChallengeViewDao challengeViewDao = ChallengeViewDao.getInstance();
		challengeViewDao.setConnection(conn);
		
		ChallengeList challenge = challengeViewDao.getChallengeInfo(idx);
		
		
		close(conn);
		
		return challenge;
	}
	*/
	
	public ChallengeInfo getChallengeDetail(int idx){
	// 도전펀딩 상세에서 보여줄거
		ChallengeInfo challengeInfo = new ChallengeInfo();
		Connection conn = getConnection();
		ChallengeViewDao challengeViewDao = ChallengeViewDao.getInstance();
		challengeViewDao.setConnection(conn);
		challengeInfo = challengeViewDao.getChallengeDetail(idx);
			
		close(conn);
		
		return challengeInfo;
	}
	
	
	public ArrayList<ChallengeReplyList> getChallengeDetailReplyList(int idx){
		// 도전펀딩 상세 댓글 보여줄거
		ArrayList<ChallengeReplyList>  challengeReplyList  = new ArrayList<ChallengeReplyList>();
		Connection conn = getConnection();
		ChallengeViewDao challengeViewDao = ChallengeViewDao.getInstance();
		challengeViewDao.setConnection(conn);
		challengeReplyList = challengeViewDao.getChallengeDetailReplyList(idx);
			
		close(conn);
		
		return challengeReplyList;
	}
}

