<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.DecimalFormat" %>	<!-- 돈 표기 -->
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");
ArrayList<OrderInfo> orderList = (ArrayList<OrderInfo>)request.getAttribute("orderList");
AdminOrderPdtPageInfo adminOrderPdtPageInfo = (AdminOrderPdtPageInfo)request.getAttribute("adminOrderPdtPageInfo");

String args ="", schargs = "";

// 검색관련 쿼리스트링 
if (adminOrderPdtPageInfo.getSchtype() == null || adminOrderPdtPageInfo.getKeyword() == null) {
	adminOrderPdtPageInfo.setSchtype("");	adminOrderPdtPageInfo.setKeyword("");
} else if (!adminOrderPdtPageInfo.getKeyword().equals("") && !adminOrderPdtPageInfo.getSchtype().equals("") ) {
	 schargs ="&schtype=" + adminOrderPdtPageInfo.getSchtype() + "&keyword=" + adminOrderPdtPageInfo.getKeyword();
}
args = "?cpage=" + adminOrderPdtPageInfo.getCpage() + schargs;

DecimalFormat formatter = new DecimalFormat("#,##0"); 	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<script>
function sortChange(url) {
	location.href = url;
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
	<h2>상품 주문 목록</h2>
	<h2>검색 창</h2>
	<form name ="frmSch" method="get">
	<input type="hidden" name="sort" value="<%=adminOrderPdtPageInfo.getSort() %>" /> 
	<ul id="cata">
		<li><select name="schtype" class="hand">
			 	<option value="miid" <% if (adminOrderPdtPageInfo.getSchtype().equals("miid")) { %> selected="selected" <% } %>>회원ID</option> 
				<option value="poiid" <% if (adminOrderPdtPageInfo.getSchtype().equals("poiid")) { %> selected="selected" <% } %>>주문번호</option> 
				<option value="poistatus" <% if (adminOrderPdtPageInfo.getSchtype().equals("poistatus")) { %> selected="selected" <% } %>>주문상태</option>
		</select></li>
		<li><input type="text" name="keyword" value="<%=adminOrderPdtPageInfo.getKeyword() %>"  /></li>
		<li><input type="submit" value="검색" /></li>
	</ul>			
	<ul id="sort">
		<li><select class="hand" onchange="sortChange(this.value);">
			<option value="order_pdt.adminord<%=args %>&sort=datea" 
				<% if (adminOrderPdtPageInfo.getSort().equals("datea")) { %> selected="selected" <% } %>>주문일-오름차순</option> 
			<option value="order_pdt.adminord<%=args %>&sort=dated" 
				<% if (adminOrderPdtPageInfo.getSort().equals("dated")) { %> selected="selected" <% } %>>주문일-내림차순</option>
		</select></li>
	</ul>
	</form>
	
	<!-- 주문 리스트 영역 시작 -->
	<table width="900" cellpadding="7" cellspacing="0" id="brd">
	<tr height="30px">
		<th width="8%">번호</th><th width="*">주문번호</th><th width="15%">회원ID</th><th width="15%">결제액(원)</th>
		<th width="20%">주문일</th><th width="15%">주문상태</th><th width="12%">수정 관리자</th>
	</tr>
<%
if(orderList.size() > 0 && adminOrderPdtPageInfo.getRcnt() > 0){	// 보여줄 게시글 목록이 있으면
	int num = adminOrderPdtPageInfo.getRcnt() - (adminOrderPdtPageInfo.getPsize() * (adminOrderPdtPageInfo.getCpage() - 1));
	for (int i = 0; i < orderList.size(); i++) {		
		OrderInfo oi = orderList.get(i);
		ArrayList<OrderDetail> detailList = oi.getDetailList();
		
		String lnk = null;
		
		String status = "";
		if (oi.getPoi_status().equals("a"))			status = "배송준비중";
		else if (oi.getPoi_status().equals("b"))	status = "배송중";
		else if (oi.getPoi_status().equals("c"))	status = "배송완료";
		
		String aiidx = "";
		if (oi.getAi_idx() != 0)	aiidx = oi.getAi_idx() + "";
		
		lnk = "order_pdt_view.adminord" + args + "&poiid=" + oi.getPoi_id() + "&miid=" + oi.getMi_id() + 
				"&sort=" + adminOrderPdtPageInfo.getSort() + "&psize=" + adminOrderPdtPageInfo.getPsize();	
%>
	<tr style="cursor:pointer" align="center" height="30px" onmouseover="this.style.background = '#efefef';" onmouseout="this.style.background = '';"  
		onclick="location.href='<%=lnk %>'">
	<td><%=num %></td> 
	<td onmouseover="chgunderline"><%=oi.getPoi_id() %></td>
	<td><%=oi.getMi_id() %></td> 
	<td><%=formatter.format(oi.getPoi_pay())%></td> 
	<td><%=oi.getPoi_date() %></td> 
	<td><%=status %></td>
	<td><%=aiidx %></td>
<% 	
		num--;
	}	
	
} else {
	out.println("<tr><td colspan='5' align='center'>검색 결과가 없습니다.</td></tr>");
}
%>		
	</table><br />
	<!-- 주문 리스트 영역 종료 -->
	
	<!-- 페이징 영역 시작 -->
	<table width="900" cellpadding="5" cellspacing="0">
	<tr>
	<td width="900" align="center">
	<%
	if(orderList.size() > 0 && adminOrderPdtPageInfo.getRcnt() > 0){	// 보여줄 게시글 목록이 있으면  페이지 번호를 보여줌
		String pageLink = "order_pdt.adminord?cpage=";
		if (adminOrderPdtPageInfo.getCpage() == 1){
			out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
		} else {
			out.print("<a href='" + pageLink + "1" + schargs + "'>[&lt;&lt;]</a>&nbsp;&nbsp;");
			out.println("<a href='" + pageLink + (adminOrderPdtPageInfo.getCpage() - 1) + schargs + "'>[&lt;]</a>&nbsp;&nbsp;");
		}
		
		for(int i = 1, j = adminOrderPdtPageInfo.getSpage(); i <= adminOrderPdtPageInfo.getBsize() && j <= adminOrderPdtPageInfo.getEpage() ; i++, j++){
		// i: 루프를 돌릴 횟수를 검사하는 용도의 변수, j : 페이지 번호 출력용 변수(블록사이즈는 5니까 5번이 최대로 돌리는 거 아닐까??) 맞음.. 한페이지에 5개의 페이지가 보이니까
			if(adminOrderPdtPageInfo.getCpage() == j) {
				out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
			} else {
				out.print("&nbsp;<a href='" + pageLink + j + schargs + "'>" + j + "</a>&nbsp;");
			}
		}
		
		if (adminOrderPdtPageInfo.getCpage() == adminOrderPdtPageInfo.getPcnt()) {
			out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
		} else {
			out.print("&nbsp;&nbsp;<a href='" + pageLink + (adminOrderPdtPageInfo.getCpage() + 1) + schargs + "'>[&gt;]</a>");
			out.println("&nbsp;&nbsp;<a href='" + pageLink + (adminOrderPdtPageInfo.getPcnt()) + schargs + "'>[&gt;&gt;]</a>");
		}
	}
	%>
	</td></tr>
	</table>
	<!-- 페이징 영역 시작 -->
	</section>
	<!-- section 영역 종료 -->
</article>
</main>
<!-- main 영역 종료 -->
</body>
</html>