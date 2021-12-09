<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String grade = "Silver";
if (memberInfo.getMi_grade().equals("b"))		grade = "Gold";
else if (memberInfo.getMi_grade().equals("c"))	grade = "Diamond";
%>
<!-- nav 영역 시작 -->
<!-- memberInfo에 빨간줄 신경 ㄴㄴ -->
<section id="mypageBox">
<nav id="mypage">
  <ul id="mypageMenu">
	 <li class="myMenu1">
		<p class="grouping">내 쇼핑</p>
		<ul class="myMenu2">
		   <li><a href="#">주문/배송조회</a></li>
		   <li><a href="#">취소/반품/교환 내역</a></li>
		   <li><a href="cart_list.ord">장바구니</a></li>
		   <li><a href="#">좋아요</a></li>
		   <li><a href="#">공감</a></li>
		   <li><a href="#">포인트</a></li>
		</ul>
	 </li>
	 <li class="myMenu1">
		<p class="grouping">내 활동</p>
		<ul class="myMenu2">
		   <li><a href="#">1:1 문의내역</a></li>
		   <li><a href="#">도전펀딩 내역</a></li>
		   <li><a href="#">마이펀딩 내역</a></li>
		</ul>
	 </li>
	 <li class="myMenu1">
		<p class="grouping">내 정보</p>
		<ul class="myMenu2">
		   <li><a href="#">회원정보 수정</a></li>
		   <li><a href="#">주소록 관리</a></li>
		   <li><a href="#">비밀번호 변경</a></li>
		   <li><a href="#">회원 탈퇴</a></li>
		</ul>
	 </li>
  </ul>
</nav>
<!-- nav 영역 종료 -->	
<!-- 간단 정보 영역 시작 -->
<article>
<div id="simpleInfo">
<span><strong class="highlight"><%=memberInfo.getMi_name() %></strong> 님 반갑습니다.</span>
<span>보유포인트 <strong class="highlight"><%=memberInfo.getMi_point() %></strong> p</span>
<span>등급 <strong class="highlight"><%=grade %></strong></span>
</div>