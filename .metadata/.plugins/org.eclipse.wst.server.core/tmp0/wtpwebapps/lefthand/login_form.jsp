<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="member.vo.*" %>	
<%
MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/footer.css" />
<style>
#login { background:#eee; }
#login #fldset { position: absolute; top:0; bottom:0; left:0; right:0; width:800px; height:300px; margin:auto; border:0; background:#fff; 
		border-right:3px solid #c1c1c1; border-bottom:3px solid #c1c1c1; }
#login h2 { font-size:30px; text-align:left; vertical-align:middle; padding-left:100px; padding-top:80px; font-weight:normal; letter-spacing :0.2em; }
#login .col { margin-left:280px; padding:5px 0 0 5px; }
#login #col1 { margin-top:-105px; }
#login #col2 { margin-top:0px; }
#login label { font-size:13px; }
#login .txt { width:200px; height:30px; font-size:13px; border:1px solid black; margin-left:10px; }
#login #uid { margin-left:23px; }
#login .btn { position:absolute; top:115px; left:595px; width:100px; height:73px; border:0; border-right:2px solid #c1c1c1; border-bottom:2px solid #c1c1c1; background:#eee; }
#login #idsave { margin-left:370px; margin-top:10px; }
</style>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<article id="login">
<form name="frmLogin" action="login" method="post">
<input type="hidden" name="url" value="<%=url %>" />
	<fieldset id="fldset">
	<h2>멤버<br />로그인</h2>
		<div class="col" id="col1">
			<label for="uid">아이디</label><input type="text" name="uid" id="uid" class="txt" value="chan135" />
		</div>
		<div class="col" id="col2">
			<label for="pwd">비밀번호</label><input type="password" name="pwd" id="pwd" class="txt" value="Kwang1" />
		</div>
		<div>
			<input type="submit" value="LOGIN" name="btn" class="btn">
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