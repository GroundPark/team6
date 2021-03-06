package admin.act;

import javax.servlet.http.*;
import vo.*;
import java.util.*;
import admin.svc.*;
import java.io.*;
import java.net.*;

public class AdminChallengeReplyUpProcAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");

		int cridx = Integer.parseInt(request.getParameter("cridx"));
		int ciidx = Integer.parseInt(request.getParameter("ciidx"));
		String miid = request.getParameter("miid");
		String view = request.getParameter("view");
		
		AdminChallengeReplyListUpSvc adminChallengeReplyListUpSvc = new AdminChallengeReplyListUpSvc();
		int vcnt = adminChallengeReplyListUpSvc.setReply(cridx, ciidx, miid, view);
		
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);			// sendredirect로... dispatch로 가면 새로고침하면 또 실행되니까 
		forward.setPath("../admin/chal_manage_reply.admin");
		
		return forward;
	}
}