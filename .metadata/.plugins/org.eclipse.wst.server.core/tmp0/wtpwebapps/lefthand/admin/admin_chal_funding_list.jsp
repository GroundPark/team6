<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%

request.setCharacterEncoding("utf-8");

PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");	
ArrayList<AdminChallengeList> adminChallengeList = (ArrayList<AdminChallengeList>)request.getAttribute("adminChallengeList");
//ChallengeList challenge = (ChallengeList)request.getAttribute("challenge");		

 

 String args = "", schargs = "";
 if (pageInfo.getSchtype() == null || pageInfo.getKeyword() == null) {
 	pageInfo.setSchtype("");	pageInfo.setKeyword("");
 	// 검색 관련 정보가 null인 경우 빈 문자열로 변경함; 이거 안하면 텍스트박스에 문자열 null찍혀서 굉장히 구려보임
 }else if(!pageInfo.getKeyword().equals("") && !pageInfo.getSchtype().equals("")){	// 빈문자일 경우 일그냥 안할거
 	schargs = "&schtype=" + pageInfo.getSchtype() + "&keyword=" + pageInfo.getKeyword();	
 }

 args = "?cpage=" + pageInfo.getCpage() + schargs;
 
 
 
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#brd th { 
border-top:2px solid #aaa; border-bottom:1px #aaa solid; 
text-align:center; font-weight:bold; background:#ddd; 
}
#brd tr:last-child > td { border-bottom:2px #aaa solid; }
#brd { padding-top:15px; padding-bottom:20px; }
#btn { width:100%; }
section #cata { padding-top:15px; float:right; padding-right:40px; }
section #sort { padding-top:15px; float:right; padding-right:40px; }
section #cata li { display:inline-block; padding-bottom:10px; }
section #search { width:100px; padding-right:60px; }

.ChalList_submit {
	width:60px;
}
</style>
<script>

</script>
</head>
<!-- 이 모양 유지할것 -->
<body>
<%@ include file="../include/incAdmin.jsp" %>
<!-- main 영역 시작 -->
<main>
	<article>
		<!-- section 영역 시작 -->
	    <section>
		    <h2>도전 펀딩 관리</h2>
			<ul id="sort">
				<li>
				<form name="frm0" method="get">
				<select class="hand" name="sort" onchange="this.form.submit();">
					<option value="idx" <% if (pageInfo.getSort().equals("idx")) { %>selected = "selected"<% } %>>최신순</option>
					<option value="edatea" <% if (pageInfo.getSort().equals("edatea")) { %>selected = "selected"<% } %>>마감일-오름차순</option> 
					<option value="edated" <% if (pageInfo.getSort().equals("edated")) { %>selected = "selected"<% } %>>마감일-내림차순</option>
					<option value="status" <% if (pageInfo.getSort().equals("status")) { %>selected = "selected"<% } %>>진행상태순</option>
				</select>
				</form>
				</li>
			</ul>
			<ul id="cata">
				<li>
				<form name="frm1" method="get">
				<select class="chalList_searchkind" name="schtype">
					<option value="ci_title" <% if (pageInfo.getSchtype().equals("ci_title")) { %>selected = "selected"<% } %>>제목</option>
					<option value="ci_idx" <% if (pageInfo.getSchtype().equals("ci_idx")) { %>selected = "selected"<% } %>>글번호</option> 
					<option value="mi_id" <% if (pageInfo.getSchtype().equals("mi_id")) { %>selected = "selected"<% } %>>작성자</option>
				</select><!-- 진행상태 검색은 정렬로 옮겨짐  -->
				<input type="text" name="keyword" value="<%=pageInfo.getKeyword() %>" />
				<input type="submit" value="검색" id="ChalList_submit" class="ChalList_submit" />
				</form>
				</li>
				
			</ul>
			
			<table width="900" cellpadding="7" cellspacing="0" id="brd">
			<tr height="36" >
			<th width="8%">글번호</th><th width="*%">제목</th><th width="15%">작성자</th><th width="15%">마감일</th>
			<th width="4%">차수</th><th width="8%">공감수</th><th width="8%">게시여부</th><th width="10%">진행상태</th>
			</tr>

