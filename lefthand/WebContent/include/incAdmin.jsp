<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
AdminInfo adminInfo = (AdminInfo)session.getAttribute("adminInfo");
if (adminInfo == null) {
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다.');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/reset.css" />
<link rel="stylesheet" href="../css/admin_base.css" />
<link rel="stylesheet" href="../css/admin_layout.css" />
<script src="../js/jquery-3.6.0.js"></script>
<script src="../js/admin.js"></script>
</head>
<script>

</script>
<body>
<div id="outerBack">
	<div id="innerBack">
		<!-- header 영역 시작 -->
		<header>
			<div id="logout"><a href="admin_logout.jsp">로그아웃</a></div>
			<span id="title" onclick="location.href='admin_mainPage.jsp'" style="cursor:pointer">관리자 모드</span>
			<p id="titleeng" onclick="location.href='admin_mainPage.jsp'" style="cursor:pointer">Administrator</p>
			<div id="greeting"><%=adminInfo.getAi_name() %>님, 안녕하세요</div>
		</header>
		<!-- header 영역 종료 -->
		<!-- nav 영역 시작 -->
		<!-- 테스트하려고 임의로 넣었습니다  -->
		<nav>
		  <ul id="ac">
			 <li class="menu1">
				<a href="#">일정 관리</a>
				<ul class="menu2">
				   <li><a href="admin_mainPage.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정</a></li>
				   <li><a href="schedule_form.sche?wtype=in">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 등록</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">관리자 관리</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관리자 목록</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관리자 등록</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;권한 설정</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">회원 관리</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원 목록</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포인트 목록</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">상품 관리</a>
				<ul class="menu2">
				   <li><a href="admin_pdt_list.adminpdt">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상품 목록</a></li>
				   <li><a href="admin_pdt_in_form.adminpdt">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상품 등록</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">도전펀딩 관리</a>
				<ul class="menu2">
				   <li><a href="chal_list.admin">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;도전펀딩 목록</a></li>
				   <li><a href="chal_manage_reply.admin">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;도전펀딩 댓글 관리</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">펀딩 관리</a>
				<ul class="menu2">
				   <li><a href="funding_list.admin">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;펀딩 목록</a></li>
				   <li><a href="/lefthand/admin/admin_funding_in.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;펀딩 등록</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">주문 관리</a>
				<ul class="menu2">
				   <li><a href="order_pdt.adminord">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상품</a></li>
				   <li><a href="order_fdg.adminord">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;펀딩</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">신고 관리</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;후기 신고</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글 신고</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">고객센터</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;공지사항</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FAQ</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1:1 문의</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">통계</a>
				<ul class="menu2">
				   <li><a href="member.stat">&nbsp;&nbsp;&nbsp;회원별 통계</a></li>
				   <li><a href="period.stat">&nbsp;&nbsp;&nbsp;기간별 통계</a></li>
				   <li><a href="fund.stat">&nbsp;&nbsp;&nbsp;펀딩별 통계</a></li>
				</ul>
			 </li>
		  </ul>
		</nav>
		<!-- nav 영역 종료 -->				
	</div>	
</div>
</body>
</html>