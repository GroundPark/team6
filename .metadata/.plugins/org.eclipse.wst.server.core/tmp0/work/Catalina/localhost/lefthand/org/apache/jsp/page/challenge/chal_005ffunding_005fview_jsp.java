/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-12-09 09:58:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page.challenge;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vo.*;
import java.util.*;
import vo.*;

public final class chal_005ffunding_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/page/challenge/../../include/footer.jsp", Long.valueOf(1637830442655L));
    _jspx_dependants.put("/page/challenge/../../include/header.jsp", Long.valueOf(1638693570207L));
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

request.setCharacterEncoding("utf-8");
ChallengePageInfo challengePageInfo = (ChallengePageInfo)request.getAttribute("challengePageInfo");	// 페이징 정보

ChallengeInfo challengeDetail = (ChallengeInfo)request.getAttribute("challengeDetail");		// 게시글 정보가 들어있는 인스턴스
if(challengeDetail == null){
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}
ArrayList<ChallengeReplyList> challengeReplyList = (ArrayList<ChallengeReplyList>)request.getAttribute("challengeReplyList"); // 댓글 정보

ChallengeGoodable goodable = (ChallengeGoodable)request.getAttribute("goodable");

//String args = "?cpage=" + challengePageInfo.getCpage();		
// if(challengepageInfo.getKeyword() != null && !challengepageInfo.getKeyword().equals("")){
// 	args += "&schtype=" + challengepageInfo.getSchtype() + "&keyword=" + challengepageInfo.getKeyword();
// }	// 검색 조건이 있을 경우에만 쿼리스트링으로 만들어 줌


      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/mainLayout.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/chal_funding_detail.css\" />\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/jquery-3.6.0.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 로그인 정보를 담은 인스턴스를 사용하기 위해 import -->\r\n");
      out.write("\t<!-- 멤버의 주소 정보를 담은 인스턴스를 사용하기 위해 import -->\r\n");
      out.write("\r\n");
      out.write("<!-- actionforward를 가 계속 겹치니까 vo를 src밑에 폴더로 vo파일안에 넣는 통합작업 해야함 -->\r\n");
      out.write("<!-- 1~2일뒤에 할예정이므로 일단 위에거 쓰셈 -->\r\n");
      out.write("<!-- 원래는 page import=\"member.vo.*\" 가 맞음!! -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/search.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<div id=\"header\" class=\"header\">\r\n");
      out.write("\t<div id=\"logo\"><h1 class=\"logo\"><a href=\"index.jsp\"><img src=\"img/logo.png\" alt=\"로고\" class=\"logo\" /></a></h1></div>\r\n");
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
      out.write("\t\t<li><input type=\"button\" value=\"검색\" id=\"goSch\" onclick=\"Examine()\" /></li>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<h2>메인 메뉴</h2>\r\n");
      out.write("\t<ul id=\"navigation\">\r\n");
      out.write("\t\t<li><a href=\"pdt_list.pdt?cata=a\">가위</a></li>\r\n");
      out.write("\t\t<li><a href=\"pdt_list.pdt?cata=b\">문구</a></li>\r\n");
      out.write("\t\t<li><a href=\"pdt_list.pdt?cata=c\">주방</a></li>\r\n");
      out.write("\t\t<li><a href=\"pdt_list.pdt?cata=d\">etc</a></li>\r\n");
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
      out.write("<script>\r\n");
      out.write("/* 댓글 300자 제한 */\r\n");
      out.write(" ");

 int myCridx = ( challengeReplyList.size() == 0 ) ? 
		 						-1 : challengeReplyList.get(challengeReplyList.size() - 1).getCr_idx();

 
      out.write("\t\r\n");
      out.write(" $(document).ready(function() {\r\n");
      out.write("\t    $('#write').on('keyup', function() {\r\n");
      out.write("\t        $('#write_cnt').html(\"(\"+$(this).val().length+\" / 300)\");\r\n");
      out.write("\t \r\n");
      out.write("\t        if($(this).val().length > 300) {\r\n");
      out.write("\t            $(this).val($(this).val().substring(0, 300));\r\n");
      out.write("\t            $('#write_cnt').html(\"(300 / 300)\");\r\n");
      out.write("\t        }\r\n");
      out.write("\t    });  \r\n");
      out.write("\t    \r\n");
      out.write("\t    \r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("function replyreg(){\r\n");
      out.write("\t");

    if (!isLogin) {
    
      out.write("\r\n");
      out.write("    alert(\"로그인 후 사용하세요.\");\r\n");
      out.write("\tlocation.href=\"login_form.jsp\";\r\n");
      out.write("\t");

	} else {
	
      out.write("\r\n");
      out.write("    var getReplyContent = $(\"#write\").val();\r\n");
      out.write("    $.ajax({\r\n");
      out.write("    \ttype : \"POST\",\r\n");
      out.write("\t\turl: \"chal_reply_in.chal\",\r\n");
      out.write("\t\tdata : { \r\n");
      out.write("\t\t\t\"ciidx\" : \"");
      out.print(challengeDetail.getCi_idx() );
      out.write("\",\t\r\n");
      out.write("\t\t\t\"cridx\" : \"");
      out.print(myCridx );
      out.write("\",\r\n");
      out.write("\t\t\t\"crcontent\" : getReplyContent \r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\tsuccess: function() {\r\n");
      out.write("\t\t\tlocation.reload();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function callDel(){\r\n");
      out.write("\tif(confirm(\"정말 삭제하시겠습니까?\")){\r\n");
      out.write("\t\tlocation.href=\"chal_del_proc.chal?ciidx=");
      out.print(challengeDetail.getCi_idx() );
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");

int isgood = 0;

System.out.println("도전펀딩 ajax용 검사값 " + goodable.getCg_history());

isgood = goodable.getCg_history();

      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("// 실력딸려서 걍 다 나누고 작업함!\r\n");
      out.write("function heartFlag(obj, idx) {\t\t\r\n");
      out.write("\tvar flag = false;\r\n");
      out.write("\tflag = !flag;\r\n");
      out.write("\t\r\n");
      out.write("\tif (flag) { \t\t// 좋아요 하트 누르면\r\n");
      out.write("\t\tobj.src=\"img/chal_heart_full.png\";\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"POST\",\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\turl : \"chal_view_good.chal\",\t\t\t\t\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\"ci_idx\" : idx,\t\r\n");
      out.write("\t\t\t\t\"cg_history\" : \"1\"\t\t\t\t// 누르면 1\r\n");
      out.write("\t\t\t\t\t},\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\tsuccess : function(chkRs) {\t\t\t\t\t\r\n");
      out.write("\t\t\t\tif (chkRs == 0)\t \talert(\"좋아요 추가 실패\");\r\n");
      out.write("\t\t\t\telse \t\t\t\tlocation.reload();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function heartFlag2(obj, idx) {\t\r\n");
      out.write("\tvar flag2 = false;\r\n");
      out.write("\tflag2 = !flag2;\r\n");
      out.write("\tif (flag2) {\t\t\t\t// 좋아요 하트 취소하면\r\n");
      out.write("\t\tobj.src=\"img/chal_heart_empty.png\";\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"POST\",\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\turl : \"chal_view_good_cancel.chal\",\t\t\t\t\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\"ci_idx\" : idx,\t\r\n");
      out.write("\t\t\t\t\"cg_history\" : \"0\"\t\t\t\t// 취소하면 0\r\n");
      out.write("\t\t\t},\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\tsuccess : function(chkRs) {\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\tif (chkRs == 0)\t \talert(\"좋아요 없애기 실패\");\r\n");
      out.write("\t\t\t\telse \t\t\t\tlocation.reload();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<!-- 도전펀딩 영역 시작  -->\r\n");
      out.write("<article class=\"chalfunding_detail\" >\r\n");
      out.write("\t<div class=\"chalfunding_detail_inner\" >\r\n");
      out.write("\t\t<!-- 도전펀딩 제목 영역 시작  -->\r\n");
      out.write("\t\t<section class=\"chg_top\">\r\n");
      out.write("\t\t\t<div class=\"chg_top_area\">\r\n");
      out.write("\t\t\t\t<div class=\"chg_titl_area\">\r\n");
      out.write("\t\t\t\t\t<p class=\"period_area\">[ 차수 : ");
      out.print(challengeDetail.getCi_step() );
      out.write("차 ] </p>\r\n");
      out.write("\t\t\t\t\t<p class=\"period_area\">");
      out.print(challengeDetail.getCi_sdate().substring(0 , 10) );
      out.write(' ');
      out.write('~');
      out.write(' ');
      out.print(challengeDetail.getCi_edate().substring(0 , 10) );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t<!-- TODO null 해결하고 .substring(0 , 10) 뒤에 붙일것 -->\r\n");
      out.write("\t\t\t\t\t<p class=\"title_area\">");
      out.print(challengeDetail.getCi_title() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t<p class=\"sym_cnt\"> 작성자 : ");
      out.print(challengeDetail.getMi_id() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<button class=\"sym_button\" style=\" margin-right:30px; \">\t\t\r\n");
      out.write("\t\t\t\t");
 if( isgood == 0) { 
      out.write("\r\n");
      out.write("\t\t\t\t<img src=\"img/chal_heart_empty.png\" width=\"100\" height=\"90\" \r\n");
      out.write("\t\t\t\tonclick=\"heartFlag(this, ");
      out.print(challengeDetail.getCi_idx() );
      out.write(");\" style=\"cursor:pointer;\" /><br /><br />\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t<img src=\"img/chal_heart_full.png\" width=\"100\" height=\"90\" \r\n");
      out.write("\t\t\t\tonclick=\"heartFlag2(this, ");
      out.print(challengeDetail.getCi_idx() );
      out.write(");\" style=\"cursor:pointer;\" /><br /><br />\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t<p style=\"font-size:20px\">공감( ");
      out.print(challengeDetail.getCi_good() );
      out.write(" )</p></button>\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t<!-- 도전펀딩 제목 영역 종료  -->\r\n");
      out.write("\t\t<!-- 도전펀딩  설명 영역 시작 -->\r\n");
      out.write("\t\t<section class=\"chg_info\">\r\n");
      out.write("\t\t\t");
 if(!challengeDetail.getCi_img().equals("null")) { 
      out.write("\r\n");
      out.write("\t\t\t<div class=\"info_img_area\">\r\n");
      out.write("\t\t\t<img src=\"page/challenge/userimg/");
      out.print(challengeDetail.getCi_img() );
      out.write("\" width=\"500\" height=\"500\" style=\"margin-bottom: 30px;\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t<div class=\"chal_info_content\">");
      out.print(challengeDetail.getCi_content().replace("\r\n", "<br />") );
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t");
 if (challengeDetail.getMi_id().equals(memberInfo.getMi_id())) { 
      out.write("\r\n");
      out.write("\t\t<div class=\"btn_chal_callDel\" style=\"text-align:right;\"><input type=\"button\" value=\"글 삭제\" onclick=\"callDel();\" style=\"padding:20px 30px; margin:0 30px; \"/></div>\r\n");
      out.write("\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t<div class=\"btn_chal_callDel\" style=\"text-align:right;\"></div>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t<!-- 도전펀딩  설명 영역 종료 -->\r\n");
      out.write("\t\t<!-- 도전펀딩 채팅 영역 시작 -->\r\n");
      out.write("\t\t<section class=\"chg_chat\">\r\n");
      out.write("\t\t\t<div class=\"chg_chat_area\">&nbsp;&nbsp; 댓글 ( ");
      out.print(challengeReplyList.size() );
      out.write(" )</div>\r\n");
      out.write("\t\t\t<div class=\"outerBox\">\r\n");

if(challengeReplyList.size() > 0){
for(int i=0;i<challengeReplyList.size(); i++){
	ChallengeReplyList cri = challengeReplyList.get(i);

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
 if (!challengeDetail.getMi_id().equals(cri.getMi_id()) ) { 
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"innerBox\">\r\n");
      out.write("\t\t\t\t\t<div class=\"circle\"><img src=\"img/circle_1.png\" width=\"100\" height=\"100\" /></div>\r\n");
      out.write("\t\t\t\t\t<div id=\"init\"></div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div id=\"txtBox1\">\t<!-- 왼쪽 댓글 -->\r\n");
      out.write("\t\t\t\t\t\t<p><img src=\"img/chat_topL.png\" width=\"450\" /></p>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"txt1\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>");
      out.print(cri.getMi_id() );
      out.write(" &nbsp; ");
      out.print(cri.getCr_date().substring(0 , 10) );
      out.write("</p><br />\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"chat_txt\">");
      out.print(cri.getCr_content().replace("\r\n", "<br />") );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p><img src=\"img/chat_bottomL.png\" width=\"450\" /></p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t");
 } else if (challengeDetail.getMi_id().equals(cri.getMi_id()) ){ 
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"innerBox2\">\r\n");
      out.write("\t\t\t\t\t<div id=\"txtBox2\">\t<!-- 오른쪽 댓글 : 작성자 -->\r\n");
      out.write("\t\t\t\t\t\t<p><img src=\"img/chat_topR.png\" width=\"450\" /></p>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"txt2\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>");
      out.print(cri.getMi_id() );
      out.write(" &nbsp; ");
      out.print(cri.getCr_date().substring(0 , 10) );
      out.write("</p><br />\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"chat_txt\">");
      out.print(cri.getCr_content().replace("\r\n", "<br />") );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p><img src=\"img/chat_bottomR.png\" width=\"450\" /></p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"circle\"><img src=\"img/circle_2.png\" width=\"100\" height=\"100\" /></div>\r\n");
      out.write("\t\t\t\t\t<div id=\"init2\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t");
 } 
      out.write('	');
      out.write('\r');
      out.write('\n');

	}

}else{
	out.println("<div style='padding:32px 0 48px 0; text-align:center; font-size:1.3em;'>댓글이 없습니다.</div>");
}

      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"writeBox\">\r\n");
      out.write("\t\t\t\t\t<textarea id=\"write\" name=\"write\" cols=\"77\" rows=\"6\"></textarea>\r\n");
      out.write("\t\t\t\t\t<button id=\"btn\" onclick=\"replyreg()\">등록</button><br />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"write_cnt\">(0 / 300)</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t<!-- 도전펀딩 채팅 영역 종료 -->\r\n");
      out.write("\t</div>\r\n");
      out.write("</article>\r\n");
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
