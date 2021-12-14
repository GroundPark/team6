package admin.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import admin.svc.*;
import vo.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class AdminFundingInProcAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
				
		FundingInfo fdg = new FundingInfo();
		
		String ourPath = "C:\\team6\\lefthand\\WebContent\\page\\funding\\img";
		
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;	
		
		MultipartRequest multi = new MultipartRequest(request, ourPath, maxSize, encType, new DefaultFileRenamePolicy());
		String fiimg1 = multi.getFilesystemName("fi_img1");
		String fiimg2 = multi.getFilesystemName("fi_img2");
		String fiimg3 = multi.getFilesystemName("fi_img3");
		String fidesc = multi.getFilesystemName("fi_desc");
		
		String fiid = "", finame = "", fiisview = "", fisdate = "", fiedate = "", fidate = "", fistatus = "";
		int fiprice = 0, figoal = 0, aiidx;
		
		
		fiid = multi.getParameter("fi_id");
		finame = multi.getParameter("fi_name");
		fiisview = multi.getParameter("fi_isview");
		fisdate = multi.getParameter("fi_sdate");
		fiedate = multi.getParameter("fi_edate");
		fidate = multi.getParameter("fi_date");
		fistatus = multi.getParameter("fi_status");
		fiprice = Integer.parseInt(multi.getParameter("fi_price"));
		figoal = Integer.parseInt(multi.getParameter("fi_goal"));
		// aiidx = Integer.parseInt(multi.getParameter("ai_idx"));
		aiidx = 0;
		System.out.println(fiid);
		
				
		//fdg.setFi_id(fiid.trim().replace("'", "''"));
		//fdg.setFi_name(finame.trim().replace("'", "''"));
		fdg.setFi_id(fiid.trim());
		fdg.setFi_name(finame.trim());
		fdg.setFi_img1(fiimg1);
		fdg.setFi_img2(fiimg2);
		fdg.setFi_img3(fiimg3);
		fdg.setFi_desc(fidesc);
		fdg.setFi_price(fiprice);
		fdg.setFi_goal(figoal);
		fdg.setFi_isview(fiisview);
		fdg.setFi_sdate(fisdate);
		fdg.setFi_edate(fiedate);
		fdg.setFi_date(fidate);
		fdg.setAi_idx(aiidx);
		fdg.setFi_status(fistatus);
						
		AdminFundingInProcSvc adminFundingInProcSvc = new AdminFundingInProcSvc();
		int result = adminFundingInProcSvc.adminFundingInsert(fdg);
		
		
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
		forward.setPath("/lefthand/admin/funding_list.admin");
//		forward.setPath("/lefthand/admin/funding_in_proc.admin?cpage=1&fiid=" + fiid);
		
		return forward;
	}
}