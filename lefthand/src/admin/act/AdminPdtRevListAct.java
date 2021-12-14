package admin.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import admin.svc.*;
import vo.*;

public class AdminPdtRevListAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ArrayList<ReviewList> reviewList = new ArrayList<ReviewList>();
		int cpage = 1, psize = 10, bsize = 5, rcnt = 0, pcnt = 0, spage = 0, epage = 0;
		// 현재 페이지번호, 페이지크기, 블록크기, 게시글 개수, 페이지개수, 시작페이지, 종료페이지를 저장할 변수
		
//		int vcnt = 0;		// 댓글 게시여부 업데이트 결과를 저장할 변수
		
		if (request.getParameter("cpage") != null)	cpage = Integer.parseInt(request.getParameter("cpage"));
		if (request.getParameter("psize") != null)	psize = Integer.parseInt(request.getParameter("psize"));
				
		String piid = request.getParameter("piid");		
		String where = " where pi_id = '" + piid + "' " ;	// 쿼리의 where절을 저장할 변수
		
		String sort = request.getParameter("sort");
		if(sort == null || sort.equals(""))		sort = "idxd";		
		
		String order = " order by rl_" + sort.substring(0, sort.length() - 1)  + 
						(sort.charAt(sort.length() - 1) == 'a' ? " asc" : " desc");
		
//		System.out.println("rlidx::" + request.getParameter("rlidx"));
//		System.out.println("miid::" + request.getParameter("miid"));
//		System.out.println("view::" + request.getParameter("val"));
						
		AdminPdtRevListSvc adminPdtRevListSvc = new AdminPdtRevListSvc();
		rcnt = adminPdtRevListSvc.getReviewCount(where);
		reviewList = adminPdtRevListSvc.getReviewList(where, order, cpage, psize);
//		chview = adminPdtRevListSvc.setReview(rlidx, miid, view, piid);
		
		pcnt = rcnt / psize;
		if (rcnt % psize > 0)	pcnt++;		
		spage = (cpage - 1) / bsize * bsize + 1;	
		epage = spage + bsize - 1;
		if(epage > pcnt) 	epage = pcnt;			
		
		AdminPdtPageInfo adminPdtPageInfo = new AdminPdtPageInfo();
		adminPdtPageInfo.setCpage(cpage);	adminPdtPageInfo.setBsize(bsize);
		adminPdtPageInfo.setEpage(epage);	adminPdtPageInfo.setPcnt(pcnt);
		adminPdtPageInfo.setPsize(psize);	adminPdtPageInfo.setRcnt(rcnt);
		adminPdtPageInfo.setSpage(spage);	adminPdtPageInfo.setSort(sort);
					
		request.setAttribute("adminPdtPageInfo", adminPdtPageInfo);
		request.setAttribute("reviewList", reviewList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_pdt_revList.jsp");
		
		return forward;
	}
	
	private boolean isEmpty(String str) {	
		boolean empty = true;
		if (str != null && !str.equals(""))	empty = false;
		return empty;
	}	
}
