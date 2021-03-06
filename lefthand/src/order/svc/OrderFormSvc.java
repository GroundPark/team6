package order.svc;

import static order.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import order.dao.*;
import vo.*;

public class OrderFormSvc {
	public ArrayList<CartInfo> getOrderPdtList(String where) {
		Connection conn = getConnection();			// jdbcUtil에 있는 메소드 getConnection()
		OrderDao orderDao = OrderDao.getInstance();	// getInstance()는 LoginDao의 public static 메소드임	
		orderDao.setConnection(conn);				// Connection 연결
		ArrayList<CartInfo> orderPdtList = orderDao.getCartList(where);
		
		close(conn);

		return orderPdtList;
	}
	
	public ArrayList<CartInfo> getDirectOrderPdtList(String piid, int poccnt, String miid) {
		Connection conn = getConnection();			// jdbcUtil에 있는 메소드 getConnection()
		OrderDao orderDao = OrderDao.getInstance();	// getInstance()는 LoginDao의 public static 메소드임	
		orderDao.setConnection(conn);				// Connection 연결
		ArrayList<CartInfo> orderPdtList = orderDao.getDirectOrderPdtList(piid, poccnt, miid);
		
		close(conn);

		return orderPdtList;
	}
	
	public ArrayList<MemberAddr> getAddrList(String uid) {
		Connection conn = getConnection();			
		OrderDao orderDao = OrderDao.getInstance();	
		orderDao.setConnection(conn);			
		ArrayList<MemberAddr> addrList = orderDao.getAddrList(uid);
		
		close(conn);

		return addrList;
	}
}
