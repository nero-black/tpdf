<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tpdf.shoot.vo.MemberVo" %>  
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL라이브러리 -->

<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypage_check.css">
<script src="${pageContext.request.contextPath}/resources/js/mypage_check.js"></script>

<body>
<main>

<div id="mypage">
	<form action="${pageContext.request.contextPath}/mypage_check_process.do" method="post" id="mypage_form">
		<input type="hidden" id="member_idx" name="member_idx" value="${member_idx}" required />
		<input type="password" id="member_pw" name="member_pw" placeholder="비밀번호" required />
		<br>
		<h3>보안을 위해 비밀번호를 다시 한 번 입력해주세요.</h3>
	</form>
	<button id="submit" onclick="mypage_submit()">확인</button>
	<button id="return" onclick="history.back()">돌아가기</button>
	<br>
</div>
</main>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->