var flag = false;

// (마지막 수정자 : 박지상)

// ajax이용해서 좋아요 리스트에 update , delete 해야 함



function heartFlag(obj) {		
// obj : this(img 태그 자체를 뜻함) |  kind = 상품인지 펀딩인지 도전인지 구분(pdt,fund)  |   id = 상품or펀딩 id값을 의미

	flag = !flag;
	if (flag) {
		obj.src="img/heart_full.png";
/*		
		$.ajax({
			type : "POST",									// 데이터 전송 방법
			url : "/lefthand/!url넣어야함!",					// 데이터를 받을 서버의 URL로 컨트롤러(서블릿)를 의미
			data : { },										// 지정한 url로 보낼 데이터의 이름 및 값
			success : function(chkRs) {						// 데이터를 보내어 실행한 결과를 chkRs로 받아옴. (sucess : 실행했으면 뭐할건데? 라는 의미)
				if (chkRs == 0)	 	alert("좋아요 목록 추가에 실패했습니다.\n새로 고침 후 다시 시도해 주십시오.");
				else 				location.reload();
			}
		});
*/
	}else {
		obj.src="img/heart_empty.png";
/*		
		$.ajax({
			type : "POST",									// 데이터 전송 방법
			url : "/lefthand/!url넣어야함!",					// 데이터를 받을 서버의 URL로 컨트롤러(서블릿)를 의미
			data : { },										// 지정한 url로 보낼 데이터의 이름 및 값
			success : function(chkRs) {						// 데이터를 보내어 실행한 결과를 chkRs로 받아옴. (sucess : 실행했으면 뭐할건데? 라는 의미)
				if (chkRs == 0)	 	alert("좋아요 목록 추가에 실패했습니다.\n새로 고침 후 다시 시도해 주십시오.");
				else 				location.reload();
			}
		});
*/
	}
}

function sympathyFlag(obj) {		
	// obj : this(img 태그 자체를 뜻함)  만들어야함 -> |   id = 상품or펀딩 id값을 의미

		flag = !flag;
		if (flag) {
			obj.src="img/sympathy_fullG.png";
	/*		
			$.ajax({
				type : "POST",									// 데이터 전송 방법
				url : "/lefthand/!url넣어야함!",					// 데이터를 받을 서버의 URL로 컨트롤러(서블릿)를 의미
				data : { },										// 지정한 url로 보낼 데이터의 이름 및 값
				success : function(chkRs) {						// 데이터를 보내어 실행한 결과를 chkRs로 받아옴. (sucess : 실행했으면 뭐할건데? 라는 의미)
					if (chkRs == 0)	 	alert("좋아요 목록 추가에 실패했습니다.\n새로 고침 후 다시 시도해 주십시오.");
					else 				location.reload();
				}
			});
	*/
		}else {
			obj.src="img/sympathy_emptyG.png";
	/*		
			$.ajax({
				type : "POST",									// 데이터 전송 방법
				url : "/lefthand/!url넣어야함!",					// 데이터를 받을 서버의 URL로 컨트롤러(서블릿)를 의미
				data : { },										// 지정한 url로 보낼 데이터의 이름 및 값
				success : function(chkRs) {						// 데이터를 보내어 실행한 결과를 chkRs로 받아옴. (sucess : 실행했으면 뭐할건데? 라는 의미)
					if (chkRs == 0)	 	alert("좋아요 목록 추가에 실패했습니다.\n새로 고침 후 다시 시도해 주십시오.");
					else 				location.reload();
				}
			});
	*/
		}
	}