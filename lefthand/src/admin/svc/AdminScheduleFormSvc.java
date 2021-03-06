package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminScheduleFormSvc {
	public AdminSchedule getMemberSchedule(String aiid, int as_idx) {
		Connection conn = getConnection();												// jdbcUtil에 있는 메소드 getConnection()
		AdminScheduleDao adminScheduleDao = AdminScheduleDao.getInstance();				// getInstance()는 LoginDao의 public static 메소드임	
		adminScheduleDao.setConnection(conn);											// Connection 연결
	
		AdminSchedule as = adminScheduleDao.getMemberSchedule(aiid, as_idx);
		
		
		close(conn);

		return as;
	}	
}
