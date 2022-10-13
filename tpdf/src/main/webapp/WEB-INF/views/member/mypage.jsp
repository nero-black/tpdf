<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% MemberVo member_info = (MemberVo)request.getAttribute("member_info"); %>

<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->

<c:if test="${member_grade == null}">
<% response.sendRedirect("need_login.do"); %>
</c:if> <!-- 비회원 접속 방지 -->

<c:if test="${member_grade == 2}">
<% response.sendRedirect("invalid.do"); %>
</c:if> <!-- 잘못된 접속 방지 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypage.css">
<script src="${pageContext.request.contextPath}/resources/js/mypage.js"></script>

<body>
<c:if test="${member_grade == 1}">
<div id="mypage">
		<br><br><br>
		<h3>아이디　： </h3>
		<div class="mypage_info" id="member_id"><%= member_info.getMember_id() %></div>
		<br>
		<h3>닉네임　： </h3>
		<div class="mypage_info" id="member_name"><%= member_info.getMember_name() %></div>
		<br>
		<h3>이메일　： </h3>
		<div class="mypage_info" id="member_email"><%= member_info.getMember_email() %></div>
		<br>
		<h3>휴대전화： </h3>
		<div class="mypage_info" id="member_tel"><%= member_info.getMember_tel() %></div>
		<br>
		<h3>성별　　： </h3>
		<div class="mypage_info" id="member_gender"><%= member_info.getMember_gender() %></div>
		<br>
		<h3>생년월일： </h3>
		<div class="mypage_info" id="member_birth"><%= member_info.getMember_birth() %></div>
		<br>
		<h3>주소　　： </h3>
		<div class="mypage_info" id="member_addr"><%= member_info.getMember_addr() %></div>
		<br><br>
		<h3>포인트　： </h3>
		<div class="mypage_info" id="member_point"><%= member_info.getMember_point() %> P</div>
		<!-- <a href="${pageContext.request.contextPath}/point_check.do" id="point_check">내역 확인</a> -->
		<br>
	<button id="modify" onclick="location.href = '${pageContext.request.contextPath}/modify.do';">회원정보 수정</button>
	<!-- <button id="point_give" onclick="location.href = '${pageContext.request.contextPath}/point_pass.do'; ">포인트 전달</button>  -->
	<button id="dropout" onclick="drop()">회원 탈퇴</button>
	<button id="return" onclick="history.back()">돌아가기</button>
</div>
</c:if>
</body>
</html>
<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->