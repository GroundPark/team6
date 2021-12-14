<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");		// 페이징 정보
AdminFundingList adminFunding = (AdminFundingList)request.getAttribute("adminFunding");		// 게시글 정보

System.out.println("어드민펀딩폼업의 ordercnt : " + adminFunding.getFi_ordercnt());

String schtype = "", keyword = "";
String args = "?cpage=" + pageInfo.getCpage();		
//if(pageInfo.getKeyword() != null && !pageInfo.getKeyword().equals("")){
//	schtype = pageInfo.getSchtype();
//	keyword = pageInfo.getKeyword();
//	args += "&schtype=" + pageInfo.getSchtype() + "&keyword=" + pageInfo.getKeyword();
	// 검색조건이 있을 경우에만 schtype와 keyword에 정보를 저장하고... 검색 조건이 있을 경우에만 쿼리스트링으로 만들어줌
//}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.pdtForm { width:800px; }
.lablearea { display:inline-block; width:130px; padding:5px; }
.fieldarea { display:inline-block; width:300px; vertical-align:center; }
.form-control { width:260px; vertical-align:center; }
input[type=text] { width:250px; height:15px; }
label { text-align:left; }
</style>
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>
<main>
	<article>
	    <section>
			<h2>펀딩 상세보기</h2>
			<form name="frmFundingList" action="../admin/funding_up_proc.admin" method="post" class="pdtForm" role="form" >	
			<input type="hidden" name="fiidx" value="<%= adminFunding.getFi_idx() %>" />
			<input type="hidden" name="cpage" value="<%=pageInfo.getCpage() %>" />
			<input type="hidden" name="schtype" value="" />
			<input type="hidden" name="keyword" value="" />
			<div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_id" >펀딩 ID</label></div>
					<div class="fieldarea"><input type="text" name="fi_id" value="<%=adminFunding.getFi_id() %>" disabled="disabled" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_name" >제목</label></div>
					<div class="fieldarea"><input type="text" name="fi_name" value="<%=adminFunding.getFi_name() %>" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_desc" >내용<br />(설명이미지)</label></div>
					<div class="fieldarea"><input type="text" name="fi_desc" value="<%=adminFunding.getFi_desc() %>" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_img1" >이미지1</label></div>
					<div class="fieldarea"><input type="text" name="fi_img1" value="<%=adminFunding.getFi_img1() %>" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_img2" >이미지2</label></div>
					<div class="fieldarea"><input type="text" name="fi_img2" value="<%=adminFunding.getFi_img2() %>" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_img3" >이미지3</label></div>
					<div class="fieldarea"><input type="text" name="fi_img3" value="<%=adminFunding.getFi_img3() %>" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_price" >단가</label></div>
					<div class="fieldarea"><input type="text" name="fi_price" value="<%=adminFunding.getFi_price() %>" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_goal" >목표펀딩금액</label></div>
					<div class="fieldarea"><input type="text" name="fi_goal" value="<%=adminFunding.getFi_goal() %>" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_rate" >펀딩율</label></div>
					<div class="fieldarea"><input type="text" name="fi_rate" value="<%=adminFunding.getFi_rate() * 100 %> %" disabled="disabled" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_total" >펀딩금액</label></div>
					<div class="fieldarea"><input type="text" name="fi_total" value="<%=adminFunding.getFi_total() %>" disabled="disabled" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_support" >참여자 수</label></div>
					<div class="fieldarea"><input type="text" name="fi_support" value="<%=adminFunding.getFi_support() %>" disabled="disabled" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_good" >좋아요 수</label></div>
					<div class="fieldarea"><input type="text" name="fi_good" value="<%=adminFunding.getFi_good() %>" disabled="disabled" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_ordercnt" >주문 수량</label></div>
					<div class="fieldarea"><input type="text" name="fi_ordercnt" value="<%=adminFunding.getFi_ordercnt() %>" disabled="disabled" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_sdate" >시작일</label></div>
					<div class="fieldarea"><input type="text" name="fi_sdate" value="<%=adminFunding.getFi_sdate() %>" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_edate" >마감일</label></div>
					<div class="fieldarea"><input type="text" name="fi_edate" value="<%=adminFunding.getFi_edate() %>" /></div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_isview" >게시여부</label></div>
					<div class="fieldarea">
						<input type="radio" name="fi_isview" value="y" id="soldy" <% if(adminFunding.getFi_isview().charAt(0) == 'y' ) { %>checked <% } %> /><label for ="soldy">Y</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="fi_isview" value="n" id="soldn" <% if(adminFunding.getFi_isview().charAt(0) == 'n' ) { %>checked <% } %> /><label for ="soldn">N</label>
					</div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="fi_status" >진행상태</label></div>
					<div class="fieldarea">
						<ul id="admin_cmb_step" data-rule-required="true">
							<li>
								<select class="form-control" name="fi_status">
									<option value="a" <% if(adminFunding.getFi_status().equals("a")) { %>selected <% } %>>펀딩중</option>
									<option value="b" <% if(adminFunding.getFi_status().equals("b")) { %>selected <% } %>>펀딩성공</option>
									<option value="c" <% if(adminFunding.getFi_status().equals("c")) { %>selected <% } %>>펀딩실패</option>
								</select>
							</li>
						</ul>
					</div>
				</div>
				<div class="form_area">	
					<div class="lablearea"><label for ="ai_idx" >등록 관리자</label></div>
					<div class="fieldarea"><input type="text" name="ai_idx" value="<%=adminFunding.getAi_idx() %>" disabled="disabled" /></div>
				</div>
				<p id="button_area" style="width:940px; margin-top:20px;">
					<input type="button" value="돌아가기" onclick="location.href ='funding_list.admin';" style="width:120px; height:25px;"/>
					<input type="submit" value="수정" style="width:120px; height:25px;"/>
				</p>	
				</form>
		   </section>
		<!-- section 영역 종료 -->
	</article>
</main>
</body>
</body>
</html>