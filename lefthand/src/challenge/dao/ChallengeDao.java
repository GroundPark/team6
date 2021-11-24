package challenge.dao;

import static challenge.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import challenge.dao.*;
import challenge.vo.*;

public class ChallengeDao {
	private static ChallengeDao challengeDao;
	private Connection conn;
	
	private ChallengeDao() {}
	
	public static ChallengeDao getInstance() {
		if (challengeDao == null)	challengeDao = new ChallengeDao();
		return challengeDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int getChallengeCount(String where) {
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from t_challenge_info " + where;
			rs = stmt.executeQuery(sql);
			
			rs.next();
			rcnt = rs.getInt(1);
			
		}catch(Exception e) {
			System.out.println("challengeDao : getChallengeCount() 에서 에러남");			
			e.printStackTrace();
		}finally {
			close(rs);	close(stmt);
		}
		
		return rcnt;
	}
	
	public ArrayList<ChallengeInfo> getChallengeList(String where, String order, int cpage, int psize){
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ChallengeInfo> challengeList = new ArrayList<ChallengeInfo>();	
		ChallengeInfo challenge = null;
		
		try {
			String sql = "select * from t_challenge_info " +
							where + order + " limit " + ((cpage - 1) * psize) + ", " + psize;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {				
			challenge = new ChallengeInfo();	
			challenge.setCi_idx(rs.getInt("ci_idx"));
			challenge.setMi_id(rs.getString("mi_id"));
			challenge.setCi_title(rs.getString("ci_title"));
			challenge.setCi_img(rs.getString("ci_img"));
			challenge.setCi_thum_img(rs.getString("ci_thum_img"));
			challenge.setCi_good(rs.getInt("ci_good"));
			challenge.setCi_sdate(rs.getString("ci_sdate"));
			challenge.setCi_edate(rs.getString("ci_edate"));
			challenge.setCi_step(rs.getInt("ci_step"));
			challenge.setCi_status(rs.getString("ci_status"));
			challenge.setCi_isview(rs.getString("ci_isview"));
			
            challengeList.add(challenge);
			}
			}catch(Exception e) {
				System.out.println("challengeDao : getChallengeList() 에서 에러남");			
				e.printStackTrace();
			}finally {
				close(rs);	close(stmt);
			}
		return challengeList;
	}
	
	
}