package member.db;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class JdbcUtil {
// DB 관련 연결 및 공통 메소드들을 정의한 클래스 - 모든 메소드는 public(어디서든) static(인스턴스 생성 없이)으로 선언됨 : 쓰기 편하라고
	public static Connection getConnection() {
	// DB에 연결하여 Connection 객체를 리턴하는 메소드
		Connection conn = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MYSQLDB");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			// 쿼리가 자동으로 commit 되는 것을 막기 위해 트랜잭션을 시작시킴
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {	// 오버로딩으로, Connection 객체를 닫아 DB와의 연결을 끊어주는 메소드
		try { conn.close(); }	catch (Exception e) { e.printStackTrace(); }
	}
	
	public static void close(Statement stmt) {	// Statement 객체를 닫는 메소드
	// PreparedStatement와 CallabledStatement는 Statement를 상속받으므로 따로 close() 메소드를 만들지 않아도 됨
		try { stmt.close(); }	catch (Exception e) { e.printStackTrace(); }
	}
	
	public static void close(ResultSet rs) {	// ResultSet 객체를 닫는 메소드
		try { rs.close(); }	catch (Exception e) { e.printStackTrace(); }
	}
	
	public static void commit(Connection conn) {	// transaction을 commit 시키는 메소드
		try {
			conn.commit();
			System.out.println("쿼리 성공");
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}
	public static void rollback(Connection conn) {	// transaction을 rollback 시키는 메소드
		try {
			conn.commit();
			System.out.println("쿼리 실패");
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}
}
