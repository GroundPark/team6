package admin.act;

import javax.servlet.http.*;	// 이걸로 세션을 쓸 수 있음
import java.io.*;
import admin.svc.*;
import vo.*;

public class AdminFundStatAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AdminFundStatsInfo fstat = new AdminFundStatsInfo();
		// 기간별 통계에 필요한 데이터들을 저장 할 인스턴스
		
		request.setCharacterEncoding("utf-8");

		AdminFundStatSvc fundStatsSvc = new AdminFundStatSvc();
		fstat = fundStatsSvc.getFundStatsData();		
		
		request.setAttribute("fstat", fstat);
		// 생성한 인스턴스들을 request객체의 속성으로 저장하여 이동할 페이지로 가져감
		
		ActionForward forward = new ActionForward();
		forward.setPath("admin_fund_stats.jsp");	// 회원별 통계로 보냄
		
		return forward;
	}
}
