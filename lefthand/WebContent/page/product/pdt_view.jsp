<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%@page import="java.text.DecimalFormat"%>
<%
request.setCharacterEncoding("utf-8");

ProductInfo pdt =(ProductInfo)request.getAttribute("pdtInfo");
ArrayList<PdtCata> cataList = (ArrayList<PdtCata>)request.getAttribute("cataList");

ReviewPageInfo revPageInfo = (ReviewPageInfo)request.getAttribute("revPageInfo");
ArrayList<ReviewList> reviewList = (ArrayList<ReviewList>)request.getAttribute("reviewList"); 
PdtPageInfo pdtPageInfo = (PdtPageInfo)request.getAttribute("pdtPageInfo");

if (pdt == null){
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다.');");
	out.println("history.back()");
	out.println("</script>");
	out.close();
}
PdtPageInfo pageInfo = (PdtPageInfo)request.getAttribute("pdtPageInfo");

String args ="", schargs = "";

/* //검색관련 쿼리스트링 
후기 페이징 하려고 가져왔는데 후기페이지 조건을 넣으면 상품 상세에 해당하는 정보를 가져올 수가 없음,,,
if(pdtPageInfo.getKeyword() != null && !pdtPageInfo.getKeyword().equals(""))	
	schargs += "&keyword=" + pdtPageInfo.getKeyword();
if(pdtPageInfo.getCata() != null && !pdtPageInfo.getCata().equals(""))
	schargs += "&cata=" + pdtPageInfo.getCata();

args = "?cpage=" + pdtPageInfo.getCpage() + schargs;  */

//숫자에 콤마 찍기위한 인스턴스
DecimalFormat decFormat = new DecimalFormat("###,###");
int price = pdt.getPi_price();
int panmega = Math.round(price - (price * pdt.getPi_discount()));		// 할인 적용된 상품금액
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/footer.css" />
<link rel="stylesheet" type="text/css" href="css/pdt_view.css" />
<link rel="stylesheet" type="text/css" href="css/mainLayout.css" />
<script src="js/jquery-3.6.0.js"></script>	
<script src="js/heartFlag.js"></script>
</head>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<script>
//숫자에 콤마
function priceToString(price) {
    return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',').concat('원');
}

var cartCnt = 1;	// 상품 개수를 저장한 변수
var total = <%=panmega %>;	// 상품 가격을 저장한 변수
function changeCnt(op) {
	var obj1 = document.getElementById("cartCnt");
	var obj2 = document.getElementById("total");
	if (op == "+") {
		cartCnt = cartCnt + 1;
	} else {
		if (cartCnt > 1)	cartCnt = cartCnt - 1;
	}
	obj1.value = cartCnt;
	obj2.innerHTML = priceToString(cartCnt * total);	
	document.frmPdt.poccnt.value = cartCnt;
}

//상품 수량 숫자만 입력 & 1부터 99까지 범위 지정
function onlyNum(obj) {
	var obj1 = document.getElementById("cartCnt");
	var obj2 = document.getElementById("total");
	
	if (isNaN(obj.value))	obj.value = "";
	if (obj.value > 99 )	{	
		obj.value = "" ; alert("구매는 1개 부터 99개 까지 가능합니다."); 
	}
	
	if(cartCnt != null){
		obj2.innerHTML = priceToString(cartCnt * total);
	}	
}

 function plusLike(rlidx, good) {
 // 좋아요 클릭시 숫자 증가
		$.ajax({
			type : "POST", 
			url : "/lefthand/likeplus", 
			data : {"rlidx" : rlidx}, 
			success : function(data) {
				if (data == 1) {
					document.getElementById("good" + rlidx).innerHTML = good + 1;
				}
			}, 
			error : function(data) {
				alert("실패  rlidx: " + rlidx);
				alert("실패 good: " + good);
			}
		});	
	}

