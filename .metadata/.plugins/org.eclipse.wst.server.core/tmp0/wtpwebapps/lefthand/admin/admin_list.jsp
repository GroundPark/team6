<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
/* admin_list.jsp의 CSS 시작 */
#adminList_wrap {
	border:0px solid black;
	width:980px;
	padding:50px 0;
}
#adminList_search{
	border:0px solid black;
	width:100%;
	margin:0 auto;
}
#adminList_search select {
	height:33px;
}
#adminList_search input {
	height:30px;	
}
#adminList_sbm {
	width:50px; 
}
#adminList_tab {
	width:100%;
	margin:0 auto;
}
#adminList_tab table {
	border:0px solid black;
	width:900px;
	margin:20px auto;
}
/* admin_list.jsp의 CSS 종료 */
</style>
</head>
<body>
<%@ include file="../include/incAdmin.jsp" %>
<main>
	<section id="adminList_wrap">
		<div id="adminList_search">
			<form name="frm" action="#" method="get">
			<select name="adminList_search_kind">
				<option vlaue="">전체</option>
				<option vlaue="ID">ID</option>
				<option vlaue="이름">이름</option>
				<option vlaue="소속부서">소속부서</option>
			</select>
			<input type="text" />
			<input type="submit" value="검색" id="adminList_sbm" />
			</form>
		</div>
		<div id="adminList_tab">
			<table border="1">
				<tr><td>테이블 영역 / 리스트가 들어가야 함</td></tr>
			</table>
		</div>
	</section>
</main>
</body>
</html>