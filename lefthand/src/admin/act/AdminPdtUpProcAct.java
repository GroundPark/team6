package admin.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.net.URLEncoder;
import admin.svc.*;
import vo.*;


public class AdminPdtUpProcAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String piid = request.getParameter("pi_id");	// 글번호(필수이므로 바로 형변환 가능)
		int cpage= Integer.parseInt(request.getParameter("cpage"));	// 페이지 번호
		String schtype = request.getParameter("schtype");	// 검색조건
		String keyword = request.getParameter("keyword");	// 검색어
		
		int price = Integer.parseInt(request.getParameter("pi_price"));
		float discount = Float.parseFloat(request.getParameter("pi_discount"));
		int stock = Integer.parseInt(request.getParameter("pi_stock"));
		int idx = Integer.parseInt(request.getParameter("ai_idx"));
		
		String args ="?piid=" + piid + "&cpage=" + cpage;
		if (schtype != null && keyword != null && !schtype.equals("") && !keyword.equals("")){
			args +="&schtype=" + schtype + "&keyword=" + URLEncoder.encode(keyword, "UTF-8"); // 한글 검색시 ?로 바뀌지 않고 그대로 적용하기 위해서
		}
		
		ProductInfo pdt = new ProductInfo();
		
		pdt.setPi_id(piid);
		pdt.setPc_id(request.getParameter("pc_id"));
		pdt.setPi_name(request.getParameter("pi_name").trim().replace("'", "''"));
		pdt.setPi_price(price);
		pdt.setPi_discount(discount);
		pdt.setPi_stock(stock);
		pdt.setPi_soldout(request.getParameter("pi_soldout"));
		pdt.setPi_isview(request.getParameter("pi_isview"));
		pdt.setPi_date(request.getParameter("pi_date"));
		pdt.setAi_idx(idx);
				
		AdminPdtUpProcSvc adminPdtUpProcSvc = new AdminPdtUpProcSvc();
		int result = adminPdtUpProcSvc.adminPdtUpdate(pdt);
				
		if (result == 0) {	// 글 등록에 실패했으면
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('상품 등록에 실패했습니다.\n다시 시도해 주십시요.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);	// dispatch가 아닌 sendRedirect 방식으로 이동한다는 설정
		forward.setPath("/lefthand/admin/admin_pdt_view.adminpdt" + args);
		
		return forward;
		
	}
}
	
