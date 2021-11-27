<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="product.vo.*" %>
<%
ProductInfo pdt =(ProductInfo)request.getAttribute("pdtInfo");
if (pdt == null){
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다.');");
	out.println("history.back()");
	out.println("</script>");
	out.close();
}
PdtPageInfo pageInfo = (PdtPageInfo)request.getAttribute("pdtPageInfo");
// 검색 조건 등의 정보를 저장하고 있는 인스턴스

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/footer.css" />
<link rel="stylesheet" type="text/css" href="css/pdt_list_detail.css" />
<script src="js/jquery-3.6.0.js"></script>
<script>
function cartBuy(chk) {
	// 장바구니나 바로 구매로 이동시키는 함수로 비로그인 시 로그인 폼으로 이동시켜야 함
	<%
	if (!isLogin) {	 %>
		location.href = "../../login_form.jsp?url=pdt_view.pdt?<%=request.getQueryString().replace("&", "$") %>";

	<% } else {	// 로그인 상태면 해당 위치로 전송시킴 %>
		var lnk = "";
		if (chk == 'c')	lnk = "cart_proc.ord";	// 장바구니 담기일 경우 이동할 경로
		else			lnk = "order_form.brd";	// 바로 구매일 경우 이동할 경로

		var frm = document.frmPdt;
		frm.action = lnk;
		frm.submit();
	<% } %>
</script>
</head>
<body>
<%@ include file ="/include/header.jsp" %>
<!-- 상품 상세보기 영역 시작 -->
<article class ="pdt_detail">
	<div class ="pdt_detail_inner">
		<!-- 상품 상세보기 대표 이미지 & 가격(주문) 영역 시작 -->
		<section class="img_price">
		<div class="img_price_area">
			<!-- 상품 이미지 영역 시작 -->
			<div class="img_area">
				<div class="img_big_area">
					<img src="img/<%=pdt.getPi_img1() %>" id="bigImg" width="380px" height="380px" alt="상품이미지"/>
				</div>
				<div class="img_small_area">
					<ul class="pdt_thumb_list">
						<li><a href="#"><img src="<%=pdt.getPi_img1() %>" width="100px" height="100px" alt="상품이미지1" onclick="chImg('1');"/></a></li>
						<li><a href="#"><img src="<%=pdt.getPi_img2() %>" width="100px" height="100px" alt="상품이미지2" onclick="chImg('2');"/></a></li>
						<li><a href="#"><img src="<%=pdt.getPi_img3() %>" width="100px" height="100px" alt="상품이미지3" onclick="chImg('3');"/></a></li>
					</ul>
				</div>
			</div>
			<!-- 상품 이미지 영역 종료  -->
			<!-- 상품 가격(주문) 영역 시작 -->	
			<div class="price_area">			
			<div class="price_area_inner">			
				<p class="pdt_name"><%=pdt.getPi_name() %></p>			
				<p class="price">
					<span class="price1"><%=pdt.getPi_price() %></span>
					<span class="price2"><%=pdt.getPi_discount() * 100 %>%</span>
					<span class="price3"><%=pdt.getPi_price() - (pdt.getPi_price() * pdt.getPi_discount()) %></span>
				</p>
				<div class="deli_area">
					<p class="deli1">배송정보</p>			
					<p class="deli2">30,000원 이상 주문시 무료 배송(미만시 배송비 2500원 발생)</p>
				</div>									
				<div class="order_cnt">
					<div class="order_cnt_box">
						<div class="titl_area">
							<span>구매수량</span>					
						</div>
						<div class="cont_area">
							<span class="cont_cnt_box">
								<button class="btnCal_cminus" name="cminus" id="cminus" value="-" onclick="changeCnt(this.value)"></button>
								<input type="text" id="cartCnt" name="cartCnt" value="1" onkeyup="onlyNum(this);"/>
								<button class="btnCalc_cplus" name="cplus" id="cplus" value="+" onclick="changeCnt(this.value)"></button>
							</span>
						</div>
					</div>					
				</div>
				<form name="frmPdt" method="post">
		 		<input type="hidden" name="piid" value="<%=pdt.getPi_id() %>" />
				<input type="hidden" name="cpage" value="<%=pageInfo.getCpage() %>" />
				<input type="hidden" name="psize" value="<%=pageInfo.getPsize() %>" />
				<input type="hidden" name="keyword" value="<%=pageInfo.getKeyword() %>" />
				<input type="hidden" name="cata" value="<%=pageInfo.getCata() %>" />
				<input type="hidden" name="sort" value="<%=pageInfo.getSort() %>" /> 
				<input type="hidden" name="occnt" value="1" />
				<input type="hidden" name="wtype" value="in" />
				<div class="pdt_total_price">
					<div class="pdt_total_line">
						<span class="tp_titl">상품금액 합계</span>					
						<span class="total"><%=pdt.getPi_price() %></span>
					</div>
				</div>
				<div class="pdt_btn_area">
					<button class="btn" id="btn01" name="ordcart" id="ordcart" onclick="cartBuy('c');"><span>장바구니</span></button>
					<button class="btn" id="btn01" name="diord" id="diord" onclick="cartBuy('d');"><span>바로구매</span></button>
					<button class="btn" id="btn02" name="zzim" id="zzim" onclick=""><span>찜</span></button>
				</div>
				</form>						
			</div>
			<!-- 상품 가격(주문) 영역 종료  -->			
			</div>				
		</div>
		</section>
		<!-- 상품 고객리뷰 별점 & 상세 설명  탭 영역 시작 -->
		<section class="info_review">
		<div class="info_review_area">
			<!-- 상품 고객리뷰 별점 영역 시작  -->
			<div class="star_review_area">
				<p id="cuReview">
					<strong>고객리뷰</strong>
					<span class="review_point">별별별별</span>
					<b>4.8</b>
				</p>
			</div>
			<!-- 상품 고객리뷰 별점 영역 종료  -->
			<div class="pdt_detail_area">
				<!-- 상품 상세 설명  탭 영역 시작  -->
				<ul class="pdt_detail_tab">
					<li onclick="fnMove('1')">상품설명</li>
					<li onclick="fnMove('2')">리뷰</li>
					<li onclick="fnMove('3')">교환/반품/환불 안내</li>
				</ul>
				<!-- 상품 상세 설명  탭 영역 종료  -->
				<!-- 상품 상세 설명 영역 시작  -->
				<div class="tab_cont_area">
					<div class="content1">
						<img src="img/a101_desc.jpg" width="1100px" height="4670px" alt="상품설명이미지" />
					</div>
					<!-- 상품 상세 리뷰 영역 시작 -->
					<div class="content2">
						<h2>리뷰</h2>
						<!-- 상품 리뷰 시작(사진포함)  -->
						<div class="review_area">
							<span id="revwriter">회원아이디</span>
							<span id="revscore">별별별별</span>
							<span id="revdate">후기작성일</span>
							<p id="revcontent">후기내용입니다.</p>
							<div class="revbottom_area">
								<p id="revimg"><img src="" width="80px;" height="80px;" alt="후기사진" /></p>
								<div id="good_report_area">
									<button id="btngood"><span>좋아요(10)</span></button>
									<button id="btnreport"><span>신고</span></button>							
								</div>
							</div>
						</div>
						<!-- 상품 리뷰 종료(사진포함)  -->
						<!-- 상품 리뷰 시작  -->
						<div class="review_area">
							<span id="revwriter">회원아이디</span>
							<span id="revscore">별별별별</span>
							<span id="revdate">후기작성일</span>
							<p id="revcontent">후기내용입니다.</p>
							<div class="revbottom_area2">
								<div id="good_report_area2">
									<button id="btngood"><span>좋아요(10)</span></button>
									<button id="btnreport"><span>신고</span></button>							
								</div>
							</div>
						</div>						
						<!-- 상품 리뷰 종료  -->
					 <!-- 상품 상세 리뷰 영역 종료 -->					
					</div>
					<div class="content3">
						<img src="../../img/refund_info.png" width="1100px" height="600px"  alt="교환/환불 안내"/>					
					</div>
				</div>
			</div>
		</div>
		</section>			
	</div>	
</article>
<%@ include file ="/include/footer.jsp" %>
<!-- list_detail js 연결  -->
<script type="text/javascript" src="../../js/list_detail.js"></script>
</body>
</html>