<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypage.css">

<body>

<div id="mypage">
		<br><br><br>
		<h3>아이디　： </h3>
		<div class="mypage_info" id="member_id">honggold</div>
		<br>
		<h3>닉네임　： </h3>
		<div class="mypage_info" id="member_name">관리자</div>
		<br>
		<h3>이메일　： </h3>
		<div class="mypage_info" id="member_email">example@email.com</div>
		<br>
		<h3>휴대전화： </h3>
		<div class="mypage_info" id="member_tel">010-1234-5678</div>
		<br>
		<h3>성별　　： </h3>
		<div class="mypage_info" id="member_gender">남</div>
		<br>
		<h3>생년월일： </h3>
		<div class="mypage_info" id="member_birth">2000-01-01</div>
		<br>
		<h3>주소　　： </h3>
		<div class="mypage_info" id="member_addr1">전라북도 전주시 덕진구</div>
		<br>
		<h3>　　　　　 </h3>
		<div class="mypage_info" id="member_addr2">백제대로 57</div>
		<br>
		<h3>포인트　： </h3>
		<div class="mypage_info" id="member_point">99,999 P</div>
		<a href="${pageContext.request.contextPath}/point_check.do" id="point_check">내역 확인</a>
		<br>
	<button id="modify" onclick="location.href = '${pageContext.request.contextPath}/modify.do';">회원정보 수정</button>
	<button id="point_give" onclick="location.href = '${pageContext.request.contextPath}/point_pass.do'; ">포인트 전달</button>
	<button id="admin_menu" onclick="location.href = '${pageContext.request.contextPath}/admin_index.do'; ">관리자 메뉴</button>
	<button id="dropout" onclick="confirm('정말로 탈퇴하시겠습니까?');">회원 탈퇴</button>
	<button id="return" onclick="history.back()">돌아가기</button>
</div>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->