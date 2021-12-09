package admin.act;

import javax.servlet.http.*;
import vo.*;
import java.util.*;
import admin.svc.*;
import java.io.*;
import java.net.*;

public class AdminChallengeUpAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("ciidx"));		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		
		String schtype = request.getParameter("schtype");	
		String keyword = request.getParameter("keyword");	
		
		PageInfo pageInfo = new PageInfo();		// 페이징에 필요한 정보
		pageInfo.setCpage(cpage);
		// pageInfo.setSchtype(schtype);
		pageInfo.setKeyword(keyword);
		
		AdminChallengeUpSvc adminChallengeUpSvc = new AdminChallengeUpSvc();
		AdminChallengeList adminChallenge = adminChallengeUpSvc.getNoticeInfo(idx);
		
		
		if(adminChallenge == null) {		// 해당 게시글이 없으면
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();  			// jsp엔 자동으로 있는데 여기선 없음
			out.println("<script>");
			out.println("alert('존재하지 않는 게시글 입니다.');");		
			out.println("history.back();");
			out.println("</script>");
		}
		
		request.setAttribute("adminChallenge", adminChallenge);
		request.setAttribute("pageInfo", pageInfo);
				
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_chal_funding_up.jsp");
		// dispatch 방식으로 이동해야 request 객체를 이동할 파일로 넘길수 있어 request안에있는 속성들을 사용할 수 있음
		
		return forward;
	}
}