/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-12-05 09:29:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.LocalDate;
import vo.*;

public final class admin_005fpdt_005fin_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/admin/../include/incAdmin.jsp", Long.valueOf(1638696574541L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("vo");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.time.LocalDate");
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
      out.write("\t\t\t\t   <li><a href=\"calendar.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"calendar_up.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 등록</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">관리자 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"admin_list.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관리자 목록</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"admin_in.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관리자 등록</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"admin_pms_up.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;권한 설정</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">회원 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"member_list.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원 목록</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"member_point.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포인트 목록</a></li>\r\n");
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
      out.write("\t\t\t\t   <li><a href=\"chal_reply_list.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;도전펀딩 댓글 관리</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">펀딩 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"funding_list.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;펀딩 목록</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"funding_in.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;펀딩 등록</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">주문 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"product_manage.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상품</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"funding_manage.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;펀딩</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">신고 관리</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"review_report.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;후기 신고</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"reply_report.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글 신고</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t </li>\r\n");
      out.write("\t\t\t <li class=\"menu1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">고객센터</a>\r\n");
      out.write("\t\t\t\t<ul class=\"menu2\">\r\n");
      out.write("\t\t\t\t   <li><a href=\"notice_list.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;공지사항</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"faq.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FAQ</a></li>\r\n");
      out.write("\t\t\t\t   <li><a href=\"1v1.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1:1 문의</a></li>\r\n");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write(".pdtForm { width:800px; }\r\n");
      out.write(".lablearea { display:inline-block; width:130px; padding:5px; }\r\n");
      out.write(".fieldarea { display:inline-block; width:300px; vertical-align:center; }\r\n");
      out.write("input[type=text] { width:250px; height:15px; }\r\n");
      out.write("label { text-align:left; }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<main>\r\n");
      out.write("\t<article>\r\n");
      out.write("\t\t<!-- section 영역 시작 -->\r\n");
      out.write("\t    <section>\r\n");
      out.write("\t\t\t<h2>상품 등록</h2>\r\n");
      out.write("\t\t\t<form name=\"frmAdminPdt\" action=\"admin_pdt_in_proc.adminpdt\" method=\"post\" class=\"pdtForm\">\t\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_id\" >상품 ID</label></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"pi_id\" /></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_id\" >카테고리</label></div>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\">\r\n");
      out.write("\t\t\t\t\t<select name=\"pc_id\" id=\"pc_id\" style=\"width:250px; height:20px; text-align:center;\" >\r\n");
      out.write("\t\t\t\t\t\t<option value=\"a\">가위</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"b\">문구</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"c\">주방</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"d\">etc</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_name\" >상품명</label></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"pi_name\"  id=\"pi_name\" /></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_img1\" >상품이미지1</label></div>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\"><input type=\"file\" name=\"pi_img1\"  id=\"pi_img1\"/></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_img2\" >상품이미지2</label></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\"><input type=\"file\" name=\"pi_img2\" id=\"pi_img2\" /></div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_img3\" >상품이미지3</label></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\"><input type=\"file\" name=\"pi_img3\"  id=\"pi_img3\" /></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_desc\" >설명이미지</label></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\"><input type=\"file\" name=\"pi_desc\"  id=\"pi_desc\" /></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_price\" >상품가격</label></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"pi_price\"  id=\"pi_price\" /></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_discount\">할인율</label></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"pi_discount\"  id=\"pi_discount\" /></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_price\">판매가격</label></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"pi_price\"  id=\"pi_price\" /></div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_stock\">재고수량</label></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\"><input type=\"text\" name=\"pi_stock\"  id=\"pi_stock\" /></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"sold\">품절 여부</label></div>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"pi_soldout\" value=\"y\" id=\"soldy\"/><label for =\"soldy\">Y</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"pi_soldout\" value=\"n\" id=\"soldn\" checked=\"checked\"/><label for =\"soldn\">N</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"isview\">게시 여부</label></div>\t\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\">\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"pi_soldout\" value=\"y\" id=\"soldy\"/><label for =\"soldy\">Y</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"pi_soldout\" value=\"n\" id=\"soldn\" checked=\"checked\"/><label for =\"soldn\">N</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

				LocalDate now = LocalDate.now();
				
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\"><label for =\"pi_date\">등록일</label></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\"><span style=\"text-align:left;\">");
      out.print(now );
      out.write("</span></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form_area\">\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"lablearea\">\t<label for =\"ai_idx\">등록 관리자</label></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"fieldarea\">");
      out.print(adminInfo.getAi_id() );
      out.write("</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<p id=\"button_area\" style=\"width:940px; margin-top:20px;\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"취소\" onclick=\"location.href ='admin_pdt_list.adminpdt';\" style=\"width:120px; height:25px;\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"등록\" style=\"width:120px; height:25px;\"/>\r\n");
      out.write("\t\t\t\t</p>\t\r\n");
      out.write("\t\t   </section>\r\n");
      out.write("\t\t<!-- section 영역 종료 -->\r\n");
      out.write("\t</article>\r\n");
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
