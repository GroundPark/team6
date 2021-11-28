
// 상품 bigimg swap
function chImg(img){
	var big = document.getElementById("bigImg");
	big.src = "page/product/img/" + img;
  }

// 상품 수량 숫자만 입력 & 1부터 99까지 범위 지정
function onlyNum(obj) {
	var total = document.getElementById("total");
	var price3 = String(document.getElementById("price3").innerHTML);
	var panmega = parseInt(price3.replace(/,/g, ""));
	
	if (isNaN(obj.value))	obj.value = "";
	if (obj.value > 99 )	{	
		obj.value = "" ; alert("구매는 1개 부터 99개 까지 가능합니다."); 
	}
	
	if(panmega != null){
		total.innerHTML = parseInt(obj.value * panmega);
	}	
}

//상품 설명 tab 클릭시 해당 위치로 스크롤
function fnMove(seq){
    var offset = $(".content" + seq).offset();
    $('html, body').animate({scrollTop : offset.top}, 500);
}

