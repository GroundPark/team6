<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="funding_info.css" />
<body>
<div class="pdt_contents" >
	<script>
	$(document).ready(function() {
		$("#img1").click(function() {
			$("#bigImg").attr("src", $(this).attr("src"))
			// id가 bigImg인 개체의 src속성 값을 변경
			// 이벤트를 일으킨 객체(this)의 src 속성값을 bigImg의 src 속성에 넣어줌
		});
		$("#img2").click(function() {
			$("#bigImg").attr("src", $(this).attr("src"))
		});
		$("#img3").click(function() {
			$("#bigImg").attr("src", $(this).attr("src"))
		});
	});
	
	$(document).ready(function() {
		$("#minus").click(function() {
			if ($("#num").val() > 1) {
				$("#num").attr("value", parseInt($("#num").val()) - 1);
				$("#totalprice").text(2500 * $("#num").val())
			}
		});
	});
	
	$(document).ready(function() {
		$("#plus").click(function() {
			$("#num").attr("value", parseInt($("#num").val()) + 1)
			$("#totalprice").text(2500 * $("#num").val())
		});
	});
	$(document)
	</script>
<div id="fundinginfo">
	<div class="fundinginfo">
		<div id="fundingname">제목</div>
		<div id="fundingmainimg"><img src="./img/fd101_info_1.jpg" id="bigImg" id="bigImg" /></div>
			<ul id="fundingimgs">
				<li><img src="./img/fd101_info_1.jpg" id="img1" class="hand" /></li>
				<li><img src="./img/fd101_info_2.jpg" id="img2" class="hand" /></li>
				<li><img src="./img/fd101_info_3.jpg" id="img3" class="hand" /></li>
			</ul>
		<div id="fundingdesc">설명</div>
	</div>
	<div id="fundinginfodesc">
		????.??.?? ~ ????.??.??<br /><br /><br />
		???% 달성<br /><br /><br />
		총 ?????원<br /><br /><br />
		??? 명 참여
	</div>
	<div id="fundinglike"><input type="button" value="좋아요  ♡" id="fundinglikebtn" /></div>
	<div id="fundinginquiry"><a href="#">문의하기</a></div>
	<div id="fundingprice">2500 원</div>
	<div id="fundingnum"><input type="button" value="-" class="plusminus" id="minus" /> <input type="text" class="num" id="num" value="1" readonly /> <input type="button" value="+" class="plusminus" id="plus" /></div>
	<div id="fundingtotalprice">총 가격 <span id="totalprice">2500</span>원</div>
	<div id="funding"><a href="#">펀딩하기</a></div>
	<div id="fundingdescimg"><img src="./img/fd101_info_desc.jpg" id="descImg" /></div>
	<div id="desc"></div>
	<div id="plicy"></div>
	<div id="qna"></div>
	<ul id="fundingdesclink">
		<li><a href="#desc" class="hand">설명</a></li>
		<li><a href="#plicy" class="hand">변환정책</a></li>
		<li><a href="#qna" class="hand">Q&A</a></li>
	</ul>
	</div>
</div>
</body>
<%@ include file="../../include/footer.jsp" %>