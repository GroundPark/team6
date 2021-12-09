package order.act;

import javax.servlet.http.*;
import java.util.*;				
import java.io.*;
import funding.svc.*;
import order.svc.*;
import vo.*;

public class FdgOrderFormAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
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
		
		int fiidx = Integer.parseInt(request.getParameter("fiidx"));	// 펀딩 인덱스 번호
		int ocnum = Integer.parseInt(request.getParameter("ocnum"));	// 구매할 펀딩 개수
		if (request.getParameter("ocnum") == null)	ocnum = 0;
				
		FdgViewSvc fdgViewSvc = new FdgViewSvc();
		FundingInfo fdgInfo = fdgViewSvc.getFdgInfo(fiidx, ocnum);
		
		OrderFormSvc orderFormSvc = new OrderFormSvc();
		addrList = orderFormSvc.getAddrList(memberInfo.getMi_id());

		request.setAttribute("fdgInfo", fdgInfo);
		request.setAttribute("addrList", addrList);
				
		// 작업 후 이동할 위치와 방법에 대해 지정하는 ActionForward 인스턴스 생성
		ActionForward forward = new ActionForward();
		forward.setPath("/page/order/fdg_order_form.jsp");	// 디스패치로 이동
				
		return forward;
	}

}
