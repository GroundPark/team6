function setToday() {
	document.frmDate.y.value = "<%=si.getcYear() %>";
	document.frmDate.m.value = "<%=si.getcMonth() %>";
	document.frmDate.submit();
	 
}

function callProc() {
	var frm = document.frmSchedule;
	var y = frm.y.value;	var m = frm.m.value;	var d = frm.d.value;	var h = frm.h.value;	var n = frm.n.value;

	frm.stime.value = y + "-" + m  + "-" + d  + " " + h + ":" + n;
	frm.submit();
}