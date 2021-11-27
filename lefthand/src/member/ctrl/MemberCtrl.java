package member.ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import member.act.*;
import member.vo.*;

@WebServlet("*.mem")
public class MemberCtrl extends HttpServlet {
	// 마이페이지로 연결
	private static final long serialVersionUID = 1L;
      
    public MemberCtrl() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestUri.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;
		
		switch (command) {
		case "/member/member_proc.mem" :		// ?
		//	action = new MemberProcAct();
			break;
		case "/member/mypage.mem" :				// 정보 수정 폼 요청
		//	action = new MemberProcAct();
			break;
		}
		
		try {
			forward = action.execute(request, response);
			// 처리 및 실행 후 이동할 경로와 방법을 받아옴
		} catch(Exception e) {
			e.printStackTrace();
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
	    		dispatcher.forward(request, response);
			}
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
