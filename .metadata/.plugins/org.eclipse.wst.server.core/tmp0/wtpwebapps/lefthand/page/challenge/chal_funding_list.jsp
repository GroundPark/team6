<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/chal_funding_list.css" />
	<script src="js/jquery-3.6.0.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="js/mainSlide.js"></script>
	<script src="js/mainPage_scroll.js"></script>
	
</head>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<script>
function searchSort(url) {
	location.href = url
}
</script>

<%
request.setCharacterEncoding("utf-8");

// PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");	
ChallengePageInfo challengePageInfo = (ChallengePageInfo)request.getAttribute("challengePageInfo");	
ArrayList<ChallengeList> challengeList = (ArrayList<ChallengeList>)request.getAttribute("challengeList");
//ChallengeList challenge = (ChallengeList)request.getAttribute("challenge");		

String schargs = "", args = "";

// 헤더쪽 검색 쿼리스트링 
// if(challengePageInfo.getKeyword() != null && !challengePageInfo.getKeyword().equals(""))	
//	schargs += "&keyword=" + challengePageInfo.getKeyword();

if (challengePageInfo.getSchtype() == null || challengePageInfo.getKeyword() == null) {
	challengePageInfo.setSchtype("");	challengePageInfo.setKeyword("");
 	// 검색 관련 정보가 null인 경우 빈 문자열로 변경함; 이거 안하면 텍스트박스에 문자열 null찍혀서 굉장히 구려보임
 }else if(!challengePageInfo.getKeyword().equals("") && !challengePageInfo.getSchtype().equals("")){	// 빈문자일 경우 일그냥 안할거
 	// schargs = "&schtype=" + pageInfo.getSchtype() + "&keyword=" + pageInfo.getKeyword();	
	 schargs += "&keyword=" + challengePageInfo.getKeyword() + "&schtype=" + challengePageInfo.getSchtype();
 }


args = "?cpage=" + challengePageInfo.getCpage() + schargs; 

// 콤보박스 검색 쿼리스트링

// 콤보박스 정렬 쿼리스트링


// String chalsort = (String)request.getAttribute("chalsort");
// String chalsearch = (String)request.getAttribute("chalsearch");
//만들고보니 담아서 안줘서 request로 판별함


%>
<!-- ------------------------------------------------------------------------------------------------ -->
<div class="chal_funding_contents" >
<div class="btn_chal_funding_write" onclick="location.href='chal_in_form.chal';" style="cursor:pointer;" >도전펀딩 등록</div>
<br />
<br />
<br />
<br />

<div class="challenge_sort" >
<table>
<tr>
<td>
<ul id="cmb_challenge_classify" style="padding-right:10px;">
		<li>
		<form name="chal_frm1" method="get">
		<select name="classify" onchange="this.form.submit();">
			<option value="chal_all" <% if (challengePageInfo.getClassify().equals("chal_all")) { %>selected = "selected"<% } %>>전체</option>
			<option value="chal_step1" <% if (challengePageInfo.getClassify().equals("chal_step1")) { %>selected = "selected"<% } %>>1차 진행중</option> 
			<option value="chal_step2" <% if (challengePageInfo.getClassify().equals("chal_step2")) { %>selected = "selected"<% } %>>2차 진행중</option>
			<option value="chal_stc" <% if (challengePageInfo.getClassify().equals("chal_stc")) { %>selected = "selected"<% } %>>확정</option>
			<option value="chal_stb" <% if (challengePageInfo.getClassify().equals("chal_stb")) { %>selected = "selected"<% } %>>마감</option>			
		</select>
		</form>
		</li>
</ul>
</td>
<td>
<ul id="cmb_challenge_sort">
		<li>
		<form name="chal_frm2" method="get">
		<select name="sort" onchange="this.form.submit();">
			<option value="chal_idxd" <% if (challengePageInfo.getSort().equals("chal_idxd")) { %>selected = "selected"<% } %>>최신순</option>	
			<option value="chal_goodd" <% if (challengePageInfo.getSort().equals("chal_goodd")) { %>selected = "selected"<% } %>>인기순</option> 
			<option value="chal_edated" <% if (challengePageInfo.getSort().equals("chal_edated")) { %>selected = "selected"<% } %>>마감일순</option>
		</select>
		</form>
		</li>
</ul>
</td>
</tr>
</table>
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
<!-- 이미지가 null이면 기본이미지, 아니면 만들어진 thumnail 이미지가 나옴 -->
<!-- 만약 시간되면 할지도... 보류 -->
<div class="chal" id="chal">
	<%=lnk %>
<% if(!ci.getCi_img().equals("null")) { %>
	<img src="page/challenge/userimg/<%=ci.getCi_thum_img() %>" style="width:350px; height:350px; padding-bottom:25px;" />
<% } else { %>
	<img src="page/challenge/img/chal_info_default.png" style="width:350px; height:350px; padding-bottom:25px;" />
<% } %>
<br />
	<!-- 각 경우에 따라 딱지라던가 마감확정 등을 붙임 -->
	<% if( status.equals("a") && step == 1 ){ %>
	<div class="chal_step1"><img src="page/challenge/img/step1.png" style="width:75px; height:75px; " /></div>
	<% } else if (status.equals("a") && step == 2){ %>
	<div class="chal_step2"><img src="page/challenge/img/step2.png" style="width:75px; height:75px; " /></div>
	<% } else if( status.equals("b") && step == 1 ){ %>
	<div class="chal_step1"><img src="page/challenge/img/step1.png" style="width:75px; height:75px; " /></div>
	<div class="chal_close"> 마 감 </div>
	<% } else if( status.equals("b") && step == 2 ){ %>
	<div class="chal_step2"><img src="page/challenge/img/step2.png" style="width:75px; height:75px; " /></div>
	<div class="chal_close"> 마 감 </div>
	<% } else if (status.equals("c") && step == 2)  { %>
	<div class="chal_step2"><img src="page/challenge/img/step2.png" style="width:75px; height:75px; " /></div>
	<div class="chal_ok"> 확 정 </div>
	<% } %>
	<div style="text-align:center; font-size:1.3em; "><a href="#"><%=ci.getCi_title() %></a></div>
	<div class="chal_period"> &nbsp;<%=ci.getCi_sdate().substring(0 , 10) %>&nbsp;~&nbsp;<%=ci.getCi_edate().substring(0 , 10) %> &nbsp; </div>
	
	<div class="chal_like" style="font-size:18px;" >
	<img src="img/heart_full.png" class="heart" style="width:21px; height:18px;" /> <%=ci.getCi_good() %> </div>
	
	
	
</div>
<%
		if(i % 4 == 3)	out.println("</div>");
		
		if(i == challengeList.size() - 1 && i % 4 != 3){	
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
if (challengeList.size() > 0){
// 상품 검색결과가 있으면 페이지 번호를 출력
	out.println("<div class='page_wrapper'>");
	out.println("<p style='font-size:1.25em; width:100%;' align='center' font-color:black>");

	args = "?sort=" + challengePageInfo.getSort() + "&psize=" + challengePageInfo.getPsize();
	
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



</div>

<!-- ------------------------------------------------------------------------------------------------ -->
</main>
<%@ include file="../../include/footer.jsp" %>
</body>
</html>
