package member.svc;

import static member.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import member.dao.*;
import member.vo.*;

public class LoginSvc {
	public MemberInfo getLoginMember(String uid, String pwd) {
		Connection conn = getConnection();				// jdbcUtil�� �ִ� �޼ҵ� getConnection()
		LoginDao loginDao = LoginDao.getInstance();		// getInstance()�� LoginDao�� public static �޼ҵ���	
		loginDao.setConnection(conn);					// Connection ����
		MemberInfo memberInfo = loginDao.getLoginMember(uid, pwd);

		close(conn);

		return memberInfo;
	}
}