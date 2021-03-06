package admin.act;

import javax.servlet.http.*;	// 이걸로 세션을 쓸 수 있음
import java.util.*;
import java.io.*;				// PrintWriter 쓸라고
import admin.svc.*;
import vo.*;

public class AdminScheduleFormAct implements Action {
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
		}
		
		int year, month, day, cYear, cMonth, cDay;
		Calendar sdate = Calendar.getInstance();					// 시작일
		cYear = sdate.get(Calendar.YEAR);							// 현재 연도
		cMonth = sdate.get(Calendar.MONTH) + 1;						// 현재 월
		cDay = sdate.get(Calendar.DATE);							// 현재 일
		
		if (request.getParameter("y") == null) {					// 검색할 연도와 월이 없으면
			year = cYear;	month = cMonth;		day = cDay;			// 현재 연도와 월, 일로 검색하게 함
			
			
		}else {														// 검색할 연도와 월이 있으면
			year = Integer.parseInt(request.getParameter("y"));		// 선택한 연도를 year에 넣음
			month = Integer.parseInt(request.getParameter("m"));	// 선택한 월을 month에 넣음
			day = Integer.parseInt(request.getParameter("d"));		// 선택한 일을 day에 넣음
		}
		
		
		
		AdminSchedule as = null;							 
							
		String wtype = request.getParameter("wtype");
		
		if(wtype.equals("up")) {	// 일정 수정일 경우(기존의 데이터를 가져가야 함)
			int as_idx = Integer.parseInt(request.getParameter("as_idx"));		// 수정 할 일정의 인덱스 번호
			AdminScheduleFormSvc adminScheduleFormSvc = new AdminScheduleFormSvc();
			as = adminScheduleFormSvc.getMemberSchedule(adminInfo.getAi_id(), as_idx);

			if (as != null) {		// 수정 할 일정의 데이터들을 받아 왔으면
				year = Integer.parseInt(as.getAs_stime().substring(0, 4));		 // as_stime이 char형이라 int로 형변환 하면서 받아야 함
				month = Integer.parseInt(as.getAs_stime().substring(5, 7));
				day = Integer.parseInt(as.getAs_stime().substring(8, 10));
				// 수정할 일정의 날짜로 변경
			} else {				// 수정 할 일정의 데이터들을 못받아 왔으면
				response.setContentType("utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('잘못된 경로로 들어오셨습니다.');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				
			}
		}
			
		AdminScheduleInfo si = new AdminScheduleInfo();						// 일정 관리의 달력에서 필요한 정보들을 저장 할 인스턴스
		si.setYear(year);			si.setMonth(month);			si.setDay(day);
		si.setcMonth(cMonth);		si.setcDay(cDay);			si.setcYear(cYear);
		// 검색 연도, 검색 월, 현재 연도, 현재 월, 현재 일 들을 si인스터스에 저장
		
		request.setAttribute("si", si);
		request.setAttribute("as", as);
			
		
		// 작업 후 이동 할 위치와 방법에 대해 지정하는 ActionForward 인스턴스 생성
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_schedule_form.jsp?wtype=" + wtype);	// dispatch방식으로 이동
		
		return forward;
	}
}
		// * sendRedirect 방식은 request 객체를 공유하지 않음(dispatch는 request객체를 공유해서 setAttribute로 가져감)

