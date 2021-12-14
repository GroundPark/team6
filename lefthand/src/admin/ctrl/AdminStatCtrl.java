package admin.ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import admin.act.*;
import vo.*;


@WebServlet("*.stat")
public class AdminStatCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public AdminStatCtrl() {super(); }


	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String requestUri = request.getRequestURI();		
		String contextPath = request.getContextPath();
		String command = requestUri.substring(contextPath.length());
		// 인덱스에서 보낸 것들을 받음!
		ActionForward forward = null;		
		Action action = null;				

		switch (command) {
		case "/admin/member.stat" :				
			action = new AdminMemberStatAct();
			break;
		case "/admin/period.stat" :			
			action = new AdminPeriodStatAct();
			break;
		case "/admin/fund.stat" :							
			action = new AdminFundStatAct();
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
