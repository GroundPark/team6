package admin.svc;

import static main.db.JdbcUtil.*;
import java.sql.*;
import admin.dao.AdminMemberStatDao;
import vo.*;

public class AdminMemberStatSvc {
	public AdminMemStatsInfo getMemStatsData() {
		AdminMemStatsInfo mstat = new AdminMemStatsInfo();
		// ȸ���� ��� ���� ������ ��� �� �ν��Ͻ� ����
		
		Connection conn = getConnection();
		
		AdminMemberStatDao memStatsDao = AdminMemberStatDao.getInstance();
		
		memStatsDao.setConnection(conn);
		
		mstat = memStatsDao.getMemStatsData();
		 	
		close(conn);
		
		return mstat;
	}
}