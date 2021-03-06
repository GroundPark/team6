package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import vo.*;

public class AdminPdtListDao {
	private static AdminPdtListDao adminPdtListDao;
	private Connection conn;
	
	private AdminPdtListDao() {}
	
	public static AdminPdtListDao getInstance() {
		if (adminPdtListDao == null)			adminPdtListDao = new AdminPdtListDao();
		return adminPdtListDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int getPdtCount(String where) {
		// 조건에 맞는 게시글의 총 개수를 리턴하는 메소드
			Statement stmt = null;
			ResultSet rs = null;
			int rcnt = 0;	// 리턴할 값(레코드 개수)을 저장할 변수로 값이 없을 경우를 대비하여 0으로 초기화
			
			try {
				stmt = conn.createStatement();
				String sql ="select count(*) from t_product_info a, t_pdt_cata b" + where;
				rs= stmt.executeQuery(sql);
				
				rs.next();	rcnt = rs.getInt(1);
				
			} catch(Exception e) {
				System.out.println("AdminPdtListDao 클래스의 getPdtCount() 메소드 오류");
				e. printStackTrace();
			} finally {
				close(rs);	close(stmt);
			}
			
			return rcnt;
			
		}
		
		public ArrayList<ProductInfo> getPdtList(String where, String order, int cpage, int psize){
			Statement stmt = null;	// 쿼리를 db로 옮겨서 실행해줌
			ResultSet rs = null;	// 쿼리를 실행한 결과를 받아줌(select쿼리 일 때)
			ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();
			ProductInfo pdt = null;	
			
			try {
				stmt = conn.createStatement();
				int snum = (cpage - 1) * psize;
				String sql ="select a.pi_idx, a.pi_id, b.pc_name, a.pi_name, a.pi_stock, a.pi_review, a.pi_date, a.pi_isview " 
						+ "from t_product_info a, t_pdt_cata b "+ where + order + " limit " + snum + ", " + psize;
				rs= stmt.executeQuery(sql);
				while (rs.next()) {
					pdt = new ProductInfo();	
//System.out.println(sql);					
					pdt.setPi_idx(rs.getInt("pi_idx"));
					pdt.setPi_id(rs.getString("pi_id"));
					pdt.setPc_name(rs.getString("pc_name"));
					pdt.setPi_name(rs.getString("pi_name"));
					pdt.setPi_stock(rs.getInt("pi_stock"));
					pdt.setPi_review(rs.getInt("pi_review"));
					pdt.setPi_date(rs.getString("pi_date"));
					pdt.setPi_isview(rs.getString("pi_isview"));
										
					pdtList.add(pdt);
				}	
				
			} catch(Exception e) {
				System.out.println("AdminPdtListDao 클래스의 getPdtList() 메소드 오류");
				e. printStackTrace();
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
					System.out.println("AdminPdtListDao : getCataList() 에서 에러남");			
					e.printStackTrace();
				}finally {
					close(rs);	close(stmt);
				}
				return cataList;
			}
}

