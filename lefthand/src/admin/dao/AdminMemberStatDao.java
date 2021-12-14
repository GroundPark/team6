package admin.dao;

import static main.db.JdbcUtil.*;	
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class AdminMemberStatDao {
	private static AdminMemberStatDao adminMemberStatDao;
	private Connection conn;
	
	private AdminMemberStatDao() {}
	// 외부에서는 함부로 인스턴스를 생성하지 못하게 private으로 생성자를 선언함
		
	public static AdminMemberStatDao getInstance() {
	// 싱글톤 방식으로 인스턴스 낭비를 줄임 
		if (adminMemberStatDao == null)	adminMemberStatDao = new AdminMemberStatDao();
		// 기존의 인스턴스가 살아있으면 새롭게 만들지 않고, 없을 경우에만 새로 생성하게 함 
		return adminMemberStatDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public AdminMemStatsInfo getMemStatsData()  {
	// 회원별 통계에서 사용 할 데이터를 저장하는 메소드
		Statement stmt = null;	
		ResultSet rs = null;
		AdminMemStatsInfo mstat = new AdminMemStatsInfo();	
		
		try {
			stmt = conn.createStatement();	
			
			String sql = "select count(*) from v_mem_stat_info"; 
			rs = stmt.executeQuery(sql);
			rs.next();
			mstat.setP_acount(rs.getInt(1));
			
			sql = "select count(*) from v_mem_stat_info where mi_hand='l'";
			rs = stmt.executeQuery(sql);
			rs.next();
			mstat.setP_lcount(rs.getInt(1));
			
			sql = "select count(*) from v_mem_stat_info where mi_hand='r'";
			rs = stmt.executeQuery(sql);
			rs.next();
			mstat.setP_rcount(rs.getInt(1));
			
			sql = "select count(*) from v_mem_stat_info where mi_hand='b'";
			rs = stmt.executeQuery(sql);
			rs.next();
			mstat.setP_bcount(rs.getInt(1));
			
			
			sql = "select count(*) from v_mem_stat_info2";
			rs = stmt.executeQuery(sql);
			rs.next();
			mstat.setF_acount(rs.getInt(1));
			
			sql = "select count(*) from v_mem_stat_info2 where mi_hand='l'";
			rs = stmt.executeQuery(sql);
			rs.next();
			mstat.setF_lcount(rs.getInt(1));
			
			sql = "select count(*) from v_mem_stat_info2 where mi_hand='r'";
			rs = stmt.executeQuery(sql);
			rs.next();
			mstat.setF_rcount(rs.getInt(1));
			
			sql = "select count(*) from v_mem_stat_info2 where mi_hand='b'";
			rs = stmt.executeQuery(sql);
			rs.next();
			mstat.setF_bcount(rs.getInt(1)); 
					
		} catch (Exception e) {
			System.out.println("AdminMemberStatDao 클래스의 getMemStatsData() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);	
		}		
		return mstat;
	}

}
