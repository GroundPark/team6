<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>	<!-- 돈 표기 -->
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mypage.css" />
<script src="js/jquery-3.6.0.js"></script>

</head>
<body>
<header>
<%@ include file="../../include/header.jsp" %>
</header>
<%
request.setCharacterEncoding("utf-8");
if (!isLogin) {
	out.println("<script>");
	out.println("alert('로그인 후 사용하세요.');");
	out.println("location.href='login_form.jsp?url=cart_list.ord';");
	out.println("</script>");
	out.close();
}

//[계속 쇼핑]버튼 클릭시 이동할 경로에 붙일 쿼리 스트링 생성
PdtPageInfo pageInfo = (PdtPageInfo)request.getAttribute("pdtPageInfo");
String args = "?cpage=" + pageInfo.getCpage() + "&psize=" + pageInfo.getPsize();
if (pageInfo.getKeyword() != null && !pageInfo.getKeyword().equals(""))	args += "&keyword=" + pageInfo.getKeyword();
if (pageInfo.getCata() != null && !pageInfo.getCata().equals(""))		args += "&cata=" + pageInfo.getCata();
if (pageInfo.getSort() != null && !pageInfo.getSort().equals(""))		args += "&sort=" + pageInfo.getSort();

//현 화면에서 보여줄 장바구니에 담긴 상품들의 목록
ArrayList<CartInfo> cartList = (ArrayList<CartInfo>)request.getAttribute("cartList");
CartInfo cart = new CartInfo();	

// 돈 표기를 위한 인스턴스 생성
DecimalFormat formatter = new DecimalFormat("#,##0");
%>
<script>
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
// 장바구니 내의 특정 상품 수량을 변경시키는 함수(pocidx는 pk로, 변경시 where절의 조건으로 사용, poccnt:변경할 수량 값)	
	$.ajax({	
		type : "POST",						
		url : "cart_proc.ord<%=args %>",
		data : {"wtype" : "up", "pocidx" : pocidx, "poccnt" : poccnt},
		success : function(chkRs) {			
			if (chkRs == 0) alert("선택한 상품 수량 변경에 실패했습니다.\n새로 고침 후 다시 시도해 주십시오.");
			else 			location.reload();	
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
	var pocidx = "";
	var frm = document.frmCart;
	frm.pocidx.value = pocidx;
	frm.submit();
}

function callDel(pocidx) {	// 삭제 버튼 클릭 시
	var isConfirm = false;
	if (pocidx == 0) {	// 선택한 상품(들) 삭제 시(여러 상품 선택 시 여러 개의 poc_idx를 쉼표로 연결하여 문자열 생성, 상품을 하나도 선택하지 않았으면 경고메시지 출력)
		pocidx = getSelectedValues();	// 삭제하려고 선택한 poc_idx값을 받아옴
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
			type : "POST",						
			url : "cart_proc.ord<%=args %>",
			data : {"wtype" : "del", "pocidx" : pocidx},
			success : function(chkRs) {			
				if (chkRs == 0) alert("선택한 상품 삭제에 실패했습니다.\n새로 고침 후 다시 시도해 주십시오.");
				else 			location.reload();	
			}
		});
	}
}
</script>
<!-- mypage 영역 시작 -->
<%@ include file="../../include/incMypage.jsp" %>
<!-- mypage 영역 종료 -->
</article>	
<!-- 간단 정보 영역 종료 -->

