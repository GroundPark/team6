/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-12-12 07:32:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import main.DateDiff;
import vo.*;
import java.text.DecimalFormat;
import vo.*;

public final class mainPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/include/footer.jsp", Long.valueOf(1639049464000L));
    _jspx_dependants.put("/include/header.jsp", Long.valueOf(1639294333316L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("vo");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("main.DateDiff");
    _jspx_imports_classes.add("java.text.DecimalFormat");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- \r\n");
      out.write("12.06 수정한것 \r\n");
      out.write("1. 펀딩, 도전펀딩 목록에서 '남은일자' 잘못 계산한거 올바르게 수정\r\n");
      out.write("2. 펀딩율 계산식 수정 (단, fi_rate가 계산된 값이 자동으로 입력되는게 아니라 리터럴값이 입력되어야 하는 문제가 있음)\r\n");
      out.write(" -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <!-- 돈 표기 -->\r\n");
      out.write("\r\n");

request.setCharacterEncoding("utf-8");

ArrayList<ProductInfo> productList = (ArrayList<ProductInfo>)request.getAttribute("productList");
ArrayList<ChallengeInfo> challengeList = (ArrayList<ChallengeInfo>)request.getAttribute("challengeList");
ArrayList<FundingInfo> fundingList = (ArrayList<FundingInfo>)request.getAttribute("fundingList");
ArrayList<ReviewInfo> reviewList =(ArrayList<ReviewInfo>)request.getAttribute("reviewList");


DecimalFormat formatter = new DecimalFormat("#,##0");

int cpage = 1, psize = 12; // 메인에 게시된 일반, 펀딩, 도전상품들을 클릭했을 때 이동하는 view.jsp에 가져 가야 할 페이징 조건(쿼리스트링에서 사용함)  

Calendar today = Calendar.getInstance();
int ye = today.get(Calendar.YEAR);	int mo = today.get(Calendar.MONTH) + 1;		int da = today.get(Calendar.DATE);
String now = ye + "-" + mo + "-" + da;



      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mainSlide.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mainLayout.css\" />\r\n");
      out.write("\t<script src=\"js/jquery-3.6.0.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery-ui-1.10.3.custom.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/mainSlide.js\"></script>\r\n");
      out.write("\t<script src=\"js/mainPage_scroll.js\"></script>\r\n");
      out.write("\t<script src=\"js/heartFlag.js\"></script>\r\n");
      out.write("\t<script src=\"js/search.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 로그인 정보를 담은 인스턴스를 사용하기 위해 import -->\r\n");

request.setCharacterEncoding("utf-8");

String sch_kind = request.getParameter("sch_kind");
if (sch_kind == null)	sch_kind = "";

String keyword = request.getParameter("keyword");
if (keyword == null)	keyword = "";

MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
boolean isLogin = false;
if (memberInfo != null)	isLogin = true;

      out.write("\r\n");
      out.write("<!-- #header 영역 시작 -->\r\n");
      out.write("<!-- 모든 사이트에서 적용되는 css -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/reset.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/base.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/footer.css\" />\r\n");
      out.write("<script src=\"js/search.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("<div id=\"header\" class=\"header\">\r\n");
      out.write("\t<div id=\"logo\"><h1 class=\"logo\"><a href=\"index.jsp\"><img src=\"img/logo.png\" alt=\"로고\" class=\"logo\" /></a></h1></div>\r\n");
      out.write("\t<ul id=\"infoMenu\">\r\n");
 if(memberInfo == null) { 
      out.write("\r\n");
      out.write("\t\t<li><a href=\"#\">회원가입</a></li>\r\n");
      out.write("\t\t<li><a href=\"login_form.jsp\">로그인</a></li>\r\n");
      out.write("\t\t<li><a href=\"login_form.jsp?url=cart_list.ord\">장바구니</a></li>\r\n");
 } else { 
      out.write("\r\n");
      out.write("\t\t<li>");
      out.print(memberInfo.getMi_name() );
      out.write(" 님, 안녕하세요.</li>\r\n");
      out.write("\t\t<li><a href=\"logout.jsp\">로그아웃</a></li>\r\n");
      out.write("\t\t<li><a href=\"cart_list.ord\">장바구니</a></li>\r\n");
      out.write("\t\t<li><a href=\"mypage.mem\">마이페이지</a></li>\r\n");
 } 
      out.write("\r\n");
      out.write("\t\t<li><a href=\"#\">고객센터</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<h2>검색 창</h2>\r\n");
      out.write("\t<!-- js로 select의 값을 확인한 후 각 값에 따라 action을 달리 정해주면 되지않음? -->\r\n");
      out.write("\t<form name=\"frmSch\" action=\"#\" method=\"get\" >\r\n");
      out.write("\t<ul id=\"searchMain\">\r\n");
      out.write("\t\t<li><select class=\"hand\" id=\"search_kind\" name=\"sch_kind\">\r\n");
      out.write("\t\t\t<option value=\"상품\" ");
 if(sch_kind.equals("상품")) { 
      out.write(" selected=\"selected\" ");
 } 
      out.write(">일반상품</option>\r\n");
      out.write("\t\t\t<option value=\"펀딩\" ");
 if(sch_kind.equals("펀딩")) { 
      out.write(" selected=\"selected\" ");
 } 
      out.write(">펀딩상품</option>\r\n");
      out.write("\t\t\t<option value=\"도전\" ");
 if(sch_kind.equals("도전")) { 
      out.write(" selected=\"selected\" ");
 } 
      out.write(">도전펀딩</option>\r\n");
      out.write("\t\t </select></li>\r\n");
      out.write("\t\t<li><input type=\"text\"  id=\"search_bar\" name=\"keyword\" onkeydown=\"enterkey();\" value=\"");
      out.print( keyword );
      out.write("\" /></li>\r\n");
      out.write("\t\t<li><button type=\"image\" id=\"goSch\"><img src=\"img/search_btn_white.png\" width=\"25\" onclick=\"Examine()\" /></button></li>\r\n");
      out.write("<!-- \t\t<input type=\"image\" value=\"검색\" id=\"goSch\" onclick=\"Examine()\" />\t -->\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<h2>메인 메뉴</h2>\r\n");
      out.write("\t\r\n");
      out.write("\t<h2>SNS</h2>\r\n");
      out.write("\t<ul id=\"sns\">\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/instagram.png\" alt=\"인스타\" /></a></li>\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/facebook.jpg\" alt=\"페이스북\" /></a></li>\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/twitter.png\" alt=\"트위터\" /></a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("</header>\r\n");
      out.write("<!-- div#header 영역 종료 -->\r\n");
      out.write("\r\n");
      out.write("<!-- nav 영역 시작 -->\r\n");
      out.write("<nav id=\"navBox\">\r\n");
      out.write("<ul id=\"navigation\">\r\n");
      out.write("\t<li><a href=\"pdt_list.pdt?cata=a\">가위</a></li>\r\n");
      out.write("\t<li><a href=\"pdt_list.pdt?cata=b\">문구</a></li>\r\n");
      out.write("\t<li><a href=\"pdt_list.pdt?cata=c\">주방</a></li>\r\n");
      out.write("\t<li><a href=\"pdt_list.pdt?cata=d\">etc</a></li>\r\n");
      out.write("\t<li><a href=\"chal_list.chal\">도전펀딩</a></li>\r\n");
      out.write("\t<li><a href=\"fdg_list.fdg\">펀딩하기</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("</nav>\r\n");
      out.write("<!-- nav 영역 종료 -->\r\n");
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("<!-- ------------------------------------------------------------------------------------------------ -->\r\n");
      out.write("<article id=\"mainSlide\">\t\t\t\t\t<!-- 메인 슬라이드 시작 -->\r\n");
      out.write("\t<div class=\"slideshow\">\r\n");
      out.write("\t\t<div class=\"slideshow-slides\">\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"slide\" id=\"slide-1\"><img src=\"img/slide-1.png\" width=\"1200\" height=\"465\" /></a>\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"slide\" id=\"slide-2\"><img src=\"img/slide-2.png\" width=\"1200\" height=\"465\" /></a>\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"slide\" id=\"slide-3\"><img src=\"img/slide-3.png\" width=\"1200\" height=\"465\" /></a>\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"slide\" id=\"slide-4\"><img src=\"img/slide-4.png\" width=\"1200\" height=\"465\" /></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"slideshow-nav\">\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"prev\">Prev</a>\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"next\">Next</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"slideshow-indicator\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</article>\t\t\t\t\t\t\t\t\t<!-- 메인 슬라이드 종료 -->\r\n");
      out.write("<!-- ------------------------------------------------------------------------------------------------ -->\r\n");
      out.write("<main>\r\n");
      out.write("\t<section id=\"section_1\">\t\t\t\t<!-- 첫번째 섹션. (Wrap)상품 목록 시작 -->\r\n");
      out.write("\t\t<article id=\"section_1_best\">\t\t<!-- Best상품 목록 시작 -->\r\n");
      out.write("\t\t\t<p id=\"best_title\">BEST 상품</p>\r\n");
      out.write("\t\t\t<div class=\"best_list\">\r\n");
 for (int i = 0 ; i < productList.size(); i++) { 
	ProductInfo pdt = productList.get(i);

      out.write("\r\n");
      out.write("\t\t\t\t<div ");
 if(i < 2) { 
      out.write(" class=\"best_pdt\" ");
 }else{ 
      out.write(" class=\"best_pdt_2row\" ");
 } 
      out.write(" >\r\n");
      out.write("\t\t\t\t\t<a href=\"pdt_view.pdt?piid=");
      out.print(pdt.getPi_id());
      out.write("&cpage=");
      out.print(cpage);
      out.write("&psize=");
      out.print(psize);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"page/product/img/");
      out.print(pdt.getPi_img1());
      out.write("\" width=\"250\" height=\"210\" />\r\n");
      out.write("\t\t\t\t\t\t<div class=\"obj_content\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"obj_content_1row\">");
      out.print( pdt.getPi_name());
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t");
 if(pdt.getPi_discount() != 0){ 
      out.write("\r\n");
      out.write("\t<del>");
      out.print(formatter.format(pdt.getPi_price()));
      out.write("원</del>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t");
 } 
      out.write("  \r\n");
      out.write("\t<span id=\"pdtDP\">");
      out.print(formatter.format((int)(pdt.getPi_price() * (1 - pdt.getPi_discount()))) );
      out.write("원</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 예솔 파트 로직 -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<img src=\"img/heart_empty.png\" class=\"heart\" onclick=\"heartFlag(this);\" /> \r\n");
      out.write("\t\t\t\t</div>\t\t\t\t\r\n");

}

      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"vline\"></div>\r\n");
      out.write("\t\t</article>\t\t\t\t\t\t\t<!-- Best상품 목록 종료 -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<article id=\"section_1_funding\">\t<!-- 실시간 HOT펀딩 목록 시작 -->\r\n");
      out.write("\t\t\t<p id=\"funding_title\">실시간 HOT 펀딩</p>\r\n");
      out.write("\t\t\t<div class=\"funding_list\">\r\n");
 for (int i = 0 ; i < fundingList.size(); i++) { 
	FundingInfo fund = fundingList.get(i);
	long deadline = DateDiff.diffOfDate(now, fund.getFi_edate().substring(0,10));		// 남은 일자를 계산하는 함수. main.DateDiff클래스

      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"funding_pdt\">\r\n");
      out.write("\t\t\t\t\t<a href=\"fdg_view.fdg?fiidx=");
      out.print(fund.getFi_idx());
      out.write("&cpage=");
      out.print(cpage);
      out.write("&psize=");
      out.print(psize);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"page/funding/img/");
      out.print(fund.getFi_img1());
      out.write("\" width=\"250\" height=\"210\" />\r\n");
      out.write("\t\t\t\t\t\t<div class=\"obj_content\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"obj_content_1row\">");
      out.print( fund.getFi_name());
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"obj_content_2row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"fund_rate\">");
      out.print(Math.round(fund.getFi_rate() * 100) );
      out.write("%</span>&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"fund_goal\">");
      out.print( formatter.format(fund.getFi_goal()));
      out.write("원</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print( deadline );
      out.write("일 남음\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<img src=\"img/heart_empty.png\" class=\"heart\" onclick=\"heartFlag(this);\" />\r\n");
      out.write("\t\t\t\t</div>\t\t\t\t\r\n");

}

      out.write("\r\n");
      out.write("\t\t\t<div id=\"hline\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</article>\t\t\t\t\t\t\t<!-- 실시간 HOT펀딩 목록 종료 -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<article id=\"section_1_challenge\">\t<!-- 도전펀딩 목록 시작 -->\r\n");
      out.write("\t\t\t<p id=\"challenge_title\">도전 펀딩!</p>\r\n");
      out.write("\t\t\t<div class=\"challenge_list\">\r\n");
 for (int i = 0 ; i < challengeList.size(); i++) { 
	ChallengeInfo chall = challengeList.get(i);
	long deadline = DateDiff.diffOfDate(now, chall.getCi_edate().substring(0,10));		// 남은 일자를 계산하는 함수. main.DateDiff클래스

      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"funding_pdt\">\r\n");
      out.write("\t\t\t\t\t<a href=\"chal_view.chal?ciidx=");
      out.print(chall.getCi_idx());
      out.write("&cpage=");
      out.print(cpage);
      out.write("\">\r\n");
 if(!chall.getCi_img().equals("null")) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"page/challenge/userimg/");
      out.print(chall.getCi_img());
      out.write("\" width=\"250\" height=\"210\" />\r\n");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"page/challenge/img/chal_info_default.png\" width=\"250px\" height=\"210\" />\r\n");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"obj_content\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"obj_content_1row\">");
      out.print( chall.getCi_title());
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"obj_content_2row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t공감 ( ");
      out.print( chall.getCi_good() );
      out.write(" / 200 )개</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print( deadline );
      out.write("일 남음\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<img src=\"img/sympathy_emptyG.png\" class=\"sympathy\"  onclick=\"sympathyFlag(this);\" />\r\n");
      out.write("\t\t\t\t</div>\t\t\t\t\r\n");

}

      out.write("\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t</article>\t\t\t\t\t\t\t<!-- 도전펀딩 목록 종료 -->\r\n");
      out.write("\t</section>\t\t\t\t\t\t\t\t<!-- 첫번째 섹션. (Wrap)상품 목록 종료 -->\r\n");
      out.write("\t\r\n");
      out.write("<!-- ------------------------------------------------------------------------------------------------ -->\t\r\n");
      out.write("\r\n");
      out.write("\t<section id=\"section_2\">\t\t\t\t<!-- 두번째 섹션. (Wrap)동영상 영역 시작 -->\r\n");
      out.write("\t\t<article id=\"video\">\t\t\t\t<!-- 동영상이 들어갈 영역 시작 -->\r\n");
      out.write("\t\t<iframe width=\"800\" height=\"400\" src=\"https://www.youtube.com/embed/QxhStu7pp44\" \r\n");
      out.write(" \t\t\ttitle=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; \r\n");
      out.write("\t\t\tencrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>\r\n");
      out.write("\t\t</article>\t\t\t\t\t\t\t<!-- 동영상이 들어갈 영역 종료 -->\t\r\n");
      out.write("\t\t<article id=\"videoExplain\">\t\t\t<!-- 동영상 설명 영역 시작 -->\r\n");
      out.write("\t\t\t<div id=\"explain\">\r\n");
      out.write("\t\t\t\t<p id=\"videoTitle\">&quot;굳이 왼손잡이용을?&quot;</p>\r\n");
      out.write("\t\t\t\t이라고 생각하신다면 여기 주목!!<br />\r\n");
      out.write("\t\t\t\t이 영상을 보게 되는 즉시 장바구니에 물건을 담고 있는 <br />자기 자신을 발견하게 될 것입니다.<br /><br />\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t나를 봐 내 작은 모습을<br />\r\n");
      out.write("\t\t\t\t너는 언제든지 웃을 수 있니<br />\r\n");
      out.write("\t\t\t\t너라도 날 보고 한번쯤<br />\r\n");
      out.write("\t\t\t\t그냥 모른척해 줄 순 없겠니<br /><br />\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t하지만 때론 세상이 뒤집어 진다고<br />\r\n");
      out.write("\t\t\t\t나 같은 아이 한둘이 어지럽힌다고<br />\r\n");
      out.write("\t\t\t\t모두 다 똑같은 손을 들어야 한다고<br />\r\n");
      out.write("\t\t\t\t그런 눈으로 욕 하지마<br /><br />\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t난 아무것도 망치지 않아 난 왼손잡이야<br /><br />\r\n");
      out.write("\t\t\t\t패닉 - 왼손잡이 中<br />\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</article>\t\t\t\t\t\t\t<!-- 동영상 설명 영역 종료 -->\r\n");
      out.write("\t</section>\t\t\t\t\t\t\t\t<!-- 두번째 섹션. (Wrap)동영상 영역 종료-->\t\r\n");
      out.write("\r\n");
      out.write("<!-- ------------------------------------------------------------------------------------------------ -->\t\r\n");
      out.write("\t\r\n");
      out.write("\t<section id=\"section_3\">\t\t\t\t<!-- 세번째 섹션. 후기 영역 시작 -->\r\n");
      out.write("\t\t<p id=\"section_3_title\">믿고 보는 생생 후기</p>\r\n");
      out.write("\t\t<article id=\"section_3_review\">\t\t\r\n");

