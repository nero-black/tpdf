<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/point_pass.css">

<body>

<div id="point_pass">
	<form action="${pageContext.request.contextPath}/point_pass_process.do" method="post" id="point_pass_form">
		<br><br><br>
		<h3>닉네임　 　： </h3>
		<div class="mypage_info">관리자</div>
		<h3>포인트　 　： </h3>
		<div class="mypage_info" id="member_point">99,999 P</div>
		<h3>대상 닉네임： </h3>
		<input type="email" class="mypage_info" name="member_passname" placeholder="포인트를 전달할 대상의 닉네임" required />
		<h3>전달 포인트： </h3>
		<input type="email" class="mypage_info" name="member_passpoint" placeholder="전달할 포인트의 양" required />
	</form>
	<button id="submit" onclick="document.getElementById('point_pass_form').submit();">포인트 전달</button>
	<button id="return" onclick="history.back()">돌아가기</button>
</div>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->