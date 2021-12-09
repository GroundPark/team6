package funding.svc;

import static funding.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import funding.dao.*;
import vo.*;

public class FdgViewSvc {
	public FundingInfo getFdgInfo(int fiidx, int ocnum) {
	// 검색된 상품 목록을 ProductInfo 형 인스턴스에 담아 리턴하는 메소드
		FundingInfo fdgInfo = new FundingInfo();
		Connection conn = getConnection();
		FundingDao fundingDao = FundingDao.getInstance();
		fundingDao.setConnection(conn);
		fdgInfo = fundingDao.getFdgInfo(fiidx, ocnum);
		close(conn);

		return fdgInfo;
	}
}