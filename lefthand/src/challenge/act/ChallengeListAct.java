package challenge.act;

import javax.servlet.http.*;
import challenge.vo.*;
import java.util.*;
import challenge.svc.*;
import java.io.*;
import java.net.*;

public class ChallengeListAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ArrayList<ChallengeInfo> challengeList = new ArrayList<ChallengeInfo>();
			
		int cpage = 1, psize = 12, bsize = 10, spage, epage, rcnt, pcnt;		
		if(request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		if(request.getParameter("psize") != null)
			psize = Integer.parseInt(request.getParameter("psize"));
		
		String keyword, cata, sprice, eprice;
		keyword = request.getParameter("keyword");		

		String where = " where ci_isview = 'y' ";
		if(!isEmpty(keyword))	where += " and ci_title like '%" + keyword + "%' ";
		else keyword = "";
		
		
		String sort = request.getParameter("sort");
		if(sort == null || sort.equals(""))		sort = "idxd";		
		
		String order = " order by ci_" + sort.substring(0, sort.length() - 1) 
			+ (sort.charAt(sort.length() - 1) == 'a' ? " asc" : " desc");
		
		ChallengeListSvc challengeListSvc = new ChallengeListSvc();
		rcnt = challengeListSvc.getChallengeCount(where);		
		
		challengeList = challengeListSvc.getChallengeList(where, order, cpage, psize);
		
		pcnt = rcnt / psize;
		if(rcnt % psize > 0)	pcnt++;				
		spage = (cpage - 1) / bsize * bsize + 1;	
		epage = spage + bsize - 1;
		if(epage > pcnt)	epage = pcnt;			
		
		ChallengePageInfo challengePageInfo = new ChallengePageInfo();
		challengePageInfo.setCpage(cpage);    challengePageInfo.setPsize(psize);        challengePageInfo.setBsize(bsize);
		challengePageInfo.setSpage(spage);    challengePageInfo.setEpage(epage);        challengePageInfo.setRcnt(rcnt);
		challengePageInfo.setPcnt(pcnt);      challengePageInfo.setKeyword(keyword);    challengePageInfo.setSort(sort);
		
        
        request.setAttribute("challengePageInfo", challengePageInfo);
        request.setAttribute("challengeList", challengeList);
        
        ActionForward forward = new ActionForward();
		forward.setPath("/page/challenge/chal_funding_list.jsp");
		
		return forward;
	}
	
	private boolean isEmpty(String str) {		
		boolean empty = true;
		if(str != null && !str.equals("")) empty = false;
		return empty;
	}
}