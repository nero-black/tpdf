<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">

<body>

<div id="login">
	<form action="${pageContext.request.contextPath}/login_process.do" method="post" id="login_form">
		<input type="text" id="member_id" name="member_id" placeholder="아이디" required />
		<br>
		<input type="password" id="member_pw" name="member_pw" placeholder="비밀번호" required />
	</form>
	<button id="submit" onclick="document.getElementById('login_form').submit();">로그인</button>
	<button id="return" onclick="history.back()">돌아가기</button>
	<br>
	<div id="sub_menu">
		<a href="${pageContext.request.contextPath}/join.do">회원가입 </a> | 
		<a href="${pageContext.request.contextPath}/find_ippw.do">아이디/비밀번호 찾기</a>
	</div>
</div>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->