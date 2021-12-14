/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-12-12 10:04:35 UTC
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

public final class pdt_005forder_005fsuccess_jsp extends org.apache.jasper.runtime.HttpJspBase
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
OrderInfo ord = (OrderInfo)request.getAttribute("ord");	// 보낸 거 받아오기
ArrayList<OrderDetail> detailList = ord.getDetailList();

String payment = "카드 결제";
if (ord.getPoi_payment().equals("B"))		payment = "휴대폰 결제";

DecimalFormat formatter = new DecimalFormat("#,##0");

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/order.css\" />\r\n");
      out.write("\t<script src=\"js/jquery-3.6.0.js\"></script>\r\n");
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
      out.write("<!-- 주문 내역 영역 시작 -->\r\n");
      out.write("<article id=\"orderSuccessBox\">\r\n");
      out.write("<h2>주문 완료!</h2>\r\n");
      out.write("<p id=\"orderNum\">주문번호 : ");
      out.print(ord.getPoi_id() );
      out.write("</p>\r\n");
      out.write("<h3>주문한 상품 내역</h3>\r\n");
      out.write("<table width=\"100%\" cellpadding=\"10\" cellspacing=\"0\" id=\"successTable\">\r\n");
      out.write("<tr>\r\n");
      out.write("<th width=\"15%\">상품</th><th width=\"*\">상품명</th><th width=\"20%\">수량</th>\r\n");
      out.write("<th width=\"10%\">단가</th>\r\n");
      out.write("</tr>\r\n");
for (OrderDetail detail : detailList) {
      out.write("\r\n");
      out.write("<tr align=\"center\">\r\n");
      out.write("<td><img src=\"page/product/img/");
      out.print(detail.getPod_pimg() );
      out.write("\" width=\"60\" height=\"60\" align=\"absmiddle\" /></td>\r\n");
      out.write("<td>");
      out.print(detail.getPod_pname() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(detail.getPod_cnt() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(formatter.format(detail.getPod_pprice()) );
      out.write("원</td>\r\n");
      out.write("</tr>\r\n");

}

      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<h3>배송지 정보</h3>\r\n");
      out.write("<div class=\"box\">\r\n");
      out.write("\t수취인명 : ");
      out.print(ord.getPoi_name() );
      out.write(" <br />\r\n");
      out.write("\t전화번호 : ");
      out.print(ord.getPoi_phone() );
      out.write("<br />\r\n");
      out.write("\t주소 : (");
      out.print(ord.getPoi_zip() );
      out.write(')');
      out.write(' ');
      out.print(ord.getPoi_addr1() + "&nbsp;" + ord.getPoi_addr2() );
      out.write(" \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<h3>결제 정보</h3>\r\n");
      out.write("<div class=\"box\">\r\n");
      out.write("\t결제수단 : ");
      out.print(payment );
      out.write("<br />\r\n");
      out.write("\t총결제액 : ");
      out.print(formatter.format(ord.getPoi_pay()) );
      out.write(" 원<br />\r\n");
      out.write("\t사용포인트 : ");
      out.print(formatter.format(ord.getPoi_point()) );
      out.write(" p\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"width:100%; margin:20px; text-align:center;\">\r\n");
      out.write("\t<input type=\"submit\" value=\"계속 쇼핑\" class=\"btn\" onclick=\"location.href='index.jsp'\" />&nbsp;&nbsp;\r\n");
      out.write("</div>\r\n");
      out.write("</article>\r\n");
      out.write("<!-- 주문 내역 영역 종료 -->\r\n");
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
