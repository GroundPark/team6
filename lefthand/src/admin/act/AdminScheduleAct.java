package admin.act;

import javax.servlet.http.*;	// 이걸로 세션을 쓸 수 있음
import java.util.*;
import java.io.*;				// PrintWriter 쓸라고
import admin.svc.*;
import vo.*;

public class AdminScheduleAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	// 앞에 public 붙여야 함. 오버라이딩. 접근제어지시자는 무조건 원본보다 같거나 커야함. 원본이 public임
		request.setCharacterEncoding("utf-8");
		
		ArrayList<AdminSchedule> scheduleList = new ArrayList<AdminSchedule>();
		// 해당 연월에 저장되어 있는 일정들을 저장할 ArrayList<AdminSchedule>
		
		HttpSession session = request.getSession();					// 세션 생성
		AdminInfo adminInfo = (AdminInfo)session.getAttribute("adminInfo");
		if (adminInfo == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 사용하세요.');");
			out.println("location.href='admin_login.jsp';");
			out.println("</script>");
			out.close();
		}
		
		int year, month, cYear, cMonth, cDay;
		Calendar sdate = Calendar.getInstance();			// 시작일
		cYear = sdate.get(Calendar.YEAR);					// 현재 연도
		cMonth = sdate.get(Calendar.MONTH) + 1;				// 현재 월
		cDay = sdate.get(Calendar.DATE);					// 현재 일
		
		if (request.getParameter("y") == null) {			// 검색할 연도와 월이 없으면
			year = cYear;			month = cMonth;			// 현재 연도와 월로 검색하게 함
			
		}else {														// 검색할 연도와 월이 있으면
			year = Integer.parseInt(request.getParameter("y"));		// 선택한 연도를 year에 넣음
			month = Integer.parseInt(request.getParameter("m"));	// 선택한 월을 month에 넣음
		}
				
		AdminScheduleInfo si = new AdminScheduleInfo();				// 일정 관리의 달력에서 필요한 정보들을 저장 할 인스턴스
		si.setYear(year);			si.setMonth(month);			si.setcYear(cYear);
		si.setcMonth(cMonth);		si.setcDay(cDay);
		// 검색 연도, 검색 월, 현재 연도, 현재 월, 현재 일 들을 si인스터스에 저장
		
		AdminScheduleSvc adminScheduleSvc = new AdminScheduleSvc();		  
		scheduleList = adminScheduleSvc.getScheduleList(adminInfo.getAi_id(), year, month);		// div에 창을 띄울 때 필요함	
													// where절에서 사용 할 값들을 가져가는것
		
		
		request.setAttribute("si", si);
		request.setAttribute("scheduleList", scheduleList); // 일정을 가지고 있는 인스턴스		12.06추가
		
		// 작업 후 이동 할 위치와 방법에 대해 지정하는 ActionForward 인스턴스 생성
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_schedule.jsp");	// dispatch방식으로 이동
		
		return forward;
	}
}
		// * sendRedirect 방식은 request 객체를 공유하지 않음(dispatch는 request객체를 공유해서 setAttribute로 가져감)
