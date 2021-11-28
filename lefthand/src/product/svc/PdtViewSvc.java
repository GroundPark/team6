package product.svc;

import static product.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import product.dao.*;
import product.vo.*;

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
	
	public ReviewInfo getRevInfo(String miid, String piid){
		ReviewInfo revInfo = new ReviewInfo();
		Connection conn = getConnection();
		ProductDao productDao = ProductDao.getInstance();
		productDao.setConnection(conn);
		revInfo = productDao.getRevInfo(miid, piid);
		close(conn);
			
		return revInfo;
	}
}
