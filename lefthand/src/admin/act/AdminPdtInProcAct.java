package admin.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import admin.svc.*;
import vo.*;

public class AdminPdtInProcAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		// 판매가격은 어떻게 처리해야 하지...?
		int wonga = Integer.parseInt(request.getParameter("pi_price").trim().replace("'", "''"));	// 상품가격
		float discount = Integer.parseInt(request.getParameter("pi_discount").trim().replace("'", "''"));	// 할인율
		int jaego = Integer.parseInt(request.getParameter("pi_discount").trim().replace("'", "''"));	// 재고량
		int gaonri = Integer.parseInt(request.getParameter("ai_idx"));	// 등록 관리자
		
		ProductInfo pdt = new ProductInfo();
		pdt.setPi_id(request.getParameter("pi_id").trim().replace("'", "''"));
		pdt.setPc_name(request.getParameter("pc_name"));
		pdt.setPi_name(request.getParameter("pi_name").trim().replace("'", "''"));
		pdt.setPi_img1(request.getParameter("pi_img1"));
		pdt.setPi_img2(request.getParameter("pi_img2"));
		pdt.setPi_img3(request.getParameter("pi_img3"));
		pdt.setPi_desc(request.getParameter("pi_desc"));
		pdt.setPi_price(wonga);
		pdt.setPi_discount(discount);
		pdt.setPi_stock(jaego);
		pdt.setPi_soldout(request.getParameter("pi_soldout"));
		pdt.setPi_isview(request.getParameter("pi_isview"));
		pdt.setPi_date(request.getParameter("pi_date"));
		pdt.setAi_idx(gaonri);
		
		
		AdminPdtInProcSvc adminPdtInProcSvc = new AdminPdtInProcSvc();
		int result = adminPdtInProcSvc.adminPdtInsert(pdt);
		
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
		forward.setPath("/lefthand/admin/admin_pdt_view.adminpdt?cpage=1&piid=" + result);
		
		return forward;
	}


}
