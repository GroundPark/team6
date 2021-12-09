package main.act;

import javax.servlet.http.*;	// 이걸로 세션을 쓸 수 있음
import java.util.*;				// 리스트 목록을 ArrayList로 받아야 하니까 import
import java.io.*;				// PrintWriter 쓸라고
import main.svc.*;
import vo.*;

public class MainAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ProductInfo> productList = new ArrayList<ProductInfo>();
		ArrayList<ChallengeInfo> challengeList = new ArrayList<ChallengeInfo>();
		ArrayList<FundingInfo> fundingList = new ArrayList<FundingInfo>();
		
		
		request.setCharacterEncoding("utf-8");

		
		MainSvc mainSvc = new MainSvc();
		productList = mainSvc.getProductList();			// 상품정보 받아오기 (많이 팔린순 4개)
		challengeList = mainSvc.getChallengeList();		// 도전펀딩 받아오기 (좋아요 많은 순 2개)
		fundingList = mainSvc.getFundingList();			// 펀딩 받아오기 (주문수 많은 순 2개)
		
		request.setAttribute("productList", productList);
		request.setAttribute("challengeList", challengeList);
		request.setAttribute("fundingList", fundingList);
		// 생성한 인스턴스들을 request객체의 속성으로 저장하여 이동할 페이지로 가져감
		
		ActionForward forward = new ActionForward();
		forward.setPath("mainPage.jsp");
		
		return forward;
	}
}

