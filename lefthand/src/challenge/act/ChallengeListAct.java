package challenge.act;

import javax.servlet.http.*;
import vo.*;
import java.util.*;
import challenge.svc.*;
import java.io.*;
import java.net.*;

public class ChallengeListAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ArrayList<ChallengeList> challengeList = new ArrayList<ChallengeList>();
			
		int cpage = 1, psize = 12, bsize = 10, spage, epage, rcnt, pcnt;		
		if(request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		
		 if(request.getParameter("psize") != null)
			psize = Integer.parseInt(request.getParameter("psize"));
		
		 String keyword;
		 keyword = request.getParameter("keyword");		
		 // String schtype = request.getParameter("schtype");

		 
		 
		 
		 
		 String where = " where ci_isview = 'y' ";
		 
		 if(!isEmpty(keyword)) {
			 where += " and ci_title like '%" + keyword + "%' ";
		 }else {
			 keyword = "";
		 }
		 
		 
		String classify = request.getParameter("classify");	

		if(classify == null || classify.equals("") || classify.equals("chal_all")) {
			where += " ";
			classify = "chal_all";
		}else if(classify.equals("chal_step1")) {
			where += " and ci_step = 1 ";
		}else if(classify.equals("chal_step2")) {
			where += " and ci_step = 2 ";
		}else if(classify.equals("chal_stc")) {
			where += " and ci_status = 'c' ";
		}else if(classify.equals("chal_stb")) {
			where += " and ci_status = 'b' ";
		}

		 
		String sort = request.getParameter("sort");
		String sort2 = "";
		

		if(sort == null || sort.equals("") || sort.equals("chal_idxd")) {
			sort = " ci_idx desc ";
			sort2 = "chal_idxd";
		}else if(sort.equals("chal_goodd")) {
			sort = " ci_good desc ";
			sort2 = "chal_goodd";
		}else if(sort.equals("chal_edated")) {
			sort = " ci_edate desc ";
			sort2 = "chal_edated";
		}

		String order = " order by " + sort;
		 
	
		
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
		challengePageInfo.setPcnt(pcnt);      challengePageInfo.setSort(sort2);			
		
		challengePageInfo.setClassify(classify);
		challengePageInfo.setKeyword(keyword);
		    
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