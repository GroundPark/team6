package admin.dao;

import static admin.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import vo.*;

public class AdminOrderPdtDao {
	private static AdminOrderPdtDao adminOrderPdtDao;
	private Connection conn;
	
	private AdminOrderPdtDao() {}
	
	public static AdminOrderPdtDao getInstance() {
		if (adminOrderPdtDao == null)			adminOrderPdtDao = new AdminOrderPdtDao();
		return adminOrderPdtDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int getOrderPdtCount(String where) {
	// 조건에 맞는 게시글의 총 개수를 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		int rcnt = 0;	// 리턴할 값(레코드 개수)을 저장할 변수로 값이 없을 경우를 대비하여 0으로 초기화
		
		try {
			stmt = conn.createStatement();
			String sql ="select count(*) from t_product_order_info " + where;
			rs= stmt.executeQuery(sql);
			rs.next();	rcnt = rs.getInt(1);
			
		} catch(Exception e) {
			System.out.println("AdminOrderPdtDao 클래스의 getOrderPdtCount() 메소드 오류");
			e. printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}
		return rcnt;
	}
	
	public ArrayList<OrderInfo> getOrderPdtList(String where, String order, int cpage, int psize) {
	// 주문된 상품 리스트를 ArrayList로 리턴하는 메소드 
		Statement stmt = null;	// 쿼리를 db로 옮겨서 실행해줌
		ResultSet rs = null;	// 쿼리를 실행한 결과를 받아줌(select쿼리 일 때)
		ArrayList<OrderInfo> orderList = new ArrayList<OrderInfo>();
		OrderInfo ord = null;
		
		try {
			stmt = conn.createStatement();
			int snum = (cpage - 1) * psize;
			String sql ="select poi_id, mi_id, poi_name, poi_pay, poi_status, poi_date, ai_idx " 
					+ "from t_product_order_info "+ where + order + " limit " + ((cpage - 1) * psize) + ", " + psize;
			rs= stmt.executeQuery(sql);

			while (rs.next()) {
				ord = new OrderInfo();	// ArrayList에 저장할 OrderInfo형 인스턴스 생성
				
				ord.setPoi_id(rs.getString("poi_id"));
				ord.setMi_id(rs.getString("mi_id"));
				ord.setPoi_name(rs.getString("poi_name"));
				ord.setPoi_pay(rs.getInt("poi_pay"));
				ord.setPoi_status(rs.getString("poi_status"));
				ord.setPoi_date(rs.getString("poi_date"));
				ord.setAi_idx(rs.getInt("ai_idx"));
				
				orderList.add(ord);
				// rs에 들어있는 레코드들을OrderInfo형 인스턴스로 생성한 후 ArrayList인 orderList에 차례대로 저장
			}	
			
		} catch(Exception e) {
			System.out.println("AdminOrderPdtDao 클래스의 getOrderPdtList() 메소드 오류");
			e. printStackTrace();
		} 
		return orderList;		
	}

	public OrderInfo getOrderInfo(String miid, String poiid) {
	// 리스트에서 주문번호 클릭 시 보여질 주문정보를 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		OrderInfo ord = null;
		// orderList에 저장할 OrderInfo형 인스턴스
		
		try {
			String sql ="select a.*, b.poi_id, b.pi_id, b.pod_cnt, b.pod_pname, b.pod_pprice " + 
					" from t_product_order_info a, t_product_order_detail b where a.poi_id = b.poi_id and a.mi_id = '" + miid + 
					"' and a.poi_id = '" + poiid + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {	// 해당 주문이 존재하면
				ord = new OrderInfo();

				ord.setPoi_id(poiid);
				ord.setMi_id(rs.getString("mi_id"));				ord.setPoi_name(rs.getString("poi_name"));
				ord.setPoi_phone(rs.getString("poi_phone"));		ord.setPoi_zip(rs.getString("poi_zip"));
				ord.setPoi_addr1(rs.getString("poi_addr1"));		ord.setPoi_addr2(rs.getString("poi_addr2"));
				ord.setPoi_memo(rs.getString("poi_memo"));			ord.setPoi_invoice(rs.getString("poi_invoice"));
				ord.setPoi_date(rs.getString("poi_date"));			ord.setPoi_pay(rs.getInt("poi_pay"));
				ord.setPoi_point(rs.getInt("poi_point"));			ord.setPoi_delipay(rs.getInt("poi_delipay"));
				ord.setPoi_payment(rs.getString("poi_payment"));	ord.setPoi_status(rs.getString("poi_status"));
				ord.setPoi_modify(rs.getString("poi_modify"));		ord.setAi_idx(rs.getInt("ai_idx"));				

				ArrayList<OrderDetail> detailList = new ArrayList<OrderDetail>();
				// 주문 내역의 상품정보들을 저장할 ArrayList 생성
				do {
					OrderDetail detail = new OrderDetail();
					// detailList 에 저장할 OrderDetail 인스턴스 생성
					detail.setPi_id(rs.getString("pi_id"));			detail.setPod_cnt(rs.getInt("pod_cnt"));				
					detail.setPod_pname(rs.getString("pod_pname"));	detail.setPod_pprice(rs.getInt("pod_pprice"));
					
					detailList.add(detail);
					
				} while (rs.next());
				
				ord.setDetailList(detailList);
				// 주문내역의  상품정보들을 저장한 detailList를 OrderInfo형 인스턴스 ord에 저장
			}
						
		} catch(Exception e) {
			System.out.println("AdminOrderPdtDao 클래스의  getOrderInfo() 메소드 오류");
			e. printStackTrace();
		}  finally {
			close(rs);	close(stmt);
		}
		
		return ord;
		
	}

	public int orderPdtUpdate(OrderInfo ord, int aiidx) {
	// 상품 주문 내역 수정시키는 메소드
		Statement stmt = null;
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "update t_product_order_info set poi_phone = '" + ord.getPoi_phone() + "', poi_zip = '" + ord.getPoi_zip() + 
					"', poi_addr1 = '" + ord.getPoi_addr1() + "', poi_addr2 = '" + ord.getPoi_addr2() + "', " + 
					"poi_memo = '" + ord.getPoi_memo() + "', poi_status = '" + ord.getPoi_status() + "', poi_invoice = '" + ord.getPoi_invoice() + 
					"', poi_modify = now(), ai_idx = " + aiidx + " where poi_id = '" + ord.getPoi_id() + "' and mi_id = '" + ord.getMi_id() + "'";			

			result = stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			System.out.println("AdminOrderPdtDao 클래스의  orderPdtUpdate() 메소드 오류");
			e. printStackTrace();
		}  finally {
			close(stmt);
		}
		
		return result;
		
	}
}
