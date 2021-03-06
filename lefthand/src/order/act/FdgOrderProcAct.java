package order.act;

import javax.servlet.http.*;
import java.util.*;	
import java.io.*;	
import order.svc.*;
import vo.*;

public class FdgOrderProcAct implements Action {
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

		int foi_pay = Integer.parseInt(request.getParameter("total"));
		int fi_idx = Integer.parseInt(request.getParameter("fiidx"));
		int ocnum = Integer.parseInt(request.getParameter("ocnum"));
		String foi_name = request.getParameter("foi_name");
		String foi_phone = request.getParameter("p1") + "-" + request.getParameter("p2") + "-" + request.getParameter("p3");
		String foi_zip = request.getParameter("foi_zip");
		String foi_addr1 = request.getParameter("foi_addr1");
		String foi_addr2 = request.getParameter("foi_addr2");
		String foi_status = "b";	// 주문 상태 : 결제완료
		
		FdgOrderInfo fdgOrd = new FdgOrderInfo();	// 주문 관련 정보들을 저장할 FdgOrderInfo형 인스턴스 생성
		fdgOrd.setMi_id(memberInfo.getMi_id());	fdgOrd.setFoi_name(foi_name);
		fdgOrd.setFoi_phone(foi_phone);			fdgOrd.setFoi_zip(foi_zip);
		fdgOrd.setFoi_addr1(foi_addr1);			fdgOrd.setFoi_addr2(foi_addr2);
		fdgOrd.setFoi_pay(foi_pay);				fdgOrd.setFoi_status(foi_status);
		
		String where = " and fi_idx = " + fi_idx;
		
		FdgOrderProcSvc fdgOrderProcSvc = new FdgOrderProcSvc();
		String result =  fdgOrderProcSvc.fdgOrderInsert(fdgOrd, where, ocnum);
				
		// 작업 후 이동할 위치와 방법에 대해 지정하는 ActionForward 인스턴스 생성
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);	// 디스패쳐로 가면 양식 한번 더 제출해야 하므로 적합하지 않음
		forward.setPath("fdg_order_success.ord?foiid=" + result.substring(0, 12));	// 구매 완료 화면으로 이동(구매 내역을 보여주는 화면)
				
		return forward;
	}

}
