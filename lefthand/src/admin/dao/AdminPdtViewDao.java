package admin.dao;

import static product.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import javax.sql.*;
import vo.*;

public class AdminPdtViewDao {
	private static AdminPdtViewDao adminPdtViewDao;
	private Connection conn;
	
	private AdminPdtViewDao() {}
	
	public static AdminPdtViewDao getInstance() {
		if (adminPdtViewDao == null)	adminPdtViewDao = new AdminPdtViewDao();
		return adminPdtViewDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public ProductInfo getPdtInfo(String piid){ 
		// 상품 정보 가져오는 메소드
			Statement stmt = null;
			ResultSet rs = null;
			ProductInfo pdt = null;
			// pdtList에 저장할 ProductInfo형 인스턴스
			
			try {
				String sql ="select a.*, b.pc_name " + 
						" from t_product_info a, t_pdt_cata b " +
						" where a.pc_id = b.pc_id and " + " a.pi_id = '" + piid + "' ";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);			
				if (rs.next()) {
					pdt = new ProductInfo();

					pdt.setPi_idx(rs.getInt("pi_idx"));				pdt.setPi_id(rs.getString("pi_id"));
					pdt.setPc_id(rs.getString("pc_id"));			pdt.setPi_name(rs.getString("pi_name"));						
					pdt.setPi_price(rs.getInt("pi_price"));			pdt.setPi_discount(rs.getFloat("pi_discount"));
					pdt.setPi_img1(rs.getString("pi_img1"));		pdt.setPi_img2(rs.getString("pi_img2"));
					pdt.setPi_img3(rs.getString("pi_img3"));		pdt.setPi_desc(rs.getString("pi_desc"));
					pdt.setPi_stock(rs.getInt("pi_stock"));			pdt.setPi_good(rs.getInt("pi_good"));
					pdt.setPi_salecnt(rs.getInt("pi_salecnt"));		pdt.setPi_review(rs.getInt("pi_review"));
					pdt.setPi_score(rs.getFloat("pi_score"));		pdt.setPi_soldout(rs.getString("pi_soldout"));
					pdt.setPi_isview(rs.getString("pi_isview"));	pdt.setPi_date(rs.getString("pi_date"));
					pdt.setAi_idx(rs.getInt("ai_idx"));				pdt.setPc_name(rs.getString("pc_name"));
					
				}
							
			} catch(Exception e) {
				System.out.println("adminPdtViewDao : getPdtInfo() 에서 에러남");
				e. printStackTrace();
			}  finally {
				close(rs);	close(stmt);
			}
			
			return pdt;			
			
		}
			
/*		public ArrayList<PdtCata> getCataList(){
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
					System.out.println("adminPdtViewDao : getCataList() 에서 에러남");			
					e.printStackTrace();
				}finally {
					close(rs);	close(stmt);
				}
				return cataList;
			}
			*/

}
