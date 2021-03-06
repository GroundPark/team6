<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");

AdminFundStatsInfo fstat = (AdminFundStatsInfo)request.getAttribute("fstat");

int s1ac = fstat.getS1ac();		int s1bc = fstat.getS1bc();			
int s2ac = fstat.getS2ac();		int s2bc = fstat.getS2bc();		int s2cc = fstat.getS2cc();

int allCount = s1ac + s1bc + s2ac + s2bc + s2cc;

double sRate = Math.round((double)s2cc / (double)allCount * 100);
double fRate = Math.round((double)(allCount - s2cc) / (double)allCount * 100);

int step2 = s2ac + s2bc + s2cc;
double joinStep2 = Math.round((double)step2 / (double)allCount * 100);
double faleStep2 = Math.round((double)(allCount - step2) / (double)allCount * 100);


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
	labels: ['성공', '실패'],
	datasets: [{
		label: '2차 진입 비율',
		backgroundColor: color(window.chartColors.green).alpha(0.5).rgbString(),
		borderColor: window.chartColors.blue,
		borderWidth: 1,
		data: [<%=joinStep2%>, <%=faleStep2%>]
	}, 
	{
		label: '도전펀딩 성공여부',
		backgroundColor: color(window.chartColors.red).alpha(0.5).rgbString(),
		borderColor: window.chartColors.red,
		borderWidth: 1,
		data: [<%=sRate%>, <%=fRate%>]
	}
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
			title:{ display:true, text:'도전 펀딩 성공 비율' }
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