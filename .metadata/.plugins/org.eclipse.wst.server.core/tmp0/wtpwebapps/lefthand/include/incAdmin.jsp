<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<body>
<div id="outerBack">
	<div id="innerBack">
		<!-- header 영역 시작 -->
		<header>
			<div id="logout"><a href="#">로그아웃</a></div>
			<span id="title">관리자 모드</span>
			<p id="titleeng">Administrator</p>
			<div id="greeting">ooo님, 안녕하세요</div>
		</header>
		<!-- header 영역 종료 -->
		<!-- nav 영역 시작 -->
		<nav>
		  <ul id="ac">
			 <li class="menu1">
				<a href="#">일정 관리</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;일정</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;일정 등록</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">관리자 관리</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;관리자 목록</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;관리자 등록</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;권한 설정</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">회원 관리</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;회원 목록</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;포인트 목록</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">상품 관리</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;상품 목록</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;상품 등록</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">도전펀딩 관리</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;도전펀딩 목록</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">펀딩 관리</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;펀딩 목록</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;펀딩 등록</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">주문 관리</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;상품</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;펀딩</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">신고 관리</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;후기 신고</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;댓글 신고</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">고객센터</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;공지사항</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;FAQ</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;1:1 문의</a></li>
				</ul>
			 </li>
			 <li class="menu1">
				<a href="#">통계</a>
				<ul class="menu2">
				   <li><a href="#">&nbsp;&nbsp;&nbsp;회원별 통계</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;기간별 통계</a></li>
				   <li><a href="#">&nbsp;&nbsp;&nbsp;펀딩별 통계</a></li>
				</ul>
			 </li>
		  </ul>
		</nav>
		<!-- nav 영역 종료 -->				
	</div>	
</div>
</body>
</html>