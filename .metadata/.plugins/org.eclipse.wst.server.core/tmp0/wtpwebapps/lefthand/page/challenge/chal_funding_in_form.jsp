<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" >
	<link rel="stylesheet" type="text/css" href="css/mainLayout.css" />
	<link rel="stylesheet" type="text/css" href="css/chal_funding_list.css" />
	<script src="js/jquery-3.6.0.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="js/mainSlide.js"></script>
	<script src="js/mainPage_scroll.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<script>
// js로 업로드파일을 1차로 검사함

// 크기는 5MB 이하로 설정했는데 5MB이상 파일에 대한 검사처리는 안했음 
// 	alert("이미지 파일 크기는 5MB까지 가능합니다.");	

// 도배 방지를 위해 한 id로 진행중인 도전펀딩이 있으면 업로드를 못하게 막아야하는데
// 테스트할때도 그렇고 이것저것하기 귀찮아서 구현은 안해놓음
// 	alert("회원님의 도전펀딩이 진행중입니다.");	

function isImg(imgstr){
	// 이미지파일인지 여부 검사 : 확장자로 검사함
	var arrImg = ["jpg", "gif", "png", "jpeg", "JPG", "GIF", "PNG", "JPEG"];
	var ext = imgstr.substring(imgstr.lastIndexOf(".") + 1);
		for(var i=0;i<arrImg.length;i++){
			if(ext==arrImg[i])	return true;
	}
	return false;
}

function chkImg(filename){
	if(!isImg(filename)){
		alert("이미지 파일만 첨부해 주세요. [ jpg, gif, png, jpeg ]");		
		document.getElementById("image").value = ""; 
		return false;			
	}   
	return true;
}
</script>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>

<%
if (!isLogin) {
	out.println("<script>");
	out.println("alert('로그인 후 사용하세요.');");
	out.println("location.href='login_form.jsp';");
	out.println("</script>");
	out.close();
}
%>
<!-- ------------------------------------------------------------------------------------------------ -->
<%
LocalDateTime now = LocalDateTime.now();
LocalDateTime edate = now.plusDays(7);
%>
<div class="panel panel-default" style="border:0px;">
<div class="panel-body" style="padding-top:100px;"> 
<div class="container" style="border:0px;">
	<form action="chal_in_proc.chal" method="post" enctype="multipart/form-data">  
	<input type="hidden" name="edate" value="<%=edate %>" />
	<!-- 펀딩 종료일 edate + 7일하여 hidden으로 보냄 -->
	<div class="form-group"  style="border:0px;">
	<label for="ci_title">제목</label>
	<input type="text" class="form-control" name ="ci_title" id="ci_title" placeholder="도전 펀딩 제목을 입력하세요." value="시연용 제목" />
	</div>
	
	<div class="form-group">
	<label for="ci_content">글 내용:</label>
	<textarea class="form-control" rows="20" name="ci_content" id="ci_content">시연용 텍스트 내용</textarea>
	</div>
	
	<div class="form-group">
	<label for="File">첨부 이미지 [ jpg, gif, png, jpeg ]</label>
	<input type="file" name="image" id="image" onchange="chkImg(this.value)" />
	</div>

	<div class="center-block" style='width:400px'>
	<input type="submit" value="등록하기" style="padding:20px 30px; margin:0 30px;" /> 
	<input type="button" value="목록으로" style="padding:20px 30px; margin:0 30px;" onclick="location.href='chal_list.chal';" />
	</div>
	</form> 
</div>
</div> <!--panel end-->
</div>

</div>
<!-- ------------------------------------------------------------------------------------------------ -->
</main>
<%@ include file="../../include/footer.jsp" %>
</body>
</html>