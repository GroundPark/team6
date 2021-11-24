package funding.ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import act.Action;
import act.PdtListAct;
import act.PdtViewAct;
import funding.act.*;
import funding.vo.*;
import vo.ActionForward;

@WebServlet("*.fdg")
public class FundingCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FundingCtrl() {
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
		case "/pdt_list.fdg" :	// 상품 목록 화면 요청
			action = new FdgListAct();
			break;
		case "/pdt_view.fdg" :	// 상품 상세 화면 요청
			action = new FdgViewAct();
			break;
		}

		try {
			forward = action.execute(request, response);
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
