<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>	<!-- 돈 표기 -->
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>	<!-- ----------- 나중에 vo.* 로 통합할 예정 ----------- -->
<%
request.setCharacterEncoding("utf-8");
FdgOrderInfo fdgOrd = (FdgOrderInfo)request.getAttribute("fdgOrd");	// 보낸 거 받아오기
ArrayList<FdgOrderDetail> fdgDetailList = fdgOrd.getFdgDetailList();

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
</head>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<!-- 주문 내역 영역 시작 -->
<article id="orderSuccessBox">
<h2>펀딩 완료!</h2>
<p id="orderNum">주문번호 : <%=fdgOrd.getFoi_id() %></p>
<h3>주문한 펀딩 내역</h3>
<table width="100%" cellpadding="10" cellspacing="0" id="successTable">
<tr>
<th width="15%">상품</th><th width="*">상품명</th><th width="20%">수량</th>
<th width="10%">단가</th>
</tr>
<% 
FdgOrderDetail myDetail = new FdgOrderDetail(); 

myDetail = fdgDetailList.get(0);
%>
<tr align="center">
<td><img src="page/funding/img/<%=myDetail.getFod_pimg() %>" width="60" height="60" align="absmiddle" /></td>
<td><%=myDetail.getFod_pname() %></td>
<td><%=myDetail.getFod_cnt() %></td>
<td><%=formatter.format(myDetail.getFod_pprice()) %>원</td>
</tr>
</table>

<h3>배송지 정보</h3>
<div class="box">
	수취인명 : <%=fdgOrd.getFoi_name() %> <br />
	전화번호 : <%=fdgOrd.getFoi_phone() %><br />
	주소 : (<%=fdgOrd.getFoi_zip() %>) <%=fdgOrd.getFoi_addr1() + "&nbsp;" + fdgOrd.getFoi_addr2() %> 
</div>

<h3>결제 정보</h3>
<div class="box">
	결제수단 : 카드결제<br />
	총결제액 : <%=fdgOrd.getFoi_pay() %> 원<br />
</div>
<div style="width:100%; margin:20px; text-align:center;">
	<input type="submit" value="계속 쇼핑" class="btn" onclick="location.href='index.jsp'" />&nbsp;&nbsp;
</div>
</article>
<!-- 주문 내역 영역 종료 -->
</section>
<!-- footer 영역 시작 -->
<%@ include file="../../include/footer.jsp" %>
<!-- footer 영역 종료 -->
</body>
</html>