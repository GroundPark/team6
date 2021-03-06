<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");		// 페이징 정보
AdminChallengeList adminChallenge = (AdminChallengeList)request.getAttribute("adminChallenge");		// 게시글 정보

String schtype = "", keyword = "";
String args = "?cpage=" + pageInfo.getCpage();		
//if(pageInfo.getKeyword() != null && !pageInfo.getKeyword().equals("")){
//	schtype = pageInfo.getSchtype();
//	keyword = pageInfo.getKeyword();
//	args += "&schtype=" + pageInfo.getSchtype() + "&keyword=" + pageInfo.getKeyword();
	// 검색조건이 있을 경우에만 schtype와 keyword에 정보를 저장하고... 검색 조건이 있을 경우에만 쿼리스트링으로 만들어줌
//}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<style>
.admin_chal_detail_container{
	width:100%;
	padding:50px;
}

</style>
<script>
// textArea 글의 크기? 만큼 자동조절해줌
$(document).ready(function () {
$("textarea").each(function () {
	  this.setAttribute("style", "height:" + (this.scrollHeight) + "px;overflow-y:hidden;");
	}).on("input", function () {
	  this.style.height = "auto";
	  this.style.height = (this.scrollHeight) + "px";
	})
});
</script>
<%

%>
<body>
<%@ include file="../include/incAdmin.jsp" %>
<main>
<div class="admin_chal_detail_container">
<form class="form-horizontal" role="form" name="frmChallengeList" method="post" action="../admin/chal_up_proc.admin" >
<input type="hidden" name="ciidx" value="<%=adminChallenge.getCi_idx() %>" />
<input type="hidden" name="cpage" value="<%=pageInfo.getCpage() %>" />
<input type="hidden" name="schtype" value="" />
<input type="hidden" name="keyword" value="" />
    <div class="form-inline form-group">
        <label for="inputName" class="col-lg-1 control-label">글 번호</label>
        <div class="col-lg-10">
            <input type="text" style="width:25%;" class="form-control" name="ci_idx" value="<%=adminChallenge.getCi_idx() %>" data-rule-required="true" maxlength="15" disabled="disabled" >
        </div>
    </div>

    <div class="form-inline form-group">
        <label for="inputId" class="col-lg-1 control-label">글 제목</label>
        <div class="col-lg-10">
            <input type="text" style="width:50%;" class="form-control" name="ci_title" value="<%=adminChallenge.getCi_title() %>" data-rule-required="true" maxlength="30">
        </div>
    </div>
    <br />
 	<div class="form-group">
        <label for="inputId" class="col-lg-1 control-label">&nbsp;&nbsp;설명</label>
        <div class="col-lg-10 w-100">
            <textarea class="form-control" name="ci_content" style="resize:none;">
<%=adminChallenge.getCi_content() %>
            </textarea>         
        </div>
    </div>
    <br />
    <br />
    <!-- .getCi_content().replace("\r\n", "<br />") 처럼 써서 줄바꿈에 대한 처리를 해야하는데 너무 귀찮다.. -->
    <div class="form-inline form-group" id="divName">
        <label for="inputName" class="col-lg-1 control-label">이미지</label>
        <div class="col-lg-10">
		<% if(adminChallenge.getCi_img().equals("null")) { %>
		<p>업로드한 이미지가 없습니다.</p>
		<% } else { %>
		<img src="../page/challenge/userimg/<%=adminChallenge.getCi_img() %>" style="width:500px; height:500px; " />	
		<% } %>
        </div>
    </div>
    <div class="form-inline form-group">
        <label for="inputId" class="col-lg-1 control-label">작성자</label>
        <div class="col-lg-10">
            <input type="text" style="width:25%;" class="form-control" name="mi_id" value="<%=adminChallenge.getMi_id() %>" data-rule-required="true" maxlength="30" disabled="disabled">
        </div>
    </div>
    <div class="form-inline form-group">
        <label for="inputId" class="col-lg-1 control-label">등록일</label>
        <div class="col-lg-10">
            <input type="text" style="width:25%;" class="form-control" name="ci_sdate" value="<%=adminChallenge.getCi_sdate().substring(0 , 10) %>" data-rule-required="true" maxlength="30" disabled="disabled">
        </div>
    </div>
    <div class="form-inline form-group">
        <label for="inputId" class="col-lg-1 control-label">마감일</label>
        <div class="col-lg-10">
            <input type="text" style="width:25%;" class="form-control" name="ci_edate" value="<%=adminChallenge.getCi_edate().substring(0 , 10) %>" data-rule-required="true" maxlength="30" disabled="disabled">
        </div>
    </div>
    
    
    
   <div class="form-inline form-group">
        <label for="inputId" class="col-lg-1 control-label">차수</label>
        <div class="col-lg-10">
	<ul id="admin_cmb_step" data-rule-required="true">
		<li><select class="form-control" name="ci_step" style="width:25%;">
			<option value="1" <% if(adminChallenge.getCi_step() == 1) { %>selected <% } %>>1차</option>
			<option value="2" <% if(adminChallenge.getCi_step() == 2) { %>selected <% } %>>2차</option>
		</select></li>
	</ul>
        </div>
    </div>
    
    
    
    <div class="form-inline form-group">
        <label for="inputId" class="col-lg-1 control-label">좋아요 수</label>
        <div class="col-lg-10">
            <input type="text" style="width:25%;" class="form-control" name="ci_good" value="<%=adminChallenge.getCi_good() %>" data-rule-required="true" maxlength="30">
        </div>
    </div>
    
  <div class="form-inline form-group">
        <label for="inputId" class="col-lg-1 control-label">진행상태</label>
        <div class="col-lg-10">
	<ul id="admin_cmb_step" data-rule-required="true">
		<li><select class="form-control" name="ci_status" style="width:25%;">
			<option value="a" <% if(adminChallenge.getCi_status().equals("a")) { %>selected <% } %>>진행</option>
			<option value="b" <% if(adminChallenge.getCi_status().equals("b")) { %>selected <% } %>>마감</option>
			<option value="c" <% if(adminChallenge.getCi_status().equals("c")) { %>selected <% } %>>펀딩확정</option>
		</select></li>
	</ul>
        </div>
    </div>

    <div class="form-inline form-group">
       <label for="inputPhoneNumber" class="col-lg-1 control-label" style="width:25%;">게시 여부</label>
       <div class="col-lg-10">
           <label class="radio-inline float-left" >
               <input type="radio" id="ci_isview" name="ci_isview" value="y" <% if(adminChallenge.getCi_isview().charAt(0) == 'y' ) { %>checked <% } %>>&nbsp;Y&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="radio" id="ci_isview" name="ci_isview" value="n" <% if(adminChallenge.getCi_isview().charAt(0) == 'n' ) { %>checked <% } %>>&nbsp;N
           </label>
       </div>
    </div>
            
                
    <div class="form-group">
        <div class="col-lg-offset-2 col-lg-10">
            <button type="submit" class="btn btn-primary">수정</button>
        </div>
    </div>
</form>
</div>
</main>
</body>
</html>