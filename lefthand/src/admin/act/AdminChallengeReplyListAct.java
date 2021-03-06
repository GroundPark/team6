package admin.act;

import javax.servlet.http.*;
import vo.*;
import java.util.*;
import admin.svc.*;
import java.io.*;
import java.net.*;

public class AdminChallengeReplyListAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ArrayList<AdminChallengeReplyList> adminChallengeReplyList = new ArrayList<AdminChallengeReplyList>();
			
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
			if(schtype.equals("ci_idx") && keyword != null && !keyword.equals("")) {
				where = " where " + schtype + " = " + keyword + " ";	
			}
		}
		
		
		
		
		// sort 필요없는데 귀찮아서 냅둠
		 String sort = request.getParameter("sort");
		 if(sort == null || sort.equals(""))		sort = "idxd";		
		
		String order = " order by cr_" + sort.substring(0, sort.length() - 1) 
		 	+ (sort.charAt(sort.length() - 1) == 'a' ? " asc" : " desc");
		
		AdminChallengeReplyListSvc adminChallengeReplyListSvc = new AdminChallengeReplyListSvc();
		rcnt = adminChallengeReplyListSvc.getAdminChallengeReplyCount(where);		
		
		adminChallengeReplyList = adminChallengeReplyListSvc.getAdminChallengeReplyList(where, order, cpage, psize);
		
		pcnt = rcnt / psize;
		if(rcnt % psize > 0)	pcnt++;				
		spage = (cpage - 1) / bsize * bsize + 1;	
		epage = spage + bsize - 1;
		if(epage > pcnt)	epage = pcnt;			
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCpage(cpage);    pageInfo.setPsize(psize);        pageInfo.setBsize(bsize);
		pageInfo.setSpage(spage);    pageInfo.setEpage(epage);        pageInfo.setRcnt(rcnt);
		pageInfo.setPcnt(pcnt);      pageInfo.setSort(sort);		  pageInfo.setSchtype(schtype);
		pageInfo.setKeyword(keyword);
		
        
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("adminChallengeList", adminChallengeReplyList);
        
        ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_chal_funding_reply_list.jsp");
		
		return forward;
	}
	
	
	private boolean isEmpty(String str) {		
		boolean empty = true;
		if(str != null && !str.equals("")) empty = false;
		return empty;
	}
}