package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminChallengeListDao {
	private static AdminChallengeListDao adminChallengeListDao;
	private Connection conn;
	
	private AdminChallengeListDao() {}
	
	public static AdminChallengeListDao getInstance() {
		if (adminChallengeListDao == null)	adminChallengeListDao = new AdminChallengeListDao();
		return adminChallengeListDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int getAdminChallengeCount(String where) {
	// 조건에 맞는 게시글의 총 개수를 리턴하는 메소드	
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;		// 리턴할 값(레코드 개수)를 저장할 변수로 값이 없을 경우를 대비하여 0으로 초기화
		
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from t_challenge_info " + where;
			rs = stmt.executeQuery(sql);
			
			rs.next();					// count()라서 있기는 항상있으니 그냥 써도됨
			rcnt = rs.getInt(1);		// 1 : 컬럼번호... 딱히 지정한거 아니니까 idx

		}catch(Exception e) {
			System.out.println("AdminChallengeListDao : getAdminChallengeCount() 메소드 오류");		
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}

		return rcnt;
	}	
	
	public ArrayList<AdminChallengeList> getAdminChallengeList(String where, String order, int cpage, int psize){
	// 목록에서 보여줄 게시글 목록을 ArrayList<NoticeList>로 리턴하는 메소드
		Statement stmt = null;		// 쿼리를 DB로 옮겨서 실행
		ResultSet rs = null;		// select 쿼리에 맞는것들 담을곳
		ArrayList<AdminChallengeList> adminChallengeList = new ArrayList<AdminChallengeList>();
		// ArrayList의 size() 메소드를 이용하면 AL 안에 데이터가 없을경우 알아낼 수 있기 때문에 생성한 채로 작업해도 됨
		AdminChallengeList adminChallenge = null;	// 하나의 게시글 저장 인스턴스... ArrayList에 저장될 객체
		
		try {
			stmt = conn.createStatement();
			int snum = (cpage - 1) * psize;
	
			String sql = "select * " + 
					" from t_challenge_info " + 
					where + 
					order +
					" limit " + snum + ", " + psize;
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {				
				adminChallenge = new AdminChallengeList();	
				adminChallenge.setCi_idx(rs.getInt("ci_idx"));
				adminChallenge.setMi_id(rs.getString("mi_id"));
				adminChallenge.setCi_title(rs.getString("ci_title"));
				adminChallenge.setCi_img(rs.getString("ci_img"));
				adminChallenge.setCi_thum_img(rs.getString("ci_thum_img"));
				adminChallenge.setCi_good(rs.getInt("ci_good"));
				adminChallenge.setCi_sdate(rs.getString("ci_sdate"));
				adminChallenge.setCi_edate(rs.getString("ci_edate"));
				adminChallenge.setCi_step(rs.getInt("ci_step"));
				adminChallenge.setCi_status(rs.getString("ci_status"));
				adminChallenge.setCi_isview(rs.getString("ci_isview"));
				
				adminChallengeList.add(adminChallenge);
			}
		}catch(Exception e) {
			System.out.println("AdminChallengeListDao : getAdminChallengeList() 에서 에러남");			
			e.printStackTrace();
		}finally {
			close(rs);	close(stmt);
		}
	return adminChallengeList;
}


}