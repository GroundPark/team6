/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-12-12 10:09:34 UTC
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

public final class admin_005forder_005ffdgList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
ArrayList<FdgOrderInfo> fdgOrderList = (ArrayList<FdgOrderInfo>)request.getAttribute("fdgOrderList");
AdminOrderFdgPageInfo adminOrderFdgPageInfo = (AdminOrderFdgPageInfo)request.getAttribute("adminOrderFdgPageInfo");

 String args ="", schargs = "";

// 검색관련 쿼리스트링 
if (adminOrderFdgPageInfo.getSchtype() == null || adminOrderFdgPageInfo.getKeyword() == null) {
	adminOrderFdgPageInfo.setSchtype("");	adminOrderFdgPageInfo.setKeyword("");
} else if (!adminOrderFdgPageInfo.getKeyword().equals("") && !adminOrderFdgPageInfo.getSchtype().equals("") ) {
	 schargs ="&schtype=" + adminOrderFdgPageInfo.getSchtype() + "&keyword=" + adminOrderFdgPageInfo.getKeyword();
}
args = "?cpage=" + adminOrderFdgPageInfo.getCpage() + schargs;

DecimalFormat formatter = new DecimalFormat("#,##0"); 

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("#brd th { border-top:2px solid #aaa; border-bottom:1px #aaa solid; text-align:center; font-weight:bold; background:#ddd; }\r\n");
      out.write("#brd tr:last-child > td { border-bottom:2px #aaa solid; }\r\n");
      out.write("#brd { padding-bottom:20px; }\r\n");
      out.write("#btn { width:100%; }\r\n");
      out.write("section #cata { float:left; padding-left:0px; }\r\n");
      out.write("section #sort { float:right; padding-right:40px; }\r\n");
      out.write("section #cata li { display:inline-block; padding-bottom:10px; }\r\n");
      out.write("section #search { width:100px; }\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("function sortChange(url) {\r\n");
      out.write("\tlocation.href = url;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
      out.write("\t<h2>펀딩 주문 목록</h2>\r\n");
      out.write("\t<h2>검색 창</h2>\r\n");
      out.write("\t<form name =\"frmSch\" method=\"get\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"sort\" value=\"");
      out.print(adminOrderFdgPageInfo.getSort() );
      out.write("\" /> \r\n");
      out.write("\t<ul id=\"cata\">\r\n");
      out.write("\t\t<li><select name=\"schtype\" class=\"hand\">\r\n");
      out.write("\t\t\t \t<option value=\"miid\" ");
 if (adminOrderFdgPageInfo.getSchtype().equals("miid")) { 
      out.write(" selected=\"selected\" ");
 } 
      out.write(">회원ID</option> \r\n");
      out.write("\t\t\t\t<option value=\"foiid\" ");
 if (adminOrderFdgPageInfo.getSchtype().equals("foiid")) { 
      out.write(" selected=\"selected\" ");
 } 
      out.write(">주문번호</option> \r\n");
      out.write("\t\t\t\t<option value=\"foistatus\" ");
 if (adminOrderFdgPageInfo.getSchtype().equals("foistatus")) { 
      out.write(" selected=\"selected\" ");
 } 
      out.write(">주문상태</option>\r\n");
      out.write("\t\t</select></li>\r\n");
      out.write("\t\t<li><input type=\"text\" name=\"keyword\" value=\"");
      out.print(adminOrderFdgPageInfo.getKeyword() );
      out.write("\"  /></li>\r\n");
      out.write("\t\t<li><input type=\"submit\" value=\"검색\" /></li>\r\n");
      out.write("\t</ul>\t\t\t\r\n");
      out.write("\t<ul id=\"sort\">\r\n");
      out.write("\t\t<li><select class=\"hand\" onchange=\"sortChange(this.value);\">\r\n");
      out.write("\t\t\t<option value=\"order_fdg.adminord");
      out.print(args );
      out.write("&sort=datea\" \r\n");
      out.write("\t\t\t\t");
 if (adminOrderFdgPageInfo.getSort().equals("datea")) { 
      out.write(" selected=\"selected\" ");
 } 
      out.write(">주문일-오름차순</option> \r\n");
      out.write("\t\t\t<option value=\"order_fdg.adminord");
      out.print(args );
      out.write("&sort=dated\" \r\n");
      out.write("\t\t\t\t");
 if (adminOrderFdgPageInfo.getSort().equals("dated")) { 
      out.write(" selected=\"selected\" ");
 } 
      out.write(">주문일-내림차순</option>\r\n");
      out.write("\t\t</select></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 주문 리스트 영역 시작 -->\r\n");
      out.write("\t<table width=\"900\" cellpadding=\"7\" cellspacing=\"0\" id=\"brd\">\r\n");
      out.write("\t<tr height=\"30px\">\r\n");
      out.write("\t\t<th width=\"8%\">번호</th><th width=\"*\">주문번호</th><th width=\"15%\">회원ID</th><th width=\"15%\">결제액(원)</th>\r\n");
      out.write("\t\t<th width=\"20%\">주문일</th><th width=\"15%\">주문상태</th><th width=\"12%\">수정 관리자</th>\r\n");
      out.write("\t</tr>\r\n");

if(fdgOrderList.size() > 0 && adminOrderFdgPageInfo.getRcnt() > 0){	// 보여줄 게시글 목록이 있으면
	int num = adminOrderFdgPageInfo.getRcnt() - (adminOrderFdgPageInfo.getPsize() * (adminOrderFdgPageInfo.getCpage() - 1));
	for (int i = 0; i < fdgOrderList.size(); i++) {		
		FdgOrderInfo oi = fdgOrderList.get(i);
		String lnk = null;
		
		String status = "";
		if (oi.getFoi_status().equals("a"))			status = "입금대기중";
		else if (oi.getFoi_status().equals("b"))	status = "결제완료";
		else if (oi.getFoi_status().equals("c"))	status = "물품제작중";
		else if (oi.getFoi_status().equals("d"))	status = "배송준비중";
		else if (oi.getFoi_status().equals("e"))	status = "배송중";
		else if (oi.getFoi_status().equals("f"))	status = "배송완료";

		String aiidx = "";
		if (oi.getAi_idx() != 0)	aiidx = oi.getAi_idx() + "";
		
		lnk = "order_fdg_view.adminord" + args + "&foiid=" + oi.getFoi_id() + "&miid=" + oi.getMi_id() + 
				"&sort=" + adminOrderFdgPageInfo.getSort() + "&psize=" + adminOrderFdgPageInfo.getPsize();				

      out.write("\r\n");
      out.write("\t<tr style=\"cursor:pointer\" align=\"center\" height=\"30px\" onmouseover=\"this.style.background = '#efefef';\" onmouseout=\"this.style.background = '';\"  \r\n");
      out.write("\t\tonclick=\"location.href='");
      out.print(lnk );
      out.write("'\">\r\n");
      out.write("\t<td>");
      out.print(num );
      out.write("</td> \r\n");
      out.write("\t<td onmouseover=\"chgunderline\">");
      out.print(oi.getFoi_id() );
      out.write("</td>\r\n");
      out.write("\t<td>");
      out.print(oi.getMi_id() );
      out.write("</td> \r\n");
      out.write("\t<td>");
      out.print(formatter.format(oi.getFoi_pay()) );
      out.write("</td>\r\n");
      out.write("\t<td>");
      out.print(oi.getFoi_date() );
      out.write("</td> \r\n");
      out.write("\t<td>");
      out.print(status );
      out.write("</td>\r\n");
      out.write("\t<td>");
      out.print(aiidx );
      out.write("</td>\r\n");
 	
		num--;
	}	
	
} else {
	out.println("<tr><td colspan='5' align='center'>검색 결과가 없습니다.</td></tr>");
}

      out.write("\t\t\r\n");
      out.write("\t</table><br />\r\n");
      out.write("\t<!-- 주문 리스트 영역 종료 -->\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 페이징 영역 시작 -->\r\n");
      out.write("\t<table width=\"900\" cellpadding=\"5\" cellspacing=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td width=\"900\" align=\"center\">\r\n");
      out.write("\t");

	if(fdgOrderList.size() > 0 && adminOrderFdgPageInfo.getRcnt() > 0){	// 보여줄 게시글 목록이 있으면  페이지 번호를 보여줌
		String pageLink = "order_fdg.adminord?cpage=";
		if (adminOrderFdgPageInfo.getCpage() == 1){
			out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
		} else {
			out.print("<a href='" + pageLink + "1" + schargs + "'>[&lt;&lt;]</a>&nbsp;&nbsp;");
			out.println("<a href='" + pageLink + (adminOrderFdgPageInfo.getCpage() - 1) + schargs + "'>[&lt;]</a>&nbsp;&nbsp;");
		}
		
		for(int i = 1, j = adminOrderFdgPageInfo.getSpage(); i <= adminOrderFdgPageInfo.getBsize() && j <= adminOrderFdgPageInfo.getEpage() ; i++, j++){
		// i: 루프를 돌릴 횟수를 검사하는 용도의 변수, j : 페이지 번호 출력용 변수(블록사이즈는 5니까 5번이 최대로 돌리는 거 아닐까??) 맞음.. 한페이지에 5개의 페이지가 보이니까
			if(adminOrderFdgPageInfo.getCpage() == j) {
				out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
			} else {
				out.print("&nbsp;<a href='" + pageLink + j + schargs + "'>" + j + "</a>&nbsp;");
			}
		}
		
		if (adminOrderFdgPageInfo.getCpage() == adminOrderFdgPageInfo.getPcnt()) {
			out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
		} else {
			out.print("&nbsp;&nbsp;<a href='" + pageLink + (adminOrderFdgPageInfo.getCpage() + 1) + schargs + "'>[&gt;]</a>");
			out.println("&nbsp;&nbsp;<a href='" + pageLink + (adminOrderFdgPageInfo.getPcnt()) + schargs + "'>[&gt;&gt;]</a>");
		}
	}
	
      out.write("\r\n");
      out.write("\t</td></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<!-- 페이징 영역 시작 -->\r\n");
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
