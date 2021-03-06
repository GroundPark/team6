package challenge.dao;

import static challenge.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import challenge.dao.*;
import vo.*;

public class ChallengeListDao {
	private static ChallengeListDao challengeDao;
	private Connection conn;
	
	private ChallengeListDao() {}
	
	public static ChallengeListDao getInstance() {
		if (challengeDao == null)	challengeDao = new ChallengeListDao();
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
			System.out.println("challengeListDao : getChallengeCount() 에서 에러남");			
			e.printStackTrace();
		}finally {
			close(rs);	close(stmt);
		}
		
		return rcnt;
	}
	
	public ArrayList<ChallengeList> getChallengeList(String where, String order, int cpage, int psize){
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ChallengeList> challengeList = new ArrayList<ChallengeList>();	
		ChallengeList challenge = null;
		
		try {
			int snum = (cpage - 1) * psize;

			String sql = "select * " + 
					" from t_challenge_info " + 
					where + order +
					" limit " + snum + ", " + psize;
		// System.out.println("리스트 search&sort : " +sql);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {				
					challenge = new ChallengeList();	
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
				System.out.println("challengeListDao : getChallengeList() 에서 에러남");			
				e.printStackTrace();
			}finally {
				close(rs);	close(stmt);
			}
		return challengeList;
	}
	
	
}