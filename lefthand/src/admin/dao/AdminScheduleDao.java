package admin.dao;

import static admin.db.JdbcUtil.*;	
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class AdminScheduleDao {
	// 게시판 및 일정관리에 대한 DB관련 작업을 처리하는 클래스
	private static AdminScheduleDao adminScheduleDao;
	private Connection conn;
	
	private AdminScheduleDao() {}
	// 외부에서는 함부로 인스턴스를 생성하지 못하게 private으로 생성자를 선언함
		
	public static AdminScheduleDao getInstance() {
	// 싱글톤 방식으로 인스턴스 낭비를 줄임 
		if (adminScheduleDao == null)	adminScheduleDao = new AdminScheduleDao();
		// 기존의 인스턴스가 살아있으면 새롭게 만들지 않고, 없을 경우에만 새로 생성하게 함 
		return adminScheduleDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	
	public ArrayList<AdminSchedule> getScheduleList(String aiid, int year, int month) {		
	// 지정된 연월에 해당하는 일정들의 목록을 추출하여 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<AdminSchedule> scheduleList = new ArrayList<AdminSchedule>();
		AdminSchedule as = null;
		
		try {
			stmt = conn.createStatement();
			
			String stime = year + "-" + (month < 10 ? "0" + month : month);		// 이런거 잘 생각해야 함
			// as_stime이 char(16)이라 int인 year과 month를 사용하면 안됨. 만들어서 넣어야 함
			
			String sql = "select * from t_admin_schedule where ai_id = '" + aiid + "' and as_stime like '" + stime + "%' "
					+ " order by as_stime";
			// 여러줄의 레코드를 뽑아올 때 반드시 가져오는 순서를 생각해야 함. 기본값은 PK순임 // order by as_stime을 줌으로써 일정 순서대로 뽑아옴
			// 사실 where절은 매개변수를 여기까지 가져와서 여기서 만들지 않아도 act에서 만들어서 가져올 수도 있음. 허나 무조건 act에서 만들 수 있는건 아님 매개변수를 여기서도 쓸 상황이 있을 수 있기 때문
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {						// if - do-while을 안써도 되는 이유는 rs에 값이 없으면 ArrayList의 size는 0으로 비어있다는걸 알 수 있기 때문
				as = new AdminSchedule();

				as.setAs_idx(rs.getInt("as_idx"));					as.setAi_id(aiid);
				as.setAs_stime(rs.getString("as_stime"));			as.setAs_content(rs.getString("as_content"));
				as.setAs_date(rs.getString("as_date"));
				
				scheduleList.add(as);
			}
			
		} catch(Exception e) {
			System.out.println("AdminScheduleDao 클래스의 getScheduleList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs); close(stmt);
		}
		
		return scheduleList;

	}
	
	
	public AdminSchedule getMemberSchedule(String aiid, int as_idx) {
	// 하나의 일정에 대한 정보를 AdminSchedule형 인스턴스로 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		AdminSchedule as = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from t_admin_schedule where ai_id = '" + aiid + "' and as_idx = " + as_idx;
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {  // rs에 담긴건 무조건 하나이므로 데이터가 있는지 검사만 하고 반복문 없이 바로 담음
				as = new AdminSchedule();

				as.setAi_id(aiid);								as.setAs_idx(as_idx);
				as.setAs_content(rs.getString("as_content"));	as.setAs_date(rs.getString("as_date"));
				as.setAs_stime(rs.getString("as_stime"));
			}
			
		} catch(Exception e) {
			System.out.println("AdminScheduleDao 클래스의 getMemberSchedule() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs); close(stmt);
		}
		
		return as;
		
	}
	

	public int scheduleProc(String wtype, AdminSchedule as) {
	// 일정관리의 일정을 등록, 수정, 삭제시키는 메소드
		Statement stmt = null;
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "";
			if (wtype.equals("in")) {			// 일정 등록일 경우
				sql = "insert into t_admin_schedule (ai_id, as_stime, as_content, as_title) values ('" + 
						as.getAi_id() + "', '" + as.getAs_stime() + "', '" + as.getAs_content() + "', 'title' )";
			} else if (wtype.equals("up")) {	// 일정 수정일 경우
				sql = "update t_admin_schedule set as_stime = '" + as.getAs_stime() + 
		                  "', as_content = '" + as.getAs_content() + "' where ai_id = '" + as.getAi_id() + 
		                  "' and as_idx = '" + as.getAs_idx() + "'";
			} else if (wtype.equals("del")) {	// 일정 삭제일 경우
				sql = "delete from t_admin_schedule where ai_id = '" + as.getAi_id() + "' and as_idx = " + as.getAs_idx();
			}
			result = stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			System.out.println("AdminScheduleDao 클래스의 scheduleProc() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}
	
}
