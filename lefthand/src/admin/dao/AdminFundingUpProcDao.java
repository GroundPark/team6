package admin.dao;

import static admin.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminFundingUpProcDao {
	private static AdminFundingUpProcDao adminFundingUpProcDao;
	private Connection conn;
	
	private AdminFundingUpProcDao() {}
	public static AdminFundingUpProcDao getInstance() {
		if(adminFundingUpProcDao == null)		adminFundingUpProcDao = new AdminFundingUpProcDao();
		return adminFundingUpProcDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int adminFundingUpdate(AdminFundingList adminFunding) {
		Statement stmt = null;
		int result = 0;

		try {
			stmt = conn.createStatement();
			String sql = "update t_funding_info set fi_name = '" + adminFunding.getFi_name() + "', " 
							+ " fi_desc = '" + adminFunding.getFi_desc() + "', " 
							+ " fi_img1 = '" + adminFunding.getFi_img1() + "', "  
							+ " fi_img2 = '" + adminFunding.getFi_img2() + "', "  
							+ " fi_img3 = '" + adminFunding.getFi_img3() + "', " 
							+ " fi_price = " + adminFunding.getFi_price() + ", " 
							+ " fi_goal = " + adminFunding.getFi_goal() + ", "
							+ " fi_sdate = '" + adminFunding.getFi_sdate() + "', "
							+ " fi_edate = '" + adminFunding.getFi_edate() + "', "
							+ " fi_isview = '" + adminFunding.getFi_isview() + "', "
							+ " fi_status = '" + adminFunding.getFi_status() + "' "
							+ " where fi_idx = " + adminFunding.getFi_idx();
			result = stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		
		return result;
	}
}