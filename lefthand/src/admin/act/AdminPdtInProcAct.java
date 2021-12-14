package admin.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import admin.svc.*;
import vo.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class AdminPdtInProcAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
				
		ProductInfo pdt = new ProductInfo();
		
		String ourPath = "C:\\lys\\web\\work\\lefthand\\WebContent\\page\\product\\img";
		
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;	
		
		MultipartRequest multi = new MultipartRequest(request, ourPath, maxSize, encType, new DefaultFileRenamePolicy());
		String piimg1 = multi.getFilesystemName("pi_img1");
		String piimg2 = multi.getFilesystemName("pi_img2");
		String piimg3 = multi.getFilesystemName("pi_img3");
		String pidesc = multi.getFilesystemName("pi_desc");
		
		String piid = "", pcid = "", piname ="", pisoldout ="" , piisview = "", pidate = "";
		int piprice = 0, price3, pistock = 0, aiidx; 
		float pidiscount = 0;
		
		piid = multi.getParameter("pi_id");
		pcid = multi.getParameter("pc_id");
		piname = multi.getParameter("pi_name");
		pisoldout = multi.getParameter("pi_soldout");
		piisview = multi.getParameter("pi_isview");
		pidate = multi.getParameter("pi_date");
		piprice = Integer.parseInt(multi.getParameter("pi_price"));
		price3 = Integer.parseInt(multi.getParameter("price3"));
		pistock = Integer.parseInt(multi.getParameter("pi_stock"));
		aiidx = Integer.parseInt(multi.getParameter("ai_idx"));
		pidiscount =  Float.parseFloat(multi.getParameter("pi_discount"));
		
				
		pdt.setPi_id(piid.trim().replace("'", "''"));
		pdt.setPc_id(pcid);
		pdt.setPi_name(piname.trim().replace("'", "''"));
		pdt.setPi_img1(piimg1);
		pdt.setPi_img2(piimg2);
		pdt.setPi_img3(piimg3);
		pdt.setPi_desc(pidesc);
		pdt.setPi_price(piprice);
		pdt.setPi_discount(pidiscount);
		pdt.setPi_stock(pistock);
		pdt.setPi_soldout(pisoldout);
		pdt.setPi_isview(piisview);
		pdt.setPi_date(pidate);
		pdt.setAi_idx(aiidx);
						
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
		forward.setPath("/lefthand/admin/admin_pdt_view.adminpdt?cpage=1&piid=" + piid);
		
		return forward;
	}


}