<%
	if(adminChallengeList.size() > 0){
	for(int i=0;i<adminChallengeList.size(); i++){
		AdminChallengeList aci = adminChallengeList.get(i);
		String lnk = null;
		
		int step = aci.getCi_step(); 
		String status = aci.getCi_status();
		
		// a:진행		b:마감		c:펀딩확정	
		//lnk = "<a href=\"chal_manage_detail.admin" + args + "&ciidx=" + aci.getCi_idx() + "&sort=" + pageInfo.getSort() +
		//	"&psize=" +pageInfo.getPsize() + "\">";
		lnk = "chal_up_form.admin" + args + "&ciidx=" + aci.getCi_idx() + "&sort=" + pageInfo.getSort() +
			"&psize=" +pageInfo.getPsize();

		if(pageInfo.getPsize() == 10) {
		// 한 페이지에 10개 글 리스트
%>
<tr style="cursor:pointer" height="36" align="center" onmouseover="this.style.background='#efefef';" 
	onmouseout="this.style.background='';" onclick="location.href='<%=lnk %>'" >
<td><%=aci.getCi_idx() %></td><td><%=aci.getCi_title() %></td><td><%=aci.getMi_id() %></td><td><%=aci.getCi_edate().substring(0 , 10) %></td>
<td><%=aci.getCi_step() %></td><td><%=aci.getCi_good() %></td><td><%=aci.getCi_isview() %></td>

<%
// 진행상태가 char임에도 String으로 받았는데 귀찮아서 수정안함.. 야매스럽지만 너무 귀찮다..
if(aci.getCi_status().equals('a'+"")){
	out.println("<td>진행</td></tr>");
}else if(aci.getCi_status().equals('b'+"")){
	out.println("<td>마감</td></tr>");
}else {
	out.println("<td>펀딩확정</td></tr>");
}
%>

<%			
		}	
	}
	out.println("</table>");
}else{
	out.println("<table width='900' cellpadding='7' cellspacing='0' id='brd'");
	out.println("<tr><td>검색된 도전펀딩이 없습니다.</td></tr>");
	out.println("</table>");
}



%>
<br />
<%
if (adminChallengeList.size() > 0){
// 상품 검색결과가 있으면 페이지 번호를 출력
	out.println("<div class='page_wrapper'>");
	out.println("<p style='font-size:1.1em; width:100%;' align='center' font-color:black>");

	args = "?sort=" + pageInfo.getSort() + "&psize=" + pageInfo.getPsize();
	
		if(pageInfo.getCpage() == 1){				
			out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
		}else{
			out.print("<a href='chal_list.admin" + args + "&cpage=1'>[&lt;&lt;]</a>&nbsp;&nbsp;");
			out.println("<a href='chal_list.admin" + args + "&cpage=" + (pageInfo.getCpage() - 1) + "'>[&lt;]</a>&nbsp;&nbsp;");
		}
		
		for(int i=1, j=pageInfo.getSpage(); i<= pageInfo.getBsize() && j <= pageInfo.getEpage(); i++, j++){
		// i : 루프 돌릴 횟수 검사하는 용도의 변수, j : 페이지 번호 출력용 변수
			if(pageInfo.getCpage() == j){
				out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
			}else{
				out.print("&nbsp;<a href='chal_list.admin" +args + "&cpage=" +j + "'>" + j + "</a>&nbsp;");
			}
		}
		
		
		if(pageInfo.getCpage() == pageInfo.getPcnt()){
			out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
		}else{
			out.print("&nbsp;&nbsp;<a href='chal_list.admin" + args + "&cpage=" + (pageInfo.getCpage() + 1 ) + "'>[&gt;]</a>");
			out.println("&nbsp;&nbsp;<a href='chal_list.admin" +args + "&cpage=" + (pageInfo.getPcnt()) + "'>[&gt;&gt;]</a>");
		}

	out.println("</p>");
	out.println("</div>");
}
%>
	    </section>
		<!-- section 영역 종료 -->
	</article>
</main>
<!-- main 영역 종료 -->
</body>
<!-- 이 모양 유지할것 -->
</html>