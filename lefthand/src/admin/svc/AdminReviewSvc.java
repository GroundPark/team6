package admin.svc;

import static product.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminReviewSvc {
	public int setReview(int rlidx, String piid, String miid, String view) {
		int vcnt = 0;
		Connection conn = getConnection();
		AdminReviewDao adminReviewtDao = AdminReviewDao.getInstance();
		adminReviewtDao.setConnection(conn);
		vcnt = adminReviewtDao.setReview(rlidx, piid, miid, view);
		
		if (vcnt >= 1)		commit(conn);	// 등록, 수정, 삭제 등의 작업이 일어난 레코드가 하나면 쿼리를 적용시킴
		else				rollback(conn);	// 작업이 일어난 레코드가 없으면 쿼리 적용을 취소하고, 처음으로 되돌림
		
		close(conn);
		
		return vcnt;
	}
}
