package product.svc;

import static product.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import product.dao.*;
import vo.*;

public class PdtViewSvc {
	public ProductInfo getPdtInfo(String piid){
		ProductInfo pdtInfo = new ProductInfo();
		Connection conn = getConnection();
		ProductDao productDao = ProductDao.getInstance();
		productDao.setConnection(conn);
		pdtInfo = productDao.getPdtInfo(piid);
		close(conn);
			
		return pdtInfo;
	}
	
	public ArrayList<PdtCata> getCataList(){
			ArrayList<PdtCata> cataList = new ArrayList<PdtCata>();
			Connection conn = getConnection();
			ProductDao productDao = ProductDao.getInstance();
			productDao.setConnection(conn);
			cataList = productDao.getCataList();
				
			close(conn);
			
			return cataList;
		}	

// 후기정보----------------------------------------------------------------------------------
	
	public int getReviewCount(String piid) {
		// 후기에서 사용할 전체 개시글 개수를 리턴하는 메소드
			int rrcnt = 0;	// 전체 게시글 개수를 저장할 변수이자 리턴할 값
			Connection conn = getConnection();
			ProductDao productDao = ProductDao.getInstance();
			productDao.setConnection(conn);
			rrcnt = productDao.getReviewCount(piid);
			close(conn);
			
			return rrcnt;
		}
		
		public ArrayList<ReviewList> getReviewList(String piid, int cpage, int psize){
		// 목록화면에서 보여줄 게시글 목록을 ReviewList형 인스턴스만 저장할수 있는 ArrayList로 리턴하는 메소드
			ArrayList<ReviewList> reviewList = null;
			// 게시글 목록을 저장할 ArrayList로 ReviewList형 인스턴스만 저장함
			Connection conn = getConnection();
			ProductDao productDao = ProductDao.getInstance();
			productDao.setConnection(conn);
			reviewList = productDao.getReviewList(piid, cpage, psize);
			close(conn);
			
			return reviewList;
		}
}
