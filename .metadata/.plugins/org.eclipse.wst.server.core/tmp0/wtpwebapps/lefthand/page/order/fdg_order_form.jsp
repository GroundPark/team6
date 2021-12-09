<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>	<!-- 돈 표기 -->
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>	<!-- ----------- 나중에 vo.* 로 통합할 예정 ----------- -->
<%
request.setCharacterEncoding("utf-8");

FundingInfo fdg = (FundingInfo)request.getAttribute("fdgInfo");
ArrayList<MemberAddr> addrList = (ArrayList<MemberAddr>)request.getAttribute("addrList");	// 배송지 목록

DecimalFormat formatter = new DecimalFormat("#,##0");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<link rel="stylesheet" type="text/css" href="css/order.css" />
	<script src="js/jquery-3.6.0.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="js/order.js"></script>
</head>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<!-- 주문폼 영역 시작 -->
<article id="orderFrmBox">
<h2>주문/결제</h2>
<form name="frmOrder" action="fdg_order_proc.ord" method="post">
<h3>펀딩 정보</h3>
<div class="box">
<table width="100%" cellpadding="10" cellspacing="0" id="cartTable">
<tr>
<th width="15%">펀딩</th><th width="*">펀딩명</th><th width="20%">단가</th>
<th width="10%">수량</th><th width="20%">구매가</th>
</tr>
<%
int total = 0;		// 총 구매가격을 저장할 변수
if (fdg != null) {	// 구매할 상품이 있으면
%>
<tr align="center">
<td><img src="page/funding/img/<%=fdg.getFi_img1() %>" width="60" height="60" align="absmiddle" /></td>
<td><%=fdg.getFi_name() %></td>
<td><%=formatter.format(fdg.getFi_price()) %>원</td>
<td><%=fdg.getOcnum() %></td>
<td><strong class="highlight2"><%=formatter.format(fdg.getFi_price() * fdg.getOcnum()) %>원</strong></td>
</tr>
<%
	total += (fdg.getFi_price() * fdg.getOcnum());

} else {	// 구매할 펀딩이 없으면
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}
%>
</table>
	<input type="hidden" name="fiidx" value="<%=fdg.getFi_idx() %>" />
	<input type="hidden" name="ocnum" value="<%=fdg.getOcnum() %>" />
	<input type="hidden" name="total" value="<%=total %>" />
</div>

<h3>배송지 정보</h3>
<div class="box">
<table width="100%" cellpadding="10" cellspacing="0" id="deliTable">
<tr>
	<th width="20%">배송지 선택</th>
	<td width="*"><select onchange="chkAddr(this.value);">
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
	</select></td>
</tr>
<%
String[] arrPhone = memberInfo.getMi_phone().split("-");
%>
<tr><th>받는 분</th><td><input type="text" name="foi_name" value="<%=memberInfo.getMi_name() %>" /></td></tr>
<tr>
	<th>연락처</th>
	<td>
		<select name="p1">
			<option value="010" <% if (arrPhone[0].equals("010")) { %>selected="selected"<% } %>>010</option>
			<option value="011" <% if (arrPhone[0].equals("011")) { %>selected="selected"<% } %>>011</option>
			<option value="016" <% if (arrPhone[0].equals("016")) { %>selected="selected"<% } %>>016</option>
			<option value="019" <% if (arrPhone[0].equals("019")) { %>selected="selected"<% } %>>019</option>
		</select> - 
		<input type="text" name="p2" size="4" value="<%=arrPhone[1] %>" /> - 
		<input type="text" name="p3" size="4" value="<%=arrPhone[2] %>" />
	</td>
</tr>
<tr>
	<th>주소</th>
	<td>
		<input type="text" name="foi_zip" id="poi_zip" size="5" readonly value="<%=zip %>" />
		<input type="button" onclick="findAddr()" value="우편번호 찾기"><br>
		<input type="text" name="foi_addr1" id="poi_addr1" value="<%=addr1 %>" /><br />
		<input type="text" name="foi_addr2" id="poi_addr2" value="<%=addr2 %>" />
	</td>
</tr>
</table>
</div>

<h3>결제</h3>
<div class="box">
<table width="100%" cellpadding="10" cellspacing="0" id="deliTable">
<tr>
	<th width="20%">결제수단</th>
	<td>
		<input type="radio" name="foi_payment" value="A" id="payA" checked="checked" /><label for="payA"> 카드 결제</label>&nbsp;&nbsp;
		<input type="radio" name="foi_payment" value="B" id="payB" /><label for="payB"> 휴대폰 결제</label>&nbsp;&nbsp;	
		<p id="caution">* 펀딩 기간 종료일까지 목표펀딩금액이 달성되지 못할 경우 결제하신 금액은 자동으로 환불 처리됩니다. (펀딩 종료일 후 최대 7일)</p>
	</td>
</tr>
<tr align="center">
	<td colspan="2" id="totalPay">총 결제 금액 : <%=formatter.format(total) %></span> 원</td>
</tr>
</table>
</div>
<div style="width:100%; margin:20px; text-align:center;">
	<input type="button" value="구매취소" class="btn" onclick="history.back();" />&nbsp;&nbsp;
	<input type="submit" value="결제하기" class="btn" />
</div>
<br />
<br />
</form>
</article>
<!-- 주문폼 영역 종료 -->
</section>
<!-- footer 영역 시작 -->
<%@ include file="../../include/footer.jsp" %>
<!-- footer 영역 종료 -->
</body>
</html>