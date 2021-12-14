<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.DecimalFormat" %>	<!-- 돈 표기 -->
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");
OrderInfo ord =(OrderInfo)request.getAttribute("orderInfo");
AdminOrderPdtPageInfo adminOrderPdtPageInfo = (AdminOrderPdtPageInfo)request.getAttribute("adminOrderPdtPageInfo");
ArrayList<OrderDetail> detailList = ord.getDetailList();

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
	<h2>상품 주문 내역</h2>
	<form name="frmAdminOrderPdt" action="order_pdt_proc.adminord" method="post" class="pdtForm">	
		<div id="box">
			<div class="form_area">	
				<div class="lablearea"><label for ="poi_id">주문번호</label></div>
				<div class="fieldarea"><input type="text" name="poi_id"  id="poi_id" value="<%=ord.getPoi_id() %>" readonly="readonly" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="poi_date">주문일</label></div>
				<div class="fieldarea"><input type="text" name="poi_date"  id="poi_date" value="<%=ord.getPoi_date() %>" readonly="readonly" /></div>
			</div>
			<table id="pdtList" width="90%" cellpadding="5" cellspacing="0">
			<tr><th width="20%">상품아이디</th><th width="*">상품명</th><th width="15%">수량(ea)</th><th width="20%">단가(원)</th></tr>
<% for (OrderDetail detail : detailList) { %>
			<tr align="center">
			<td><%=detail.getPi_id() %></td>
			<td><%=detail.getPod_pname() %></td>
			<td><%=detail.getPod_cnt() %></td>
			<td><%=formatter.format(detail.getPod_pprice()) %></td>
			</tr>
<% } %>
			</table>
			<div class="form_area">				
				<div class="lablearea"><label for ="mi_id">주문자 아이디</label></div>
				<div class="fieldarea"><input type="text" name="mi_id"  id="mi_id" readonly="readonly" value="<%=ord.getMi_id() %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="poi_name">주문자명</label></div>
				<div class="fieldarea"><input type="text" name="poi_name"  id="poi_name" readonly="readonly" value="<%=ord.getPoi_name() %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="poi_phone">전화번호</label></div>
				<div class="fieldarea"><input type="text" name="poi_phone"  id="poi_phone" value="<%=ord.getPoi_phone() %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="poi_zip">주소</label></div>
				<div class="fieldarea"><input type="text" name="poi_zip"  id="poi_zip" value="<%=ord.getPoi_zip() %>" /></div><br />
				<div class="lablearea"></div>
				<div class="fieldarea"><input type="text" name="poi_addr1"  id="poi_addr1" value="<%=ord.getPoi_addr1() %>" /></div><br />
				<div class="lablearea"></div>
				<div class="fieldarea"><input type="text" name="poi_addr2"  id="poi_addr2" value="<%=ord.getPoi_addr2() %>" /></div>
			</div>
<%
String memo = ord.getPoi_memo();
if (ord.getPoi_memo() == null)	memo = ""; 
						

String invoice = ord.getPoi_invoice();
if (ord.getPoi_invoice() == null)	invoice = ""; 

String aiidx = "";
if (ord.getAi_idx() != 0)	aiidx = ord.getAi_idx() + "";
%>
			<div class="form_area">				
				<div class="lablearea"><label for ="poi_memo">배송메모</label></div>
				<div class="fieldarea"><input type="text" name="poi_memo"  id="poi_memo" value="<%=memo %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="poi_invoice">송장번호</label></div>
				<div class="fieldarea"><input type="text" name="poi_invoice"  id="poi_invoice" value="<%=invoice %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="poi_status">주문상태</label></div>				
				<div class="fieldarea">
				<select name="poi_status" id="comboBox" >
					<option value="a" <% if(ord.getPoi_status().equals("a")) { %> selected="selected" <% }%>>배송준비중</option>
					<option value="b" <% if(ord.getPoi_status().equals("b")) { %> selected="selected" <% }%>>배송중</option>
					<option value="c" <% if(ord.getPoi_status().equals("c")) { %> selected="selected" <% }%>>배송완료</option>
				</select>
				</div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="poi_price">결제액</label></div>
				<div class="fieldarea"><input type="text" name="poi_price"  id="poi_price" readonly="readonly" value="<%=formatter.format(ord.getPoi_pay()) %> 원" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="poi_point">사용 포인트</label></div>
				<div class="fieldarea"><input type="text" name="poi_point"  id="poi_point" readonly="readonly" value="<%=formatter.format(ord.getPoi_point()) %> p" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="poi_modify">최종 수정일</label></div>
				<div class="fieldarea"><input type="text" name="poi_modify"  id="poi_modify" readonly="readonly" value="<%=ord.getPoi_modify() %>" /></div>
			</div>
			<div class="form_area">				
				<div class="lablearea"><label for ="ai_idx">관리자 번호</label></div>
				<div class="fieldarea"><input type="text" name="ai_idx"  id="ai_idx" readonly="readonly" value="<%=aiidx %>" /></div>
			</div>
			
			<p id="button_area" style="width:100%; margin-top:20px;">
				<input type="button" class="btn" value="돌아가기" onclick="location.href ='order_pdt.adminord';" style="width:120px; height:25px;"/>
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