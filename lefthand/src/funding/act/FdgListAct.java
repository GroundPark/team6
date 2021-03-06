package funding.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import funding.svc.*;
import vo.*;

import java.net.*;

public class FdgListAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ArrayList<FundingInfo> fdgList = new ArrayList<FundingInfo>();
			
		int cpage = 1, psize = 12, bsize = 10, spage, epage, rcnt, pcnt;		
		if(request.getParameter("cpage") != null)	cpage = Integer.parseInt(request.getParameter("cpage"));
		if(request.getParameter("psize") != null)	psize = Integer.parseInt(request.getParameter("psize"));
		
		String endate = request.getParameter("endate");

		String sedate = "";
		
		String where = " where fi_isview = 'y' ";
		
		if (endate == null || endate.equals("")) {
			 // sedate = "";
			where = " where fi_isview = 'y' ";
		} else if (endate == "y") {
			sedate = " and fi_status = 'a' ";
			where = " where fi_isview = 'y' " + sedate;
		} else {
			sedate = " and (fi_status = 'b' or fi_status = 'c') ";
			where = " where fi_isview = 'y' " + sedate;
		}
		
/*
		String keyword;
		keyword = request.getParameter("keyword");
		
		if(!isEmpty(keyword))	where += " and fi_name like '%" + keyword + "%' ";
		else keyword = "";
*/
		String sort = request.getParameter("sort");
		if(sort == null || sort.equals(""))		sort = "idd";		
		
		String order = " order by fi_" + sort.substring(0, sort.length() - 1) 
			+ (sort.charAt(sort.length() - 1) == 'a' ? " asc" : " desc");
		
		FdgListSvc fdgListSvc = new FdgListSvc();
		rcnt = fdgListSvc.getFdgCount(where);		
		
		fdgList = fdgListSvc.getFdgList(where, order, cpage, psize);
		
		pcnt = rcnt / psize;
		if(rcnt % psize > 0)	pcnt++;				
		spage = (cpage - 1) / bsize * bsize + 1;	
		epage = spage + bsize - 1;
		if(epage > pcnt)	epage = pcnt;			
		
		FdgPageInfo fdgPageInfo = new FdgPageInfo();
		fdgPageInfo.setCpage(cpage);    fdgPageInfo.setPsize(psize);        fdgPageInfo.setBsize(bsize);
		fdgPageInfo.setSpage(spage);    fdgPageInfo.setEpage(epage);        fdgPageInfo.setRcnt(rcnt);
		fdgPageInfo.setPcnt(pcnt);     	fdgPageInfo.setSort(sort);
        
        request.setAttribute("fdgPageInfo", fdgPageInfo);
        request.setAttribute("fdgList", fdgList);
        
        ActionForward forward = new ActionForward();
		forward.setPath("/page/funding/fdg_list.jsp");
		
		return forward;
	}
	
	private boolean isEmpty(String str) {		
		boolean empty = true;
		if(str != null && !str.equals("")) empty = false;
		return empty;
	}
}