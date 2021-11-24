<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include시 글자가 깨지는것을 위의 설정 변경으로 해결함. -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
			<a href="#" class="slide" id="slide-4"><img src="img/slide-4.jpg" width="1200" height="465" /></a>
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
				<div class="best_pdt">
					<a href="#"><img src="img/상품사진1.jpg" width="250" height="210" alt="크기 : 250x210" /></a>
					<a href="#"><p class="best_pdt_content">왼손용 가위	 5000원</p></a>
				</div>
				<div class="best_pdt">
					<a href="#"><img src="img/상품사진2.jpg" width="250" height="210" alt="크기 : 250x210" /></a>
					<a href="#"><p class="best_pdt_content">왼손용 마우스 25000원</p></a>
				</div>
			</div>
			<div class="best_list">
				<div class="best_pdt">
					<a href="#"><img src="img/상품사진3.jpg" width="250" height="210" alt="크기 : 250x210" /></a>
					<a href="#"><p class="best_pdt_content">왼손용 칼 2000원</p></a>
				</div>
				<div class="best_pdt">
					<a href="#"><img src="img/상품사진4.jpg" width="250" height="210" alt="크기 : 250x210" /></a>
					<a href="#"><p class="best_pdt_content">왼손용 볼펜	 5000원</p></a>
				</div>
			</div>
		</article>							<!-- Best상품 목록 종료 -->
	
		<article id="section_1_funding">	<!-- 실시간 HOT펀딩 목록 시작 -->
			<p id="funding_title">실시간 HOT 펀딩</p>
			<div class="funding_list">
				<div class="funding_pdt">
					<a href="#"><img src="img/펀딩사진1.jpg" width="250" height="210" alt="크기 : 250x210" /></a>
					<a href="#"><p class="funding_pdt_content">펀딩이름</p></a>
				</div>
				<div class="funding_pdt">
					<a href="#"><img src="img/펀딩사진2.jpg" width="250" height="210" alt="크기 : 250x210" /></a>
					<a href="#"><p class="funding_pdt_content">펀딩이름</p></a>
				</div>
			</div>
		</article>							<!-- 실시간 HOT펀딩 목록 종료 -->
		
		<article id="section_1_challenge">	<!-- 도전펀딩 목록 시작 -->
			<p id="challenge_title">도전 펀딩!</p>
			<div class="challenge_list">
				<div class="challenge_pdt">
					<a href="#"><img src="img/도전펀딩사진1.jpg" width="250" height="210" alt="크기 : 250x210" /></a>
					<a href="#"><p class="challenge_pdt_content">도전펀딩이름</p></a>
				</div>
				<div class="challenge_pdt">
					<a href="#"><img src="img/도전펀딩사진2.jpg" width="250" height="210" alt="크기 : 250x210" /></a>
					<a href="#"><p class="challenge_pdt_content">도전펀딩이름</p></a>
				</div>
			</div>	
		</article>							<!-- 도전펀딩 목록 종료 -->
	</section>								<!-- 첫번째 섹션. (Wrap)상품 목록 종료 -->
	
<!-- ------------------------------------------------------------------------------------------------ -->	

	<section id="section_2">				<!-- 두번째 섹션. (Wrap)동영상 영역 시작 -->
		<article id="video">				<!-- 동영상이 들어갈 영역 시작 -->
<!--		<span>동영상을 보려면 이 span 삭제하고 주석 풀면 됨. 동영상 너무 크나?</span>     -->
	<iframe width="800" height="400" src="https://www.youtube.com/embed/QxhStu7pp44" 
 			title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; 
			encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</article>							<!-- 동영상이 들어갈 영역 종료 -->	
		<article id="videoExplain">			<!-- 동영상 설명 영역 시작 -->
			<p id="explain">
				아주 
				유용함에
				틀림
				없습니다.
			</p>
		</article>							<!-- 동영상 설명 영역 종료 -->
	</section>								<!-- 두번째 섹션. (Wrap)동영상 영역 종료-->	

<!-- ------------------------------------------------------------------------------------------------ -->	
	
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
				<img src="img/넣을사진.jsp" width="250" height="190" alt="크기 : 250x190" />
			</div>
			<p id="interview_content">
				평소 불편했던 사항들에 대해 작은 아이디어를 냈을 뿐인데 좋은 결과로 돌아와서 너무 좋습니다.
			</p>
		</article>
	</section>								<!-- 네번째 섹션. 인터뷰 영역 종료 -->

<!-- ------------------------------------------------------------------------------------------------ -->
</main>
<button class="back-to-top"><span class="label">페이지 위로 가기</span></button>
<%@ include file="include/footer.jsp" %>
</body>
</html>