package challenge.ctrl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import challenge.act.*;
import vo.*;

@WebServlet("*.chal")		// 도전 펀딩관련 모든 요청 처리하는 서블릿 클래스
public class ChallengeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ChallengeCtrl() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestUri.substring(contextPath.length());
    	
    	ActionForward forward = null;
    	Action action = null;
    	
    	switch (command) {
    	case "/chal_list.chal" :		// 게시글 목록 요청	
    		action = new ChallengeListAct();
			break;
		case "/chal_in_form.chal" :		// 게시글 등록 폼 요청
			action = new ChallengeInAct();
			break;
		case "/chal_in_proc.chal" :		// 게시글 등록 처리 요청
		    action = new ChallengeInProcAct();
			break;
		case "/chal_view.chal" :		// 게시글 보기 화면 요청
			action = new ChallengeViewAct();
			break;
		case "/chal_view_good.chal" :		// 게시글 보기 좋아요
			action = new ChallengeViewGoodAct();
			break;
		case "/chal_view_good_cancel.chal" :		// 게시글 보기 취소 : ChallengeViewGoodCancelAct 인데 잘못썻음
			action = new ChallengeViewCancelAct();
			break;
		case "/chal_del_proc.chal" :	// 게시글 삭제 처리 요청
			action = new ChallengeDelProcAct();
			break;
		case "/chal_reply_in.chal" :	// 게시글 댓글 입력
			action = new ChallengeReplyInAct();
			break;
		//case "/chal_reply_del.chal" :	// 게시글 댓글 삭제
		//	action = new ChallengeReplyDelAct();
		//	break;
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