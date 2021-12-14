package admin.svc;

import static main.db.JdbcUtil.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminPeriodStatSvc {
	public AdminPeriodStatsInfo getPeriodStatsData() {
		AdminPeriodStatsInfo pstat = new AdminPeriodStatsInfo();
		// 기간별 통계 관련 정보를 담아 올 인스턴스 생성
		
		Connection conn = getConnection();
		
		AdminPeriodStatDao periodStatsDao = AdminPeriodStatDao.getInstance();
		
		periodStatsDao.setConnection(conn);
		
		pstat = periodStatsDao.getPeriodStatsData();
		 	
		close(conn);
		
		return pstat;
	}
}