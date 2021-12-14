package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminOrderPdtProcSvc {
	public int orderPdtUpdate(OrderInfo ord, int aiidx) {
		Connection conn = getConnection();			
		AdminOrderPdtDao adminOrderPdtDao = AdminOrderPdtDao.getInstance();	
		adminOrderPdtDao.setConnection(conn);
		
		int result = adminOrderPdtDao.orderPdtUpdate(ord, aiidx);
		
		if (result >= 1)	commit(conn);	
		else				rollback(conn);	

		close(conn);

		return result;
	}
}