function cartBuy(chk) {
	// 장바구니나 바로 구매로 이동시키는 함수로 비로그인 시 로그인 폼으로 이동시켜야 함
	<%
	if (!isLogin) {	 %>
		alert("로그인 후 이용해 주세요.");
		location.href = "login_form.jsp?url=pdt_view.pdt?<%=request.getQueryString().replace("&", "$") %>";

	<% } else {	// 로그인 상태면 해당 위치로 전송시킴 %>
		var lnk = "";
		if (chk == 'c')	lnk = "cart_proc.ord";	// 장바구니 담기일 경우 이동할 경로
		else			lnk = "order_form.ord";	// 바로 구매일 경우 이동할 경로

		var frm = document.frmPdt;
		frm.action = lnk;
		frm.submit();
	<% } %>
}
</script>
<!-- 상품 상세보기 영역 시작 -->
<article class ="pdt_detail">
	<div class ="pdt_detail_inner">
		<!-- 상품 상세보기 대표 이미지 & 가격(주문) 영역 시작 -->
		<section class="img_price">
		<div class="img_price_area">
			<!-- 상품 이미지 영역 시작 -->
			<div class="img_area">
				<div class="img_big_area">
					<img src="page/product/img/<%=pdt.getPi_img1() %>" id="bigImg" width="380px" height="380px" alt="상품이미지"/>
				</div>
				<div class="img_small_area">
					<ul class="pdt_thumb_list">
						<li><img src="page/product/img/<%=pdt.getPi_img1() %>" width="100px" height="100px" alt="상품이미지1" onclick="chImg('<%=pdt.getPi_img1()%>');"/></li>
						<li><img src="page/product/img/<%=pdt.getPi_img2() %>" width="100px" height="100px" alt="상품이미지2" onclick="chImg('<%=pdt.getPi_img2()%>');"/></li>
						<li><img src="page/product/img/<%=pdt.getPi_img3() %>" width="100px" height="100px" alt="상품이미지3" onclick="chImg('<%=pdt.getPi_img3()%>');"/></li>
					</ul>
				</div>
			</div>
			<!-- 상품 이미지 영역 종료  -->
			<!-- 상품 가격(주문) 영역 시작 -->	
			<div class="price_area">			
			<div class="price_area_inner">			
				<p class="pdt_name"><%=pdt.getPi_name() %></p>			
				<p class="price">
					<% if(pdt.getPi_discount() != 0){ %><span class="price1" ><%=decFormat.format(price) %></span><% } %>&nbsp;
					<% if(pdt.getPi_discount() != 0){ %><span class="price2"><%=Math.round(pdt.getPi_discount() * 100) %>%</span><% } %>&nbsp;
					<span class="price3" id="price3"><%=decFormat.format(Math.round(price * (1 - pdt.getPi_discount()))) %>원</span>
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
								<button type="button" class="btnCal_cminus" name="cminus" id="cminus" value="-" onclick="changeCnt(this.value)" ></button>
								<input type="text" name="cartCnt" id="cartCnt" value="1" readonly  style="height:28px;"/>
								<button type="button" class="btnCalc_cplus" name="cplus" id="cplus" value="+" onclick="changeCnt(this.value)" ></button>
							</span>
						</div>
					</div>					
				</div>
				<form name="frmPdt" method="post">
				<input type="hidden" name="pocidx" value="0" />
		 		<input type="hidden" name="piid" value="<%=pdt.getPi_id() %>" />		 		
				<input type="hidden" name="cpage" value="<%=pdtPageInfo.getCpage() %>" />
				<input type="hidden" name="psize" value="<%=pdtPageInfo.getPsize() %>" />
				<input type="hidden" name="keyword" value="<%=pdtPageInfo.getKeyword() %>" />
				<input type="hidden" name="cata" value="<%=pdtPageInfo.getCata() %>" />
				<input type="hidden" name="sort" value="<%=pdtPageInfo.getSort() %>" /> 
				<input type="hidden" name="poccnt" value="1" />
				<input type="hidden" name="wtype" value="in" />
				<div class="pdt_total_price">
					<div class="pdt_total_line">
						<span class="tp_titl">상품금액 합계</span>					
						<span id="total"><%=decFormat.format(Math.round(price * (1 - pdt.getPi_discount()))) %>원</span>
					</div>
				</div>
				<div class="pdt_btn_area">
					<button class="btn" id="btn01" name="ordcart" id="ordcart" onclick="cartBuy('c'); return false;"><span>장바구니</span></button>
					<button class="btn" id="btn01" name="diord" id="diord" onclick="cartBuy('d'); return false;"><span>바로구매</span></button>
					<div id="zzim" name="zzim" id="zzim" >
						 <img src="img/heart_empty.png " width="35px" height="35px" class="heart" onclick="heartFlag(this);" /> 
					</div>
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
				<div id="cuReview"> 					
					<div id="cuReview_1">고객리뷰</div>
					<div id="cuReview_2">
 						<p style="WIDTH:<%=pdt.getPi_score() / 5.0 * 100 %>%;">
 						</p>
					</div>
					<div id="cuReview_3">평점(<%=String.format("%.2f", pdt.getPi_score()) %>)</div> 
				</div>									
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
						<img src="page/product/img/<%=pdt.getPi_desc() %>" width="1100px" height="4670px" alt="상품설명이미지" />
					</div>
					<!-- 상품 상세 리뷰 영역 시작 -->
					<div class="content2">
					<h2>리뷰</h2>
<%
if(reviewList.size() > 0 && revPageInfo.getRrcnt() > 0){	// 보여줄 후기 목록이 있으면
	int num = revPageInfo.getRrcnt() - (revPageInfo.getRpsize() * (revPageInfo.getRcpage() - 1));
	for (int i = 0; i < reviewList.size(); i++){		
		ReviewList rl = reviewList.get(i);						 	
%>	 				
						<div class="review_area">
							<div id="revinfo">
								<span id="revwriter"><%=rl.getMi_id() %></span>
								<div id="revscore1">
									<p style="WIDTH:<%=rl.getRl_score() / 5.0 * 100 %>%;"></p>
								</div>							
								<span id="revdate"><%=rl.getRl_date().substring(0, 10) %></span>
							</div>
							<p id="revcontent"><%=rl.getRl_content() %></p>							
							<div class="revbottom_area">
								<div id="good_report_area">
									<a href="javascript:plusLike(<%=rl.getRl_idx() %>, <%=rl.getRl_good() %>);">
									<img src="img/free-icon-thumb-up-20664.png" width="30px" height="30px"/></a>
									<span id="good<%=rl.getRl_idx() %>" style='font-weight:bold; padding-bottom:px;'><%=rl.getRl_good() %></span>			
								</div>
								</div>
						</div>
<%
if(rl.getRl_img() != null) {
%>						
					<p id="revimg"><img src="" width="80px;" height="80px;" alt="후기사진" /></p>
						
<% 	
}
		num--;
	}	
} else {
	out.println("<div style ='margin:10px 0 0 30px; font-size:15px; font-weight:bold; '>작성된 후기가 없습니다.</div>");
}

%>
					 <!-- 상품 상세 리뷰 영역 종료 -->					
					</div>
					<div class="content3">
						<img src="page/product/img/refund_info.png" width="1100px" height="600px"  alt="교환/환불 안내"/>					
					</div>
				</div>
			</div>
		</div>
		</section>			
	</div>	
</article>
<%@ include file ="../../include/footer.jsp" %>
<!-- list_detail js 연결  -->
<script type="text/javascript" src="js/pdt_view.js"></script>
</body>
</html>