package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class AdminLoginDao {
	private static AdminLoginDao loginDao;
	private Connection conn;

	private AdminLoginDao() {}

	public static AdminLoginDao getInstance() {
		if (loginDao == null)	loginDao = new AdminLoginDao();
		return loginDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public AdminInfo getLoginAdmin(String uid, String pwd) {
		// 지정한 아이디(uid)와 암호(pwd)로 로그인 작업을 처리한 후 회원정보를 MemberInfo형 인스턴스에 담아 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		AdminInfo adminInfo = null;	// 데이터가 없을 경우 null을 리턴하게 함

		try {
			stmt = conn.createStatement();
			String sql = "select * from t_admin_info where ai_id = '" + uid + "' and ai_pw ='" + pwd + "' and ai_isact = 'y' ";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				adminInfo = new AdminInfo();	// rs에 담긴 데이터들을 저장할 인스턴스 생성
				adminInfo.setAi_date(rs.getString("ai_date"));
				adminInfo.setAi_email(rs.getString("ai_email"));
				adminInfo.setAi_id(rs.getString("ai_id"));
				adminInfo.setAi_idx(rs.getInt("ai_idx"));
				adminInfo.setAi_isact(rs.getString("ai_isact"));
				adminInfo.setAi_name(rs.getString("ai_name"));
				adminInfo.setAi_phone(rs.getString("ai_phone"));
				adminInfo.setAi_pw(rs.getString("ai_pw"));
				adminInfo.setAi_tel(rs.getString("ai_tel"));
				adminInfo.setApi_id(rs.getString("api_id"));				
			}	// rs가 비었으면 else 없이 그냥 memberInfo에 null이 들어있는 상태로 리턴함

		} catch(Exception e) {
			System.out.println("LoginDao 클래스의 getLoginMember() 메소드 오류");
			e.printStackTrace();
		}

		return adminInfo;
	}

}
