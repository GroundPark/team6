package admin.act;

import javax.servlet.http.*;
import java.util.*;
import vo.*;
import admin.svc.*;

public class AdminOrderFdgListAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ArrayList<FdgOrderInfo> fdgOrderList = new ArrayList<FdgOrderInfo>();
		int cpage = 1, psize = 10, bsize = 5, rcnt = 0, pcnt = 0, spage = 0, epage = 0;
		// 현재 페이지번호, 페이지크기, 블록크기, 게시글 개수, 페이지개수, 시작페이지, 종료페이지를 저장할 변수
		
		if (request.getParameter("cpage") != null)	cpage = Integer.parseInt(request.getParameter("cpage"));
		if (request.getParameter("psize") != null)	psize = Integer.parseInt(request.getParameter("psize"));
		
		String schtype = request.getParameter("schtype");	// 검색 타입(주문자, 주문번호, 주문상태)
		String keyword = request.getParameter("keyword");	// 검색어
		
		
		String where = "where 1=1 ";	// 쿼리의 where절을 저장할 변수
		
		if (!isEmpty(keyword)) {	// keyword(검색어)가 존재한다면
			if(schtype.equals("miid")) {				// 검색타입이 주문자 아이디일 경우
				where += " and mi_id like '%" + keyword + "%' ";
				
			} else if(schtype.equals("foiid")) {		// 검색타입이 주문번호일 경우
				where += " and foi_id like '%" + keyword + "%' ";
				
			} else if(schtype.equals("foistatus")) {	// 검색타입이 주문상태일 경우
				where += " and foi_status like '%" + keyword + "%' ";
				
			} 
		}	
		
		String sort = request.getParameter("sort");					// 정렬조건을 받아옴
		if(sort == null || sort.equals(""))		sort = "dated";		// 기본 정렬은 주문일 내림차순		
		
		String order = " order by foi_" + sort.substring(0, sort.length() - 1) 
			+ (sort.charAt(sort.length() - 1) == 'a' ? " asc" : " desc");
		
		AdminOrderFdgListSvc adminOrderFdgListSvc = new AdminOrderFdgListSvc();
		rcnt = adminOrderFdgListSvc.getOrderFdgCount(where);
		fdgOrderList = adminOrderFdgListSvc.getOrderFdgList(where, order, cpage, psize);
		
		pcnt = rcnt / psize;
		if (rcnt % psize > 0)	pcnt++;		
		spage = (cpage - 1) / bsize * bsize + 1;	
		epage = spage + bsize - 1;
		if(epage > pcnt) 	epage = pcnt;			
		
		AdminOrderFdgPageInfo adminOrderFdgPageInfo = new AdminOrderFdgPageInfo();
		adminOrderFdgPageInfo.setCpage(cpage);	adminOrderFdgPageInfo.setBsize(bsize);
		adminOrderFdgPageInfo.setEpage(epage);	adminOrderFdgPageInfo.setPcnt(pcnt);
		adminOrderFdgPageInfo.setPsize(psize);	adminOrderFdgPageInfo.setRcnt(rcnt);
		adminOrderFdgPageInfo.setSpage(spage);	adminOrderFdgPageInfo.setKeyword(keyword);
		adminOrderFdgPageInfo.setSort(sort);	adminOrderFdgPageInfo.setSchtype(schtype);
		
		
		request.setAttribute("adminOrderFdgPageInfo", adminOrderFdgPageInfo);
		request.setAttribute("fdgOrderList", fdgOrderList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_order_fdgList.jsp");
		
		return forward;
	}
	
	private boolean isEmpty(String str) {	
		boolean empty = true;
		if (str != null && !str.equals(""))	empty = false;
		return empty;
	}

}
