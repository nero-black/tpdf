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
<script src="http://code.jquery.com/jquery-latest.min.js"></script> <!-- jquery 필수 -->
<script src="${pageContext.request.contextPath}/resources/js/find_idpw.js"></script>

<body>
	<div id="find">
	<div id="find_id">
	<h3>아이디 찾기</h3>
		<form id="find_id_form">
			<input type="text" id="member_name" name="member_name" placeholder="닉네임" required />
			<input type="text" id="member_email" name="member_email" placeholder="이메일 (example@email.com)" required />
			<input type="text" id="member_tel" name="member_tel" placeholder="휴대폰 번호 (하이폰 '-' 제외)" required />
			<br>
		</form>
		<button href="${pageContext.request.contextPath}/find_id.do" id="find_id_button" onclick="find_id(); return false;">아이디 찾기</button>
		<button id="return" onclick=location.href="${pageContext.request.contextPath}/join.do">회원가입</button>
	</div>
	<div id="find_pw">
	<h3>비밀번호 찾기</h3>
		<form id="find_pw_form">
			<input type="text" id="member_id" name="member_id" placeholder="아이디"  maxlength="20" required />
			<br>
		</form>
		<button href="${pageContext.request.contextPath}/find_pw.do" id="find_pw_button1" onclick="find_pw(); return false;">비밀번호 찾기</button>
		<button id="return" onclick="history.back()">돌아가기</button>
		
	</div>
	</div>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->