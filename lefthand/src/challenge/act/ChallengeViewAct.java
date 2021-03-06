package challenge.act;

import javax.servlet.http.*;
import 	vo.*;
import java.util.*;
import challenge.svc.*;
import java.io.*;
import java.net.*;

public class ChallengeViewAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		
		int idx = Integer.parseInt(request.getParameter("ciidx"));		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		
		 ArrayList<ChallengeReplyList> challengeReplyList = new ArrayList<ChallengeReplyList>();
		
		// String schtype = request.getParameter("schtype");	// 검색조건
		// String keyword = request.getParameter("keyword");	// 검색어
		
		// String args ="?idx=" + idx + "&cpage=" + cpage ;
		
		String sort = request.getParameter("sort");			if(sort == null)		sort = "idxd";
		
		ChallengePageInfo challengePageInfo = new ChallengePageInfo();		// 페이징에 필요한 정보를 저장할 인스턴스 생성
		challengePageInfo.setCpage(cpage);
		// challengePageInfo.setSchtype(schtype);
		// challengePageInfo.setKeyword(keyword);
		// 300페이지에서 보고있다던가 검색하고 몇개 보는데, 리스트 다시 갔는데 1페이지로 가면 사용자가 빡치니까 가져옴
		
		
		
		
		
		ChallengeViewSvc challengeViewSvc = new ChallengeViewSvc();	
		ChallengeInfo challengeDetail = challengeViewSvc.getChallengeDetail(idx);
		if(challengeDetail == null) {		// 해당 게시글이 없으면
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();  			// jsp엔 자동으로 있는데 여기선 없음
			out.println("<script>");
			out.println("alert('존재하지 않는 게시글 입니다.');");		
			out.println("history.back();");
			out.println("</script>");
		}
		
		
		HttpSession session = request.getSession();
		MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
		
		if(memberInfo == null) {		// 해당 게시글이 없으면
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();  			// jsp엔 자동으로 있는데 여기선 없음
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");		
			out.println("location.href='login_form.jsp';");
			out.println("</script>");
		}
		
		
		
		String miid = memberInfo.getMi_id();
		
	
        
        ChallengeGoodSvc challengeGoodableSvc = new ChallengeGoodSvc();
        ChallengeGoodable goodable = challengeGoodableSvc.getChallengeGoodable(idx, miid);	
        
        // System.out.println(goodable); 
        request.setAttribute("goodable", goodable);
        
        
		
		
		challengeReplyList = challengeViewSvc.getChallengeDetailReplyList(idx);
		//ChallengeReplyList challengeReply = challengeViewSvc.getChallengeDetailReplyList(idx);
		
		
		challengePageInfo.setCpage(cpage);                    
		challengePageInfo.setSort(sort);
		// challengePageInfo.setPsize(psize); 	
		
		// request.setAttribute("challenge", challenge);
		request.setAttribute("challengePageInfo", challengePageInfo);
		request.setAttribute("challengeDetail", challengeDetail);
		// request.setAttribute("challengeReply", challengeReply);
		request.setAttribute("challengeReplyList", challengeReplyList);
		// view로 가져갈 인스턴스를 request 객체의 attribute으로 저장함
		
		ActionForward forward = new ActionForward();
		forward.setPath("/page/challenge/chal_funding_view.jsp");

		
		return forward;
	}
}