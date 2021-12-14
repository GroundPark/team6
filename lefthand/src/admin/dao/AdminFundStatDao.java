package admin.dao;

import static main.db.JdbcUtil.*;	
import java.util.*;
import javax.sql.*;
import java.sql.*;
import admin.act.*;
import vo.*;

public class AdminFundStatDao {
	private static AdminFundStatDao adminFundStatDao;
	private Connection conn;
	
	private AdminFundStatDao() {}
	// 외부에서는 함부로 인스턴스를 생성하지 못하게 private으로 생성자를 선언함
		
	public static AdminFundStatDao getInstance() {
	// 싱글톤 방식으로 인스턴스 낭비를 줄임 
		if (adminFundStatDao == null)	adminFundStatDao = new AdminFundStatDao();
		// 기존의 인스턴스가 살아있으면 새롭게 만들지 않고, 없을 경우에만 새로 생성하게 함 
		return adminFundStatDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	

	
	public AdminFundStatsInfo getFundStatsData() {
	// 기간별 통계에서 사용 할 데이터를 저장하는 메소드
		Statement stmt = null;	
		ResultSet rs = null;
		AdminFundStatsInfo fstat = new AdminFundStatsInfo();
		
		try {
			stmt = conn.createStatement();			
			String sql = "select ci_step, ci_status, count(*) c from t_challenge_info group by ci_step, ci_status";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {

				switch (rs.getInt(1)) {				
				case 1 :				
					switch (rs.getString(2)) {
					case "a" :
						fstat.setS1ac(rs.getInt(3));
					break;
					case "b" :
						fstat.setS1bc(rs.getInt(3));
					break;
					}
				break;
				
				case 2 : 
					switch (rs.getString(2)) {
					case "a" :
						fstat.setS2ac(rs.getInt(3));
					break;
					case "b" :
						fstat.setS2bc(rs.getInt(3));
					break;
					case "c" :
						fstat.setS2cc(rs.getInt(3));
					break;
					}
					
				break;
				}
			}
			
		} catch (Exception e) {
			System.out.println("AdminPeriodStatDao 클래스의 getPeriodStatsData() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);	
		}		
		return fstat;
	}
}
