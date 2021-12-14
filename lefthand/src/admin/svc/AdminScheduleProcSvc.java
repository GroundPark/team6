package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminScheduleProcSvc {
	public int scheduleProc(String wtype, AdminSchedule as) {
		Connection conn = getConnection();											// jdbcUtil에 있는 메소드 getConnection()
		AdminScheduleDao adminScheduleDao = AdminScheduleDao.getInstance();			// getInstance()는 LoginDao의 public static 메소드임
		adminScheduleDao.setConnection(conn);										// Connection 연결
	
		int result = adminScheduleDao.scheduleProc(wtype, as);
		
		if (result >= 1)	commit(conn);											// 업데이트만 여러번 일어남. 생각 잘 해야함 (result == 1 하면 안됨)
		else 				rollback(conn);											// 작업이 일어난 레코드가 없으면 쿼리 적용을 취소하고 처음으로 되돌림
		close(conn);

		return result;
	}	
}
