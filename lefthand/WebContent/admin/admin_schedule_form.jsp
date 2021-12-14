<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");


String wtype = request.getParameter("wtype");
String as_idx = request.getParameter("as_idx");
AdminScheduleInfo si = (AdminScheduleInfo)request.getAttribute("si");

Calendar tmp = Calendar.getInstance();
tmp.set(si.getYear(), si.getMonth() - 1, si.getDay());
int max = tmp.getActualMaximum(Calendar.DATE); 		// 선택한 연월에 해당하는 마지막 일을 구함 // option 반복문에서 사용할거임


String msg = "등록";
String hh = "", nn = "", content = ""; 

if (wtype.equals("up")){
	msg = "수정";
	AdminSchedule as = (AdminSchedule)request.getAttribute("as");		// 수정일때만 만들어지므로
	hh = as.getAs_stime().substring(11,13);								// 일정의 시간 중 시(hour)부분만 추출
	nn = as.getAs_stime().substring(14);								// 일정의 시간 중 분(minute)부분만 추출
	content = as.getAs_content();										// 일정의 내용 추출
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/date_change.js"></script>
<script>
function callProc() {
	var frm = document.frmSchedule;
	var y = frm.y.value;	var m = frm.m.value;	var d = frm.d.value;	var h = frm.h.value;	var n = frm.n.value;

	frm.stime.value = y + "-" + m  + "-" + d  + " " + h + ":" + n;
	frm.submit();
}

</script>
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>

<main>
	<article>
	    <section>
			<h2>일정 <%= msg %> 폼</h2>
			<form name="frmSchedule" action="schedule_proc.sche" method="post">
			<input type="hidden" name="wtype" value="<%= wtype %>" />
			<input type="hidden" name="as_idx" value="<%=as_idx%>" />
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
					<option value="<%=n %>" <% if (hh.equals(n)) { %>selected="selected"<% } %>><%= (i < 10) ? "0" + i : i %></option>
			<% } %>	
				</select>시
				<select name="n">
			<% for (int i = 0 ; i <= 59 ; i++) { 
				String n = (i < 10 ? "0" + i : "" + i);
			%>
					<option value="<%=n %>"<% if (nn.equals(n)) { %>selected="selected"<% } %>><%= (i < 10) ? "0" + i : i %></option>
			<% } %>	
				</select>분 
			</td>
			</tr>
			<tr>
			<th>내용</th>
			<td><textarea name="content" rows="5" cols="60"><%= content %></textarea></td>
			</tr>
			<tr><td colspan="2" align="center">
				<input type="button" value="일정 <%=msg%>" onclick="callProc();" />		<!-- stime을 만들어서 서브밋 시킴  -->
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