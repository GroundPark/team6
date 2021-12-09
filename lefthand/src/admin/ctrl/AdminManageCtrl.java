package admin.ctrl;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import vo.*;
import admin.act.*;


@WebServlet("*.admin")		// 모든 admin 요청을 처리하는 서블릿 클래스? 나눠도 되긴함
public class AdminManageCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminManageCtrl() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestUri.substring(contextPath.length());
    	
    	ActionForward forward = null;
    	Action action = null;
    	
    	switch (command) {								// 진행중 (마지막 수정 : 박지상)		
    	case "/admin/chal_list.admin" :					// 도전펀딩 게시글 관리용 리스트 요청	
    		action = new AdminChallengeListAct();
			break;
		case "/admin/chal_up_form.admin" :				// 도전펀딩 게시글 관리 (수정 폼) 요청
			action = new AdminChallengeUpAct();
			break;
		case "/admin/chal_up_proc.admin" :				// 도전펀딩 게시글 관리 (수정 처리) 요청
			action = new AdminChallengeUpProcAct();
			break;
		case "/admin/chal_manage_reply.admin" :		// 도전펀딩 게시글 댓글 관리용 요청
			action = new AdminChallengeReplyListAct();
			break;
		case "/admin/chal_manage_reply_up.admin" :		// 도전펀딩 게시글 댓글 관리용 요청
		//	action = new AdminChallengReplyUpAct();
			break;
		case "/admin/funding_list.admin" :				// 펀딩 게시글 관리용 리스트 요청	
    		action = new AdminFundingListAct();
			break;
		case "/admin/funding_up_form.admin" :			// 펀딩 게시글 관리 (수정 폼) 요청
			action = new AdminFundingUpAct();
			break;
		case "/admin/funding_up_proc.admin" :			// 펀딩 게시글 관리 (수정 처리) 요청
		//	action = new AdminFundingUpProcAct();
			break;
		case "/admin?funding_insert_proc.admin" :		// 펀딩 게시글 등록 요청
		//	action = new AdminFundingInsertAct();
		
		}
		
    	
    	try {
    		forward = action.execute(request, response);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		}else {
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