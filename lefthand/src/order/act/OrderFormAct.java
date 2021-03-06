package order.act;

import javax.servlet.http.*;
import java.util.*;			
import java.io.*;
import order.svc.*;
import vo.*;

public class OrderFormAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	// 앞에 public 붙여야 함. 오버라이딩. 접근제어지시자는 무조건 원본보다 같거나 커야함. 원본이 public임
		request.setCharacterEncoding("utf-8");
		ArrayList<CartInfo> orderPdtList = new ArrayList<CartInfo>();	// 구매할 상품 목록을 저장할 ArrayList
		ArrayList<MemberAddr> addrList = new ArrayList<MemberAddr>();	// 회원의 주소 목록을 저장할 ArrayList
		
		HttpSession session = request.getSession();	// 세션 생성 
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
		
		String where = " and a.mi_id = '" + memberInfo.getMi_id() + "' ";
		String pocidx = request.getParameter("pocidx");
		// 구매하려는 상품의 장바구니 인덱스 번호들(pocidx의 값이 빈 문자열일 경우[전체 구매]로 취급하면 됨)
		
		String lnk = "";	// 이동할 경로
		OrderFormSvc orderFormSvc = new OrderFormSvc();
		
		if (!pocidx.equals("") && !pocidx.equals("0")) {	// pocidx가 빈 문자열이 아니면(장바구니에서 구매하려는 상품을 선택했으면)			
			String[] arrPocidx = pocidx.split(",");
			String tmp = "";
			for (int i = 0; i < arrPocidx.length ; i++) {
				tmp += " or a.poc_idx = " + arrPocidx[i];
			}
			where += " and (" + tmp.substring(4) + ") " ;	// 장바구니에서 선택한 상품들만 추출하기 위한 where절

			orderPdtList = orderFormSvc.getOrderPdtList(where);
			
			lnk = "/page/order/pdt_order_form.jsp";
			
		} else if (pocidx.equals("0")) {	// 상품 바로 구매 시
			String piid = request.getParameter("piid");						// 선택한 상품 아이디
			int poccnt = Integer.parseInt(request.getParameter("poccnt"));	// 선택한 수량
			
			orderPdtList = orderFormSvc.getDirectOrderPdtList(piid, poccnt, memberInfo.getMi_id());	
			
			lnk = "/page/order/direct_pdt_order_form.jsp";		
		}else if (pocidx.equals("")) {      // 상품 전체 구매 시
	         orderPdtList = orderFormSvc.getOrderPdtList(where);
	         
	         lnk = "/page/order/pdt_order_form.jsp";
	         
	      }
		
		addrList = orderFormSvc.getAddrList(memberInfo.getMi_id());
	
		request.setAttribute("orderPdtList", orderPdtList);
		request.setAttribute("addrList", addrList);
				
		// 작업 후 이동할 위치와 방법에 대해 지정하는 ActionForward 인스턴스 생성
		ActionForward forward = new ActionForward();
		forward.setPath(lnk);	// 디스패치로 이동
				
		return forward;
	}

}
