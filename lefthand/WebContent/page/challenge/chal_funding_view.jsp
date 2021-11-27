<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="challenge.vo.*" %>
<%
request.setCharacterEncoding("utf-8");
ChallengePageInfo challengePageInfo = (ChallengePageInfo)request.getAttribute("challengePageInfo");		
// ChallengeInfo challenge = (ChallengeInfo)request.getAttribute("challengeInfo");
ChallengeList challenge = (ChallengeList)request.getAttribute("challenge");		// 게시글 정보가 들어있는 인스턴스
if(challenge == null){
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}
ChallengeInfo challengeDetail = (ChallengeInfo)request.getAttribute("challengeDetail");		// 게시글 정보가 들어있는 인스턴스

//String args = "?cpage=" + challengePageInfo.getCpage();		
// if(challengepageInfo.getKeyword() != null && !challengepageInfo.getKeyword().equals("")){
// 	args += "&schtype=" + challengepageInfo.getSchtype() + "&keyword=" + challengepageInfo.getKeyword();
// }	// 검색 조건이 있을 경우에만 쿼리스트링으로 만들어 줌

// String kind = "단순공지";
// if (notice.getNl_kind().equals("b"))			kind="이벤트";
// else if (notice.getNl_kind().equals("c"))		kind="상품관련";
// else if (notice.getNl_kind().equals("d"))		kind="보도자료";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/footer.css" />
<link rel="stylesheet" type="text/css" href="css/chal_funding_detail.css" />
<link rel="stylesheet" type="text/css" href="css/mainLayout.css" />

<style>
body {
	position:relative;
	padding-bottom:80px;
}
</style>
<script src="js/jquery-3.6.0.js"></script>
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

function reg_reply(){
	alert("버튼 테스트");
}
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
					<p class="period_area">[<%=challenge.getCi_step() %>] <%=challenge.getCi_sdate() %> ~ <%=challenge.getCi_edate() %></p>
					<p class="title_area"><%=challenge.getCi_title() %></p>
					<p class="sym_cnt"><%=challenge.getMi_id() %></p>
				</div>
				<button class="sym_button"><img src="img/heart_empty.png" width="70" height="60" /><br /><br /><p>공감( 50 )</p></button>
			</div>
		</section>
		<!-- 도전펀딩 제목 영역 종료  -->
		<!-- 도전펀딩  설명 영역 시작 -->
		<section class="chg_info">
			<div class="info_img_area"><img src="page/challenge/userimg/<%=challenge.getCi_img() %>" width="500" height="500" /><p><%=challenge.getCi_content() %></div>
		</section>
		<!-- 도전펀딩  설명 영역 종료 -->
		<!-- 도전펀딩 채팅 영역 시작 -->
		<section class="chg_chat">
			<div class="chg_chat_area">&nbsp;&nbsp; 댓글 ( 2 )</div>
			<div class="outerBox">
				<div class="innerBox">
					<div class="circle"><img src="img/circle_1.png" width="100" height="100" /></div>
					<div id="init">A</div>
					<div id="txtBox1">	<!-- 왼쪽 댓글 -->
						<p><img src="img/chat_topL.png" width="450" /></p>
						<div id="txt1">
							<p>회원아이디 2021-11-23 17:56</p><br />
							<span class="chat_txt">정말 좋은 생각인 거 같아요!</span>
						</div>
						<p><img src="img/chat_bottomL.png" width="450" /></p>
					</div>
				</div>
				<div class="innerBox2">
					<div id="txtBox2">	<!-- 왼쪽 댓글 -->
						<p><img src="img/chat_topR.png" width="450" /></p>
						<div id="txt2">
							<p>회원아이디 2021-11-23 20:08</p><br />
							<span class="chat_txt">감사합니다 <br /> :)</span>
						</div>
						<p><img src="img/chat_bottomR.png" width="450" /></p>
					</div>
					<div class="circle"><img src="img/circle_2.png" width="100" height="100" /></div>
					<div id="init2">B</div>
				</div><br />
				<div id="writeBox">
					<textarea id="write" name="write" cols="77" rows="6"></textarea>
					<input type="button" value="등록" id="btn" onclick="reg_reply();" /><br />
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