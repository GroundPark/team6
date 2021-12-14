package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminOrderPdtViewSvc {
	public OrderInfo getOrderInfo(String miid, String poiid) {
		OrderInfo orderInfo = new OrderInfo();
		Connection conn = getConnection();
		AdminOrderPdtDao adminOrderPdtDao = AdminOrderPdtDao.getInstance();
		adminOrderPdtDao.setConnection(conn);
		orderInfo = adminOrderPdtDao.getOrderInfo(miid, poiid);
		close(conn);
			
		return orderInfo;
	}
}
