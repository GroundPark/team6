package funding.svc;

import static funding.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import funding.dao.*;
import vo.*;

public class FdgListSvc {
	public int getFdgCount(String where) {
	// 검색된 펀딩의 전체 개수를 리턴하는 메소드
		int rcnt = 0;	// 전체 펀딩 개수를 저장할 변수
		Connection conn = getConnection();
		FundingDao fundingDao = FundingDao.getInstance();
		fundingDao.setConnection(conn);
		rcnt = fundingDao.getFdgCount(where);
		close(conn);

		return rcnt;
	}

	public ArrayList<FundingInfo> getFdgList(String where, String order, int cpage, int psize) {
	// 펀딩 목록을 ArrayList<FundingInfo>에 담아 리턴하는 메소드
		ArrayList<FundingInfo> fdgList = new ArrayList<FundingInfo>();
		Connection conn = getConnection();
		FundingDao fundingDao = FundingDao.getInstance();
		fundingDao.setConnection(conn);
		fdgList = fundingDao.getFdgList(where, order, cpage, psize);
		close(conn);

		return fdgList;
	}
}