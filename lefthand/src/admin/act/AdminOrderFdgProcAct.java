package admin.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;				
import vo.*;
import admin.svc.*;

public class AdminOrderFdgProcAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();	
		AdminInfo adminInfo = (AdminInfo)session.getAttribute("adminInfo");
		if (adminInfo == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('로그인 후 사용하세요.'); location.href='admin_login.jsp?url=order_fdg_view.adminord'; </script>");
			out.close();			
		}
		
		FdgOrderInfo ord = new FdgOrderInfo();
		
		ord.setFoi_id(request.getParameter("foi_id"));
		ord.setMi_id(request.getParameter("mi_id"));
		ord.setFoi_phone(request.getParameter("foi_phone"));
		ord.setFoi_zip(request.getParameter("foi_zip"));
		ord.setFoi_addr1(request.getParameter("foi_addr1"));
		ord.setFoi_addr2(request.getParameter("foi_addr2"));
		if (request.getParameter("foi_invoice") != null || request.getParameter("foi_invoice").equals("")) ord.setFoi_invoice(request.getParameter("foi_invoice"));
		ord.setFoi_memo(request.getParameter("foi_memo"));
		ord.setFoi_status(request.getParameter("foi_status"));	
		
		AdminOrderFdgProcSvc adminOrderFdgProcSvc = new AdminOrderFdgProcSvc();
		int result = adminOrderFdgProcSvc.orderFdgUpdate(ord, adminInfo.getAi_idx());
		
		ActionForward forward = new ActionForward();
		forward.setPath("order_fdg.adminord");
		
		return forward;
	}

}
