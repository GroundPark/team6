package funding.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import funding.svc.*;
import vo.*;

public class FdgViewAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		int psize = Integer.parseInt(request.getParameter("psize"));
		// 펀딩보기에서 필수로 있어야 하는 값들이므로 검사없이 바로 int형으로 형변환 시킴
		int fiidx = Integer.parseInt(request.getParameter("fiidx"));
		int ocnum = 0;	// 펀딩 주문 시 필요한 값으로 여기서는 사용하지 않음
		String sort = request.getParameter("sort");		if (sort == null)		sort = "idd";

		FdgViewSvc fdgViewSvc = new FdgViewSvc();
		FundingInfo fdgInfo = fdgViewSvc.getFdgInfo(fiidx, ocnum);

		FdgPageInfo fdgPageInfo = new FdgPageInfo();// 페이징에 필요한 정보들을 저장할 인스턴스
		fdgPageInfo.setCpage(cpage);	fdgPageInfo.setPsize(psize);	fdgPageInfo.setSort(sort);

		request.setAttribute("fdgPageInfo", fdgPageInfo);
		request.setAttribute("fdgInfo", fdgInfo);
		// 생성한 인스턴스들을 request객체의 속성으로 저장하여 이동할 페이지로 가져감

		ActionForward forward = new ActionForward();
		forward.setPath("/page/funding/fdg_view.jsp");

		return forward;
	}

	private boolean isEmpty(String str) {	// 문자열에 어떤 값이든 들어 있는지 여부를 검사하는 메소드
		boolean empty = true;
		if (str != null && !str.equals(""))	empty = false;
		return empty;
	}
}
