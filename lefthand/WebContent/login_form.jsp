<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/footer.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
</head>
<body>
<header>
<%@ include file="include/header.jsp" %>
</header>
<%
if (memberInfo != null) {
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다.');");
	out.println("history.back();");
	out.println("</script>");
	out.close();	// 여기서 이 파일을 끝냄
}

request.setCharacterEncoding("utf-8");
String url = request.getParameter("url");
if (url == null)	url = "";
// 로그인 후 이동할 페이지 주소로, 없는 경우 빈 문자열로 지정
%>
<article id="login">
<form name="frmLogin" action="login" method="post">
<input type="hidden" name="url" value="<%=url %>" />
	<fieldset id="fldset">
	<h2>회원<br />로그인</h2>
		<div class="col" id="col1">
			<label for="uid">아이디</label><input type="text" name="uid" id="uid" class="txt" value="chan135" />
		</div>
		<div class="col" id="col2">
			<label for="pwd">비밀번호</label><input type="password" name="pwd" id="pwd" class="txt" value="Kwang1" />
		</div>
		<div>
			<input type="submit" value="LOGIN" name="btn" class="btn" />
		</div>
		<div>
			<input type="checkbox" name="idsave" value="idsave" id="idsave" checked="checked" /><label for="idsave">아이디 저장</label>
		</div>
	</fieldset>
</form>
</article>
<%@ include file="/include/footer.jsp" %>
</body>
</html>