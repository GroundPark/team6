package product.svc;

import static product.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import product.dao.*;
import vo.*;

public class PdtListSvc {
	public int getPdtCount(String where) {
		int rcnt = 0;		
		
		Connection conn = getConnection();
		ProductDao productDao = ProductDao.getInstance();
		productDao.setConnection(conn);
		rcnt = productDao.getPdtCount(where);
			
		close(conn);
		
		return rcnt;
	}
	
	public ArrayList<ProductInfo> getPdtList(String where, String order, int cpage, int psize){
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();
		Connection conn = getConnection();
		ProductDao productDao = ProductDao.getInstance();
		productDao.setConnection(conn);
		pdtList = productDao.getPdtList(where, order, cpage, psize);
			
		close(conn);
		
		return pdtList;
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
	
	
}