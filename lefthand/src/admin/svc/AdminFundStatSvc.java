package admin.svc;

import static main.db.JdbcUtil.*;
import java.sql.*;
import admin.dao.*;
import vo.*;


public class AdminFundStatSvc {
	public AdminFundStatsInfo getFundStatsData() {
		AdminFundStatsInfo fstat = new AdminFundStatsInfo();
		// 펀딩별 통계 관련 정보를 담아 올 인스턴스 생성
		
		Connection conn = getConnection();
		
		AdminFundStatDao fundStatsDao = AdminFundStatDao.getInstance();
		
		fundStatsDao.setConnection(conn);
		
		fstat = fundStatsDao.getFundStatsData();
		 	
		close(conn);
		
		return fstat;
	}
}