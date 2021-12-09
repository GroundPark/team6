function enterkey() {
	if (window.event.keyCode == 13) {
    	// 엔터키가 눌렸을 때
		Examine();
    }
}

function Examine() {
	var frm = document.frmSch;
	var lnk = "";
	var sch_kind = frm.sch_kind.value;
	
	if (sch_kind == "상품") {
		lnk = "pdt_list.pdt";
	}
	else if(sch_kind == "펀딩"){
		lnk = "fdg_list.fdg";
	}else if(sch_kind == "도전"){
		lnk = "chal_list.chal";
	}
	
	frm.action = lnk;
	frm.submit();
	
}