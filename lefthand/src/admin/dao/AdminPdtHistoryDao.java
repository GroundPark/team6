package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import vo.*;

public class AdminPdtHistoryDao {
	private static AdminPdtHistoryDao adminPdtHistoryDao;
	private Connection conn;
	
	private AdminPdtHistoryDao() {}
	
	public static AdminPdtHistoryDao getInstance() {
		if (adminPdtHistoryDao == null)			adminPdtHistoryDao = new AdminPdtHistoryDao();
		return adminPdtHistoryDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<ProductHistory> getPdtHistoryList(String piid){
		Statement stmt = null;	// 쿼리를 db로 옮겨서 실행해줌
		ResultSet rs = null;	// 쿼리를 실행한 결과를 받아줌(select쿼리 일 때)
		ArrayList<ProductHistory> productHistory = new ArrayList<ProductHistory>();
		ProductHistory ph = null;
		
		try {
			stmt = conn.createStatement();
			String sql ="select * from t_pdt_history where pi_id = '" + piid + "' order by ph_date desc";
			rs= stmt.executeQuery(sql);
			while (rs.next()) {
				ph = new ProductHistory();

				ph.setPh_idx(rs.getInt("ph_idx"));
				ph.setPi_id(rs.getString("pi_id"));
				ph.setPh_oldprice(rs.getInt("ph_oldprice"));
				ph.setPh_newprice(rs.getInt("ph_newprice"));
				ph.setPh_date(rs.getString("ph_date"));
				ph.setAi_idx(rs.getInt("ai_idx"));								
				productHistory.add(ph);
			}	
			
		} catch(Exception e) {
			System.out.println("AdminPdtRevListDao 클래스의 getPdtHistoryList() 메소드 오류");
			e. printStackTrace();
		} 
		return productHistory;	
	}
}
