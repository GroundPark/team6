package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminPdtListSvc {
	public int getPdtCount(String where) {
		int rcnt = 0;	
		Connection conn = getConnection();
		AdminPdtListDao adminPdtListDao = AdminPdtListDao.getInstance();
		adminPdtListDao.setConnection(conn);
		rcnt = adminPdtListDao.getPdtCount(where);
		close(conn);
		
		return rcnt;
	}
	
	public ArrayList<ProductInfo> getPdtList(String where, String order, int cpage, int psize){
		ArrayList<ProductInfo> pdtList = null;
		Connection conn = getConnection();
		AdminPdtListDao adminPdtListDao = AdminPdtListDao.getInstance();
		adminPdtListDao.setConnection(conn);
		pdtList = adminPdtListDao.getPdtList(where, order,cpage, psize);
		close(conn);
		
		return pdtList;
	}
	
	public ArrayList<PdtCata> getCataList(){
		ArrayList<PdtCata> cataList = new ArrayList<PdtCata>();
		Connection conn = getConnection();
		AdminPdtListDao adminPdtListDao = AdminPdtListDao.getInstance();
		adminPdtListDao.setConnection(conn);
		cataList = adminPdtListDao.getCataList();
			
		close(conn);
		
		return cataList;
	}
}
