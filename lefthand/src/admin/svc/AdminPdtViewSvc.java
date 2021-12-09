package admin.svc;

import static admin.db.JdbcUtil.*;
import static product.db.JdbcUtil.close;
import static product.db.JdbcUtil.getConnection;

import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminPdtViewSvc {
	public ProductInfo getPdtInfo(String piid){
		ProductInfo pdtInfo = new ProductInfo();
		Connection conn = getConnection();
		AdminPdtViewDao adminPdtViewDao = AdminPdtViewDao.getInstance();
		adminPdtViewDao.setConnection(conn);
		pdtInfo = adminPdtViewDao.getPdtInfo(piid);
		close(conn);
			
		return pdtInfo;
	}
	
/*	public ArrayList<PdtCata> getCataList(){
			ArrayList<PdtCata> cataList = new ArrayList<PdtCata>();
			Connection conn = getConnection();
			AdminPdtViewDao adminPdtViewDao = AdminPdtViewDao.getInstance();
			adminPdtViewDao.setConnection(conn);
			cataList = adminPdtViewDao.getCataList();
				
			close(conn);
			
			return cataList;
		}*/
}
