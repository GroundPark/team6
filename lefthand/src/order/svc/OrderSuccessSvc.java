package order.svc;

import static order.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import order.dao.*;
import vo.*;

public class OrderSuccessSvc {
	public OrderInfo getOrderInfo(String miid, String poiid) {
		Connection conn = getConnection();			// jdbcUtil에 있는 메소드 getConnection()
		OrderDao orderDao = OrderDao.getInstance();	// getInstance()는 LoginDao의 public static 메소드임	
		orderDao.setConnection(conn);				// Connection 연결
		OrderInfo ord = orderDao.getOrderInfo(miid, poiid);
		
		close(conn);

		return ord;
	}
	
	public FdgOrderInfo getFdgOrderInfo(String miid, String foiid) {
		Connection conn = getConnection();			// jdbcUtil에 있는 메소드 getConnection()
		OrderDao orderDao = OrderDao.getInstance();	// getInstance()는 LoginDao의 public static 메소드임	
		orderDao.setConnection(conn);				// Connection 연결
		FdgOrderInfo fdgOrd = orderDao.getFdgOrderInfo(miid, foiid);
		
		close(conn);

		return fdgOrd;
	}
}
