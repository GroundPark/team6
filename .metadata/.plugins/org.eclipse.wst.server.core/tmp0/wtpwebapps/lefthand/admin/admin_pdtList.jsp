<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");
ArrayList<ProductInfo> pdtList = (ArrayList<ProductInfo>)request.getAttribute("pdtList");
ArrayList<PdtCata> cataList = (ArrayList<PdtCata>)request.getAttribute("cataList");
AdminPdtPageInfo adminPdtPageInfo = (AdminPdtPageInfo)request.getAttribute("adminPdtPageInfo");

 String args ="", schargs = "";
 
// 검색관련 쿼리스트링 
if (adminPdtPageInfo.getSchtype() == null || adminPdtPageInfo.getKeyword() == null){
	adminPdtPageInfo.setSchtype("");	adminPdtPageInfo.setKeyword("");
} else if (!adminPdtPageInfo.getKeyword().equals("") && !adminPdtPageInfo.getSchtype().equals("") ){
	 schargs ="&schtype=" + adminPdtPageInfo.getSchtype()+"&keyword=" + adminPdtPageInfo.getKeyword();
}
args = "?cpage=" + adminPdtPageInfo.getCpage() + schargs;
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#brd th { border-top:2px solid #aaa; border-bottom:1px #aaa solid; text-align:center; font-weight:bold; background:#ddd; }
#brd tr:last-child > td { border-bottom:2px #aaa solid; }
#brd { padding-bottom:20px; }
#btn { width:100%; }
section #cata { float:left; padding-left:0px; }
section #sort { float:right; padding-right:40px; }
section #cata li { display:inline-block; padding-bottom:10px; }
section #search { width:100px; }
</style>
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>
<!-- main 영역 시작 -->
<main>
	<article>
		<!-- section 영역 시작 -->
	    <section>
		    <h2>상품 목록</h2>
			<h2>검색 창</h2>
			<form name ="frmSch" method="get">
			<ul id="cata">
				<li><select name="schtype" class="hand">
 				 	<option value="cate" <% if (adminPdtPageInfo.getSchtype().equals("cate")) { %> selected="selected" <% } %>>카테고리</option> 
					<option value="id" <% if (adminPdtPageInfo.getSchtype().equals("id")) { %> selected="selected" <% } %>>상품ID</option> 
					<option value="name" <% if (adminPdtPageInfo.getSchtype().equals("name")) { %> selected="selected" <% } %>>상품명</option>
 					<option value="isview" <% if (adminPdtPageInfo.getSchtype().equals("isview")) { %> selected="selected" <% } %>>게시여부</option>
				</select></li>
				<li><input type="text" name="keyword" value="<%=adminPdtPageInfo.getKeyword() %>"  /></li>
				<li><input type="submit" value="검색" /></li>
			</ul>			
			<ul id="sort">
				<li><select name="" class="hand" onchange="if(this.value) location.href=(this.value);">
					<option value="">전체</option>
					<option value="admin_pdt_list.adminpdt<%=args %>&sort=datea" <% if (adminPdtPageInfo.getSort().equals("datea")) { %>selected="selected" <% } %>>등록일-오름차순</option> 
					<option value="admin_pdt_list.adminpdt<%=args %>&sort=dated" <% if (adminPdtPageInfo.getSort().equals("dated")) { %>selected="selected" <% } %>>등록일-내림차순</option>
				</select></li>
			</ul>
			</form>
			<table width="900" cellpadding="7" cellspacing="0" id="brd">
			<tr height="30">
			<th width="5%">번호</th><th width="6%">카데고리</th><th width="9%">상품ID</th><th width="30%">상품명</th><th width="10%">재고수량</th>
			<th width="7%">후기수</th><th width="*">등록일</th><th width="10%">게시여부</th><th width="12%">history</th>
			</tr>
