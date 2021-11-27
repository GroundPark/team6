package admin.ctrl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import admin.svc.*;	// act가 포함된 파일이므로
import admin.vo.*;	// 로그인 후 회원정보를 저장하기 위함

@WebServlet("/backLogin")
public class BackLoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BackLoginCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid").toLowerCase().trim();
		String pwd = request.getParameter("pwd").trim();
		
		LoginSvc loginSvc = new LoginSvc();
		MemberInfo memberInfo = loginSvc.getLoginMember(uid, pwd);
		
		HttpSession session = request.getSession();
		// jsp가 아니므로 session 객체를 사용하려면 직접 httpSession 인스턴스를 생성해야 함
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (memberInfo != null) {	// 로그인 성공 시
			session.setAttribute("memberInfo", memberInfo);
			response.sendRedirect("admin/admin_mainPage.jsp");
		} else {
			out.println("<script>");
			out.println("alert('로그인에 실패했습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
	}
}
