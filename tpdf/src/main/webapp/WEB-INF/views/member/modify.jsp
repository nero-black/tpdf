<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modify.css">

<body>

<div id="modify">
	<form action="${pageContext.request.contextPath}/modify_process.do" method="post" id="modify_form">
		<br><br><br>
		<h3>아이디　： </h3>
		<div class="mypage_info">honggold</div>
		<h3>비밀번호： </h3>
		<input type="password" class="mypage_info_pw" name="member_pw" placeholder="현재 또는 변경할 비밀번호" required />
		<a class="pwc">비밀번호 불일치</a>
		<br>
		<h3>　　　　　 </h3>
		<input type="password" class="mypage_info_pw" name="member_pwc" placeholder="비밀번호 확인" required />
		<a class="pwc">비밀번호 불일치</a>
		<h3>닉네임　： </h3>
		<div class="mypage_info">관리자</div>
		<h3>이메일　： </h3>
		<input type="email" class="mypage_info" name="member_email" placeholder="이메일 (example@email.com)" value="example@email.com" required />
		<h3>휴대전화： </h3>
		<input type="tel" class="mypage_info" name="member_tel" placeholder="휴대폰 번호 (하이폰 '-' 포함)" value="010-1234-5678"  required />
		<h3>성별　　： </h3>
		<div class="mypage_info">남</div>
		<h3>생년월일： </h3>
		<div class="mypage_info">2000-01-01</div>
		<h3>주소　　： </h3>
		<input type="text" class="mypage_info" name="member_addr1" placeholder="주소: 우편 번호로 찾기 (클릭)" value="전라북도 전주시 덕진구" required />
		<h3>　　　　　 </h3>
		<input type="text" class="mypage_info" name="member_addr2" placeholder="상세 주소" value="백제대로 57" /> <!-- addr1+addr2 로 처리 필요 -->
		<br>
	</form>
	<button id="submit" onclick="document.getElementById('modify_form').submit();">정보 수정</button>
	<button id="return" onclick="history.back()">돌아가기</button>
</div>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->