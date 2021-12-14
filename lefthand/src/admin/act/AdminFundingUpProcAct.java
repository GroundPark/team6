package admin.act;

import javax.servlet.http.*;
import vo.*;
import java.util.*;
import admin.svc.*;
import java.io.*;
import java.net.*;

public class AdminFundingUpProcAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("fiidx"));		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		
		String schtype = request.getParameter("schtype");	
		String keyword = request.getParameter("keyword");	
		
		String args ="?fiidx=" + idx + "&cpage=" + cpage ;
		if(schtype != null && keyword != null && !schtype.equals("") && !keyword.equals("")){
			args += "&schtype=" + schtype + "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
		}		// 조건은 있는 경우에만 쿼리스트링으로 연결시킴
		
		
		AdminFundingList adminFunding = new AdminFundingList();
		adminFunding.setFi_idx(idx);
		adminFunding.setFi_name(request.getParameter("fi_name"));
		adminFunding.setFi_desc(request.getParameter("fi_desc"));
		adminFunding.setFi_img1(request.getParameter("fi_img1"));
		adminFunding.setFi_img2(request.getParameter("fi_img2"));
		adminFunding.setFi_img3(request.getParameter("fi_img3"));
		adminFunding.setFi_price(Integer.parseInt(request.getParameter("fi_price")));
		adminFunding.setFi_goal(Integer.parseInt(request.getParameter("fi_goal")));
		adminFunding.setFi_sdate(request.getParameter("fi_sdate"));
		adminFunding.setFi_edate(request.getParameter("fi_edate"));
		adminFunding.setFi_isview(request.getParameter("fi_isview"));
		adminFunding.setFi_status(request.getParameter("fi_status"));
		
		 AdminFundingUpProcSvc adminFundingUpProcSvc = new  AdminFundingUpProcSvc();
		// DB를 제외한 비즈니스 로직을 처리하기 위한 인스턴스
		int result = adminFundingUpProcSvc.AdminFundingUpdate(adminFunding);
		
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
		forward.setPath("../admin/funding_list.admin" + args);
		
		return forward;
	}
}