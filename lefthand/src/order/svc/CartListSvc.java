package order.svc;

import static order.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import order.dao.*;
import vo.*;
public class CartListSvc {
	public ArrayList<CartInfo> getCartList(String where) {
		Connection conn = getConnection();			// jdbcUtil에 있는 메소드 getConnection()
		OrderDao orderDao = OrderDao.getInstance();	// getInstance()는 LoginDao의 public static 메소드임	
		orderDao.setConnection(conn);							// Connection 연결
		ArrayList<CartInfo> cartList = orderDao.getCartList(where);
		
		close(conn);

		return cartList;
	}
}