<!-- 장바구니 리스트 영역 시작 -->
<article id="cartListBox">
<h2>장바구니 ( <%=cartList.size() %> )</h2><br />
<form name="frmCart" action="order_form.ord" method="post">
<input type="hidden" name="chk" value="" />	<!-- 장바구니에 하나만 담겼을 경우는 배열이 아니기 때문에 걔를 배열로 만들어주려고 -->
<input type="hidden" name="pocidx" value="" />
<table width="950" cellpadding="10" cellspacing="0" id="cartTable">
<tr>
<th width="5%"><input type="checkbox" name="all" checked="checked" onclick="chkAll(this);" /></th>
<th width="15%">상품</th><th width="*">상품명</th>
<th width="10%">수량</th><th width="20%">구매가</th><th width="10%">삭제</th>
</tr>
<%
if (cartList.size() > 0) {	// 장바구니에 상품이 들어 있으면
	int total = 0;	// 총 구매가격을 저장할 변수
	int delipay = 0;	// 배송비를 저장할 변수
	for (int i = 0 ; i < cartList.size() ; i++) {
		cart = cartList.get(i);
		String lnk = "<a href='pdt_view.pdt" + args + "&piid=" + cart.getPi_id() + "'>";
		
		int max = cart.getPi_stock();	// 남은 재고량
		if (max == -1 || max > 100)		max = 100;	// 재고가 무제한이거나 100을 넘을 경우 최대값으로 100을 지정
%>
<tr align="center">
<td><input type="checkbox" name="chk" value="<%=cart.getPoc_idx() %>" checked="checked" onclick="choose(this);" /></td>
<td align="center">
	<%=lnk %><img src="page/product/img/<%=cart.getPi_img1() %>" width="100" height="100" align="absmiddle" /></a>
	<!-- 합본이랑 민지씨 환경 다른거 주의 : 합본은 앞에 안붙이고... 민지씨 환경에서는 / 붙여야함 -->
</td>
<td><%=cart.getPi_name() %></td>
<td>
	<select name="cnt<%=cart.getPoc_idx() %>" class="optCmb" onchange="chCount(<%=cart.getPoc_idx() %>, this.value);">
<%		for (int j = 1 ; j <= max ; j++) { %>
		<option value="<%=j %>" <% if (j == cart.getPoc_cnt()) { %>selected="selected"<% } %>><%=j %></option>
<% 		} %>
	</select>
</td>
<td><del><%=formatter.format(cart.getPi_price() * cart.getPoc_cnt())  %></del><br />
<strong class="highlight2"><%=formatter.format(((cart.getPi_price() * (1 - cart.getPi_discount())) * cart.getPoc_cnt()))%></strong></td>
<%
	total += ((cart.getPi_price() * (1 - cart.getPi_discount())) * cart.getPoc_cnt());
	
	if (total < 30000)	delipay = 2500;
	else				delipay = 0;
%>
<td><input type="button" value="삭제" class="btn" id="delBtn" onclick="callDel(<%=cart.getPoc_idx() %>);" /></td>
</tr>
<%
}
%>
</table>
<table width="950" cellpadding="15" cellspacing="0">
<tr>
<td width="*" height="50px">
	<input type="button" value="선택 상품 구매" class="btn" onclick="buyChk();"/>
	<input type="button" value="선택 상품 삭제" class="btn" onclick="callDel(0);" />
</td>
<td width="400" align="right">총 구매가격 : <%=formatter.format(total) %> + <%=formatter.format(delipay) %> (배송비) = <strong id="total"><%=formatter.format(total + delipay) %></strong> 원</td>
</tr>
<tr><td colspan="2" align="center">
	<input type="button" value="계속 쇼핑" class="btn" onclick="location.href='pdt_list.pdt<%=args %>';" />&nbsp;&nbsp;&nbsp;
	<input type="button" value="전체 구매" class="btn" onclick="buyAll();"/>
</td></tr>
<%
} else {	// 장바구니가 비었으면
%>
<tr><td colspan="6" height="100px" align="center">장바구니가 비었습니다.</td></tr>
<tr><td colspan="6" align="center" style="border-bottom:0;">
	<input type="button" value="계속 쇼핑" class="btn" onclick="location.href='pdt_list.pdt<%=args %>';" />
</td></tr>
<%
}
%>
</table>
</form>
</article>
<!-- 장바구니 리스트 영역 종료 -->
</section>
<!-- footer 영역 시작 -->
<%@ include file="../../include/footer.jsp" %>
<!-- footer 영역 종료 -->
</body>
</html>