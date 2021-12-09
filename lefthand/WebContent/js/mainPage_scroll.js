function scrollableElement(elements){	
// scrollTop을 사용할 수 있는 요소를 리턴하는 함수
	var i, len, el, $el, scrollable;
	for (i = 0, len = arguments.length ; i < len ; i++ ) {
	// i : 루프를 위한 변수, len : 매개변수(argument)의 개수를 저장하기 위한 변수
		el = arguments[i];
		// i인덱스에 해당하는 매개변수를 el에 저장
		$el = $(el);
		// el을 객체화 시킴
		if ($el.scrollTop() > 0) {
		// 해당 객체($el)의 스크롤바 상단 값이 0보다 크면(해당 객체로 스크롤이 움직였으면)
			return el;
			// 해당 객체를 리턴
		}else {
			$el.scrollTop(1);
			scrollable = $el.scrollTop() > 0;
			$el.scrollTop(0);
			if (scrollable) {
				return el;
			}
			// 인위적으로 $el의 scrollTop값을 조절하여 리턴
		}
	}
	return [];
}

$(document).ready(function() {
	$(".back-to-top").each(function() {
	// 해당 선택자에 대해 무한 루프를 돌면서 작업함
		var $el = $(scrollableElement("html", "body"));
		// 데이터타입을 지정하지 않으니 인수를 2개써도 무관.. (제대로 이해하진 못함 jq가 봐주는거라고 함)
		// html과 body 중 스크롤이 가능한 요소를 감지
		$(this).click(function(evt) {
			evt.preventDefault();
			// 현재 이벤트의 기본 동작을 중단시키는 기능
			$el.animate({ scrollTop:0 }, 250);
			// 스크롤을 일으킨 객체($el)의 scrollTop 값을 0으로 지정
		});
	});
});
