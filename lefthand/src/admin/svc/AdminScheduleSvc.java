package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminScheduleSvc {
	public ArrayList<AdminSchedule> getScheduleList(String aiid, int year, int month) {
		Connection conn = getConnection();
		AdminScheduleDao adminScheduleDao = AdminScheduleDao.getInstance();	// 싱글턴 방식
		adminScheduleDao.setConnection(conn);
		
		ArrayList<AdminSchedule> scheduleList = adminScheduleDao.getScheduleList(aiid, year, month);
		
		close(conn);
		
		return scheduleList;
	}

}
