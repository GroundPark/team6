/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-12-08 07:58:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vo.*;
import vo.*;

public final class admin_005fchal_005ffunding_005fup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/admin/../include/incAdmin.jsp", Long.valueOf(1638947755469L));
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
    _jspx_imports_classes = null;
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

PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");		// 페이징 정보
AdminChallengeList adminChallenge = (AdminChallengeList)request.getAttribute("adminChallenge");		// 게시글 정보

String schtype = "", keyword = "";
String args = "?cpage=" + pageInfo.getCpage();		
//if(pageInfo.getKeyword() != null && !pageInfo.getKeyword().equals("")){
//	schtype = pageInfo.getSchtype();
//	keyword = pageInfo.getKeyword();
//	args += "&schtype=" + pageInfo.getSchtype() + "&keyword=" + pageInfo.getKeyword();
	// 검색조건이 있을 경우에만 schtype와 keyword에 정보를 저장하고... 검색 조건이 있을 경우에만 쿼리스트링으로 만들어줌
//}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery.js\"></script>\r\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write(".admin_chal_detail_container{\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("\tpadding:50px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("// textArea 글의 크기? 만큼 자동조절해줌\r\n");
      out.write("$(document).ready(function () {\r\n");
      out.write("$(\"textarea\").each(function () {\r\n");
      out.write("\t  this.setAttribute(\"style\", \"height:\" + (this.scrollHeight) + \"px;overflow-y:hidden;\");\r\n");
      out.write("\t}).on(\"input\", function () {\r\n");
      out.write("\t  this.style.height = \"auto\";\r\n");
      out.write("\t  this.style.height = (this.scrollHeight) + \"px\";\r\n");
      out.write("\t})\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");



      out.write("\r\n");
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
      out.write("\t\t\t\t   <li><a href=\"chal_manage_reply.admin\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;도전펀딩 댓글 관리</a></li>\r\n");
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
      out.write("<main>\r\n");
      out.write("<div class=\"admin_chal_detail_container\">\r\n");
      out.write("<form class=\"form-horizontal\" role=\"form\" name=\"frmChallengeList\" method=\"post\" action=\"../admin/chal_up_proc.admin\" >\r\n");
      out.write("<input type=\"hidden\" name=\"ciidx\" value=\"");
      out.print(adminChallenge.getCi_idx() );
      out.write("\" />\r\n");
      out.write("<input type=\"hidden\" name=\"cpage\" value=\"");
      out.print(pageInfo.getCpage() );
      out.write("\" />\r\n");
      out.write("<input type=\"hidden\" name=\"schtype\" value=\"\" />\r\n");
      out.write("<input type=\"hidden\" name=\"keyword\" value=\"\" />\r\n");
      out.write("    <div class=\"form-group\">\r\n");
      out.write("        <label for=\"inputName\" class=\"col-lg-2 control-label\">글 번호</label>\r\n");
      out.write("        <div class=\"col-lg-10\">\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"ci_idx\" value=\"");
      out.print(adminChallenge.getCi_idx() );
      out.write("\" data-rule-required=\"true\" maxlength=\"15\" disabled=\"disabled\" >\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"form-group\">\r\n");
      out.write("        <label for=\"inputId\" class=\"col-lg-2 control-label\">글 제목</label>\r\n");
      out.write("        <div class=\"col-lg-10\">\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"ci_title\" value=\"");
      out.print(adminChallenge.getCi_title() );
      out.write("\" data-rule-required=\"true\" maxlength=\"30\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write(" \t<div class=\"form-group\">\r\n");
      out.write("        <label for=\"inputId\" class=\"col-lg-2 control-label\">설명</label>\r\n");
      out.write("        <div class=\"col-lg-10\">\r\n");
      out.write("            <textarea class=\"form-control\" name=\"ci_content\" style=\"resize:none\">\r\n");
      out.print(adminChallenge.getCi_content() );
      out.write("\r\n");
      out.write("            </textarea>         \r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- .getCi_content().replace(\"\\r\\n\", \"<br />\") 처럼 써서 줄바꿈에 대한 처리를 해야하는데 너무 귀찮다.. -->\r\n");
      out.write("    <div class=\"form-group\" id=\"divName\">\r\n");
      out.write("        <label for=\"inputName\" class=\"col-lg-2 control-label\">이미지</label>\r\n");
      out.write("        <div class=\"col-lg-10\">\r\n");
      out.write("\t\t");
 if(adminChallenge.getCi_img().equals("null")) { 
      out.write("\r\n");
      out.write("\t\t<p>업로드한 이미지가 없습니다.</p>\r\n");
      out.write("\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t<img src=\"../page/challenge/userimg/");
      out.print(adminChallenge.getCi_img() );
      out.write("\" style=\"width:500px; height:500px; \" />\t\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"form-group\">\r\n");
      out.write("        <label for=\"inputId\" class=\"col-lg-2 control-label\">작성자</label>\r\n");
      out.write("        <div class=\"col-lg-10\">\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"mi_id\" value=\"");
      out.print(adminChallenge.getMi_id() );
      out.write("\" data-rule-required=\"true\" maxlength=\"30\" disabled=\"disabled\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"form-group\">\r\n");
      out.write("        <label for=\"inputId\" class=\"col-lg-2 control-label\">등록일</label>\r\n");
      out.write("        <div class=\"col-lg-10\">\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"ci_sdate\" value=\"");
      out.print(adminChallenge.getCi_sdate().substring(0 , 10) );
      out.write("\" data-rule-required=\"true\" maxlength=\"30\" disabled=\"disabled\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"form-group\">\r\n");
      out.write("        <label for=\"inputId\" class=\"col-lg-2 control-label\">마감일</label>\r\n");
      out.write("        <div class=\"col-lg-10\">\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"ci_edate\" value=\"");
      out.print(adminChallenge.getCi_edate().substring(0 , 10) );
      out.write("\" data-rule-required=\"true\" maxlength=\"30\" disabled=\"disabled\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("   <div class=\"form-group\">\r\n");
      out.write("        <label for=\"inputId\" class=\"col-lg-2 control-label\">차수</label>\r\n");
      out.write("        <div class=\"col-lg-10\">\r\n");
      out.write("\t<ul id=\"admin_cmb_step\" data-rule-required=\"true\">\r\n");
      out.write("\t\t<li><select class=\"form-control\" name=\"ci_step\">\r\n");
      out.write("\t\t\t<option value=\"1\" ");
 if(adminChallenge.getCi_step() == 1) { 
      out.write("selected ");
 } 
      out.write(">1차</option>\r\n");
      out.write("\t\t\t<option value=\"2\" ");
 if(adminChallenge.getCi_step() == 2) { 
      out.write("selected ");
 } 
      out.write(">2차</option>\r\n");
      out.write("\t\t</select></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <div class=\"form-group\">\r\n");
      out.write("        <label for=\"inputId\" class=\"col-lg-2 control-label\">좋아요 수</label>\r\n");
      out.write("        <div class=\"col-lg-10\">\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"ci_good\" value=\"");
      out.print(adminChallenge.getCi_good() );
      out.write("\" data-rule-required=\"true\" maxlength=\"30\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("  <div class=\"form-group\">\r\n");
      out.write("        <label for=\"inputId\" class=\"col-lg-2 control-label\">진행상태</label>\r\n");
      out.write("        <div class=\"col-lg-10\">\r\n");
      out.write("\t<ul id=\"admin_cmb_step\" data-rule-required=\"true\">\r\n");
      out.write("\t\t<li><select class=\"form-control\" name=\"ci_status\">\r\n");
      out.write("\t\t\t<option value=\"a\" ");
 if(adminChallenge.getCi_status().equals("a")) { 
      out.write("selected ");
 } 
      out.write(">진행</option>\r\n");
      out.write("\t\t\t<option value=\"b\" ");
 if(adminChallenge.getCi_status().equals("b")) { 
      out.write("selected ");
 } 
      out.write(">마감</option>\r\n");
      out.write("\t\t\t<option value=\"c\" ");
 if(adminChallenge.getCi_status().equals("c")) { 
      out.write("selected ");
 } 
      out.write(">펀딩확정</option>\r\n");
      out.write("\t\t</select></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"form-group\">\r\n");
      out.write("                  <label for=\"inputPhoneNumber\" class=\"col-lg-2 control-label\">게시 여부</label>\r\n");
      out.write("                  <div class=\"col-lg-10\">\r\n");
      out.write("                      <label class=\"radio-inline\">\r\n");
      out.write("                          <input type=\"radio\" id=\"ci_isview\" name=\"ci_isview\" value=\"y\" ");
 if(adminChallenge.getCi_isview().charAt(0) == 'y' ) { 
      out.write("checked ");
 } 
      out.write(">&nbsp;Y&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                      </label>\r\n");
      out.write("                      <label class=\"radio-inline\">\r\n");
      out.write("                          <input type=\"radio\" id=\"ci_isview\" name=\"ci_isview\" value=\"n\" ");
 if(adminChallenge.getCi_isview().charAt(0) == 'n' ) { 
      out.write("checked ");
 } 
      out.write(">&nbsp;N\r\n");
      out.write("                      </label>\r\n");
      out.write("                  </div>\r\n");
      out.write("    </div>\r\n");
      out.write("            \r\n");
      out.write("                \r\n");
      out.write("    <div class=\"form-group\">\r\n");
      out.write("        <div class=\"col-lg-offset-2 col-lg-10\">\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\">수정</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</main>\r\n");
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