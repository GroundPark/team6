package admin.ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import admin.act.*;
import vo.*;

@WebServlet("*.adminpdt")
public class AdminProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminProductCtrl() {
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
    	case "/admin/admin_pdt_list.adminpdt" :		
    		action = new AdminPdtListAct();		// 상품 목록
    		break;
    	case "/admin/admin_pdt_in_form.adminpdt" :	
    		action = new AdminPdtInAct();		// 상품 등록 폼
    		break;
    	case "/admin/admin_pdt_in_proc.adminpdt" :			
    		action = new AdminPdtInProcAct();	// 상품 등록 처리
    		break;
    	case "/admin/admin_pdt_view.adminpdt" :		
    		action = new AdminPdtViewAct();		// 상품 상세 보기 화면 요청
    		break;
    	case "/admin/admin_pdt_up_form.adminpdt" :	
//    		action = new AdminPdtUpAct();		// 상품 등록 폼
    		break;
    	case "/admin/admin_pdt_up_proc.adminpdt" :	
    		action = new AdminPdtUpProcAct();		// 상품 수정 처리 요청	
    		break;	
    	case "/admin/admin_pdt_del_proc.adminpdt" :	
//    		action = new AdminPdtDelProcAct();	// 상품 삭제 요쳥 (isview ->n)
    		break;	
    	case "/admin/admin_pdt_rev_list.adminpdt" :	
    		action = new AdminPdtRevListAct();	// 후기 리스트 요청
    		break;
    	case "/admin/admin_pdt_history.adminpdt" :	
    		action = new AdminPdtHistoryAct();	// 상품가격 히스토리 정보요청
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