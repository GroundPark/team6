package product.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import product.svc.*;
import vo.*;

public class PdtViewAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		int psize = Integer.parseInt(request.getParameter("psize"));
		
		// 후기 페이지 번호
		int rcpage = 1, rpsize = 100, rbsize = 5, rrcnt = 0, rpcnt = 0, rspage = 0, repage = 0;
		// 현재 페이지번호, 페이지크기, 블록크기, 게시글 개수, 페이지개수, 시작페이지, 종료페이지를 저장할 변수
		
		if (request.getParameter("rcpage") != null)
			rcpage = Integer.parseInt(request.getParameter("rcpage"));
		
		// 상품 상세 페이지 정보		
		String piid = request.getParameter("piid");
		String miid = request.getParameter("miid");	

		String keyword	= request.getParameter("keyword");	if (keyword == null)	keyword = "";
		String cata		= request.getParameter("cata");		if (cata == null)		cata = "";
		String sort 	= request.getParameter("sort");		if (sort == null)		sort ="idd";

		// 상품상세페이지 인스턴스 생성
		PdtViewSvc pdtViewSvc = new PdtViewSvc();
		ProductInfo pdtInfo = pdtViewSvc.getPdtInfo(piid);
		
		// 상품 카타
		ArrayList<PdtCata> cataList = pdtViewSvc.getCataList();
		
		// 후기 리스트 인스턴스 생성
		rrcnt = pdtViewSvc.getReviewCount(piid);
		ArrayList<ReviewList> reviewList = pdtViewSvc.getReviewList(piid, rcpage, rpsize);
		
		// 후기 페이징
		rpcnt = rrcnt / rpsize;
		if (rrcnt % rpsize > 0)	rpcnt++;		// 전체 페이지 개수이면서 마지막 페이지 번호
		rspage = (rcpage - 1) / rbsize * rbsize + 1;	// 블록 시작 페이지 번호
		repage = rspage + rbsize - 1;
		if(repage > rpcnt) 	repage = rpcnt;			// 블록 종료 페이지 번호
		
		// 상품 페이징
		PdtPageInfo pdtPageInfo = new PdtPageInfo();// 페이징에 필요한 정보들을 저장할 인스턴스
		pdtPageInfo.setCpage(cpage);		pdtPageInfo.setPsize(psize);	pdtPageInfo.setKeyword(keyword);	
		pdtPageInfo.setSort(sort);			pdtPageInfo.setCata(cata);
		
		// 후기페이지
		ReviewPageInfo revPageInfo = new ReviewPageInfo();
		revPageInfo.setRcpage(rcpage);	revPageInfo.setRbsize(rbsize);
		revPageInfo.setRepage(repage);	revPageInfo.setRpcnt(rpcnt);
		revPageInfo.setRpsize(rpsize);	revPageInfo.setRrcnt(rrcnt);
		revPageInfo.setRspage(rspage);	
				
		request.setAttribute("pdtPageInfo", pdtPageInfo);
		request.setAttribute("pdtInfo", pdtInfo);
		request.setAttribute("cataList", cataList);
		request.setAttribute("revPageInfo", revPageInfo);
		request.setAttribute("reviewList", reviewList);		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/page/product/pdt_view.jsp");

		return forward;
	}

	private boolean isEmpty(String str) {	// 문자열에 어떤 값이든 들어 있는지 여부를 검사하는 메소드
		boolean empty = true;
		if (str != null && !str.equals(""))	empty = false;
		return empty;
	}

}
