<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="main.DateDiff" %>
<%@ page import="vo.*" %>
<%@ page import="java.text.DecimalFormat" %>   <!-- 돈 표기 -->

<%
request.setCharacterEncoding("utf-8");

ArrayList<ProductInfo> productList = (ArrayList<ProductInfo>)request.getAttribute("productList");
ArrayList<ChallengeInfo> challengeList = (ArrayList<ChallengeInfo>)request.getAttribute("challengeList");
ArrayList<FundingInfo> fundingList = (ArrayList<FundingInfo>)request.getAttribute("fundingList");

DecimalFormat formatter = new DecimalFormat("#,##0");

int cpage = 1, psize = 12; // 메인에 게시된 일반, 펀딩, 도전상품들을 클릭했을 때 이동하는 view.jsp에 가져 가야 할 페이징 조건(쿼리스트링에서 사용함)  

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- UTF-8로 할것 -->
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="css/mainSlide.css" />
	<link rel="stylesheet" type="text/css" href="css/mainLayout.css" />
	<link rel="stylesheet" type="text/css" href="css/base.css" />

	<script src="js/jquery-3.6.0.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="js/mainSlide.js"></script>
	<script src="js/mainPage_scroll.js"></script>
	<script src="js/heartFlag.js"></script>
	<script src="js/search.js"></script>
</head>
<body>
<header>
<%@ include file="include/header.jsp" %>
</header>
<!-- ------------------------------------------------------------------------------------------------ -->
<article id="mainSlide">					<!-- 메인 슬라이드 시작 -->
	<div class="slideshow">
		<div class="slideshow-slides">
			<a href="#" class="slide" id="slide-1"><img src="img/slide-1.png" width="1200" height="465" /></a>
			<a href="#" class="slide" id="slide-2"><img src="img/slide-2.png" width="1200" height="465" /></a>
			<a href="#" class="slide" id="slide-3"><img src="img/slide-3.png" width="1200" height="465" /></a>
			<a href="#" class="slide" id="slide-4"><img src="img/slide-4.png" width="1200" height="465" /></a>
		</div>
		<div class="slideshow-nav">
			<a href="#" class="prev">Prev</a>
			<a href="#" class="next">Next</a>
		</div>
		<div class="slideshow-indicator"></div>
	</div>
</article>									<!-- 메인 슬라이드 종료 -->
<!-- ------------------------------------------------------------------------------------------------ -->

<main>
	<section id="section_1">				<!-- 첫번째 섹션. (Wrap)상품 목록 시작 -->
		<article id="section_1_best">		<!-- Best상품 목록 시작 -->
			<p id="best_title">Best 상품</p>
			<div class="best_list">
<% for (int i = 0 ; i < productList.size(); i++) { 
	ProductInfo pdt = productList.get(i);
%>
				<div <% if(i < 2) { %> class="best_pdt" <% }else{ %> class="best_pdt_2row" <% } %> >
					<a href="pdt_view.pdt?piid=<%=pdt.getPi_id()%>&cpage=<%=cpage%>&psize=<%=psize%>">
						<img src="page/product/img/<%=pdt.getPi_img1()%>" width="250" height="210" />
						<div class="obj_content">
							<div class="obj_content_1row"><%= pdt.getPi_name()%></div>
							<div>
								<del><%= pdt.getPi_price() %>원</del>&nbsp;&nbsp;&nbsp;
								<span id="pdtDP"><%=formatter.format((int)(pdt.getPi_price() * (1 - pdt.getPi_discount()))) %>원</span>
							</div>
						</div>
					</a>
					<img src="img/heart_empty.png" class="heart" onclick="heartFlag(this);" /> 
				</div>				
<%
}
%>
			</div>
		</article>							<!-- Best상품 목록 종료 -->
	
		<article id="section_1_funding">	<!-- 실시간 HOT펀딩 목록 시작 -->
			<p id="funding_title">실시간 HOT 펀딩</p>
			<div class="funding_list">
<% for (int i = 0 ; i < fundingList.size(); i++) { 
	FundingInfo fund = fundingList.get(i);
	long deadline = DateDiff.diffOfDate(fund.getFi_sdate(), fund.getFi_edate());		// 남은 일자를 계산하는 함수. main.DateDiff클래스
%>
				<div class="funding_pdt">
					<a href="fdg_view.fdg?fiidx=<%=fund.getFi_idx()%>&cpage=<%=cpage%>&psize=<%=psize%>">
						<img src="page/funding/img/<%=fund.getFi_img1()%>" width="250" height="210" />
						<div class="obj_content">
							<div class="obj_content_1row"><%= fund.getFi_name()%></div>
							<div class="obj_content_2row">
								<span id="fund_rate"><%= (int)fund.getFi_rate() %>%</span>&nbsp;&nbsp;
								<span id="fund_goal"><%= formatter.format(fund.getFi_goal())%>원</span>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<%= deadline %>일 남음								
							</div>
						</div>
					</a>
					<img src="img/heart_empty.png" class="heart" onclick="heartFlag(this);" />
				</div>				
<%
}
%>
			</div>
		</article>							<!-- 실시간 HOT펀딩 목록 종료 -->
		
		
		
		
		
		
		
		<article id="section_1_challenge">	<!-- 도전펀딩 목록 시작 -->
			<p id="challenge_title">도전 펀딩!</p>
			<div class="challenge_list">
