package admin.act;

import javax.servlet.http.*;
import vo.*;
import java.util.*;
import admin.svc.*;
import java.io.*;
import java.net.*;

public class AdminChallengeUpProcAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("ciidx"));		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		
		String schtype = request.getParameter("schtype");	
		String keyword = request.getParameter("keyword");	
		
		String args ="?ciidx=" + idx + "&cpage=" + cpage ;
		if(schtype != null && keyword != null && !schtype.equals("") && !keyword.equals("")){
			args += "&schtype=" + schtype + "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
		}		// 조건은 있는 경우에만 쿼리스트링으로 연결시킴
		
		
		AdminChallengeList adminChallenge = new AdminChallengeList();
		adminChallenge.setCi_idx(idx);
		adminChallenge.setCi_step(Integer.parseInt(request.getParameter("ci_step")));
		adminChallenge.setCi_title(request.getParameter("ci_title").trim().replace("'", "''"));
		adminChallenge.setCi_content(request.getParameter("ci_content"));
		adminChallenge.setCi_isview(request.getParameter("ci_isview"));
		adminChallenge.setCi_good(Integer.parseInt(request.getParameter("ci_good")));
		adminChallenge.setCi_status(request.getParameter("ci_status"));
		
		 AdminChallengeUpProcSvc adminChallengeUpProcSvc = new  AdminChallengeUpProcSvc();
		// DB를 제외한 비즈니스 로직을 처리하기 위한 인스턴스
		int result = adminChallengeUpProcSvc.AdminChallengeUpdate(adminChallenge);
		
		if (result == 0) {	
			response.setContentType("test/html; charset=utf-8");	
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글 수정에 실패했습니다.\n다시 시도해 주십시오');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);			// sendredirect로... dispatch로 가면 새로고침하면 또 실행되니까 
		forward.setPath("../admin/chal_list.admin" + args);
		
		return forward;
	}
}