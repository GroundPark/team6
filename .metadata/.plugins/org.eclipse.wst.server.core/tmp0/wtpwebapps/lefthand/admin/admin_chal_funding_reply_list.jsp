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

 String args = "", schargs = "";
 if (pageInfo.getSchtype() == null || pageInfo.getKeyword() == null) {
 	pageInfo.setSchtype("");	pageInfo.setKeyword("");
 	// 검색 관련 정보가 null인 경우 빈 문자열로 변경함; 이거 안하면 텍스트박스에 문자열 null찍혀서 굉장히 구려보임
 }else if(!pageInfo.getKeyword().equals("") && !pageInfo.getSchtype().equals("")){	// 빈문자일 경우 일그냥 안할거
 	schargs = "&schtype=" + pageInfo.getSchtype() + "&keyword=" + pageInfo.getKeyword();	
 }

 args = "&cpage=" + pageInfo.getCpage() + schargs;


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
<script>	
function chView(cridx, ciidx, miid, view) {
	// 댓글 게시여부 변경 함수(cridx: 댓글 번호, ciidx: 글 번호, miid: 회원ID, val: 댓글 현재 게시상태)
		$.ajax({
			type : "POST", 
			url : "chal_manage_reply_up.admin", 
			data : {"cridx" : cridx, "ciidx": ciidx, "miid": miid, "view" : view }, 
			success : function(chkRs) {
				if (chkRs == 0)	alert("댓글 게시 여부 변경에 실패했습니다.\n새로 고침 후 다시 시도해 주십시오.");
				else			{
					location.reload();
				}
			},
			error : function(chkRs) {
				alert("실패  cridx: " + cridx);
			}
		});
	}	
</script>	
	
<!-- main 영역 시작 -->
<main>
	<article>
		<!-- section 영역 시작 -->
	    <section>
		    <h2>도전 펀딩 관리</h2>

			<ul id="cata">
				<li>
				<form name="frm1" method="get">
				<select class="chalReply_search" name="schtype">
					<option value="mi_id" <% if (pageInfo.getSchtype().equals("mi_id")) { %>selected = "selected"<% } %>>작성자</option> 
					<option value="cr_content" <% if (pageInfo.getSchtype().equals("cr_content")) { %>selected = "selected"<% } %>>댓글 내용</option>
					<option value="ci_idx" <% if (pageInfo.getSchtype().equals("ci_idx")) { %>selected = "selected"<% } %>>글번호</option>
				</select><!-- 진행상태 검색은 정렬로 옮겨짐  -->
				<input type="text" name="keyword" value="<%=pageInfo.getKeyword() %>" />
				<input type="submit" value="검색" id="chalReply_submit" class="chalReply_submit" />
				</form>
				</li>
				
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
		
		String miid = acl.getMi_id();
		
		String replyContent = acl.getCr_content();	
		if(replyContent.length() > 32)		replyContent = replyContent.substring(0, 30) + "...";
		
		
		// a:진행		b:마감		c:펀딩확정	
		//lnk = "<a href=\"chal_manage_detail.admin" + args + "&ciidx=" + aci.getCi_idx() + "&sort=" + pageInfo.getSort() +
		//	"&psize=" +pageInfo.getPsize() + "\">";
		//lnk = "chal_manage_reply_up.admin" + args + "&cridx=" + acl.getCr_idx() + "&sort=" + pageInfo.getSort() +
		//	"&psize=" +pageInfo.getPsize();

		if(pageInfo.getPsize() == 10) {
		// 한 페이지에 10개 글 리스트
%>
<tr height="36" align="center" onmouseover="this.style.background='#efefef';" 
	onmouseout="this.style.background='';" >
<td><%=acl.getCr_idx() %></td><td><%=acl.getCi_idx() %></td><td><%=acl.getMi_id() %></td>
<td><%=acl.getCr_date() %></td><td><%=replyContent %></td>
<td>

<% if (acl.getCr_isview().equals("y")){ %>
<select name="view" style="cursor:pointer" onchange="chView(<%=acl.getCr_idx() %> ,<%=acl.getCi_idx() %>, '<%=acl.getMi_id() %>', this.value);">		
	<option value="y" selected="selected" >Y</option>
	<option value="n" >N</option>
</select>
<% } else if (acl.getCr_isview().equals("n")) { %>
<select name="view" style="cursor:pointer" onchange="chView(<%=acl.getCr_idx() %> ,<%=acl.getCi_idx() %>, '<%=acl.getMi_id() %>', this.value);">		
	<option value="y">Y</option>
	<option value="n" selected="selected" >N</option>
</select>
<% } %>

</td>
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