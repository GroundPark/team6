/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-12-12 15:52:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page.funding;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vo.*;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.text.DecimalFormat;
import vo.*;

public final class fdg_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/page/funding/../../include/header.jsp", Long.valueOf(1639294333316L));
    _jspx_dependants.put("/page/funding/../../include/footer.jsp", Long.valueOf(1639049464000L));
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
    _jspx_imports_classes.add("java.time.temporal.ChronoUnit");
    _jspx_imports_classes.add("java.time.LocalDate");
    _jspx_imports_classes.add("java.text.DecimalFormat");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");

request.setCharacterEncoding("utf-8");

ArrayList<FundingInfo> fdgList = (ArrayList<FundingInfo>)request.getAttribute("fdgList");
FundingInfo fdg = new FundingInfo();
FdgPageInfo fdgPageInfo = (FdgPageInfo)request.getAttribute("fdgPageInfo");

String args ="";
DecimalFormat formatter = new DecimalFormat("#,##0");
args = "?cpage=" + fdgPageInfo.getCpage();

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/funding_list.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n");
      out.write("\t<script src=\"js/jquery-3.6.0.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery-ui-1.10.3.custom.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/mainSlide.js\"></script>\r\n");
      out.write("\t<script src=\"js/mainPage_scroll.js\"></script>\r\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("  \t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
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
      out.write("<script>\r\n");
      out.write("function fundingarray(url) {\r\n");
      out.write("\tlocation.href = url\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<!-- ------------------------------------------------------------------------------------------------ -->\r\n");
      out.write("<div class=\"fdg_contents\" >\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<ul class=\"fundingsearch\">\r\n");
      out.write("\t<li>\r\n");
      out.write("\t\t<select onchange=\"fundingarray(this.value)\"> <!-- ??????(??????), ?????????, ?????????, ????????????????????? ?????? ?????? -->\r\n");
      out.write("\t\t\t<option value=\"\">??????</option>\r\n");
      out.write("\t\t\t<option value=\"fdg_list.fdg");
      out.print(args );
      out.write("&sort=rated\">?????????</option>\r\n");
      out.write("\t\t\t<option value=\"fdg_list.fdg");
      out.print(args );
      out.write("&sort=sdated\">?????????</option>\r\n");
      out.write("\t\t\t<option value=\"fdg_list.fdg");
      out.print(args );
      out.write("&sort=edatea\">???????????????</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t</li>\r\n");
      out.write("</ul>\r\n");

	if(fdgList.size() > 0) {
		   for(int i = 0 ; i < fdgList.size() ; i++) {
			   FundingInfo fi = fdgList.get(i);
		        String lnk = null;

		        String status = fi.getFi_status();

		        // a:?????????        b:????????????        c:????????????
		        // ????????? ????????? ?????? ??????
		        if(!fi.getFi_status().equals("c")) {
		        	lnk = "<a href=\"fdg_view.fdg" + args + "&fiidx=" + fi.getFi_idx() + "&sort=" + fdgPageInfo.getSort() + "&psize=" + fdgPageInfo.getPsize() + "\">";
		        } else {
		        	lnk = "<a href=\"javascript:alert('??????????????? ???????????????.');\">";
		        }
				
		        /////
		        // 11-27 ????????? ?????? : N??? ?????? ?????????
		        ///// 
		        
		        LocalDate sDate = LocalDate.now();
		        LocalDate eDate = LocalDate.parse(fi.getFi_edate());
		    
		        long calDay = ChronoUnit.DAYS.between(sDate, eDate);
				// System.out.println(calDay);
		
		        if(fdgPageInfo.getPsize() == 12) {
		        // ??? ???????????? 12?????? ?????? ????????? ????????? ??????(??? ?????? 3?????? ?????????)
		    if(i % 3 == 0)	out.println("<div align='center'>");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"fdg\">\r\n");
      out.write("\t");
      out.print(lnk );
      out.write("<img src=\"page/funding/img/");
      out.print(fi.getFi_img1() );
      out.write("\" style=\"width:350px; height:350px; padding-bottom:25px;\" /></a>\r\n");
      out.write("\t<div style=\"text-align:center;\"><a href=\"#\">");
      out.print(fi.getFi_name() );
      out.write("</a></div>\r\n");
      out.write("\t<table width=\"100%\">\r\n");
      out.write("\t\t<tr><td style=\"text-align:center\"><b>");
      out.print(String.format("%.0f", fi.getFi_rate() * 100 ) );
      out.write(" %</b></td>\r\n");
      out.write("\t\t<td style=\"text-align:center; font-size:95%\" > ");
      out.print(formatter.format(fi.getFi_total()) );
      out.write(" ???</td>\r\n");
      out.write("\t\t<td style=\"text-align:center\">");
      out.print(calDay );
      out.write("?????????</td></tr>\r\n");
      out.write("\t\t\t<div class=\"progress\">\r\n");
      out.write("\t\t\t");
 if(fi.getFi_rate() * 100 < 100) { 
      out.write("\t\t\t\r\n");
      out.write("\t\t\t    <div class=\"progress-bar progress-bar-striped active\" role=\"progressbar\" aria-valuenow=\"70\" aria-valuemin=\"0\" aria-valuemax=\"100\" \r\n");
      out.write("\t\t\t    \tstyle=\"width:");
      out.print(fi.getFi_rate() * 100 );
      out.write("%\">\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"progress-bar progress-bar-striped\" role=\"progressbar\" aria-valuenow=\"50\" aria-valuemin=\"0\" aria-valuemax=\"100\" \r\n");
      out.write("\t\t\t    \tstyle=\"width:");
      out.print(fi.getFi_rate() * 100 );
      out.write("%\">\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");

if(i % 4 == 3)   out.println("</div>");

if(i == fdgList.size() - 1 && i % 4 != 3){   
   // ?????? ???????????? ???????????? pdtList??? ????????? ?????????????????? 3?????? ?????? ????????? ????????? ??????
   out.println("</div>");
}
}
}

}else{
out.println("<div>????????? ????????? ????????????.</div>");
}

      out.write('\r');
      out.write('\n');

if (fdgList.size() > 0){
// ?????? ??????????????? ????????? ????????? ????????? ??????
	out.println("<div class='page_wrapper'>");
	out.println("<p style='font-size:1.25em; width:100%;' align='center' font-color:black>");

	args = "?sort=" + fdgPageInfo.getSort() + "&psize=" + fdgPageInfo.getPsize();
	
		if(fdgPageInfo.getCpage() == 1){				
			out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
		}else{
			out.print("<a href='fdg_list.fdg" + args + "&cpage=1'>[&lt;&lt;]</a>&nbsp;&nbsp;");
			out.println("<a href='fdg_list.fdg" + args + "&cpage=" + (fdgPageInfo.getCpage() - 1) + "'>[&lt;]</a>&nbsp;&nbsp;");
		}
		
		for(int i = 1, j = fdgPageInfo.getSpage(); i <= fdgPageInfo.getBsize() && j <= fdgPageInfo.getEpage() ; i++, j++){
		// i : ?????? ?????? ?????? ???????????? ????????? ??????, j : ????????? ?????? ????????? ??????
			if(fdgPageInfo.getCpage() == j){
				out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
			}else{
				out.print("&nbsp;<a href='fdg_list.fdg" + args + "&cpage=" +j + "'>" + j + "</a>&nbsp;");
			}
		}
		
		
		if(fdgPageInfo.getCpage() == fdgPageInfo.getPcnt()){
			out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
		}else{
			out.print("&nbsp;&nbsp;<a href='fdg_list.fdg" + args + "&cpage=" + (fdgPageInfo.getCpage() + 1 ) + "'>[&gt;]</a>");
			out.println("&nbsp;&nbsp;<a href='fdg_list.fdg" +args + "&cpage=" + (fdgPageInfo.getPcnt()) + "'>[&gt;&gt;]</a>");
		}

	out.println("</p>");
	out.println("</div>");
}

      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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
