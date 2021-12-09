package order.svc;

import static order.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import order.dao.*;
import vo.*;

public class OrderProcSvc {
	public String orderInsert(OrderInfo ord, String where) {
		Connection conn = getConnection();			// jdbcUtil에 있는 메소드 getConnection()
		OrderDao orderDao = OrderDao.getInstance();	// getInstance()는 LoginDao의 public static 메소드임	
		orderDao.setConnection(conn);				// Connection 연결
		
		String result = orderDao.orderInsert(ord, where);	
		
		if (Integer.parseInt(result.substring(13)) >= 1)	commit(conn);	// 인서트와 동시에 업데이트 할 쿼리 문이 많으므로
		else				rollback(conn);	// 작업이 일어난 레코드가 없으면 쿼리 적용을 취소하고 처음으로 되돌림

		close(conn);

		return result;
	}

}
