package admin.svc;

import static admin.db.JdbcUtil.*;	
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminPdtInProcSvc {
	public int adminPdtInsert(ProductInfo pdt) {
		int result = 0;
		Connection conn = getConnection();
		AdminPdtInProcDao adminPdtInProcDao = AdminPdtInProcDao.getInstance();
		adminPdtInProcDao.setConnection(conn);
		result = adminPdtInProcDao.adminPdtInsert(pdt);
		
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		return result;
	}
}
