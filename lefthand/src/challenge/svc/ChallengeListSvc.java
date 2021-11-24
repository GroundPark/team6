package challenge.svc;

import static challenge.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import challenge.dao.*;
import challenge.vo.*;

public class ChallengeListSvc {
	public int getChallengeCount(String where) {
		int rcnt = 0;		
		
		Connection conn = getConnection();
		ChallengeDao challengeDao = ChallengeDao.getInstance();
		challengeDao.setConnection(conn);
		rcnt = challengeDao.getChallengeCount(where);
			
		close(conn);
		
		return rcnt;
	}
	
	public ArrayList<ChallengeInfo> getChallengeList(String where, String order, int cpage, int psize){
		ArrayList<ChallengeInfo> challengeList = new ArrayList<ChallengeInfo>();
		Connection conn = getConnection();
		ChallengeDao challengeDao = ChallengeDao.getInstance();
		challengeDao.setConnection(conn);
		challengeList = challengeDao.getChallengeList(where, order, cpage, psize);
			
		close(conn);
		
		return challengeList;
	}
	
}