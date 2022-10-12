<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% MemberVo member_info = (MemberVo)request.getAttribute("member_info"); %>

<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modify.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/modify.js"></script>

<body>

<div id="modify">
	<form action="${pageContext.request.contextPath}/modify_process.do" method="post" id="modify_form">
		<br><br><br>
		<h3>아이디　： </h3>
		<input type="hidden" id="member_idx" name="member_idx" value="<%= member_info.getMember_idx() %>" required />
		<div class="mypage_info"><%= member_info.getMember_id() %></div>
		<h3>비밀번호： </h3>
		<input type="password" class="mypage_info_pw" id="member_pw" name="member_pw" placeholder="현재 또는 변경할 비밀번호"required />
		<a id="pwc1">비밀번호 불일치</a>
		<br>
		<h3>　　　　　 </h3>
		<input type="password" class="mypage_info_pw" id="member_pwc" name="member_pwc" placeholder="비밀번호 확인" maxlength="30" required />
		<a id="pwc2">비밀번호 불일치</a>
		<input type="text" id="member_quest" id="member_quest" name="member_quest" placeholder="비밀번호 찾기 질문 (최대 40글자)" value="<%= member_info.getMember_quest() %>" maxlength="30" required />
		<br>
		<input type="text" id="member_answer" id="member_quest" name="member_answer" placeholder="비밀번호 찾기 답변 (최대 10글자)" value="<%= member_info.getMember_answer() %>" maxlength="10" required />
		<br>
		<h3>닉네임　： </h3>
		<div class="mypage_info"><%= member_info.getMember_name() %></div>
		<h3>이메일　： </h3>
		<input type="email" class="mypage_info" id="member_email" name="member_email" placeholder="이메일 (example@email.com)" value="<%= member_info.getMember_email() %>" required />
		<h3>휴대전화： </h3>
		<input type="tel" class="mypage_info" id="member_tel" name="member_tel" placeholder="휴대폰 번호 (하이폰 '-' 제외)" value="<%= member_info.getMember_tel() %>"  required />
		<h3>성별　　： </h3>
		<div class="mypage_info"><%= member_info.getMember_gender() %></div>
		<h3>생년월일： </h3>
		<div class="mypage_info"><%= member_info.getMember_birth() %></div>
		<h3>주소　　： </h3>
		<input type="text" class="mypage_info" id="member_addr" name="member_addr" placeholder="주소" value="<%= member_info.getMember_addr() %>" required />
	</form>
	<button id="submit" onclick="modify();">수정하기</button>
	<button id="return" onclick="history.back()">돌아가기</button>
</div>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->