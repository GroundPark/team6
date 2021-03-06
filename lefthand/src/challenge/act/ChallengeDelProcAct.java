package challenge.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import challenge.svc.*;
import vo.*;

public class ChallengeDelProcAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("ciidx"));		
		
		
		ChallengeDelProcSvc challengeDelProcSvc = new ChallengeDelProcSvc();
		
		int result = challengeDelProcSvc.challengeDelete(idx);
		
		if (result == 0) {	// 글 삭제에 실패했으면
			response.setContentType("test/html; charset=utf-8");	
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글 삭제에 실패했습니다.\n다시 시도해 주십시오');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("/lefthand/chal_list.chal");
		
		return forward;
	}
}
