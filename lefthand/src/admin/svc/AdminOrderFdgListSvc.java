package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminOrderFdgListSvc {
	public int getOrderFdgCount(String where) {
		int rcnt = 0;	
		Connection conn = getConnection();
		AdminOrderFdgDao adminOrderFdgDao = AdminOrderFdgDao.getInstance();
		adminOrderFdgDao.setConnection(conn);
		rcnt = adminOrderFdgDao.getOrderFdgCount(where);
		close(conn);
		
		return rcnt;
	}
	
	public ArrayList<FdgOrderInfo> getOrderFdgList(String where, String order, int cpage, int psize){
		ArrayList<FdgOrderInfo> fdgOrderList = null;
		Connection conn = getConnection();
		AdminOrderFdgDao adminOrderFdgDao = AdminOrderFdgDao.getInstance();
		adminOrderFdgDao.setConnection(conn);
		fdgOrderList = adminOrderFdgDao.getOrderFdgList(where, order,cpage, psize);
		close(conn);
		
		return fdgOrderList;
	}
}
