﻿package admin.svc;

import static main.db.JdbcUtil.*;
import java.sql.*;
import admin.dao.AdminMemberStatDao;
import vo.*;

public class AdminMemberStatSvc {
	public AdminMemStatsInfo getMemStatsData() {
		AdminMemStatsInfo mstat = new AdminMemStatsInfo();
		// 회원별 통계 관련 정보를 담아 올 인스턴스 생성
		
		Connection conn = getConnection();
		
		AdminMemberStatDao memStatsDao = AdminMemberStatDao.getInstance();
		
		memStatsDao.setConnection(conn);
		
		mstat = memStatsDao.getMemStatsData();
		 	
		close(conn);
		
		return mstat;
	}
}