<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="funding.vo.*" %>

<%@ page import="java.time.LocalDate" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.temporal.ChronoUnit" %>

<%
request.setCharacterEncoding("utf-8");

ArrayList<FundingInfo> fdgList = (ArrayList<FundingInfo>)request.getAttribute("fdgList");
FdgPageInfo fdgPageInfo = (FdgPageInfo)request.getAttribute("fdgPageInfo");

String args ="";

args = "?cpage=" + fdgPageInfo.getCpage();

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/mainSlide.css" />
	<link rel="stylesheet" type="text/css" href="css/mainLayout.css" />
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="js/jquery-3.6.0.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="js/mainSlide.js"></script>
	<script src="js/mainPage_scroll.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
	
<style>

.fdg_contents {
	width:1200px;  margin: 0 auto;
	overflow:hidden;
	height:100%;	
	
	padding-bottom:300px;
	position:relative;
}
.fdg { margin:20px; border:1px black solid; float:left; font-size:1.4em; }

.page_wrapper {
	position:absolute;
	left:0%; bottom:9%;
	transform:translate(0%, -9%); 
	width: 1200px; height: 60px; 
	padding-top:50px;
	padding-bottom:50px;

}




.progress {
	width:325px;
}

</style>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<!-- ------------------------------------------------------------------------------------------------ -->
<div class="fdg_contents" >
<br />
<br />
<p align="right" style="padding:15px 75px 15px; "> 여기다 콤보박스 넣으셈 </p>
<%
	if(fdgList.size() > 0) {
		   for(int i = 0 ; i < fdgList.size() ; i++) {
			   FundingInfo fi = fdgList.get(i);
		        String lnk = null;

		        String status = fi.getFi_status();

		        // a:펀딩중        b:펀딩실패        c:펀딩성공
		        // 각각의 경우에 따라 출력
		        if(fi.getFi_status().equals("a")) {
		        	lnk = "<a href=\"fdg_view.fdg" + args + "&fiidx=" + fi.getFi_idx() + "&sort=" + fdgPageInfo.getSort() +
		        			"&psize=" + fdgPageInfo.getPsize() + "\">";
		        } else if (fi.getFi_status().equals("b")) {
		        	lnk = "<a href=\"javascript:alert('펀딩실패된 상품입니다.');\">";
		        } else {
		        	lnk = "<a href=\"javascript:alert('펀딩확정된 상품입니다.');\">";
		        }
				
		        /////
		        // 11-27 박지상 수정 : N일 남음 구하기
		        ///// 
		        
		        LocalDate sDate = LocalDate.now();
		        LocalDate eDate = LocalDate.parse(fi.getFi_edate());
		    
		        long calDay = ChronoUnit.DAYS.between(sDate, eDate);
				// System.out.println(calDay);
		
		        if(fdgPageInfo.getPsize() == 12) {
		        // 한 페이지에 12개의 상품 목록을 보여줄 경우(한 줄에 3개씩 보여줌)
		    if(i % 3 == 0)	out.println("<div align='center'>");
%>



<div class="fdg">
	<%=lnk %><img src="page/funding/img/<%=fi.getFi_img1() %>" style="width:350px; height:350px; padding-bottom:25px;" /></a>
	<div style="text-align:center;"><a href="#"><%=fi.getFi_name() %></a></div>
	<table width="100%">
		<tr><td style="text-align:center"><b><%=String.format("%.0f", fi.getFi_rate() * 100 ) %> %</b></td>
		<td style="text-align:center"><%=fi.getFi_price() %> 원</td>
		<td style="text-align:center"><%=calDay %>일남음</td></tr>
			<div class="progress">
			<% if(fi.getFi_rate() * 100 < 100) { %>			
			    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" 
			    	style="width:<%=fi.getFi_rate() * 100 %>%">
			    </div>
			<% } else { %>
				<div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" 
			    	style="width:<%=fi.getFi_rate() * 100 %>%">
			    </div>
			<% } %>
			</div>
	</table>
</div>


<%
			if(i%4 == 3) 	out.println("</div>");
			}
		}
	} else {
	out.println("<div>검색된 펀딩이 없습니다.</div>");
}

%>

<!-- 예제용 데이터  -->
<div class="fdg">
	<a href="fdg_view.fdg?cpage=1&fiidx=2&sort=idd&psize=12"><img src="page/funding/img/fd102_info_1.jpg" style="width:350px; height:350px; padding-bottom:25px;" /></a>
	<div style="text-align:center;"><a href="#">왼손용 테스트</a></div>
	<table width="100%">
		<tr><td style="text-align:center">10 %</td>
		<td style="text-align:center">300 원</td>
		<td style="text-align:center"> 12일남음</td></tr>
			<div class="progress">
			    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" 
			    	style="width:30%">
			    </div>
			</div>
	</table>
</div>

<!-- 예제용 데이터 끝 -->

</div>

<%
if (fdgList.size() > 0){
// 상품 검색결과가 있으면 페이지 번호를 출력
	out.println("<div class='page_wrapper'>");
	out.println("<p style='font-size:1.25em; width:100%;' align='center'>");

	args = "?sort=" + fdgPageInfo.getSort() + "&psize=" + fdgPageInfo.getPsize();
	
		if(fdgPageInfo.getCpage() == 1){				
			out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
		}else{
			out.print("<a href='fdg_list.fdg" + args + "&cpage=1'>[&lt;&lt;]</a>&nbsp;&nbsp;");
			out.println("<a href='fdg_list.fdg" + args + "&cpage=" + (fdgPageInfo.getCpage() - 1) + "'>[&lt;]</a>&nbsp;&nbsp;");
		}
		
		for(int i = 1, j = fdgPageInfo.getSpage(); i <= fdgPageInfo.getBsize() && j <= fdgPageInfo.getEpage() ; i++, j++){
		// i : 루프 돌릴 횟수 검사하는 용도의 변수, j : 페이지 번호 출력용 변수
			if(fdgPageInfo.getCpage() == j){
				out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
			}else{
				out.print("&nbsp;<a href='fdg_list.fdg" + args + "&cpage=" +j + "'>" + j + "</a>&nbsp;");
			}
		}
		
		
		if(fdgPageInfo.getCpage() == fdgPageInfo.getPcnt()){
			out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
		}else{
			out.print("&nbsp;&nbsp;<a href='fdg_list.fdg" + args + "&cpage=" + (fdgPageInfo.getCpage() + 1 ) + "'>[&gt;]</a>");
			out.println("&nbsp;&nbsp;<a href='fdg_list.fdg" +args + "&cpage=" + (fdgPageInfo.getPcnt()) + "'>[&gt;&gt;]</a>");
		}

	out.println("</p>");
	out.println("</div>");
}
%>
</div>
<!-- ------------------------------------------------------------------------------------------------ -->
</main>
<%@ include file="../../include/footer.jsp" %>
</body>
</html>