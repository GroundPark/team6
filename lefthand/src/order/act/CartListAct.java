package order.act;

import javax.servlet.http.*;
import java.util.*;	
import java.io.*;
import order.svc.*;
import vo.*; 

public class CartListAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ArrayList<CartInfo> cartList = new ArrayList<CartInfo>();
System.out.println("cartListAct의 keyword : " + request.getParameter("keyword"));  // 여기부터 이상		
		HttpSession session = request.getSession();	// 세션 생성 : 그래야 장바구니에 올 수 있음
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
		
		CartListSvc cartListSvc = new CartListSvc();
		cartList = cartListSvc.getCartList(where);


		// 검색 조건들 및 정렬 기준 pdtPageInfo 인스턴스
		PdtPageInfo pdtPageInfo = new PdtPageInfo();
		if (request.getParameter("cpage") == null)	pdtPageInfo.setCpage(1);
		else	pdtPageInfo.setCpage(Integer.parseInt(request.getParameter("cpage")));	// 조건 검사 안하면 null일 경우 에러 발생함

		if (request.getParameter("psize") == null)	pdtPageInfo.setPsize(12);
		else	pdtPageInfo.setPsize(Integer.parseInt(request.getParameter("psize")));

		pdtPageInfo.setKeyword(request.getParameter("keyword"));	

		pdtPageInfo.setCata(request.getParameter("cata"));
		pdtPageInfo.setSort(request.getParameter("sort"));	
		
		request.setAttribute("pdtPageInfo", pdtPageInfo);
		request.setAttribute("cartList", cartList);
		
				
		// 작업 후 이동할 위치와 방법에 대해 지정하는 ActionForward 인스턴스 생성
		ActionForward forward = new ActionForward();
		forward.setPath("page/order/cart_list.jsp");	// 디스패치로 이동
				
		return forward;
	}

}
