package order.act;

import javax.servlet.http.*;
import java.util.*;			
import java.io.*;			
import order.svc.*;
import vo.*;

public class OrderProcAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	// 앞에 public 붙여야 함. 오버라이딩. 접근제어지시자는 무조건 원본보다 같거나 커야함. 원본이 public임
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();	// 세션 생성 : 회원아이디가 필요하기 때문
		MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
		if (memberInfo == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 사용하세요.');");
			out.println("location.href='login_form.jsp';");
			out.println("</script>");
			out.close();			
		}

		int poi_pay = Integer.parseInt(request.getParameter("poipay"));		// 총 결제금액
		int poi_pnt = 0;
		if (request.getParameter("use_pnt") != null || !request.getParameter("use_pnt").equals(""))	
		poi_pnt = Integer.parseInt(request.getParameter("use_pnt"));	// 사용포인트
		
//		int savePnt = Integer.parseInt(request.getParameter("savePnt"));	// 구매포인트 - DB에 컬럼이 없어서 일단 제외
		int poi_delipay = Integer.parseInt(request.getParameter("delipay"));	// 배송비
		String poi_name = request.getParameter("poi_name");
		String poi_phone = request.getParameter("p1") + "-" + request.getParameter("p2") + "-" + request.getParameter("p3");
		String poi_zip = request.getParameter("poi_zip");
		String poi_addr1 = request.getParameter("poi_addr1");
		String poi_addr2 = request.getParameter("poi_addr2");
		String poi_payment = request.getParameter("poi_payment");
		String poi_status = "a";	// 주문 상태 : 배송대기중
		
		OrderInfo ord = new OrderInfo();	// 주문 관련 정보들을 저장할 OrderInfo형 인스턴스 생성
		ord.setMi_id(memberInfo.getMi_id());	ord.setPoi_name(poi_name);
		ord.setPoi_phone(poi_phone);			ord.setPoi_zip(poi_zip);
		ord.setPoi_addr1(poi_addr1);			ord.setPoi_addr2(poi_addr2);
		ord.setPoi_pay(poi_pay);				ord.setPoi_point(poi_pnt);
		ord.setPoi_payment(poi_payment);		ord.setPoi_status(poi_status);
		ord.setPoi_delipay(poi_delipay);
		
		String where = " and a.mi_id = '" + memberInfo.getMi_id() + "' ";	
		String pocidx = request.getParameter("pocidx");
		// 구매하려는 상품의 장바구니 인덱스 번호들		

		OrderProcSvc orderProcSvc = new OrderProcSvc();
		String result = "";
		
		if (!pocidx.equals("") && !pocidx.equals("0")) {	// pocidx가 빈 문자열이 아니면(구매하려는 상품을 선택했으면)			
			String[] arrPocidx = pocidx.split(",");
			String tmp = "";
			for (int i = 0; i < arrPocidx.length ; i++) {
				tmp += " or a.poc_idx = " + arrPocidx[i];
			}
			
			where += " and (" + tmp.substring(4) + ") " ;	// 장바구니에서 선택한 상품들만 추출하기 위한 where절

			result =  orderProcSvc.orderInsert(ord, where);
			
		} else if (pocidx.equals("0")) {					// 상품 바로 구매 시
			String piid = request.getParameter("piid");						// 선택한 상품 아이디
			int poccnt = Integer.parseInt(request.getParameter("poccnt"));	// 선택한 수량
			result =  orderProcSvc.directOrderInsert(ord, piid, poccnt);
		}
		
				
		// 작업 후 이동할 위치와 방법에 대해 지정하는 ActionForward 인스턴스 생성
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);	// 디스패쳐로 가면 양식 한번 더 제출해야 하므로 적합하지 않음
		forward.setPath("order_success.ord?poiid=" + result.substring(0, 12));	// 구매 완료 화면으로 이동(구매 내역을 보여주는 화면)
				
		return forward;
	}

}
