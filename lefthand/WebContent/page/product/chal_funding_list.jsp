<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<style>

.chal_funding_contents {
	width:1200px; height:1500px;  margin: 0 auto;
	background-color:#bbbbbb;
	
}

.chal_funding { position:relative; margin:20px; border:1px black solid; float:left; font-size:1.1em; }

.chal_period { text-align:center; }

.chal_like { float:right; padding:5px; }

.chal_ok { 
	position:absolute;	
	top:50%; left:50%;
	transform:translate(-50%, -75%); 
	width:100px; height:50px; background-color:rgba(155, 183, 214, 0.8);  
	z-index: 1;
	text-align:center;
	font-size:1.5em;
	padding:50px;
}
</style>


<div class="chal_funding_contents">
<h2>도전 펀딩 리스트 레이아웃 예제</h2>
<div class="chal_funding">
	<a href="#"><img src="../challenge/img/chal_info_default.jpg" style="width:350px; height:310px; padding-bottom:15px;" /></a>
	<div style="text-align:center;"><a href="#">도전 펀딩 이름(이미지 null 일때)</a></div>
	<div class="chal_period"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>
	<div class="chal_like"> ♥ ( 0 ) </div>
</div>

<div class="chal_funding">
	<a href="#"><img src="../challenge/userimg/thum_chal_info_2.jpg" style="width:350px; height:310px; padding-bottom:15px;" /></a>
	<div style="text-align:center;"><a href="#">도전 펀딩 이름(1차)</a></div>
	<div class="chal_period"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>
	<div class="chal_like"> ♥ ( 30 ) </div>
</div>

<div class="chal_funding">
	<a href="#"><img src="../challenge/userimg/thum_chal_info_2.jpg" style="width:350px; height:310px; padding-bottom:15px;" /></a>
	<div style="text-align:center;"><a href="#">도전 펀딩 이름(2차)</a></div>
	<div class="chal_period"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>
	<div class="chal_like"> ♥ ( 50 ) </div>
</div>

<div class="chal_funding">
	<a href="#"><img src="../challenge/userimg/thum_chal_info_1.jpg" style="width:350px; height:310px; padding-bottom:15px;" /></a>
	<div class="chal_ok"> 확 정 </div>
	<div style="text-align:center;"><a href="#">도전 펀딩 이름(확정)</a></div>
	<div class="chal_period"> &nbsp; 2021.10.30 &nbsp; ~ &nbsp; 2021.11.05 &nbsp; </div>
	<div class="chal_like"> ♥ ( 200 ) </div>
</div>



</div>