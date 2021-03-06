package admin.act;

import javax.servlet.http.*;
import vo.*;

import java.util.*;
import admin.svc.*;

public class AdminFundingListAct implements Action {
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ArrayList<AdminFundingList> adminFundingList = new ArrayList<AdminFundingList>();
			
		int cpage = 1, psize = 10, bsize = 10, spage, epage, rcnt, pcnt;		
		if(request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		// if(request.getParameter("psize") != null)
		//	psize = Integer.parseInt(request.getParameter("psize"));
		
		// String keyword;
		// keyword = request.getParameter("keyword");		
		
		 String where = " ";	// 전부 다보임
		// if(!isEmpty(keyword))	where += " and ci_title like '%" + keyword + "%' ";
		// else keyword = "";
		
		String sort = request.getParameter("sort");
		if(sort == null || sort.equals(""))		sort = "idxd";		
		
		String order = " order by ci_" + sort.substring(0, sort.length() - 1) 
			+ (sort.charAt(sort.length() - 1) == 'a' ? " asc" : " desc");
		
		AdminFundingListSvc adminFundingListSvc = new AdminFundingListSvc();
		rcnt = adminFundingListSvc.getAdminFundingCount(where);		
		
		adminFundingList = adminFundingListSvc.getAdminFundingList(where, order, cpage, psize);
		
		pcnt = rcnt / psize;
		if(rcnt % psize > 0)	pcnt++;				
		spage = (cpage - 1) / bsize * bsize + 1;	
		epage = spage + bsize - 1;
		if(epage > pcnt)	epage = pcnt;			
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCpage(cpage);    pageInfo.setPsize(psize);        pageInfo.setBsize(bsize);
		pageInfo.setSpage(spage);    pageInfo.setEpage(epage);        pageInfo.setRcnt(rcnt);
		pageInfo.setPcnt(pcnt);      pageInfo.setSort(sort);
		// challengePageInfo.setKeyword(keyword);
		
        
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("adminFundingList", adminFundingList);
        
        ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_funding_list.jsp");
		
		return forward;
	}
	
}