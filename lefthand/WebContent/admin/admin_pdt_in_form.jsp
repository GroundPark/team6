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
<body>
<main>
	<article>
		<!-- section 영역 시작 -->
	    <section>
			<h2>상품 등록</h2>
			<form name="frmAdminPdt" action="admin_pdt_in_proc.adminpdt" method="post" class="pdtForm">	
			<div>
				<div class="form_area">	
					<div class="lablearea"><label for ="pi_id" >상품 ID</label></div>
					<div class="fieldarea"><input type="text" name="pi_id" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_id" >카테고리</label></div>				
					<div class="fieldarea">
					<select name="pc_id" id="pc_id" style="width:250px; height:20px; text-align:center;" >
						<option value="a">가위</option>
						<option value="b">문구</option>
						<option value="c">주방</option>
						<option value="d">etc</option>
					</select>
					</div>
					</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_name" >상품명</label></div>
					<div class="fieldarea"><input type="text" name="pi_name"  id="pi_name" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_img1" >상품이미지1</label></div>					
					<div class="fieldarea"><input type="file" name="pi_img1"  id="pi_img1"/></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_img2" >상품이미지2</label></div>
					<div class="fieldarea"><input type="file" name="pi_img2" id="pi_img2" /></div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_img3" >상품이미지3</label></div>
					<div class="fieldarea"><input type="file" name="pi_img3"  id="pi_img3" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_desc" >설명이미지</label></div>
					<div class="fieldarea"><input type="file" name="pi_desc"  id="pi_desc" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_price" >상품가격</label></div>
					<div class="fieldarea"><input type="text" name="pi_price"  id="pi_price" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_discount">할인율</label></div>
					<div class="fieldarea"><input type="text" name="pi_discount"  id="pi_discount" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_price">판매가격</label></div>
					<div class="fieldarea"><input type="text" name="pi_price"  id="pi_price" /></div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_stock">재고수량</label></div>
					<div class="fieldarea"><input type="text" name="pi_stock"  id="pi_stock" /></div>
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
					<input type="radio" name="pi_soldout" value="y" id="soldy"/><label for ="soldy">Y</label>
					<input type="radio" name="pi_soldout" value="n" id="soldn" checked="checked"/><label for ="soldn">N</label>
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
					<div class="fieldarea"><%=adminInfo.getAi_id() %></div>
				</div>
				<p id="button_area" style="width:940px; margin-top:20px;">
					<input type="button" value="취소" onclick="location.href ='admin_pdt_list.adminpdt';" style="width:120px; height:25px;"/>
					<input type="submit" value="등록" style="width:120px; height:25px;"/>
				</p>	
		   </section>
		<!-- section 영역 종료 -->
	</article>
</main>
<!-- main 영역 종료 -->
</body>
</html>