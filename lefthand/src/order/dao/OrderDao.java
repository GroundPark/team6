package order.dao;

import static order.db.JdbcUtil.*;	
import java.util.*;
import javax.sql.*;
import java.sql.*;
import vo.*;

public class OrderDao {
// 장바구니 및 주문 관련 DB작업을 처리하는 클래스
	private static OrderDao orderDao;
	private Connection conn;
	
	private OrderDao() {}
	// 외부에서는 함부로 인스턴스를 생성하지 못하게 private으로 생성자를 선언함
		
	public static OrderDao getInstance() {
	// 싱글톤 방식으로 인스턴스 낭비를 줄임 
		if (orderDao == null)	orderDao = new OrderDao();
		// 기존의 인스턴스가 살아있으면 새롭게 만들지 않고, 없을 경우에만 새로 생성하게 함 
		return orderDao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int cartInsert(CartInfo cart) {
	// 받아온 상품 정보(cart)를 장바구니에 추가시키는 메소드
		Statement stmt = null;
		ResultSet rs = null;	// 동일한 상품이 장바구니에 있는지 여부를 판단하기 위함
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "select a.poc_idx, a.poc_cnt, b.pi_stock from t_product_order_cart a, t_product_info b " + 
					" where a.pi_id = b.pi_id and a.pi_id = '" + cart.getPi_id() + 
					"' and a.mi_id = '" + cart.getMi_id() + "' ";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {	// 추가하려는 상품과 동일한 상품이 이미 존재한다면(기존 상품 정보에서 수량만 조절)
				sql = "update t_product_order_cart set poc_cnt = poc_cnt + " + cart.getPoc_cnt() + " where poc_idx = " + rs.getInt("poc_idx") ;
				if (rs.getInt("pi_stock") > 0) {	// 재고가 무제한(-1)이 아니면
					sql += " and (poc_cnt + " + cart.getPoc_cnt() + ") <= " + rs.getInt("pi_stock");
					// 기존 수량과 새로 추가할 수량의 합이 재고량 이하일 경우에만 update 가능
				}
				
			} else {			// 처음 추가하는 상품이면
				sql = "insert into t_product_order_cart (mi_id, pi_id, poc_cnt) values ('" + 
						cart.getMi_id() + "', '" + cart.getPi_id() + "', " + cart.getPoc_cnt() + ") ";
			}
			
			result = stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			System.out.println("OrderDao 클래스의 cartInsert() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);	
		}
		
		return result;
	}

	public int cartUpdateCount(CartInfo cart, String where) {
	// 받아온 상품정보(cart)를 이용하여 장바구니 내의 상품 수량을 변경시키는 메소드
		Statement stmt = null;
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "update t_product_order_cart set poc_cnt = " + cart.getPoc_cnt() + where;
			result = stmt.executeUpdate(sql);
			System.out.println(result);
			
		} catch(Exception e) {
			System.out.println("OrderDao 클래스의 cartUpdateCount() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}
	
	public int cartDelete(CartInfo cart, String where) {
	// 받아온 상품정보(cart)를 이용하여 장바구니 내의 상품을 삭제시키는 메소드
		Statement stmt = null;
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			String sql = "delete from t_product_order_cart " + where;
			result = stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			System.out.println("OrderDao 클래스의 cartDelete() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}


	public ArrayList<CartInfo> getCartList(String where) {
	// 장바구니 목록을 ArrayList<CartInfo>형 인스턴스로 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<CartInfo> cartList = new ArrayList<CartInfo>();
		CartInfo cart = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select a.*, b.pi_name, b.pi_img1, b.pi_price, b.pi_stock, b.pi_discount " + 
					" from t_product_order_cart a, t_product_info b where a.pi_id = b.pi_id and b.pi_isview = 'y' " + 
					" and (b.pi_stock >= a.poc_cnt or b.pi_stock = -1) " + where + "order by a.pi_id";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {	// rs가 비어있는지 여부를 알려면 if문을 사용해야 하나 얘는 arrayList여서 확인 가능하므로 while문을 사용함
				cart = new CartInfo();	// cartList에 저장할 하나의 상품 정보를 담을 CartInfo형 인스턴스 생성
				
				cart.setPoc_idx(rs.getInt("poc_idx"));					cart.setMi_id(rs.getString("mi_id"));
				cart.setPi_id(rs.getString("pi_id"));					cart.setPoc_cnt(rs.getInt("poc_cnt"));
				cart.setPi_discount(rs.getDouble("pi_discount"));		cart.setPoc_date(rs.getString("poc_date"));		
				cart.setPi_name(rs.getString("pi_name"));				cart.setPi_price(rs.getInt("pi_price"));		
				cart.setPi_img1(rs.getString("pi_img1"));				cart.setPi_stock(rs.getInt("pi_stock"));
				
				cartList.add(cart);	// 하나의 상품 정보를 담은 인스턴스 cart를 cartList에 저장
			}
			
		} catch(Exception e) {
			System.out.println("OrderDao 클래스의 getCartList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);	
		}
		
		return cartList;
	}

	public ArrayList<CartInfo> getDirectOrderPdtList(String piid, int poccnt, String miid) {
	// 상품 바로주문 시 상품 정보를 ArrayList<CartInfo>형 인스턴스로 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<CartInfo> cartList = new ArrayList<CartInfo>();
		CartInfo cart = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select pi_name, pi_img1, pi_price, pi_stock, pi_discount " + 
					" from t_product_info where pi_isview = 'y' and pi_id = '" + piid +  
					"' and (pi_stock >= " + poccnt + " or pi_stock = -1) order by pi_id";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {	
				cart = new CartInfo();	// cartList에 저장할 하나의 상품 정보를 담을 CartInfo형 인스턴스 생성
				
				cart.setMi_id(miid);		cart.setPi_id(piid);		cart.setPoc_cnt(poccnt);
				cart.setPi_discount(rs.getDouble("pi_discount"));		cart.setPi_name(rs.getString("pi_name"));				
				cart.setPi_price(rs.getInt("pi_price"));				cart.setPi_img1(rs.getString("pi_img1"));				
				cart.setPi_stock(rs.getInt("pi_stock"));
				
				cartList.add(cart);	// 하나의 상품 정보를 담은 인스턴스 cart를 cartList에 저장
			}
			
		} catch(Exception e) {
			System.out.println("OrderDao 클래스의 getDirectOrderPdtList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);	
		}
		
		return cartList;
	}
	
	public ArrayList<MemberAddr> getAddrList(String uid) {
	// 상품을 구매하려는 회원의 주소목록을 ArrayList<MemberAddr>형 인스턴스로 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MemberAddr> addrList = new ArrayList<MemberAddr>();
		MemberAddr addr = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from t_member_address where mi_id = '" + uid + "' order by ma_basic desc";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {	// rs가 비어있는지 여부를 알려면 if문을 사용해야 하나 얘는 arrayList여서 확인 가능하므로 while문을 사용함
				addr = new MemberAddr();	// addrList에 저장할 하나의 주소 정보를 담을 MemberAddr형 인스턴스 생성

				addr.setMa_idx(rs.getInt("ma_idx"));			addr.setMa_name(rs.getString("ma_name"));
				addr.setMa_zip(rs.getString("ma_zip"));			addr.setMa_addr1(rs.getString("ma_addr1"));
				addr.setMa_addr2(rs.getString("ma_addr2"));		addr.setMa_basic(rs.getString("ma_basic"));	
				
				addrList.add(addr);	// 하나의 주소 정보를 담은 인스턴스addr를 addrList에 저장
			}
			
		} catch(Exception e) {
			System.out.println("OrderDao 클래스의 getAddrList() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);	
		}
		
		return addrList;
	}


	public String orderInsert(OrderInfo ord, String where) {
	// 주문 처리 메소드
		PreparedStatement pstmt = null;	// insert문에서 사용하기 위함
		Statement stmt = null, stmt2 = null;
		ResultSet rs = null;
		String poiid = getOrderId();	// 새 주문번호 받아오기
		String result = poiid + ":";	// 리턴값을 저장할 변수(주문번호와 변경된 레코드 개수)
		
		try {
			String sql = "select a.pi_id, a.poc_cnt, b.pi_name, b.pi_img1, b.pi_price, b.pi_stock " + 
					" from t_product_order_cart a, t_product_info b where a.pi_id = b.pi_id and b.pi_isview = 'y' " + 
					" and (b.pi_stock >= a.poc_cnt or b.pi_stock = -1) " + where + " order by a.pi_id";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {	// 장바구니에 구매하고자 하는 상품이 있는 경우
				sql = "insert into t_product_order_info (poi_id, mi_id, poi_name, poi_phone, poi_zip, poi_addr1, poi_addr2, poi_memo, poi_payment, "
						+ "poi_pay, poi_point, poi_discount, poi_delipay, poi_status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,  poiid);					pstmt.setString(2, ord.getMi_id());
				pstmt.setString(3, ord.getPoi_name());		pstmt.setString(4, ord.getPoi_phone());
				pstmt.setString(5, ord.getPoi_zip());		pstmt.setString(6, ord.getPoi_addr1());
				pstmt.setString(7, ord.getPoi_addr2());		pstmt.setString(8, "");
				pstmt.setString(9, ord.getPoi_payment());	pstmt.setInt(10, ord.getPoi_pay());
				pstmt.setInt(11, ord.getPoi_point());		pstmt.setInt(12, ord.getPoi_discount());
				pstmt.setInt(13,  ord.getPoi_delipay());	pstmt.setString(14, ord.getPoi_status());	
				
				result += pstmt.executeUpdate();
				if (result.charAt(13) == '0') { System.out.println("t_order_info 테이블  insert 쿼리 오류");	return result; }
				// 주문 테이블(t_order_info)에 insert 쿼리가 정상적으로 동작하지 않은 경우 더 이상 메소드를 진행시키지 않음(서비스에서 rollback할 거임)

				stmt2 = conn.createStatement();
				do {	// 장바구니의 구매상품 정보를 이용하여 t_product_order_detail(insert), t_product_order_info(update) 작업
					sql = "insert into t_product_order_detail (poi_id, pi_id, pod_cnt, pod_pname, pod_pimg, pod_pprice) values (?, ?, ?, ?, ?, ?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, poiid);						pstmt.setString(2, rs.getString("pi_id"));
					pstmt.setInt(3, rs.getInt("poc_cnt"));			pstmt.setString(4, rs.getString("pi_name"));
					pstmt.setString(5, rs.getString("pi_img1"));	pstmt.setInt(6, rs.getInt("pi_price"));

					result += pstmt.executeUpdate();
					if (result.charAt(13) == '0') { System.out.println("t_product_order_detail 테이블  insert 쿼리 오류");	return result; }
					// 주문 상세정보(t_product_order_detail) 추가 쿼리
					
					String stock = ", pi_stock = pi_stock - " + rs.getInt("poc_cnt");	// 판매한 개수만큼 재고량을 줄이는 쿼리
					if (rs.getInt("pi_stock") == -1)	stock = "";		// 재고량이 무제한이면 줄이지 않음
					sql = "update t_product_info set pi_salecnt = pi_salecnt + " + rs.getInt("poc_cnt") + 
					stock + " where pi_id = '" + rs.getString("pi_id") + "' ";
					result += stmt2.executeUpdate(sql);
					if (result.charAt(13) == '0') { System.out.println("t_product_info 테이블 update 쿼리 오류"); return result; }
					
				} while (rs.next());
				
				// 포인트 적립 쿼리
				if (ord.getPoi_point() > 0) {
					sql = "insert into t_member_point (mi_id, mp_kind, mp_point, mp_content) values (?, ?, ?, ?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ord.getMi_id());			pstmt.setString(2, "b");
					pstmt.setInt(3, ord.getPoi_point());		pstmt.setString(4, "상품구매-" + poiid);
					result += pstmt.executeUpdate();		// 포인트 적립 내역 추가 쿼리
					if (result.charAt(13) == '0') { System.out.println("t_member_point 테이블  insert 쿼리 오류");	return result; }
					
					sql = "update t_member_info set mi_point = mi_point - " + ord.getPoi_point() + " where mi_id = '" + ord.getMi_id() + "' ";
					result += stmt2.executeUpdate(sql);	// 회원 보유 포인트 변경 쿼리
					if (result.charAt(13) == '0') { System.out.println("t_member_info 테이블  update 쿼리 오류");	return result; }
				}
				
				// 장바구니 삭제 쿼리
				sql = "delete from t_product_order_cart a where 1=1 " + where;
				// where변수에 들어있는 조건이 ' and'로 시작하므로 where절에 항상 참인 조건을 인위적으로 입력하여 사용
				result += stmt2.executeUpdate(sql);
				if (result.charAt(13) == '0') { System.out.println("t_order_cart 테이블  delete 쿼리 오류");	return result; }
			}
			
		} catch(Exception e) {
			System.out.println("OrderDao 클래스의 orderInsert() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt2);	close(pstmt);	close(stmt);
		}
		
		return result;
	}

	public String directOrderInsert(OrderInfo ord, String piid, int poccnt) {
		// 주문 처리 메소드
			PreparedStatement pstmt = null;	// insert문에서 사용하기 위함
			Statement stmt = null, stmt2 = null;
			ResultSet rs = null;
			String poiid = getOrderId();	// 새 주문번호 받아오기
			String result = poiid + ":";	// 리턴값을 저장할 변수(주문번호와 변경된 레코드 개수)
			
			try {
				String sql = "select pi_id, pi_name, pi_img1, pi_price, pi_stock " + 
						" from t_product_info where pi_id = '" + piid + "' and pi_isview = 'y' " + 
						" and (pi_stock >= " + poccnt + " or pi_stock = -1) order by pi_id";

				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {	// 장바구니에 구매하고자 하는 상품이 있는 경우
					sql = "insert into t_product_order_info (poi_id, mi_id, poi_name, poi_phone, poi_zip, poi_addr1, poi_addr2, poi_memo, poi_payment, "
							+ "poi_pay, poi_point, poi_discount, poi_delipay, poi_status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,  poiid);					pstmt.setString(2, ord.getMi_id());
					pstmt.setString(3, ord.getPoi_name());		pstmt.setString(4, ord.getPoi_phone());
					pstmt.setString(5, ord.getPoi_zip());		pstmt.setString(6, ord.getPoi_addr1());
					pstmt.setString(7, ord.getPoi_addr2());		pstmt.setString(8, "");
					pstmt.setString(9, ord.getPoi_payment());	pstmt.setInt(10, ord.getPoi_pay());
					pstmt.setInt(11, ord.getPoi_point());		pstmt.setInt(12, ord.getPoi_discount());
					pstmt.setInt(13,  ord.getPoi_delipay());	pstmt.setString(14, ord.getPoi_status());	
					
					result += pstmt.executeUpdate();
					if (result.charAt(13) == '0') { System.out.println("t_order_info 테이블  insert 쿼리 오류");	return result; }
					// 주문 테이블(t_order_info)에 insert 쿼리가 정상적으로 동작하지 않은 경우 더 이상 메소드를 진행시키지 않음(서비스에서 rollback할 거임)

					stmt2 = conn.createStatement();
					do {	// 장바구니의 구매상품 정보를 이용하여 t_product_order_detail(insert), t_product_order_info(update) 작업
						sql = "insert into t_product_order_detail (poi_id, pi_id, pod_cnt, pod_pname, pod_pimg, pod_pprice) values (?, ?, ?, ?, ?, ?)";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, poiid);						pstmt.setString(2, piid);
						pstmt.setInt(3, poccnt);						pstmt.setString(4, rs.getString("pi_name"));
						pstmt.setString(5, rs.getString("pi_img1"));	pstmt.setInt(6, rs.getInt("pi_price"));

						result += pstmt.executeUpdate();
						if (result.charAt(13) == '0') { System.out.println("t_product_order_detail 테이블  insert 쿼리 오류");	return result; }
						// 주문 상세정보(t_product_order_detail) 추가 쿼리
						
						String stock = ", pi_stock = pi_stock - " + poccnt;	// 판매한 개수만큼 재고량을 줄이는 쿼리
						if (rs.getInt("pi_stock") == -1)	stock = "";		// 재고량이 무제한이면 줄이지 않음
						sql = "update t_product_info set pi_salecnt = pi_salecnt + " + poccnt + 
						stock + " where pi_id = '" + piid + "' ";
						result += stmt2.executeUpdate(sql);
						if (result.charAt(13) == '0') { System.out.println("t_product_info 테이블 update 쿼리 오류"); return result; }
						
					} while (rs.next());
					
					// 포인트 적립 쿼리
					if (ord.getPoi_point() > 0) {
						sql = "insert into t_member_point (mi_id, mp_kind, mp_point, mp_content) values (?, ?, ?, ?)";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, ord.getMi_id());			pstmt.setString(2, "b");
						pstmt.setInt(3, ord.getPoi_point());		pstmt.setString(4, "상품구매-" + poiid);
						result += pstmt.executeUpdate();		// 포인트 적립 내역 추가 쿼리
						if (result.charAt(13) == '0') { System.out.println("t_member_point 테이블  insert 쿼리 오류");	return result; }
						
						sql = "update t_member_info set mi_point = mi_point - " + ord.getPoi_point() + " where mi_id = '" + ord.getMi_id() + "' ";
						result += stmt2.executeUpdate(sql);	// 회원 보유 포인트 변경 쿼리
						if (result.charAt(13) == '0') { System.out.println("t_member_info 테이블  update 쿼리 오류");	return result; }
					}
					
				}
				
			} catch(Exception e) {
				System.out.println("OrderDao 클래스의 directOrderInsert() 메소드 오류");
				e.printStackTrace();
			} finally {
				close(rs);	close(stmt2);	close(pstmt);	close(stmt);
			}
			
			return result;
		}
	
	public String getOrderId() {
	// 새 주문아이디를 생성하여 리턴하는 메소드(yymmdd + 랜덤영문 3자리 + 일련번호 3자리 : 101)
		Statement stmt = null;
		ResultSet rs = null;
		String poiid = "";

		Calendar today = Calendar.getInstance();
		String date = (today.get(Calendar.YEAR) + "").substring(2);	// 연도의 뒷쪽 두 자리 추출
		int m = today.get(Calendar.MONTH) + 1;
		int d = today.get(Calendar.DATE);
		date += (m < 10) ? "0" + m : "" + m;
		date += (d < 10) ? "0" + d : "" + d;

		String tmp = "";	// 랜덤 영문 3자리를 저장할 변수
		String[] arr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		Random rnd = new Random();
		for (int i = 0 ; i < 3 ; i++)	tmp += arr[rnd.nextInt(26)];

		try {
			String sql = "select max(right(poi_id, 3)) from t_product_order_info where poi_id like '" + date + "%' ";
			// 같은 날 주문 번호들 중에서 가장 일련번호가 큰 값을 추출하기 위한 쿼리
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next() && rs.getString(1) != null)	poiid = date + tmp + (Integer.parseInt(rs.getString(1)) + 1);
			else										poiid = date + tmp + "101";

		} catch(Exception e) {
			System.out.println("OrderDao 클래스의 getOrderId() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return poiid;
	}
	
	public OrderInfo getOrderInfo(String miid, String poiid) {
	// 지정된 회원이 가장 최근에 주문한 내역을 추출하여 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		OrderInfo ord = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select a.*, b.pi_id, b.pod_cnt, b.pod_pname, b.pod_pimg, b.pod_pprice " + 
					" from t_product_order_info a, t_product_order_detail b where a.poi_id = b.poi_id and a.mi_id = '" + 
					miid + "' and a.poi_id = '" + poiid + "' order by b.pi_id";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {	// 해당 주문이 존재하면
				ord = new OrderInfo();	// 주문 정보들을 저장할 인스턴스 생성
				ord.setPoi_id(poiid);								ord.setMi_id(miid);
				ord.setPoi_name(rs.getString("poi_name"));			ord.setPoi_phone(rs.getString("poi_phone"));
				ord.setPoi_zip(rs.getString("poi_zip"));			ord.setPoi_addr1(rs.getString("poi_addr1"));
				ord.setPoi_addr2(rs.getString("poi_addr2"));		ord.setPoi_memo(rs.getString("poi_memo"));
				ord.setPoi_payment(rs.getString("poi_payment"));	ord.setPoi_pay(rs.getInt("poi_pay"));
				ord.setPoi_point(rs.getInt("poi_point"));			ord.setPoi_discount(rs.getInt("poi_discount"));
				ord.setPoi_delipay(rs.getInt("poi_delipay"));		ord.setPoi_status(rs.getString("poi_status"));
				ord.setPoi_date(rs.getString("poi_date"));
				// t_product_order_info 테이블 내의 정보
				
				ArrayList<OrderDetail> detailList = new ArrayList<OrderDetail>();
				// 주문 내역의 상품정보들을 저장할 ArrayList 생성
				do {
					OrderDetail detail = new OrderDetail();
					// detailList 에 저장할 OrderDetail 인스턴스 생성
					detail.setPi_id(rs.getString("pi_id"));			detail.setPod_cnt(rs.getInt("pod_cnt"));				
					detail.setPod_pname(rs.getString("pod_pname"));	detail.setPod_pimg(rs.getString("pod_pimg"));	
					detail.setPod_pprice(rs.getInt("pod_pprice"));
					detailList.add(detail);
					
				} while (rs.next());
				
				ord.setDetailList(detailList);
				// 주문내역의  상품정보들을 저장한 detailList를 OrderInfo형 인스턴스 ord에 저장
			}
			
		} catch(Exception e) {
			System.out.println("OrderDao 클래스의 getOrderInfo() 메소드 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);	
		}
		
		return ord;
	}
	
// 펀딩 관련 order DB 처리 영역       ///////////////////////////////////////
	public String fdgOrderInsert(FdgOrderInfo fdgOrd, String where, int ocnum) {
		// 펀딩 주문 처리 메소드
			PreparedStatement pstmt = null;	// insert문에서 사용하기 위함
			Statement stmt = null, stmt2 = null;
			ResultSet rs = null;
			String foiid = getOrderId();	// 새 주문번호 받아오기
			String result = foiid + ":";	// 리턴값을 저장할 변수(주문번호와 변경된 레코드 개수)
			
			try {
				String sql = "select fi_id, fi_name, fi_img1, fi_price from t_funding_info where fi_isview = 'y'" + where;

				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if (rs.next()) {	// 구매하고자 하는 펀딩이 있는 경우
					
					sql = "insert into t_funding_order_info (foi_id, mi_id, foi_name, foi_phone, foi_zip, foi_addr1, foi_addr2, foi_memo, "
								+ "foi_pay, foi_status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, foiid);						pstmt.setString(2, fdgOrd.getMi_id());
					pstmt.setString(3, fdgOrd.getFoi_name());		pstmt.setString(4, fdgOrd.getFoi_phone());
					pstmt.setString(5, fdgOrd.getFoi_zip());		pstmt.setString(6, fdgOrd.getFoi_addr1());
					pstmt.setString(7, fdgOrd.getFoi_addr2());		pstmt.setString(8, "");
					pstmt.setInt(9, fdgOrd.getFoi_pay());			pstmt.setString(10, fdgOrd.getFoi_status());	
					
					result += pstmt.executeUpdate();
					if (result.charAt(13) == '0') { System.out.println("t_funding_order_info 테이블  insert 쿼리 오류");	return result; }
					// 주문 테이블(t_funding_order_info)에 insert 쿼리가 정상적으로 동작하지 않은 경우 더 이상 메소드를 진행시키지 않음(서비스에서 rollback할 거임)
					
					stmt2 = conn.createStatement();
					do {
						sql = "insert into t_funding_order_detail (foi_id, fi_id, fod_cnt, fod_pname, fod_pimg, fod_pprice) values (?, ?, ?, ?, ?, ?)";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, foiid);						pstmt.setString(2, rs.getString("fi_id"));
						pstmt.setInt(3, ocnum);							pstmt.setString(4, rs.getString("fi_name"));
						pstmt.setString(5, rs.getString("fi_img1"));	pstmt.setInt(6, rs.getInt("fi_price"));
			
						result += pstmt.executeUpdate();
						if (result.charAt(13) == '0') { System.out.println("t_funding_order_detail 테이블  insert 쿼리 오류");	return result; }
						// 주문 상세정보(t_funding_order_detail) 추가 쿼리
						
						sql = "update t_funding_info set fi_ordercnt = fi_ordercnt + " + ocnum 
								+ " , fi_total = fi_total + " + rs.getInt("fi_price")
								+ " , fi_support = fi_support + 1"		// 통합전 바꿈
								+ ", fi_total= fi_price * fi_ordercnt, fi_rate = (fi_total / fi_goal) where fi_id = '" 
								+ rs.getString("fi_id") + "' ";
						result += stmt2.executeUpdate(sql);
						if (result.charAt(13) == '0') { System.out.println("t_fundging_info 테이블 update 쿼리 오류"); return result; }
					
					} while (rs.next());
				}
				
			} catch(Exception e) {
				System.out.println("OrderDao 클래스의 fdgOrderInsert() 메소드 오류");
				e.printStackTrace();
				
			} finally {
				close(rs);	close(stmt2);	close(pstmt);	close(stmt);	
			}
			
			return result;
		}

		public FdgOrderInfo getFdgOrderInfo(String miid, String foiid) {
		// 지정된 회원이 가장 최근에 주문한 내역을 추출하여 리턴하는 메소드
			Statement stmt = null;
			ResultSet rs = null;
			FdgOrderInfo fdgOrd = null;

			try {
				stmt = conn.createStatement();
				String sql = "select a.*, b.fi_id, b.fod_cnt, b.fod_pname, b.fod_pimg, b.fod_pprice " + 
						" from t_funding_order_info a, t_funding_order_detail b where a.foi_id = b.foi_id and a.mi_id = '" + 
						miid + "' and a.foi_id = '" + foiid + "' order by b.fi_id";
				rs = stmt.executeQuery(sql);

				if (rs.next()) {	// 해당 주문이 존재하면
					fdgOrd = new FdgOrderInfo();	// 주문 정보들을 저장할 인스턴스 생성
					fdgOrd.setFoi_id(foiid);							fdgOrd.setMi_id(miid);
					fdgOrd.setFoi_name(rs.getString("foi_name"));		fdgOrd.setFoi_phone(rs.getString("foi_phone"));
					fdgOrd.setFoi_zip(rs.getString("foi_zip"));			fdgOrd.setFoi_addr1(rs.getString("foi_addr1"));
					fdgOrd.setFoi_addr2(rs.getString("foi_addr2"));		fdgOrd.setFoi_memo(rs.getString("foi_memo"));
					fdgOrd.setFoi_pay(rs.getInt("foi_pay"));			fdgOrd.setFoi_status(rs.getString("foi_status"));
					fdgOrd.setFoi_date(rs.getString("foi_date"));
					// t_funding_order_info 테이블 내의 정보

					ArrayList<FdgOrderDetail> detailList = new ArrayList<FdgOrderDetail>();
					// 주문 내역의 상품정보들을 저장할 ArrayList 생성
					do {
						FdgOrderDetail detail = new FdgOrderDetail();	// OrderDetail 인스턴스 생성
						detail.setFi_id(rs.getString("fi_id"));			detail.setFod_cnt(rs.getInt("fod_cnt"));				
						detail.setFod_pname(rs.getString("fod_pname"));	detail.setFod_pimg(rs.getString("fod_pimg"));	
						detail.setFod_pprice(rs.getInt("fod_pprice"));
						
						detailList.add(detail);			// 통합전 수정
						
					} while (rs.next());
					
					fdgOrd.setFdgDetailList(detailList);
					// 주문내역의  상품정보들을 저장한 detailList를 OrderInfo형 인스턴스 fdgOrd에 저장
				}

			} catch(Exception e) {
				System.out.println("OrderDao 클래스의 getFdgOrderInfo() 메소드 오류");
				e.printStackTrace();
			} finally {
				close(rs);	close(stmt);	
			}

			return fdgOrd;
		}	
}
