package order.act;

import javax.servlet.http.*;
import java.util.*;		
import java.io.*;
import order.svc.*;
import vo.*;

public class FdgOrderSuccessAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String foiid = request.getParameter("foiid");	// 쿼리스트링으로 주문번호를 받아옴

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if (foiid == null) {	// 보여줄 주문의 주문번호가 없을 경우
			out.println("<script> alert('잘못된 경로로 들어오셨습니다.'); history.back(); </script>");
			out.close();			
		}

		HttpSession session = request.getSession();	// 세션 생성 : 회원아이디가 필요하기 때문
		MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
		if (memberInfo == null) {
			out.println("<script> alert('로그인 후 사용하세요.'); location.href='login_form.jsp'; </script>");
			out.close();			
		}
		
		OrderSuccessSvc orderSuccessSvc = new OrderSuccessSvc();
		FdgOrderInfo fdgOrd = orderSuccessSvc.getFdgOrderInfo(memberInfo.getMi_id(), foiid);
		if (fdgOrd == null) {
			out.println("<script> alert('잘못된 경로로 들어오셨습니다.'); history.back(); </script>");
			out.close();			
		}
		
		request.setAttribute("fdgOrd", fdgOrd);	// 주문에 대한 정보들을 저장한 인스턴스를 request 객체의 속성으로 저장
		ActionForward forward = new ActionForward();	// 작업 후 이동할 위치와 방법에 대해 지정하는 ActionForward 인스턴스 생성
		forward.setPath("/page/order/fdg_order_success.jsp");	// 디스패치로 이동
				
		return forward;
	}

}
