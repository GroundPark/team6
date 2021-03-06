<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ include file="../include/incAdmin.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function call()
{
 if(document.getElementById("pi_price").value && document.getElementById("pi_discount").value){
  document.getElementById('price3').value =
	  Math.ceil(parseInt(document.getElementById('pi_price').value) *  (1 - parseFloat((document.getElementById('pi_discount').value))));
 }
}
function checkFile(f){

	// files 로 해당 파일 정보 얻기.
	var file = f.files;

	// file[0].name 은 파일명 입니다.
	// 정규식으로 확장자 체크
	// 패턴/ 플래그 => 패턴에 있는 문자열들 찾기위함
	// \. : 마침표 자체를 매칭되는 문자열로 사용하기 위함   /문자열 $ =>문자열의 끝에서 일치(gif,jpg... 로 끝남)
	// i: 대소문자 구분없이 검색, test: 매칭된 문자열이 있는지 확인하는 메소드(문자열 있으면 true, 없으면 false)
	if(!/\.(gif|jpg|jpeg|png)$/i.test(file[0].name)) alert('gif, jpg, png 파일만 선택해 주세요.\n\n현재 파일 : ' + file[0].name);

	// 체크를 통과했다면 종료.
	else return;

	// 체크에 걸리면 선택된  내용 취소 처리를 해야함.
	// 파일선택 폼의 내용은 스크립트로 컨트롤 할 수 없습니다.
	// 그래서 그냥 새로 폼을 새로 써주는 방식으로 초기화 합니다.
	f.outerHTML = f.outerHTML;
}
</script>
<style>
.pdtForm { width:800px; }
.lablearea { display:inline-block; width:200px; padding:5px; text-align:left; font-weight:bold; }
.fieldarea { display:inline-block; width:350px; vertical-align:center; }
input[type=text] { width:350px; height:15px; }
input[type=file] { width:350px; }
label { text-align:left; }
</style>
</head>
<body>
<main>
	<article>
		<!-- section 영역 시작 -->
	    <section>
			<h2>상품 등록</h2>
			<form name="frmAdminPdt" action="admin_pdt_in_proc.adminpdt" method="post" class="pdtForm" 
				enctype="multipart/form-data" onsubmit="return chkVal(this);">	
			<div>
				<div class="form_area">	
					<div class="lablearea"><label for ="pi_id" >상품 ID</label></div>
					<div class="fieldarea"><input type="text" name="pi_id" value="a113"/></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pc_id" >카테고리</label></div>				
					<div class="fieldarea">
					<select name="pc_id" style="width:355px; height:20px; text-align:center;" >
						<option value="a">가위</option>
						<option value="b">문구</option>
						<option value="c">주방</option>
						<option value="d">etc</option>
					</select>
					</div>
					</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_name" >상품명</label></div>
					<div class="fieldarea"><input type="text" name="pi_name"  id="pi_name" value="아동용 가위"/></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_img1" >상품이미지1</label></div>					
					<div class="fieldarea"><input type="file" name="pi_img1"  id="pi_img1" onchange="checkFile(this)" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_img2" >상품이미지2</label></div>
					<div class="fieldarea"><input type="file" name="pi_img2" id="pi_img2" onchange="checkFile(this)" /></div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_img3" >상품이미지3</label></div>
					<div class="fieldarea"><input type="file" name="pi_img3"  id="pi_img3" onchange="checkFile(this)" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_desc" >설명이미지</label></div>
					<div class="fieldarea"><input type="file" name="pi_desc"  id="pi_desc" onchange="checkFile(this)" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_price" >상품가격</label></div>
					<div class="fieldarea"><input type="text" name="pi_price"  id="pi_price" onkeyup="call();" value="10000"/></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_discount">할인율</label></div>
					<div class="fieldarea"><input type="text" name="pi_discount"  id="pi_discount" onkeyup="call();" value="0.1"/></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="price3">판매가격</label></div>
					<div class="fieldarea"><input type="text" name="price3"  id="price3" value="9000"/></div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_stock">재고수량</label></div>
					<div class="fieldarea"><input type="text" name="pi_stock"  id="pi_stock" value="100"/></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="sold">품절 여부</label></div>					
					<div class="fieldarea">
					<input type="radio" name="pi_soldout" value="y" id="soldy"/><label for ="soldy">Y</label>
					<input type="radio" name="pi_soldout" value="n" id="soldn" checked="checked"/><label for ="soldn">N</label>
					</div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="isview">게시 여부</label></div>	
					<div class="fieldarea">		
					<input type="radio" name="pi_isview" value="y" id="soldy"/><label for ="soldy">Y</label>
					<input type="radio" name="pi_isview" value="n" id="soldn" checked="checked"/><label for ="soldn">N</label>
					</div>
				</div>
				<%
				LocalDate now = LocalDate.now();
				%>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_date">등록일</label></div>
					<div class="fieldarea"><span style="text-align:left;"><%=now %></span></div>
				</div>
				<div class="form_area">				
					<div class="lablearea">	<label for ="ai_idx">등록 관리자</label></div>
					<div class="fieldarea"><input type="text" name="ai_idx" id="ai_idx" value="<%=adminInfo.getAi_idx() %>" style="text-align:center;" readonly/></div>
				</div>
				<p id="button_area" style="width:1020px; margin-top:30px;">
					<input type="button" value="취소" onclick="location.href ='admin_pdt_list.adminpdt';" style="width:170px; height:25px;"/>
					<input type="submit" value="등록" style="width:170px; height:25px;"/>
				</p>
				</div>
				</div>
				</div>
			</form>
		   </section>
		<!-- section 영역 종료 -->
	</article>
</main>
<!-- main 영역 종료 -->
</body>
</html>