<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%

request.setCharacterEncoding("utf-8");

PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");	
ArrayList<AdminFundingList> adminFundingList = (ArrayList<AdminFundingList>)request.getAttribute("adminFundingList");
//FundingList funding = (FundingList)request.getAttribute("funding");		

String args ="";
// 검색관련 쿼리스트링 
// if(challengePageInfo.getKeyword() != null && !challengePageInfo.getKeyword().equals(""))	
//	schargs += "&keyword=" + challengePageInfo.getKeyword();

 args = "?cpage=" + pageInfo.getCpage();
 

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
</style>
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>
<!-- main 영역 시작 -->
<main>
	<article>
		<!-- section 영역 시작 -->
	    <section>
		    <h2>펀딩 관리</h2>
			<h2>검색 창</h2>
			<ul id="sort">
				<li><select class="hand">
					<option value="전체">전체</option>
					<option value="등록일-오름차숨">등록일-오름차숨</option> 
					<option value="등록일-내림차순">등록일-내림차순</option> 
					<option value="마감일-오름차순">마감일-오름차순</option>
					<option value="마감일-내림차순">마감일-내림차순</option>
					<option value="펀딩율">펀딩율</option>
				</select></li>
			</ul>
			<ul id="cata">
				<li><select class="hand">
					<option value="제목">제목</option>
					<option value="펀딩아이디">펀디아이디</option>
					<option value="진행상태">진행상태</option>
				</select></li>
				<li><input type="text" id="search" /></li>
			</ul>
			<table width="900" cellpadding="7" cellspacing="0" id="brd">
			<tr height="36" >
			<th width="8%">글번호</th><th width="*%">펀딩 아이디</th><th width=25%">제목</th><th width="15%">시작일</th>
			<th width="15%">마감일</th><th width="15%">펀딩율</th><th width="10%">진행상태</th>
			</tr>

<%
	if(adminFundingList.size() > 0){
	for(int i=0;i<adminFundingList.size(); i++){
		AdminFundingList aci = adminFundingList.get(i);
		String lnk = null;
		
		String status = aci.getFi_status();
		
		// a:진행		b:마감		c:펀딩확정	
		//lnk = "<a href=\"chal_manage_detail.admin" + args + "&ciidx=" + aci.getCi_idx() + "&sort=" + pageInfo.getSort() +
		//	"&psize=" +pageInfo.getPsize() + "\">";
		lnk = "funding_up_form.admin" + args + "&fiidx=" + aci.getFi_idx() + "&sort=" + pageInfo.getSort() +
			"&psize=" +pageInfo.getPsize();

		if(pageInfo.getPsize() == 10) {
		// 한 페이지에 10개 글 리스트
%>
<tr height="36" align="center" onmouseover="this.style.background='#efefef';" onmouseout="this.style.background='';" onclick="location.href='<%=lnk %>'" style="cursor:pointer" >
<td><%=aci.getFi_idx() %></td><td><%=aci.getFi_id() %></td><td><%=aci.getFi_name() %></td><td><%=aci.getFi_sdate().substring(0 , 10) %></td>
<td><%=aci.getFi_edate().substring(0 , 10) %></td><td><%=Math.floor(aci.getFi_rate() * 100) %> %</td>

<%
// 진행상태가 char임에도 String으로 받았는데 귀찮아서 수정안함.. 야매스럽지만 너무 귀찮다..
if(aci.getFi_status().equals('a'+"")){
	out.println("<td>펀딩중</td></tr>");
}else if(aci.getFi_status().equals('b'+"")){
	out.println("<td>펀딩성공</td></tr>");
}else {
	out.println("<td>펀딩실패</td></tr>");
}
%>

<%			
		}	
	}
	out.println("</table>");
}else{
	out.println("<table width='900' cellpadding='7' cellspacing='0' id='brd'");
	out.println("<tr><td>검색된 펀딩이 없습니다.</td></tr>");
	out.println("</table>");
}



%>
<br />
<%
if (adminFundingList.size() > 0){
// 상품 검색결과가 있으면 페이지 번호를 출력
	out.println("<div class='page_wrapper'>");
	out.println("<p style='font-size:1.1em; width:100%;' align='center' font-color:black>");

	args = "?sort=" + pageInfo.getSort() + "&psize=" + pageInfo.getPsize();
	
		if(pageInfo.getCpage() == 1){				
			out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
		}else{
			out.print("<a href='funding_list.admin" + args + "&cpage=1'>[&lt;&lt;]</a>&nbsp;&nbsp;");
			out.println("<a href='funding_list.admin" + args + "&cpage=" + (pageInfo.getCpage() - 1) + "'>[&lt;]</a>&nbsp;&nbsp;");
		}
		
		for(int i=1, j=pageInfo.getSpage(); i<= pageInfo.getBsize() && j <= pageInfo.getEpage(); i++, j++){
		// i : 루프 돌릴 횟수 검사하는 용도의 변수, j : 페이지 번호 출력용 변수
			if(pageInfo.getCpage() == j){
				out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
			}else{
				out.print("&nbsp;<a href='funding_list.admin" +args + "&cpage=" +j + "'>" + j + "</a>&nbsp;");
			}
		}
		
		
		if(pageInfo.getCpage() == pageInfo.getPcnt()){
			out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
		}else{
			out.print("&nbsp;&nbsp;<a href='funding_list.admin" + args + "&cpage=" + (pageInfo.getCpage() + 1 ) + "'>[&gt;]</a>");
			out.println("&nbsp;&nbsp;<a href='funding_list.admin" +args + "&cpage=" + (pageInfo.getPcnt()) + "'>[&gt;&gt;]</a>");
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