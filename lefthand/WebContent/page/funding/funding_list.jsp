<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<style>

.funding_contents {
	width:1200px; height:1500px;  margin: 0 auto;
	background-color:#bbbbbb;
	
}

.funding { margin:20px; border:1px black solid; float:left; font-size:1.1em; }

.funding_search {
	text-align:right; padding-right:150px;
}

.funding_sort {
	text-align:right; padding-right:50px;
}

</style>



<div class="funding_contents">
<h2>펀딩 리스트 레이아웃 예제</h2>
<div class="funding_search">
<ul id="cmb_funding_search">
		<li><select>
			<option value="전체">전체</option>
			<option value="진행중">진행중</option> 
			<option value="종료">종료</option>
		</select></li>
	</ul>
</div>
<div class="funding_sort">
<ul id="cmb_funding_sort">
		<li><select> <!-- 스토리 보드 수정 필요 : 최신순, 인기순, 마감임박 순  -->
			<option value="최신순">최신순</option>
			<option value="인기순">인기순</option> 
			<option value="마감임박순">마감임박순</option>
		</select></li>
	</ul>
</div>

<div class="funding">
	<a href="#"><img src="../funding/img/fd103_info_1.jpg" style="width:350px; height:310px; padding-bottom:15px;" /></a>
	<div style="text-align:center;"><a href="#">펀딩 이름</a></div>
	<table width="100%">
		<tr><td style="text-align:left">614 %</td><td style="text-align:center">3,072,000원</td><td style="text-align:right">10일남음</td></tr>
	</table>
</div>

<div class="funding">
	<a href="#"><img src="../funding/img/fd103_info_2.jpg" style="width:350px; height:310px; padding-bottom:15px;" /></a>
	<div style="text-align:center;"><a href="#">펀딩 이름</a></div>
	<table width="100%">
		<tr><td style="text-align:left">614 %</td><td style="text-align:center">3,072,000원</td><td style="text-align:right">10일남음</td></tr>
	</table>
</div>

<div class="funding">
	<a href="#"><img src="../funding/img/fd103_info_2.jpg" style="width:350px; height:310px; padding-bottom:15px;" /></a>
	<div style="text-align:center;"><a href="#">펀딩 이름</a></div>
	<table width="100%">
		<tr><td style="text-align:left">614 %</td><td style="text-align:center">3,072,000원</td><td style="text-align:right">10일남음</td></tr>
	</table>
</div>

<div class="funding">
	<a href="#"><img src="../funding/img/fd103_info_3.jpg" style="width:350px; height:310px; padding-bottom:15px;" /></a>
	<div style="text-align:center;"><a href="#">펀딩 이름</a></div>
	<table width="100%">
		<tr><td style="text-align:left">614 %</td><td style="text-align:center">3,072,000원</td><td style="text-align:right">10일남음</td></tr>
	</table>
</div>

</div>
