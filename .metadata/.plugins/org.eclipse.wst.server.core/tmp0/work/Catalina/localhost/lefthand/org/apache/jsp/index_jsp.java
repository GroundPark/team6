/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-11-20 17:30:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import product.vo.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/include/footer.jsp", Long.valueOf(1637419512456L));
    _jspx_dependants.put("/include/header.jsp", Long.valueOf(1637429391366L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("product.vo");
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");

// request.setCharacterEncoding("utf-8");
// MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");

// boolean isLogin = false;
// if(memberInfo != null)		isLogin = true;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/reset.css\" />\t\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/base.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/layout.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/footer.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/teststyle.css\" />\t<!-- 테스트용 css -->\r\n");
      out.write("<script src=\"../../js/jquery-3.6.0.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- #header 영역 시작 -->\t\r\n");
      out.write("<div id=\"wrapper\">\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\t<div id=\"logo\"><h1 class=\"logo\"><a href=\"index.jsp\"><img src=\"img/header/logo.png\" alt=\"로고\" class=\"logo\" /></a></h1></div>\r\n");
      out.write("\t<ul id=\"infoMenu\">\r\n");
      out.write("\t\t<li><a href=\"#\">회원가입</a></li>\r\n");
      out.write("\t\t<li><a href=\"#\">로그인</a></li>\r\n");
      out.write("\t\t<li><a href=\"#\">장바구니</a></li>\r\n");
      out.write("\t\t<li><a href=\"#\">마이페이지</a></li>\r\n");
      out.write("\t\t<li><a href=\"#\">고객센터</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<h2>검색 창</h2>\r\n");
      out.write("\t<ul id=\"searchMain\">\r\n");
      out.write("\t\t<li><select class=\"hand\">\r\n");
      out.write("\t\t\t<option value=\"전체\">전체</option>\r\n");
      out.write("\t\t\t<option value=\"가위\">가위</option> \r\n");
      out.write("\t\t\t<option value=\"문구\">문구</option>\r\n");
      out.write("\t\t\t<option value=\"주방\">주방</option>\r\n");
      out.write("\t\t\t<option value=\"etc\">etc</option>\r\n");
      out.write("\t\t\t<option value=\"도전펀딩\">도전펀딩</option>\r\n");
      out.write("\t\t\t<option value=\"펀딩하기\">펀딩하기</option>\r\n");
      out.write("\t\t</select></li>\r\n");
      out.write("\t\t<li><input type=\"text\" /></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<h2>메인 메뉴</h2>\r\n");
      out.write("\t<ul id=\"navigation\">\r\n");
      out.write("\t<!-- 제대로 동작되는놈 : pdt_list.pdt 나머지는 임시 -->\r\n");
      out.write("\t\t<li><a href=\"pdt_list.pdt\">가위</a></li>\r\n");
      out.write("\t\t<li><a href=\"page/product/pdt_office.jsp\">문구</a></li>\r\n");
      out.write("\t\t<li><a href=\"page/product/pdt_kitchen.jsp\">주방</a></li>\r\n");
      out.write("\t\t<li><a href=\"page/product/pdt_etc.jsp\">etc</a></li>\r\n");
      out.write("\t\t<li><a href=\"page/product/chal_funding_list.jsp\">도전펀딩</a></li>\r\n");
      out.write("\t\t<li><a href=\"page/product/funding_list.jsp\">펀딩하기</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<h2>SNS</h2>\r\n");
      out.write("\t<ul id=\"sns\">\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/header/instagram.png\" alt=\"인스타\" /></a></li>\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/header/facebook.jpg\" alt=\"페이스북\" /></a></li>\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/header/twitter.png\" alt=\"트위터\" /></a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- div#header 영역 종료 -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<div class=\"maindiv\">\r\n");
      out.write("    <br /><br /><br /><br />\r\n");
      out.write("    <h2 align=\"center\">내용을 입력하세요</h2>\r\n");
      out.write("    <br />\r\n");
      out.write("\t<h2 align=\"center\"><a href=\"#\" >관리자 페이지 링크를 입력하세요</a></h2>\r\n");
      out.write("\t<br />\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<footer>\r\n");
      out.write("\t<!-- footerInner영역 시작 -->\r\n");
      out.write("\t<div class=\"footerInner\">\r\n");
      out.write("\t\t<div class=\"corp_area\">\r\n");
      out.write("\t\t\t<ul class=\"corp_list\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">이용 약관</a></li> |\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">개인정보 처리방침</a></li> |\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">고객센터</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"company_info_area\">\r\n");
      out.write("\t\t<img src=\"img/logo_long.png\" width=\"191px\" height=\"59px\" alt=\"Logo\" class=\"footerLogo\"/>\r\n");
      out.write("\t\t\t<div class=\"ci_area\">\r\n");
      out.write("\t\t\t\t<ul class=\"company_info\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">회사명</a></li> |\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">대표이사</a></li> |\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">회사 주소</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"ci_area\">\r\n");
      out.write("\t\t\t<ul class=\"company_info\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">사업자 등록번호</a></li> |\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">사업자 정보</a></li> |\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">고객센터 전화번호</a></li> |\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">회사 이메일</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</footer>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write('\r');
      out.write('\n');
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
