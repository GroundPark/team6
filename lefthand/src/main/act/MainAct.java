package main.act;

import javax.servlet.http.*;	// 이걸로 세션을 쓸 수 있음

import challenge.vo.ChallengeInfo;
import funding.vo.FundingInfo;

import java.util.*;				// 리스트 목록을 ArrayList로 받아야 하니까 import
import java.io.*;				// PrintWriter 쓸라고
import main.svc.*;
import main.vo.*;
import product.vo.ProductInfo;

public class MainAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ProductInfo> productList = new ArrayList<ProductInfo>();
		ArrayList<ChallengeInfo> challengeList = new ArrayList<ChallengeInfo>();
		ArrayList<FundingInfo> fundingList = new ArrayList<FundingInfo>();
		// ProductList형 인스턴스만을 담은 ArrayList형 pdtList를 생성하여 상품 목록의 정보들을 저장할것임
		
		request.setCharacterEncoding("utf-8");

		
		MainSvc mainSvc = new MainSvc();
		productList = mainSvc.getProductList();
		challengeList = mainSvc.getChallengeList();
		fundingList = mainSvc.getFundingList();
		
		request.setAttribute("productList", productList);
		request.setAttribute("challengeList", challengeList);
		request.setAttribute("fundingList", fundingList);
		// 생성한 인스턴스들을 request객체의 속성으로 저장하여 이동할 페이지로 가져감
		
		ActionForward forward = new ActionForward();
		forward.setPath("/mainPage.jsp");
		
		return forward;
	}
}

