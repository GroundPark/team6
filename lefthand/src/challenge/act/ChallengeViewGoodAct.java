package challenge.act;

import javax.servlet.http.*;
import vo.*;
import java.io.PrintWriter;
import java.util.*;
import challenge.svc.*;

public class ChallengeViewGoodAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		
		int idx = Integer.parseInt(request.getParameter("ci_idx"));	
		// 좋아요용 idx : 헷갈림 주의!!		
		
		int cpage = 1;
		if(request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		
		int cg_history = Integer.parseInt(request.getParameter("cg_history"));
		// ajax 데이터

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
		
		
        
     
		
		// ArrayList<ChallengeReplyList> challengeReplyList = new ArrayList<ChallengeReplyList>();
		
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
		// ! ci_good 개수를 위함
		
		if(challengeDetail == null) {		// 해당 게시글이 없으면
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();  			// jsp엔 자동으로 있는데 여기선 없음
			out.println("<script>");
			out.println("alert('존재하지 않는 게시글 입니다.');");		
			out.println("history.back();");
			out.println("</script>");
		}
		
		// ! 복붙의 폐혜... 1개만 가져오면 되는데 일단은 list로 먼저 하고 나중에 수정하던가 하겠음 
		ChallengeGoodList challengeGoodList = new ChallengeGoodList();
		// challengeGoodList.setCg_idx();
		challengeGoodList.setCi_idx(idx);
		challengeGoodList.setMi_id(miid);
		challengeGoodList.setCg_history(cg_history);
		
		
	    ChallengeGoodSvc challengeGoodableSvc = new ChallengeGoodSvc();
	    ChallengeGoodable goodable = challengeGoodableSvc.getChallengeGoodable(idx, miid);	
        
        request.setAttribute("goodable", goodable);
			
		
		
		ChallengeGoodSvc challengeGoodSvc = new ChallengeGoodSvc();		
		int result = challengeGoodSvc.challengeGoodInsert(challengeGoodList);
		
		
		
		challengePageInfo.setCpage(cpage);                    
		challengePageInfo.setSort(sort);
		// challengePageInfo.setPsize(psize); 	

		request.setAttribute("challengePageInfo", challengePageInfo);
		// request.setAttribute("challengeDetail", challengeDetail);
		 request.setAttribute("challengeGoodList", challengeGoodList);
		
		 ActionForward forward = new ActionForward();
		 forward.setRedirect(true);
		 forward.setPath("/lefthand/chal_view.chal?cpage=" + cpage + "&ciidx=" + idx + "&sort=" +sort );
		// 여기에서는 리스트 전용임에 주의

		
		return forward;
	}
}