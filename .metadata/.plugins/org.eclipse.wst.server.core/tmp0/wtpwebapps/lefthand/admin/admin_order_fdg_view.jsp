<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.DecimalFormat" %>	<!-- 돈 표기 -->
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");
FdgOrderInfo fdgOrd =(FdgOrderInfo)request.getAttribute("fdgOrderInfo");
AdminOrderFdgPageInfo adminOrderFdgPageInfo = (AdminOrderFdgPageInfo)request.getAttribute("adminOrderFdgPageInfo");
ArrayList<FdgOrderDetail> detailList = fdgOrd.getFdgDetailList();

DecimalFormat formatter = new DecimalFormat("#,##0"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.pdtForm { border:0px solid black; width:100%; margin:0 auto; }
.lablearea { border:0px solid black; text-align:left; display:inline-block; width:100px; padding:5px; margin-left:-185px;}
.fieldarea { display:inline-block; width:300px; padding:5px; vertical-align:center; }
input[type=text] { width:440px; height:10px; padding:7px; }
input:read-only { background-color:#efefef; border:1px solid #a1a1a1; }  
label { text-align:left; font-weight:bold;  }
#comboBox { width:455px; padding:3px; margin-left:0px;}

#box { width:600px; margin:0 auto; border:0px solid black; }
#pdtList { border:0px solid black; margin:15px 0; width:95%; }
#pdtList th { text-align:center; font-weight:bold; border-bottom:1px double #a1a1a1; border-top:1px double #a1a1a1; padding:3px; }
#pdtList td { border-bottom:1px solid #a1a1a1; padding:3px; } 
.btn:hover { background:#F2A649; cursor:pointer; }
</style>
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>
<!-- main 영역 시작 -->
<main>
<article>
	<!-- section 영역 시작 -->
	<section>
	<h2>펀딩 주문 내역</h2>
	<form name="frmAdminOrderFdg" action="order_fdg_proc.adminord" method="post" class="pdtForm">	
		<div id="box">
			<div class="form_area">	
				<div class="lablearea"><label for ="foi_id">주문번호</label></div>
				<div class="fieldarea"><input type="text" name="foi_id"  id="foi_id" value="<%=fdgOrd.getFoi_id() %>" readonly="readonly" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="foi_date">주문일</label></div>
				<div class="fieldarea"><input type="text" name="foi_date"  id="foi_date" value="<%=fdgOrd.getFoi_date() %>" readonly="readonly" /></div>
			</div>
			<table id="pdtList" width="90%" cellpadding="5" cellspacing="0">
			<tr><th width="20%">펀딩아이디</th><th width="*">펀딩명</th><th width="15%">수량(ea)</th><th width="20%">단가(원)</th></tr>
<% for (FdgOrderDetail detail : detailList) { %>
			<tr align="center">
			<td><%=detail.getFi_id() %></td>
			<td><%=detail.getFod_pname() %></td>
			<td><%=detail.getFod_cnt() %></td>
			<td><%=formatter.format(detail.getFod_pprice()) %></td>
			</tr>
<% } %>
			</table>
			<div class="form_area">				
				<div class="lablearea"><label for ="mi_id">주문자 아이디</label></div>
				<div class="fieldarea"><input type="text" name="mi_id"  id="mi_id" readonly="readonly" value="<%=fdgOrd.getMi_id() %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="foi_name">주문자명</label></div>
				<div class="fieldarea"><input type="text" name="foi_name"  id="foi_name" readonly="readonly" value="<%=fdgOrd.getFoi_name() %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="foi_phone">전화번호</label></div>
				<div class="fieldarea"><input type="text" name="foi_phone"  id="foi_phone" value="<%=fdgOrd.getFoi_phone() %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="foi_zip">주소</label></div>
				<div class="fieldarea"><input type="text" name="foi_zip"  id="foi_zip" value="<%=fdgOrd.getFoi_zip() %>" /></div><br />
				<div class="lablearea"></div>
				<div class="fieldarea"><input type="text" name="foi_addr1"  id="foi_addr1" value="<%=fdgOrd.getFoi_addr1() %>" /></div><br />
				<div class="lablearea"></div>
				<div class="fieldarea"><input type="text" name="foi_addr2"  id="foi_addr2" value="<%=fdgOrd.getFoi_addr2() %>" /></div>
			</div>
<%
String memo = fdgOrd.getFoi_memo();
if (fdgOrd.getFoi_memo() == null)	memo = ""; 
						

String invoice = fdgOrd.getFoi_invoice();
if (fdgOrd.getFoi_invoice() == null)	invoice = ""; 

String aiidx = "";
if (fdgOrd.getAi_idx() != 0)	aiidx = fdgOrd.getAi_idx() + "";
%>
			<div class="form_area">				
				<div class="lablearea"><label for ="foi_memo">배송메모</label></div>
				<div class="fieldarea"><input type="text" name="foi_memo"  id="foi_memo" value="<%=memo %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="foi_invoice">송장번호</label></div>
				<div class="fieldarea"><input type="text" name="foi_invoice"  id="foi_invoice" value="<%=invoice %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="foi_status">주문상태</label></div>				
				<div class="fieldarea">
				<select name="foi_status" id="comboBox" >
					<option value="a" <% if(fdgOrd.getFoi_status().equals("a")) { %> selected="selected" <% }%>>입금대기중</option>
					<option value="b" <% if(fdgOrd.getFoi_status().equals("b")) { %> selected="selected" <% }%>>결제완료</option>
					<option value="c" <% if(fdgOrd.getFoi_status().equals("c")) { %> selected="selected" <% }%>>물품제작중</option>
					<option value="d" <% if(fdgOrd.getFoi_status().equals("d")) { %> selected="selected" <% }%>>배송준비중</option>
					<option value="e" <% if(fdgOrd.getFoi_status().equals("e")) { %> selected="selected" <% }%>>배송중</option>
					<option value="f" <% if(fdgOrd.getFoi_status().equals("f")) { %> selected="selected" <% }%>>배송완료</option>
				</select>
				</div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="foi_price">결제액</label></div>
				<div class="fieldarea"><input type="text" name="foi_price"  id="foi_price" readonly="readonly" value="<%=formatter.format(fdgOrd.getFoi_pay()) %> 원" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="foi_modify">최종 수정일</label></div>
				<div class="fieldarea"><input type="text" name="foi_modify"  id="foi_modify" readonly="readonly" value="<%=fdgOrd.getFoi_modify() %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="ai_idx">관리자 번호</label></div>
				<div class="fieldarea"><input type="text" name="ai_idx"  id="ai_idx" readonly="readonly" value="<%=aiidx %>" /></div>
			</div>
			
			<p id="button_area" style="width:100%; margin-top:20px;">
				<input type="button" class="btn" value="돌아가기" onclick="location.href ='order_fdg.adminord';" style="width:120px; height:25px;"/>
				&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="수정" class="btn" style="width:120px; height:25px;"/>
			</p>
		</div>
		</form>					
	</section>
	<!-- section 영역 종료 -->
</article>
</main>
<!-- main 영역 종료 -->
</body>
</html>