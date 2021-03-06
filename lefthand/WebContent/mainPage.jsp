<!-- 
12.06 수정한것 
1. 펀딩, 도전펀딩 목록에서 '남은일자' 잘못 계산한거 올바르게 수정
2. 펀딩율 계산식 수정 (단, fi_rate가 계산된 값이 자동으로 입력되는게 아니라 리터럴값이 입력되어야 하는 문제가 있음)
 -->
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
ArrayList<ReviewInfo> reviewList =(ArrayList<ReviewInfo>)request.getAttribute("reviewList");


DecimalFormat formatter = new DecimalFormat("#,##0");

int cpage = 1, psize = 12; // 메인에 게시된 일반, 펀딩, 도전상품들을 클릭했을 때 이동하는 view.jsp에 가져 가야 할 페이징 조건(쿼리스트링에서 사용함)  

Calendar today = Calendar.getInstance();
int ye = today.get(Calendar.YEAR);	int mo = today.get(Calendar.MONTH) + 1;		int da = today.get(Calendar.DATE);
String now = ye + "-" + mo + "-" + da;


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/mainSlide.css" />
	<link rel="stylesheet" type="text/css" href="css/mainLayout.css" />
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
			<p id="best_title">BEST 상품</p>
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
	<% if(pdt.getPi_discount() != 0){ %>
	<del><%=formatter.format(pdt.getPi_price())%>원</del>&nbsp;&nbsp;&nbsp;
	<% } %>  
	<span id="pdtDP"><%=formatter.format((int)(pdt.getPi_price() * (1 - pdt.getPi_discount()))) %>원</span>
	</div>
	<!-- 예솔 파트 로직 -->
						</div>
					</a>
					<img src="img/heart_empty.png" class="heart" onclick="heartFlag(this);" /> 
				</div>				
<%
}
%>
			</div>
			<div id="vline"></div>
		</article>							<!-- Best상품 목록 종료 -->
		
		<article id="section_1_funding">	<!-- 실시간 HOT펀딩 목록 시작 -->
			<p id="funding_title">실시간 HOT 펀딩</p>
			<div class="funding_list">
<% for (int i = 0 ; i < fundingList.size(); i++) { 
	FundingInfo fund = fundingList.get(i);
	long deadline = DateDiff.diffOfDate(now, fund.getFi_edate().substring(0,10));		// 남은 일자를 계산하는 함수. main.DateDiff클래스
%>
				<div class="funding_pdt">
					<a href="fdg_view.fdg?fiidx=<%=fund.getFi_idx()%>&cpage=<%=cpage%>&psize=<%=psize%>">
						<img src="page/funding/img/<%=fund.getFi_img1()%>" width="250" height="210" />
						<div class="obj_content">
							<div class="obj_content_1row"><%= fund.getFi_name()%></div>
							<div class="obj_content_2row">
								<span id="fund_rate"><%=Math.round(fund.getFi_rate() * 100) %>%</span>&nbsp;&nbsp;

								<span id="fund_goal"><%= formatter.format(fund.getFi_goal())%>원</span>
								&nbsp;&nbsp;&nbsp;
								<%= deadline %>일 남음								
							</div>
						</div>
					</a>
					<img src="img/heart_empty.png" class="heart" onclick="heartFlag(this);" />
				</div>				
<%
}
%>
			<div id="hline"></div>
			</div>
		</article>							<!-- 실시간 HOT펀딩 목록 종료 -->
		
		<article id="section_1_challenge">	<!-- 도전펀딩 목록 시작 -->
			<p id="challenge_title">도전 펀딩!</p>
			<div class="challenge_list">
