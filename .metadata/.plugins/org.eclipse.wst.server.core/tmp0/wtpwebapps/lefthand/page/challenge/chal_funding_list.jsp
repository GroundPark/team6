<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="challenge.vo.*" %>

<%
request.setCharacterEncoding("utf-8");

ChallengePageInfo challengePageInfo = (ChallengePageInfo)request.getAttribute("challengePageInfo");	
ArrayList<ChallengeList> challengeList = (ArrayList<ChallengeList>)request.getAttribute("challengeList");
//ChallengeList challenge = (ChallengeList)request.getAttribute("challenge");		

String args ="", schargs = "";
// 검색관련 쿼리스트링 
// if(challengePageInfo.getKeyword() != null && !challengePageInfo.getKeyword().equals(""))	
//	schargs += "&keyword=" + challengePageInfo.getKeyword();

 args = "?cpage=" + challengePageInfo.getCpage() + schargs;
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
	<script src="js/jquery-3.6.0.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="js/mainSlide.js"></script>
	<script src="js/mainPage_scroll.js"></script>
</head>
<style>

.chal_funding_contents {
	width:1200px;  margin: 0 auto;

	overflow:hidden;
	height:100%;	
	
	padding-bottom:300px;
	position:relative;
}

.chal_period { 
	text-align:center; padding-bottom:45px; font-size:1.1em; 
}

.chal_like { 
	padding:5px; 
	position:absolute;	 
	top:93%; left:68%;
	width:100px; height:20px;
	background-color:#98ddde;
}

.chal_ok { 
	position:absolute;	
	top:50%; left:50%;
	transform:translate(-50%, -75%); 
	width:100px; height:50px; background-color:rgba(158, 158, 158, 0.5);  
	z-index: 0;
	text-align:center;
	font-size:1.5em;
	padding:50px;
}

.chal_close{
	position:absolute;	
	top:50%; left:50%;
	transform:translate(-50%, -75%); 
	width:100px; height:50px; background-color:rgba(158, 158, 158, 0.5);  
	z-index: 0;
	text-align:center;
	font-size:1.5em;
	padding:50px;
}


.chal{
	border:1px black solid; position:relative; margin:20px; 
	float:left; font-size:1.2em;
}

.challenge_sort {
	text-align:right; padding-right:50px;
}

.page_wrapper {
	position:absolute;
	left:0%; bottom:20%;
	transform:translate(0%, -20%); 
	
	width: 1200px; height: 60px; 
	padding-top:50px;
	padding-bottom:50px;
	
}

.btn_chal_funding_write {
	position:absolute;
	width:250px; height:50px;
	background-color:#dee2e6;
	text-align:center;
	
	line-height:250%;
	
	font-size:1.5em;
	
	top:30px; left:20px;
}

.chal_step1{
	padding:5px; 
	position:absolute;	 
	top:1%; left:1%;
	width:75px; height:75px;
}

.chal_step2{
	padding:5px; 
	position:absolute;	 
	top:1%; left:1%;
	width:75px; height:175px;
}

.maindiv{
	height: 3000px;	width:1200px; margin: 0 auto;
	background-color:#d3d3d3;
}	

.pdt_contents {
	width:1200px;  margin: 0 auto;

	overflow:hidden;
	height:100%;	
	
	padding-bottom:300px;
	position:relative;
}


.pdt { margin:20px; border:1px black solid; float:left; font-size:1.4em; }

.pdt_price { text-decoration:line-through; color:gray; font-size:0.9em; }

.pdt_real_price { color:red; font-size:1.2em; }

.page_wrapper {
	position:absolute;
	left:0%; bottom:4%;

	width: 1200px; height: 60px; 
	padding-top:50px;
	padding-bottom:50px;
}



body {
	position:relative;
	padding-bottom:0px;
}
</style>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<!-- ------------------------------------------------------------------------------------------------ -->
<div class="chal_funding_contents">
<div class="btn_chal_funding_write" OnClick="location.href=location.href;" style="cursor:pointer;" >도전펀딩 등록</div>
<br />
<br />
<br />
<br />
<div class="challenge_sort">
<ul id="cmb_challenge_sort">
		<li><select>
			<option value="최신순">최신순</option>
			<option value="인기순">인기순</option> 
			<option value="마감임박순">마감임박순</option>
			<option value="1차">1차</option>
			<option value="2차">2차</option>
			<option value="확정">확정</option>
		</select></li>
	</ul>
