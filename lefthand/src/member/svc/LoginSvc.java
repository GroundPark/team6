package member.svc;

import static member.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import member.dao.*;
import vo.*;

public class LoginSvc {
	public MemberInfo getLoginMember(String uid, String pwd) {
		Connection conn = getConnection();				// jdbcUtil에 있는 메소드 getConnection()
		LoginDao loginDao = LoginDao.getInstance();		// getInstance()는 LoginDao의 public static 메소드임	
		loginDao.setConnection(conn);					// Connection 연결
		MemberInfo memberInfo = loginDao.getLoginMember(uid, pwd);

		close(conn);

		return memberInfo;
	}
}
