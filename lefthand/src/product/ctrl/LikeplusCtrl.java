package product.ctrl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import product.svc.*;
import vo.*;


@WebServlet("/likeplus")
public class LikeplusCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LikeplusCtrl() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();	
		MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if (memberInfo == null) {
			out.println("<script>");
			out.println("alert('로그인 후 이용해주세요.');");
			out.println("location.href='login_form.jsp';");
			out.println("</script>");
			out.close();
		}
		int rlidx = Integer.parseInt(request.getParameter("rlidx"));
		
		try {
			LikePlusSvc likePlusSvc = new LikePlusSvc();
			int result = likePlusSvc.cntUpdte(memberInfo.getMi_id(), rlidx);
			out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}  
    
