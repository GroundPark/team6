<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
AdminInfo adminInfo = (AdminInfo)session.getAttribute("adminInfo");
if (adminInfo != null) {
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다.');");
	out.println("history.back();");
	out.println("</script>");
	out.close();	// 여기서 이 파일을 끝냄
}

request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body { background:#eee; }
#fldset { position: absolute; top:0; bottom:0; left:0; right:0; width:800px; height:300px; margin:auto; border:0; background:#fff; 
		border-right:3px solid #c1c1c1; border-bottom:3px solid #c1c1c1; }
h2 { font-size:30px; text-align:left; vertical-align:middle; padding-left:100px; padding-top:80px; font-weight:normal; letter-spacing :0.2em; }
.col { margin-left:280px; padding:5px 0 0 5px; }
#col1 { margin-top:-105px; }
#col2 { margin-top:0px; }
label { font-size:13px; }
.txt { width:200px; height:30px; font-size:13px; border:1px solid black; margin-left:10px; }
#uid { margin-left:23px; }
.btn { position:absolute; top:115px; left:595px; width:100px; height:73px; border:0; border-right:2px solid #c1c1c1; border-bottom:2px solid #c1c1c1; background:#eee; }
#idsave { margin-left:370px; margin-top:10px; }
</style>
</head>
<body>
<form name="loginFrm" action="../adminLogin" method="post">
	<fieldset id="fldset">
		<h2>관리자<br />로그인</h2>
		<div class="col" id="col1">
			<label for="uid">ADMIN ID</label><input type="text" name="uid" id="uid" class="txt" value="admin1" />
		</div>
		<div class="col" id="col2">
			<label for="pwd">PASSWORD&nbsp;</label><input type="password" name="pwd" id="pwd" class="txt" value="1111" />
		</div>
		<div>
			<input type="submit" value="LOGIN" name="btn" class="btn">
		</div>
		<div>
			<input type="checkbox" name="idsave" value="idsave" id="idsave" checked="checked" /><label for="idsave">아이디 저장</label>
		</div>
	</fieldset>
</form>
</body>
</html>