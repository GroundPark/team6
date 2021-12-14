package admin.ctrl;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import admin.act.*;
import vo.*;

@WebServlet("*.adminord")
public class AdminOrderCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminOrderCtrl() {
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
    	case "/admin/order_pdt.adminord" :			// 주문 상품 목록
    		action = new AdminOrderPdtListAct();	
    		break;
    	case "/admin/order_pdt_view.adminord" :		// 주문 상품 상세보기
    		action = new AdminOrderPdtViewAct();			
    		break;
    	case "/admin/order_pdt_proc.adminord" :		// 주문 상품 내역 수정
    		action = new AdminOrderPdtProcAct();			
    		break;
    	case "/admin/order_fdg.adminord" :			// 주문 펀딩 목록
    		action = new AdminOrderFdgListAct();	
    		break;
    	case "/admin/order_fdg_view.adminord" :		// 주문 펀딩 상세보기
    		action = new AdminOrderFdgViewAct();			
    		break;
    	case "/admin/order_fdg_proc.adminord" :		// 주문 펀딩 내역 수정
    		action = new AdminOrderFdgProcAct();			
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
