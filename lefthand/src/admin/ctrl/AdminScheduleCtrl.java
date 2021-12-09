package admin.ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import admin.act.*;
import vo.*;


@WebServlet("*.bbs")
public class AdminScheduleCtrl extends HttpServlet {
// �������� ����� ���� ��Ʈ�ѷ�
	private static final long serialVersionUID = 1L;
    public AdminScheduleCtrl() { super(); }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String requestUri = request.getRequestURI();		
		String contextPath = request.getContextPath();
		String command = requestUri.substring(contextPath.length());
		// �ε������� ���� �͵��� ����!

		ActionForward forward = null;		// AF �̵������ �����ϴ� Ŭ����
		Action action = null;				// AF�� �����ؾ� �� �������̽�

		switch (command) {
		case "/schedule.bbs" :				// �������� �޷� ��û��
			action = new AdminScheduleAct();
			break;
		case "/schedule_form.bbs" :			// ���� ���� ��(���� ��� �� ����) ��û��
			action = new AdminScheduleFormAct();
			break;
		case "/schedule_proc.bbs" :			// ���� ó��(���, ����, ����) ��û��				
//			action = new AdminScheduleProcAct();
			break;
		}
		
		try {
			forward = action.execute(request, response);	
			// ó�� �� ���� �� �̵��� ��ο� ����� �޾ƿ�
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
