package product.dao;

import static product.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import javax.sql.*;
import vo.*;

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
	// 상품 개수를 가져오는 메소드
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
	// 상품 목록 가져오는 메소드
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
            pdt.setPi_discount(rs.getFloat("pi_discount"));
            pdt.setPi_img1(rs.getString("pi_img1"));
            pdt.setPi_img2(rs.getString("pi_img2"));
            pdt.setPi_img3(rs.getString("pi_img3"));
            pdt.setPi_desc(rs.getString("pi_desc"));
            pdt.setPi_stock(rs.getInt("pi_stock"));
            pdt.setPi_good(rs.getInt("pi_good"));
            pdt.setPi_salecnt(rs.getInt("pi_salecnt"));
            pdt.setPi_review(rs.getInt("pi_review"));
            pdt.setPi_score(rs.getFloat("pi_score"));
            pdt.setPi_soldout(rs.getString("pi_soldout"));
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
		
	public ProductInfo getPdtInfo(String piid){ 
	// 상품 정보 가져오는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		ProductInfo pdt = null;
		// pdtList에 저장할 ProductInfo형 인스턴스
		
		try {
			String sql ="select a.*, b.pc_name " + 
					" from t_product_info a, t_pdt_cata b " +
					" where a.pc_id = b.pc_id and " +
					" a.pi_stock <> 0 and a.pi_isview = 'y' and a.pi_id = '" + piid + "' ";
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
			System.out.println("productDao : getPdtInfo() 에서 에러남");
			e. printStackTrace();
		}  finally {
			close(rs);	close(stmt);
		}
		
		return pdt;
		
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
		
	
// 후기정보-----------------------------------------------------------------------------------------------------------
	
	public int getReviewCount(String piid) {
		// 해당 상품 리뷰의 총 개수를 리턴하는 메소드
			Statement stmt = null;
			ResultSet rs = null;
			int rrcnt = 0;	
			
			try {
				stmt = conn.createStatement();

				String sql ="select count(*) from t_review_list where pi_id = '" + piid + "' ";
				rs= stmt.executeQuery(sql);
				
				rs.next();	rrcnt = rs.getInt(1);
				
			} catch(Exception e) {
				System.out.println("ProductDao 클래스의 getReviewCount() 메소드 오류");
				e. printStackTrace();
			} finally {
				close(rs);	close(stmt);
			}
			
			return rrcnt;
			
		}
		
		public ArrayList<ReviewList> getReviewList(String piid, int cpage, int psize){
		// 목록에서 보여줄 후기목록을 ArrayList<ReviewList>로 리턴하는 메소드
			Statement stmt = null;	
			ResultSet rs = null;	
			ArrayList<ReviewList> reviewList = new ArrayList<ReviewList>();
			ReviewList review = null;	
			
			try {
				stmt = conn.createStatement();
				int snum = (cpage - 1) * psize;
				String sql ="select * from t_review_list " + 
						" where rl_isview = 'y' and pi_id = '" + piid + "' " +
						" order by rl_idx desc limit " + snum +", "+ psize;
				rs= stmt.executeQuery(sql);
				
				while (rs.next()) {
					review = new ReviewList();	
					
					review.setRl_idx(rs.getInt("rl_idx"));
					review.setMi_id(rs.getString("mi_id"));
					review.setRl_content(rs.getString("rl_content"));
					review.setRl_img(rs.getString("rl_img"));
					review.setRl_score(rs.getInt("rl_score"));
					review.setRl_good(rs.getInt("rl_good"));
					review.setRl_isview(rs.getString("rl_isview"));
					review.setRl_date(rs.getString("rl_date"));
					
					reviewList.add(review);
				}	
				
			} catch(Exception e) {
				System.out.println("ProductDao 클래스의 getReviewList() 메소드 오류");
				e. printStackTrace();
			} 
			
			return reviewList;
					
		}
	
}
