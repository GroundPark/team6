package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import vo.*;

public class AdminFundingInProcDao {
	private static AdminFundingInProcDao adminFundingInProcDao;
	private Connection conn;
	
	private AdminFundingInProcDao() {}
	
	public static AdminFundingInProcDao getInstance() {
		if (adminFundingInProcDao == null)		adminFundingInProcDao = new AdminFundingInProcDao();
		return adminFundingInProcDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int adminFundingInsert(FundingInfo fdg) {
		Statement stmt = null;
		int result = 0;
		int fiidx = 0;
		
	
		try {
			stmt = conn.createStatement();

			String sql ="insert into t_funding_info (fi_id, fi_name, fi_img1, fi_img2, fi_img3, fi_desc, fi_price, fi_goal, fi_sdate, fi_edate, fi_status, fi_isview, ai_idx) "
					+ "values ( '" + fdg.getFi_id() + "', '" + fdg.getFi_name()  + "', '" + fdg.getFi_img1() + "', '" +	fdg.getFi_img2() + "', '" + fdg.getFi_img3() +
					"', '" + fdg.getFi_desc() + "', " + fdg.getFi_price() +", " + fdg.getFi_goal() + ", '" + 
					fdg.getFi_sdate() + "', '" + fdg.getFi_edate() + "', '" + fdg.getFi_status() + "', '" + fdg.getFi_isview() + "', " + 4 + ") ";
			System.out.println("sql오타 : " + sql);
					result = stmt.executeUpdate(sql);
												
			} catch(Exception e) {
				e. printStackTrace();
			} finally {
				close(stmt);
			}			
			return result;
		}
}

