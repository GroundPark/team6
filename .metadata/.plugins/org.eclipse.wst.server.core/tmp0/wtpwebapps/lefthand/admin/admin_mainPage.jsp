<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 이 모양 유지할것 -->
<body>
<%@ include file="../include/incAdmin.jsp" %>
<jsp:forward page="/schedule.bbs" />
<!--
로그인 하고 첫 화면에 일정관리를 보여줘야하는데 로그인에는 act가 없어서 데이터를 받아오기가 여의치않아서 곧바로 이동시키는것.
프론트의 index.jsp와 같은 기능이라 보면 됨.
-->
</body>
<!-- 이 모양 유지할것 -->
</html>