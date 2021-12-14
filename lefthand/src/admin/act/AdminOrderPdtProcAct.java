package admin.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;				
import vo.*;
import admin.svc.*;

public class AdminOrderPdtProcAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();	
		AdminInfo adminInfo = (AdminInfo)session.getAttribute("adminInfo");
		if (adminInfo == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('로그인 후 사용하세요.'); location.href='admin_login.jsp?url=order_pdt_view.adminord'; </script>");
			out.close();			
		}
		
		OrderInfo ord = new OrderInfo();
		
		ord.setPoi_id(request.getParameter("poi_id"));
		ord.setMi_id(request.getParameter("mi_id"));
		ord.setPoi_phone(request.getParameter("poi_phone"));
		ord.setPoi_zip(request.getParameter("poi_zip"));
		ord.setPoi_addr1(request.getParameter("poi_addr1"));
		ord.setPoi_addr2(request.getParameter("poi_addr2"));
		if (request.getParameter("poi_invoice") != null || request.getParameter("poi_invoice").equals("")) ord.setPoi_invoice(request.getParameter("poi_invoice"));
		ord.setPoi_memo(request.getParameter("poi_memo"));
		ord.setPoi_status(request.getParameter("poi_status"));	
		
		AdminOrderPdtProcSvc adminOrderPdtProcSvc = new AdminOrderPdtProcSvc();
		int result = adminOrderPdtProcSvc.orderPdtUpdate(ord, adminInfo.getAi_idx());
		
		ActionForward forward = new ActionForward();
		forward.setPath("order_pdt.adminord");
		
		return forward;
	}
}
