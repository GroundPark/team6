<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%@page import="java.text.DecimalFormat"%>
<%
request.setCharacterEncoding("utf-8");
ArrayList<ProductHistory> productHistory = (ArrayList<ProductHistory>)request.getAttribute("productHistory");

//숫자에 콤마 찍기위한 인스턴스
DecimalFormat decFormat = new DecimalFormat("###,###");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
h2 { font-size:20px; }
#revList th { border-bottom:3px black double; font-size:12px; }
#revList td { border-bottom:1px black solid; }
</style>
</head>
<body>
<h2 align="center">상품 가격 변동</h2>
<table width="400px;" cellpadding="5" cellspacing="0" style="text-align:center;" id="revList" >
<th width="15%">번호</th><th width="20%">기존가격</th><th width="20%">변경가격</th>
<th width="*">가격변경일자</th><th width="15%">관리자</th>
<%
int num = productHistory.size();
if(productHistory.size() > 0) {
	for(int i = 0; i < productHistory.size(); i++){
		ProductHistory ph = productHistory.get(i);
%>
<tr>
<td><%=num %></td><td><%=decFormat.format(ph.getPh_oldprice()) %></td><td><%=decFormat.format(ph.getPh_newprice()) %></td>
<td><%=ph.getPh_date().substring(0, 10) %></td><td><%=ph.getAi_idx() %></td>
</tr>
<% 
num--;
 	} 
} else {
	out.println("<tr><td colspan='8' align='center'>가격변동 내역이 없습니다.</td></tr>");
}

%>

</table>
</body>
</html>