<% for (int i = 0 ; i < challengeList.size(); i++) { 
	ChallengeInfo chall = challengeList.get(i);
	long deadline = DateDiff.diffOfDate(chall.getCi_sdate(), chall.getCi_edate());		// 남은 일자를 계산하는 함수. main.DateDiff클래스
%>
				<div class="funding_pdt">
					<a href="chal_view.chal?ciidx=<%=chall.getCi_idx()%>&cpage=<%=cpage%>">
						<% if(!chall.getCi_img().equals("null")) { %>
	<img src="page/challenge/userimg/<%=chall.getCi_img()%>" width="250" height="210" />
<% } else { %>
	<img src="page/challenge/img/chal_info_default.png" width="250px" height="210" />
<% } %>
<%-- 도전 펀딩에 있는 로직을 써야 이미지가 제대로 나옴--%>
						<div class="obj_content">
							<div class="obj_content_1row"><%= chall.getCi_title()%></div>
							<div class="obj_content_2row">
								공감 ( <%= chall.getCi_good() %> / 50 )개</span>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<%= deadline %>일 남음									
							</div>
						</div>
					</a>
					<img src="img/sympathy_emptyG.png" class="sympathy"  onclick="sympathyFlag(this);" />
				</div>				
<%
}
%>
			</div>	
		</article>							<!-- 도전펀딩 목록 종료 -->
	</section>								<!-- 첫번째 섹션. (Wrap)상품 목록 종료 -->
	
<!-- ------------------------------------------------------------------------------------------------ -->	

	<section id="section_2">				<!-- 두번째 섹션. (Wrap)동영상 영역 시작 -->
		<article id="video">				<!-- 동영상이 들어갈 영역 시작 -->
		<iframe width="800" height="400" src="https://www.youtube.com/embed/QxhStu7pp44" 
 			title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; 
			encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</article>							<!-- 동영상이 들어갈 영역 종료 -->	
		<article id="videoExplain">			<!-- 동영상 설명 영역 시작 -->
			<div id="explain">
				<br /><br />
				Left-handed products designed for use in your left hand!<br /><br />
				We have been providing specially designed left-handed items to make life a bit easier for lefthanders since 1967.<br />
				Us left handers are pretty adaptable and can find ways to make standard right handed tools work for us,<br />
				but why should left-handed people have to do that and put up with the resulting discomfort and poor performance?<br />
				<br /><br />
				Treat yourself to the properly designed left handed versions of your everyday implements and feel the difference<br />
				for yourself when you use them with you left hand. Or do a fellow left-hander a favour with a left handed gift<br />
				they will really appreciate.
			</div>
		</article>							<!-- 동영상 설명 영역 종료 -->
	</section>								<!-- 두번째 섹션. (Wrap)동영상 영역 종료-->	

<!-- ------------------------------------------------------------------------------------------------ -->	
<!-- 후기 뽑아오기는 나중에 무현씨가 작업하거나 안하는걸로 -->
	<section id="section_3">				<!-- 세번째 섹션. 후기 영역 시작 -->
		<p id="section_3_title">믿고 보는 생생 후기</p>
		<article id="section_3_review">		
			<div class="review_obj">
				<div class="review_top">ID:<span class="reviewer">ymh194</span><span class="reviewDate">2021.11.23</span></div>
				<div class="review_score">★★★★☆</div>
				<div class="review_body">아주 만족합니다! 손에 잘 맞아요</div>
				<div class="review_bottom">왼손잡이용 가위</div>
			</div>
			<div class="review_obj">
				<div class="review_top">ID:<span class="reviewer">lmj111</span><span class="reviewDate">2021.11.23</span></div>
				<div class="review_score">★★★★☆</div>
				<div class="review_body">잘 써집니다</div>
				<div class="review_bottom">왼손잡이용 연필</div>
			</div>
			<div class="review_obj">
				<div class="review_top">ID:<span class="reviewer">lys222</span><span class="reviewDate">2021.11.23</span></div>
				<div class="review_score">★★★★☆</div>
				<div class="review_body">쓸만해요</div>
				<div class="review_bottom">왼손잡이용 칼</div>
			</div>
			<div class="review_obj">
				<div class="review_top">ID:<span class="reviewer">ljh333</span><span class="reviewDate">2021.11.23</span></div>
				<div class="review_score">★★★★★</div>
				<div class="review_body">신기합니다</div>
				<div class="review_bottom">왼손잡이용 마우스</div>
			</div>

		</article>	
	</section>								<!-- 세번째 섹션. 후기 영역 종료 -->
	
<!-- ------------------------------------------------------------------------------------------------ -->	
	
	<section id="section_4">		 		<!-- 네번째 섹션. 인터뷰 영역 시작 -->
		<p id="section_4_title">성공 펀딩 인터뷰!</p>
		<article id="section_4_interview">
			<div id="interview_img">
				<img src="img/interview.png" width="250" height="190" alt="크기 : 250x190" />
			</div>
			<p id="interview_content">
				<br /><br /><br /><br />
				평소 불편했던 사항들에 대해 작은 아이디어를 냈을 뿐인데 좋은 결과로 돌아와서 너무 좋습니다.
			</p>
		</article>
	</section>								<!-- 네번째 섹션. 인터뷰 영역 종료 -->

<!-- ------------------------------------------------------------------------------------------------ -->
<%
// 확인용 입니다 (박지상)
//세션 이름 검사 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=hmw53&logNo=60187803922

	String s_name= ""; 
	String s_value= "";
	
	
	Enumeration enum_01 = session.getAttributeNames(); 
	int l=0;
	
	while(enum_01.hasMoreElements()){ 
		l++;
		
		s_name= enum_01.nextElement().toString(); 
		s_value= session.getAttribute(s_name).toString(); 
		
		System.out.println("SESSION NAME[ " + s_name +" ] SESSION VALUE [ " + s_value + " ]");

	}

%>
</main>
<button class="back-to-top"><span class="label">페이지 위로 가기</span></button>
<div id="mainClareSpace"></div>
<%@ include file="include/footer.jsp" %>
</body>
</html>