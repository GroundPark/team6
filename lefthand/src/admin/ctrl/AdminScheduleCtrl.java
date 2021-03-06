package admin.ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import admin.act.*;
import vo.*;


@WebServlet("*.sche")
public class AdminScheduleCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminScheduleCtrl() {        super();   }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String requestUri = request.getRequestURI();		
		String contextPath = request.getContextPath();
		String command = requestUri.substring(contextPath.length());
		// 인덱스에서 보낸 것들을 받음!
// System.out.println("AdminScheduleCtrl파일의 command : " + command);
		ActionForward forward = null;					// AF 이동방식을 저장하는 클래스
		Action action = null;							// AF가 구현해야 할 인터페이스

		switch (command) {
		case "/admin/schedule.sche" :					// 일정관리 달력 요청시
			action = new AdminScheduleAct();
			break;
		case "/admin/schedule_form.sche" :				// 일정 관리 폼(일정 등록 및 수정) 요청시
			action = new AdminScheduleFormAct();
			break;
		case "/admin/schedule_proc.sche" :				// 일정 처리(등록, 수정, 삭제) 요청시				
			action = new AdminScheduleProcAct();
			break;
		case "/admin/schedule_form_in.sche" :				// 일정 처리(등록, 수정, 삭제) 요청시				
			action = new AdminScheduleFormAct();
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