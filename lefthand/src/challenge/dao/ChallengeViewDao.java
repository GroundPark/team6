package challenge.dao;

import static challenge.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import challenge.dao.*;
import vo.*;

public class ChallengeViewDao {
	private static ChallengeViewDao challengeViewDao;
	private Connection conn;
	
	private ChallengeViewDao() {}
	
	public static ChallengeViewDao getInstance() {
		if (challengeViewDao == null)	challengeViewDao = new ChallengeViewDao();
		return challengeViewDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public ChallengeInfo getChallengeDetail(int idx) {
	// 지정한 글번호에 해당하는 게시글 정보를 ChallengeInfo형 인스턴스에 담아 리턴하는 메소드
			Statement stmt = null;
			ResultSet rs = null;
			ChallengeInfo challengeDetail = null;		
			
			try {		// 다 하고 정리함
				stmt = conn.createStatement();
				String sql = "select * from t_challenge_info where ci_idx = " + idx;
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {			
					challengeDetail = new ChallengeInfo();		
					challengeDetail.setCi_idx(idx);
					challengeDetail.setCi_title(rs.getString("ci_title"));
					challengeDetail.setCi_content(rs.getString("ci_content"));
					challengeDetail.setCi_img(rs.getString("ci_img"));
					challengeDetail.setCi_good(rs.getInt("ci_good"));
					challengeDetail.setCi_sdate(rs.getString("ci_sdate"));
					challengeDetail.setCi_edate(rs.getString("ci_edate"));
					challengeDetail.setCi_step(rs.getInt("ci_step"));
					challengeDetail.setCi_status(rs.getString("ci_status"));
					challengeDetail.setCi_isview(rs.getString("ci_isview"));
					challengeDetail.setMi_id(rs.getString("mi_id"));
				}	
			}catch(Exception e) {
				System.out.println("ChallengeViewDao : getChallengeDetail() 메소드 오류");
				e.printStackTrace();
			}
			
			return challengeDetail;
		}
	
	public ArrayList<ChallengeReplyList> getChallengeDetailReplyList(int idx) {
	// 지정한 글번호에 해당하는 댓글 정보들을 ChallengeReply형 인스턴스에 담아 리턴하는 메소드
				Statement stmt = null;
				ResultSet rs = null;
				ArrayList<ChallengeReplyList> challengeReplyList = new ArrayList<ChallengeReplyList>();	
				ChallengeReplyList challengeReply = null;
				
				try {		// 다 하고 정리함
					stmt = conn.createStatement();
					String sql = "select * from t_challenge_reply where ci_idx = " + idx;
					rs = stmt.executeQuery(sql);
					
					while(rs.next()) {			
						challengeReply = new ChallengeReplyList();		
						challengeReply.setCi_idx(idx);
						challengeReply.setMi_id(rs.getString("mi_id"));
						challengeReply.setCr_content(rs.getString("cr_content"));
						challengeReply.setCr_idx(rs.getInt("cr_idx"));
						challengeReply.setCr_date(rs.getString("cr_date"));
						challengeReply.setCr_isview(rs.getString("cr_isview"));
						
						challengeReplyList.add(challengeReply);

					}	
				}catch(Exception e) {
					System.out.println("ChallengeViewDao : getChallengeDetailReplyList() 메소드 오류");
					e.printStackTrace();
				}finally {
					close(rs);	close(stmt);
				}
				
				return challengeReplyList;
			}
	
	
	

}
