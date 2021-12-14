package admin.act;

import javax.servlet.http.*;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminPdtViewAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String piid = request.getParameter("piid");	// 상품 아이디
		int cpage= Integer.parseInt(request.getParameter("cpage"));	// 페이지 번호
//		int psize= Integer.parseInt(request.getParameter("psize"));
		
		String schtype = request.getParameter("schtype");	if (schtype == null)	schtype = "";	
		String keyword	= request.getParameter("keyword");	if (keyword == null)	keyword = "";
//		String cata		= request.getParameter("cata");		if (cata == null)		cata = "";
		String sort 	= request.getParameter("sort");		if (sort == null)		sort ="idd";
		
		AdminPdtViewSvc adminPdtViewSvc = new AdminPdtViewSvc();
		ProductInfo pdtInfo = adminPdtViewSvc.getPdtInfo(piid);
		
//		ArrayList<PdtCata> cataList = adminPdtViewSvc.getCataList();
				
		AdminPdtPageInfo adminPdtPageInfo = new AdminPdtPageInfo();// 페이징에 필요한 정보들을 저장할 인스턴스
		adminPdtPageInfo.setCpage(cpage);		adminPdtPageInfo.setKeyword(keyword);	
		adminPdtPageInfo.setSort(sort);			
		adminPdtPageInfo.setSchtype(schtype);	
		
		request.setAttribute("adminPdtPageInfo", adminPdtPageInfo);
		request.setAttribute("pdtInfo", pdtInfo);
//		request.setAttribute("cataList", cataList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_pdt_view.jsp");

		return forward;
	}

	private boolean isEmpty(String str) {	// 문자열에 어떤 값이든 들어 있는지 여부를 검사하는 메소드
		boolean empty = true;
		if (str != null && !str.equals(""))	empty = false;
		return empty;
	}

}
