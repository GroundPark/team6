package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminOrderFdgViewSvc {
	public FdgOrderInfo getFdgOrderInfo(String miid, String foiid) {
		FdgOrderInfo fdgOrderInfo = new FdgOrderInfo();
		Connection conn = getConnection();
		AdminOrderFdgDao adminOrderFdgDao = AdminOrderFdgDao.getInstance();
		adminOrderFdgDao.setConnection(conn);
		fdgOrderInfo = adminOrderFdgDao.getFdgOrderInfo(miid, foiid);
		close(conn);
			
		return fdgOrderInfo;
	}
}
