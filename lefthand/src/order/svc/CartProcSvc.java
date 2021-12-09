package order.svc;

import static order.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import order.dao.*;
import vo.*;

public class CartProcSvc {
	public int cartProc(String wtype, CartInfo cart, String where) {
		Connection conn = getConnection();			// jdbcUtil에 있는 메소드 getConnection()
		OrderDao orderDao = OrderDao.getInstance();	// getInstance()는 LoginDao의 public static 메소드임	
		orderDao.setConnection(conn);				// Connection 연결
		int result = 0;		
		
		if (wtype.equals("in")) {	// 특정 상품(cart)을 장바구나에 담기를 할 경우
			result = orderDao.cartInsert(cart);
		} else if (wtype.equals("up")) { // 특정 상품(cart)을 수정할 경우
			result = orderDao.cartUpdateCount(cart, where);		
		} else if (wtype.equals("del")) {	// 특정 상품(cart)을 삭제할 경우
			result = orderDao.cartDelete(cart, where);			
		}
		
		// 트랜잭션 : 우리가 JdbcUtil에서 만들어놨어
		if (result >= 1)	commit(conn);	// 등록, 수정, 삭제 등의 작업이 일어난 레코드가 하나면 쿼리를 적용시킴
		else				rollback(conn);	// 작업이 일어난 레코드가 없으면 쿼리 적용을 취소하고 처음으로 되돌림

		close(conn);

		return result;
	}
}