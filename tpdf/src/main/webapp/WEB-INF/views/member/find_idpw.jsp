<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/find_idpw.css">

<body>

<div id="find_ippw">
	<form action="${pageContext.request.contextPath}/find_idpw_process.do" method="post" id="find_idpw_form">
		<input type="email" id="member_email" name="member_email" placeholder="이메일 (example@email.com)" required />
		<br>
		<input type="tel" id="member_tel" name="member_tel" placeholder="휴대폰 번호 (하이폰 '-' 포함)" required />
	</form>
	<button id="submit" onclick="document.getElementById('find_idpw_form').submit();">찾기</button>
	<button id="return" onclick="history.back()">돌아가기</button>
</div>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->