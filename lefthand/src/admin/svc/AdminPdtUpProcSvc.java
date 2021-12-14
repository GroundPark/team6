package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminPdtUpProcSvc {
	public int adminPdtUpdate(ProductInfo pdt) {
		int result = 0;
		Connection conn = getConnection();
		AdminPdtUpProcDao adminPdtUpProcDao = AdminPdtUpProcDao.getInstance();
		adminPdtUpProcDao.setConnection(conn);
		result = adminPdtUpProcDao.adminPdtUpdate(pdt);
		
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		return result;
	}
}
