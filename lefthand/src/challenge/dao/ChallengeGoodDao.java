package challenge.dao;

import static challenge.db.JdbcUtil.*;		
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class ChallengeGoodDao {
	private static ChallengeGoodDao challengeGoodInDao;
	private Connection conn;
	
	private ChallengeGoodDao() {}
	public static ChallengeGoodDao getInstance() {
	// singleton
		if(challengeGoodInDao == null)		challengeGoodInDao = new ChallengeGoodDao();
		return challengeGoodInDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int challengeGoodInsert(ChallengeGoodList challengeGood) {
		Statement stmt = null, stmt2 = null, stmt3 = null, stmt4 = null, stmt5 = null;
		ResultSet rs = null, rs2 = null;
		int result = 0;
		int result2 = 0;
		int cIdx = 1;		// 도전펀딩 idx
		int cGood = 0;		// 도전펀딩 글의 좋아요 수

		try {
			// 마지막 좋아요 idx + 1한 곳에...
			stmt = conn.createStatement();
			String sql = "select max(cg_idx) + 1 from t_challenge_good where cg_idx = " 
						+ challengeGood.getCg_idx();
			rs = stmt.executeQuery(sql);	
			if(rs.next()) cIdx = rs.getInt(1);	
		
			// cg_history에 값을 줘서 기록을 남긴다...
			sql = "insert into t_challenge_good (cg_idx, mi_id, ci_idx, cg_history) values ( " 
					+ cIdx + ", '" 
					+ challengeGood.getMi_id() + "' , "
					+ challengeGood.getCi_idx() + " , "
					+ 1 + ") ";
					// + challengeGood.getCg_history() + ") ";
			result = stmt.executeUpdate(sql);
			
			// 또한 ci_good에 +1하는 쿼리도 날려야 한다
			stmt2 = conn.createStatement();
			sql = "update t_challenge_info set ci_good = ci_good + 1 where ci_idx = " + challengeGood.getCi_idx();
			result = stmt.executeUpdate(sql);

			// 더해서 판별후 ci_step 1차,2차,확정을 update해야함
			stmt2 = conn.createStatement();
			sql = "select ci_good from t_challenge_info where ci_idx = " + challengeGood.getCi_idx();
			System.out.println("50개 2단계 테스트 selcet : " +sql);
			rs2 = stmt2.executeQuery(sql);	
			if(rs2.next()) cGood = rs2.getInt(1);	
			
			if(cGood == 50 ) {
				stmt3 = conn.createStatement();
				sql = "update t_challenge_info set ci_step = 2, ci_sdate = now(), ci_edate = DATE_ADD(NOW(), "
						+ " INTERVAL 1 MONTH)  where ci_idx = " + challengeGood.getCi_idx();	
				System.out.println("테스트 update 2단계 됨 : " +sql);
				result2 = stmt3.executeUpdate(sql);
			// 좋아요가 50개가 되면 업데이트 하는 sql
			// * 49개로 취소한다음 다시 50개로 좋아요 누르면 그때마다의 now()로 2단계가 되니까 장난질에 취약할듯
			}else if (cGood == 200) {
				stmt5 = conn.createStatement();
				sql = "update t_challenge_info set ci_status = 'c' where ci_idx = " + challengeGood.getCi_idx();
				System.out.println("테스트 update 확정 됨 : " +sql);
				result2 = stmt5.executeUpdate(sql);
			// 좋아요가 200개가 되면 성공이므로 딱히 뭐 할건 없는듯
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);	
			close(rs2);
			close(stmt);
			close(stmt2);
			close(stmt3);
			close(stmt4);
		}
		
		return result;
	}
	
	public int challengeGoodCancel(ChallengeGoodList challengeGood) {
		Statement stmt = null, stmt2 = null, stmt3 = null, stmt4 = null;
		ResultSet rs = null, rs2 = null;
		int result = 0, result2 = 0;
		int cIdx = 1;		// 도전펀딩 idx
		int cGood = 0;

		try {
			// 마지막 좋아요 idx + 1한 곳에...
			stmt = conn.createStatement();
			String sql = "select max(cg_idx) + 1 from t_challenge_good where cg_idx = " 
						+ challengeGood.getCg_idx();
			rs = stmt.executeQuery(sql);	
			if(rs.next()) cIdx = rs.getInt(1);	
		
			// cg_history에 값을 줘서 기록을 남긴다...
			sql = "insert into t_challenge_good (cg_idx, mi_id, ci_idx, cg_history) values ( " 
					+ cIdx + ", '" 
					+ challengeGood.getMi_id() + "' , "
					+ challengeGood.getCi_idx() + " , "
					+ 0 + ") ";
			result = stmt.executeUpdate(sql);
			
			// 또한 ci_good에 -1하는 쿼리도 날려야 한다
			sql = "update t_challenge_info set ci_good = ci_good - 1 where ci_idx = " + challengeGood.getCi_idx();
			// System.out.println(sql);		
			result = stmt.executeUpdate(sql);
			
			// 더해서 판별후 ci_step 1차,2차,확정을 update해야함
			stmt2 = conn.createStatement();
			sql = "select ci_good from t_challenge_info where ci_idx = " + challengeGood.getCi_idx();
			System.out.println("50개 2단계 테스트 selcet : " +sql);
			rs2 = stmt2.executeQuery(sql);	
			if(rs2.next()) cGood = rs2.getInt(1);	
			
			// (수정됨) 한번 2단계가 되었으면 좋아요를 취소해도 1단계로 돌아가지는 않음
			
			/*
			if(cGood == 49 ) {
				stmt3 = conn.createStatement();
				sql = "update t_challenge_info set ci_step = 1 where ci_idx = " + challengeGood.getCi_idx();	
				System.out.println("테스트 update cancel 1단계 됨 : " +sql);
				result2 = stmt3.executeUpdate(sql);

			}else if (cGood == 199 ) {
				stmt4 = conn.createStatement();
				sql = "update t_challenge_info set ci_status = 'a' where ci_idx = " + challengeGood.getCi_idx();
				System.out.println("테스트 update cancel 미확정 됨 : " +sql);
				result2 = stmt4.executeUpdate(sql);
			// 한번 확정이 되었으면 좋아요를 취소해도 전단계로 돌아가지 않음
			}
			*/			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);		
			close(stmt);
			close(rs2);		
			close(stmt2);
		}
		
		return result;
	}
	
	public ChallengeGoodable getChallengeGoodable(int idx, String miid) {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		ChallengeGoodable challengeGoodable = null;
		
		try {
			stmt = conn.createStatement();
			sql = "select cg_history from t_challenge_good where ci_idx = " 
					 + idx
					 + " and mi_id = '" + miid
					+ "' order by cg_idx desc limit 1 ";
			rs = stmt.executeQuery(sql);
			// System.out.println(sql);
			
			if(rs.next()){
				do{
					challengeGoodable = new ChallengeGoodable();
					challengeGoodable.setCg_history(rs.getInt("cg_history"));
				}while(rs.next());


			}else{
				challengeGoodable = new ChallengeGoodable();
				System.out.println("challengeGoodDao에서 rs값이 null이므로 0 처리되었습니다");
				challengeGoodable.setCg_history(0);	
			}
			

		} catch(Exception e) {
			System.out.println("GoodDao 클래스의 getChallengeGoodable() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt); 
		}
		
		return challengeGoodable;
	}
	
	
	
	
	
}