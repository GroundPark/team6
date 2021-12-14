package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminOrderPdtListSvc {
	public int getOrderPdtCount(String where) {
		int rcnt = 0;	
		Connection conn = getConnection();
		AdminOrderPdtDao adminOrderPdtDao = AdminOrderPdtDao.getInstance();
		adminOrderPdtDao.setConnection(conn);
		rcnt = adminOrderPdtDao.getOrderPdtCount(where);
		close(conn);
		
		return rcnt;
	}
	
	public ArrayList<OrderInfo> getOrderPdtList(String where, String order, int cpage, int psize){
		ArrayList<OrderInfo> orderList = null;
		Connection conn = getConnection();
		AdminOrderPdtDao adminOrderPdtDao = AdminOrderPdtDao.getInstance();
		adminOrderPdtDao.setConnection(conn);
		orderList = adminOrderPdtDao.getOrderPdtList(where, order,cpage, psize);
		close(conn);
		
		return orderList;
	}
}
