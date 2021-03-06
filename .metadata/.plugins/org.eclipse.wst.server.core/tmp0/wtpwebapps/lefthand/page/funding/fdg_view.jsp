<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %> <!-- ----------- 나중에 vo.* 로 통합할 예정 ----------- -->
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/funding_info.css" />
	<script src="js/jquery-3.6.0.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="js/mainSlide.js"></script>
	<script src="js/mainPage_scroll.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<%
request.setCharacterEncoding("utf-8");

FundingInfo fdg = (FundingInfo)request.getAttribute("fdgInfo");
FdgPageInfo pageInfo = (FdgPageInfo)request.getAttribute("fdgPageInfo");
// 검색 조건 등의 정보를 저장하고 있는 인스턴스
%>

<script>
var num = 1;							// 펀딩 개수를 저장한 변수
var total = <%=fdg.getFi_price() %>;	// 펀딩 가격을 저장한 변수
function changeNum(op) {
	var obj1 = document.getElementById("num");
	var obj2 = document.getElementById("total");
	if (op == "+") {
		num = num + 1;
	} else {
		if (num > 1) 	num = num - 1;
	}
	obj1.innerHTML = num;
	obj2.innerHTML = (num * total);
	document.frmFdg.ocnum.value = num;
}

$(document).ready(function() {
	$("#img1").click(function() {
		$("#bigImg").attr("src", $(this).attr("src"))
		// id가 bigImg인 개체의 src속성 값을 변경
		// 이벤트를 일으킨 객체(this)의 src 속성값을 bigImg의 src 속성에 넣어줌
	});
	$("#img2").click(function() {
		$("#bigImg").attr("src", $(this).attr("src"))
	});
	$("#img3").click(function() {
		$("#bigImg").attr("src", $(this).attr("src"))
	});
});

function goFunding() {
// 펀딩하기 버튼 클릭 시 주문창으로 이동시키는 함수로 비로그인 시 로그인 폼으로 이동시켜야 함
<% if (!isLogin) { %>
	alert("로그인 후 이용 가능합니다.");
	window.location.href = "login_form.jsp?url=fdg_view.fdg?<%=request.getQueryString().replace("&", "$") %>";

<% } else {	 %>	// 로그인 상태면 해당 위치로 전송시킴
	var lnk = "";
	var frm = document.frmFdg;
	frm.action = "fdg_order_form.ord";	// 펀딩하기 주문창으로 이동
	frm.submit();
<% } %>
}
</script>

<div id="fundinginfo">
	<form name="frmFdg" method="post">
	<input type="hidden" name="fiidx" value="<%=fdg.getFi_idx() %>" />
	<input type="hidden" name="cpage" value="<%=pageInfo.getCpage() %>" />
	<input type="hidden" name="psize" value="<%=pageInfo.getPsize() %>" />
	<input type="hidden" name="sort" value="<%=pageInfo.getSort() %>" />
	<input type="hidden" name="wtype" value="in" />
	<input type="hidden" name="ocnum" value="1" />
		<div class="fundinginfo">
			<div id="fundingname"><%=fdg.getFi_name() %></div>
			<div id="fundingmainimg">
				<img src="page/funding/img/<%=fdg.getFi_img1() %>" id="bigImg" id="bigImg" />
			</div>
			<ul id="fundingimgs">
				<li><img src="page/funding/img/<%=fdg.getFi_img1() %>" id="img1" class="hand" /></li>
				<li><img src="page/funding/img/<%=fdg.getFi_img2() %>" id="img2" class="hand" /></li>
				<li><img src="page/funding/img/<%=fdg.getFi_img3() %>" id="img3" class="hand" /></li>
			</ul>
		</div>
		<div id="fundinginfodesc">
			기간 : <%=fdg.getFi_sdate().substring(0, 10) %> ~ <%=fdg.getFi_edate().substring(0, 10) %><br /><br /><br />
			달성률 : <%=Math.round(fdg.getFi_rate() * 100) %>% 달성<br /><br /><br />
			총 모금액 : <%=fdg.getFi_total() %>원<br /><br /><br />
			참여자 수 : <%=fdg.getFi_support() %> 명 참여
		</div>
		<div id="fundingprice">개당 <%=fdg.getFi_price() %> 원</div>
		<div id="fundingnum">
			<input type="button" value="-" class="plusminus" id="minus" onclick="changeNum(this.value);" />
			<span class="num" id="num">1</span>
			<input type="button" value="+" class="plusminus" id="plus" onclick="changeNum(this.value);" />
		</div>
		<div id="fundingtotalprice">총 가격 <span id="total"><%=fdg.getFi_price() %></span>원</div>
		<div id="funding">
			<input type="button" value="펀딩하기" name="ordfdg" id="ordfdg" class="fundingbtn" onclick="goFunding(); return false;">
		</div>
	</form>
	<div id="fundingdescimg"><img src="page/funding/img/<%=fdg.getFi_desc() %>" id="descImg" /></div>
	<div id="desc"></div>
	<div id="plicy"></div>

	<div id="qna"></div>
	<ul id="fundingdesclink">
		<li><a href="#desc" class="hand">설명</a></li>
		<li><a href="#plicy" class="hand">변환정책</a></li>
		<li><a href="#qna" class="hand">FAQ</a></li>
	</ul>
</div>
</div>
</div>
</main>
<%@ include file="../../include/footer.jsp" %>
</body>
</html>