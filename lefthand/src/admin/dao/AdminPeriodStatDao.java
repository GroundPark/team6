package admin.dao;

import static main.db.JdbcUtil.*;	
import java.util.*;
import javax.sql.*;
import java.sql.*;
import admin.act.*;
import vo.*;

public class AdminPeriodStatDao {
	private static AdminPeriodStatDao adminPeriodStatDao;
	private Connection conn;
	
	private AdminPeriodStatDao() {}
	// 외부에서는 함부로 인스턴스를 생성하지 못하게 private으로 생성자를 선언함
		
	public static AdminPeriodStatDao getInstance() {
	// 싱글톤 방식으로 인스턴스 낭비를 줄임 
		if (adminPeriodStatDao == null)	adminPeriodStatDao = new AdminPeriodStatDao();
		// 기존의 인스턴스가 살아있으면 새롭게 만들지 않고, 없을 경우에만 새로 생성하게 함 
		return adminPeriodStatDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	
	
	public AdminPeriodStatsInfo getPeriodStatsData() {
	// 기간별 통계에서 사용 할 데이터를 저장하는 메소드
		Statement stmt = null;	
		ResultSet rs = null;
		AdminPeriodStatsInfo pstat = new AdminPeriodStatsInfo();
		
		try {
			stmt = conn.createStatement();			
			String sql = "select month(poi_date) m, count(*) c from t_product_order_info where year(poi_date) = 2021 group by month(poi_date)";
			// 21년도 데이터만 받아옴
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {

				switch (rs.getInt(1)) {				
				case 1 :				
					pstat.setM1(rs.getInt(2));
					break;
				case 2 :				
					pstat.setM2(rs.getInt(2));
					break;
				case 3 :				
					pstat.setM3(rs.getInt(2));
					break;
				case 4 :				
					pstat.setM4(rs.getInt(2));
					break;
				case 5 :				
					pstat.setM5(rs.getInt(2));
					break;
				case 6 :				
					pstat.setM6(rs.getInt(2));
					break;
				case 7 :				
					pstat.setM7(rs.getInt(2));
					break;
				case 8 :				
					pstat.setM8(rs.getInt(2));
					break;
				case 9 :				
					pstat.setM9(rs.getInt(2));
					break;
				case 10 :				
					pstat.setM10(rs.getInt(2));
					break;
				case 11 :				
					pstat.setM11(rs.getInt(2));
					break;
				case 12 :				
					pstat.setM12(rs.getInt(2));
					break;
				}
			}
			
		} catch (Exception e) {
			System.out.println("AdminPeriodStatDao 클래스의 getPeriodStatsData() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);	
		}		
		return pstat;
	}

}
