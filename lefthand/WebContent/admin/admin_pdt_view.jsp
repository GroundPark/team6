<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%@ include file="../include/incAdmin.jsp" %>
<%
request.setCharacterEncoding("utf-8");
ProductInfo pdt =(ProductInfo)request.getAttribute("pdtInfo");
ArrayList<PdtCata> cataList = (ArrayList<PdtCata>)request.getAttribute("cataList");
AdminPdtPageInfo adminpdtPageInfo = (AdminPdtPageInfo)request.getAttribute("adminpdtPageInfo");

 String args ="", schargs = "";
 
%>
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
	    <section>
			<h2>상품 등록</h2>
			<form name="frmAdminPdt" action="admin_pdt_up_proc.adminpdt" method="post" class="pdtForm">	
			<div>
				<div class="form_area">	
					<div class="lablearea"><label for ="pi_id" >상품 ID</label></div>
					<div class="fieldarea"><input type="text" name="pi_id" value="<%=pdt.getPi_id() %>" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_id" >카테고리</label></div>				
					<div class="fieldarea">
					<select name="pc_" id="option" style="width:250px; height:20px; text-align:center;" >
						<option value="a" <% if(pdt.getPc_id().equals("a")) { %> selected="selected" <% }%>>가위</option>
						<option value="b" <% if(pdt.getPc_id().equals("b")) { %> selected="selected" <% }%>>문구</option>
						<option value="c" <% if(pdt.getPc_id().equals("c")) { %> selected="selected" <% }%>>주방</option>
						<option value="d" <% if(pdt.getPc_id().equals("d")) { %> selected="selected" <% }%>>etc</option>
					</select>
					</div>
					</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_name" >상품명</label></div>
					<div class="fieldarea"><input type="text" name="pi_name"  id="pi_name" value="<%=pdt.getPi_name() %>"/></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_img1" >상품이미지1</label></div>					
					<div class="fieldarea"><input type="text" name="pi_img1"  id="pi_img1" value="<%=pdt.getPi_img1() %>"/></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_img2" >상품이미지2</label></div>
					<div class="fieldarea"><input type="text" name="pi_img2" id="pi_img2" value="<%=pdt.getPi_img2() %>"/></div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_img3" >상품이미지3</label></div>
					<div class="fieldarea"><input type="text" name="pi_img3"  id="pi_img3" value="<%=pdt.getPi_img3() %>" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_desc" >설명이미지</label></div>
					<div class="fieldarea"><input type="text" name="pi_desc"  id="pi_desc" value="<%=pdt.getPi_desc() %>"/></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_price" >상품가격</label></div>
					<div class="fieldarea"><input type="text" name="pi_price"  id="pi_price" value="<%=pdt.getPi_price() %>"/></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_discount">할인율</label></div>
					<div class="fieldarea"><input type="text" name="pi_discount"  id="pi_discount" value="<%=pdt.getPi_discount() %>" /></div>
				</div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_price">판매가격</label></div>
					<div class="fieldarea"><input type="text" name="pi_price"  id="pi_price" value="<%=Math.round(pdt.getPi_price() * (1 - pdt.getPi_discount())) %>"/></div>
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_stock">재고수량</label></div>
					<div class="fieldarea"><input type="text" name="pi_stock"  id="pi_stock" value="<%=pdt.getPi_name() %>" /></div>
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
				<div class="form_area">				
					<div class="lablearea"><label for ="pi_date">등록일</label></div>
					<div class="fieldarea"><span style="text-align:left;"><%=pdt.getPi_date() %></span></div>
				</div>
				<div class="form_area">				
					<div class="lablearea">	<label for ="ai_idx">등록 관리자</label></div>
					<div class="fieldarea"><%=pdt.getAi_idx() %></div>
				</div>
				<p id="button_area" style="width:940px; margin-top:20px;">
					<input type="button" value="돌아가기" onclick="location.href ='admin_pdt_list.adminpdt';" style="width:120px; height:25px;"/>
					<input type="submit" value="수정" style="width:120px; height:25px;"/>
				</p>	
		   </section>
		<!-- section 영역 종료 -->
	</article>
</main>
</body>
</body>
</html>