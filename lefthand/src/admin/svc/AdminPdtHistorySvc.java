package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminPdtHistorySvc {
	public ArrayList<ProductHistory> getPdtHistoryList(String piid){
		ArrayList<ProductHistory> productHistory = null;
		Connection conn = getConnection();
		AdminPdtHistoryDao adminPdtHistoryDao = AdminPdtHistoryDao.getInstance();
		adminPdtHistoryDao.setConnection(conn);
		productHistory = adminPdtHistoryDao.getPdtHistoryList(piid);
		close(conn);
		
		return productHistory;
	}
}
