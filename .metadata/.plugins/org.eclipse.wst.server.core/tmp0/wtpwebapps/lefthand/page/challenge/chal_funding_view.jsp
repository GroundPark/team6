<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%@ page import="java.util.*" %>
<%
request.setCharacterEncoding("utf-8");
ChallengePageInfo challengePageInfo = (ChallengePageInfo)request.getAttribute("challengePageInfo");	// 페이징 정보

ChallengeInfo challengeDetail = (ChallengeInfo)request.getAttribute("challengeDetail");		// 게시글 정보가 들어있는 인스턴스
if(challengeDetail == null){
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}
ArrayList<ChallengeReplyList> challengeReplyList = (ArrayList<ChallengeReplyList>)request.getAttribute("challengeReplyList"); // 댓글 정보

ChallengeGoodable goodable = (ChallengeGoodable)request.getAttribute("goodable");

//String args = "?cpage=" + challengePageInfo.getCpage();		
// if(challengepageInfo.getKeyword() != null && !challengepageInfo.getKeyword().equals("")){
// 	args += "&schtype=" + challengepageInfo.getSchtype() + "&keyword=" + challengepageInfo.getKeyword();
// }	// 검색 조건이 있을 경우에만 쿼리스트링으로 만들어 줌

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/mainLayout.css" />
	<link rel="stylesheet" type="text/css" href="css/chal_funding_detail.css" />

<script src="js/jquery-3.6.0.js"></script>

</head>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<script>
/* 댓글 300자 제한 */
 <%
 int myCridx = ( challengeReplyList.size() == 0 ) ? 
		 						-1 : challengeReplyList.get(challengeReplyList.size() - 1).getCr_idx();

 %>	
 $(document).ready(function() {
	    $('#write').on('keyup', function() {
	        $('#write_cnt').html("("+$(this).val().length+" / 300)");
	 
	        if($(this).val().length > 300) {
	            $(this).val($(this).val().substring(0, 300));
	            $('#write_cnt').html("(300 / 300)");
	        }
	    });  
	    
	    
	});

 
function replyreg(){
	<%
    if (!isLogin) {
    %>
    alert("로그인 후 사용하세요.");
	location.href="login_form.jsp";
	<%
	} else {
	%>
    var getReplyContent = $("#write").val();
    $.ajax({
    	type : "POST",
		url: "chal_reply_in.chal",
		data : { 
			"ciidx" : "<%=challengeDetail.getCi_idx() %>",	
			"cridx" : "<%=myCridx %>",
			"crcontent" : getReplyContent 
			},
		success: function() {
			location.reload();
		}
	});
    <% } %>
}


function callDel(){
	if(confirm("정말 삭제하시겠습니까?")){
		location.href="chal_del_proc.chal?ciidx=<%=challengeDetail.getCi_idx() %>";
	}
}


<%
int isgood = 0;

System.out.println("도전펀딩 ajax용 검사값 " + goodable.getCg_history());

isgood = goodable.getCg_history();
%>	


// 실력딸려서 걍 다 나누고 작업함!
function heartFlag(obj, idx) {		
	var flag = false;
	flag = !flag;
	
	if (flag) { 		// 좋아요 하트 누르면
		obj.src="img/chal_heart_full.png";	
		$.ajax({
			type : "POST",									
			url : "chal_view_good.chal",				
			data : {
				"ci_idx" : idx,	
				"cg_history" : "1"				// 누르면 1
					},										
			success : function(chkRs) {					
				if (chkRs == 0)	 	alert("좋아요 추가 실패");
				else 				location.reload();
			}
		});
	}
}

function heartFlag2(obj, idx) {	
	var flag2 = false;
	flag2 = !flag2;
	if (flag2) {				// 좋아요 하트 취소하면
		obj.src="img/chal_heart_empty.png";	
		$.ajax({
			type : "POST",								
			url : "chal_view_good_cancel.chal",				
			data : {
				"ci_idx" : idx,	
				"cg_history" : "0"				// 취소하면 0
			},										
			success : function(chkRs) {						
				if (chkRs == 0)	 	alert("좋아요 없애기 실패");
				else 				location.reload();
			}
		});
	}
}



</script>
<!-- 도전펀딩 영역 시작  -->
<article class="chalfunding_detail" >
	<div class="chalfunding_detail_inner" >
		<!-- 도전펀딩 제목 영역 시작  -->
		<section class="chg_top">
			<div class="chg_top_area">
				<div class="chg_titl_area">
					<p class="period_area">[ 차수 : <%=challengeDetail.getCi_step() %>차 ] </p>
					<p class="period_area"><%=challengeDetail.getCi_sdate().substring(0 , 10) %> ~ <%=challengeDetail.getCi_edate().substring(0 , 10) %></p>
					<!-- TODO null 해결하고 .substring(0 , 10) 뒤에 붙일것 -->
					<p class="title_area"><%=challengeDetail.getCi_title() %></p>
					<p class="sym_cnt"> 작성자 : <%=challengeDetail.getMi_id() %></p>
				</div>
				<button class="sym_button" style=" margin-right:30px; ">		
				<% if( isgood == 0) { %>
				<img src="img/chal_heart_empty.png" width="100" height="90" 
				onclick="heartFlag(this, <%=challengeDetail.getCi_idx() %>);" style="cursor:pointer;" /><br /><br />
				<% } else { %>
				<img src="img/chal_heart_full.png" width="100" height="90" 
				onclick="heartFlag2(this, <%=challengeDetail.getCi_idx() %>);" style="cursor:pointer;" /><br /><br />
				<% } %>
				<p style="font-size:20px">공감( <%=challengeDetail.getCi_good() %> )</p></button>			
			</div>
		</section>
		<!-- 도전펀딩 제목 영역 종료  -->
		<!-- 도전펀딩  설명 영역 시작 -->
		<section class="chg_info">
			<% if(!challengeDetail.getCi_img().equals("null")) { %>
			<div class="info_img_area">
			<img src="page/challenge/userimg/<%=challengeDetail.getCi_img() %>" width="500" height="500" style="margin-bottom: 30px;" />
			</div>
			<% } %>
			<div class="chal_info_content"><%=challengeDetail.getCi_content().replace("\r\n", "<br />") %>
			</div>
			
		</section>
		<% if (challengeDetail.getMi_id().equals(memberInfo.getMi_id())) { %>
		<div class="btn_chal_callDel" style="text-align:right;"><input type="button" value="글 삭제" onclick="callDel();" style="padding:20px 30px; margin:0 30px; "/></div>
		<% } else { %>
		<div class="btn_chal_callDel" style="text-align:right;"></div>
		<% } %>
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
	out.println("<div style='padding:32px 0 48px 0; text-align:center; font-size:1.3em;'>댓글이 없습니다.</div>");
}
%>			
				<div id="writeBox">
					<textarea id="write" name="write" cols="77" rows="6"></textarea>
					<button id="btn" onclick="replyreg()">등록</button><br />
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