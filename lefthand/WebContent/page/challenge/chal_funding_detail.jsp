<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../../css/base.css" />
<link rel="stylesheet" type="text/css" href="../../css/footer.css" />
<link rel="stylesheet" type="text/css" href="../../css/chal_funding_detail.css" />
<script src="../../js/jquery-3.6.0.js"></script>
<script>
$(document).ready(function() {
    $('#write').on('keyup', function() {
        $('#write_cnt').html("("+$(this).val().length+" / 300)");
 
        if($(this).val().length > 300) {
            $(this).val($(this).val().substring(0, 300));
            $('#write_cnt').html("(300 / 300)");
        }
    });   
});
</script>
</head>
<body>
<%@ include file="../../include/header.jsp" %>
<!-- 도전펀딩 영역 시작  -->
<article class="chalfunding_detail">
	<div class="chalfunding_detail_inner">
		<!-- 도전펀딩 제목 영역 시작  -->
		<section class="chg_top">
			<div class="chg_top_area">
				<div class="chg_titl_area">
					<p class="period_area">[1차] 2021.11.30 ~ 2021.12.28</p>
					<p class="title_area">숟가락과 왼손잡이가 만나면 어떻게 될까요?</p>
					<p class="sym_cnt">memberID</p>
					<p class="period_area">2021.11.30 12:13</p>
				</div>
				<button class="sym_button"><img src="../../img/heart_empty.png" width="70" height="60" /><br /><br /><p>공감( 50 )</p></button>
			</div>
		</section>
		<!-- 도전펀딩 제목 영역 종료  -->
		<!-- 도전펀딩  설명 영역 시작 -->
		<section class="chg_info">
			<div class="info_img_area"><img src="a.jpg" width="500" height="500" /><p>글쓴이가 올리는 이미지로 최대 크기 제한 필요</p></div>
			<div class="info_desc_area">다이슨이 전기차를 개발할 당시, VR 기술이 적용된 분야는 다양한데요. 크게는 가상 시뮬레이션 기술을 활용한 주행 경험이 있습니다. 
			다이슨에서는 완전한 가상 시뮬레이션 기술을 통해 엔지니어가 직접 운전석에 앉아 핸들을 잡고 주행을 하고, 어깨 너머로 뒤를 본다거나 차량 내부와 외부의 주변 환경을 관찰하며 주차까지 
			해 볼 수 있도록 구현했다고 합니다. 제임스 다이슨은 "처음 가상 현실에서 차를 운전해 보았을 때, 헤어 드라이어나 무선 청소기 프로토타입을 처음 사용했을 때와 같은 느낌을 받았다. 
			체험하면서 곧바로 어떤 점이 개선되어야 할지 보였다" 라고 전했습니다. 시뮬레이션을 할 때는 정확하고 뚜렷하게 보이는 것이 중요한데, 시간이 지나면서 VR의 시각적 해상도가 점차 개선되어 
			차량 내 인터페이스를 더욱 집중적으로 연구하고 분석할 수 있게 되었다고 합니다.</div>
		</section>
		<!-- 도전펀딩  설명 영역 종료 -->
		<!-- 도전펀딩 채팅 영역 시작 -->
		<section class="chg_chat">
			<div class="chg_chat_area">&nbsp;&nbsp;댓글 ( 2 )</div>
			<div class="outerBox">
				<div class="innerBox">
					<div class="circle"><img src="../../img/circle_1.png" width="100" height="100" /></div>
					<div id="init">A</div>
					<div id="txtBox1">	<!-- 왼쪽 댓글 -->
						<p><img src="../../img/chat_topL.png" width="450" /></p>
						<div id="txt1">
							<p>회원아이디 2021-11-23 17:56</p><br />
							<span class="chat_txt">정말 좋은 생각인 거 같아요!</span>
						</div>
						<p><img src="../../img/chat_bottomL.png" width="450" /></p>
					</div>
				</div>
				<div class="innerBox2">
					<div id="txtBox2">	<!-- 왼쪽 댓글 -->
						<p><img src="../../img/chat_topR.png" width="450" /></p>
						<div id="txt2">
							<p>회원아이디 2021-11-23 20:08</p><br />
							<span class="chat_txt">감사합니다 <br /> :)</span>
						</div>
						<p><img src="../../img/chat_bottomR.png" width="450" /></p>
					</div>
					<div class="circle"><img src="../../img/circle_2.png" width="100" height="100" /></div>
					<div id="init2">B</div>
				</div><br />
				<div id="writeBox">
					<textarea id="write" name="write" cols="77" rows="6"></textarea>
					<input type="button" value="등록" id="btn" /><br />
				</div>
					<div id="write_cnt">(0 / 300)</div>
			</div>
		</section>
		<!-- 도전펀딩 채팅 영역 종료 -->
	</div>
</article>
<%@ include file="../../include/footer.jsp" %>
</body>
</html>
