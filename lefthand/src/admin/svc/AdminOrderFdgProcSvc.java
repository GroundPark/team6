package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminOrderFdgProcSvc {
	public int orderFdgUpdate(FdgOrderInfo ord, int aiidx) {
		Connection conn = getConnection();			
		AdminOrderFdgDao adminOrderFdgDao = AdminOrderFdgDao.getInstance();	
		adminOrderFdgDao.setConnection(conn);
		
		int result = adminOrderFdgDao.orderFdgUpdate(ord, aiidx);
		
		if (result >= 1)	commit(conn);	
		else				rollback(conn);	

		close(conn);

		return result;
	}
}
