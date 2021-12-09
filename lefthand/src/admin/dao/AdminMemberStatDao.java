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
	// �ܺο����� �Ժη� �ν��Ͻ��� �������� ���ϰ� private���� �����ڸ� ������
		
	public static AdminMemberStatDao getInstance() {
	// �̱��� ������� �ν��Ͻ� ���� ���� 
		if (adminMemberStatDao == null)	adminMemberStatDao = new AdminMemberStatDao();
		// ������ �ν��Ͻ��� ��������� ���Ӱ� ������ �ʰ�, ���� ��쿡�� ���� �����ϰ� �� 
		return adminMemberStatDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public AdminMemStatsInfo getMemStatsData()  {
	// ȸ���� ��迡�� ��� �� �����͸� �����ϴ� �޼ҵ�
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
			
			sql = "select count(*) from v_mem_stat_info where mi_hand='l'";
			rs = stmt.executeQuery(sql);
			rs.next();
			mstat.setF_lcount(rs.getInt(1));
			
			sql = "select count(*) from v_mem_stat_info where mi_hand='r'";
			rs = stmt.executeQuery(sql);
			rs.next();
			mstat.setF_rcount(rs.getInt(1));
			
			sql = "select count(*) from v_mem_stat_info where mi_hand='b'";
			rs = stmt.executeQuery(sql);
			rs.next();
			mstat.setF_bcount(rs.getInt(1)); 
					
		} catch (Exception e) {
			System.out.println("AdminMemberStatDao Ŭ������ getMemStatsData() �޼ҵ� ����");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);	
		}		
		return mstat;
	}

}
