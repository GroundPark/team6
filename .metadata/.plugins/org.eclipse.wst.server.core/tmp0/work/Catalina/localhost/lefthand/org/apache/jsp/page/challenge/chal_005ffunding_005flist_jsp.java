/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-11-27 07:18:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page.challenge;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import challenge.vo.*;
import member.vo.*;

public final class chal_005ffunding_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/page/challenge/../../include/footer.jsp", Long.valueOf(1637830442655L));
    _jspx_dependants.put("/page/challenge/../../include/header.jsp", Long.valueOf(1637949837449L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("member.vo");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("challenge.vo");
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
      out.write("\r\n");

request.setCharacterEncoding("utf-8");

ChallengePageInfo challengePageInfo = (ChallengePageInfo)request.getAttribute("challengePageInfo");	
ArrayList<ChallengeList> challengeList = (ArrayList<ChallengeList>)request.getAttribute("challengeList");
//ChallengeList challenge = (ChallengeList)request.getAttribute("challenge");		

String args ="", schargs = "";
// 검색관련 쿼리스트링 
// if(challengePageInfo.getKeyword() != null && !challengePageInfo.getKeyword().equals(""))	
//	schargs += "&keyword=" + challengePageInfo.getKeyword();

 args = "?cpage=" + challengePageInfo.getCpage() + schargs;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/reset.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mainSlide.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mainLayout.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/base.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/footer.css\" />\r\n");
      out.write("\t<script src=\"js/jquery-3.6.0.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery-ui-1.10.3.custom.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/mainSlide.js\"></script>\r\n");
      out.write("\t<script src=\"js/mainPage_scroll.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write(".chal_funding_contents {\r\n");
      out.write("\twidth:1200px;  margin: 0 auto;\r\n");
      out.write("\r\n");
      out.write("\toverflow:hidden;\r\n");
      out.write("\theight:100%;\t\r\n");
      out.write("\t\r\n");
      out.write("\tpadding-bottom:300px;\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".chal_period { \r\n");
      out.write("\ttext-align:center; padding-bottom:45px; font-size:1.1em; \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".chal_like { \r\n");
      out.write("\tpadding:5px; \r\n");
      out.write("\tposition:absolute;\t \r\n");
      out.write("\ttop:93%; left:68%;\r\n");
      out.write("\twidth:100px; height:20px;\r\n");
      out.write("\tbackground-color:#98ddde;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".chal_ok { \r\n");
      out.write("\tposition:absolute;\t\r\n");
      out.write("\ttop:50%; left:50%;\r\n");
      out.write("\ttransform:translate(-50%, -75%); \r\n");
      out.write("\twidth:100px; height:50px; background-color:rgba(158, 158, 158, 0.5);  \r\n");
      out.write("\tz-index: 0;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tfont-size:1.5em;\r\n");
      out.write("\tpadding:50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".chal_close{\r\n");
      out.write("\tposition:absolute;\t\r\n");
      out.write("\ttop:50%; left:50%;\r\n");
      out.write("\ttransform:translate(-50%, -75%); \r\n");
      out.write("\twidth:100px; height:50px; background-color:rgba(158, 158, 158, 0.5);  \r\n");
      out.write("\tz-index: 0;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tfont-size:1.5em;\r\n");
      out.write("\tpadding:50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".chal{\r\n");
      out.write("\tborder:1px black solid; position:relative; margin:20px; \r\n");
      out.write("\tfloat:left; font-size:1.2em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".challenge_sort {\r\n");
      out.write("\ttext-align:right; padding-right:50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".page_wrapper {\r\n");
      out.write("\tposition:absolute;\r\n");
      out.write("\tleft:0%; bottom:20%;\r\n");
      out.write("\ttransform:translate(0%, -20%); \r\n");
      out.write("\t\r\n");
      out.write("\twidth: 1200px; height: 60px; \r\n");
      out.write("\tpadding-top:50px;\r\n");
      out.write("\tpadding-bottom:50px;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn_chal_funding_write {\r\n");
      out.write("\tposition:absolute;\r\n");
      out.write("\twidth:250px; height:50px;\r\n");
      out.write("\tbackground-color:#dee2e6;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\t\r\n");
      out.write("\tline-height:250%;\r\n");
      out.write("\t\r\n");
      out.write("\tfont-size:1.5em;\r\n");
      out.write("\t\r\n");
      out.write("\ttop:30px; left:20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".chal_step1{\r\n");
      out.write("\tpadding:5px; \r\n");
      out.write("\tposition:absolute;\t \r\n");
      out.write("\ttop:1%; left:1%;\r\n");
      out.write("\twidth:75px; height:75px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".chal_step2{\r\n");
      out.write("\tpadding:5px; \r\n");
      out.write("\tposition:absolute;\t \r\n");
      out.write("\ttop:1%; left:1%;\r\n");
      out.write("\twidth:75px; height:175px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".maindiv{\r\n");
      out.write("\theight: 3000px;\twidth:1200px; margin: 0 auto;\r\n");
      out.write("\tbackground-color:#d3d3d3;\r\n");
      out.write("}\t\r\n");
      out.write("\r\n");
      out.write(".pdt_contents {\r\n");
      out.write("\twidth:1200px;  margin: 0 auto;\r\n");
      out.write("\r\n");
      out.write("\toverflow:hidden;\r\n");
      out.write("\theight:100%;\t\r\n");
      out.write("\t\r\n");
      out.write("\tpadding-bottom:300px;\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".pdt { margin:20px; border:1px black solid; float:left; font-size:1.4em; }\r\n");
      out.write("\r\n");
      out.write(".pdt_price { text-decoration:line-through; color:gray; font-size:0.9em; }\r\n");
      out.write("\r\n");
      out.write(".pdt_real_price { color:red; font-size:1.2em; }\r\n");
      out.write("\r\n");
      out.write(".page_wrapper {\r\n");
      out.write("\tposition:absolute;\r\n");
      out.write("\tleft:0%; bottom:4%;\r\n");
      out.write("\r\n");
      out.write("\twidth: 1200px; height: 60px; \r\n");
      out.write("\tpadding-top:50px;\r\n");
      out.write("\tpadding-bottom:50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("\tpadding-bottom:0px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 로그인 정보를 담은 MemberInfo 인스턴스를 사용하기 위해 import -->\r\n");

MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");

      out.write("\r\n");
      out.write("<!-- #header 영역 시작 -->\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\t<div id=\"logo\"><h1 class=\"logo\"><a href=\"mainPage.jsp\"><img src=\"img/logo.png\" alt=\"로고\" class=\"logo\" /></a></h1></div>\r\n");
      out.write("\t<ul id=\"infoMenu\">\r\n");
 if(memberInfo == null) { 
      out.write("\r\n");
      out.write("\t\t<li><a href=\"#\">회원가입</a></li>\r\n");
      out.write("\t\t<li><a href=\"login_form.jsp\">로그인</a></li>\r\n");
      out.write("\t\t<li><a href=\"login_form.jsp?url=page/order/cart_list.ord\">장바구니</a></li>\r\n");
 } else { 
      out.write("\r\n");
      out.write("\t\t<li>");
      out.print(memberInfo.getMi_name() );
      out.write(" 님, 안녕하세요.</li>\r\n");
      out.write("\t\t<li><a href=\"logout.jsp\">로그아웃</a></li>\r\n");
      out.write("\t\t<li><a href=\"cart_list.ord\">장바구니</a></li>\r\n");
      out.write("\t\t<li><a href=\"#\">마이페이지</a></li>\r\n");
 } 
      out.write("\r\n");
      out.write("\t\t<li><a href=\"#\">고객센터</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<h2>검색 창</h2>\r\n");
      out.write("\t<ul id=\"searchMain\">\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<select class=\"hand\" id=\"search_kind\">\r\n");
      out.write("\t\t\t\t<option value=\"전체\">전체</option>\r\n");
      out.write("\t\t\t\t<option value=\"가위\">가위</option> \r\n");
      out.write("\t\t\t\t<option value=\"문구\">문구</option>\r\n");
      out.write("\t\t\t\t<option value=\"주방\">주방</option>\r\n");
      out.write("\t\t\t\t<option value=\"etc\">etc</option>\r\n");
      out.write("\t\t\t\t<option value=\"도전펀딩\">도전펀딩</option>\r\n");
      out.write("\t\t\t\t<option value=\"펀딩하기\">펀딩하기</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li><input type=\"text\"  id=\"search_bar\" /></li>\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/search_btn.png\" id=\"search_img\" alt=\"검색\" /></a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<h2>메인 메뉴</h2>\r\n");
      out.write("\t<ul id=\"navigation\">\r\n");
      out.write("\t\t<li><a href=\"pdt_list.pdt\">가위</a></li>\r\n");
      out.write("\t\t<li><a href=\"page/product/pdt_office.jsp\">문구</a></li>\r\n");
      out.write("\t\t<li><a href=\"page/product/pdt_kitchen.jsp\">주방</a></li>\r\n");
      out.write("\t\t<li><a href=\"page/product/pdt_etc.jsp\">etc</a></li>\r\n");
      out.write("\t\t<li><a href=\"chal_list.chal\">도전펀딩</a></li>\r\n");
      out.write("\t\t<li><a href=\"fdg_list.fdg\">펀딩하기</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<h2>SNS</h2>\r\n");
      out.write("\t<ul id=\"sns\">\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/instagram.png\" alt=\"인스타\" /></a></li>\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/facebook.jpg\" alt=\"페이스북\" /></a></li>\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"img/twitter.png\" alt=\"트위터\" /></a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- div#header 영역 종료 -->\r\n");
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("<!-- ------------------------------------------------------------------------------------------------ -->\r\n");
      out.write("<div class=\"chal_funding_contents\">\r\n");
      out.write("<div class=\"btn_chal_funding_write\" OnClick=\"location.href=location.href;\" style=\"cursor:pointer;\" >도전펀딩 등록</div>\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<br />\r\n");
      out.write("<div class=\"challenge_sort\">\r\n");
      out.write("<ul id=\"cmb_challenge_sort\">\r\n");
      out.write("\t\t<li><select>\r\n");
      out.write("\t\t\t<option value=\"최신순\">최신순</option>\r\n");
      out.write("\t\t\t<option value=\"인기순\">인기순</option> \r\n");
      out.write("\t\t\t<option value=\"마감임박순\">마감임박순</option>\r\n");
      out.write("\t\t\t<option value=\"1차\">1차</option>\r\n");
      out.write("\t\t\t<option value=\"2차\">2차</option>\r\n");
      out.write("\t\t\t<option value=\"확정\">확정</option>\r\n");
      out.write("\t\t</select></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");

	if(challengeList.size() > 0){
	for(int i=0;i<challengeList.size(); i++){
		ChallengeList ci = challengeList.get(i);
		String lnk = null;
		
		int step = ci.getCi_step(); 
		String status = ci.getCi_status();
		
		// a:진행		b:마감		c:펀딩확정
		// 각각의 경우에 따라 출력. 진행아닌 경우 그냥 보게해도 되는데 만들기 귀찮아서 아예 못들어가게 막음
		if(ci.getCi_status().equals("a")){		
	lnk = "<a href=\"chal_view.chal" + args + "&ciidx=" + ci.getCi_idx() + "&sort=" + challengePageInfo.getSort() +
			"&psize=" +challengePageInfo.getPsize() + "\">";
		}else if (ci.getCi_status().equals("b")){		
	lnk = "<a href=\"javascript:alert('마감된 상품입니다.');\">";
		}else{
	lnk = "<a href=\"javascript:alert('확정된 상품입니다.');\">";		
		}
		
		if(challengePageInfo.getPsize() == 12) {
		// 한 페이지에 12개의 상품 목록을 보여줄 경우(한 줄에 3	개씩 보여줌)
	if(i%3 == 0)		out.println("<div align='center'>");

      out.write("\r\n");
      out.write("<div class=\"chal\">\r\n");
      out.write("\t");
      out.print(lnk );
      out.write("<img src=\"page/challenge/userimg/");
      out.print(ci.getCi_thum_img() );
      out.write("\" style=\"width:350px; height:350px; padding-bottom:25px;\" /><br />\r\n");
      out.write("\t");
 if( status.equals("a") && step == 1 ){ 
      out.write("\r\n");
      out.write("\t<div class=\"chal_step1\"><img src=\"page/challenge/img/step1.png\" style=\"width:75px; height:75px; \" /></div>\r\n");
      out.write("\t");
 } else if (status.equals("a") && step == 2){ 
      out.write("\r\n");
      out.write("\t<div class=\"chal_step2\"><img src=\"page/challenge/img/step2.png\" style=\"width:75px; height:75px; \" /></div>\r\n");
      out.write("\t");
 } else if (status.equals("c")) { 
      out.write("\r\n");
      out.write("\t<div class=\"chal_ok\"> 확 정 </div>\r\n");
      out.write("\t");
 } else { 
      out.write("\r\n");
      out.write("\t<div class=\"chal_close\"> 마 감 </div>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t<div style=\"text-align:center; font-size:1.3em; \"><a href=\"#\">");
      out.print(ci.getCi_title() );
      out.write("</a></div>\r\n");
      out.write("\t<div class=\"chal_period\"> &nbsp;");
      out.print(ci.getCi_sdate().substring(0 , 10) );
      out.write("&nbsp;~&nbsp;");
      out.print(ci.getCi_edate() );
      out.write("-null-null &nbsp; </div>\r\n");
      out.write("\t<div class=\"chal_like\"> ♥  ");
      out.print(ci.getCi_good() );
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

			if(i%4 == 3) 	out.println("</div>");
		}
	}

}else{
	out.println("<div>검색된 상품이 없습니다.</div>");
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 예제 데이터 시작 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"chal\">\r\n");
      out.write("\t<a href=\"#\"><img src=\"page/challenge/img/chal_info_default.png\" style=\"width:350px; height:350px; padding-bottom:25px;\" /></a>\r\n");
      out.write("\t<div class=\"chal_step1\"><img src=\"page/challenge/img/step1.png\" style=\"width:75px; height:75px; \" /></div>\r\n");
      out.write("\t<div style=\"text-align:center; font-size:1.3em; \"><a href=\"#\">* 도전 펀딩 예제 데이터 (이미지 null)</a></div>\r\n");
      out.write("\t<div class=\"chal_period\"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>\r\n");
      out.write("\t<div class=\"chal_like\"> ♥  0  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"chal\">\r\n");
      out.write("\t<a href=\"#\"><img src=\"page/challenge/userimg/thum_chal_info_3.jpg\" style=\"width:350px; height:350px; padding-bottom:25px;\" /></a>\r\n");
      out.write("\t<div class=\"chal_step1\"><img src=\"page/challenge/img/step1.png\" style=\"width:75px; height:75px; \" /></div>\r\n");
      out.write("\t<div style=\"text-align:center; font-size:1.3em; \"><a href=\"#\">* 도전 펀딩 예제 데이터 (1차)</a></div>\r\n");
      out.write("\t<div class=\"chal_period\"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>\r\n");
      out.write("\t<div class=\"chal_like\"> ♥  30  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"chal\">\r\n");
      out.write("\t<a href=\"#\"><img src=\"page/challenge/userimg/thum_chal_info_4.jpg\" style=\"width:350px; height:350px; padding-bottom:25px;\" /></a>\r\n");
      out.write("\t<div class=\"chal_step2\"><img src=\"page/challenge/img/step2.png\" style=\"width:75px; height:75px; \" /></div>\r\n");
      out.write("\t<div style=\"text-align:center; font-size:1.3em; \"><a href=\"#\">* 도전 펀딩 예제 데이터 (2차)</a></div>\r\n");
      out.write("\t<div class=\"chal_period\"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>\r\n");
      out.write("\t<div class=\"chal_like\"> ♥  50  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"chal\">\r\n");
      out.write("\t<a href=\"#\"><img src=\"page/challenge/userimg/thum_chal_info_5.jpg\" style=\"width:350px; height:350px; padding-bottom:25px;\" /></a>\r\n");
      out.write("\t<div class=\"chal_ok\"> 확 정 </div>\r\n");
      out.write("\t<div style=\"text-align:center; font-size:1.3em; \"><a href=\"#\">* 도전 펀딩 예제 데이터 (확정)</a></div>\r\n");
      out.write("\t<div class=\"chal_period\"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>\r\n");
      out.write("\t<div class=\"chal_like\"> ♥  200  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"chal\">\r\n");
      out.write("\t<a href=\"#\"><img src=\"page/challenge/userimg/thum_chal_info_2.jpg\" style=\"width:350px; height:350px; padding-bottom:25px;\" /></a>\r\n");
      out.write("\t<div class=\"chal_close\"> 마 감 </div>\r\n");
      out.write("\t<div style=\"text-align:center; font-size:1.3em; \"><a href=\"#\">* 도전 펀딩 예제 데이터 (마감)</a></div>\r\n");
      out.write("\t<div class=\"chal_period\"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>\r\n");
      out.write("\t<div class=\"chal_like\"> ♥  200  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- 예제 데이터 끝 -->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

if (challengeList.size() > 0){
// 상품 검색결과가 있으면 페이지 번호를 출력
	out.println("<div class='page_wrapper'>");
	out.println("<p style='font-size:1.25em; width:100%;' align='center'>");

	args = "?sort=" + challengePageInfo.getSort() + "&psize=" + challengePageInfo.getPsize() + schargs;
	
		if(challengePageInfo.getCpage() == 1){				
			out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
		}else{
			out.print("<a href='chal_list.chal" + args + "&cpage=1'>[&lt;&lt;]</a>&nbsp;&nbsp;");
			out.println("<a href='chal_list.chal" + args + "&cpage=" + (challengePageInfo.getCpage() - 1) + "'>[&lt;]</a>&nbsp;&nbsp;");
		}
		
		for(int i=1, j=challengePageInfo.getSpage(); i<= challengePageInfo.getBsize() && j <= challengePageInfo.getEpage(); i++, j++){
		// i : 루프 돌릴 횟수 검사하는 용도의 변수, j : 페이지 번호 출력용 변수
			if(challengePageInfo.getCpage() == j){
				out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
			}else{
				out.print("&nbsp;<a href='chal_list.chal" +args + "&cpage=" +j + "'>" + j + "</a>&nbsp;");
			}
		}
		
		
		if(challengePageInfo.getCpage() == challengePageInfo.getPcnt()){
			out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
		}else{
			out.print("&nbsp;&nbsp;<a href='chal_list.chal" + args + "&cpage=" + (challengePageInfo.getCpage() + 1 ) + "'>[&gt;]</a>");
			out.println("&nbsp;&nbsp;<a href='chal_list.chal" +args + "&cpage=" + (challengePageInfo.getPcnt()) + "'>[&gt;&gt;]</a>");
		}

	out.println("</p>");
	out.println("</div>");
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!-- ------------------------------------------------------------------------------------------------ -->\r\n");
      out.write("</main>\r\n");
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
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
