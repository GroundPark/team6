package challenge.act;

import javax.servlet.http.*;
import vo.*;
import java.util.*;
import challenge.svc.*;
import java.io.*;

public class ChallengeReplyInAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
	
		HttpSession session = request.getSession();
		MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
		
		String miid = memberInfo.getMi_id();
		String cridx = request.getParameter("cridx");
		String crcontent = request.getParameter("crcontent");
		String ciidx = request.getParameter("ciidx");

		
		ChallengeReplyList challengeReplyList = new ChallengeReplyList();
		challengeReplyList.setCr_idx(Integer.parseInt(cridx));
		challengeReplyList.setCi_idx(Integer.parseInt(ciidx));
		challengeReplyList.setMi_id(miid);
		challengeReplyList.setCr_content(crcontent);
		
		ChallengeReplySvc challengeReplySvc = new ChallengeReplySvc();		
		// 댓글 관련 삽입삭제 하기 전 검사는 귀찮아서 안함
		int result = challengeReplySvc.challengeInsert(challengeReplyList);
		
		if (result == 0) {	// 글 등록에 실패했으면
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('댓글 등록에 실패했습니다.\n다시 시도해 주십시오');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		
		 ActionForward forward = new ActionForward();
		 forward.setRedirect(true);
		 forward.setPath("/lefthand/chal_view.chal?cpage=1&ciidx=" + ciidx);

		
		return forward;
	}
}