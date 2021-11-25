<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- #header 영역 시작 -->
<div id="header">
	<div id="logo"><h1 class="logo"><a href="mainPage.jsp"><img src="img/logo.png" alt="로고" class="logo" /></a></h1></div>
	<ul id="infoMenu">
		<li><a href="#">회원가입</a></li>
		<li><a href="login_form.jsp">로그인</a></li>
		<li><a href="login_form.jsp?url=page/order/cart_list.ord">장바구니</a></li>
		<li><a href="page/member/update_form.jsp">정보수정</a></li>
		<li><a href="logout.jsp">로그아웃</a></li>
		<li><a href="cart_list.ord">장바구니</a></li>
		<li><a href="#">마이페이지</a></li>
		<li><a href="#">고객센터</a></li>
	</ul>
	<h2>검색 창</h2>
	<ul id="searchMain">
		<li>
			<select class="hand" id="search_kind">
				<option value="전체">전체</option>
				<option value="가위">가위</option> 
				<option value="문구">문구</option>
				<option value="주방">주방</option>
				<option value="etc">etc</option>
				<option value="도전펀딩">도전펀딩</option>
				<option value="펀딩하기">펀딩하기</option>
			</select>
		</li>
		<li><input type="text"  id="search_bar" /></li>
		<li><a href="#"><img src="img/search_btn.png" id="search_img" alt="검색" /></a></li>
	</ul>
	<h2>메인 메뉴</h2>
	<ul id="navigation">
		<li><a href="pdt_list.pdt">가위</a></li>
		<li><a href="page/product/pdt_office.jsp">문구</a></li>
		<li><a href="page/product/pdt_kitchen.jsp">주방</a></li>
		<li><a href="page/product/pdt_etc.jsp">etc</a></li>
		<li><a href="chal_list.chal">도전펀딩</a></li>
		<li><a href="pdt_list.fdg">펀딩하기</a></li>
	</ul>
	<h2>SNS</h2>
	<ul id="sns">
		<li><a href="#"><img src="img/instagram.png" alt="인스타" /></a></li>
		<li><a href="#"><img src="img/facebook.jpg" alt="페이스북" /></a></li>
		<li><a href="#"><img src="img/twitter.png" alt="트위터" /></a></li>
	</ul>
</div>
<!-- div#header 영역 종료 -->
