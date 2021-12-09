
// 상품 bigimg swap
function chImg(img){
	var big = document.getElementById("bigImg");
	big.src = "page/product/img/" + img;
  }


//상품 설명 tab 클릭시 해당 위치로 스크롤
function fnMove(seq){
    var offset = $(".content" + seq).offset();
    $('html, body').animate({scrollTop : offset.top}, 500);
}

