<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");

AdminMemStatsInfo mstat = (AdminMemStatsInfo)request.getAttribute("mstat");

int aCount = mstat.getP_acount() + mstat.getF_acount();		
int lCount = mstat.getP_lcount() + mstat.getF_lcount();
int rCount = mstat.getP_rcount() + mstat.getF_rcount();		
int bCount = mstat.getP_bcount() + mstat.getF_bcount();

double lRate = Math.floor((double)lCount / (double)aCount * 100);
double rRate = Math.floor((double)rCount / (double)aCount * 100);
double bRate = Math.floor((double)bCount / (double)aCount * 100);



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
<script src="../js/admin.js"></script>
<script src="../js/Chart.min.js"></script>
<script src="../js/utils.js"></script>
<script>
var config = {
	type: 'doughnut',
	data: {
		datasets: [{
			data: [<%= lRate %>, <%= rRate%>, <%= bRate %>], 
			backgroundColor: [
				window.chartColors.red, 
				window.chartColors.orange, 
				window.chartColors.yellow
			],
			label: '점유율'
		}],
		labels: ["왼손잡이", "오른손잡이", "양손잡이"]
	},
	options: {
		responsive: true, legend: { position: 'top', }, 
		title: { display: true, text: '주손 대비 구매 비율' },
		animation: { animateScale: true, animateRotate: true }
	}
};

window.onload = function() {
	var ctx = document.getElementById('chart-area').getContext('2d');
	window.myDoughnut = new Chart(ctx, config);
};

</script>
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>

<main>
	<article>
	    <section>    	
			<div id="canvas-holder" style="width:70%">
			<canvas id="chart-area"></canvas>
			</div> 
	    </section>
	</article>
</main>
</body>
</html>