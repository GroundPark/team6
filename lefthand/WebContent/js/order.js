/**
 * 
 */

function chkAddr(val) {
// 주소 콤보박스 선택 시 작업
	var zip = document.frmOrder.poi_zip;
	var addr1 = document.frmOrder.poi_addr1;
	var addr2 = document.frmOrder.poi_addr2;
	if (val == "") {	// 새 주소 입력 시
		zip.value="";	addr1.value="";		addr2.value="";
	} else {
		zip.value = val.substring(0, 5);
		addr1.value = val.substring(6, val.lastIndexOf(":"));
		addr2.value = val.substring(val.lastIndexOf(":") + 1);
	}
	
}

function findAddr() {
// 주소 찾는 다음 API
	new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
		
        console.log(data);
        
    	var roadAddr = data.roadAddress; // 도로명 주소 변수
        var jibunAddr = data.jibunAddress; // 지번 주소 변수
        
        // 우편번호와 주소 정보를 해당 필드에 넣는다.
        document.getElementById('poi_zip').value = data.zonecode;
        if(roadAddr !== ''){
            document.getElementById("poi_addr1").value = roadAddr;
        } 
        else if(jibunAddr !== ''){
            document.getElementById("poi_addr2").value = jibunAddr;
            }
        }
    }).open();
}

function chkPoint(amt,pnt,min,unit) {
// 포인트 사용 시 유효성 검사
//input값을 전체 마일리지로 설정 > minusPoint 
//amt : 최초 결제 금액 / pnt : 사용가능,남은 포인트 / min : 사용 가능 최소 포인트 / unit : 사용단위
	var v_point = 0; //사용할 포인트 (input 입력값)

	if (document.getElementById("chk_use").checked)  
	{
		if (pnt < min)  //최소 사용 단위보다 작을 때
		{
			v_point = 0; 
		}else {
			v_point = pnt - pnt%unit; //사용할 포인트 = 전체 마일리지 중 최소단위 이하 마일리지를 뺀 포인트
		}

		if(pnt > amt ){ //결제금액보다 포인트가 더 클 때
			v_point = amt; //사용할 포인트는 결제금액과 동일하게 설정
		}
		
	}
	document.getElementById("use_pnt").value = v_point; //input 값 설정

	changePoint(amt,pnt,min,unit);
}
	
function changePoint(amt,pnt,min,unit, delipay){
//input값을 불러옴 > left_pnt 변경 > 최종결제 변경
//amt : 최초 결제 금액 / pnt : 사용가능,남은 포인트 / min : 사용 가능 최소 포인트 / unit : 사용단위
	var v_point = 0;
	v_point = parseInt(document.getElementById("use_pnt").value); //사용할 포인트 (input 입력값)
	if (v_point > pnt) //입력값이 사용가능 포인트보다 클때
	{
		v_point = pnt;
		document.getElementById("use_pnt").value = v_point; //input 값 재설정
	}

	if(v_point > amt ){ //결제금액보다 포인트가 더 클 때
		v_point = amt; //사용할 포인트는 결제금액과 동일하게 설정
		document.getElementById("use_pnt").value = v_point; //input 값 재설정
	}

	if (v_point < min)  //최소 사용 단위보다 작을 때
	{
		v_point = 0; 
		document.getElementById("use_pnt").value = v_point; //input 값 재설정
	}else {
		v_point = v_point - v_point%unit; //사용할 포인트 = 사용할 마일리지 중 최소단위 이하 마일리지를 뺀 포인트
	}

	document.getElementById("result_pnt").innerHTML = v_point; // 사용할 포인트 출력
	
	var poipay = document.frmOrder.poipay;	// 히든으로 가져갈 총 결제금액
	poipay.value = amt - v_point + delipay;
	document.getElementById("highlight").innerHTML = poipay.value; 
}