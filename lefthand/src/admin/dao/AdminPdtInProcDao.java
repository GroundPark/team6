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
		Statement stmt = null;
		int result = 0;
		int piidx = 0;
		
	
		try {
			stmt = conn.createStatement();
			
			String sql = "select max(pi_idx) from t_product_info";
			
			sql ="insert into t_product_info(pi_id, pc_id, pi_name, pi_img1, pi_img2, pi_img3, pi_desc, " +
					"pi_price, pi_discount, pi_stock, pi_soldout, pi_isview, ai_idx) values ( '" + 
					pdt.getPi_id() + "', '" + pdt.getPc_id()  + "', '" + pdt.getPi_name() + "', '" + pdt.getPi_img1() + "' ,'" + 
					pdt.getPi_img2() + "', '" + pdt.getPi_img3() + "', '" + pdt.getPi_desc() + "', " + pdt.getPi_price() +
					", " + pdt.getPi_discount() + ", " + pdt.getPi_stock() + ", '" + pdt.getPi_soldout() + "', '" +
					pdt.getPi_isview() + "', " + pdt.getAi_idx() + " ) ";
			
					result = stmt.executeUpdate(sql);
												
			} catch(Exception e) {
				e. printStackTrace();
			} finally {
				close(stmt);
			}			
			return result;
		}
}
