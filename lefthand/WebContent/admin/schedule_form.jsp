<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");


String wtype = request.getParameter("wtype");
String ms_idx = request.getParameter("ms_idx");
ScheduleInfo si = (ScheduleInfo)request.getAttribute("si");

Calendar tmp = Calendar.getInstance();
tmp.set(si.getYear(), si.getMonth() - 1, si.getDay());
int max = tmp.getActualMaximum(Calendar.DATE); 		// 선택한 연월에 해당하는 마지막 일을 구함 // option 반복문에서 사용할거임

String msg = "등록";
if (wtype.equals("up")){
	msg = "수정";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/reset.css" />
<link rel="stylesheet" href="../css/admin_base.css" />
<link rel="stylesheet" href="../css/admin_layout.css" />
<link rel="stylesheet" href="../css/admin_schedule.css" /> 		<!-- 추가 -->
<script src="../js/jquery-3.6.0.js"></script>
<script src="../js/admin_schedule.js"></script>					<!-- 추가 -->
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>
<main>
	<article>
	    <section> 
	   		 
			<h2>일정 <%= msg %> 폼</h2>
			<form name="frmSchedule" action="schedule_proc.bbs" method="post">
			<input type="hidden" name="wtype" value="<%= wtype %>" />
			<input type="hidden" name="ms_idx" value="<%=ms_idx%>" />
			<input type="hidden" name="stime" value="" />
			<table width="600" cellpadding="5">
			<tr>
			<th width="15%">일시</th>
			<td width="*">
				<select name="y" onchange="resetday(this.value, this.form.m.value, this.form.d);")>
			<% for (int i = 2020 ; i <= (si.getcYear() + 10) ; i++) { %>
					<option value="<%=i %>" <% if (i == si.getYear()) { %>selected="selected"<% } %>><%=i %></option>
			<% } %>
				</select>년 
				<select name="m" onchange="resetday(this.form.y.value, this.value, this.form.d);">
			<% for (int i = 1 ; i <= 12 ; i++) { 
				String n = (i < 10 ? "0" + i : "" + i);
			%>
					<option value="<%=n %>" <% if (i == si.getMonth()) { %>selected="selected"<% } %>>
						<%= (i < 10) ? "0" + i : i %>
					</option>
			<% } %>
				</select>월
				<select name="d">
			<% for (int i = 1 ; i <= max ; i++) { 
				String n = (i < 10 ? "0" + i : "" + i);
			%>
					<option value="<%=n %>" <% if (i == si.getDay()) { %>selected="selected"<% } %>>
					 	<%= (i < 10) ? "0" + i : i %>
					 </option>
			<% } %>	
				</select>일
				<select name="h">
			<% for (int i = 0 ; i <= 23 ; i++) { 
				String n = (i < 10 ? "0" + i : "" + i);
			%>
					<option value="<%=n %>"><%= (i < 10) ? "0" + i : i %></option>
			<% } %>	
				</select>시
				<select name="n">
			<% for (int i = 0 ; i <= 59 ; i++) { 
				String n = (i < 10 ? "0" + i : "" + i);
			%>
					<option value="<%=n %>"><%= (i < 10) ? "0" + i : i %></option>
			<% } %>	
				</select>분 
			</td>
			</tr>
			<tr>
			<th>내용</th>
			<td><textarea name="content" rows="5" cols="60"></textarea></td>
			</tr>
			<tr><td colspan="2" align="center">
				<input type="button" value="일정"<%= msg %>" onclick="callProc();" />		<!-- stime을 만들어서 서브밋 시킴  -->
				<!-- 서버에서 할 일을 클라에서 시켜 효율적임 -->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="다시 입력" />
			</td></tr>
			</table>
			</form>
			
	    </section>
	</article>
</main>
</body>
</html>