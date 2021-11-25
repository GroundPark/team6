package member.ctrl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import member.svc.*;	// act�� ���Ե� �����̹Ƿ�
import member.vo.*;	// �α��� �� ȸ�������� �����ϱ� ����

@WebServlet("/login")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid").toLowerCase().trim();
		String pwd = request.getParameter("pwd").trim();
		String url = request.getParameter("url").replace("$", "&");
		// ������Ʈ���� �ִ� url�� ��� '&'�� '$'�� ������� �޾ƿ��� ������ �ٽ� '&'�� ������Ѿ� ��
		if (url.equals(""))	url = "mainPage.jsp";	// hidden���� �޾ƿ��� ������ null�� �ƴ� �� ���ڿ��� ��
		// �α��� �� �̵��� ��ΰ� ���� ��� index ȭ������ �̵��ϵ��� �ּҸ� ����
		
		LoginSvc loginSvc = new LoginSvc();
		MemberInfo memberInfo = loginSvc.getLoginMember(uid, pwd);
		
		HttpSession session = request.getSession();
		// jsp�� �ƴϹǷ� session ��ü�� ����Ϸ��� ���� httpSession �ν��Ͻ��� �����ؾ� ��
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (memberInfo != null) {	// �α��� ���� ��
			session.setAttribute("memberInfo", memberInfo);
			response.sendRedirect(url);
		} else {
			out.println("<script>");
			out.println("alert('�α��ο� �����߽��ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
		}
	}
}