if (reviewList.size() > 0) {
	for (int i = 0 ; i < reviewList.size(); i ++) {
		ReviewInfo review = reviewList.get(i);

      out.write("\r\n");
      out.write("\t\t\t<div class=\"review_obj\">\r\n");
      out.write("\t\t\t\t<div class=\"review_top\">\r\n");
      out.write("\t\t\t\t\tID:<span class=\"reviewer\">");
      out.print(review.getMi_id());
      out.write("</span><span class=\"reviewDate\">");
      out.print(review.getRl_date());
      out.write("</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"review_score\">\r\n");
      out.write("\t\t\t\t\t<p style=\"WIDTH:");
      out.print(review.getRl_score() / 5.0 * 100 );
      out.write("%;\"></p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"review_body\">");
      out.print( review.getRl_content() );
      out.write("</div>\r\n");
      out.write("\t\t\t\t<div class=\"review_bottom\">");
      out.print( review.getPi_name() );
      out.write("</div>\r\n");
      out.write("\t\t\t</div>\r\n");

	}
}

      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t</article>\t\r\n");
      out.write("\t</section>\t\t\t\t\t\t\t\t<!-- 세번째 섹션. 후기 영역 종료 -->\r\n");
      out.write("\t\r\n");
      out.write("<!-- ------------------------------------------------------------------------------------------------ -->\t\r\n");
      out.write("\t\r\n");
      out.write("\t<section id=\"section_4\">\t\t \t\t<!-- 네번째 섹션. 인터뷰 영역 시작 -->\r\n");
      out.write("\t\t<p id=\"section_4_title\">성공 펀딩 인터뷰!</p>\r\n");
      out.write("\t\t<article id=\"section_4_interview\">\r\n");
      out.write("\t\t\t<div id=\"interview_img\">\r\n");
      out.write("\t\t\t\t<img src=\"img/interview.png\" width=\"250\" height=\"190\" alt=\"크기 : 250x190\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<p id=\"interview_content\">\r\n");
      out.write("\t\t\t\t<span class=\"question\">Q. 도전펀딩을 하게 된 계기가 있다면?</span><br /><br />\r\n");
      out.write("\t\t\t\t<span class=\"answer\">\r\n");
      out.write("\t\t\t\tA. 이전까지는 왼손잡이로서 불편함을 감수하고 살아야 한다고 생각했습니다. 그런데 '왼손잡상점'를 통해 그 불편함을 인식하고 편하게 바꿀 수 있다는 생각이 들었습니다.\r\n");
      out.write("\t\t\t\t그래서 일상생활 속에서 왼손잡이만이 느끼는 불편함을 찾고자 하였고, 그 결과 좋은 아이디어가 떠올라 도전펀딩을 하게 되었습니다.\r\n");
      out.write("\t\t\t\t</span><br /><br />\r\n");
      out.write("\t\t\t\t<span class=\"question\">Q. 앞으로 도전할 회원들에게 한마디 부탁드립니다.</span><br /><br />\r\n");
      out.write("\t\t\t\t<span class=\"answer\">\r\n");
      out.write("\t\t\t\tA. 내가 불편하다고 느낀다면 다른 사람들도 그렇게 느낄 것입니다. 나의 작은 아이디어 하나가 세상을 변화시킬 수 있다고 생각합니다.\r\n");
      out.write("\t\t\t\t여러분들도 일상 속에서 느끼는 불편함을 생각에서 그치는 것이 아니라 이 '도전펀딩'을 통해 여러 사람들과 공감할 수 있기를 바랍니다. \r\n");
      out.write("\t\t\t\t그렇게 왼손잡이용 상품을 온라인에서만 구매하는 것이 아닌 우리 일상 속 어디에서나 볼 수 있기를 꿈꾸셨으면 좋겠습니다. \r\n");
      out.write("\t\t\t\t</span><br /><br />\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</article>\r\n");
      out.write("\t</section>\t\t\t\t\t\t\t\t<!-- 네번째 섹션. 인터뷰 영역 종료 -->\r\n");
      out.write("\r\n");
      out.write("<!-- ------------------------------------------------------------------------------------------------ -->\r\n");
      out.write("</main>\r\n");
      out.write("<button class=\"back-to-top\"><span class=\"label\">페이지 위로 가기</span></button>\r\n");
      out.write("<div id=\"mainClareSpace\"></div>\r\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<footer>\n");
      out.write("\t<!-- footerInner영역 시작 -->\n");
      out.write("\t<div class=\"footerInner\">\n");
      out.write("\t\t<div class=\"corp_area\">\n");
      out.write("\t\t\t<ul class=\"corp_list\">\n");
      out.write("\t\t\t\t<li><a href=\"#\">이용 약관</a></li> |\n");
      out.write("\t\t\t\t<li><a href=\"#\">개인정보 처리방침</a></li> |\n");
      out.write("\t\t\t\t<li><a href=\"#\">고객센터</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"company_info_area\">\n");
      out.write("\t\t<img src=\"img/logo_long.png\" width=\"191px\" height=\"59px\" alt=\"Logo\" class=\"footerLogo\"/>\n");
      out.write("\t\t\t<div class=\"ci_area\">\n");
      out.write("\t\t\t\t<ul class=\"company_info\">\n");
      out.write("\t\t\t\t\t<li>회사명&nbsp;(주)왼손잡상점</li>&nbsp;&nbsp;|&nbsp;&nbsp;\n");
      out.write("\t\t\t\t\t<li>대표이사&nbsp;이지윤</li>&nbsp;&nbsp;|&nbsp;&nbsp;\n");
      out.write("\t\t\t\t\t<li>주소&nbsp;서울특별시 강남구 강남대로 428 만이빌딩 5, 10층</li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"ci_area\">\n");
      out.write("\t\t\t<ul class=\"company_info\">\n");
      out.write("\t\t\t\t<li>사업자 등록번호&nbsp;112-39-54678</li>&nbsp;&nbsp;|&nbsp;&nbsp;\n");
      out.write("\t\t\t\t<li>고객센터 전화번호&nbsp;1546-6557</li>&nbsp;&nbsp;|&nbsp;&nbsp;\n");
      out.write("\t\t\t\t<li>회사 이메일&nbsp;leftystore@lefty.com</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</footer>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
