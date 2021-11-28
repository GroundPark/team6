<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="challenge.vo.*" %>
<%@ page import="java.util.*" %>
<%
request.setCharacterEncoding("utf-8");
ChallengePageInfo challengePageInfo = (ChallengePageInfo)request.getAttribute("challengePageInfo");	// 페이징 정보
// ChallengeInfo challenge = (ChallengeInfo)request.getAttribute("challengeInfo");
// ChallengeList challenge = (ChallengeList)request.getAttribute("challenge");		// 게시글 정보가 들어있는 인스턴스

ChallengeInfo challengeDetail = (ChallengeInfo)request.getAttribute("challengeDetail");		// 게시글 정보가 들어있는 인스턴스
if(challengeDetail == null){
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}
ArrayList<ChallengeReplyList> challengeReplyList = (ArrayList<ChallengeReplyList>)request.getAttribute("challengeReplyList"); // 댓글 정보

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
/* 댓글 300자 제한 */
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
	// 댓글을 update하고 이 페이지를 새로고침하여 표시하는게 쉬운가? 좀 걸려도 ajax같은 걸 써서 해야하는가? 보류...
	alert("버튼 테스트");
	location.reload();
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
					<p class="period_area">[ 차수 : <%=challengeDetail.getCi_step() %>차 ] </p>
					<p class="period_area"><%=challengeDetail.getCi_sdate() %> ~ <%=challengeDetail.getCi_edate() %></p>
					<!-- TODO null 해결하고 .substring(0 , 10) 뒤에 붙일것 -->
					<p class="title_area"><%=challengeDetail.getCi_title() %></p>
					<p class="sym_cnt"> 작성자 : <%=challengeDetail.getMi_id() %></p>
				</div>
				<button class="sym_button"><img src="img/heart_empty.png" width="100" height="90" /><br /><br /><p style="font-size:20px">공감( <%=challengeDetail.getCi_good() %> )</p></button>
			</div>
		</section>
		<!-- 도전펀딩 제목 영역 종료  -->
		<!-- 도전펀딩  설명 영역 시작 -->
		<section class="chg_info">
			<div class="info_img_area"><img src="page/challenge/userimg/<%=challengeDetail.getCi_img() %>" width="500" height="500" style="margin-bottom: 30px;" />
			<div class="chal_info_content"><%=challengeDetail.getCi_content().replace("\r\n", "<br />") %>
			<!-- TODO 더미데이터 작성할때 우리 평범하게 게시판 글싸는것처럼 한다음 스타일 어떻게 할지 생각 : 지금은 그냥 가운데 정렬됨 -->
			</div>
			</div>
		</section>
		<!-- 도전펀딩  설명 영역 종료 -->
		<!-- 도전펀딩 채팅 영역 시작 -->
		<section class="chg_chat">
			<div class="chg_chat_area">&nbsp;&nbsp; 댓글 ( <%=challengeReplyList.size() %> )</div>
			<div class="outerBox">
<%
if(challengeReplyList.size() > 0){
for(int i=0;i<challengeReplyList.size(); i++){
	ChallengeReplyList cri = challengeReplyList.get(i);
%>

			<% if (!challengeDetail.getMi_id().equals(cri.getMi_id()) ) { %>
				<div class="innerBox">
					<div class="circle"><img src="img/circle_1.png" width="100" height="100" /></div>
					<div id="init"></div>
					
					<div id="txtBox1">	<!-- 왼쪽 댓글 -->
						<p><img src="img/chat_topL.png" width="450" /></p>
						<div id="txt1">
							<p><%=cri.getMi_id() %> &nbsp; <%=cri.getCr_date().substring(0 , 10) %></p><br />
							<span class="chat_txt"><%=cri.getCr_content().replace("\r\n", "<br />") %></span>
						</div>
						<p><img src="img/chat_bottomL.png" width="450" /></p>
					</div>
				</div>
				<br />
			<% } else if (challengeDetail.getMi_id().equals(cri.getMi_id()) ){ %>
				<div class="innerBox2">
					<div id="txtBox2">	<!-- 오른쪽 댓글 : 작성자 -->
						<p><img src="img/chat_topR.png" width="450" /></p>
						<div id="txt2">
							<p><%=cri.getMi_id() %> &nbsp; <%=cri.getCr_date().substring(0 , 10) %></p><br />
							<span class="chat_txt"><%=cri.getCr_content().replace("\r\n", "<br />") %></span>
						</div>
						<p><img src="img/chat_bottomR.png" width="450" /></p>
					</div>
					<div class="circle"><img src="img/circle_2.png" width="100" height="100" /></div>
					<div id="init2"></div>
				</div>
				<br />
			<% } %>	
<%
	}

}else{
	out.println("<div>댓글이 없습니다.</div>");
}
%>			
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