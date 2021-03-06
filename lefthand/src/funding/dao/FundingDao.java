package funding.dao;

import static funding.db.JdbcUtil.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class FundingDao {
	private static FundingDao fundingDao;
	private Connection conn;

	private FundingDao() {}

	public static FundingDao getInstance() {
		if (fundingDao == null)	fundingDao = new FundingDao();
		return fundingDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int getFdgCount(String where) {
	// 펀딩의 전체 개수를 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;

		try {
			String sql = "select count(*) from t_funding_info " + where;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			rcnt = rs.getInt(1);
		} catch(Exception e) {
			System.out.println("FundingDao 클래스의 getFdgCount() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return rcnt;
	}

	public ArrayList<FundingInfo> getFdgList(String where, String order, int cpage, int psize) {
	// 펀딩 목록을 ArrayList<FundingInfo>에 담아 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<FundingInfo> fdgList = new ArrayList<FundingInfo>();
		// 펀딩목록을 저장할 ArrayList로 오직 FundingInfo형 인스턴스만 저장할 수 있음
		FundingInfo fdg = null;
		// fdgList에 저장할 FundingInfo형 인스턴스

		try {
			String sql = "select * from t_funding_info " + where + order + " limit " + ((cpage - 1) * psize) + ", " + psize;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				fdg = new FundingInfo();
				// fdgList에 저장할 하나의 상품 정보를 담을 인스턴스 생성

				fdg.setFi_idx(rs.getInt("fi_idx"));				fdg.setFi_id(rs.getString("fi_id"));
				fdg.setFi_name(rs.getString("fi_name"));		fdg.setFi_img1(rs.getString("fi_img1"));		
				fdg.setFi_img2(rs.getString("fi_img2"));		fdg.setFi_img3(rs.getString("fi_img3"));
				fdg.setFi_desc(rs.getString("fi_desc"));		fdg.setFi_price(rs.getInt("fi_price"));	
				fdg.setFi_ordercnt(rs.getInt("fi_ordercnt"));	fdg.setFi_goal(rs.getInt("fi_goal"));	
				fdg.setFi_rate(rs.getFloat("fi_rate"));			fdg.setFi_support(rs.getInt("fi_support"));
				fdg.setFi_total(rs.getInt("fi_total"));			fdg.setFi_good(rs.getInt("fi_good"));
				fdg.setFi_sdate(rs.getString("fi_sdate"));		fdg.setFi_edate(rs.getString("fi_edate"));
				fdg.setFi_status(rs.getString("fi_status"));	fdg.setFi_isview(rs.getString("fi_isview"));
				fdg.setFi_date(rs.getString("fi_date"));		fdg.setAi_idx(rs.getInt("ai_idx"));
				// 받아온 컬럼들의 값을 fdg 인스턴스에 저장

				fdgList.add(fdg);
				// 하나의 상품 정보를 담은 인스턴스 fdg를 fdgList에 저장
			}

		} catch(Exception e) {
			System.out.println("FundingDao 클래스의 getFdgList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return fdgList;
	}


	public FundingInfo getFdgInfo(int fiidx, int ocnum) {
	// 검색된 상품의 정보를 FundingInfo 형 인스턴스에 담아 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		FundingInfo fdg = null;

		try {
			String sql = "select * from t_funding_info where fi_isview = 'y' and fi_idx = '" + fiidx + "' ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				fdg = new FundingInfo();

				fdg.setFi_idx(rs.getInt("fi_idx"));				fdg.setFi_id(rs.getString("fi_id"));
				fdg.setFi_name(rs.getString("fi_name"));		fdg.setFi_img1(rs.getString("fi_img1"));		
				fdg.setFi_img2(rs.getString("fi_img2"));		fdg.setFi_img3(rs.getString("fi_img3"));
				fdg.setFi_desc(rs.getString("fi_desc"));		fdg.setFi_price(rs.getInt("fi_price"));	
				fdg.setFi_ordercnt(rs.getInt("fi_ordercnt"));	fdg.setFi_goal(rs.getInt("fi_goal"));	
				fdg.setFi_rate(rs.getFloat("fi_rate"));			fdg.setFi_support(rs.getInt("fi_support"));
				fdg.setFi_total(rs.getInt("fi_total"));			fdg.setFi_good(rs.getInt("fi_good"));
				fdg.setFi_sdate(rs.getString("fi_sdate"));		fdg.setFi_edate(rs.getString("fi_edate"));
				fdg.setFi_status(rs.getString("fi_status"));	fdg.setFi_isview(rs.getString("fi_isview"));
				fdg.setFi_date(rs.getString("fi_date"));		fdg.setAi_idx(rs.getInt("ai_idx"));
				fdg.setOcnum(ocnum);
				}

		} catch(Exception e) {
			System.out.println("FundingDao 클래스의 getFdgInfo() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return fdg;
	}
}