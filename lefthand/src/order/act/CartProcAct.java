package order.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.net.URLEncoder;
import order.svc.*;
import vo.*;

public class CartProcAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String wtype = request.getParameter("wtype");	// 등록(in), 수정(up), 삭제(del) 여부를 구분짓는 값
		String piid = request.getParameter("piid");		// 상품 아이디
		String pocidxs = request.getParameter("pocidx");	// 장바구니 인덱스로 삭제 시 여러 개의 인덱스를 문자열로 받을 때 사용
		int poccnt = 0, pocidx = 0;
		if (!wtype.equals("del"))	poccnt = Integer.parseInt(request.getParameter("poccnt"));	// 상품 개수		
		
		if (wtype.equals("up"))		pocidx = Integer.parseInt(request.getParameter("pocidx"));	// 장바구니 인덱스
		// 장바구니에 상품을 등록할 경우 인덱스 번호는 필요 없으므로 'in'일 경우를 제외하고 장바구니 인덱스를 받아옴
			
		HttpSession session = request.getSession();	// 세션 생성
		MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
		if (memberInfo == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 사용하세요.');");
			out.println("location.href='login_form.jsp';");
			out.println("</script>");
			out.close();			
		}
		
		CartInfo cart = new CartInfo();
		cart.setPoc_idx(pocidx);		cart.setPi_id(piid);		cart.setPoc_cnt(poccnt);
		cart.setPoc_idxs(pocidxs);		cart.setMi_id(memberInfo.getMi_id());
		// 장바구니 등록, 수정, 삭제 시 필요한 정보들을 CartInfo형 인스턴스에 담음
		
		String where = "";
		if (wtype.equals("up") || wtype.equals("del")) {
		// 장바구니 수정, 삭제 시 사용할 where절을 생성
			where = " where mi_id = '" + memberInfo.getMi_id() + "' and ";
			if (wtype.equals("up")) {	// 장바구니 수정일 경우
				where += " poc_idx = " + pocidx;
			} else if (wtype.equals("del")) {	// 장바구니 삭제일 경우
				String[] arrIdx = pocidxs.split(",");
				String tmpStr = "";
				for (int i = 0; i < arrIdx.length ; i++) {
					tmpStr += " or poc_idx = " + arrIdx[i];
				}
				where += " (" + tmpStr.substring(4) + ")" ;	// 맨 앞 or은 빼야 하니깐 subString으로!
			}
			// 회원 전용이라면 기본적으로 조건에 회원아이디가 들어가는 것이 안전함
		}	// dao에는 session 없으니깐 여기서 그냥 만들어서 가져가는 걸로
		
		CartProcSvc cartProcSvc = new CartProcSvc();
		int result = cartProcSvc.cartProc(wtype, cart, where);
		// 등록, 수정, 삭제를 모두 CartProc() 메소드에서 wtype에 따라 처리
		response.setContentType("text/html; charset-utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		System.out.println(result);
		if (result == 0) {
			out.println("<script>");
			out.println("alert('장바구니 작업 시 문제가 발생했습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();			
		}
		// 검색 조건들 및 정렬 기준 쿼리 스트링
		String args = "?cpage=" + request.getParameter("cpage") + "&psize=" + request.getParameter("psize");	// 필수인 파라미터들
		String keyword = request.getParameter("keyword");	if (!isEmptyStr(keyword))	args += "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
		String cata = request.getParameter("cata");			if (!isEmptyStr(cata))		args += "&cata=" + cata;
		String sort = request.getParameter("sort");			if (!isEmptyStr(sort))		args += "&sort=" + sort;
		// sendRedirect 로 가면 request를 공유하지 않기 떄문에 이렇게 가져감			

		// 작업 후 이동할 위치와 방법에 대해 지정하는 ActionForward 인스턴스 생성
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("cart_list.ord" + args);		

		return forward;
	}
	
	// 문자열을 받아 null인지 여부와 빈 문자열인지 여부를 검사하여 데이터가 들어있으면 false, 없으면 true를 리턴하는 isEmptyStr() 메소드
	private boolean isEmptyStr(String str) {
		boolean isEmpty = false;
		if (str == null || str.equals(""))	isEmpty = true;
		return isEmpty;
	}

}
