package admin.dao;

import static product.db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.io.PrintWriter;
import java.sql.*;
import vo.*;

public class AdminReviewDao {
	private static AdminReviewDao adminReviewDao;
	private Connection conn;

	private AdminReviewDao() {}

	public static AdminReviewDao getInstance() {
		if (adminReviewDao == null)			adminReviewDao = new AdminReviewDao();
		return adminReviewDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int setReview(int rlidx, String piid, String miid, String view) {
			Statement stmt = null;
			int vcnt = 0;			

			try {
				String sql = "update t_review_list set rl_isview = '" + view + "' " +
							  "where rl_idx = " + rlidx + " and pi_id = '" + piid + "' and " +
							  "mi_id = '" + miid + "' ";
//				System.out.println(sql);
				stmt = conn.createStatement();
				vcnt = stmt.executeUpdate(sql);
				
			} catch(Exception e) {
				System.out.println("AdminReviewDao 클래스의 setReview() 메소드 오류");
				e.printStackTrace();
			} finally {
				close(stmt);
			}

			return vcnt;
		}
}
