// 상품 bigimg swap
function chImg(img){
	var big = document.getElementById("bigImg");
	big.src = "img/a101_info_" + img + ".jpg";
  }

// 상품 수량 숫자만 입력 & 1부터 99까지 범위 지정
function onlyNum(obj) {
	if (isNaN(obj.value))	obj.value = "";
	if (obj.value >99 )	{	
		obj.value = "" ; alert("구매는 1개 부터 99개 까지 가능합니다."); 
	}
}

// 상품 설명 tab 클릭시 해당 위치로 스크롤
const lis = document.querySelectorAll(".pdt_detail_tab li")
const contents = document.querySelectorAll(".content")
const firstTop = contents[0].offsetTop
const secondTop = contents[1].offsetTop
const thirdTop = contents[2].offsetTop
 
lis[0].onclick = function(){
  window.scroll({top:firstTop, behavior: 'smooth'})
}
lis[1].onclick = function(){
  window.scroll({top:secondTop, behavior: 'smooth'})
}
lis[2].onclick = function(){
  window.scroll({top:thirdTop, behavior: 'smooth'})
}


$(function( ) {
	$(window).scroll(function() { 
		if ($(this).scrollTop() > 200) { 
			$('#btntoTop').fadeIn(); } 
		else { $('#btntoTop').fadeOut(); }
	}); 
	$("#btntoTop").click(function() { 
   	$('html, body').animate({ scrollTop : 0  }, 200); 
    return false; });
});