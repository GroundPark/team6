/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-12-12 09:24:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page.challenge;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vo.*;
import java.time.LocalDateTime;
import vo.*;

public final class chal_005ffunding_005fin_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/page/challenge/../../include/footer.jsp", Long.valueOf(1639049464000L));
    _jspx_dependants.put("/page/challenge/../../include/header.jsp", Long.valueOf(1639294333316L));
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
    _jspx_imports_classes.add("java.time.LocalDateTime");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\" >\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mainLayout.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/chal_funding_list.css\" />\r\n");
      out.write("\t<script src=\"js/jquery-3.6.0.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery-ui-1.10.3.custom.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/mainSlide.js\"></script>\r\n");
      out.write("\t<script src=\"js/mainPage_scroll.js\"></script>\r\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<script>\r\n");
      out.write("// js??? ?????????????????? 1?????? ?????????\r\n");
      out.write("\r\n");
      out.write("// ????????? 5MB ????????? ??????????????? 5MB?????? ????????? ?????? ??????????????? ????????? \r\n");
      out.write("// \talert(\"????????? ?????? ????????? 5MB?????? ???????????????.\");\t\r\n");
      out.write("\r\n");
      out.write("// ?????? ????????? ?????? ??? id??? ???????????? ??????????????? ????????? ???????????? ????????? ??????????????????\r\n");
      out.write("// ?????????????????? ????????? ?????????????????? ???????????? ????????? ????????????\r\n");
      out.write("// \talert(\"???????????? ??????????????? ??????????????????.\");\t\r\n");
      out.write("\r\n");
      out.write("function isImg(imgstr){\r\n");
      out.write("\t// ????????????????????? ?????? ?????? : ???????????? ?????????\r\n");
      out.write("\tvar arrImg = [\"jpg\", \"gif\", \"png\", \"jpeg\", \"JPG\", \"GIF\", \"PNG\", \"JPEG\"];\r\n");
      out.write("\tvar ext = imgstr.substring(imgstr.lastIndexOf(\".\") + 1);\r\n");
      out.write("\t\tfor(var i=0;i<arrImg.length;i++){\r\n");
      out.write("\t\t\tif(ext==arrImg[i])\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn false;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function chkImg(filename){\r\n");
      out.write("\tif(!isImg(filename)){\r\n");
      out.write("\t\talert(\"????????? ????????? ????????? ?????????. [ jpg, gif, png, jpeg ]\");\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"image\").value = \"\"; \r\n");
      out.write("\t\treturn false;\t\t\t\r\n");
      out.write("\t}   \r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("\r\n");
      out.write("\t<!-- ????????? ????????? ?????? ??????????????? ???????????? ?????? import -->\r\n");

request.setCharacterEncoding("utf-8");

String sch_kind = request.getParameter("sch_kind");
if (sch_kind == null)	sch_kind = "";

String keyword = request.getParameter("keyword");
if (keyword == null)	keyword = "";

MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
boolean isLogin = false;
if (memberInfo != null)	isLogin = true;

      out.write("\r\n");
      out.write("<!-- #header ?????? ?????? -->\r\n");
      out.write("<!-- ?????? ??????????????? ???????????? css -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/reset.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/base.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/footer.css\" />\r\n");
      out.write("<script src=\"js/search.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("<div id=\"header\" class=\"header\">\r\n");
      out.write("\t<div id=\"logo\"><h1 class=\"logo\"><a href=\"index.jsp\"><img src=\"img/logo.png\" alt=\"??????\" class=\"logo\" /></a></h1></div>\r\n");
      out.write("\t<ul id=\"infoMenu\">\r\n");
 if(memberInfo == null) { 
      out.write("\r\n");
      out.write("\t\t<li><a href=\"#\">????????????</a></li>\r\n");
      out.write("\t\t<li><a href=\"login_form.jsp\">?????????</a></li>\r\n");
      out.write("\t\t<li><a href=\"login_form.jsp?url=cart_list.ord\">????????????</a></li>\r\n");
 } else { 
      out.write("\r\n");
      out.write("\t\t<li>");
      out.print(memberInfo.getMi_name() );
      out.write(" ???, ???????????????.</li>\r\n");
      out.write("\t\t<li><a href=\"logout.jsp\">????????????</a></li>\r\n");
      out.write("\t\t<li><a href=\"cart_list.ord\">????????????</a></li>\r\n");
      out.write("\t\t<li><a href=\"mypage.mem\">???????????????</a></li>\r\n");
 } 
      out.write("\r\n");
      out.write("\t\t<li><a href=\"#\">????????????</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<h2>?????? ???</h2>\r\n");
      out.write("\t<!-- js??? select??? ?????? ????????? ??? ??? ?????? ?????? action??? ?????? ???????????? ????????????? -->\r\n");
      out.write("\t<form name=\"frmSch\" action=\"#\" method=\"get\" >\r\n");
      out.write("\t<ul id=\"searchMain\">\r\n");
      out.write("\t\t<li><select class=\"hand\" id=\"search_kind\" name=\"sch_kind\">\r\n");
      out.write("\t\t\t<option value=\"??????\" ");
 if(sch_kind.equals("??????")) { 
      out.write(" selected=\"selected\" ");
 } 
      out.write(">????????????</option>\r\n");
      out.write("\t\t\t<option value=\"??????\" ");
 if(sch_kind.equals("??????")) { 
      out.write(" selected=\"selected\" ");
 } 
      out.write(">????????????</option>\r\n");
      out.write("\t\t\t<option value=\"??????\" ");
 if(sch_kind.equals("??????")) { 
      out.write(" selected=\"selected\" ");
 } 
      out.write(">????????????</option>\r\n");
      out.write("\t\t </select></li>\r\n");
      out.write("\t\t<li><input type=\"text\"  id=\"search_bar\" name=\"keyword\" onkeydown=\"enterkey();\" value=\"");
      out.print( keyword );
      out.write("\" /></li>\r\n");
      out.write("\t\t<li><button type=\"image\" id=\"goSch\"><img src=\"img/search_btn_white.png\" width=\"25\" onclick=\"Examine()\" /></button></li>\r\n");
      out.write("<!-- \t\t<input type=\"image\" value=\"??????\" id=\"goSch\" onclick=\"Examine()\" />\t -->\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<h2>?????? ??????</h2>\r\n");
      out.write("\t\r\n");
      out.write("\t<h2>SNS</h2>\r\n");
      out.write("\t<ul id=\"sns\">\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/instagram.png\" alt=\"?????????\" /></a></li>\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/facebook.jpg\" alt=\"????????????\" /></a></li>\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/twitter.png\" alt=\"?????????\" /></a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("</header>\r\n");
      out.write("<!-- div#header ?????? ?????? -->\r\n");
      out.write("\r\n");
      out.write("<!-- nav ?????? ?????? -->\r\n");
      out.write("<nav id=\"navBox\">\r\n");
      out.write("<ul id=\"navigation\">\r\n");
      out.write("\t<li><a href=\"pdt_list.pdt?cata=a\">??????</a></li>\r\n");
      out.write("\t<li><a href=\"pdt_list.pdt?cata=b\">??????</a></li>\r\n");
      out.write("\t<li><a href=\"pdt_list.pdt?cata=c\">??????</a></li>\r\n");
      out.write("\t<li><a href=\"pdt_list.pdt?cata=d\">etc</a></li>\r\n");
      out.write("\t<li><a href=\"chal_list.chal\">????????????</a></li>\r\n");
      out.write("\t<li><a href=\"fdg_list.fdg\">????????????</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("</nav>\r\n");
      out.write("<!-- nav ?????? ?????? -->\r\n");
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");

if (!isLogin) {
	out.println("<script>");
	out.println("alert('????????? ??? ???????????????.');");
	out.println("location.href='login_form.jsp';");
	out.println("</script>");
	out.close();
}

      out.write("\r\n");
      out.write("<!-- ------------------------------------------------------------------------------------------------ -->\r\n");

LocalDateTime now = LocalDateTime.now();
LocalDateTime edate = now.plusDays(7);

      out.write("\r\n");
      out.write("<div class=\"panel panel-default\" style=\"border:0px;\">\r\n");
      out.write("<div class=\"panel-body\" style=\"padding-top:100px;\"> \r\n");
      out.write("<div class=\"container\" style=\"border:0px;\">\r\n");
      out.write("\t<form action=\"chal_in_proc.chal\" method=\"post\" enctype=\"multipart/form-data\">  \r\n");
      out.write("\t<input type=\"hidden\" name=\"edate\" value=\"");
      out.print(edate );
      out.write("\" />\r\n");
      out.write("\t<!-- ?????? ????????? edate + 7????????? hidden?????? ?????? -->\r\n");
      out.write("\t<div class=\"form-group\"  style=\"border:0px;\">\r\n");
      out.write("\t<label for=\"ci_title\">??????</label>\r\n");
      out.write("\t<input type=\"text\" class=\"form-control\" name =\"ci_title\" id=\"ci_title\" placeholder=\"?????? ?????? ????????? ???????????????.\" value=\"????????? ??????\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"form-group\">\r\n");
      out.write("\t<label for=\"ci_content\">??? ??????:</label>\r\n");
      out.write("\t<textarea class=\"form-control\" rows=\"20\" name=\"ci_content\" id=\"ci_content\">????????? ????????? ??????</textarea>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"form-group\">\r\n");
      out.write("\t<label for=\"File\">?????? ????????? [ jpg, gif, png, jpeg ]</label>\r\n");
      out.write("\t<input type=\"file\" name=\"image\" id=\"image\" onchange=\"chkImg(this.value)\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"center-block\" style='width:400px'>\r\n");
      out.write("\t<input type=\"submit\" value=\"????????????\" style=\"padding:20px 30px; margin:0 30px;\" /> \r\n");
      out.write("\t<input type=\"button\" value=\"????????????\" style=\"padding:20px 30px; margin:0 30px;\" onclick=\"location.href='chal_list.chal';\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</form> \r\n");
      out.write("</div>\r\n");
      out.write("</div> <!--panel end-->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!-- ------------------------------------------------------------------------------------------------ -->\r\n");
      out.write("</main>\r\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<footer>\n");
      out.write("\t<!-- footerInner?????? ?????? -->\n");
      out.write("\t<div class=\"footerInner\">\n");
      out.write("\t\t<div class=\"corp_area\">\n");
      out.write("\t\t\t<ul class=\"corp_list\">\n");
      out.write("\t\t\t\t<li><a href=\"#\">?????? ??????</a></li> |\n");
      out.write("\t\t\t\t<li><a href=\"#\">???????????? ????????????</a></li> |\n");
      out.write("\t\t\t\t<li><a href=\"#\">????????????</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"company_info_area\">\n");
      out.write("\t\t<img src=\"img/logo_long.png\" width=\"191px\" height=\"59px\" alt=\"Logo\" class=\"footerLogo\"/>\n");
      out.write("\t\t\t<div class=\"ci_area\">\n");
      out.write("\t\t\t\t<ul class=\"company_info\">\n");
      out.write("\t\t\t\t\t<li>?????????&nbsp;(???)???????????????</li>&nbsp;&nbsp;|&nbsp;&nbsp;\n");
      out.write("\t\t\t\t\t<li>????????????&nbsp;?????????</li>&nbsp;&nbsp;|&nbsp;&nbsp;\n");
      out.write("\t\t\t\t\t<li>??????&nbsp;??????????????? ????????? ???????????? 428 ???????????? 5, 10???</li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"ci_area\">\n");
      out.write("\t\t\t<ul class=\"company_info\">\n");
      out.write("\t\t\t\t<li>????????? ????????????&nbsp;112-39-54678</li>&nbsp;&nbsp;|&nbsp;&nbsp;\n");
      out.write("\t\t\t\t<li>???????????? ????????????&nbsp;1546-6557</li>&nbsp;&nbsp;|&nbsp;&nbsp;\n");
      out.write("\t\t\t\t<li>?????? ?????????&nbsp;leftystore@lefty.com</li>\n");
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
