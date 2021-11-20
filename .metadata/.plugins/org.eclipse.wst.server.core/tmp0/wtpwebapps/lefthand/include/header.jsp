<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="product.vo.*" %>
<%
// request.setCharacterEncoding("utf-8");
// MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");

// boolean isLogin = false;
// if(memberInfo != null)		isLogin = true;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />	
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/footer.css" />
<link rel="stylesheet" type="text/css" href="css/teststyle.css" />	<!-- 박지상 테스트용 css -->
<script type="text/javascript" src=""></script>
<script type="text/javascript" src=""></script>
</head>
<body>
<!-- #header 영역 시작 -->	
<div id="wrapper">
<div id="header">
	<div id="logo"><h1 class="logo"><a href="index.jsp"><img src="img/header/logo.png" alt="로고" class="logo" /></a></h1></div>
	<ul id="infoMenu">
		<li><a href="#">회원가입</a></li>
		<li><a href="#">로그인</a></li>
		<li><a href="#">장바구니</a></li>
		<li><a href="#">마이페이지</a></li>
		<li><a href="#">고객센터</a></li>
	</ul>
	<h2>검색 창</h2>
	<ul id="searchMain">
		<li><select class="hand">
			<option value="전체">전체</option>
			<option value="가위">가위</option> 
			<option value="문구">문구</option>
			<option value="주방">주방</option>
			<option value="etc">etc</option>
			<option value="도전펀딩">도전펀딩</option>
			<option value="펀딩하기">펀딩하기</option>
		</select></li>
		<li><input type="text" /></li>
	</ul>
	<h2>메인 메뉴</h2>
	<ul id="navigation">
		<li><a href="pdt_list.pdt">가위</a></li>
		<li><a href="pdt_office.pdt">문구</a></li>
		<li><a href="pdt_kitchen.pdt">주방</a></li>
		<li><a href="pdt_etc.pdt">etc</a></li>
		<li><a href="#">도전펀딩</a></li>
		<li><a href="#">펀딩하기</a></li>
	</ul>
	<h2>SNS</h2>
	<ul id="sns">
		<li><a href="#"><img src="img/header/instagram.png" alt="인스타" /></a></li>
		<li><a href="#"><img src="img/header/facebook.jpg" alt="페이스북" /></a></li>
		<li><a href="#"><img src="img/header/twitter.png" alt="트위터" /></a></li>
	</ul>
</div>
<!-- div#header 영역 종료 -->
	