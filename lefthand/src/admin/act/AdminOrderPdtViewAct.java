package admin.act;

import javax.servlet.http.*;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminOrderPdtViewAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String miid = request.getParameter("miid");	// 주문 아이디
		String poiid = request.getParameter("poiid");	// 주문 아이디
		int cpage= Integer.parseInt(request.getParameter("cpage"));	// 페이지 번호
		int psize= Integer.parseInt(request.getParameter("psize"));
		
		String schtype = request.getParameter("schtype");	if (schtype == null)	schtype = "";	
		String keyword	= request.getParameter("keyword");	if (keyword == null)	keyword = "";
		String sort 	= request.getParameter("sort");		if (sort == null)		sort ="dated";

		AdminOrderPdtViewSvc adminOrderPdtViewSvc = new AdminOrderPdtViewSvc();
		OrderInfo orderInfo = adminOrderPdtViewSvc.getOrderInfo(miid, poiid);
				
		AdminOrderPdtPageInfo adminOrderPdtPageInfo = new AdminOrderPdtPageInfo();// 페이징에 필요한 정보들을 저장할 인스턴스
		adminOrderPdtPageInfo.setCpage(cpage);		adminOrderPdtPageInfo.setPcnt(psize);	
		adminOrderPdtPageInfo.setSort(sort);		adminOrderPdtPageInfo.setKeyword(keyword);	
		adminOrderPdtPageInfo.setSchtype(schtype);	
				
		request.setAttribute("adminOrderPdtPageInfo", adminOrderPdtPageInfo);
		request.setAttribute("orderInfo", orderInfo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_order_pdt_view.jsp");

		return forward;
	}

	private boolean isEmpty(String str) {	// 문자열에 어떤 값이든 들어 있는지 여부를 검사하는 메소드
		boolean empty = true;
		if (str != null && !str.equals(""))	empty = false;
		return empty;
	}
	
}
