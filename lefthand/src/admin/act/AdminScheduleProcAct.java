package admin.act;

import javax.servlet.http.*;	// 이걸로 세션을 쓸 수 있음
import java.util.*;
import java.io.*;				// PrintWriter 쓸라고
import admin.svc.*;
import vo.*;

public class AdminScheduleProcAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	// 앞에 public 붙여야 함. 오버라이딩. 접근제어지시자는 무조건 원본보다 같거나 커야함. 원본이 public임
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();					// 세션 생성
		AdminInfo adminInfo = (AdminInfo)session.getAttribute("adminInfo");
		if (adminInfo == null) {
			response.setContentType("utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 사용하세요.');");
			out.println("location.href='admin_login.jsp';");
			out.println("</script>");
			out.close();
		}	// 폼에서 시간을 오래 끌면 로그인이 풀릴수도 있어서 검삭해야함
		
		
		
		AdminSchedule as = new AdminSchedule();					// 작업 처리에 필요한 정보들을 저장 할 인스턴스
		as.setAi_id(adminInfo.getAi_id());
		
		String wtype = request.getParameter("wtype");
		
		if (wtype.equals("in") || wtype.equals("up")) {
			as.setAs_stime(request.getParameter("stime"));
			as.setAs_content(request.getParameter("content"));
		}
		
		// else if가 아닌 이유는 up이 걸려서 
		
		if (wtype.equals("up") || wtype.equals("del")) {
			as.setAs_idx(Integer.parseInt(request.getParameter("as_idx")));
		}
		
		
		AdminScheduleProcSvc adminScheduleProcSvc = new AdminScheduleProcSvc();
		int result = adminScheduleProcSvc.scheduleProc(wtype, as); 
		
		// 작업 후 이동 할 위치와 방법에 대해 지정하는 ActionForward 인스턴스 생성
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);									// proc 작업 후 이동은 sendRedirect() 방식으로 이동
		forward.setPath("admin_mainPage.jsp");	
		
		return forward;
	}
}
		// * sendRedirect 방식은 request 객체를 공유하지 않음(dispatch는 request객체를 공유해서 setAttribute로 가져감)
