<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>	<!-- 로그인 정보를 담은 인스턴스를 사용하기 위해 import -->
	<!-- 멤버의 주소 정보를 담은 인스턴스를 사용하기 위해 import -->

<!-- actionforward를 가 계속 겹치니까 vo를 src밑에 폴더로 vo파일안에 넣는 통합작업 해야함 -->
<!-- 1~2일뒤에 할예정이므로 일단 위에거 쓰셈 -->
<!-- 원래는 page import="member.vo.*" 가 맞음!! -->



<%
request.setCharacterEncoding("utf-8");

String sch_kind = request.getParameter("sch_kind");
if (sch_kind == null)	sch_kind = "";

String keyword = request.getParameter("keyword");
if (keyword == null)	keyword = "";

MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
boolean isLogin = false;
if (memberInfo != null)	isLogin = true;
%>
<!-- #header 영역 시작 -->
<!-- 모든 사이트에서 적용되는 css -->
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/footer.css" />


<script src="js/search.js"></script>

<div id="header" class="header">
	<div id="logo"><h1 class="logo"><a href="index.jsp"><img src="img/logo.png" alt="로고" class="logo" /></a></h1></div>
	<ul id="infoMenu">
<% if(memberInfo == null) { %>
		<li><a href="#">회원가입</a></li>
		<li><a href="login_form.jsp">로그인</a></li>
		<li><a href="login_form.jsp?url=page/order/cart_list.ord">장바구니</a></li>
<% } else { %>
		<li><%=memberInfo.getMi_name() %> 님, 안녕하세요.</li>
		<li><a href="logout.jsp">로그아웃</a></li>
		<li><a href="cart_list.ord">장바구니</a></li>
		<li><a href="mypage.mem">마이페이지</a></li>
<% } %>
		<li><a href="#">고객센터</a></li>
	</ul>
	<h2>검색 창</h2>
	<!-- js로 select의 값을 확인한 후 각 값에 따라 action을 달리 정해주면 되지않음? -->
	<form name="frmSch" action="#" method="get" >
	<ul id="searchMain">
		<li><select class="hand" id="search_kind" name="sch_kind">
			<option value="상품" <% if(sch_kind.equals("상품")) { %> selected="selected" <% } %>>일반상품</option>
			<option value="펀딩" <% if(sch_kind.equals("펀딩")) { %> selected="selected" <% } %>>펀딩상품</option>
			<option value="도전" <% if(sch_kind.equals("도전")) { %> selected="selected" <% } %>>도전펀딩</option>
		 </select></li>
		<li><input type="text"  id="search_bar" name="keyword" onkeydown="enterkey();" value="<%= keyword %>" /></li>
		<li><input type="button" value="검색" id="goSch" onclick="Examine()" /></li>
	</form>
	</ul>
	<h2>메인 메뉴</h2>
	<ul id="navigation">
		<li><a href="pdt_list.pdt?cata=a">가위</a></li>
		<li><a href="pdt_list.pdt?cata=b">문구</a></li>
		<li><a href="pdt_list.pdt?cata=c">주방</a></li>
		<li><a href="pdt_list.pdt?cata=d">etc</a></li>
		<li><a href="chal_list.chal">도전펀딩</a></li>
		<li><a href="fdg_list.fdg">펀딩하기</a></li>
	</ul>
	<h2>SNS</h2>
	<ul id="sns">
		<li><a href="#"><img src="img/instagram.png" alt="인스타" /></a></li>
		<li><a href="#"><img src="img/facebook.jpg" alt="페이스북" /></a></li>
		<li><a href="#"><img src="img/twitter.png" alt="트위터" /></a></li>
	</ul>
</div>
<!-- div#header 영역 종료 -->
