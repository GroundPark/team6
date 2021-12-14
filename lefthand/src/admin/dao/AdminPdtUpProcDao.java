package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import vo.*;

public class AdminPdtUpProcDao {
	private static AdminPdtUpProcDao adminPdtUpProcDao;
	private Connection conn;
	
	private AdminPdtUpProcDao() {}
	
	public static AdminPdtUpProcDao getInstance() {
	// 싱글톤 방식으로 인스턴스 낭비를 줄임
		if (adminPdtUpProcDao == null)		adminPdtUpProcDao = new AdminPdtUpProcDao();
		return adminPdtUpProcDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int adminPdtUpdate(ProductInfo pdt) {
		Statement stmt = null;		/*update할 때 resutlset은 필요 없음*/
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "update t_product_info set " +
				" pc_id = '" 		+ pdt.getPc_id() 	 	+ "', " +
				" pi_name = '" 		+ pdt.getPi_name() 	 	+ "', " +
				" pi_price = '" 	+ pdt.getPi_price()  	+ "', " +
				" pi_discount = '" 	+ pdt.getPi_discount()  + "', " +
				" pi_stock = '" 	+ pdt.getPi_stock()  	+ "', " +
				" pi_good = '" 		+ pdt.getPi_good()  	+ "', " +
				" pi_salecnt = '" 	+ pdt.getPi_salecnt()  	+ "', " +
				" pi_soldout = '" 	+ pdt.getPi_soldout()  	+ "', " +
				" pi_isview = '" 	+ pdt.getPi_isview()  	+ "', " +
//				" pi_date = '" 		+ pdt.getPi_date()  	+ "', " +
				" ai_idx = '" 		+ pdt.getAi_idx()  		+ "' " 	+
				" where pi_id = '" 	+ pdt.getPi_id()		+ "' " ;
//			System.out.println(sql);
			result = stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			e. printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}
}
