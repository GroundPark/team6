package main.ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import main.act.*;	
import vo.*;


@WebServlet("/mainPage.go")
public class MainCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MainCtrl() {   super();    }

    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String requestUri = request.getRequestURI();		
		String contextPath = request.getContextPath();
		String command = requestUri.substring(contextPath.length());
		// 인덱스에서 보낸 것들을 받음!

		ActionForward forward = null;		// AF 이동방식을 저장하는 클래스
		Action action = null;				// AF가 구현해야 할 인터페이스

		switch (command) {
		case "/mainPage.go" :				// 메인 페이지 요청 
			action = new MainAct();			
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
