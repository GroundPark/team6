<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="product.vo.*" %>

<%
request.setCharacterEncoding("utf-8");

ArrayList<ProductInfo> pdtList = (ArrayList<ProductInfo>)request.getAttribute("pdtList");
ArrayList<PdtCata> cataList = (ArrayList<PdtCata>)request.getAttribute("cataList");

PdtPageInfo pdtPageInfo = (PdtPageInfo)request.getAttribute("pdtPageInfo");

 String args ="", schargs = "";
 
// 검색관련 쿼리스트링 
if(pdtPageInfo.getKeyword() != null && !pdtPageInfo.getKeyword().equals(""))	
	schargs += "&keyword=" + pdtPageInfo.getKeyword();
if(pdtPageInfo.getCata() != null && !pdtPageInfo.getCata().equals(""))
	schargs += "&cata=" + pdtPageInfo.getCata();

args = "?cpage=" + pdtPageInfo.getCpage() + schargs; 
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/mainSlide.css" />
	<link rel="stylesheet" type="text/css" href="css/mainLayout.css" />
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<script src="js/jquery-3.6.0.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="js/mainSlide.js"></script>
	<script src="js/mainPage_scroll.js"></script>
</head>
	
<style>

.maindiv{
	height: 3000px;	width:1200px; margin: 0 auto;
	background-color:#d3d3d3;
}

#align { width:1160px; align:right; }	

.pdt_contents {
	width:1200px;  margin: 0 auto;
	overflow:hidden;
	height:100%;	
	
	padding-bottom:300px;
	position:relative;
}

.pdt { margin:20px; border:1px black solid; float:left; font-size:1.4em; }

.pdt_price { text-decoration:line-through; color:gray; font-size:0.9em; }

.pdt_real_price { color:red; font-size:1.2em; }

.page_wrapper {
	position:absolute;
	left:0%; bottom:5%;
	transform:translate(0%, -5%); 
	width: 1200px; height: 60px; 
	padding-top:50px;
	padding-bottom:50px;
}

body {
	position:relative;
	padding-bottom:0px;
}

.bold { font-weight:bold; }
</style>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<!-- ------------------------------------------------------------------------------------------------ -->
<div class="pdt_contents" >
<br />
<h2 align="center"></h2>
<br />
<!-- 상품 정렬 조건 -->
<p id="align" align="right">
	<a href="pdt_list.pdt<%=args %>&sort=reviewd" <%=(pdtPageInfo.getSort().equals("reviewd") ? "class='bold'" : "") %>>인기순</a>&nbsp;
	<a href="pdt_list.pdt<%=args %>&sort=salecntd" <%=(pdtPageInfo.getSort().equals("salecntd") ? "class='bold'" : "") %>>판매량순</a>&nbsp;
	<a href="pdt_list.pdt<%=args %>&sort=priced" <%=(pdtPageInfo.getSort().equals("priced") ? "class='bold'" : "") %>>높은 가격순</a>&nbsp;
	<a href="pdt_list.pdt<%=args %>&sort=pricea" <%=(pdtPageInfo.getSort().equals("pricea") ? "class='bold'" : "") %>>낮은 가격순</a>&nbsp;
</p>
<!-- 상품 목록 시작  -->
<%
if(pdtList.size() > 0){
// 상품 검색결과가 있으면
	for(int i = 0 ;i < pdtList.size(); i++){
		ProductInfo pi = pdtList.get(i);
		String lnk = null;
		if(pi.getPi_stock() != 0){		// 상품의 재고가 남아있는 경우... 무제한이 -1
			lnk = "<a href=\"/pdt_view.pdt" + args + "&piid=" + pi.getPi_id() + "&sort=" + pdtPageInfo.getSort() +
					"&psize=" +pdtPageInfo.getPsize() + "\">";
		}else{		// 상품의 재고가 없는 품절일 경우
			lnk = "<a href=\"javascript:alert('품절된 상품입니다.');\">";
		}
		
		if(pdtPageInfo.getPsize() == 12) {
		// 한 페이지에 12개의 상품 목록을 보여줄 경우(한 줄에 3개씩 보여줌)
			if(i % 3 == 0)		out.println("<div align='center'>");
%>
<div class="pdt">
	<%=lnk %><img src="page/product/img/<%=pi.getPi_img1() %>" style="width:350px; height:350px; padding-bottom:25px;" /><br />
	<%=pi.getPi_name() %></a><br /><span class="pdt_price"><%=pi.getPi_price() %> 원</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=(int)(pi.getPi_price() * (1-pi.getPi_discount()))  %> 원
</div>

<%
			if(i % 4 == 3) 	out.println("</div>");
		}
	}

}else{
	out.println("<div>검색된 상품이 없습니다.</div>");
}
%>
 
</div>

<%
if (pdtList.size() > 0){
// 상품 검색결과가 있으면 페이지 번호를 출력
	out.println("<div class='page_wrapper'>");
	out.println("<p style='font-size:1.25em; width:100%;' align='center'>");

	args = "?sort=" + pdtPageInfo.getSort() + "&psize=" + pdtPageInfo.getPsize() + schargs;
	
		if(pdtPageInfo.getCpage() == 1){				
			out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
		}else{
			out.print("<a href='pdt_list.pdt" + args + "&cpage=1'>[&lt;&lt;]</a>&nbsp;&nbsp;");
			out.println("<a href='pdt_list.pdt" + args + "&cpage=" + (pdtPageInfo.getCpage() - 1) + "'>[&lt;]</a>&nbsp;&nbsp;");
		}
		
		for(int i=1, j=pdtPageInfo.getSpage(); i<= pdtPageInfo.getBsize() && j <= pdtPageInfo.getEpage(); i++, j++){
		// i : 루프 돌릴 횟수 검사하는 용도의 변수, j : 페이지 번호 출력용 변수
			if(pdtPageInfo.getCpage() == j){
				out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
			}else{
				out.print("&nbsp;<a href='pdt_list.pdt" +args + "&cpage=" +j + "'>" + j + "</a>&nbsp;");
			}
		}
		
		
		if(pdtPageInfo.getCpage() == pdtPageInfo.getPcnt()){
			out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
		}else{
			out.print("&nbsp;&nbsp;<a href='pdt_list.pdt" + args + "&cpage=" + (pdtPageInfo.getCpage() + 1 ) + "'>[&gt;]</a>");
			out.println("&nbsp;&nbsp;<a href='pdt_list.pdt" +args + "&cpage=" + (pdtPageInfo.getPcnt()) + "'>[&gt;&gt;]</a>");
		}

	out.println("</p>");
	out.println("</div>");
}
%>

</div>
<!-- ------------------------------------------------------------------------------------------------ -->
</main>
<%@ include file="../../include/footer.jsp" %>
</body>
</html>

