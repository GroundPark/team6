package admin.svc;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminLoginSvc {
	public AdminInfo getLoginAdmin(String uid, String pwd) {
		Connection conn = getConnection();				// jdbcUtil에 있는 메소드 getConnection()
		AdminLoginDao adminLoginDao = AdminLoginDao.getInstance();		// getInstance()는 LoginDao의 public static 메소드임	
		adminLoginDao.setConnection(conn);					// Connection 연결
		AdminInfo adminInfo = adminLoginDao.getLoginAdmin(uid, pwd);

		close(conn);

		return adminInfo;
	}

}
