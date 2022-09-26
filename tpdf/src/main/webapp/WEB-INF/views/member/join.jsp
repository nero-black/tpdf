<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/join.css">

<body>

<div id="join">
	<form action="${pageContext.request.contextPath}/join_process.do" method="post" id="join_form">
		<input type="text" id="member_id" name="member_id" placeholder="아이디" required />
		<a href="${pageContext.request.contextPath}/id_check.do" id="id_check">중복 확인</a>
		<br>
		<input type="password" id="member_pw" name="member_pw" placeholder="비밀번호" required />
		<a id="pwc1">비밀번호 불일치</a>
		<br>
		<input type="password" id="member_pwc" name="member_pwc" placeholder="비밀번호 확인" required />
		<a id="pwc2">비밀번호 불일치</a>
		<br>
		<input type="text" id="member_name" name="member_name" placeholder="닉네임" required />
		<a href="${pageContext.request.contextPath}/name_check.do" id="name_check">중복 확인</a>
		<br>
		<input type="email" id="member_email" name="member_email" placeholder="이메일 (example@email.com)" required />
		<br>
		<input type="tel" id="member_tel" name="member_tel" placeholder="휴대폰 번호 (하이폰 '-' 포함)" required />
		<br>
		<div id="member_gender">
		성별: &nbsp; &nbsp;
		<label id="member_gender_m"><input type="radio" class="member_gender" name="member_gender" value="m" checked /> 남자</label> &nbsp; &nbsp; &nbsp; &nbsp;
		<label id="member_gender_f"><input type="radio" class="member_gender" name="member_gender" value="f" /> 여자</label> &nbsp; &nbsp; &nbsp; 
		</div>
		<br>
		<div id="birth">생년월일: </div><input type="date" id="member_birth" name="member_birth" placeholder="생년월일" required/>
		<br>
		<input type="text" id="member_addr1" name="member_addr1" placeholder="주소: 우편 번호로 찾기 (클릭)" required />
		<input type="text" id="member_addr2" name="member_addr2" placeholder="상세 주소" /> <!-- addr1+addr2 로 처리 필요 -->
		<br>
	</form>
	<button id="submit" onclick="document.getElementById('join_form').submit();">회원가입</button>
	<button id="return" onclick="history.back()">돌아가기</button>
</div>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->