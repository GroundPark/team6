/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-12-12 10:08:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.text.DecimalFormat;
import vo.*;
import vo.*;

public final class admin_005forder_005fpdt_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/admin/../include/incAdmin.jsp", Long.valueOf(1639303678618L));
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
      out.write("\r\n");
      out.write("\t<!-- 돈 표기 -->\r\n");
      out.write("\r\n");

request.setCharacterEncoding("utf-8");
OrderInfo ord =(OrderInfo)request.getAttribute("orderInfo");
AdminOrderPdtPageInfo adminOrderPdtPageInfo = (AdminOrderPdtPageInfo)request.getAttribute("adminOrderPdtPageInfo");
ArrayList<OrderDetail> detailList = ord.getDetailList();

DecimalFormat formatter = new DecimalFormat("#,##0"); 

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write(".pdtForm { border:0px solid black; width:100%; margin:0 auto; }\r\n");
      out.write(".lablearea { border:0px solid black; text-align:left; display:inline-block; width:100px; padding:5px; margin-left:-185px;}\r\n");
      out.write(".fieldarea { display:inline-block; width:300px; padding:5px; vertical-align:center; }\r\n");
      out.write("input[type=text] { width:440px; height:10px; padding:7px; }\r\n");
      out.write("input:read-only { background-color:#efefef; border:1px solid #a1a1a1; }  \r\n");
      out.write("label { text-align:left; font-weight:bold;  }\r\n");
      out.write("#comboBox { width:455px; padding:3px; margin-left:0px;}\r\n");
      out.write("\r\n");
      out.write("#box { width:600px; margin:0 auto; border:0px solid black; }\r\n");
      out.write("#pdtList { border:0px solid black; margin:15px 0; width:95%; }\r\n");
      out.write("#pdtList th { text-align:center; font-weight:bold; border-bottom:1px double #a1a1a1; border-top:1px double #a1a1a1; padding:3px; }\r\n");
      out.write("#pdtList td { border-bottom:1px solid #a1a1a1; padding:3px; } \r\n");
      out.write(".btn:hover { background:#F2A649; cursor:pointer; }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");