</div>
<%
	if(challengeList.size() > 0){
	for(int i=0;i<challengeList.size(); i++){
		ChallengeList ci = challengeList.get(i);
		String lnk = null;
		
		int step = ci.getCi_step(); 
		String status = ci.getCi_status();
		
		// a:진행		b:마감		c:펀딩확정
		// 각각의 경우에 따라 출력. 진행아닌 경우 그냥 보게해도 되는데 만들기 귀찮아서 아예 못들어가게 막음
		if(ci.getCi_status().equals("a")){		
	lnk = "<a href=\"chal_view.chal" + args + "&ciidx=" + ci.getCi_idx() + "&sort=" + challengePageInfo.getSort() +
			"&psize=" +challengePageInfo.getPsize() + "\">";
		}else if (ci.getCi_status().equals("b")){		
	lnk = "<a href=\"javascript:alert('마감된 상품입니다.');\">";
		}else{
	lnk = "<a href=\"javascript:alert('확정된 상품입니다.');\">";		
		}
		
		if(challengePageInfo.getPsize() == 12) {
		// 한 페이지에 12개의 상품 목록을 보여줄 경우(한 줄에 3	개씩 보여줌)
	if(i%3 == 0)		out.println("<div align='center'>");
%>
<div class="chal">
	<%=lnk %><img src="page/challenge/userimg/<%=ci.getCi_thum_img() %>" style="width:350px; height:350px; padding-bottom:25px;" /><br />
	<% if( status.equals("a") && step == 1 ){ %>
	<div class="chal_step1"><img src="page/challenge/img/step1.png" style="width:75px; height:75px; " /></div>
	<% } else if (status.equals("a") && step == 2){ %>
	<div class="chal_step2"><img src="page/challenge/img/step2.png" style="width:75px; height:75px; " /></div>
	<% } else if (status.equals("c")) { %>
	<div class="chal_ok"> 확 정 </div>
	<% } else { %>
	<div class="chal_close"> 마 감 </div>
	<% } %>
	<div style="text-align:center; font-size:1.3em; "><a href="#"><%=ci.getCi_title() %></a></div>
	<div class="chal_period"> &nbsp;<%=ci.getCi_sdate().substring(0 , 10) %>&nbsp;~&nbsp;<%=ci.getCi_edate() %>-null-null &nbsp; </div>
	<div class="chal_like"> ♥  <%=ci.getCi_good() %>  </div>
</div>

<%
			if(i%4 == 3) 	out.println("</div>");
		}
	}

}else{
	out.println("<div>검색된 상품이 없습니다.</div>");
}
%>

<!-- 예제 데이터 시작 -->


<div class="chal">
	<a href="#"><img src="page/challenge/img/chal_info_default.png" style="width:350px; height:350px; padding-bottom:25px;" /></a>
	<div class="chal_step1"><img src="page/challenge/img/step1.png" style="width:75px; height:75px; " /></div>
	<div style="text-align:center; font-size:1.3em; "><a href="#">* 도전 펀딩 예제 데이터 (이미지 null)</a></div>
	<div class="chal_period"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>
	<div class="chal_like"> ♥  0  </div>
</div>

<div class="chal">
	<a href="#"><img src="page/challenge/userimg/thum_chal_info_3.jpg" style="width:350px; height:350px; padding-bottom:25px;" /></a>
	<div class="chal_step1"><img src="page/challenge/img/step1.png" style="width:75px; height:75px; " /></div>
	<div style="text-align:center; font-size:1.3em; "><a href="#">* 도전 펀딩 예제 데이터 (1차)</a></div>
	<div class="chal_period"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>
	<div class="chal_like"> ♥  30  </div>
</div>

<div class="chal">
	<a href="#"><img src="page/challenge/userimg/thum_chal_info_4.jpg" style="width:350px; height:350px; padding-bottom:25px;" /></a>
	<div class="chal_step2"><img src="page/challenge/img/step2.png" style="width:75px; height:75px; " /></div>
	<div style="text-align:center; font-size:1.3em; "><a href="#">* 도전 펀딩 예제 데이터 (2차)</a></div>
	<div class="chal_period"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>
	<div class="chal_like"> ♥  50  </div>
</div>

<div class="chal">
	<a href="#"><img src="page/challenge/userimg/thum_chal_info_5.jpg" style="width:350px; height:350px; padding-bottom:25px;" /></a>
	<div class="chal_ok"> 확 정 </div>
	<div style="text-align:center; font-size:1.3em; "><a href="#">* 도전 펀딩 예제 데이터 (확정)</a></div>
	<div class="chal_period"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>
	<div class="chal_like"> ♥  200  </div>
</div>

<div class="chal">
	<a href="#"><img src="page/challenge/userimg/thum_chal_info_2.jpg" style="width:350px; height:350px; padding-bottom:25px;" /></a>
	<div class="chal_close"> 마 감 </div>
	<div style="text-align:center; font-size:1.3em; "><a href="#">* 도전 펀딩 예제 데이터 (마감)</a></div>
	<div class="chal_period"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>
	<div class="chal_like"> ♥  200  </div>
</div>

<!-- 예제 데이터 끝 -->

</div>

<%
if (challengeList.size() > 0){
// 상품 검색결과가 있으면 페이지 번호를 출력
	out.println("<div class='page_wrapper'>");
	out.println("<p style='font-size:1.25em; width:100%;' align='center'>");

	args = "?sort=" + challengePageInfo.getSort() + "&psize=" + challengePageInfo.getPsize() + schargs;
	
		if(challengePageInfo.getCpage() == 1){				
			out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
		}else{
			out.print("<a href='chal_list.chal" + args + "&cpage=1'>[&lt;&lt;]</a>&nbsp;&nbsp;");
			out.println("<a href='chal_list.chal" + args + "&cpage=" + (challengePageInfo.getCpage() - 1) + "'>[&lt;]</a>&nbsp;&nbsp;");
		}
		
		for(int i=1, j=challengePageInfo.getSpage(); i<= challengePageInfo.getBsize() && j <= challengePageInfo.getEpage(); i++, j++){
		// i : 루프 돌릴 횟수 검사하는 용도의 변수, j : 페이지 번호 출력용 변수
			if(challengePageInfo.getCpage() == j){
				out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
			}else{
				out.print("&nbsp;<a href='chal_list.chal" +args + "&cpage=" +j + "'>" + j + "</a>&nbsp;");
			}
		}
		
		
		if(challengePageInfo.getCpage() == challengePageInfo.getPcnt()){
			out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
		}else{
			out.print("&nbsp;&nbsp;<a href='chal_list.chal" + args + "&cpage=" + (challengePageInfo.getCpage() + 1 ) + "'>[&gt;]</a>");
			out.println("&nbsp;&nbsp;<a href='chal_list.chal" +args + "&cpage=" + (challengePageInfo.getPcnt()) + "'>[&gt;&gt;]</a>");
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
