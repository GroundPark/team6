<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>	<!-- 돈 표기 -->
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");
ArrayList<CartInfo> pdtList = (ArrayList<CartInfo>)request.getAttribute("orderPdtList");
ArrayList<MemberAddr> addrList = (ArrayList<MemberAddr>)request.getAttribute("addrList");	// 배송지 목록

String piid = request.getParameter("piid");						// 선택한 상품 아이디
int poccnt = Integer.parseInt(request.getParameter("poccnt"));	// 선택한 수량

DecimalFormat formatter = new DecimalFormat("#,##0");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/order.css" />
	<script src="js/jquery-3.6.0.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	<!-- 주소검색용 -->
	<script src="js/order.js"></script>
</head>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<!-- 주문폼 영역 시작 -->
<article id="orderFrmBox">
<h2>주문/결제</h2>
<form name="frmOrder" action="order_proc.ord?piid=<%=piid %>&poccnt=<%=poccnt %>" method="post">
<h3>상품 정보</h3>
<div class="box">
<table width="100%" cellpadding="10" cellspacing="0" id="cartTable">
<tr>
<th width="15%">상품</th><th width="*">상품명</th><th width="20%">판매가</th>
<th width="10%">수량</th><th width="20%">구매가</th>
</tr>
<%
int delipay = 0;	// 배송비를 저장할 변수
int total = 0;		// 총 구매가격을 저장할 변수
int savePnt = 0;	// 적립시킬 포인트를 저장할 변수 - 우리는 컬럼이 없어서 일단 만들어 놓긴 했지만 쓰진 않을 거임
if (pdtList != null && pdtList.size() > 0) {	// 구매할 상품이 있으면
	for (int i = 0 ; i < pdtList.size() ; i++) {
		CartInfo pdt = pdtList.get(i);
		// pdtList 안에 들어있는 i번째 인스턴스를 CartInfo형 인스턴스로 생성
		
%>
<tr align="center">
<td><img src="page/product/img/<%=pdt.getPi_img1() %>" width="60" height="60" align="absmiddle" /></td>
<td><%=pdt.getPi_name() %></td>
<td><%=formatter.format(pdt.getPi_price()) %>원</td>
<td><%=poccnt %></td>
<td><del><%=formatter.format(pdt.getPi_price() * poccnt)  %></del><br />
<strong class="highlight2"><%=formatter.format(((pdt.getPi_price() * (1 - pdt.getPi_discount())) * poccnt))%>원</strong></td>
</tr>
<%
		total += ((pdt.getPi_price() * (1 - pdt.getPi_discount())) * poccnt);
		
		if (total < 30000)	delipay = 2500;	
		else				delipay = 0;
		
		
	}	
	savePnt = total / 100 * 5;		// 결제금액의 5%를 포인트로 적립

} else {	// 구매할 상품이 없으면
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}
%>
</table>
	<input type="hidden" name="pocidx" value="0" />
	<input type="hidden" name="poipay" value="<%=total + delipay %>" />
	<input type="hidden" name="savePnt" value="<%=savePnt %>" />
	<input type="hidden" name="delipay" value="<%=delipay %>" />
</div>

<h3>배송지 정보</h3>
<div class="box">
<table width="100%" cellpadding="10" cellspacing="0" id="deliTable">
<%
String[] arrPhone = memberInfo.getMi_phone().split("-");
%>
<tr><th>받는 분</th><td><input type="text" name="poi_name" value="<%=memberInfo.getMi_name() %>" /></td></tr>
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
	<th width="20%">배송지 선택</th>
	<td width="*"><select onchange="chkAddr(this.value);" id="addrSelect">
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
<tr>
	<th>주소</th>
	<td>
		<input type="text" name="poi_zip" id="poi_zip" size="5" readonly value="<%=zip %>" />
		<input type="button" onclick="findAddr()" value="우편번호 찾기"><br>
		<input type="text" name="poi_addr1" id="poi_addr1" value="<%=addr1 %>" /><br />
		<input type="text" name="poi_addr2" id="poi_addr2" value="<%=addr2 %>" />
	</td>
</tr>
</table>
</div>

<h3>포인트 사용 및 결제</h3>
<div class="box">
<table width="100%" cellpadding="10" cellspacing="0" id="deliTable">
<tr><th width="20%">사용 포인트</th>
	<td>
		<span><input type="checkbox" id="chk_use" onclick="chkPoint(<%=total %>,<%=memberInfo.getMi_point() %>,10, <%=delipay %>)">
		<label for="chk_use"> 포인트 전체 사용</label></span><br />
        <span><input type="number" name="use_pnt" id="use_pnt" max="<%=total %>" value="0" onchange="changePoint(<%=total %>,<%=memberInfo.getMi_point() %>,10, <%=delipay %>);"></span> p 
        / <span name="left_pnt" id="left_pnt"><%=memberInfo.getMi_point() %> p</span> <br />
        <span>포인트는 10p단위로 사용 가능합니다.</span>
    </td>
</tr>
<tr><th>결제수단</th>
	<td>
		<input type="radio" name="poi_payment" value="A" id="payA" checked="checked" /><label for="payA"> 카드 결제</label>&nbsp;&nbsp;
		<input type="radio" name="poi_payment" value="B" id="payB" /><label for="payB"> 휴대폰 결제</label>&nbsp;&nbsp;	
	</td>
</tr>
<tr align="center">
	<td colspan="2" id="totalPay">총 결제 금액 : <%=formatter.format(total) %> 원 - <span id="result_pnt">0</span> p + 
	<%=formatter.format(delipay) %> (배송비) = <span id="highlight"><%=formatter.format(total + delipay) %></span> 원</td>
</tr>
</table>
</div>
<div style="width:100%; margin:20px; text-align:center;">
	<input type="button" value="결제하기" class="btn" onclick="submit();"/>&nbsp;&nbsp;
	<input type="button" value="구매취소" class="btn" onclick="history.back();" />
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