AdminInfo adminInfo = (AdminInfo)session.getAttribute("adminInfo");
if (adminInfo == null) {
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다.');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/reset.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/admin_base.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/admin_layout.css\" />\r\n");
      out.write("<script src=\"../js/jquery-3.6.0.js\"></script>\r\n");
      out.write("<script src=\"../js/admin.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"outerBack\">\r\n");
      out.write("\t<div id=\"innerBack\">\r\n");
      out.write("\t\t<!-- header 영역 시작 -->\r\n");
      out.write("\t\t<header>\r\n");
      out.write("\t\t\t<div id=\"logout\"><a href=\"admin_logout.jsp\">로그아웃</a></div>\r\n");
      out.write("\t\t\t<span id=\"title\" onclick=\"location.href='admin_mainPage.jsp'\" style=\"cursor:pointer\">관리자 모드</span>\r\n");
      out.write("\t\t\t<p id=\"titleeng\" onclick=\"location.href='admin_mainPage.jsp'\" style=\"cursor:pointer\">Administrator</p>\r\n");
      out.write("\t\t\t<div id=\"greeting\">");
      out.print(adminInfo.getAi_name() );
      out.write("님, 안녕하세요</div>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t<!-- header 영역 종료 -->\r\n");
      out.write("\t\t<!-- nav 영역 시작 -->\r\n");
      out.write("\t\t<!-- 테스트하려고 임의로 넣었습니다  -->\r\n");
      out.write("\t\t<nav>\r\n");
      out.write("\t\t  <ul id=\"ac\">\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">일정 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"admin_mainPage.jsp\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"schedule_form.sche?wtype=in\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 등록</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">관리자 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관리자 목록</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관리자 등록</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;권한 설정</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">회원 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원 목록</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포인트 목록</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">상품 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"admin_pdt_list.adminpdt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상품 목록</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"admin_pdt_in_form.adminpdt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상품 등록</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">도전펀딩 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"chal_list.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;도전펀딩 목록</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"chal_manage_reply.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;도전펀딩 댓글 관리</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">펀딩 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"funding_list.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;펀딩 목록</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"/lefthand/admin/admin_funding_in.jsp\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;펀딩 등록</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">주문 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"order_pdt.adminord\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상품</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"order_fdg.adminord\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;펀딩</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">신고 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;후기 신고</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글 신고</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">고객센터</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;공지사항</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FAQ</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1:1 문의</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">통계</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"member.stat\">&nbsp;&nbsp;&nbsp;회원별 통계</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"period.stat\">&nbsp;&nbsp;&nbsp;기간별 통계</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"fund.stat\">&nbsp;&nbsp;&nbsp;펀딩별 통계</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t  </ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t<!-- nav 영역 종료 -->\t\t\t\t\r\n");
      out.write("\t</div>\t\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<!-- main 영역 시작 -->\r\n");
      out.write("<main>\r\n");
      out.write("<article>\r\n");
      out.write("\t<!-- section 영역 시작 -->\r\n");
      out.write("\t<section>\r\n");
      out.write("\t<h2>상품 주문 내역</h2>\r\n");
      out.write("\t<form name=\"frmAdminOrderPdt\" action=\"order_pdt_proc.adminord\" method=\"post\" class=\"pdtForm\">\t\r\n");
      out.write("\t\t<div id=\"box\">\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"poi_id\">주문번호</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_id\"  id=\"poi_id\" value=\"");
      out.print(ord.getPoi_id() );
      out.write("\" readonly=\"readonly\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"poi_date\">주문일</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_date\"  id=\"poi_date\" value=\"");
      out.print(ord.getPoi_date() );
      out.write("\" readonly=\"readonly\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<table id=\"pdtList\" width=\"90%\" cellpadding=\"5\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t<tr><th width=\"20%\">상품아이디</th><th width=\"*\">상품명</th><th width=\"15%\">수량(ea)</th><th width=\"20%\">단가(원)</th></tr>\r\n");
 for (OrderDetail detail : detailList) { 
      out.write("\r\n");
      out.write("\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t<td>");
      out.print(detail.getPi_id() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(detail.getPod_pname() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(detail.getPod_cnt() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(formatter.format(detail.getPod_pprice()) );
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
 } 
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"mi_id\">주문자 아이디</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"mi_id\"  id=\"mi_id\" readonly=\"readonly\" value=\"");
      out.print(ord.getMi_id() );
      out.write("\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"poi_name\">주문자명</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_name\"  id=\"poi_name\" readonly=\"readonly\" value=\"");
      out.print(ord.getPoi_name() );
      out.write("\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"poi_phone\">전화번호</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_phone\"  id=\"poi_phone\" value=\"");
      out.print(ord.getPoi_phone() );
      out.write("\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"poi_zip\">주소</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_zip\"  id=\"poi_zip\" value=\"");
      out.print(ord.getPoi_zip() );
      out.write("\" /></div><br />\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_addr1\"  id=\"poi_addr1\" value=\"");
      out.print(ord.getPoi_addr1() );
      out.write("\" /></div><br />\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_addr2\"  id=\"poi_addr2\" value=\"");
      out.print(ord.getPoi_addr2() );
      out.write("\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");

String memo = ord.getPoi_memo();
if (ord.getPoi_memo() == null)	memo = ""; 
						

String invoice = ord.getPoi_invoice();
if (ord.getPoi_invoice() == null)	invoice = ""; 

String aiidx = "";
if (ord.getAi_idx() != 0)	aiidx = ord.getAi_idx() + "";

      out.write("\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"poi_memo\">배송메모</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_memo\"  id=\"poi_memo\" value=\"");
      out.print(memo );
      out.write("\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"poi_invoice\">송장번호</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_invoice\"  id=\"poi_invoice\" value=\"");
      out.print(invoice );
      out.write("\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"poi_status\">주문상태</label></div>\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\">\r\n");
      out.write("\t\t\t\t<select name=\"poi_status\" id=\"comboBox\" >\r\n");
      out.write("\t\t\t\t\t<option value=\"a\" ");
 if(ord.getPoi_status().equals("a")) { 
      out.write(" selected=\"selected\" ");
 }
      out.write(">배송준비중</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"b\" ");
 if(ord.getPoi_status().equals("b")) { 
      out.write(" selected=\"selected\" ");
 }
      out.write(">배송중</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"c\" ");
 if(ord.getPoi_status().equals("c")) { 
      out.write(" selected=\"selected\" ");
 }
      out.write(">배송완료</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"poi_price\">결제액</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_price\"  id=\"poi_price\" readonly=\"readonly\" value=\"");
      out.print(formatter.format(ord.getPoi_pay()) );
      out.write(" 원\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"poi_point\">사용 포인트</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_point\"  id=\"poi_point\" readonly=\"readonly\" value=\"");
      out.print(formatter.format(ord.getPoi_point()) );
      out.write(" p\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"poi_modify\">최종 수정일</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"poi_modify\"  id=\"poi_modify\" readonly=\"readonly\" value=\"");
      out.print(ord.getPoi_modify() );
      out.write("\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"lablearea\"><label for =\"ai_idx\">관리자 번호</label></div>\r\n");
      out.write("\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"ai_idx\"  id=\"ai_idx\" readonly=\"readonly\" value=\"");
      out.print(aiidx );
      out.write("\" /></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<p id=\"button_area\" style=\"width:100%; margin-top:20px;\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" class=\"btn\" value=\"돌아가기\" onclick=\"location.href ='order_pdt.adminord';\" style=\"width:120px; height:25px;\"/>\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"submit\" value=\"수정\" class=\"btn\" style=\"width:120px; height:25px;\"/>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</form>\t\t\t\t\t\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- section 영역 종료 -->\r\n");
      out.write("</article>\r\n");
      out.write("</main>\r\n");
      out.write("<!-- main 영역 종료 -->\r\n");
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