<% for (int i = 0 ; i < challengeList.size(); i++) { 
	ChallengeInfo chall = challengeList.get(i);
	long deadline = DateDiff.diffOfDate(now, chall.getCi_edate().substring(0,10));		// 남은 일자를 계산하는 함수. main.DateDiff클래스
%>
				<div class="funding_pdt">
					<a href="chal_view.chal?ciidx=<%=chall.getCi_idx()%>&cpage=<%=cpage%>">
<% if(!chall.getCi_img().equals("null")) { %>
					<img src="page/challenge/userimg/<%=chall.getCi_img()%>" width="250" height="210" />
<% } else { %>
					<img src="page/challenge/img/chal_info_default.png" width="250px" height="210" />
<% } %>
						<div class="obj_content">
							<div class="obj_content_1row"><%= chall.getCi_title()%></div>
							<div class="obj_content_2row">
								공감 ( <%= chall.getCi_good() %> / 200 )개</span>
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
				<p id="videoTitle">&quot;굳이 왼손잡이용을?&quot;</p>
				이라고 생각하신다면 여기 주목!!<br />
				이 영상을 보게 되는 즉시 장바구니에 물건을 담고 있는 <br />자기 자신을 발견하게 될 것입니다.<br /><br />
				
				나를 봐 내 작은 모습을<br />
				너는 언제든지 웃을 수 있니<br />
				너라도 날 보고 한번쯤<br />
				그냥 모른척해 줄 순 없겠니<br /><br />
				
				하지만 때론 세상이 뒤집어 진다고<br />
				나 같은 아이 한둘이 어지럽힌다고<br />
				모두 다 똑같은 손을 들어야 한다고<br />
				그런 눈으로 욕 하지마<br /><br />
				
				난 아무것도 망치지 않아 난 왼손잡이야<br /><br />
				패닉 - 왼손잡이 中<br />
				
				
			</div>
		</article>							<!-- 동영상 설명 영역 종료 -->
	</section>								<!-- 두번째 섹션. (Wrap)동영상 영역 종료-->	

<!-- ------------------------------------------------------------------------------------------------ -->	
	
	<section id="section_3">				<!-- 세번째 섹션. 후기 영역 시작 -->
		<p id="section_3_title">믿고 보는 생생 후기</p>
		<article id="section_3_review">		
<%
if (reviewList.size() > 0) {
	for (int i = 0 ; i < reviewList.size(); i ++) {
		ReviewInfo review = reviewList.get(i);
%>
			<div class="review_obj">
				<div class="review_top">
					ID:<span class="reviewer"><%=review.getMi_id()%></span><span class="reviewDate"><%=review.getRl_date()%></span>
				</div>
				<div class="review_score">
					<p style="WIDTH:<%=review.getRl_score() / 5.0 * 100 %>%;"></p>
				</div>
				<div class="review_body"><%= review.getRl_content() %></div>
				<div class="review_bottom"><%= review.getPi_name() %></div>
			</div>
<%
	}
}
%>			

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
				<span class="question">Q. 도전펀딩을 하게 된 계기가 있다면?</span><br /><br />
				<span class="answer">
				A. 이전까지는 왼손잡이로서 불편함을 감수하고 살아야 한다고 생각했습니다. 그런데 '왼손잡상점'를 통해 그 불편함을 인식하고 편하게 바꿀 수 있다는 생각이 들었습니다.
				그래서 일상생활 속에서 왼손잡이만이 느끼는 불편함을 찾고자 하였고, 그 결과 좋은 아이디어가 떠올라 도전펀딩을 하게 되었습니다.
				</span><br /><br />
				<span class="question">Q. 앞으로 도전할 회원들에게 한마디 부탁드립니다.</span><br /><br />
				<span class="answer">
				A. 내가 불편하다고 느낀다면 다른 사람들도 그렇게 느낄 것입니다. 나의 작은 아이디어 하나가 세상을 변화시킬 수 있다고 생각합니다.
				여러분들도 일상 속에서 느끼는 불편함을 생각에서 그치는 것이 아니라 이 '도전펀딩'을 통해 여러 사람들과 공감할 수 있기를 바랍니다. 
				그렇게 왼손잡이용 상품을 온라인에서만 구매하는 것이 아닌 우리 일상 속 어디에서나 볼 수 있기를 꿈꾸셨으면 좋겠습니다. 
				</span><br /><br />
			</p>
		</article>
	</section>								<!-- 네번째 섹션. 인터뷰 영역 종료 -->

<!-- ------------------------------------------------------------------------------------------------ -->
</main>
<button class="back-to-top"><span class="label">페이지 위로 가기</span></button>
<div id="mainClareSpace"></div>
<%@ include file="include/footer.jsp" %>
</body>
</html>