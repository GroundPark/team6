<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%

request.setCharacterEncoding("utf-8");

PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");	
ArrayList<AdminChallengeReplyList> adminChallengeReplyList = (ArrayList<AdminChallengeReplyList>)request.getAttribute("adminChallengeList");
//ChallengeList challenge = (ChallengeList)request.getAttribute("challenge");		

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
<!-- 이 모양 유지할것 -->
<body>
<%@ include file="../include/incAdmin.jsp" %>
<!-- main 영역 시작 -->
<main>
	<article>
		<!-- section 영역 시작 -->
	    <section>
		    <h2>도전 펀딩 관리</h2>
			<h2>검색 창</h2>
			<ul id="cata">
				<li><select class="hand">
					<option value="제목">글번호</option>
					<option value="작성자">작성자</option>
					<option value="진행상태">댓글 내용</option>
				</select></li>
				<li><input type="text" id="search" /></li>
			</ul>
			<table width="900" cellpadding="7" cellspacing="0" id="brd">
			<tr height="36" >
			<th width="8%">댓글 번호</th><th width="8%">글 번호</th><th width="10%">작성자</th>
			<th width="20%">작성일시</th><th width="*%">댓글내용</th><th width="8%">게시여부</th>
			</tr>

<%
	if(adminChallengeReplyList.size() > 0){
	for(int i=0;i<adminChallengeReplyList.size(); i++){
		AdminChallengeReplyList acl = adminChallengeReplyList.get(i);
		String lnk = null;
		
		int cridx = acl.getCr_idx(); 
		int ciidx = acl.getCi_idx();
		String miid = acl.getMi_id();
		
		String replyContent = acl.getCr_content();	
		if(replyContent.length() > 32)		replyContent = replyContent.substring(0, 30) + "...";
		
		
		// a:진행		b:마감		c:펀딩확정	
		//lnk = "<a href=\"chal_manage_detail.admin" + args + "&ciidx=" + aci.getCi_idx() + "&sort=" + pageInfo.getSort() +
		//	"&psize=" +pageInfo.getPsize() + "\">";
		lnk = "chal_manage_reply_up.admin" + args + "&cridx=" + acl.getCr_idx() + "&sort=" + pageInfo.getSort() +
			"&psize=" +pageInfo.getPsize();

		if(pageInfo.getPsize() == 10) {
		// 한 페이지에 10개 글 리스트
%>
<tr style="cursor:pointer" height="36" align="center" onmouseover="this.style.background='#efefef';" 
	onmouseout="this.style.background='';" onclick="location.href='<%=lnk %>'" >
<td><%=acl.getCr_idx() %></td><td><%=acl.getCi_idx() %></td><td><%=acl.getMi_id() %></td>
<td><%=acl.getCr_date() %></td><td><%=replyContent %></td><td><%=acl.getCr_isview() %></td>
<%			
		}	
	}
	out.println("</table>");
}else{
	out.println("<table width='900' cellpadding='7' cellspacing='0' id='brd'");
	out.println("<tr><td>검색된 도전 펀딩 댓글이 없습니다.</td></tr>");
	out.println("</table>");
}



%>
<br />
<%
if (adminChallengeReplyList.size() > 0){
// 상품 검색결과가 있으면 페이지 번호를 출력
	out.println("<div class='page_wrapper'>");
	out.println("<p style='font-size:1.1em; width:100%;' align='center' font-color:black>");

	args = "?sort=" + pageInfo.getSort() + "&psize=" + pageInfo.getPsize();
	
		if(pageInfo.getCpage() == 1){				
			out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
		}else{
			out.print("<a href='chal_manage_reply.admin" + args + "&cpage=1'>[&lt;&lt;]</a>&nbsp;&nbsp;");
			out.println("<a href='chal_manage_reply.admin" + args + "&cpage=" + (pageInfo.getCpage() - 1) + "'>[&lt;]</a>&nbsp;&nbsp;");
		}
		
		for(int i=1, j=pageInfo.getSpage(); i<= pageInfo.getBsize() && j <= pageInfo.getEpage(); i++, j++){
		// i : 루프 돌릴 횟수 검사하는 용도의 변수, j : 페이지 번호 출력용 변수
			if(pageInfo.getCpage() == j){
				out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
			}else{
				out.print("&nbsp;<a href='chal_manage_reply.admin" +args + "&cpage=" +j + "'>" + j + "</a>&nbsp;");
			}
		}
		
		
		if(pageInfo.getCpage() == pageInfo.getPcnt()){
			out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
		}else{
			out.print("&nbsp;&nbsp;<a href='chal_manage_reply.admin" + args + "&cpage=" + (pageInfo.getCpage() + 1 ) + "'>[&gt;]</a>");
			out.println("&nbsp;&nbsp;<a href='chal_manage_reply.admin" +args + "&cpage=" + (pageInfo.getPcnt()) + "'>[&gt;&gt;]</a>");
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