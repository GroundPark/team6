<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");

AdminPeriodStatsInfo pstat = (AdminPeriodStatsInfo)request.getAttribute("pstat");

int m1 = pstat.getM1();		int m2 = pstat.getM2();		int m3 = pstat.getM3();		int m4 = pstat.getM4();
int m5 = pstat.getM5();		int m6 = pstat.getM6();		int m7 = pstat.getM7();		int m8 = pstat.getM8();
int m9 = pstat.getM9();		int m10 = pstat.getM10();	int m11 = pstat.getM11();	int m12 = pstat.getM12();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
canvas {
-moz-user-select: none;
-webkit-user-select: none;
-ms-user-select: none;
}
</style>
<link rel="stylesheet" href="../css/reset.css" />
<link rel="stylesheet" href="../css/admin_base.css" />
<link rel="stylesheet" href="../css/admin_layout.css" />
<script src="../js/jquery-3.6.0.js"></script>
<script src="../js/Chart.min.js"></script>
<script src="../js/utils.js"></script>
<script>
var color = Chart.helpers.color;
var barChartData = {
	labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	datasets: [{
		label: '주문 수',
		backgroundColor: color(window.chartColors.red).alpha(0.5).rgbString(),
		borderColor: window.chartColors.red,
		borderWidth: 1,
		data: [<%=m1%>, <%=m2%>, <%=m3%>, <%=m4%>, <%=m5%>, <%=m6%>, <%=m7%>, <%=m8%>, <%=m9%>, <%=m10%>, <%=m11%>, <%=m12%> ] 
	}, 
/* -- 데이터 막대 추가
	, {
		label: '순이익2',
		backgroundColor: color(window.chartColors.green).alpha(0.5).rgbString(),
		borderColor: window.chartColors.blue,
		borderWidth: 1,
		data: [15, 20, 17, 13, 28, 22, 9]
	}
*/
	]
};

window.onload = function() {
	var ctx = document.getElementById('canvas').getContext('2d');
	window.myBar = new Chart(ctx, {
		type: 'bar',
		data: barChartData,
		options: {
			responsive: true,
			legend:{ position:'top' }, 
			title:{ display:true, text:'2021년 월별 주문 수' }
		}
	});
};
</script>
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>

<main>
	<article>
	    <section> 
			<div id="container" style="width: 75%;">
				<canvas id="canvas"></canvas>
			</div>
	    </section>
	</article>
</main>
</body>
</html>