<%
if(pdtList.size() > 0 && adminPdtPageInfo.getRcnt() > 0){	// 보여줄 게시글 목록이 있으면
	int num = adminPdtPageInfo.getRcnt() - (adminPdtPageInfo.getPsize() * (adminPdtPageInfo.getCpage() - 1));
	for (int i = 0; i < pdtList.size(); i++){		
		ProductInfo pl = pdtList.get(i);	
		
		String lnk = "<a href=\"admin_pdt_view.adminpdt" + args + "&piid=" + pl.getPi_id() +
				"&sort=" + adminPdtPageInfo.getSort() + "&psize=" + adminPdtPageInfo.getPsize() + "\">";
				
		String rlnk = "<a href=\"admin_pdt_rev_list.adminpdt?piid=" + pl.getPi_id() + "\">";
		String hlnk = "<a href=\"admin_pdt_history.adminpdt?piid=" + pl.getPi_id() + "\">";
%>
		<tr align="center" height="30" onmouseover="this.style.background = '#efefef';" onmouseout="this.style.background = '';">
		<td><%=num %></td> 
		<td><%=pl.getPc_name() %></td>
		<td><%=pl.getPi_id() %></td>
		<td onmouseover="chgunderline"><%=lnk + pl.getPi_name() + "</a>" %></td>
		<td><%=pl.getPi_stock() %></td>
		<td onmouseover="chgunderline"><%=rlnk + pl.getPi_review() + "</a>" %></td>
		<td><%=pl.getPi_date().substring(0, 10) %></td>
		<td><%=pl.getPi_isview() %></td>
		<td onmouseover="chgunderline">
		<a onclick="window.open(this.href, '_blank', 'width=430px ,height=300px, toolbars=no, scrollbars=yes, top=50%, left=500%'); return false;"
<%=hlnk + "히스토리 </a>" %></td></tr>
<% 	
		num--;
	}	
	
} else {
	out.println("<tr><td colspan='8' align='center'>검색 결과가 없습니다.</td></tr>");
}
%>		
		</table><br />
		<table width="900" cellpadding="5" cellspacing="0">
		<tr>
		<td width="900" align="center">
		<%
		if(pdtList.size() > 0 && adminPdtPageInfo.getRcnt() > 0){	// 보여줄 게시글 목록이 있으면  페이지 번호를 보여줌
			String pageLink = "admin_pdt_list.adminpdt?cpage=";
			if (adminPdtPageInfo.getCpage() == 1){
				out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
			} else {
				out.print("<a href='" + pageLink + "1" + schargs + "'>[&lt;&lt;]</a>&nbsp;&nbsp;");
				out.println("<a href='" + pageLink + (adminPdtPageInfo.getCpage() - 1) + schargs + "'>[&lt;]</a>&nbsp;&nbsp;");
			}
			
			for(int i = 1, j = adminPdtPageInfo.getSpage(); i <= adminPdtPageInfo.getBsize() && j <= adminPdtPageInfo.getEpage() ; i++, j++){
			// i: 루프를 돌릴 횟수를 검사하는 용도의 변수, j : 페이지 번호 출력용 변수(블록사이즈는 5니까 5번이 최대로 돌리는 거 아닐까??) 맞음.. 한페이지에 5개의 페이지가 보이니까
				if(adminPdtPageInfo.getCpage() == j) {
					out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
				} else {
					out.print("&nbsp;<a href='" + pageLink + j + schargs + "'>" + j + "</a>&nbsp;");
				}
			}
			
			if (adminPdtPageInfo.getCpage() == adminPdtPageInfo.getPcnt()) {
				out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
			} else {
				out.print("&nbsp;&nbsp;<a href='" + pageLink + (adminPdtPageInfo.getCpage() + 1) + schargs + "'>[&gt;]</a>");
				out.println("&nbsp;&nbsp;<a href='" + pageLink + (adminPdtPageInfo.getPcnt()) + schargs + "'>[&gt;&gt;]</a>");
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