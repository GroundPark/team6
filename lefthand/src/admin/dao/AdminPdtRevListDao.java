package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import vo.*;

public class AdminPdtRevListDao {
	private static AdminPdtRevListDao adminPdtRevListDao;
	private Connection conn;
	
	private AdminPdtRevListDao() {}
	
	public static AdminPdtRevListDao getInstance() {
		if (adminPdtRevListDao == null)			adminPdtRevListDao = new AdminPdtRevListDao();
		return adminPdtRevListDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int getReviewCount(String where) {
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;	// 리턴할 값(레코드 개수)을 저장할 변수로 값이 없을 경우를 대비하여 0으로 초기화
		
		try {
			stmt = conn.createStatement();
			String sql ="select count(*) from t_review_list" + where;
			rs= stmt.executeQuery(sql);
			
			rs.next();	rcnt = rs.getInt(1);
			
		} catch(Exception e) {
			System.out.println("AdminPdtRevListDao 클래스의 getReviewCount() 메소드 오류");
			e. printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}		
		return rcnt;
	}
	
	
	public ArrayList<ReviewList> getReviewList(String where, String order, int cpage, int psize){
		Statement stmt = null;	// 쿼리를 db로 옮겨서 실행해줌
		ResultSet rs = null;	// 쿼리를 실행한 결과를 받아줌(select쿼리 일 때)
		ArrayList<ReviewList> reviewList = new ArrayList<ReviewList>();
		ReviewList re = null;	
		
		try {
			stmt = conn.createStatement();
			int snum = (cpage - 1) * psize;
			String sql ="select rl_idx, mi_id, pi_id, rl_content, rl_img, rl_score, rl_good, rl_isview, rl_date " 
					+ " from t_review_list "+ where + order + " limit " + snum + ", " + psize;
			rs= stmt.executeQuery(sql);
			while (rs.next()) {
				re = new ReviewList();
//System.out.println(sql);				
				re.setRl_idx(rs.getInt("rl_idx"));
				re.setMi_id(rs.getString("mi_id"));
				re.setPi_id(rs.getString("pi_id"));
				re.setRl_content(rs.getString("rl_content"));
				re.setRl_img(rs.getString("rl_img"));
				re.setRl_score(rs.getInt("rl_score"));
				re.setRl_good(rs.getInt("rl_good"));
				re.setRl_isview(rs.getString("rl_isview"));
				re.setRl_date(rs.getString("rl_date"));
													
				reviewList.add(re);
			}	
			
		} catch(Exception e) {
			System.out.println("AdminPdtRevListDao 클래스의 getReviewList() 메소드 오류");
			e. printStackTrace();
		} 
		
		return reviewList;
	}
	
}
