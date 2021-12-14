package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import vo.*;

public class AdminOrderFdgDao {
	private static AdminOrderFdgDao adminOrderFdgDao;
	private Connection conn;
	
	private AdminOrderFdgDao() {}
	
	public static AdminOrderFdgDao getInstance() {
		if (adminOrderFdgDao == null)			adminOrderFdgDao = new AdminOrderFdgDao();
		return adminOrderFdgDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int getOrderFdgCount(String where) {
	// 조건에 맞는 게시글의 총 개수를 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;	// 리턴할 값(레코드 개수)을 저장할 변수로 값이 없을 경우를 대비하여 0으로 초기화
		
		try {
			stmt = conn.createStatement();
			String sql ="select count(*) from t_funding_order_info " + where;
			rs= stmt.executeQuery(sql);
			rs.next();	rcnt = rs.getInt(1);
			
		} catch(Exception e) {
			System.out.println("AdminOrderFdgDao 클래스의 getOrderFdgCount() 메소드 오류");
			e. printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}
		return rcnt;
	}
	
	public ArrayList<FdgOrderInfo> getOrderFdgList(String where, String order, int cpage, int psize) {
	// 주문된 펀딩 리스트를 ArrayList로 리턴하는 메소드 
		Statement stmt = null;
		ResultSet rs = null;	
		ArrayList<FdgOrderInfo> fdgOrderList = new ArrayList<FdgOrderInfo>();
		FdgOrderInfo fdgOrd = null;
		
		try {
			stmt = conn.createStatement();
			int snum = (cpage - 1) * psize;
			String sql ="select foi_id, mi_id, foi_pay, foi_status, foi_date, ai_idx " 
					+ "from t_funding_order_info "+ where + order + " limit " + ((cpage - 1) * psize) + ", " + psize;
			rs= stmt.executeQuery(sql);
			
			while (rs.next()) {
				fdgOrd = new FdgOrderInfo();
				
				fdgOrd.setFoi_id(rs.getString("foi_id"));
				fdgOrd.setMi_id(rs.getString("mi_id"));
				fdgOrd.setFoi_pay(rs.getInt("foi_pay"));
				fdgOrd.setFoi_status(rs.getString("foi_status"));
				fdgOrd.setFoi_date(rs.getString("foi_date"));
				fdgOrd.setAi_idx(rs.getInt("ai_idx"));
				
				fdgOrderList.add(fdgOrd);
			}	
			
		} catch(Exception e) {
			System.out.println("AdminOrderFdgDao 클래스의 getOrderFdgList() 메소드 오류");
			e. printStackTrace();
		} 
		return fdgOrderList;		
	}

	public FdgOrderInfo getFdgOrderInfo(String miid, String foiid) {
	// 리스트에서 주문번호 클릭 시 보여질 주문정보를 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		FdgOrderInfo fdgOrd = null;
		
		try {
			String sql ="select a.*, b.foi_id, b.fi_id, b.fod_cnt, b.fod_pname, b.fod_pprice " + 
					" from t_funding_order_info a, t_funding_order_detail b where a.foi_id = b.foi_id and a.mi_id = '" + miid + 
					"' and a.foi_id = '" + foiid + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {	// 해당 주문이 존재하면
				fdgOrd = new FdgOrderInfo();

				fdgOrd.setFoi_id(foiid);
				fdgOrd.setMi_id(rs.getString("mi_id"));				fdgOrd.setFoi_name(rs.getString("foi_name"));
				fdgOrd.setFoi_phone(rs.getString("foi_phone"));		fdgOrd.setFoi_zip(rs.getString("foi_zip"));
				fdgOrd.setFoi_addr1(rs.getString("foi_addr1"));		fdgOrd.setFoi_addr2(rs.getString("foi_addr2"));
				fdgOrd.setFoi_memo(rs.getString("foi_memo"));		fdgOrd.setFoi_invoice(rs.getString("foi_invoice"));
				fdgOrd.setFoi_date(rs.getString("foi_date"));		fdgOrd.setFoi_pay(rs.getInt("foi_pay"));
				fdgOrd.setFoi_status(rs.getString("foi_status"));	fdgOrd.setFoi_delipay(rs.getInt("foi_delipay"));
				fdgOrd.setFoi_modify(rs.getString("foi_modify"));	fdgOrd.setAi_idx(rs.getInt("ai_idx"));				

				ArrayList<FdgOrderDetail> detailList = new ArrayList<FdgOrderDetail>();
				// 주문 내역의 상품정보들을 저장할 ArrayList 생성
				do {
					FdgOrderDetail detail = new FdgOrderDetail();
					// detailList 에 저장할 OrderDetail 인스턴스 생성
					detail.setFi_id(rs.getString("fi_id"));			detail.setFod_cnt(rs.getInt("fod_cnt"));				
					detail.setFod_pname(rs.getString("fod_pname"));	detail.setFod_pprice(rs.getInt("fod_pprice"));
					
					detailList.add(detail);
					
				} while (rs.next());
				
				fdgOrd.setFdgDetailList(detailList);
				// 주문내역의  상품정보들을 저장한 detailList를 OrderInfo형 인스턴스 ord에 저장
			}
						
		} catch(Exception e) {
			System.out.println("AdminOrderFdgDao 클래스의  getFdgOrderInfo() 메소드 오류");
			e. printStackTrace();
		}  finally {
			close(rs);	close(stmt);
		}
		
		return fdgOrd;
		
	}

	public int orderFdgUpdate(FdgOrderInfo ord, int aiidx) {
	// 상품 주문 내역 수정시키는 메소드
		Statement stmt = null;
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "update t_funding_order_info set foi_phone = '" + ord.getFoi_phone() + "', foi_zip = '" + ord.getFoi_zip() + 
					"', foi_addr1 = '" + ord.getFoi_addr1() + "', foi_addr2 = '" + ord.getFoi_addr2() + "', " + 
					"foi_memo = '" + ord.getFoi_memo() + "', foi_status = '" + ord.getFoi_status() + "', foi_invoice = '" + ord.getFoi_invoice() + 
					"', foi_modify = now(), ai_idx = " + aiidx + " where foi_id = '" + ord.getFoi_id() + "' and mi_id = '" + ord.getMi_id() + "'";			

			result = stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			System.out.println("AdminOrderFdgDao 클래스의  orderFdgUpdate() 메소드 오류");
			e. printStackTrace();
		}  finally {
			close(stmt);
		}
		
		return result;
		
	}
}
