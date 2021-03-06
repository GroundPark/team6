/**
마이페이지용 JS
**/

/* 장바구니 */
function chkAll(all) {	
// 목록의 체크박스를 클릭하면 아래 체크박스가 모두 클릭되도록 하는 함수
  var arrChk = document.frmCart.chk;	// 폼(frmCart) 안에 chk라는 이름의 컨트롤이 여러 개 있으므로 배열로 받아옴
  for (var i = 1 ; i < arrChk.length ; i++) {	// 0번은 hidden이므로 1번부터 도는 것도 좋음
	  arrChk[i].checked = all.checked;
  }
}

function choose(chk) {	
// 아래 체크박스들 중 하나라도 풀리면 맨 위 목록의 all 체크박스가 해제되도록 하는 함수
  if (!chk.checked) {	// chk가 체크가 풀렸으면
	  var all = document.frmCart.all;
	  all.checked = false;	// all 체크가 풀리도록
  }
}

function chCount(pocidx, poccnt) {	
// 장바구니 내의 특정 상품 수량을 변경시키는 함수(ocidx의 pk로, 변경시 where절의 조건으로 사용, occnt:변경할 수량 값)	
	$.ajax({
		type : "POST",						// 데이터 전송 방법
		url : "/cart_proc.ord",		// 데이터를 받을 서버의 URL로 컨트롤러(서블릿)를 의미 <%=args %>
		data : {"wtype" : "up", "pocidx" : pocidx, "poccnt" : poccnt},	// 지정한 url로 보낼 데이터의 이름 및 값
		success : function(chkRs) {			// 데이터를 보내어 실행한 결과를 chkRs로 받아옴(쿼리 성공을 의미)
			if (chkRs == 0) alert("선택한 상품 수량 변경에 실패했습니다.\n새로 고침 후 다시 시도해 주십시오.");
			else 			location.reload();	// 이론적으로는 깜빡이지만 표시도 안남
		}
	});
}

function getSelectedValues() {
// chk 체크박스들에서 선택한 체크박스의 값들만 추출하여 문자열로 리턴하는 함수(선택 상품 삭제와 선택 상품 구매에서 사용됨)
	var arrChk = document.frmCart.chk;	// 문서 내의 frmCart 폼 안에 있는 컨트롤들 중 chk라는 이름을 가진 컨트롤들을 배열로 받아옴(단, chk라는 이름의 컨트롤이 하나밖에 없으면 배열은 생성되지 않음)
	var idxs = "";	// chk 배열에서 추출한 값들을 저장할 변수
	for (var i = 1 ; i < arrChk.length ; i++) {	// 0번 인덱스가 아닌 1번부터 시작하는 이유는 chk라는 이름의 첫번째 컨트롤이 hidden이므로
		if (arrChk[i].checked)	idxs += "," + arrChk[i].value;
		// 체크된 체크박스의 value들만 추출하여 idxs에 누적 저장
	}
	// alert(idxs);
	return idxs.substring(1);	// idxs 변수에 누적된 문자열의 맨 앞에 있는 구분자(,)를 제거한 후 리턴
}

function buyChk() {		// 선택한 상품 구매 버튼 클릭 시 
	var pocidx = getSelectedValues();
	if (pocidx != "") {	// 구매하기 위해 선택할 상품이 있을 경우
		var frm = document.frmCart;
		frm.pocidx.value = pocidx;
		frm.submit();
	} else {	// 선택할 상품이 없을 경우
		alert("구매할 상품을 하나 이상 선택하세요.");	
	}
}

function buyAll() {		// 전체 상품 구매 버튼 클릭 시 
	
}
function callDel(pocidx) {
	var isConfirm = false;
	if (pocidx == 0) {	// 선택한 상품(들) 삭제 시(여러 상품 선택 시 여러 개의 oc_idx를 쉼표로 연결하여 문자열 생성, 상품을 하나도 선택하지 않았으면 경고메시지 출력)
		pocidx = getSelectedValues();	// 삭제하려고 선택한 oc_idx값을 받아옴
		if (pocidx != "") {	// 삭제할 상품들의 인덱스가 있으면
			isConfirm = confirm("선택한 상품들을 장바구니에서 삭제하시겠습니까?");
		} else {	// 삭제할 상품들의 인덱스가 없으면
			alert("삭제할 상품을 하나 이상 선택하세요.");	
		}
	} else {	// 특정 상품 삭제 시
		isConfirm = confirm("해당 상품을 장바구니에서 삭제하시겠습니까?");
	}
	
	if (isConfirm) {
		$.ajax({
			type : "POST",						// 데이터 전송 방법
			url : "/cart_proc.ord<%=args %>",		// 데이터를 받을 서버의 URL로 컨트롤러(서블릿)를 의미 
			data : {"wtype" : "del", "pocidx" : pocidx},	// 지정한 url로 보낼 데이터의 이름 및 값
			success : function(chkRs) {			// 데이터를 보내어 실행한 결과를 chkRs로 받아옴(쿼리 성공을 의미)
				if (chkRs == 0) alert("선택한 상품 삭제에 실패했습니다.\n새로 고침 후 다시 시도해 주십시오.");
				else 			location.reload();	
			}
		});
	}
}

function chAddr(val) {
// 주소 입력 
	var zip = document.frmOrder.oi_zip;
	var addr1 = document.frmOrder.oi_addr1;
	var addr2 = document.frmOrder.oi_addr2;
	if (val == "") {	// 새 주소 입력 시
		zip.value="";	addr1.value="";		addr2.value="";
	} else {
		zip.value = val.substring(0, 5);
		addr1.value = val.substring(6, val.lastIndexOf(":"));
		addr2.value = val.substring(val.indexOf(":") + 1);
	}
	
}