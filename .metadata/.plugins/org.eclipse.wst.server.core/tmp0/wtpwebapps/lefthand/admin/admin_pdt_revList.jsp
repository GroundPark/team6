<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
request.setCharacterEncoding("utf-8");

ArrayList<ReviewList> reviewList = (ArrayList<ReviewList>)request.getAttribute("reviewList");
AdminPdtPageInfo adminPdtPageInfo = (AdminPdtPageInfo)request.getAttribute("adminPdtPageInfo");

String piid = request.getParameter("piid");
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#brd th { border-top:2px solid #aaa; border-bottom:1px #aaa solid; text-align:center; font-weight:bold; background:#ddd; }
#brd tr:last-child > td { border-bottom:2px #aaa solid; }
#brd { padding-bottom:20px; }
#btn { width:100%; }
section #sort { float:right; padding-right:40px; margin-bottom:10px; }
section #search { width:100px; }
.hide {display:none;}
.review .show { display:table-row !important; } 
.td {cursor:pointer;}  
</style>
<script>
function chView(rlidx, piid, rid, val) {
	// 댓글 게시여부 변경 함수(rlidx: 후기 글번호, piid: 상품 아이디, rid: 회원ID, val: 댓글 현재 게시상태)
		$.ajax({
			type : "POST", 
			url : "/lefthand/chview", 
			data : {"rlidx" : rlidx, "piid": piid, "miid": rid, "view" : val }, 
			success : function(chkRs) {
				if (chkRs == 0)	alert("댓글 게시 여부 변경에 실패했습니다.\n새로 고침 후 다시 시도해 주십시오.");
				else			location.reload();
			},
			error : function(chkRs) {
				alert("실패  rlidx: " + rlidx);
				alert("실패 miid: " + rid);
			}
		});
	}
</script>
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>
<!-- main 영역 시작 -->
<main>
	<article>
		<!-- section 영역 시작 -->
	    <section>
		    <h2><%=piid %> 상품 후기 관리</h2>
		    <form name ="frmSort" method="get">
		    <input type="hidden" name="sort" value="<%=adminPdtPageInfo.getSort() %>" />
			<ul id="sort">
				<li><select name="sort" class="hand" onchange="if(this.value) location.href=(this.value);">
					<option value="전체">전체</option>
					<option value="admin_pdt_rev_list.adminpdt?piid=<%=piid %>&sort=idxa" <% if (adminPdtPageInfo.getSort().equals("idxa")) { %>selected="selected" <% } %> >등록일-오름차순</option>
					<option value="admin_pdt_rev_list.adminpdt?piid=<%=piid %>&sort=idxd" <% if (adminPdtPageInfo.getSort().equals("idxd")) { %>selected="selected" <% } %>>등록일-내림차순</option>
				</select></li>
			</ul>
			</form>
			<table width="900" cellpadding="7" cellspacing="0" id="brd" class="review">
			<tr height="30">
			<th width="5%">번호</th><th width="6%">후기번호</th><th width="8%">작성자</th><th width="8%">평점</th><th width="8%">좋아요</th>
			<th width="*%">내용</th><th width="15%">날짜</th><th width="10%">게시여부</th>
			</tr>
<%
if(reviewList.size() > 0 && adminPdtPageInfo.getRcnt() > 0){	// 보여줄 후기 목록이 있으면
	int num = adminPdtPageInfo.getRcnt() - (adminPdtPageInfo.getPsize() * (adminPdtPageInfo.getCpage() - 1));
	for (int i = 0; i < reviewList.size(); i++){		
		ReviewList rl = reviewList.get(i);	
		
%>
		
		<tr align="center" height="30"
		onmouseover="this.style.background = '#efefef';" onmouseout="this.style.background = '';" >
		<td><%=num %></td> 
		<td><%=rl.getRl_idx() %></td>
		<td><%=rl.getMi_id() %></td>
		<td><%=rl.getRl_score() %></td>
		<td><%=rl.getRl_good() %></td>
		<td><%=rl.getRl_content() %></td>
		<td><%=rl.getRl_date().substring(0,11)%></td>
		<td>
			<select name="view" onchange="chView(<%=rl.getRl_idx() %> ,'<%=piid %>', '<%=rl.getMi_id() %>', this.value);">		
				<option value="y" <% if (rl.getRl_isview().equals("y")) { %> selected="selected" <% } %>>Y</option>
				<option value="n" <% if (rl.getRl_isview().equals("n")) { %> selected="selected" <% } %>>N</option>
			</select>
		</td>
		</tr>							
<% 	
		num--;
	}	
	
} else {
	out.println("<tr height='30'><td colspan='8' align='center'>작성된 후기가 없습니다.</td></tr>");
}
%>		
			</table><br />
			<table width="900" cellpadding="5" cellspacing="0">
		<tr>
		<td width="900" align="center">
		<%
		if(reviewList.size() > 0 && adminPdtPageInfo.getRcnt() > 0){	// 보여줄 게시글 목록이 있으면  페이지 번호를 보여줌
			String pageLink = "admin_pdt_rev_list.adminpdt?piid=" + piid + "&cpage=";
			if (adminPdtPageInfo.getCpage() == 1){
				out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
			} else {
				out.print("<a href='" + pageLink + "1' >[&lt;&lt;]</a>&nbsp;&nbsp;");
				out.println("<a href='" + pageLink + (adminPdtPageInfo.getCpage() - 1) + "'>[&lt;]</a>&nbsp;&nbsp;");
			}
			
			for(int i = 1, j = adminPdtPageInfo.getSpage(); i <= adminPdtPageInfo.getBsize() && j <= adminPdtPageInfo.getEpage() ; i++, j++){
			// i: 루프를 돌릴 횟수를 검사하는 용도의 변수, j : 페이지 번호 출력용 변수(블록사이즈는 5니까 5번이 최대로 돌리는 거 아닐까??) 맞음.. 한페이지에 5개의 페이지가 보이니까
				if(adminPdtPageInfo.getCpage() == j) {
					out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
				} else {
					out.print("&nbsp;<a href='" + pageLink + j  + "'>" + j + "</a>&nbsp;");
				}
			}
			
			if (adminPdtPageInfo.getCpage() == adminPdtPageInfo.getPcnt()) {
				out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
			} else {
				out.print("&nbsp;&nbsp;<a href='" + pageLink + (adminPdtPageInfo.getCpage() + 1) + "'>[&gt;]</a>");
				out.println("&nbsp;&nbsp;<a href='" + pageLink + (adminPdtPageInfo.getPcnt()) + "'>[&gt;&gt;]</a>");
			}
		}
		%>
		</td></tr>
		</table>
	    </section>
		<!-- section 영역 종료 -->
	</article>
</main>
<!-- main 영역 종료 -->
</body>
</html>