<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ include file="../include/incAdmin.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.pdtForm { width:800px; }
.lablearea { display:inline-block; width:130px; padding:5px; }
.fieldarea { display:inline-block; width:300px; vertical-align:center; }
input[type=text] { width:250px; height:15px; }
label { text-align:left; }
</style>
</head>
<script>
function isImg(imgstr) {
	// 이미지파일인지 여부 검사 : 확장자로 검사함
	var arrImg = ["jpg", "gif", "png", "jpeg", "JPG", "GIF", "PNG", "JPEG"];
	var ext = imgstr.substring(imgstr.lastIndexOf(".") + 1);
		for(var i=0;i<arrImg.length;i++){
			if(ext==arrImg[i])	return true;
	}
	return false;
}

function chkImg(filename) {
	if(!isImg(filename)) {
		alert("이미지 파일만 첨부해 주세요. [ jpg, gif, png, jpeg ]");		
		document.getElementById("image").value = ""; 
		return false;			
	}   
	return true;
}
</script>
<body>
<main>
	<article>
		<!-- section 영역 시작 -->
	    <section>
			<h2>펀딩 등록</h2>
			<form name="frmFdginPdt" action="funding_in_proc.admin" method="post" class="pdtForm" enctype="multipart/form-data">
			<div>
				<div class="form_area">	
					<div class="lablearea"><label for="fi_id">펀딩 ID</label></div>
					<div class="fieldarea"><input type="text" name="fi_id" value="fd121"/></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_name" >제목</label></div>
					<div class="fieldarea"><input type="text" name="fi_name" value="왼손잡이 글러브" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="fi_img1" >펀딩이미지1</label></div>					
					<div class="fieldarea"><input type="file" name="fi_img1" id="fi_img1" onchange="chkImg(this.value)" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="fi_img2" >펀딩이미지2</label></div>
					<div class="fieldarea"><input type="file" name="fi_img2" id="fi_img2" onchange="chkImg(this.value)"  /></div>
				<div class="form_area">				
					<div class="lablearea"><label for ="fi_img3" >펀딩이미지3</label></div>
					<div class="fieldarea"><input type="file" name="fi_img3"  id="fi_img3" onchange="chkImg(this.value)"  /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="fi_desc" >설명이미지</label></div>
					<div class="fieldarea"><input type="file" name="fi_desc"  id="fi_desc" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="fi_price" >단가</label></div>
					<div class="fieldarea"><input type="text" name="fi_price" id="fi_price" value="89000" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="fi_goal">펀딩목표금액</label></div>
					<div class="fieldarea"><input type="text" name="fi_goal"  id="fi_goal" value="890000" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_isview" >게시여부</label></div>
					<div class="fieldarea">
						<input type="radio" name="fi_isview" value="y" id="soldy" /><label for ="soldy">Y</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="fi_isview" value="n" id="soldn" checked="checked" /><label for ="soldn">N</label>
					</div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="fi_sdate">시작일</label></div>
					<div class="fieldarea"><input type="text" name="fi_sdate"  id="fi_sdate" value="2021-12-13" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="fi_edate">마감일</label></div>
					<div class="fieldarea"><input type="text" name="fi_edate"  id="fi_edate" value="2022-01-13" /></div>
				</div>
				<%
				LocalDate now = LocalDate.now();
				%>
				<div class="form_area">				
					<div class="lablearea"><label for ="fi_date">등록일</label></div>
					<div class="fieldarea"><span style="text-align:left;"><%=now %></span></div>
				</div>
				<div class="form_area">				
					<div class="lablearea">	<label for ="ai_idx">등록 관리자</label></div>
					<div class="fieldarea"><%=adminInfo.getAi_id() %></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_status" >진행상태</label></div>
					<div class="fieldarea">
						<ul id="admin_cmb_step" data-rule-required="true">
							<li>
								<select class="form-control" name="fi_status">
									<option value="a" >펀딩중</option>
									<option value="b" >펀딩성공</option>
									<option value="c" >펀딩실패</option>
								</select>
							</li>
						</ul>
					</div>
				</div>
				<p id="button_area" style="width:940px; margin-top:20px;">
					<input type="button" value="취소" onclick="location.href ='admin_funding_list.admin';" style="width:120px; height:25px;"/>
					<input type="submit" value="등록" style="width:120px; height:25px;"/>
				</p>
				</div>
				</div>
				</form>	
		   </section>
		<!-- section 영역 종료 -->
	</article>
</main>
</body>
</html>