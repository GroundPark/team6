package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import vo.*;

public class AdminPdtInProcDao {
	private static AdminPdtInProcDao adminPdtInProcDao;
	private Connection conn;
	
	private AdminPdtInProcDao() {}
	
	public static AdminPdtInProcDao getInstance() {
		if (adminPdtInProcDao == null)		adminPdtInProcDao = new AdminPdtInProcDao();
		return adminPdtInProcDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int adminPdtInsert(ProductInfo pdt) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql ="insert into t_product_info(pi_id, pc_id, pi_name, pi_img1, pi_img2, pi_img3, pi_desc, pi_price, pi_discount, pi_stock, pi_soldout, pi_isview, ai_idx) " + 
					" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			
			
			
			
			
			result = pstmt.executeUpdate(sql);
				
		} catch(Exception e) {
			e. printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
