<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%

AdminScheduleInfo si = (AdminScheduleInfo)request.getAttribute("si");
// 달력 출력을 위한 정보(검색 연월, 현재 연월일)들을 저장하고 있는 인스턴스

ArrayList<AdminSchedule> scheduleList = (ArrayList<AdminSchedule>)request.getAttribute("scheduleList");
// 검색 연월에 해당하는 일정들의 목록을 저장하고 있는 ArrayList		

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
<style>
#sch table, #sch th, #sch td {border-bottom:1px solid black; text-align:center;}
#sch {border-collapse:collapse;}
#sch th {height:30px; background:#585858; color:white; font-weight:bold;}
#sch td {height:80px; text-align:left; font-weight:bold;}
.txtRed {color:red;}
.txtBlue {color:blue;}
#today {background:#efefef; font-weight:bold;}
#schManage { width:700px; margin-left:0; border:0px solid black;}

/* div로 일정 보여주는 부분 */
.scheduleBox {
	width:400px; height:150px; background:#FFCC99;	padding:10px;
	overflow:auto;
	position:absolute; top:150px; left:150px;  
	display:none;
}
</style>
<script>
function setToday() {
	document.frmDate.y.value = "<%=si.getcYear() %>";
	document.frmDate.m.value = "<%=si.getcMonth() %>";
	document.frmDate.submit();
	 
}

function showSchedule(box) {
	var obj = document.getElementById(box);
	obj.style.display = "block";
}
function hideSchedule(box) {
	var obj = document.getElementById(box);
	obj.style.display = "none";
}

function goDel(as_idx) {
	if (confirm("정말 삭제하시겠습니까?")) {
		location.href="schedule_proc.sche?wtype=del&as_idx=" + as_idx;
	}
}
</script>
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>
<style>hr { display:block; }</style>				<!-- reset.css에서 hr을 none으로 해놨는데 일정보여주는 div에서 hr이 필요함 -->
<main>
	<article>
	    <section>
			<h2 id="schManage">일정 관리</h2>
			<form name="frmDate" action="admin_mainPage.jsp" method="post">
			<p style="width:700px;" align="center">
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
			</p><br /><br />
			</form>
			<table width="700" cellpadding="5" id="sch">
			<tr>
			<th width="100">일</th><th width="100">월</th><th width="100">화</th><th width="100">수</th>
			<th width="100">목</th><th width="100">금</th><th width="100">토</th>
			</tr>
			<%
			if (sWeek != 1) {
				out.println("<tr>");
				for (int i = 1 ; i < sWeek ; i++)	out.println("<td>&nbsp;</td>");
			}	// 1일의 위치가 처음이 아니면 1일의 위치 만큼 빈 칸으로 채움
			
			String lnk = "schedule_form.sche";
			String args = "";
			for (int i = 1, n = sWeek ; i <= eDay ; i++, n++) {
			// i : 날짜의 일(day) 부분을 담당할 변수로 날짜 출력에 사용됨 / n : 요일번호(1~7)로 일주일이 지나면 다음 줄로 내리기 위한 용도
				String txtCls = "", txtId = "";			// 여기서 선언 한 이유는 값이 필요없는 경우가 있어 초기화가 지속적으로 이루어져야 하기에
				// 해당 날짜 td에 적용 할 클래스와 아이디를 저장 할 변수 
				
				if (n % 7 == 1) {	// 현재 요일번호가 일요일(1)이면 새로운 줄 시작
					out.println("<tr>");
					txtCls =" class=\"txtRed\"";
				}
				if (n % 7 == 0) 	txtCls =" class=\"txtBlue\"";		// 현재 요일번호가 토요일(7)이면
				if (si.getYear() == si.getcYear() && si.getMonth() == si.getcMonth() && i == si.getcDay()) 	txtId = " id=\"today\"";
					
				String schImg = "", closeImg = "";		// 여기서 선언 한 이유는 값이 없는 경우가 있어 초기화가 지속적으로 이루어져야 하기에	
														// 스케쥴과 닫기 이미지를 링크과 함께 저장 할 변수로. 일정이 있을 경우에만 사용됨
														
				if (scheduleList.size() > 0) {			// 검색 연월에 해당하는 일정이 있을경우
					out.println("<div class='scheduleBox' id='box" + i + "'>");
					
					for(int j = 0 ; j < scheduleList.size() ; j++) {
						AdminSchedule as = scheduleList.get(j);
						String stime = si.getYear() + "-" + (si.getMonth() < 10 ? "0" + si.getMonth() : si.getMonth()) + 
								"-" + (i < 10 ? "0" + i : i);
						if (stime.equals(as.getAs_stime().substring(0, 10))) {				// 현재 출력할 날짜에 해당하는 일정이 있을경우
							args = "?wtype=up&y=" + si.getYear() + "&m=" + si.getMonth() + "&d=" + i + "&as_idx=" + as.getAs_idx();
							// 일정 수정시 필요한 쿼리스트링 생성
							schImg = "<a href=\"javascript:showSchedule('box" + i + "');\">";			// a태그 안에서 js쓰는 방법!!
							schImg += "<img src='../img/schedule_icon.png' width='20' style='margin-left:10px' /></a>";
							closeImg = "<a href=\"javascript:hideSchedule('box" + i + "');\">";			// a태그 안에서 js쓰는 방법!!
							closeImg += "<img src='../img/close.png' width='20' /></a><br /><br />";
							
							out.println(stime + " 일정<span style='margin-right:240px;'></span>" + closeImg);
							out.println("일시 : " + as.getAs_stime().substring(11) + "&nbsp;&nbsp;");
							out.println("<input type=\"button\" value=\"수정\" onclick=\"location.href='" + lnk + args + "';\" />");
							out.println("<input type=\"button\" value=\"삭제\" onclick=\"goDel(" + as.getAs_idx() + ");\" />");
							out.println("<br /><br /> " + as.getAs_content().replace("\r\n", "<br />"));
							out.println("<br /><br /><br /> 등록일 : " + as.getAs_date() + "<hr />");
						}
					}
				
					out.println("</div>");																
				}
				
				
				args = "?wtype=in&y=" + si.getYear() + "&m=" + si.getMonth() + "&d=" + i;
				out.println("<td valign='top'" + txtCls + txtId + "><a href='" +lnk + args + "'>" + i + "</a>");	// valign=top 이거 기억하기~!~! 글자가 상단배치 됨 
				out.println(schImg + "</td>");
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
	   		
	    </section>
	</article>
</main>

</body>
</html>