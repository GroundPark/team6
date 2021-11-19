<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="product.vo.*" %>

<%
// request.setCharacterEncoding("utf-8");
// MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");

// boolean isLogin = false;
// if(memberInfo != null)		isLogin = true;
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/footer.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/teststyle.css" />
<meta charset="UTF-8">
<title>왼손잡상점</title>
</head>
<body>
<table class="header" border="1">
<tr>
	<td colspan="2" rowspan="2" align="right">
		<a href="index.jsp"><img src="img/logo.png" alt="왼손잡상점" width="155px" height="100px" /></a>
	</td>
	<td colspan="4" align="right" style="padding-right:30px">
		<a href="#">회원가입</a> | <a href="#">로그인</a> | <a href="#">장바구니</a> | <a href="#">마이페이지</a> | <a href="#">고객센터</a>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<select>
			<option value="전체">전체</option>
			<option value="가위">가위</option>
			<option value="문구">문구</option>
			<option value="주방">주방</option>
			<option value="etc">etc</option>
			<option value="도전펀딩">도전펀딩</option>
			<option value="펀딩하기">펀딩하기</option>
		</select>
		<input type="text" />
	</td>
	<td colspan="2" align="center">
		<a href=""><img src="img/instagram.png" alt="인스타" width="30px" height="30px" /></a>
		<a href=""><img src="img/facebook.jpg" alt="페이스북" width="30px" height="30px" /></a>
		<a href=""><img src="img/twitter.png" alt="트위터" width="30px"  height="30px"/></a>
	</td>
</tr>
<tr align="center">
	<!-- 여기 tmp.jpg는 임시 이미지입니다. 완성시 교체 또는 삭제하세요 -->
	<td width="17%">
		<a href="pdt_list.pdt">가위<img src="img/tmp.jpg" alt="가위" /></a>
	</td>
	<td width="17%">
		<a href="pdt_office.pdt">문구<img src="img/tmp.jpg" alt="문구" /></a>
	</td>
	<td width="17%">
		<a href="pdt_kitchen.pdt">주방<img src="img/tmp.jpg" alt="주방" /></a>
	</td>
	<td width="*%">
		<a href="pdt_etc.pdt">etc<img src="img/tmp.jpg" alt="etc" /></a>
	</td>
	<td width="17%">
		<a href="#">도전펀딩<img src="img/tmp.jpg" alt="도전펀딩" /></a>
	</td>
	<td width="17%">
		<a href="#">펀딩하기<img src="img/tmp.jpg" alt="펀딩하기" /></a>
	</td>
</tr>
</table>
<hr />