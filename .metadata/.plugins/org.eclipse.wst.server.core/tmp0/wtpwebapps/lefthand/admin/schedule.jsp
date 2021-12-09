<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");

ScheduleInfo si = (ScheduleInfo)request.getAttribute("si");

Calendar sdate = Calendar.getInstance();
sdate.set(si.getYear(), si.getMonth() - 1, 1);		// 달력 시작일 지정
Calendar edate = Calendar.getInstance();
edate.set(si.getYear(), si.getMonth(), 1);			// 달력 종료일로 다음달 1일로 지정
edate.add(Calendar.DATE, -1);						// 다음달 1일에서 하루를 뺀 날짜로 시작월의 말일을 지정
int sWeek = sdate.get(Calendar.DAY_OF_WEEK);		// 시작일의 요일 번호이자 1일의 시작 위치
int eDay = edate.get(Calendar.DATE);				// 말일
int eWeek = edate.get(Calendar.DAY_OF_WEEK);		// 말일의 요일 번호
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
	  		<div id="dd">
				<h2>일정 관리</h2>
				<form name="frmDate" method="post">
				<p style="width:910px;" align="center" id="ymd" >
					<select name="y"  onchange="this.form.submit();">
				<% for (int i = 2020 ; i <= (si.getcYear() + 10) ; i++) { %>
						<option value="<%=i %>" <% if (i == si.getYear()) { %>selected="selected"<% } %>><%=i %></option>
				<% } %>
					</select>년 
					<select name="m" onchange="this.form.submit();">
				<% for (int i = 1 ; i <= 12 ; i++) { %>
						<option value="<%=i %>" <% if (i == si.getMonth()) { %>selected="selected"<% } %>><%=i %></option>
				<% } %>
					</select>월 
					<input type="button" value="오늘 날짜" onclick="setToday()"/>
				</p>
				</form>
				<table width="910" cellpadding="5" id="sch">
				<tr>
				<th width="130">일</th><th width="130">월</th><th width="130">화</th><th width="130">수</th>
				<th width="130">목</th><th width="130">금</th><th width="130">토</th>
				</tr>
				<%
				if (sWeek != 1) {
					out.println("<tr>");
					for (int i = 1 ; i < sWeek ; i++)	out.println("<td>&nbsp;</td>");
				}	// 1일의 위치가 처음이 아니면 1일의 위치 만큼 빈 칸으로 채움
				
				String lnk = "schedule_form.bbs";
				String args = "";
				for (int i = 1, n = sWeek ; i <= eDay ; i++, n++) {
				// i : 날짜의 일(day) 부분을 담당할 변수로 날짜 출력에 사용됨 / n : 요일번호(1~7)로 일주일이 지나면 다음 줄로 내리기 위한 용도
					String txtCls = "", txtId = "";		
					// 해당 날짜 td에 적용 할 클래스와 아이디를 저장 할 변수 
					
					if (n % 7 == 1) {	// 현재 요일번호가 일요일(1)이면 새로운 줄 시작
						out.println("<tr>");
						txtCls =" class=\"txtRed\"";
					}
					if (n % 7 == 0) 	txtCls =" class=\"txtBlue\"";
					if (si.getYear() == si.getcYear() && si.getMonth() == si.getcMonth() && i == si.getcDay()) 	txtId = " id=\"today\"";
						
				
					args = "?wtype=in&y=" + si.getYear() + "&m=" + si.getMonth() + "&d=" + i;
					out.println("<td valign='top'" + txtCls + txtId + "><a href='" + lnk + args + "'>" + i + "</a></td>");	// valign=top 이거 기억하기~!~! 글자가 상단배치 됨 
					if (n % 7 == 0)	{ 
						out.println("</tr>");	// 현재 요일번호가 토요일(7)이면 다음 줄로 내림
					}
					else if (i == eDay && n % 7 != 0) {
					// 마지막 일(day)을 출력했으나 토요일이 아닐경우
						for (int j = n % 7 ; j < 7 ; j++) {
							out.println("<td>&nbsp;</td>");
						}
						out.println("</tr>");
					}
				}
				%>
				</table>   
			</div>	
	    </section>
	</article>
</main>
</body>
</html>