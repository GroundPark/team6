/* 아코디언 메뉴 */
$(document).ready(function() {
	$('.menu1').click(function() {
		$('.menu2').slideUp();
		if ($(this).children('.menu2').is(':hidden')){
			$(this).children('.menu2').slideDown();
		} else{
			$(this).children('.menu2').slideUp();
		}
	});
  });