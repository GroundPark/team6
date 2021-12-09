package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminFundingUpDao {
	private static AdminFundingUpDao adminFundingUpDao;
	private Connection conn;
	
	private AdminFundingUpDao() {}
	// 외부에서 함부로 인스턴스 생성하지 못하게 private로 생성자를 선언함
	
	public static AdminFundingUpDao getInstance() {
	// 싱글톤 방식
		if (adminFundingUpDao == null)	adminFundingUpDao = new AdminFundingUpDao();
		return adminFundingUpDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public AdminFundingList getAdminFundingInfo(int idx) {
			Statement stmt = null;
			ResultSet rs = null;
			AdminFundingList adminFunding = null;		
			
			try {
				stmt = conn.createStatement();
				String sql = "select * from t_funding_info where fi_idx = " + idx;
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					adminFunding = new AdminFundingList();	
					adminFunding.setFi_idx(rs.getInt("fi_idx"));
					adminFunding.setFi_id(rs.getString("fi_id"));
					adminFunding.setFi_name(rs.getString("fi_name"));
					adminFunding.setFi_img1(rs.getString("fi_img1"));
					adminFunding.setFi_img2(rs.getString("fi_img2"));
					adminFunding.setFi_img3(rs.getString("fi_img3"));
					adminFunding.setFi_desc(rs.getString("fi_desc"));
					adminFunding.setFi_price(rs.getInt("fi_price"));
					adminFunding.setFi_ordercnt(rs.getInt("fi_ordercnt"));
					adminFunding.setFi_goal(rs.getInt("fi_goal"));
					adminFunding.setFi_rate(rs.getFloat("fi_rate"));
					adminFunding.setFi_support(rs.getInt("fi_support"));
					adminFunding.setFi_total(rs.getInt("fi_total"));
					adminFunding.setFi_good(rs.getInt("fi_good"));
					adminFunding.setFi_sdate(rs.getString("fi_sdate"));
					adminFunding.setFi_edate(rs.getString("fi_edate"));
					adminFunding.setFi_status(rs.getString("fi_status"));
					adminFunding.setFi_isview(rs.getString("fi_isview"));
				}	
			}catch(Exception e) {
				System.out.println("AdminFundingUpDao : getAdminFundingInfo() 메소드 오류");	
				e.printStackTrace();
			}
			
			return adminFunding;
	}
}