package product.dao;

import static product.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import product.dao.*;
import product.vo.*;

public class ProductDao {
	private static ProductDao productDao;
	private Connection conn;
	
	private ProductDao() {}
	
	public static ProductDao getInstance() {
		if (productDao == null)	productDao = new ProductDao();
		return productDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int getPdtCount(String where) {
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from t_product_info a, t_pdt_cata b " + where;
			rs = stmt.executeQuery(sql);
			
			rs.next();
			rcnt = rs.getInt(1);
			
		}catch(Exception e) {
			System.out.println("productDao : getPdtCount() 에서 에러남");			
			e.printStackTrace();
		}finally {
			close(rs);	close(stmt);
		}
		
		return rcnt;
	}
	
	public ArrayList<ProductInfo> getPdtList(String where, String order, int cpage, int psize){
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();	
		ProductInfo pdt = null;
		
		try {
			String sql = "select a.*, b.pc_id, b.pc_name from t_product_info a, t_pdt_cata b " +
							where + order + " limit " + ((cpage - 1) * psize) + ", " + psize;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {				
			pdt = new ProductInfo();	
			pdt.setPi_idx(rs.getInt("pi_idx"));
            pdt.setPi_id(rs.getString("pi_id"));
            pdt.setPc_id(rs.getString("pc_id"));
            pdt.setPi_name(rs.getString("pi_name"));
            pdt.setPi_price(rs.getInt("pi_price"));
            pdt.setPi_discount(rs.getDouble("pi_discount"));
            pdt.setPi_img1(rs.getString("pi_img1"));
            pdt.setPi_img2(rs.getString("pi_img2"));
            pdt.setPi_img3(rs.getString("pi_img3"));
            pdt.setPi_desc(rs.getString("pi_desc"));
            pdt.setPi_stock(rs.getInt("pi_stock"));
            pdt.setPi_good(rs.getInt("pi_good"));
            pdt.setPi_salecnt(rs.getInt("pi_salecnt"));
            pdt.setPi_review(rs.getInt("pi_review"));
            pdt.setPi_score(rs.getDouble("pi_score"));
            pdt.setPi_isview(rs.getString("pi_isview"));
            pdt.setPi_date(rs.getString("pi_date"));
            pdt.setAi_idx(rs.getInt("ai_idx"));
            pdt.setPc_name(rs.getString("pc_name"));
 
			pdtList.add(pdt);
			}
			}catch(Exception e) {
				System.out.println("productDao : getPdtList() 에서 에러남");			
				e.printStackTrace();
			}finally {
				close(rs);	close(stmt);
			}
		return pdtList;
	}
	
	public ArrayList<PdtCata> getCataList(){
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PdtCata> cataList = new ArrayList<PdtCata>();	
		PdtCata cata = null;
		
		try {
			String sql = "select * from t_pdt_cata";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {				
			cata = new PdtCata();
            
			cata.setPc_id(rs.getString("pc_id"));
			cata.setPc_name(rs.getString("pc_name"));

			cataList.add(cata);
			}
			}catch(Exception e) {
				System.out.println("productDao : getCataList() 에서 에러남");			
				e.printStackTrace();
			}finally {
				close(rs);	close(stmt);
			}
			return cataList;
		}
		
	
}
