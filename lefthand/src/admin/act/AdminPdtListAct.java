package admin.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import admin.svc.*;
import vo.*;

public class AdminPdtListAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();
		int cpage = 1, psize = 10, bsize = 5, rcnt = 0, pcnt = 0, spage = 0, epage = 0;
		// 현재 페이지번호, 페이지크기, 블록크기, 게시글 개수, 페이지개수, 시작페이지, 종료페이지를 저장할 변수
		
		if (request.getParameter("cpage") != null)	cpage = Integer.parseInt(request.getParameter("cpage"));
		if (request.getParameter("psize") != null)	psize = Integer.parseInt(request.getParameter("psize"));
		
		String schtype = request.getParameter("schtype");		
		String cata = request.getParameter("cate");
		String keyword = request.getParameter("keyword");	// 검색어(카테고리,상품ID,상품명,게시여부)
		
		
		String where = " where a.pc_id = b.pc_id ";	// 쿼리의 where절을 저장할 변수
		
		if (keyword != null && !keyword.equals("")) {		// keyword(검색어)가 존재한다면
		if(schtype.equals("cate")) {
			where += " and b.pc_name like '%" + keyword + "%' ";
		}		
		if(schtype.equals("id")) {
			where += " and a.pi_id like '%" + keyword + "%' ";
		}		
		if(schtype.equals("name")) {
			where += " and a.pi_name like '%" + keyword + "%' ";
		}		
		if(schtype.equals("isview")) {
			where += " and a.pi_isview like '%" + keyword + "%' ";
		}
	}	
		
		String sort = request.getParameter("sort");
		if(sort == null || sort.equals(""))		sort = "ida";		
		
		String order = " order by pi_" + sort.substring(0, sort.length() - 1) 
			+ (sort.charAt(sort.length() - 1) == 'a' ? " asc" : " desc");
		
		AdminPdtListSvc adminPdtListSvc = new AdminPdtListSvc();
		rcnt = adminPdtListSvc.getPdtCount(where);
		pdtList = adminPdtListSvc.getPdtList(where, order,cpage, psize);
		
		pcnt = rcnt / psize;
		if (rcnt % psize > 0)	pcnt++;		
		spage = (cpage - 1) / bsize * bsize + 1;	
		epage = spage + bsize - 1;
		if(epage > pcnt) 	epage = pcnt;			
		
		AdminPdtPageInfo adminpdtPageInfo = new AdminPdtPageInfo();
		adminpdtPageInfo.setCpage(cpage);	adminpdtPageInfo.setBsize(bsize);
		adminpdtPageInfo.setEpage(epage);	adminpdtPageInfo.setPcnt(pcnt);
		adminpdtPageInfo.setPsize(psize);	adminpdtPageInfo.setRcnt(rcnt);
		adminpdtPageInfo.setSpage(spage);	adminpdtPageInfo.setKeyword(keyword);
		adminpdtPageInfo.setCata(cata);			
		adminpdtPageInfo.setSort(sort);		adminpdtPageInfo.setSchtype(schtype);
		
		ArrayList<PdtCata> cataList = adminPdtListSvc.getCataList();
		
		request.setAttribute("adminpdtPageInfo", adminpdtPageInfo);
		request.setAttribute("pdtList", pdtList);
        request.setAttribute("cataList", cataList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_pdtList.jsp");
		
		return forward;
	}
	
	private boolean isEmpty(String str) {	
		boolean empty = true;
		if (str != null && !str.equals(""))	empty = false;
		return empty;
	}	
}

