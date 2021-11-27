<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%


%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#brd th { border-top:2px solid #aaa; border-bottom:1px #aaa solid; text-align:center; font-weight:bold; background:#ddd; }
#brd tr:last-child > td { border-bottom:2px #aaa solid; }
#brd { padding-bottom:20px; }
#btn { width:100%; }
section #cata { float:left; padding-left:0px; }
section #sort { float:right; padding-right:40px; }
section #cata li { display:inline-block; padding-bottom:10px; }
section #search { width:100px; }
</style>
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>
<!-- main 영역 시작 -->
<main>
	<article>
		<!-- section 영역 시작 -->
	    <section>
		    <h2>상품 목록</h2>
			<h2>검색 창</h2>
			<ul id="cata">
				<li><select class="hand">
					<option value="전체">전체</option>
					<option value="가위">가위</option> 
					<option value="문구">문구</option>
					<option value="주방">주방</option>
					<option value="etc">etc</option>
				</select></li>
				<li><input type="text" id="search" /></li>
			</ul>
			<ul id="sort">
				<li><select class="hand">
					<option value="전체">전체</option>
					<option value="등록일-오름차순">등록일-오름차순</option> 
					<option value="등록일-내림차순">등록일-내림차순</option>
				</select></li>
			</ul>
			<table width="900" cellpadding="7" cellspacing="0" id="brd">
			<tr>
			<th width="8%">번호</th><th width="15%">카데고리</th><th width="15%">상품ID</th><th width="15%">재고수량</th>
			<th width="8%">후기수</th><th width="*">등록일</th><th width="10%">게시여부</th><th width="12%">history</th>
			</tr>
			<%
			for (int i = 10 ; i > 0 ; i--) {
				out.println("<tr align=\"center\" onmouseover=\"this.style.background='#efefef';\" onmouseout=\"this.style.background='';\">");
				out.println("<td>1</td><td>가위</td><td>A001</td><td>200</td><td>500</td><td>2021-11-10</td><td>Y</td><td><input type='button' id='btn' value='보기' /></td></tr>");
			}
			%>
			</table><br />
			<p><a href='#'>&lt;&lt;</a>&nbsp;&nbsp;<a href='#'>&lt;</a>&nbsp;&nbsp;<a href='#'>1&nbsp;&nbsp;</a><a href='#'>&gt;</a>&nbsp;&nbsp;<a href='#'>&gt;&gt;</p>
	    </section>
		<!-- section 영역 종료 -->
	</article>
</main>
<!-- main 영역 종료 -->
</body>
</html>