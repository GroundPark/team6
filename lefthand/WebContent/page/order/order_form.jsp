<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>	<!-- 돈 표기 -->
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");
ArrayList<CartInfo> pdtList = (ArrayList<CartInfo>)request.getAttribute("orderPdtList");
ArrayList<MemberAddr> addrList = (ArrayList<MemberAddr>)request.getAttribute("addrList");	// 배송지 목록
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.box { border:1px solid black; width:600px; padding:10px; margin-bottom:10px;  }
</style>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<link rel="stylesheet" type="text/css" href="css/mypage.css" />
	<script src="js/jquery-3.6.0.js"></script>
	<script src="js/mypage.js"></script>
</head>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<!-- 주문폼 영역 시작 -->
<article id="cartListBox">
<h2>상품 주문서 화면</h2>
<form name="frmOrder" action="order_proc.ord" method="post">
<h3>구매할 상품</h3>
<div class="box">
<%
String pocidx = "";	// 장바구니의 인덱스 번호(들)을 저장할 변수
int total = 0;		// 총 구매가격을 저장할 변수
int savePnt = 0;	// 적립시킬 포인트를 저장할 변수
if (pdtList != null && pdtList.size() > 0) {	// 구매할 상품이 있으면
	for (int i = 0 ; i < pdtList.size() ; i++) {
		CartInfo pdt = pdtList.get(i);
		// pdtList 안에 들어있는 i번째 인스턴스를 CartInfo형 인스턴스로 생성
		
		pocidx += "," + pdt.getPoc_idx();		// 장바구니의 인덱스 번호(들)을 누적시켜 저장	
%>
	<p style="margin:0;">
		<table width="100%">
		<tr>
		<td width="80" align="center">
			<img src="page/product/img/<%=pdt.getPi_img1() %>" width="60" height="60" />
		</td>
		<td width="*">
			<%=pdt.getPi_name() + " / 개수 : " + pdt.getPoc_cnt() + "ea"%><br />
			<%="단가 : " + pdt.getPi_price() %>
		</td>
		</tr>
		</table>		
	</p>
<%
		total += pdt.getPi_price() * pdt.getPoc_cnt();
	}	
	pocidx = pocidx.substring(1);	// 장바구니 인덱스 값들 중 맨 앞 쉼표 자르기
	savePnt = total / 100;		// 결제금액의 1%를 포인트로 적립

} else {	// 구매할 상품이 없으면
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}
%>
	<input type="hidden" name="pocidx" value="<%=pocidx %>" />
	<input type="hidden" name="savePnt" value="<%=savePnt %>" />
</div>

<h3>배송지 정보</h3>
<div class="box">
<%
String[] arrPhone = memberInfo.getMi_phone().split("-");
%>
	수취인 : <input type="text" name="poi_name" value="<%=memberInfo.getMi_name() %>" /><br />
	전화번호 : 
		<select name="p1">
			<option value="010" <% if (arrPhone[0].equals("010")) { %>selected="selected"<% } %>>010</option>
			<option value="011" <% if (arrPhone[0].equals("011")) { %>selected="selected"<% } %>>011</option>
			<option value="016" <% if (arrPhone[0].equals("016")) { %>selected="selected"<% } %>>016</option>
			<option value="019" <% if (arrPhone[0].equals("019")) { %>selected="selected"<% } %>>019</option>
		</select> - 
		<input type="text" name="p2" size="4" value="<%=arrPhone[1] %>" /> - 
		<input type="text" name="p3" size="4" value="<%=arrPhone[2] %>" /><br />
	배송지 선택 : 
		<select onchange="chAddr(this.value);">
<% 
String zip = "", addr1 = "", addr2 = "";
for (int i = 0 ; i < addrList.size() ; i++) { 
	MemberAddr addr = addrList.get(i);
	String tmpAddr = addr.getMa_name() + " : " + addr.getMa_addr1() + " " + addr.getMa_addr2();
	String tmpAddr2 = addr.getMa_zip() + ":" + addr.getMa_addr1() + ":" + addr.getMa_addr2();
	if (addr.getMa_basic().equals("y")) {
		zip = addr.getMa_zip();
		addr1 = addr.getMa_addr1();
		addr2 = addr.getMa_addr2();
	}	// 처음에 보여줄 기본주소를 변수에 저장
%>
			<option value="<%=tmpAddr2 %>"><%=tmpAddr %></option>
<%	
}
%>
			<option value="">새 주소 입력</option>
		</select><br />
	우편번호 : <input type="text" name="poi_zip" size="5" value="<%=zip %>" /><br />
	주소 : <input type="text" name="poi_addr1" value="<%=addr1 %>" /> 
		<input type="text" name="poi_addr2" value="<%=addr2 %>" />
</div>

<h3>결제 정보</h3>
<div class="box">
	<input type="radio" name="poi_payment" value="A" id="payA" checked="checked" /><label for="payA">카드 결제</label>&nbsp;&nbsp;
	<input type="radio" name="poi_payment" value="B" id="payB" /><label for="payB">휴대폰 결제</label>&nbsp;&nbsp;	
	<p style="text-align:right; margin:5px 0 0 0;">총 결제 금액 : <%=total %></p>
</div>
<div style="width:600px; margin:20px; text-align:center;">
	<input type="submit" value="상품 구매" />&nbsp;&nbsp;
	<input type="button" value="구매 취소" onclick="history.back();" />
</div>
</form>
</article>
<!-- 주문폼 영역 종료 -->
</section>
<!-- footer 영역 시작 -->
<%@ include file="../../include/footer.jsp" %>
<!-- footer 영역 종료 -->
</body>
</html>