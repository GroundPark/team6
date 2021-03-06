<%@ page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>

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
	<script src="js/jquery-3.6.0.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
</head>	
<style>

#align { width:1160px; align:right; }	

.pdt_contents {
	width:1200px;  margin: 0 auto;
	overflow:hidden;
	height:100%;		
	padding-bottom:300px;
	position:relative;
}

/* 통합 전 추가 */

.pdt_contents a:link { color:black; text-decoration:none; }	
.pdt_contents a:visited { color:black; text-decoration:none; }
.pdt_contents a:hover { color:black; text-decoration:none; font-weight:bold; }
.pdt_contents a:focus { color:black; text-decoration:none; }
.pdt_contents a:active { color:black; text-decoration:none; }

a {text-decoration:none; }

/* 통합 전 추가 */


.pdt { margin:30px 20px 0 20px; float:left; font-size:1.4em; }

#pdt_img_box { position:relative; }
#pdt_img { border:1px solid black; }
#pdt_zzim {
	position:absolute;
	background:none;
	border:0px solid #d1d1d1;
	outline:none;
	top:90%;
	left:87%;
	width:35px;
	height:30px;
	padding:0;
    cursor: pointer;
}
.pdt_title { margin-top:15px; }
#pdt_name { font-weight:bold; display:inline-block; margin-bottom:6px; text-align:right; }
#pdt_soldout { color:red; font-weight:bold; font-size:0.7em; }

#pdt_price1 { 
	text-decoration:line-through; color:gray; font-size:0.9em; display:inline-block; margin:0 10px 0 -30px; 
}
#pdt_price2	{ color:red; font-size:1.2em; display:inline-block; }

.pdt_real_price { color:red; font-size:1.1em; }

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
		if(pi.getPi_stock() != 0){		
			lnk = "<a href=\"pdt_view.pdt" + args + "&piid=" + pi.getPi_id() + "&sort=" + pdtPageInfo.getSort() +
					"&psize=" +pdtPageInfo.getPsize() + "\">";
		} else{		
			lnk = "<a href=\"javascript:alert('품절된 상품입니다.');\">";
		} 
		
		if(pdtPageInfo.getPsize() == 12) {
		
			if(i % 3 == 0)		out.println("<div align='center'>");
		
		// 숫자에 콤마 찍기위한 인스턴스
		DecimalFormat decFormat = new DecimalFormat("###,###");
		int price = pi.getPi_price();
%>

<div class="pdt">
	<div id="pdt_img_box">
		<div id="pdt_img"><%=lnk %><img src="page/product/img/<%=pi.getPi_img1() %>" style="width:350px; height:350px; padding-bottom:10px;" /></div>
		<button type="button" id="pdt_zzim" value="하트"><img src="img/pdt_heart_empty.png " width="28px" height="24px"/></button>
	</div>
	<div class="pdt_title"><span id="pdt_name"><%=pi.getPi_name() %></span></a>
	<% if(pi.getPi_soldout().equals("y")) { %><span id ="pdt_soldout">품절</span>  <% } %> <br />	
	<% if(pi.getPi_discount() != 0){ %>
	<span id="pdt_price1"><%=decFormat.format(price) %>원</span>
	<% } %>  
	<span id="pdt_price2"><%=decFormat.format((int)(pi.getPi_price() * (1-pi.getPi_discount()))) %>원</span></div>
</div>

<%
			if(i % 4 == 3) 	out.println("</div>");
			if(i == pdtList.size() - 1 && i % 4 != 3){	
				// 현재 출력하는 데이터가 pdtList의 마지막 데이터이면서 3칸을 모두 채우지 못했을 경우
				out.println("</div>");
	}
  }
}

}else{
	out.println("<div>검색된 상품이 없습니다.</div>");
}
%>

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
</div>
<!-- ------------------------------------------------------------------------------------------------ -->
</main>
<%@ include file="../../include/footer.jsp" %>
</body>
</html>

