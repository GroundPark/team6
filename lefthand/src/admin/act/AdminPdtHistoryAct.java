package admin.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import admin.svc.*;
import vo.*;

public class AdminPdtHistoryAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ArrayList<ProductHistory> productHistory = new ArrayList<ProductHistory>();
		
		String piid = request.getParameter("piid");
		
		AdminPdtHistorySvc adminPdtHistorySvc = new AdminPdtHistorySvc();
		productHistory = adminPdtHistorySvc.getPdtHistoryList(piid);
				
		request.setAttribute("productHistory", productHistory);
				
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/admin_pdt_history.jsp");
		
		return forward;
		
	}	

}
