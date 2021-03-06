<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>

<%@ page import="java.time.LocalDate" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="java.text.DecimalFormat" %> 
<%
request.setCharacterEncoding("utf-8");

ArrayList<FundingInfo> fdgList = (ArrayList<FundingInfo>)request.getAttribute("fdgList");
FundingInfo fdg = new FundingInfo();
FdgPageInfo fdgPageInfo = (FdgPageInfo)request.getAttribute("fdgPageInfo");

String args ="";
DecimalFormat formatter = new DecimalFormat("#,##0");
args = "?cpage=" + fdgPageInfo.getCpage();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/funding_list.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="js/jquery-3.6.0.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="js/mainSlide.js"></script>
	<script src="js/mainPage_scroll.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>

<script>
function fundingarray(url) {
	location.href = url
}
</script>
<!-- ------------------------------------------------------------------------------------------------ -->
<div class="fdg_contents" >
<br />
<br />
<ul class="fundingsearch">
	<li>
		<select onchange="fundingarray(this.value)"> <!-- 전체(기본), 인기순, 최신순, 마감임박순으로 정렬 가능 -->
			<option value="">전체</option>
			<option value="fdg_list.fdg<%=args %>&sort=rated">인기순</option>
			<option value="fdg_list.fdg<%=args %>&sort=sdated">최신순</option>
			<option value="fdg_list.fdg<%=args %>&sort=edatea">마감임박순</option>
		</select>
	</li>
</ul>
<%
	if(fdgList.size() > 0) {
		   for(int i = 0 ; i < fdgList.size() ; i++) {
			   FundingInfo fi = fdgList.get(i);
		        String lnk = null;

		        String status = fi.getFi_status();

		        // a:펀딩중        b:펀딩성공        c:펀딩실패
		        // 각각의 경우에 따라 출력
		        if(!fi.getFi_status().equals("c")) {
		        	lnk = "<a href=\"fdg_view.fdg" + args + "&fiidx=" + fi.getFi_idx() + "&sort=" + fdgPageInfo.getSort() + "&psize=" + fdgPageInfo.getPsize() + "\">";
		        } else {
		        	lnk = "<a href=\"javascript:alert('펀딩실패된 상품입니다.');\">";
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
		<td style="text-align:center; font-size:95%" > <%=formatter.format(fi.getFi_total()) %> 원</td>
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
if(i % 4 == 3)   out.println("</div>");

if(i == fdgList.size() - 1 && i % 4 != 3){   
   // 현재 출력하는 데이터가 pdtList의 마지막 데이터이면서 3칸을 모두 채우지 못했을 경우
   out.println("</div>");
}
}
}

}else{
out.println("<div>검색된 상품이 없습니다.</div>");
}
%>
<%
if (fdgList.size() > 0){
// 상품 검색결과가 있으면 페이지 번호를 출력
	out.println("<div class='page_wrapper'>");
	out.println("<p style='font-size:1.25em; width:100%;' align='center' font-color:black>");

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


</div>
<!-- ------------------------------------------------------------------------------------------------ -->
</main>
<%@ include file="../../include/footer.jsp" %>
</body>
</html>