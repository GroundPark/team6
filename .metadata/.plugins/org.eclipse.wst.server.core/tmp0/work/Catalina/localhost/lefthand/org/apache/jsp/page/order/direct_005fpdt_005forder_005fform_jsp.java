/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-12-13 02:27:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page.order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.util.*;
import vo.*;
import vo.*;

public final class direct_005fpdt_005forder_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/page/order/../../include/header.jsp", Long.valueOf(1639294333316L));
    _jspx_dependants.put("/page/order/../../include/footer.jsp", Long.valueOf(1639049464000L));
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

      out.write("\r\n");
      out.write("\t<!-- 돈 표기 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");

request.setCharacterEncoding("utf-8");
ArrayList<CartInfo> pdtList = (ArrayList<CartInfo>)request.getAttribute("orderPdtList");
ArrayList<MemberAddr> addrList = (ArrayList<MemberAddr>)request.getAttribute("addrList");	// 배송지 목록

String piid = request.getParameter("piid");						// 선택한 상품 아이디
int poccnt = Integer.parseInt(request.getParameter("poccnt"));	// 선택한 수량

DecimalFormat formatter = new DecimalFormat("#,##0");

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/order.css\" />\r\n");
      out.write("\t<script src=\"js/jquery-3.6.0.js\"></script>\r\n");
      out.write("\t<script src=\"//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\t<!-- 주소검색용 -->\r\n");
      out.write("\t<script src=\"js/order.js\"></script>\r\n");
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
      out.write("<!-- 주문폼 영역 시작 -->\r\n");
      out.write("<article id=\"orderFrmBox\">\r\n");
      out.write("<h2>주문/결제</h2>\r\n");
      out.write("<form name=\"frmOrder\" action=\"order_proc.ord?piid=");
      out.print(piid );
      out.write("&poccnt=");
      out.print(poccnt );
      out.write("\" method=\"post\">\r\n");
      out.write("<h3>상품 정보</h3>\r\n");
      out.write("<div class=\"box\">\r\n");
      out.write("<table width=\"100%\" cellpadding=\"10\" cellspacing=\"0\" id=\"cartTable\">\r\n");
      out.write("<tr>\r\n");
      out.write("<th width=\"15%\">상품</th><th width=\"*\">상품명</th><th width=\"20%\">판매가</th>\r\n");
      out.write("<th width=\"10%\">수량</th><th width=\"20%\">구매가</th>\r\n");
      out.write("</tr>\r\n");

int delipay = 0;	// 배송비를 저장할 변수
int total = 0;		// 총 구매가격을 저장할 변수
int savePnt = 0;	// 적립시킬 포인트를 저장할 변수 - 우리는 컬럼이 없어서 일단 만들어 놓긴 했지만 쓰진 않을 거임
if (pdtList != null && pdtList.size() > 0) {	// 구매할 상품이 있으면
	for (int i = 0 ; i < pdtList.size() ; i++) {
		CartInfo pdt = pdtList.get(i);
		// pdtList 안에 들어있는 i번째 인스턴스를 CartInfo형 인스턴스로 생성
		

      out.write("\r\n");
      out.write("<tr align=\"center\">\r\n");
      out.write("<td><img src=\"page/product/img/");
      out.print(pdt.getPi_img1() );
      out.write("\" width=\"60\" height=\"60\" align=\"absmiddle\" /></td>\r\n");
      out.write("<td>");
      out.print(pdt.getPi_name() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(formatter.format(pdt.getPi_price()) );
      out.write("원</td>\r\n");
      out.write("<td>");
      out.print(poccnt );
      out.write("</td>\r\n");
      out.write("<td><del>");
      out.print(formatter.format(pdt.getPi_price() * poccnt)  );
      out.write("</del><br />\r\n");
      out.write("<strong class=\"highlight2\">");
      out.print(formatter.format(((pdt.getPi_price() * (1 - pdt.getPi_discount())) * poccnt)));
      out.write("원</strong></td>\r\n");
      out.write("</tr>\r\n");

		total += ((pdt.getPi_price() * (1 - pdt.getPi_discount())) * poccnt);
		
		if (total < 30000)	delipay = 2500;	
		else				delipay = 0;
		
		
	}	
	savePnt = total / 100 * 5;		// 결제금액의 5%를 포인트로 적립

} else {	// 구매할 상품이 없으면
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}

      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\t<input type=\"hidden\" name=\"pocidx\" value=\"0\" />\r\n");
      out.write("\t<input type=\"hidden\" name=\"poipay\" value=\"");
      out.print(total + delipay );
      out.write("\" />\r\n");
      out.write("\t<input type=\"hidden\" name=\"savePnt\" value=\"");
      out.print(savePnt );
      out.write("\" />\r\n");
      out.write("\t<input type=\"hidden\" name=\"delipay\" value=\"");
      out.print(delipay );
      out.write("\" />\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h3>배송지 정보</h3>\r\n");
      out.write("<div class=\"box\">\r\n");
      out.write("<table width=\"100%\" cellpadding=\"10\" cellspacing=\"0\" id=\"deliTable\">\r\n");

