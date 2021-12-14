package product.dao;

import static product.db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.io.PrintWriter;
import java.sql.*;
import vo.*;


public class LikePlusDao {
	private static LikePlusDao likePlusDao;
	private Connection conn;

	private LikePlusDao() {}

	public static LikePlusDao getInstance() {
		if (likePlusDao == null)	likePlusDao = new LikePlusDao();
		return likePlusDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int cntUpdte(String miid, int rlidx) {
			RevGoodList revGoodList = new RevGoodList();
			Statement stmt = null;
			ResultSet rs = null;
			int result = 0;			

			try {
				stmt = conn.createStatement();
				String sql = "select mi_id from t_review_good where rl_idx =" + rlidx;				
				rs = stmt.executeQuery(sql);
				boolean isOK = true;
				while(rs.next()) {
					if(miid.equals(rs.getString("mi_id"))) {
						isOK = false;
						break;
					}
				}
				if(isOK) {
					sql = "update t_review_list set rl_good = rl_good + 1 where rl_idx = " + rlidx;
					result = stmt.executeUpdate(sql);
					if(result == 1) {
						sql="insert into t_review_good (mi_id, rl_idx) values " + "( '" + miid + "', '" + rlidx + "' )";
						result = stmt.executeUpdate(sql);					
					} else {
						return result;
					}
				}


			} catch(Exception e) {
				System.out.println("LikePlusDao 클래스의 cntUpdte() 메소드 오류");
				e.printStackTrace();
			} finally {
				close(stmt);
			}

			return result;
		}
}
