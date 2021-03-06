package admin.act;

import javax.servlet.http.*;
import vo.*;

import java.util.*;
import admin.svc.*;

public class AdminChallengeListAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ArrayList<AdminChallengeList> adminChallengeList = new ArrayList<AdminChallengeList>();
			
		int cpage = 1, psize = 10, bsize = 10, spage, epage, rcnt, pcnt;		
		if(request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		if(request.getParameter("psize") != null)
			psize = Integer.parseInt(request.getParameter("psize"));
		
		String keyword;		
		keyword = request.getParameter("keyword");		
		
		String schtype = request.getParameter("schtype");
		
		String where = "";	
		if(keyword != null && !keyword.equals("")) {		// keyword(검색어)가 존재한다면... 
			// 검사순서는 이거그냥 쓰셈 아니면 익셉션뜸;먼저나오면 null.equals("")...		
				where = " where " + schtype + " like '%" + keyword + "%' ";		
		}
		
		
		String sort = request.getParameter("sort");
		String sort2 = "";

		if(sort == null || sort.equals("") || sort.equals("idx")) {
			sort = " ci_idx desc ";
			sort2 = "idx";
		}else if(sort.equals("edatea")) {
			sort = " ci_edate asc ";
			sort2 = "edatea";
		}else if(sort.equals("edated")) {
			sort = " ci_edate desc ";
			sort2 = "edated";
		}else if(sort.equals("status")) {
			sort = " ci_status desc ";
			sort2 = "status";
		}

		String order = " order by " + sort;
		
		
		AdminChallengeListSvc adminChallengeListSvc = new AdminChallengeListSvc();
		rcnt = adminChallengeListSvc.getAdminChallengeCount(where);		
		
		adminChallengeList = adminChallengeListSvc.getAdminChallengeList(where, order, cpage, psize);
		
		pcnt = rcnt / psize;
		if(rcnt % psize > 0)	pcnt++;				
		spage = (cpage - 1) / bsize * bsize + 1;	
		epage = spage + bsize - 1;
		if(epage > pcnt)	epage = pcnt;			
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCpage(cpage);    pageInfo.setPsize(psize);        pageInfo.setBsize(bsize);
		pageInfo.setSpage(spage);    pageInfo.setEpage(epage);        pageInfo.setRcnt(rcnt);
		pageInfo.setPcnt(pcnt);      pageInfo.setSort(sort2);		  pageInfo.setSchtype(schtype);
		pageInfo.setKeyword(keyword);
		
        
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("adminChallengeList", adminChallengeList);
        
        ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_chal_funding_list.jsp");
		
		return forward;
	}
	
	private boolean isEmpty(String str) {		
		boolean empty = true;
		if(str != null && !str.equals("")) empty = false;
		return empty;
	}
	
}