String[] arrPhone = memberInfo.getMi_phone().split("-");

      out.write("\r\n");
      out.write("<tr><th>받는 분</th><td><input type=\"text\" name=\"poi_name\" value=\"");
      out.print(memberInfo.getMi_name() );
      out.write("\" /></td></tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th>연락처</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<select name=\"p1\">\r\n");
      out.write("\t\t\t<option value=\"010\" ");
 if (arrPhone[0].equals("010")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">010</option>\r\n");
      out.write("\t\t\t<option value=\"011\" ");
 if (arrPhone[0].equals("011")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">011</option>\r\n");
      out.write("\t\t\t<option value=\"016\" ");
 if (arrPhone[0].equals("016")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">016</option>\r\n");
      out.write("\t\t\t<option value=\"019\" ");
 if (arrPhone[0].equals("019")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">019</option>\r\n");
      out.write("\t\t</select> - \r\n");
      out.write("\t\t<input type=\"text\" name=\"p2\" size=\"4\" value=\"");
      out.print(arrPhone[1] );
      out.write("\" /> - \r\n");
      out.write("\t\t<input type=\"text\" name=\"p3\" size=\"4\" value=\"");
      out.print(arrPhone[2] );
      out.write("\" />\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th width=\"20%\">배송지 선택</th>\r\n");
      out.write("\t<td width=\"*\"><select onchange=\"chkAddr(this.value);\" id=\"addrSelect\">\r\n");
 
String zip = "", addr1 = "", addr2 = "";
for (int i = 0 ; i < addrList.size() ; i++) { 
	MemberAddr addr = addrList.get(i);
	String tmpAddr = addr.getMa_name() + " : " + addr.getMa_addr1() + " " + addr.getMa_addr2();
	String tmpAddr2 = addr.getMa_zip() + ":" + addr.getMa_addr1() + ":" + addr.getMa_addr2();
	if (addr.getMa_basic().equals("y")) {
		zip = addr.getMa_zip();
		addr1 = addr.getMa_addr1();
		addr2 = addr.getMa_addr2();
	}	// 처음에 보여줄 기본주소를 변수에 저장

      out.write("\r\n");
      out.write("\t\t\t<option value=\"");
      out.print(tmpAddr2 );
      out.write('"');
      out.write('>');
      out.print(tmpAddr );
      out.write("</option>\r\n");
	
}

      out.write("\r\n");
      out.write("\t\t\t<option value=\"\">새 주소 입력</option>\r\n");
      out.write("\t</select></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th>주소</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<input type=\"text\" name=\"poi_zip\" id=\"poi_zip\" size=\"5\" readonly value=\"");
      out.print(zip );
      out.write("\" />\r\n");
      out.write("\t\t<input type=\"button\" onclick=\"findAddr()\" value=\"우편번호 찾기\"><br>\r\n");
      out.write("\t\t<input type=\"text\" name=\"poi_addr1\" id=\"poi_addr1\" value=\"");
      out.print(addr1 );
      out.write("\" /><br />\r\n");
      out.write("\t\t<input type=\"text\" name=\"poi_addr2\" id=\"poi_addr2\" value=\"");
      out.print(addr2 );
      out.write("\" />\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h3>포인트 사용 및 결제</h3>\r\n");
      out.write("<div class=\"box\">\r\n");
      out.write("<table width=\"100%\" cellpadding=\"10\" cellspacing=\"0\" id=\"deliTable\">\r\n");
      out.write("<tr><th width=\"20%\">사용 포인트</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<span><input type=\"checkbox\" id=\"chk_use\" onclick=\"chkPoint(");
      out.print(total );
      out.write(',');
      out.print(memberInfo.getMi_point() );
      out.write(",10, ");
      out.print(delipay );
      out.write(")\">\r\n");
      out.write("\t\t<label for=\"chk_use\"> 포인트 전체 사용</label></span><br />\r\n");
      out.write("        <span><input type=\"number\" name=\"use_pnt\" id=\"use_pnt\" max=\"");
      out.print(total );
      out.write("\" value=\"0\" onchange=\"changePoint(");
      out.print(total );
      out.write(',');
      out.print(memberInfo.getMi_point() );
      out.write(",10, ");
      out.print(delipay );
      out.write(");\"></span> p \r\n");
      out.write("        / <span name=\"left_pnt\" id=\"left_pnt\">");
      out.print(memberInfo.getMi_point() );
      out.write(" p</span> <br />\r\n");
      out.write("        <span>포인트는 10p단위로 사용 가능합니다.</span>\r\n");
      out.write("    </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr><th>결제수단</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<input type=\"radio\" name=\"poi_payment\" value=\"A\" id=\"payA\" checked=\"checked\" /><label for=\"payA\"> 카드 결제</label>&nbsp;&nbsp;\r\n");
      out.write("\t\t<input type=\"radio\" name=\"poi_payment\" value=\"B\" id=\"payB\" /><label for=\"payB\"> 휴대폰 결제</label>&nbsp;&nbsp;\t\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr align=\"center\">\r\n");
      out.write("\t<td colspan=\"2\" id=\"totalPay\">총 결제 금액 : ");
      out.print(formatter.format(total) );
      out.write(" 원 - <span id=\"result_pnt\">0</span> p + \r\n");
      out.write("\t");
      out.print(formatter.format(delipay) );
      out.write(" (배송비) = <span id=\"highlight\">");
      out.print(formatter.format(total + delipay) );
      out.write("</span> 원</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"width:100%; margin:20px; text-align:center;\">\r\n");
      out.write("\t<input type=\"button\" value=\"결제하기\" class=\"btn\" onclick=\"submit();\"/>&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"button\" value=\"구매취소\" class=\"btn\" onclick=\"history.back();\" />\r\n");
      out.write("</div>\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("</form>\r\n");
      out.write("</article>\r\n");
      out.write("<!-- 주문폼 영역 종료 -->\r\n");
      out.write("</section>\r\n");
      out.write("<!-- footer 영역 시작 -->\r\n");
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
      out.write("<!-- footer 영역 종료 -->\r\n");
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