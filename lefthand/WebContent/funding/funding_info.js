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
	
	$(document).ready(function() {
		$("#fundinglikebtn").click(function() {
			if ($("#fundinglikebtn").val() == "좋아요 ♡") {
				$("#fundinglikebtn").attr("value", "좋아요 ♥");
			} else {
				$("#fundinglikebtn").attr("value", "좋아요 ♡");
			}
		});
	});