package product.svc;

import static product.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import product.dao.*;
import vo.*;

public class LikePlusSvc {
	public int cntUpdte(String miid, int rlidx) {
		Connection conn = getConnection();
		LikePlusDao likePlusDao = LikePlusDao.getInstance();
		likePlusDao.setConnection(conn);
		int result = 0;

		result = likePlusDao.cntUpdte(miid, rlidx);

		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);

		return result;
	}
}
